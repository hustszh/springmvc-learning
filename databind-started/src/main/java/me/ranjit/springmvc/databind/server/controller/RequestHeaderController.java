package me.ranjit.springmvc.databind.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by suzh on 9/8/2017.
 */
@Controller
@RequestMapping("/requestHeader")
public class RequestHeaderController {

    @RequestMapping(value = "/test", method = {RequestMethod.POST, RequestMethod.GET})
    public String test(@RequestHeader("User-Agent") String userAgent,
                       @RequestHeader("Accept") List<String> accepts) {
        System.out.println("user-agent:"+userAgent);
        System.out.println("accept:"+accepts);
        return "success";
    }
}
