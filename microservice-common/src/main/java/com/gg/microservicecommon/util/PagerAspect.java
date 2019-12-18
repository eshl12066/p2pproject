package com.gg.microservicecommon.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class PagerAspect {

    @Around("execution( * com.gg.*.service.impl.*.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable{

        //准备容器
        Query query = null;
        //获取所有参数
        Object[] args1 = args.getArgs();
        for( Object i :args1){
            if(i instanceof Query){
                //在参数中找到query对象后把这个query放到容器中
                query = (Query) i;
                break;
            }
        }
        if(query!=null){
            //query不为空就开始分页
            PageHelper.startPage(query.getPage(),query.getRows());
        }

        //执行方法，args.getArgs是参数的意思
        Object proceed = args.proceed(args.getArgs());

        if(query!=null){
            //这个把所有的页数给拿出来，给query设置
            PageInfo pageInfo = new PageInfo((List) proceed);
            query.setTotal(pageInfo.getTotal());
        }


        return proceed;
    }





}
