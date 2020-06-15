package com.xiaojihua.m08_springboot_startup.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 实现ApplicationContextInitializer时候需要一个泛型，指定成ConfigurableApplicationContext
 * 就行，代表IOC容器
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("ApplicationContextInitializer...initialize..."+configurableApplicationContext);
    }
}
