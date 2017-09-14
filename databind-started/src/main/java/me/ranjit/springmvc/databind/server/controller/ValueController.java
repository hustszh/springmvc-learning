package me.ranjit.springmvc.databind.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by suzh on 9/8/2017.
 */
@Controller
@RequestMapping("/value")
public class ValueController {

    //作用在类的属性上，可以获取配置文件的属性值
    @Value("${hostname:'localhost'}")
//    @Value("#{configProperties['hostname']}")
    private String hostname;

    //作用在功能处理方法的参数上
    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST})
    public String test(@Value("(#{systemProperties['java.vm.version']}") String jvmVersion) {
        System.out.println("jvm version:"+jvmVersion);
        System.out.println("hostname:"+hostname);
        return "success";
    }
}
