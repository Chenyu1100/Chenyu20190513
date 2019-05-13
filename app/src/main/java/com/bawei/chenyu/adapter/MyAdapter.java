package com.bawei.chenyu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chenyu.R;
import com.bawei.chenyu.bean.Zhoukaobean;
import com.bumptech.glide.Glide;

import java.util.List;
/*
* 20190513   陈宇
*
* 适配器   进行listview优化
*
* */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private List<Zhoukaobean.ItemsBean> list;

    public MyAdapter(Context context, List<Zhoukaobean.ItemsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                ViewHolder holder;
                if (convertView==null){
                     //获取资源
                    convertView=View.inflate(context, R.layout.activity_adapter,null);
                    holder=new ViewHolder();
                    holder.textView=convertView.findViewById(R.id.textview);
                    holder.imageView=convertView.findViewById(R.id.imageview);
                    convertView.setTag(holder);
                }else {
                    holder= (ViewHolder) convertView.getTag();
                }
                holder.textView.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
                break;
            case 1:
                ViewHolder1 holder1;
                if (convertView==null){

                    convertView=View.inflate(context, R.layout.activity_adapter1,null);
                    holder1=new ViewHolder1();
                    holder1.textView1=convertView.findViewById(R.id.textview1);
                    holder1.imageView1=convertView.findViewById(R.id.imageview1);
                    convertView.setTag(holder1);
                }else {
                    holder1= (ViewHolder1) convertView.getTag();
                }
                holder1.textView1.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getImage()).into(holder1.imageView1);
                break;

        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    //寄存器
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
    class ViewHolder1{
        TextView textView1;
        ImageView imageView1;
    }
}
