package com.xiaojihua.m07_springboot_jpa.controller;

import com.xiaojihua.m07_springboot_jpa.entity.User;
import com.xiaojihua.m07_springboot_jpa.reporsitory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userRepository.findById(id).orElse(new User());
    }

    /**
     * 插入
     * @param user
     * @return
     */
    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return user;
    }
}
