package com.example.huajie.myapplication.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by HuaJie on 2017/10/24.
 */

public class Util {

    public static String syncRequest(String appSeverUrl){
        try {
            URL url = new URL(appSeverUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(10000);
            if(httpURLConnection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                return null;
            }
            int length = httpURLConnection.getContentLength();
            if(length<=0){
                length = 16*1024;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            byte[] data = new byte[length];
            int read = inputStream.read(data);
            inputStream.close();
            if(read<=0){
                return null;
            }
            return new String(data,0,read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
