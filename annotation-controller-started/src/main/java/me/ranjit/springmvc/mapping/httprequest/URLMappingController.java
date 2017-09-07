package me.ranjit.springmvc.mapping.httprequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * Created by suzh on 9/1/2017.
 */
@Controller
public class URLMappingController {

    //普通URL路径映射
    //多个URL路径可以映射到同一个处理器的功能处理方法。
    //组合使用是"或"的关系，即“/test1”或“/user/create”请求URL路径都可以映射到@RequestMapping指定的功能处理方法。
    @RequestMapping(value={"/test1", "/user/create"})
    public void m1() {
    }

    //URI模板模式映射
    @RequestMapping(value="/users/{userId}")//：{×××}占位符， 请求的URL可以是 “/users/123456”或“/users/abcd”，通过@PathVariable可以提取URI模板模式中的{×××}中的×××变量。
    //@RequestMapping(value="/users/{userId}/create")//：这样也是可以的，请求的URL可以是“/users/123/create”。
    //@RequestMapping(value="/users/{userId}/topics/{topicId}")//：这样也是可以的，请求的URL可以是“/users/123/topics/123”。
    public void m2() {
    }

    //Ant风格的URL路径映射
    @RequestMapping(value="/users/**")//：可以匹配“/users/abc/abc”，但“/users/123”将会被【URI模板模式映射中的“/users/{userId}”模式优先映射到】
    //@RequestMapping(value="/product?")//：可匹配“/product1”或“/producta”，但不匹配“/product”或“/productaa”;
    //@RequestMapping(value="/product*")//：可匹配“/productabc”或“/product”，但不匹配“/productabc/abc”;
    //@RequestMapping(value="/product/*")//：可匹配“/product/abc”，但不匹配“/productabc”;
    //@RequestMapping(value="/products/**/{productId}")//：可匹配“/products/abc/abc/123”或“/products/123”，也就是Ant风格和URI模板变量风格可混用;
    public void m3() {
    }

    //正则表达式风格的URL路径映射
    @RequestMapping(value="/products/{categoryCode:\\d+}-{pageNumber:\\d+}")//：可以匹配“/products/123-1”，但不能匹配“/products/abc-1”，这样可以设计更加严格的规则。
    public void m4() {
    }
}
