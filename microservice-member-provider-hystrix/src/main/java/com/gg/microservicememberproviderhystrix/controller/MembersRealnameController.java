package com.gg.microservicememberproviderhystrix.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import com.gg.microservicecommon.entity.member.MembersRealname;
import com.gg.microservicecommon.util.PageBaen;
import com.gg.microservicecommon.util.PageUtils;
import com.gg.microservicecommon.util.R;
import com.gg.microservicememberproviderhystrix.service.MembersRealnameService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (MembersRealname)表控制层
 *
 * @author makejava
 * @since 2019-12-12 20:54:39
 */
@RestController
@RequestMapping("membersRealname")
public class MembersRealnameController {
    /**
     * 服务对象
     */
    @Resource
    private MembersRealnameService membersRealnameService;

    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public MembersRealname selectOne(Integer id) {
        return this.membersRealnameService.queryById(id);
    }

    /**
     * 查询所有&&，加上模糊查
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersRealnameQuery")
    @ApiOperation(value = "查询所有",notes = "查询到的数据是分页的，并且也可以传入参数进行查询")
    public PageUtils membersRealnameQuery(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {

        return null;
    }
    /**
     *  增加&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersRealnameAdd")
    @ApiOperation(value = "增加单个",notes = "增加&&")
    public R membersRealnameAdd(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        PageBaen pageBaen = new PageBaen(params);
        return this.membersRealnameService.insert(pageBaen) > 0 ? R.ok("增加成功") : R.error(-1,"增加失败");
    }
    /**
     * 删除&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersRealnameDel")
    @ApiOperation(value = "删除单个",notes = "删除&&")
    public R membersRealnameDel(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
    /**
     * 修改&&
     * @param params 前台传过来的参数集
     * @param req 全局的request请求
     * @param resp 全局的respons相应
     * @return
     */
    @RequestMapping("membersRealnameUpdate")
    @ApiOperation(value = "修改单个",notes = "跟据传过来的id进行一个信息修改")
    public R membersRealnameUpdate(@RequestParam Map<String,Object> params, HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    @RequestMapping("getRLOne")
    @ApiOperation(value = "单个查",notes = "单个查询")
    public  Map<String,Object> getCLONE(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Map<String, Object> map = this.membersRealnameService.queryByRLId(Integer.valueOf(id));
        return  map;
    }



    @RequestMapping("updateRState")
    @ApiOperation(value = "修改状态",notes = "修改状态,并加上审核人的备注与材料证明的合理得分")
    public R updateCState(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        PageBaen pageBaen = new PageBaen(params);
        return this.membersRealnameService.updateState(pageBaen) >0 ? R.ok("修改成功") : R.error(-1,"修改失败");
    }

    /**
     * 查看所有
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("getRAll")
    @ApiOperation(value = "模糊查",notes = "默认查所有，输入参数即可查询")
    public PageUtils  getRAll(@RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        String start=null;
        String stop = null;
        if(!StringUtils.isEmpty(request.getParameter("start"))){
            String[] split = request.getParameter("start").split("T");
            start = split[0];
            String[] split1 = request.getParameter("stop").split("T");
            stop  = split1[0];
        }
        PageBaen pageBaen = new PageBaen(params);
        if(!StringUtils.isEmpty(start)){
            pageBaen.put("start",start);
            pageBaen.put("stop",stop);
        }
        List<Map<String,Object>> list = this.membersRealnameService.getRAllPager(pageBaen);
        for (Map<String,Object> map1 : list) {
            map1.put("apply_time",map1.get("apply_time").toString());
        }
        return new PageUtils(list,pageBaen.getTotal());
    }



    /**
     * 文件上传 用于身份证的图片上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/imgUpload")
    public R upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        try {
            //生成图片名称
            //获取原始文件名称(包含格式)
            String originalFileName = picture.getOriginalFilename();
            System.out.println("原始文件名称：" + originalFileName);
            //获取文件类型，以最后一个`.`为标识
            String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
            System.out.println("文件类型：" + type);
            //获取文件名称（不包含格式）
            String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

            //设置文件新名称: 当前时间+文件名称（不包含格式）
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = sdf.format(d);
            String fileName = date + name + "." + type;
            System.out.println("新文件名称：" + fileName);
            //上传图片
            FileUtils.copyInputStreamToFile(picture.getInputStream(),new File("D://upload/"+fileName));
            //图片上传成功返回图片访问地址
            R r = R.ok("图片上传成功");
            r.put("path", "/upload/" + fileName );
            return r;
        } catch (IOException e) {
            return R.error("上传失败");
        }
    }


    @RequestMapping("queryRnull")
    @ApiOperation(value = "单个查",notes = "单个查询")
    public  MembersRealname queryRnull(@RequestParam Integer id){
        return this.membersRealnameService.queryRnull(id);
    }

}