package me.ranjit.springmvc.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.LastModified;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by suzh on 8/28/2017.
 * 支持Last-Modified机制，需要实现LastModified接口
 */
public class HelloLastModifiedCacheController extends AbstractController implements LastModified{
    private long lastModified;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //点击后再次请求当前页面
        response.getWriter().write("<a href=''>this</a>");
        return null;
    }

    public long getLastModified(HttpServletRequest request) {
        if(lastModified == 0L) {
            //TODO 此处更新的条件：如果内容有更新，应该重新返回内容最新修改的时间戳
            lastModified = System.currentTimeMillis();
        }
        return lastModified;
    }
}
