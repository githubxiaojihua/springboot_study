package com.xiaojihua.m03.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义springmvc配置，修改springboot对于springmvc的自动配置
 * 教程中是通过集成WebMvcConfigurerAdapter，来进行自定义配置的
 * 但是本项目使用的新版springboot提示已经过时了，可以直接实现webMvcConfigurer就行
 * 因为其采用了java8的新特性：接口有默认的实现方法，因此无需借助WebMvcConfigurerAdapter
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * 配置viewControllers，这样就不用在Controller写方法了，
     * 直接配置全局的
     * 请求atguigu直接跳转到页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/atguigu").setViewName("success");
    }
}
