package me.ranjit.springmvc.databind.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by suzh on 9/8/2017.
 */
public class RequestClient {
    public static void main(String[] args) throws Exception {
//        requestWithUrlAndParams("requestParam", "base", "username=suzh");
//        requestWithUrlAndParams("requestParam","base", null);//use default value
//        requestWithUrlAndParams("requestParam","multiValue", "role=suzh");
//        requestWithUrlAndParams("requestParam","multiValue", "role=suzh&role=ranjit");
//
//        requestWithUrlAndParams("pathVariable","user/suzh/topics/book", "userId=suzh&topic=book");

//        requestWithUrlAndCookie("cookieValue","sessionidStr");
//        requestWithUrlAndCookie("cookieValue","sessionidCookie");

//        requestWithUrlAndHeaders("requestHeader","test");

//        requestWithUrlAndParams("modelAttribute","bindParamToCommandObj", "username=suzh&password=123456");
//        requestWithUrlAndParams("modelAttribute","bindModelToCommandObj", null);
//        requestWithUrlAndParams("modelAttribute","bindToMappingMethod", null);
//        requestWithUrlAndParams("modelAttribute","bindToReturnValue", null);

        requestWithUrlAndParams("value","test", null);
    }

    public static void requestWithUrlAndParams(String baseURL, String requestMethod, String params) throws Exception {
        //请求的地址
        String targetParam = (params == null ? "" : "?"+params);
        String url = "http://localhost:8080/"+baseURL+"/"+requestMethod+targetParam;
        System.out.println("Request url:"+url);
        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory(). createRequest(new URI(url), HttpMethod.POST);

        //设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //设置请求头的内容类型头和内容编码
        request.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        //以编码写出请求内容体
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        request.getBody().write(jsonData.getBytes("UTF-8"));

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();

        //得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        System.out.println("response charset:"+charset);

        //得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);
        String resultData = new String(bytes, charset);
        System.out.println("json data: " + resultData);
    }

    public static void requestWithUrlAndCookie(String baseURL, String requestMethod) throws Exception {
        //请求的地址
        String url = "http://localhost:8080/"+baseURL+"/"+requestMethod;
        System.out.println("Request url:"+url);
        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);

        //设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //设置请求头的内容类型头和内容编码
        request.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        String JSESSIONID = "HA@!$#^&*()_+HA";
        request.getHeaders().set("Cookie", "JSESSIONID="+JSESSIONID);

        //以编码写出请求内容体
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        request.getBody().write(jsonData.getBytes("UTF-8"));

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();

        //得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        System.out.println("response charset:"+charset);

        //得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);
        String resultData = new String(bytes, charset);
        System.out.println("json data: " + resultData);
    }

    public static void requestWithUrlAndHeaders(String baseURL, String requestMethod) throws Exception {
        //请求的地址
        String url = "http://localhost:8080/"+baseURL+"/"+requestMethod;
        System.out.println("Request url:"+url);
        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);

        //设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        request.getHeaders().setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));
        //设置请求头的内容类型头和内容编码
        request.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        request.getHeaders().set("User-Agent", "Hello");

        //以编码写出请求内容体
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        request.getBody().write(jsonData.getBytes("UTF-8"));

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();

        //得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        System.out.println("response charset:"+charset);

        //得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);
        String resultData = new String(bytes, charset);
        System.out.println("json data: " + resultData);
    }

}
