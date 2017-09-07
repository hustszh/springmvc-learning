package me.ranjit.springmvc.mapping.httprequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by suzh on 9/1/2017.
 */
@Controller
@RequestMapping("/customers/**")//1.处理器的通用映射前缀
public class MethodMappingController {

    //对类级别的@RequestMapping进行窄化
    //表示showForm可处理匹配“/customers/**/create”且请求方法为“GET”的请求；
    @RequestMapping(value="/create", method = RequestMethod.GET)//2.类级别的@RequestMapping窄化
    public String showForm() {
        System.out.println("===============GET");
        return "customer/create";
    }

    //对类级别的@RequestMapping进行窄
    //表示submit可处理匹配“/customers/**/create”且请求方法为“POST”的请求。
    @RequestMapping(value="/create", method = RequestMethod.POST)//3.类级别的@RequestMapping窄化
    public String submit() {
        System.out.println("================POST");
        return "redirect:/success";
    }

    //组合使用是“或”的关系
    //即请求方法可以是 GET 或 POST。
    @RequestMapping(value="/methodOr", method = {RequestMethod.POST, RequestMethod.GET})
    public void GetOrPost() {

    }
}
