package com.wang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 王航
 * @Email: 954544828@qq.com
 * @Date: 2021/10/5 0005
 */

//扩展springMVC  dispatcherServlet
@Configuration
public class myMvcConfig implements WebMvcConfigurer
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }

    //注册到spring容器中
    @Bean
    public LocaleResolver localeResolver()
    {
        return new myLocaleResolver();
    }
}
