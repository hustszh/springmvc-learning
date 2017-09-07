package me.ranjit.springmvc.controller;

import me.ranjit.springmvc.model.UserModel;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by suzh on 8/28/2017.
 */
public class HelloSimpleFormController extends SimpleFormController {
    public HelloSimpleFormController() {
        setCommandClass(UserModel.class); //设置命令对象实现类
        setCommandName("user");//设置命令对象的名字
    }
    //form object 表单对象，提供展示表单时的表单数据（使用commandName放入请求）
    protected Object formBackingObject(HttpServletRequest request) throws Exception {
        UserModel user = new UserModel();
        user.setUsername("Pls input user name");
        return user;
    }
    //提供展示表单时需要的一些其他数据
    protected Map referenceData(HttpServletRequest request) throws Exception {
        Map map = new HashMap();
        map.put("cityList", Arrays.asList("shan", "bei", "guang"));
        return map;
    }

    //不需要返回模型对象给成功页面时，复写doSubmitAction()方法是最佳的选择，因为该方法没有返回值。
    protected void doSubmitAction(Object command) throws Exception {
        UserModel user = (UserModel) command;
        //TODO 调用业务对象处理
        System.out.println(user);
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
}
