package com.example.demo01C;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> headers = new HashMap<>(3);
        String requestUrl = "http://localhost:8080/postjson";
        //String jsonStr = "{\"name\":\"张三\"}";
        String jsonStr = "{\"name\":\"张三\"}";
        headers.put("content-type", "application/json");
        // 发送post请求
        String resultData = HttpUtils.sendPostWithJson(requestUrl, jsonStr,headers);
        // 并接收返回结果
        System.out.println(resultData);
    }
}