package me.ranjit.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by suzh on 9/1/2017.
 */
@Controller//1.@Controller或@RequestMapping，即可把一个POJO类变身为处理器
public class HelloAnnotationController {
    @RequestMapping(value = "/hello")//2.请求URL到处理器功能处理方法的映射
    public ModelAndView helloWorld() {
        //1、收集参数
        //2、绑定参数到命令对象
        //3、调用业务对象
        //4、选择下一个页面
        ModelAndView mv = new ModelAndView();
        //添加模型数据 可以是任意的POJO对象
        mv.addObject("message", "Hello World!");
        //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
        mv.setViewName("hello");
        return mv;//3.模型数据和逻辑视图名
    }
}
