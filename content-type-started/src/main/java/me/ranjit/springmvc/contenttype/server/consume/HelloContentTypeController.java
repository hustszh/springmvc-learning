package me.ranjit.springmvc.contenttype.server.consume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by suzh on 9/6/2017.
 */
@Controller
@RequestMapping("/contentType")
public class HelloContentTypeController {

    //只对请求头为“Content-Type:application/json”的进行请求处理（即消费请求内容区数据）;
    @RequestMapping(value = "/requestWithOptionalCharset", method = RequestMethod.POST,
        headers = "Content-Type=application/json")
    public String requestWithOptionalCharset(HttpServletRequest request) throws IOException {

        //获取请求的内容区数据（json字符串数据）
        InputStream is = request.getInputStream();
        byte[] bytes = new byte[request.getContentLength()];//得到请求头的内容区数据的长度
        is.read(bytes);

        //得到请求中的内容区数据（以CharacterEncoding解码）
        System.out.println("request character encoding:"+request.getCharacterEncoding());
        String jsonStr = request.getCharacterEncoding() != null ?
                new String(bytes, request.getCharacterEncoding()) : new String(bytes);
        //此处得到数据后，可以通过如json-lib转换为其他对象
        System.out.println("optional:"+jsonStr);
        return "success";//返回success.jsp页面
    }

    @RequestMapping(value = "/requestWithRequiredCharset", method = RequestMethod.POST,
        headers = "Content-Type=application/json;charset=UTF-8")//“;charset=UTF-8”部分并不会起限定作用!!!!
    public String requestWithRequiredCharset(HttpServletRequest request) throws IOException {

        //获取请求的内容区数据（json字符串数据）
        InputStream is = request.getInputStream();
        byte[] bytes = new byte[request.getContentLength()];//得到请求头的内容区数据的长度
        is.read(bytes);

        //得到请求中的内容区数据（以CharacterEncoding解码）
        String jsonStr = new String(bytes, "UTF-8");
        //此处得到数据后，可以通过如json-lib转换为其他对象
        System.out.println("required:"+jsonStr);
        return "success";//返回success.jsp页面
    }


}
