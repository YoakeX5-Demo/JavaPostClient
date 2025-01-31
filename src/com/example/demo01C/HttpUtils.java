package com.example.demo01C;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import java.util.HashMap;

public class HttpUtils {
    public static String sendPostWithJson(String url, String jsonStr, HashMap<String,String> headers) {
        // 返回的结果
        String jsonResult = "";
        try {
            HttpClient client = new HttpClient();
            // 连接超时
            client.getHttpConnectionManager().getParams().setConnectionTimeout(3*1000);
            // 读取数据超时
            client.getHttpConnectionManager().getParams().setSoTimeout(3*60*1000);
            client.getParams().setContentCharset("UTF-8");
            PostMethod postMethod = new PostMethod(url);

            postMethod.setRequestHeader("content-type", headers.get("content-type"));

            // 非空
            if (null != jsonStr && !"".equals(jsonStr)) {
                StringRequestEntity requestEntity = new StringRequestEntity(jsonStr, headers.get("content-type"), "UTF-8");
                postMethod.setRequestEntity(requestEntity);
            }
            int status = client.executeMethod(postMethod);
            if (status == HttpStatus.SC_OK) {
                jsonResult = postMethod.getResponseBodyAsString();
            } else {
                throw new RuntimeException("接口连接失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException("接口连接失败！");
        }
        return jsonResult;
    }
}
