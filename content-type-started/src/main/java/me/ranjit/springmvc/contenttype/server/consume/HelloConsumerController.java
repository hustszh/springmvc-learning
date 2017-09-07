package me.ranjit.springmvc.contenttype.server.consume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * Created by suzh on 9/6/2017.
 */
@Controller
@RequestMapping("/consume")
public class HelloConsumerController {

    @RequestMapping(value = "/request", method = RequestMethod.POST,
        consumes = "application/json")//等同于@RequestMapping的“headers = "Content-Type=application/json"”
    public String request(HttpServletRequest request) throws Exception {

        //获取请求的内容区数据（json字符串数据）
        InputStream is = request.getInputStream();
        byte[] bytes = new byte[request.getContentLength()];
        is.read(bytes);

        //得到请求中的CharacterEncoding
        String charset = request.getCharacterEncoding();
        System.out.println("request charset:" + charset);

        //得到请求中的内容区数据（以CharacterEncoding解码）
        String jsonStr = charset == null ? new String(bytes) : new String(bytes, charset);
        System.out.println(jsonStr);

        //返回success.jsp页面
        return "success";
    }
}
