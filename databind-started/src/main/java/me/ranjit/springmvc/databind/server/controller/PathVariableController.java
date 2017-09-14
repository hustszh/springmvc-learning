package me.ranjit.springmvc.databind.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by suzh on 9/8/2017.
 */
@Controller
@RequestMapping("/pathVariable")
public class PathVariableController {

    @RequestMapping(value = "/user/{userId}/topics/{topic}", method = {RequestMethod.POST, RequestMethod.GET})
    public void base(@PathVariable("userId") String userId,
                     @PathVariable("topic") String topic,
                     HttpServletResponse response) throws IOException {
        System.out.println("userId:"+userId);
        System.out.println("topic:"+topic);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println("END");
    }
}
