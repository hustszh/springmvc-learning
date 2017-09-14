package me.ranjit.springmvc.databind.server.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by suzh on 9/8/2017.
 */
@Controller
@RequestMapping("/requestParam")
public class RequestParamController {

    @RequestMapping(value = "/base", method = RequestMethod.POST)
    public String base(@RequestParam(value = "username", required = false, defaultValue = "ranjit") String username) {
        System.out.println(username);
        return "success";
    }

    @RequestMapping(value = "/multiValue", method = RequestMethod.POST)
    public String multiValue(@RequestParam("role") List<String> roleList) {
        System.out.println(JSON.toJSONString(roleList));
        return "success";
    }
}
