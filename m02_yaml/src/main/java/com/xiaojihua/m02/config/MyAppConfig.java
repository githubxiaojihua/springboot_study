package com.xiaojihua.m02.config;

import com.xiaojihua.m02.service.HellServiceByConfiguation;
import com.xiaojihua.m02.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot推荐使用的配置方式
 */
@Configuration
public class MyAppConfig {

    //将方法的返回值添加到容器中；
    // 容器中这个组件默认的id就是方法名
    @Bean
    public HellServiceByConfiguation getHelloService(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new HellServiceByConfiguation();
    }
}
