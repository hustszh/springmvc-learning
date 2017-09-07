package me.ranjit.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by suzh on 8/28/2017.
 */
public class HelloCacheController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //点击后再次请求当前页面
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }
}
