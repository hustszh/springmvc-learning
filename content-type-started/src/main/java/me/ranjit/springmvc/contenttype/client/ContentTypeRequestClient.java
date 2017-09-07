package me.ranjit.springmvc.contenttype.client;

import me.ranjit.springmvc.contenttype.util.SystemUtil;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.net.URI;

/**
 * Created by suzh on 9/7/2017.
 */
public class ContentTypeRequestClient {
    public static void main(String[] args) throws Exception {

        SystemUtil.echoSystemDefaultEncoding();

        requestWithOptionalCharset("application/json", "ISO-8859-1");
        requestWithOptionalCharset("application/json", null);//将会使用OS系统缺省编码

        requestWithRequiredCharset("application/json", "ISO-8859-1");
        requestWithRequiredCharset("application/json", "UTF-8");
        requestWithRequiredCharset("application/json", "utf-8");
        requestWithRequiredCharset("application/json", null);//将会使用OS系统缺省编码

    }

    private static void requestWithOptionalCharset(String mimeType, String charsetName) throws Exception {
        //请求的地址
        String url = "http://localhost:8080/contentType/requestWithOptionalCharset";

        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);

        //设置请求头的内容类型头和内容编码
        String contentType = (charsetName == null ? mimeType : mimeType+";charset="+charsetName);
        request.getHeaders().set("Content-Type", contentType);

        //以编码写出请求内容体
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        request.getBody().write(charsetName != null ?
                jsonData.getBytes(charsetName) : jsonData.getBytes());//String.getBytes()使用OS默认字符集进行编码

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();
        System.out.println(response.getStatusCode());
    }

    private static void requestWithRequiredCharset(String mimeType, String charsetName) throws Exception {
        //请求的地址
        String url = "http://localhost:8080/contentType/requestWithRequiredCharset";

        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory().createRequest(new URI(url), HttpMethod.POST);

        //设置请求头的内容类型头和内容编码
        String contentType = (charsetName == null ? mimeType : mimeType+";charset="+charsetName);
        System.out.println(contentType);
        request.getHeaders().set("Content-Type", contentType);

        //以编码写出请求内容体
        String jsonData = "{\"username\":\"中文\", \"password\":\"123\"}";
        request.getBody().write(charsetName != null ?
                jsonData.getBytes(charsetName) : jsonData.getBytes());//String.getBytes()使用OS默认字符集进行编码

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();
        System.out.println(response.getStatusCode());
    }


}
