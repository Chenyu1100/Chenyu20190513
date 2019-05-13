package com.bawei.chenyu.model;

import com.bawei.chenyu.MainActivity;
import com.bawei.chenyu.okhttp.Okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/*
 * 20190513  陈宇
 *
 * 继承IModel里面的方法 传给presenter进行处理
 * */
public class Model implements IModel{

    @Override
    public void getshow(String url, final ZsCallback zsCallback) {
    Okhttp.deget(url, new Callback() {
        @Override
        //失败
        public void onFailure(Call call, IOException e) {

        }

        @Override
        //成功
        public void onResponse(Call call, Response response) throws IOException {
            zsCallback.onSuccesss(response.body().string());
        }
    });
    }
}
