package com.bawei.chenyu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawei.chenyu.adapter.MyAdapter;
import com.bawei.chenyu.base.BaseActivity;
import com.bawei.chenyu.bean.Zhoukaobean;
import com.bawei.chenyu.presenter.Presenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends BaseActivity {
   private ListView listView;
   private MyAdapter adapter;
   private List<Zhoukaobean> list;
   private Presenter presenter;
    //布局
    @Override
    public int initlayout() {
        return R.layout.activity_main;
    }
    //资源id
    @Override
    public void initfind() {
      listView=findViewById(R.id.listview);
      presenter=new Presenter(this);
      presenter.setshow();
    }
    //数据
    @Override
    public void initdata() {

    }
    public void getshow(final String data){
        //开启线程
      runOnUiThread(new Runnable() {
          @Override
          public void run() {
              //进行解析
              Gson gson=new Gson();
              //开始解析
              Zhoukaobean zhoukaobean = gson.fromJson(data, Zhoukaobean.class);
              List<Zhoukaobean.ItemsBean> list=zhoukaobean.getItems();
              //设置适配器
              adapter=new MyAdapter(MainActivity.this,list);
              listView.setAdapter(adapter);
          }
      });
    }
}
