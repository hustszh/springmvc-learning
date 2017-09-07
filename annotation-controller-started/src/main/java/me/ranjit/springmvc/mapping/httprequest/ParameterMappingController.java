package me.ranjit.springmvc.mapping.httprequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by suzh on 9/1/2017.
 */
@Controller
@RequestMapping("/parameter1")//1.处理器的通用映射前缀
public class ParameterMappingController {
    //2.进行类级别的@RequestMapping窄化
    //表示请求中有“create”的参数名且请求方法为“GET”即可匹配，如可匹配的请求URL“http://×××/parameter1?create”；
    @RequestMapping(params="create", method= RequestMethod.GET)
    public String showForm() {
        System.out.println("===============showForm");
        return "parameter/create";
    }

    //3.进行类级别的@RequestMapping窄化
    //表示请求中有“create”的参数名且请求方法为“POST”即可匹配；
    @RequestMapping(params="create", method=RequestMethod.POST)
    public String submit() {
        System.out.println("================submit");
        return "redirect:/success";
    }

    //表示请求中“没有create”参数名且请求方法为“GET”即可匹配，如可匹配的请求URL“http://×××/parameter1?abc”。
    @RequestMapping(params="!create", method=RequestMethod.GET)
    public void m1() {}

    //表示请求中有“submitFlag=create”请求参数且请求方法为“GET”即可匹配，如请求URL为http://×××/parameter2?submitFlag=create；
    @RequestMapping(params="submitFlag=create", method=RequestMethod.GET)
    public String showForm1() {
        System.out.println("===============showForm");
        return "parameter/create";
    }

    // 组合使用是“且”的关系
    // 表示请求中的有“test1”参数名 且 有“test2=create”参数即可匹配，如可匹配的请求URL“http://×××/parameter3?test1&test2=create。
    @RequestMapping(params={"test1", "test2=create"})
    public void both() {}
}
