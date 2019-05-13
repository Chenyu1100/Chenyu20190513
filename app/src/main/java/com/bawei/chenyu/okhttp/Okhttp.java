package com.bawei.chenyu.okhttp;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/*
 * 20190513  陈宇
 *
 * 写展示的内容的方法   给IModel调用
 * */
public class Okhttp {
    public static void deget(String url, Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        //设置请求方式
        Request build = new Request.Builder().url(url)
                .method("GET", null).build();
        //数据传给callback
        okHttpClient.newCall(build).enqueue(callback);
    }

}
