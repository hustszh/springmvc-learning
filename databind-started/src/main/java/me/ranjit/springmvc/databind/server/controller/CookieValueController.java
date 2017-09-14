package me.ranjit.springmvc.databind.server.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;

/**
 * Created by suzh on 9/8/2017.
 */
@Controller
@RequestMapping("/cookieValue")
public class CookieValueController {

    @RequestMapping(value = "/sessionidStr", method = {RequestMethod.GET,RequestMethod.POST} )
    public String testSessionidStr(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionid) {
        System.out.println("str:"+sessionid);
        return "success";
    }

    @RequestMapping(value = "/sessionidCookie", method = {RequestMethod.GET,RequestMethod.POST} )
    public String testSessionidCookie(@CookieValue(value = "JSESSIONID", defaultValue = "") Cookie cookie) {
        System.out.println("cookie:"+JSON.toJSONString(cookie));
        return "success";
    }
}
