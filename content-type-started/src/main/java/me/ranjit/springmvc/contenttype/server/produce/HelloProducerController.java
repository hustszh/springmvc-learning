package me.ranjit.springmvc.contenttype.server.produce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by suzh on 9/6/2017.
 */
@Controller
@RequestMapping("/produce")
public class HelloProducerController {

    @RequestMapping(value = "/response", method = RequestMethod.POST,
        produces = "application/json")//等同于@RequestMapping的“headers = "Accept=application/json"”
    public void response(HttpServletResponse response) throws Exception {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        response.getWriter().write(jsonData);
    }
}
