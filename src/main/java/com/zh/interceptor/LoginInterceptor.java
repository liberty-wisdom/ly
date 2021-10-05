package com.zh.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableCaching
public class LoginInterceptor implements WebMvcConfigurer  {
    @Autowired
    private UserLoginInterceptor userLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/static/**")
        .excludePathPatterns("/")
        .excludePathPatterns("/loginIn")
        .excludePathPatterns("/loginOut");
    }
}
