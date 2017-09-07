package me.ranjit.springmvc.contenttype.server.produce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by suzh on 9/6/2017.
 */
@Controller
@RequestMapping("/accept")
public class HelloAcceptController {

    //服务器应该根据Accept请求头生产指定媒体类型的数据。
    @RequestMapping(value = "/acceptWithOptionalCharset", method = RequestMethod.POST,
            headers = "Accept=application/json")
    public void acceptWithOptionalCharset(HttpServletResponse response) throws IOException {
        //表示响应的内容区数据的媒体类型为json格式，且编码为GBK(客户端可以获取此编码格式，并以此解码)
        response.setContentType("application/json;charset=gbk");

        //写出响应体内容
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        response.getWriter().write(jsonData);
    }

    //服务器应该根据Accept请求头生产指定媒体类型的数据。
    @RequestMapping(value = "/acceptWithRequiredCharset", method = RequestMethod.POST,
            headers = "Accept=application/json;charset=gbk")//“;charset=gbk”部分并不会起限定作用!!!!
    public void acceptWithRequiredCharset(HttpServletResponse response) throws IOException {
        //表示响应的内容区数据的媒体类型为json格式，且编码为GBK(客户端可以获取此编码格式，并以此解码)
        response.setContentType("application/json;charset=gbk");

        //写出响应体内容
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        response.getWriter().write(jsonData);
    }

}
