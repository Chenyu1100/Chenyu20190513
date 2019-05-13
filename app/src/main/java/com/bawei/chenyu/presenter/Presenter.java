package com.bawei.chenyu.presenter;
/*
 * 20190513  陈宇
 *
 * 继承Ipresenter的方法
 * */

import com.bawei.chenyu.MainActivity;
import com.bawei.chenyu.model.IModel;
import com.bawei.chenyu.model.Model;

public class Presenter implements IPresenter {
    private String path="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    private final Model model;
    private MainActivity mainActivity;
    public Presenter(MainActivity mainActivity){
        this.mainActivity=mainActivity;
        model=new Model();
    }

    @Override
    public void setshow() {
        model.getshow(path, new IModel.ZsCallback() {
            @Override
            public void onSuccesss(String data) {
                //成功的话在MainActivity里创建 这个显示方法
                mainActivity.getshow(data);
            }
        });
    }
}
