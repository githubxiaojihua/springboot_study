package com.xiaojihua.m01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Helloworld {

    @RequestMapping("/hello")
    public String helloworld(){
        return "helloworld quickly create";
    }
}
