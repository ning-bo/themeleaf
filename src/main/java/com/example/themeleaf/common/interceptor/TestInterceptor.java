package com.example.themeleaf.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author NingBo
 * @create 2018-05-24 16:21
 * @desc 拦截器练习
 **/
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(StringUtils.equals(request.getRequestURI(),"/xin/index")){
            return true;
        }
        return false;
    }

}
