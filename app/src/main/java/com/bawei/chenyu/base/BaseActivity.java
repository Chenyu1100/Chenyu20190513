package com.bawei.chenyu.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
/*
* 20190513    陈宇
*
* 抽取基类
* */
public abstract class BaseActivity extends AppCompatActivity {
    //布局
    public abstract int initlayout();
    //id
    public abstract void initfind();
    //数据
    public abstract void initdata();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayout());
        initfind();
        initdata();
    }
}
