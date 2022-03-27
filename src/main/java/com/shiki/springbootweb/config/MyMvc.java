package com.shiki.springbootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
public class MyMvc implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/").setViewName("index");
       registry.addViewController("/index.html").setViewName("index");
       registry.addViewController("/main.html").setViewName("dashboard");



    }

    //将自己写的国际化工具类注册到bean
    @Bean
    public LocaleResolver localeResolver(){
        return  new MyLocaleResolver();
    }

    //添加拦截器
    // /*只表示下面一层的      /** 表示下面所有的
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器 ，选择拦截的路由和不拦截的路由
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/login/user","/static/**");
    }



}
