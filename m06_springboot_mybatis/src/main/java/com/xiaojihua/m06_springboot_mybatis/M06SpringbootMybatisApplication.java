package com.xiaojihua.m06_springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xiaojihua.m06_springboot_mybatis.mapper")
@SpringBootApplication
public class M06SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(M06SpringbootMybatisApplication.class, args);
    }

}
