package me.ranjit.springmvc.controller;

import me.ranjit.springmvc.model.DataBinderModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by suzh on 8/30/2017.
 */
public class HelloErrorController extends AbstractCommandController {

    public HelloErrorController() {
        setCommandClass(DataBinderModel.class);
        setCommandName("command");
    }

    @Override
    protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
        //表示用户名不为空
        errors.reject("username.not.empty");
        //带有默认错误消息
        errors.reject("username.not.empty1", "用户名不能为空1");
        //带有参数和默认错误消息
        errors.reject("username.length.error", new Object[]{5, 10}, "用户名长度不合法，长度必须在5到10之间");

        //得到错误相关的模型数据
        Map model = errors.getModel();
        return new ModelAndView("bind/error", model);
    }
}
