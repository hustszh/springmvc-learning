package me.ranjit.springmvc.controller;

import me.ranjit.springmvc.model.UserModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by suzh on 8/28/2017.
 */
public class HelloAbstractCommandController extends AbstractCommandController {

    public HelloAbstractCommandController() {
        //设置命令对象实现类
        //也可以通过配置文件的依赖注入实现
        setCommandClass(UserModel.class);
//        setCommandName("command");
    }
    @Override
    protected ModelAndView handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object command, BindException e) throws Exception {
        //将命令对象转换为实际类型
        UserModel user = (UserModel) command;
        ModelAndView mv = new ModelAndView();
        mv.setViewName("abstractCommand");
        mv.addObject("user", user);
        return mv;
    }
}
