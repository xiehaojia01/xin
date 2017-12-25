package com.example.week01.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week01.R;
import com.example.week01.bean.UserBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Administrator on 2017/12/2.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

     List<UserBean> list;
     Context context;

    public MyAdapter(List<UserBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        //加载视图
        View view=View.inflate(context, R.layout.iten_rec,null);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        SimpleDraweeView img;
       TextView name;
       TextView msg;
       TextView time;
        public MyViewHolder(View itemView) {
            super(itemView);
            //初始化控件
            img=itemView.findViewById(R.id.sdv);
            name=itemView.findViewById(R.id.name);
            msg=itemView.findViewById(R.id.msg);
            time=itemView.findViewById(R.id.times);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserBean resultsBean=list.get(position);
         MyViewHolder myViewHolder= (MyViewHolder) holder;

         myViewHolder.name.setText(resultsBean.getType());
         myViewHolder.msg.setText(resultsBean.getDes());
         myViewHolder.time.setText(resultsBean.getPublishedAt()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
