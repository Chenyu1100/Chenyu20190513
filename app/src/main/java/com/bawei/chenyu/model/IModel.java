package com.bawei.chenyu.model;
/*
* 20190513  陈宇
*
* 调取Okhttp的方法
* */
public interface IModel {
     void getshow(String url,ZsCallback zsCallback);
    interface ZsCallback{
        //成功的方法  以及显示的数据
        void onSuccesss(String data);
    }
}
