package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootConfiguration
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@MapperScan(value = "com.mapper")  // mybatis 需要扫描mapper接口, 记得加上
public class ManagerSystem_SpringBoot_Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagerSystem_SpringBoot_Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ManagerSystem_SpringBoot_Application.class, args);
    }

}

