package me.ranjit.springmvc.mapping.httprequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by suzh on 9/1/2017.
 */
@Controller
@RequestMapping("/headerMapping/**")
public class HeaderMappingController {

    //请求头数据中有指定参数名
    //表示请求的URL必须为“/header/test1” 且 请求头中必须有"abc"参数才能匹配。
    @RequestMapping(value="/header/test1", headers = "abc")
    public void abc() {
        System.out.println("abc");
    }

    //请求头数据中没有指定参数名
    //表示请求的URL必须为“/header/test2” 且 请求头中必须没有abc参数才能匹配。
    @RequestMapping(value="/header/test2", headers = "!abc")
    public void noneabc(){

    }

    //请求头数据中指定参数名=值
    //表示请求的URL必须为“/header/test3” 且 请求头中必须有“Content-Type=application/json”参数即可匹配。
    //如果请求头中没有或不是“Content-Type=application/json”参数（如“text/html”其他参数），将返回“HTTP Status 415”状态码【表示不支持的媒体类型(Media Type)，也就是MIME类型】，即我们的功能处理方法只能处理application/json的媒体类型。
    @RequestMapping(value="/header/test3", headers = "Content-Type=application/json")
    public void contentType() {

    }

    //Accept=text/*：表示主类型为text，子类型任意，如“text/plain”、“text/html”等都可以匹配。
    @RequestMapping(value="/header/test5", headers = "Accept=text/*")
    public void acceptText() {

    }

    //组合使用是“且”的关系
    //表示请求的URL必须为“/header/test6” 且 请求头中必须有“Accept”参数但值不等于“text/vnd.wap.wml”且 请求中必须有参数“abc=123”即可匹配。
    @RequestMapping(value="/header/test6", headers = {"Accept!=text/vnd.wap.wml","abc=123"})
    public void headerAnd() {

    }
}
