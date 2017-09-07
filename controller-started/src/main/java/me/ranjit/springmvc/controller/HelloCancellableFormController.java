package me.ranjit.springmvc.controller;

import me.ranjit.springmvc.model.UserModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.CancellableFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suzh on 8/29/2017.
 */
public class HelloCancellableFormController extends CancellableFormController {

    public HelloCancellableFormController() {
        setCommandClass(UserModel.class);
        setCommandName("user");//用于jsp中的EL语句
    }

    //form object 表单对象，提供展示表单时的表单数据（使用commandName放入请求）
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        UserModel user = new UserModel();
        user.setUsername("Input user name");
        return user;
    }

    //提供展示表单时需要的一些其他数据
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map map = new HashMap();
        map.put("cityList", Arrays.asList("shan", "bei", "guang"));
        return map;
    }

    //如果需要返回模型对象给成功页面，那么就必须复写表单控制器的onSubmit ()方法。
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        UserModel user = (UserModel) command;
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        if (errors.hasErrors())
            mv.setViewName("fail");
        else
            mv.setViewName("success");
        return mv;
    }

    @Override
    protected ModelAndView onCancel(HttpServletRequest request, HttpServletResponse response, Object command) throws Exception {
        UserModel user = (UserModel) command;
        //TODO 调用业务对象处理
        System.out.println(user);
        return super.onCancel(command);
    }
}
