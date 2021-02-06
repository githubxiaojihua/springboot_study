package com.xiaojihua.springbootasync;

import com.xiaojihua.springbootasync.service.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootAsync {

    @Autowired
    AsyncTaskService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAsync.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        for(int i=0; i<10; i++){
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
        return null;
    }
}
