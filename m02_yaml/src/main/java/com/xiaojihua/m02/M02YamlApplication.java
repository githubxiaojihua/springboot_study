package com.xiaojihua.m02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:beans.xml"})
public class M02YamlApplication {

    public static void main(String[] args) {
        SpringApplication.run(M02YamlApplication.class, args);
    }

}
