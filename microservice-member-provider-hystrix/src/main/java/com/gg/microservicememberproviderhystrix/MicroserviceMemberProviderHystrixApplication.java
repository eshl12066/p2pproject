package com.gg.microservicememberproviderhystrix;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//扫描所有目录下的文件
@ComponentScan(basePackages = {"com.gg.microservicecommon","com.gg.microservicememberproviderhystrix"})
//找到一个数据访问层的mapper文件
@MapperScan("com.gg.microservicememberproviderhystrix.dao")
//开启熔断降级
@EnableCircuitBreaker
//开启management管理模块
@EnableTransactionManagement
//开启切面自动代理
@EnableAspectJAutoProxy
//开启erueka客户端
@EntityScan("com.gg.*.*")
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceMemberProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceMemberProviderHystrixApplication.class, args);
    }

}
