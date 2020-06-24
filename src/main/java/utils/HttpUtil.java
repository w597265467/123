package utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;



@Log4j
public class HttpUtil {
    static CloseableHttpClient httpClient = getHttpClient();
    public static CloseableHttpClient getHttpClient() {
        if (httpClient!=null){
            return httpClient;
        }
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        BasicCookieStore cookieStore = new BasicCookieStore();
        {
            BasicClientCookie cookie = new BasicClientCookie("Admin-Token", "1");
            cookie.setVersion(0);
            cookie.setDomain("www.chengdutianfu.com");
            cookie.setPath("/");
            cookieStore.addCookie(cookie);
            BasicClientCookie cookie2 = new BasicClientCookie("shiro.sesssion", "1");
            cookie2.setVersion(0);
            cookie2.setDomain("www.chengdutianfu.com");
            cookie2.setPath("/iot-cloud");
            cookieStore.addCookie(cookie2);
        }
        BasicClientCookie cookie = new BasicClientCookie("JSESSIONID", "550600e9-a6d6-49dd-a0fb-f9e9b6aa6117");
        cookie.setVersion(0);
        cookie.setDomain("oms.chengdutianfu.com");
        cookie.setPath("/iot-oms");
        cookieStore.addCookie(cookie);
        BasicClientCookie cookie1 = new BasicClientCookie("Admin-Token", "550600e9-a6d6-49dd-a0fb-f9e9b6aa6117");
        cookie1.setVersion(0);
        cookie1.setDomain("oms.chengdutianfu.com");
        cookie1.setPath("/");
        cookieStore.addCookie(cookie1);
        BasicClientCookie cookie2 = new BasicClientCookie("sidebarStatus", "1");
        cookie2.setVersion(0);
        cookie2.setDomain("oms.chengdutianfu.com");
        cookie2.setPath("/");
        cookieStore.addCookie(cookie2);
        httpClientBuilder.setDefaultCookieStore(cookieStore);
        httpClient = httpClientBuilder.build();
        return httpClient;
    }

    public static JSONObject hget(String url) {
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;
        JSONObject data = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String s = EntityUtils.toString(responseEntity);
                data = JSONObject.parseObject(s);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {

                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void hpost(String url, JSONObject object) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        // 把表单对象设置到httpPost中
        StringEntity requestEntity = new StringEntity(object.toString(), "utf-8");
        httpPost.setEntity(requestEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.debug(s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            String code = jsonObject.getString("code");
            if ("20000".equals(code)){
                log.debug("下发成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {

                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static JSONObject hpost(String url, JSONArray object) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        // 把表单对象设置到httpPost中
        System.out.println(object.toString());
        StringEntity requestEntity = new StringEntity(object.toString(), "utf-8");
        httpPost.setEntity(requestEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.debug(s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            String code = jsonObject.getString("code");
//            if ("20000".equals(code)){
//                log.debug("下发成功");
//            }
            return jsonObject;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {

                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HttpPost httpPost = new HttpPost("http://aip.baidubce.com/rest/2.0/ocr/v1/general_basic");
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        // 把表单对象设置到httpPost中
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.addBinaryBody("image",new File("C:\\Users\\wly\\Desktop\\微信图片_20200424164828.png"));
        multipartEntityBuilder.addTextBody("access_token", "24.8911594e48d82b3bbbf681dccd0a6b36.2592000.1590311574.282335-19586862");
        httpPost.setEntity(multipartEntityBuilder.build());
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.debug(s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            String code = jsonObject.getString("code");
            if ("20000".equals(code)){
                log.debug("下发成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {

                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
