package com.zh.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* 登录拦截器
* */
@Configuration
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        Object newName = session.getAttribute("newName");
        if(newName!=null){
            return true;
        }else {
            response.sendRedirect(request.getContextPath()+"/loginOut");
            return false;
        }
    }
}
