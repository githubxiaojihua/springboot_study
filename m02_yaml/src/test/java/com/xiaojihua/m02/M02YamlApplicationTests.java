package com.xiaojihua.m02;

import com.xiaojihua.m02.pojo.Person;
import com.xiaojihua.m02.pojo.PersonForPropertiesSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class M02YamlApplicationTests {

    @Autowired
    Person person;

    @Autowired
    PersonForPropertiesSource pfp;

    // 注入ApplicationContext
    @Autowired
    ApplicationContext ctx;

    @Test
    void contextLoads() {
        // 测试使用@ConfigurationProperties注解，绑定application.properties文件到bean属性上
        // @ConfigurationProperties注解可应用与properties以及yml
        // 测试配置文件中的占位符和表达式
        System.out.println(person);
        // 测试使用@PropertySource注解通过指定配置文件，只能应用与properties
        // 配合@ConfigurationProperties来绑定类属性
        System.out.println(pfp);

        // 测试@ImportResource引入外部XML配置文件
        // 如果注销掉M02YamlApplication.java类上的@ImportResource注解则输出为false
        // 因为虽然配置了一个beans.xml但是并没有加载到容器中。
        boolean helloService = ctx.containsBean("helloService");
        System.out.println(helloService);

        // 测试使用springboot推荐的配置类的方式加载类
        // 注意方法名就是默认的bean名称
        boolean hellServiceByConfiguation = ctx.containsBean("getHelloService");
        System.out.println(hellServiceByConfiguation);
    }

}
