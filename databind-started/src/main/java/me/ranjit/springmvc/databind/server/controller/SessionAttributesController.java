package me.ranjit.springmvc.databind.server.controller;

import me.ranjit.springmvc.databind.server.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Arrays;

/**
 * Created by suzh on 9/13/2017.
 * @SessionAttributes，提供了多次请求之间透明的存取会话数据
 * @SessionAttributes注解只能在类上使用，不能在方法上使用
 */
@SessionAttributes(value = {"names", "user"}, types = {Integer.class})//名称为names, users和类型为Integer的属性都保存到session中
@Controller
@RequestMapping("/session")
public class SessionAttributesController {

    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(ModelMap model) {
        model.put("names", Arrays.asList("caoyc","zhh","cjx"));
        model.addAttribute("age", 18);
        return "sessionAttribute";
    }

    @RequestMapping(value = "/clean", method = {RequestMethod.GET, RequestMethod.POST})
    public String clean(SessionStatus sessionStatus) {
        //@SessionAttributes需要清除时，使用SessionStatus.setComplete();来清除。
        // 注意，它只清除@SessionAttributes的session，不会清除HttpSession的数据。
        sessionStatus.setComplete();
        return "sessionAttribute";
    }

    @ModelAttribute("user")//value值要与使用者一致
    private UserModel createUserModel() {
        System.out.println("call createUserModel()");
        return new UserModel("UUUser", "PPPord");
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(@ModelAttribute("user") UserModel userModel) {
        return "sessionUser";
    }
}
