package com.gg.microservicezuul3001.config;

import com.gg.microservicezuul3001.filter.MyCorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {


    @Bean
    public MyCorsFilter myCorsFilter(){
        return new MyCorsFilter();
    }

}