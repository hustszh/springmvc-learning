package me.ranjit.springmvc.databind.server.controller;

import com.alibaba.fastjson.JSON;
import me.ranjit.springmvc.databind.server.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by suzh on 9/8/2017.
 */
@Controller
@RequestMapping("/modelAttribute")
public class ModelAttributeController {

    //方式1：使用在非功能方法（没有映射到URL）上，在所有此controller的所有功能方法执行之前执行。
    @ModelAttribute("user")//value值要与使用者一致
    private UserModel createUserModel() {
        System.out.println("call createUserModel()");
        return new UserModel("newU", "newP");
    }

    //方式2：使用在功能方法（映射到URL）上，可以从Form或URL参数中的参数值构造命令对象
    @RequestMapping(value = "/bindParamToCommandObj", method = {RequestMethod.POST, RequestMethod.GET})
    public String bindParamToCommandObj(@ModelAttribute("user") UserModel userModel) {//如果传递了参数，就使用参数，否则使用createUserModel()的返回值，视图可以使用user.xx获取属性值
        System.out.println(JSON.toJSONString(userModel));
        return "userInfo";
    }

    //方式2：使用在功能方法（映射到URL）上，可以从由@ModelAttribute修饰的非功能方法（如上面的createUserModel）中获取命令对象。
    @RequestMapping(value = "/bindModelToCommandObj", method = {RequestMethod.POST, RequestMethod.GET})
    public String bindReturnToCommandObj(@ModelAttribute("user") UserModel userModel) {//如果传递了参数，就使用参数，否则使用createUserModel()的返回值，视图可以使用user.xx获取属性值
        System.out.println(JSON.toJSONString(userModel));
        return "userInfo";
    }

    //方式3：使用在功能方法（映射到URL）的注解上，表示返回的不是视图名，而是一个属性值。相当于在request中封装了key=username，value=Newname。
    //视图名称如何确定？？？
    //视图名称由RequestToViewNameTranslator根据请求“控制器URL/功能处理方法URL”转换为逻辑视图“控制器URL/功能处理方法URL.jsp”。
    @RequestMapping(value = "bindToMappingMethod", method = {RequestMethod.POST, RequestMethod.GET})
    @ModelAttribute("userModel")
    public UserModel bindToMappingMethod() {
        UserModel userModel = new UserModel("Newname", "NewPassword");
        System.out.println(JSON.toJSONString(userModel));
        return userModel;
    }

    //方式4：使用在功能方法（映射到URL）的返回值上，作用与“使用在功能方法的注解上”一致。
    @RequestMapping(value = "bindToReturnValue", method = {RequestMethod.GET, RequestMethod.POST})
    public @ModelAttribute("ReModel") UserModel bindToReturnValue() {
        UserModel userModel = new UserModel("ReUser", "Reword");
        System.out.println(JSON.toJSONString(userModel));
        return userModel;
    }

}
