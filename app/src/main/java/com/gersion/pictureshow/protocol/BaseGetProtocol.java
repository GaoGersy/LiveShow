package com.gersion.pictureshow.protocol;

import com.google.gson.Gson;

import android.os.Build;
import android.os.Handler;

import com.orhanobut.logger.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @作者 Gersy
 * @版本
 * @包名 com.heima.jdmall.protocol
 * @待完成
 * @创建时间 2016/8/29
 * @功能描述 TODO
 * @更新人 $
 * @更新时间 $
 * @更新版本 $
 */
public class BaseGetProtocol {

    public static final int STATE_LOADING = 0;//加载中
    public static final int STATE_ERROR = 1;//错误
    public static final int STATE_EMPTY = 2;//空
    public static final int STATE_SUCCESS = 3;//成功
    private static final long userfulTime = 5 * 60 * 1000;
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");//mdiatype 这个需要和服务端保持一致
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");//mdiatype 这个需要和服务端保持一致
    private OkHttpClient mOkHttpClient;//okHttpClient 实例
    private Handler okHttpHandler;//全局处理子线程和M主线程通信
    private Request.Builder mBuilder;
    private String mCacheKey;

    private static BaseGetProtocol mBaseGetProtocol;
    private OkHttpClient mMOkHttpClient;

    private BaseGetProtocol() {
        mBuilder = addHeaders();
        mOkHttpClient =  new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static BaseGetProtocol getInstance(){
        if (mBaseGetProtocol==null){
            synchronized (BaseGetProtocol.class){
                if (mBaseGetProtocol == null){
                    mBaseGetProtocol = new BaseGetProtocol();
                }
            }
        }
        return mBaseGetProtocol;
    }

    //=============================================================

    /**
     * okHttp get同步请求
     *
     * @param Url Get请求全路径地址
     * @param paramsMap 请求参数
     */
    public String requestGetBySyn(String Url, HashMap<String, String> paramsMap){
        StringBuilder tempParams = new StringBuilder();
        //处理参数
        int pos = 0;
        for (String key : paramsMap.keySet()) {
            if (pos > 0) {
                tempParams.append("&");
            }
            //对参数进行URLEncoder
            try {
                tempParams.append(String.format("%s=%s", key, URLEncoder.encode(paramsMap.get(key), "utf-8")));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            pos++;
        }
        //补全请求地址
        String requestUrl = String.format("%s?%s", Url, tempParams.toString());
        //          创建一个请求
        Request request = mBuilder.url(requestUrl).build();
        //创建一个Call
        Call call = mOkHttpClient.newCall(request);
        //执行请求
        Response response = null;
        try {
            response = call.execute();

        if (response.isSuccessful()) {
            String string = null;
            try {
                string = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (!string.contains("error")) {
//                writeData2Disk(string);
            }
            return string;
        } else {

            return null;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 统一为请求添加头信息
     */
    private Request.Builder addHeaders() {
        mBuilder = new Request.Builder()
                .addHeader("Connection", "keep-alive")
                .addHeader("platform", "2")
                .addHeader("phoneModel", Build.MODEL)
                .addHeader("systemVersion", Build.VERSION.RELEASE)
                .addHeader("appVersion", "3.2.0");

        return mBuilder;
    }
//
//    //从磁盘载入数据
//    private T loaDataFromDisk(String cacheKey) {
//        LogUtils.e("本地读取数据");
//        BufferedReader br;
//        File file = new File(FileUtils.getDir("cache"), cacheKey);
//        if (file.exists()) {
//            try {
//                br = new BufferedReader(new FileReader(file));
//                String firstLine = br.readLine();
//                long insertTime = Long.parseLong(firstLine);
//                if (SystemClock.currentThreadTimeMillis() - insertTime < userfulTime) {
//                    String json = br.readLine();
//                    return parseJson(json, new Gson());
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    //写入缓存到本地存储
//    private void writeData2Disk(String json) {
//        String path = FileUtils.getDir("json");
//        BufferedWriter bw = null;
//        try {
//            File file = new File(path, mCacheKey);
//            bw = new BufferedWriter(new FileWriter(file));
//            bw.write(SystemClock.currentThreadTimeMillis() + "");
//            bw.newLine();
//            bw.write(json);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.close(bw);
//        }
//    }
//
//    public abstract T parseJson(String json, Gson gson);

}
