package com.example.week1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week1.R;
import com.example.week1.bean.Data;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by len on 2017/12/4.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Data.DataBean.DefaultGoodsListBean> listrv=new ArrayList<>();

    public MyAdapter(Context context, List<Data.DataBean.DefaultGoodsListBean> listrv) {
        this.context = context;
        this.listrv = listrv;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).sdv.setImageURI(listrv.get(position).getGoods_img());
        ((MyViewHolder)holder).tv.setText(listrv.get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return listrv!=null?listrv.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView sdv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            sdv=itemView.findViewById(R.id.sdv);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}
