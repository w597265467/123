package test2;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;


@Log4j
public class HttpUtil {
    public static void main(String[] args) throws UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException, CertificateException {

        int i = 1;
        HttpUtil httpUtil = new HttpUtil();

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        List<String> strings = FileReadLine.readLine("D:\\project\\123\\src\\main\\resources\\data.txt");
        for (String string : strings) {
            Row row1 = sheet.createRow(i++);
            String[] split = string.split("\t");
            String cardNum = split[0];
            String name = split[1];
            Cell cell = row1.createCell(0);
            cell.setCellValue(cardNum);
            Cell cell1 = row1.createCell(1);
            cell1.setCellValue(name);
            JSONObject data = getData(httpUtil, cardNum);
            JSONObject simBasicInfo = null;
            if (data != null) {
                try {
                    simBasicInfo = data.getJSONArray("rows").getJSONObject(0).getJSONObject("simBasicInfo");
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
            if (simBasicInfo == null) {
                continue;
            }
            //{
            //    "code": "2001",
            //    "msg": "当前请求被成功处理",
            //    "total": 1,
            //    "count": 1,
            //    "rows": [
            //        {
            //            "simBasicInfo": {
            //                "msisdn": "1440286950553",
            //                "iccid": "89860428231880060563",
            //                "imsi": "460044869500553",
            //                "cardStatus": "2",
            //                "remark": "",
            //                "subsId": "8111000200727434"
            //            },
            //            "simApnInfo": {
            //                "apn1List": [],
            //                "apn2List": [],
            //                "imei": "8621070476890803"
            //            },
            //            "simUsageInfo": {
            //                "dataUsage": "2910208",
            //                "smsUsage": "",
            //                "voiceUsage": ""
            //            }
            //        }
            //    ]
            //}

            //{
            //    "code": "2001",
            //    "msg": "当前请求被成功处理",
            //    "total": 0,
            //    "count": 0,
            //    "rows": [
            //        {
            //            "sessionStatus": "2",
            //            "sessionStatusDesc": ""
            //        }
            //    ]
            //}
            JSONObject session = getData2(httpUtil, simBasicInfo.getString("msisdn"));
            if (session == null){
                continue;
            }
            String sessionStatus = session.getJSONArray("rows").getJSONObject(0).getString("sessionStatus");
            String remark = null;
            if ("2".equals(sessionStatus)) {
                //离线七天内有数据上报
                //{"params":{"msisdn":"1440286950553"},"page":{"size":10,"index":1,"total":-1}}
// {
//    "code": "2001",
//    "msg": "当前请求被成功处理",
//    "total": 52,
//    "count": 10,
//    "rows": [
//        {
//            "beginDate": "20200602124343",
//            "endDate": "2020 06 02 13 13 43",
                // 2020.06.02 13:13:43
//            "dataUsage": "11252",
//            "region": "四川全省"
//        },
                JSONObject msisdn = getData3(httpUtil, simBasicInfo.getString("msisdn"));
                String endDate = msisdn.getJSONArray("rows").getJSONObject(0).getString("endDate");
                try {
                    if (endDate.length() == 14) {
                        String ss1 = endDate.substring(0, 3);
                        String ss2 = endDate.substring(4, 5);
                        String ss3 = endDate.substring(6, 7);
                        String ss4 = endDate.substring(8, 9);
                        String ss5 = endDate.substring(10, 11);
                        String ss6 = endDate.substring(12, 13);
                        remark ="离线七天内有数据上报,最后一次上报时间"+ ss1 + "." + ss2 + "." + ss3 + ". " + ss4 + ":" + ss5 + ":" + ss6;
                    }
                } catch (Exception e){
                    remark ="离线七天内有数据上报,最后一次上报时间"+endDate;
                }
            } else if ("0".equals(sessionStatus)) {
                //在线
                remark ="在线";
            } else if ("3".equals(sessionStatus)) {
                //离线七天以上
                remark ="离线七天以上";
            } else {
                remark ="其他";
            }
            Cell cell2 = row1.createCell(2);
            cell2.setCellValue(remark);
        }
        wb.write(new FileOutputStream("D:\\project\\123\\src\\main\\resources\\楼宇流量统计"+System.currentTimeMillis()+".xsl"));
//        System.out.println(hpost);
    }

    private static JSONObject getData3(HttpUtil httpUtil, String msisdn) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        //{"params":{"msisdn":"1440286950553"},"page":{"size":10,"index":1,"total":-1}}
        jsonObject.put("params", jsonObject2);
        jsonObject.put("page", jsonObject3);
        jsonObject2.put("msisdn", msisdn);
        jsonObject3.put("size", 10);
        jsonObject3.put("index", 1);
        jsonObject3.put("total", -1);
        return httpUtil.hpost3("https://ct.cmonelink.com/api/diag/queryAllCDR?lang=zh-CN", jsonObject);
    }

    private static JSONObject getData2(HttpUtil httpUtil, String msisdn) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        //{"params":{"msisdn":"1440286950553"}}
        jsonObject.put("params", jsonObject2);
        jsonObject2.put("msisdn", msisdn);
        return httpUtil.hpost2("https://ct.cmonelink.com/api/diag/querySessionStatus?lang=zh-CN", jsonObject);
    }

    private static JSONObject getData(HttpUtil httpUtil, String cardNum) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        //{"params":{"cardNum":"89860428231880060585"}}
        jsonObject.put("params", jsonObject2);
        jsonObject2.put("cardNum", cardNum);
        return httpUtil.hpost("https://ct.cmonelink.com/api/diag/queryEquipmentInfo?lang=zh-CN", jsonObject);
    }

    void addCookie(String key, String value) {
        BasicClientCookie cookie = new BasicClientCookie(key, value);
        cookie.setVersion(0);
        cookie.setDomain("ct.cmonelink.com");
//        cookie.setDomain("192.168.3.10");
        cookie.setPath("/");
        cookies.add(cookie);
    }

    List<BasicClientCookie> cookies = new ArrayList<>();

    public CloseableHttpClient getHttpClient() throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException {

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(new FileInputStream("C:\\Users\\wly\\Desktop\\txt\\trust2.keystore"),
                "123456".toCharArray());
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(new FileInputStream("C:\\Users\\wly\\Desktop\\txt\\trust2.keystore"),
                "123456".toCharArray());
        SSLContext sslContext = SSLContexts
                .custom()
                .loadKeyMaterial(keyStore, "123456".toCharArray())
                .loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
                .build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);  //制造一个socket
        HttpClientBuilder httpClientBuilder = HttpClients.custom().setSSLSocketFactory(sslsf);
        BasicCookieStore cookieStore = new BasicCookieStore();
        if (cookies != null) {
            for (BasicClientCookie cookie : cookies) {
                cookieStore.addCookie(cookie);
            }
        }
        httpClientBuilder.setDefaultCookieStore(cookieStore);

        return httpClientBuilder.build();
    }


    public JSONObject hpost(String url, JSONObject object) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        // 把表单对象设置到httpPost中
        StringEntity requestEntity = new StringEntity(object.toString(), "utf-8");
        httpPost.setEntity(requestEntity);
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("Connection", "keep-alive");
        String str =
                "Accept: application/json, text/plain, */*\n" +
                        "Accept-Encoding: gzip, deflate, br\n" +
                        "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\n" +
                        "ancient: MTU5MTYxMDM0Mjc3OCY1MDMyMDg=\n" +
                        "congue: SU5EaWFnfElORGlhZw==\n" +
                        "Connection: keep-alive\n" +
//                        "Content-Length: 45\n" +
                        "Content-Type: application/json;charset=UTF-8\n" +
                        "Cookie: lang=zh-CN; name=BE2803302372; SESSION=a715dc24-3ef5-43af-a5cf-f8aab9e04d08; ssi=a715dc24-3ef5-43af-a5cf-f8aab9e04d08; casLogin-Token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCRTI4MDMzMDIzNzIiLCJhdWQiOiIkMmEkMTAkNE8ydEI5UG94dnhJdFdzMklLYk90LktlMFJJTy44bFJVWHR0ZDFBYzFFOW9CUHgvbVJRbmUiLCJjcmVhdGVkIjoxNTkxNjAzODIxNTk1LCJleHAiOjE1OTE2MDM4ODF9.kf4SHutCncdP9CXvTYUX3BOKocuWfePZdim10tXHO8GcCQCYhnjvM6z1gkEY8bdaS9HTE8T24gi9Sutz6qn_AA; roleId=101001; JSESSIONID=FCCFA3ED87ECC60A26E8D0C505F38860\n" +
                        "exponent: MjAyMDA2MDgxNzU5MDI3NzgmMDY4MTUy\n" +
                        "Host: ct.cmonelink.com\n" +
                        "Origin: https://ct.cmonelink.com\n" +
                        "Referer: https://ct.cmonelink.com/\n" +
                        "Sec-Fetch-Dest: empty\n" +
                        "Sec-Fetch-Mode: cors\n" +
                        "Sec-Fetch-Site: same-origin\n" +
                        "sign: 6435366332613130663162343432616438376334373433316534386132313536\n" +
                        "suspect: ODE1\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36\n" +
                        "X-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCRTI4MDMzMDIzNzIiLCJhdWQiOiIkMmEkMTAkNE8ydEI5UG94dnhJdFdzMklLYk90LktlMFJJTy44bFJVWHR0ZDFBYzFFOW9CUHgvbVJRbmUiLCJjcmVhdGVkIjoxNTkxNjAzODIxNTk1LCJleHAiOjE1OTE2MDM4ODF9.kf4SHutCncdP9CXvTYUX3BOKocuWfePZdim10tXHO8GcCQCYhnjvM6z1gkEY8bdaS9HTE8T24gi9Sutz6qn_AA";
//       "";
        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(": ");
            httpPost.setHeader(split1[0], split1[1]);
        }
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = getHttpClient();

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.debug(s);
            return JSONObject.parseObject(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源

                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public JSONObject hpost2(String url, JSONObject object) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        // 把表单对象设置到httpPost中
        StringEntity requestEntity = new StringEntity(object.toString(), "utf-8");
        httpPost.setEntity(requestEntity);
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("Connection", "keep-alive");
        String str =
                "Accept: application/json, text/plain, */*\n" +
                        "Accept-Encoding: gzip, deflate, br\n" +
                        "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\n" +
                        "ancient: MTU5MTYwOTc5Mzk1NyYxOTM3NzQ=\n" +
                        "congue: SU5EaWFnfElORGlhZw==\n" +
                        "Connection: keep-alive\n" +
//                        "Content-Length: 37\n" +
                        "Content-Type: application/json;charset=UTF-8\n" +
                        "Cookie: lang=zh-CN; name=BE2803302372; SESSION=a715dc24-3ef5-43af-a5cf-f8aab9e04d08; ssi=a715dc24-3ef5-43af-a5cf-f8aab9e04d08; casLogin-Token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCRTI4MDMzMDIzNzIiLCJhdWQiOiIkMmEkMTAkNE8ydEI5UG94dnhJdFdzMklLYk90LktlMFJJTy44bFJVWHR0ZDFBYzFFOW9CUHgvbVJRbmUiLCJjcmVhdGVkIjoxNTkxNjAzODIxNTk1LCJleHAiOjE1OTE2MDM4ODF9.kf4SHutCncdP9CXvTYUX3BOKocuWfePZdim10tXHO8GcCQCYhnjvM6z1gkEY8bdaS9HTE8T24gi9Sutz6qn_AA; roleId=101001; JSESSIONID=FCCFA3ED87ECC60A26E8D0C505F38860\n" +
                        "exponent: MjAyMDA2MDgxNzQ5NTM5NTcmNTg2Njgz\n" +
                        "Host: ct.cmonelink.com\n" +
                        "Origin: https://ct.cmonelink.com\n" +
                        "Referer: https://ct.cmonelink.com/\n" +
                        "Sec-Fetch-Dest: empty\n" +
                        "Sec-Fetch-Mode: cors\n" +
                        "Sec-Fetch-Site: same-origin\n" +
                        "sign: 6563396132616234383930396166393936393630363538353933373132393138\n" +
                        "suspect: MjA2\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36\n" +
                        "X-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCRTI4MDMzMDIzNzIiLCJhdWQiOiIkMmEkMTAkNE8ydEI5UG94dnhJdFdzMklLYk90LktlMFJJTy44bFJVWHR0ZDFBYzFFOW9CUHgvbVJRbmUiLCJjcmVhdGVkIjoxNTkxNjAzODIxNTk1LCJleHAiOjE1OTE2MDM4ODF9.kf4SHutCncdP9CXvTYUX3BOKocuWfePZdim10tXHO8GcCQCYhnjvM6z1gkEY8bdaS9HTE8T24gi9Sutz6qn_AA";
//       "";
        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(": ");
            httpPost.setHeader(split1[0], split1[1]);
        }
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = getHttpClient();

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.debug(s);
            return JSONObject.parseObject(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源

                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public JSONObject hpost3(String url, JSONObject object) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/json");
        // 把表单对象设置到httpPost中
        StringEntity requestEntity = new StringEntity(object.toString(), "utf-8");
        httpPost.setEntity(requestEntity);
        httpPost.setHeader("Accept", "*/*");
        httpPost.setHeader("Accept-Encoding", "gzip, deflate, br");
        httpPost.setHeader("Connection", "keep-alive");
        String str =
                "cept: application/json, text/plain, */*\n" +
                        "Accept-Encoding: gzip, deflate, br\n" +
                        "Accept-Language: zh-CN,zh;q=0.9,en;q=0.8\n" +
                        "ancient: MTU5MTYxMDI1ODAzOSY5NjE1MDA=\n" +
                        "congue: SU5EaWFnfElORGlhZw==\n" +
                        "Connection: keep-alive\n" +
//                        "Content-Length: 77\n" +
                        "Content-Type: application/json;charset=UTF-8\n" +
                        "Cookie: lang=zh-CN; name=BE2803302372; SESSION=a715dc24-3ef5-43af-a5cf-f8aab9e04d08; ssi=a715dc24-3ef5-43af-a5cf-f8aab9e04d08; casLogin-Token=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCRTI4MDMzMDIzNzIiLCJhdWQiOiIkMmEkMTAkNE8ydEI5UG94dnhJdFdzMklLYk90LktlMFJJTy44bFJVWHR0ZDFBYzFFOW9CUHgvbVJRbmUiLCJjcmVhdGVkIjoxNTkxNjAzODIxNTk1LCJleHAiOjE1OTE2MDM4ODF9.kf4SHutCncdP9CXvTYUX3BOKocuWfePZdim10tXHO8GcCQCYhnjvM6z1gkEY8bdaS9HTE8T24gi9Sutz6qn_AA; roleId=101001; JSESSIONID=FCCFA3ED87ECC60A26E8D0C505F38860\n" +
                        "exponent: MjAyMDA2MDgxNzU3MzgzOSYyNjA5OTE=\n" +
                        "Host: ct.cmonelink.com\n" +
                        "Origin: https://ct.cmonelink.com\n" +
                        "Referer: https://ct.cmonelink.com/\n" +
                        "Sec-Fetch-Dest: empty\n" +
                        "Sec-Fetch-Mode: cors\n" +
                        "Sec-Fetch-Site: same-origin\n" +
                        "sign: 3766653465333138336633643131666636326338373334643163393764383737\n" +
                        "suspect: NzA1\n" +
                        "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36\n" +
                        "X-Token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJCRTI4MDMzMDIzNzIiLCJhdWQiOiIkMmEkMTAkNE8ydEI5UG94dnhJdFdzMklLYk90LktlMFJJTy44bFJVWHR0ZDFBYzFFOW9CUHgvbVJRbmUiLCJjcmVhdGVkIjoxNTkxNjAzODIxNTk1LCJleHAiOjE1OTE2MDM4ODF9.kf4SHutCncdP9CXvTYUX3BOKocuWfePZdim10tXHO8GcCQCYhnjvM6z1gkEY8bdaS9HTE8T24gi9Sutz6qn_AA";
//       "";
        String[] split = str.split("\n");
        for (String s : split) {
            String[] split1 = s.split(": ");
            httpPost.setHeader(split1[0], split1[1]);
        }
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = getHttpClient();

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(entity);
            log.debug(s);
            return JSONObject.parseObject(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源

                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
