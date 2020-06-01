package com.xiaojihua.m03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {


    //    @DeleteMapping
    //    @PutMapping
    //    @GetMapping
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String userName, @RequestParam("password")String password, Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(userName) && "123456".equals(password)){
            session.setAttribute("loginUser",userName);
            return "redirect:/main.html";
        }else{
            map.put("msg","登录失败！");
            return "login";
        }
    }
}
