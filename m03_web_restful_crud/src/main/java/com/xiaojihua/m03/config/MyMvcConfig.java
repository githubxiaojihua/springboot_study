package com.xiaojihua.m03.config;

import com.xiaojihua.m03.compnent.LoginHandlerIntercepter;
import com.xiaojihua.m03.compnent.MyLocalResolver;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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

    /**
     * springboot会自动扫描容器中的WebMvcConfigurer类并进行注册，因此
     * 直接返回一个WebMvcConfigurer匿名内部类也是可以实现扩展springmvc配置
     * 的目的
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 教程中没有配置对静态资源的放行，但是这里需要
             * 应该是版本的问题
             * @param registry
             */
            /*@Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**");
            }*/

        };
    }

    /**
     * 配置自定义的localResolver
     * 注意方法名称必须是localResolver，即跟springboot mvc自动配置中的方法名称一致，
     * 这样才能达到覆盖掉原来自动配置的Resolver
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    /**
     * 通过编程的方式来配置嵌入式server
     * 注意所使用的泛型
     * @return
     */
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
            @Override
            public void customize(ConfigurableServletWebServerFactory factory) {
                factory.setPort(9000);
            }
        };
    }
}
