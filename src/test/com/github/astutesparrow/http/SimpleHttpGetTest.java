package com.github.astutesparrow.http;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

/**
 * User: 智深
 * Date: 13-5-8
 */
public class SimpleHttpGetTest {

    @Test
    public void simpleHttpGet() {
        HttpClient httpClient = new DefaultHttpClient();

        try {
            String params = "ch=" + URLEncoder.encode("中", "utf-8") + "&en=Hello";
            URI uri = URIUtils.createURI("http", "localhost", 8080, "/encoding", params, null);

            HttpUriRequest request = new HttpGet(uri);

            request.addHeader(new Header() {
                @Override
                public String getName() {
                    return "Content-Type";
                }

                @Override
                public String getValue() {
                    return "application/x-www-form-urlencoded;charset=utf-8";
                }

                @Override
                public HeaderElement[] getElements() throws ParseException {
                    return new HeaderElement[0];
                }
            });

            System.out.println(request.getRequestLine());


            // 发送请求，返回响应
            HttpResponse response = httpClient.execute(request);

            // 打印响应信息
            System.out.println(response.getStatusLine());
        } catch (ClientProtocolException e) {
            // 协议错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络异常
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
