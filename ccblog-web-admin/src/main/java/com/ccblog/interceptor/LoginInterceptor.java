package com.ccblog.interceptor;

import com.ccblog.pojo.po.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/2/3/003.
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        System.out.println("LoginInterceptor----是否登录----preHandle");

        if (request.getSession().getAttribute("user") == null) {
            System.out.println("未登录");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
        System.out.println("已登录"+"用户为："+ ((User) request.getSession().getAttribute("user")).getUserNickname());
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
