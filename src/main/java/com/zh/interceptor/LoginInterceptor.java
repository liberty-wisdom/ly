package com.zh.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
@EnableCaching
public class LoginInterceptor implements WebMvcConfigurer  {
    @Autowired
    private UserLoginInterceptor userLoginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        log.info("开始加载登录拦截器");
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/**")
        .excludePathPatterns("/static/**")
        .excludePathPatterns("/")
        .excludePathPatterns("/loginIn")
        .excludePathPatterns("/loginOut");
        log.info("登录拦截器加载完成");
    }
}
