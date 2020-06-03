package com.xiaojihua.m03.controller;


import com.xiaojihua.m03.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloWorldController {

    /**
     * 加上RequestParam就必须传递user属性
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user){
        if("aaa".equals(user)){
            throw new UserNotExistException();
        }
        return "helloworld";
    }

    @RequestMapping("/success")
    public String success(ModelMap map){
        //设置model的值
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

}
