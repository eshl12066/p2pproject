package com.gg.microservicesysproviderhystrix.aspect;

import com.gg.microservicecommon.entity.sys.CommonConstant;
import com.gg.microservicecommon.entity.sys.JwtUtils;
import com.gg.microservicecommon.entity.sys.SysLoginLog;
import com.gg.microservicecommon.util.R;
import com.gg.microservicecommon.util.StringUtil;
import com.gg.microservicesysproviderhystrix.annotation.Log;
import com.gg.microservicesysproviderhystrix.service.SysLoginLogService;
import com.gg.microservicesysproviderhystrix.util.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 1100:非法操作，就是没有jwt值，
     * 1101:验证失败：可能验证时间，
     * 1102:没有该权限：没有权限的操作，不记录
     */

    @Resource
    SysLoginLogService sysLoginLogService;
    /**
     *redis模板
     * required=false 是开启懒加载
     */
    @Autowired(required = false)
    private RedisTemplate redisTemplate;

    //运行方法时间
    private long time;
    //整个的方法
    private ProceedingJoinPoint Jpoint;
    //jwt令牌
    private String jwt;
    //根据jwt从redis获取的值
    private Map sysUser;
    //request
    private HttpServletRequest req;
    //response
    private HttpServletResponse resp;
    //要增加的信息主体
    private SysLoginLog sysLoginLog =new SysLoginLog();
    //注解的信息
    private Log syslog;


    @Pointcut("@annotation(com.gg.microservicesysproviderhystrix.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //注入方法
        Jpoint = point;
        //注入设置其他信息
        settal();
        Object result = null;
        //判断是否直接执行这个方法
        if(!"-1".equals(syslog.role())){//登录
            if(StringUtil.isNotEmptyT(jwt)){
                if(StringUtil.isNotEmptyT(sysUser+"")){

                    if(JwtUtils.validateJwtToken(jwt)==null){//判断这个令牌是否有用
                        //延长令牌时间
                        String newJwt = JwtUtils.copyJwt(jwt, CommonConstant.JWT_WEB_TTL * 30);
                        resp.setHeader("jwt",newJwt);

                        //把以前的删掉
                        redisTemplate.expire(CommonConstant.USER_PREFIX + jwt, 1, TimeUnit.SECONDS);
                        redisTemplate.expire(CommonConstant.HEADER_PREFIX + jwt, 1, TimeUnit.SECONDS);
                        //管理员的实体放到redis里并设置时间为60分钟
                        redisTemplate.opsForHash().putAll(CommonConstant.USER_PREFIX+newJwt,sysUser);
                        redisTemplate.expire(CommonConstant.USER_PREFIX+newJwt,CommonConstant.REDIS_TIMEOUT,TimeUnit.SECONDS);
                        //jwt验证放入redis里面并设置时间为60分钟
                        redisTemplate.opsForValue().set(CommonConstant.HEADER_PREFIX+newJwt,newJwt);
                        redisTemplate.expire(CommonConstant.HEADER_PREFIX+newJwt,CommonConstant.REDIS_TIMEOUT,TimeUnit.SECONDS);
                    }

                    if(BRole()){//判断是否有权限，调用了BRole()方法
                        long beginTime = System.currentTimeMillis();
                        // 执行方法
                        result = point.proceed();
                        // 执行时长(毫秒)
                        time = System.currentTimeMillis() - beginTime;
                    }
                    else{
                        result = R.error(1102,"对不起，你没有该权限");
                    }

                }
                else{
                    result = R.error(1101,"对不起，jwt验证失败,请重新登陆");
                }
            }
            else{
                result = R.error(1100,"对不起，请登录再进行操作");
                //保存异常信息
                unSaveLog();
            }
        }
        else {//登陆就直接执行方法
            long beginTime = System.currentTimeMillis();
            // 执行方法
            result = point.proceed();
            // 执行时长(毫秒)
            time = System.currentTimeMillis() - beginTime;
        }

        return result;
    }

    /**
     * 最后的返回的执行代码
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "logPointCut()")// returning的值和doAfterReturning的参数名一致
    public void doAfterReturning(Object ret) throws Throwable {
        //异步保存日志，成功运行方法后才会执行这个方法体
        saveLog(ret);

    }

    /**
     * 判断是否有这个权限
     * @return
     */
    boolean BRole(){
        String s = sysUser.get("roleid")+"";
        String s1= syslog.role();
        String[] split = s.split(";");
        String[] split1 = s1.split(";");
        boolean f = false;
        for (String p : split ){
            for (String p1 : split1){
                if(p.equals(p1)){
                    f=true;
                }
            }
        }
        return f;
    };

    /**
     *注入jwt,redisjwt
     * 注解
     */
    void  settal(){
        //获取从前台传过来的jwt
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        req = attributes.getRequest();
        resp = attributes.getResponse();
        //获取前台传过来的jwt
        jwt = req.getHeader("jwt");
        //根据前台传过来的jwt搜索redis
        sysUser = redisTemplate.opsForHash().entries(CommonConstant.USER_PREFIX + jwt);

        //1、从ProceedingJoinPoint中获取到一个signature
        MethodSignature signature = (MethodSignature) Jpoint.getSignature();
        //2、获取到了它的一个方法体
        Method method = signature.getMethod();
        //3、获取我们注解里面的值
        syslog = method.getAnnotation(Log.class);

    }

    /**
     * 额，在最后返回结果中获取信息
     * @param ret
     * @throws InterruptedException
     */
    void saveLog(Object ret) throws InterruptedException {

            if(!"-1".equals(syslog.role())){//除了登陆消息之外的记录
                if(BRole()){//如果有这个权限操作就直接记录，没有就不记录
                    //用户id
                    sysLoginLog.setUserId(Integer.parseInt(sysUser.get("userid")+""));
                    //用户名字
                    sysLoginLog.setUserName(sysUser.get("username")+"");
                    //用户角色名字
                    sysLoginLog.setUserRole(sysUser.get("rolename")+"");
                    //日志描述
                    sysLoginLog.setContent(syslog.content());
                    //日志类型
                    sysLoginLog.setType(syslog.type());
                    //表格名称
                    sysLoginLog.setTablename(syslog.tableName());
                    //参数集合
                    sysLoginLog.setRemarks(Jpoint.getArgs()[0].toString());
                    //请求地址
                    sysLoginLog.setRequestUrl(req.getRequestURL()+"");
                    //操作时间
                    sysLoginLog.setLogTime(new Date());
                    //真实ip
                    sysLoginLog.setIp(req.getRemoteAddr());
                    System.err.println("真实ip为："+ IpUtils.getIpAddr(req));
                    System.err.println("地址A为："+ req.getLocalAddr());
                    System.err.println("地址B为："+ req.getRemoteAddr());
                    R r = (R)ret;
                    //返回值
                    sysLoginLog.setResultValue(r+"");
                    Object code = r.get("code");
                    Object msg = r.get("msg");
                    //操作结果
                    sysLoginLog.setResult(Integer.parseInt(code+""));
                    //操作信息
                    sysLoginLog.setExString(msg+",此方法操作的时长为："+time);

                    int insert = sysLoginLogService.insert(sysLoginLog);
                    if(insert>0){
                        System.err.println("记录成功");
                    }
                    else{
                        System.err.println("记录失败");
                    }
                }
            }
            else{//登陆的消息记录
                R r = (R)ret;
                Object code = r.get("code");
                Object msg = r.get("msg");
                Map data = (Map) r.get("data");
                //用户id
                sysLoginLog.setUserId(Integer.parseInt(data.get("userid")+""));
                //用户名字
                sysLoginLog.setUserName(data.get("username")+"");
                //用户角色名字
                sysLoginLog.setUserRole(data.get("rolename")+"");
                //日志描述
                sysLoginLog.setContent(syslog.content());
                //日志类型
                sysLoginLog.setType(syslog.type());
                //表格名称
                sysLoginLog.setTablename(syslog.tableName());
                //参数集合
                sysLoginLog.setRemarks(Jpoint.getArgs()[0].toString());
                //请求地址
                sysLoginLog.setRequestUrl(req.getRequestURL()+"");
                //操作时间
                sysLoginLog.setLogTime(new Date());
                //真实ip
                sysLoginLog.setIp(req.getRemoteAddr());
                System.err.println("真实ip为："+ IpUtils.getIpAddr(req));
                System.err.println("地址A为："+ req.getLocalAddr());
                System.err.println("地址B为："+ req.getRemoteAddr());

                //返回值
                sysLoginLog.setResultValue("登录成功");

                //操作结果
                sysLoginLog.setResult(-1);
                //操作信息
                sysLoginLog.setExString(msg+",此方法操作的时长为："+time);

                int insert = sysLoginLogService.insert(sysLoginLog);
                if(insert>0){
                    System.err.println("记录成功");
                }
                else{
                    System.err.println("记录失败");
                }

            }



    }

    void unSaveLog(){//非法登陆
        //日志描述
        sysLoginLog.setContent(syslog.content());
        //日志类型
        sysLoginLog.setType(syslog.type());
        //表格名称
        sysLoginLog.setTablename(syslog.tableName());
        //参数集合
        sysLoginLog.setRemarks(Jpoint.getArgs()[0].toString());
        //请求地址
        sysLoginLog.setRequestUrl(req.getRequestURL()+"");
        //操作时间
        sysLoginLog.setLogTime(new Date());
        //真实ip
        sysLoginLog.setIp(req.getRemoteAddr());
        System.err.println("真实ip为："+ IpUtils.getIpAddr(req));
        System.err.println("地址A为："+ req.getLocalAddr());
        System.err.println("地址B为："+ req.getRemoteAddr());

        //返回值
        sysLoginLog.setResultValue("非法操作");
        //操作结果
        sysLoginLog.setResult(1100);
        //操作信息
        sysLoginLog.setExString("没有登录操作");

        int insert = sysLoginLogService.insert(sysLoginLog);
        if(insert>0){
            System.err.println("记录成功");
        }
        else{
            System.err.println("记录失败");
        }
    }
}