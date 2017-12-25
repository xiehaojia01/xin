package com.example.week2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.week2.R;
import com.example.week2.bean.MainBean;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by lenovo on 2017/12/9.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {


    Context context;
    MainBean bean;

    OnItemClickListener listener;

    public Myadapter(Context context, MainBean mbean) {
        this.context = context;
        this.bean = mbean;
    }
    public interface OnItemClickListener{
        public void OnItemClick(View view,int position);
    }

    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv1.setText(bean.getGoods_list().get(position).getGoods_name());
        holder.tv2.setText(""+bean.getGoods_list().get(position).getNormal_price());
        DraweeController dc = Fresco.newDraweeControllerBuilder()
                .setUri(bean.getGoods_list().get(position).getImage_url())
                .setAutoPlayAnimations(true)
                .build();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.OnItemClick(v,position);
                }
            }
        });
        holder.img.setController(dc);
    }

    @Override
    public int getItemCount() {
        return bean.getGoods_list().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView img;
        private final TextView tv1,tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            img =  itemView.findViewById(R.id.mimg);
            tv1 = itemView.findViewById(R.id.mtitle);
            tv2 = itemView.findViewById(R.id.mprice);

        }
    }

}