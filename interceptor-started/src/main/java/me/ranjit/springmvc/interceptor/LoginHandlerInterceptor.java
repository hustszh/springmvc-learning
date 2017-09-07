package me.ranjit.springmvc.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by suzh on 8/31/2017.
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {

    private static String loginUrl = "login";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、请求到登录页面 放行
        if(request.getServletPath().startsWith(loginUrl)) {
            return true;
        }

        //2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求

        //3、如果用户已经登录 放行
        if(request.getSession().getAttribute("username") != null) {
            //更好的实现方式的使用cookie
            return true;
        }

        //4、非法请求 即这些请求需要登录后才能访问
        //重定向到登录页面
        response.sendRedirect(request.getContextPath() + loginUrl);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
