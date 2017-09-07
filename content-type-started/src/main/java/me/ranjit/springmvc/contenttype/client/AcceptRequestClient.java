package me.ranjit.springmvc.contenttype.client;

import me.ranjit.springmvc.contenttype.util.SystemUtil;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;

/**
 * Created by suzh on 9/7/2017.
 */
public class AcceptRequestClient {
    public static void main(String[] args) throws Exception {

        SystemUtil.echoSystemDefaultEncoding();

        acceptWithOptionalCharset("application/json", "ISO-8859-1");
        acceptWithOptionalCharset("application/json", null);//将会使用OS系统缺省编码

        acceptWithRequiredCharset("application/json", "ISO-8859-1");
        acceptWithRequiredCharset("application/json", "GBK");
        acceptWithRequiredCharset("application/json", "gbk");
        acceptWithRequiredCharset("application/json", null);//将会使用OS系统缺省编码

    }

    public static void acceptWithOptionalCharset(String mimeType, String charsetName) throws Exception {
        //请求的地址
        String url = "http://localhost:8080/accept/acceptWithOptionalCharset";
        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory(). createRequest(new URI(url), HttpMethod.POST);

        //设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        String acceptType = charsetName == null ? mimeType : mimeType+";charset=" + charsetName;
        request.getHeaders().set("Accept", acceptType);

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();

        //得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        System.out.println("response charset:"+charset);

        //得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);
        String jsonData = new String(bytes, charset);
        System.out.println("json data: " + jsonData);
    }

    public static void acceptWithRequiredCharset(String mimeType, String charsetName) throws Exception {
        //请求的地址
        String url = "http://localhost:8080/accept/acceptWithRequiredCharset";
        //创建Http Request(内部使用HttpURLConnection)
        ClientHttpRequest request = new SimpleClientHttpRequestFactory(). createRequest(new URI(url), HttpMethod.POST);

        //设置客户端可接受的媒体类型（即需要什么类型的响应体数据）
        String acceptType = charsetName == null ? mimeType : mimeType+";charset=" + charsetName;
        request.getHeaders().set("Accept", acceptType);

        //发送请求并得到响应
        ClientHttpResponse response = request.execute();

        //得到响应体的编码方式
        Charset charset = response.getHeaders().getContentType().getCharSet();
        System.out.println("response charset:"+charset);

        //得到响应体的内容
        InputStream is = response.getBody();
        byte bytes[] = new byte[(int)response.getHeaders().getContentLength()];
        is.read(bytes);
        String jsonData = new String(bytes, charset);
        System.out.println("json data: " + jsonData);
    }
}
