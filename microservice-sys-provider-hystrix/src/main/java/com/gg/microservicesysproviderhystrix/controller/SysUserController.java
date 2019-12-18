package com.gg.microservicesysproviderhystrix.controller;

import com.gg.microservicecommon.entity.sys.*;
import com.gg.microservicecommon.entity.sys.Query;
import com.gg.microservicecommon.util.*;
import com.gg.microservicesysproviderhystrix.annotation.Log;
import com.gg.microservicesysproviderhystrix.service.SysRoleService;
import com.gg.microservicesysproviderhystrix.service.SysUserService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2019-12-12 11:33:23
 */
@RestController
@RequestMapping("sysUser")
@Api(description = "后台请求")
public class SysUserController {

    /**
     * 服务对象
     */
    @Resource
    private SysRoleService sysRoleService;

    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    /**
     *
     * @param params 从前台传过来的所有参数
     * @param req   request请求
     * @param resp  response 响应
     * @return
     */
    @RequestMapping("login")
    @ApiOperation(value = "登录",notes = "正规途径登录访问")
    @Log(content = "后台主界面登录",type = "登录",tableName = "sys_user",role = "-1")
    public R login(@RequestParam Map<String,Object> params, HttpServletRequest req , HttpServletResponse resp ) {
        //一、要想判断登录，首先要判断验证码是否登陆成功
        //获取用户传过来的验证码
        String user_code = req.getParameter("userCode");

        //1,先获取发来的请求头里面的verificationJwt的值
        String vue_verificationJwt = req.getHeader(CommonConstant.JWT_VERIFICATION_KEY);
        //2,从redis里根据键获取值
        Object redis_code = redisTemplate.opsForValue().get(CommonConstant.VERIFICATION_PREFIX + vue_verificationJwt);
        if(StringUtil.isEmptyT((String) redis_code)){//判断redis是否还有该值
            return  R.error(1,"验证码失效");
        }
        if(!redis_code.toString().equalsIgnoreCase(user_code)){//判断输入的验证码和redis里面的验证码是否一样
            return R.error(1,"验证码输入错误");
        }

        //二、如果以上都没有进入，就代表可以开始验证用户是否登陆成功
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("uname:"+uname+"  pwd:"+pwd);
        Map<String,Object> sysUser = sysUserService.getUser(uname);
        System.out.println(sysUser.toString());

        //判断从前端输入的密码是否和数据库的盐是否相同
        if(MD5Util.verify(pwd,sysUser.get("salt")+"")){

            //进来了就代表密码没问题,为这个用户包装一下，加上角色名和描述
            List<SysRole> sysRoles = sysRoleService.getRoleByUserid(Integer.parseInt(sysUser.get("userid") + ""));
            StringBuilder builderRolename = new StringBuilder();
            StringBuilder builderRoleD = new StringBuilder();
            StringBuilder builderRoleid = new StringBuilder();
            for (SysRole s : sysRoles){
                builderRolename.append(";"+s.getRolename());
                builderRoleD.append(";"+s.getDescription());
                builderRoleid.append(";"+s.getRoleid());
            }
            //加上自己的一个rolename,角色名字
            sysUser.put("rolename",builderRolename.substring(1));
            sysUser.put("description",builderRoleD.substring(1));
            sysUser.put("roleid",builderRoleid.substring(1));

            //创建一个jwt
            String jwt = JwtUtils.createJwt(params, CommonConstant.JWT_WEB_TTL * 30);

            //管理员的实体放到redis里并设置时间为60分钟
            redisTemplate.opsForHash().putAll(CommonConstant.USER_PREFIX+jwt,sysUser);
            redisTemplate.expire(CommonConstant.USER_PREFIX+jwt,CommonConstant.REDIS_TIMEOUT,TimeUnit.SECONDS);
            //jwt验证放入redis里面并设置时间为60分钟
            redisTemplate.opsForValue().set(CommonConstant.HEADER_PREFIX+jwt,jwt);
            redisTemplate.expire(CommonConstant.HEADER_PREFIX+jwt,CommonConstant.REDIS_TIMEOUT,TimeUnit.SECONDS);
            //放入响应头里
            resp.setHeader(CommonConstant.JWT_HEADER_KEY,jwt);
            R r = new R();
            r.put("data",sysUser);
            return r;
        }
        else{
            return R.error(1,"登录失败,密码或账号错误");
        }

    }

    /**
     *
     * @param params 从前台传过来的所有参数
     * @param req   request请求
     * @param resp  response 响应
     * @return
     */
    @RequestMapping("memberLogin")
    @RequiresGuest
    @ApiOperation(value = "登录",notes = "正规途径登录访问")
    public R memberLogin(@RequestParam Map<String,Object> params,HttpServletRequest req ,HttpServletResponse resp ) {
        //一、要想判断登录，首先要判断验证码是否登陆成功
        //获取用户传过来的验证码
        String user_code = req.getParameter("userCode");

        //1,先获取发来的请求头里面的verificationJwt的值
        String vue_verificationJwt = req.getHeader(CommonConstant.JWT_VERIFICATION_KEY);
        //2,从redis里根据键获取值
        Object redis_code = redisTemplate.opsForValue().get(CommonConstant.VERIFICATION_PREFIX + vue_verificationJwt);
        if(StringUtil.isEmptyT((String) redis_code)){//判断redis是否还有该值
            return  R.error(1,"验证码失效");
        }
        if(!redis_code.toString().equalsIgnoreCase(user_code)){//判断输入的验证码和redis里面的验证码是否一样
            return R.error(1,"验证码输入错误");
        }

        //二、如果以上都没有进入，就代表可以开始验证用户是否登陆成功
        String name = req.getParameter("uname");
        String password = req.getParameter("pwd");
        Map<String, Object> user = this.sysUserService.membersLogin(name, password);
        if(user!=null){
            //创建一个jwt
            String jwt = JwtUtils.createJwt(params, CommonConstant.JWT_WEB_TTL * 60);
            //用户jwt放入redis里面并设置时间为60分钟
            redisTemplate.opsForValue().set(CommonConstant.HEADER_PREFIX+jwt,jwt);
            redisTemplate.expire(CommonConstant.HEADER_PREFIX+jwt,CommonConstant.REDIS_TIMEOUT,TimeUnit.SECONDS);
            //放入响应头里
            resp.setHeader(CommonConstant.JWT_HEADER_KEY,jwt);

            R r = new R();
            r.put("data",user);
            return r;
        }
        else{
            return  R.error(-1,"登陆失败");
        }

    }
    /**
     *  增加会员
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("addMembers")
    @ApiOperation(value = "增加会员",notes = "增加会员")
    public R addMembers(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysUser sysUser) {

        Map<String,Object> param = new HashMap<>();
        param.putAll(params);
        param.put("certification_score",30);
        param.put("is_identity_authentication",1);
        param.put("members_state",0);

        return this.sysUserService.addMembers(param) >0 ? R.ok("注册成功"): R.error(-1,"注册失败");

    }


    /**
     *  //1,先获取来自客户端传过来的表头verificationJwt
     *  //2,把随机产生的验证码存放到redis里面，存放方式为(verificationCode+jwt令牌)为键，(随机产生的验证码)为值。
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("verificationCode")
    @RequiresGuest
    @ApiOperation(value = "生成图片验证码", notes = "发送到客户端进行浏览，验证码格式是base64字符串的图片")
    public String verificationCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //随机生成验证码
        String code = VerifyCodeUtil.produceNumAndChar(4);


        //1,先获取来自客户端传过来的表头verificationJwt
        String vue_verificationJwt = req.getHeader(CommonConstant.JWT_VERIFICATION_KEY);
        //2,解密vue_verificationJwt，看有无
        if(vue_verificationJwt != null && !"null".equals(vue_verificationJwt) && !"".equals(vue_verificationJwt) ){//判断jwt是否为空,isEmpty()（为空则false,不为空为true）
            Claims claims = JwtUtils.validateJwtToken(vue_verificationJwt);
            if(claims==null){//如果过期
                //3,创建一个jwt令牌,重新发送给客户端（只有在之前的令牌失效了，才能新创建）
                vue_verificationJwt = JwtUtils.createJwt(new HashMap<String, Object>(), JwtUtils.JWT_WEB_TTL);
                //4,把创建好的jwt放入到响应头
                resp.setHeader(CommonConstant.JWT_VERIFICATION_KEY, vue_verificationJwt);
            }
        }
        else{//第一次请求，jwt为空
            //3,创建一个jwt令牌,发送给客户端
            vue_verificationJwt = JwtUtils.createJwt(new HashMap<String, Object>(), JwtUtils.JWT_WEB_TTL);
            //4,把创建好的jwt放入到响应头
            resp.setHeader(CommonConstant.JWT_VERIFICATION_KEY, vue_verificationJwt);
        }
        //删除之前存储在redis的验证码
        redisTemplate.delete(CommonConstant.VERIFICATION_PREFIX+vue_verificationJwt);
        //3,不换jwt令牌，每次请求都更新redis里面的验证码
        redisTemplate.opsForValue().set(CommonConstant.VERIFICATION_PREFIX+vue_verificationJwt,code,60,TimeUnit.SECONDS);

        //4,//生成图片
        String img = "data:image/png;base64," + ImageUtil.createImageWithVerifyCode(code, 230,60);
        return img;
    }

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    //    @RequiresPermissions(value = {"user:select"})
    @RequestMapping("selectOne")
    @ApiOperation(value = "查询单个",notes = "用来查询单个用户的信息")
    public SysUser selectOne(Integer userid) {
        return this.sysUserService.queryById(userid);
    }


    /**
     * 查询所有管理员，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("userQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils userQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        String state = req.getParameter("userstate");

        Query query = new Query(params);
        List<SysUser> sysUsers = this.sysUserService.queryPager(query);
        List<Map<String,Object>> list =new ArrayList<>();
        Map<String,Object> map ;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 E hh:mm:ss");

        for(SysUser s : sysUsers){
            map = new HashMap<>();
            map.put("userid",s.getUserid());
            map.put("username",s.getUsername());
            map.put("userrole",this.toUserRole(s.getUserid()));
            map.put("createdate",sdf.format(s.getCreatedate()));
            if(s.getUserstate()==0){
                map.put("userstate","可用");
            }
            else{
                map.put("userstate","不可用");
            }

            list.add(map);
        }
        long s = query.getTotal();
        return new PageUtils(list,query.getTotal());
    }
    public String toUserRole(Integer userid){
        List<SysRole> sysRoles = this.sysRoleService.userRoleSelect(userid + "");
        if(sysRoles!=null && sysRoles.size()>0){
            StringBuilder sb = new StringBuilder();
            for (SysRole s :sysRoles){
                sb.append(","+s.getRolename());
            }
            return sb.substring(1);
        }
        else{
            return "暂无角色";
        }

    }

    /**
     *  增加管理员
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("userAdd")
    @ApiOperation(value = "增加单个",notes = "增加管理员")
    public R userAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysUser sysUser) {
        if(this.sysUserService.sysLogin(sysUser.getUsername())!=null){
            return R.error(-2,"名字重复,请换个名字");
        }
        String password = req.getParameter("password");
        String salt = PasswordHelper.createSalt();
        String credentials = PasswordHelper.createCredentials(password, salt);

        sysUser.setPassword(credentials);
        sysUser.setSalt(salt);
        sysUser.setCreatedate(new Date());
        sysUser.setUserstate(0);
        return this.sysUserService.insert(sysUser) > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");
    }
    /**
     * 删除管理员
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("userDel")
    @ApiOperation(value = "删除单个",notes = "删除管理员")
    public R userDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysUser sysUser) {
        return this.sysUserService.deleteById(sysUser.getUserid()) ? R.ok("增加成功") : R.error(-1,"增加失败");
    }
    /**
     * 修改管理员
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("userUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据穿过来的id进行一个信息修改")
    public R userUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysUser sysUser) {


        String password = req.getParameter("password");
        if(password!=null){
            String salt = PasswordHelper.createSalt();
            String credentials = PasswordHelper.createCredentials(password, salt);

            sysUser.setPassword(credentials);
            sysUser.setSalt(salt);
        }


        return this.sysUserService.update(sysUser)>0 ? R.ok("修改成功") : R.error(-1,"修改失败");
    }

    /**
     *  增加管理员的角色
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("addUserRole")
    @ApiOperation(value = "为用户增加多个角色",notes = "增加角色")
    public R addUserRole(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysUser sysUser) {
        String userid = req.getParameter("userid");
        String userids = req.getParameter("userids");

        String[] split = userids.split(",");

        if(userids!=null){
            int r = this.sysRoleService.delUserRole(userid);
            for (String s : split){
                int i = this.sysRoleService.addUserRole(userid, s);
            }
            return R.ok("增加成功");
        }
        return R.error(-1,"增加失败");//manageLoginout

    }

    /**
     *  后台管理员退出
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("manageLoginout")
    @ApiOperation(value = "后台退出",notes = "整个redis资源清空")
    public R manageLoginout(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp,SysUser sysUser) {
        String vue_jwt = req.getHeader("jwt");
        //清空
        //用户的jwt
        redisTemplate.expire(CommonConstant.HEADER_PREFIX + vue_jwt, 1, TimeUnit.SECONDS);
        //把角色，权限
        redisTemplate.expire(CommonConstant.USERROLE_PREFIX + vue_jwt, 1, TimeUnit.SECONDS);
        redisTemplate.expire(CommonConstant.USERPERMISSION_PREFIX + vue_jwt, 1, TimeUnit.SECONDS);
        JwtUtils.copyJwt(StringUtils.trimAllWhitespace(vue_jwt + ""), (long)1000);

        return R.ok();

    }
    /**
     *  前台用户退出
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersLoginout")
    @ApiOperation(value = "前台退出",notes = "整个redis资源清空")
    public R membersLoginout(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp, SysUser sysUser) {
        String vue_jwt = req.getHeader("jwt");
        //清空
        //用户的jwt
        redisTemplate.expire(CommonConstant.HEADER_PREFIX + vue_jwt, 1, TimeUnit.SECONDS);
        JwtUtils.copyJwt(StringUtils.trimAllWhitespace(vue_jwt + ""), (long)1000);

        return R.ok();

    }

}