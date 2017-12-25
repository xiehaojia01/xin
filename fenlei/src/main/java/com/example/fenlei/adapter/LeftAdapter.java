package com.example.fenlei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fenlei.R;
import com.example.fenlei.bean.ClassifyLeft;

import java.util.List;


public class LeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ClassifyLeft.DatasBean.ClassListBean> leftlist;
    OnItemClickListener listener;

    public LeftAdapter(Context context, List<ClassifyLeft.DatasBean.ClassListBean> leftlist) {
        this.context = context;
        this.leftlist = leftlist;
    }

    public interface OnItemClickListener{
        public void OnItemClick(View view, int position);
    }

    public void setOnItemClick(OnItemClickListener listener){
        this.listener=listener;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.left_item,null);
        return new LeftHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((LeftHolder)holder).tv_left.setText(leftlist.get(position).getGc_name());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                 listener.OnItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return leftlist!=null?leftlist.size():0;
    }

    class LeftHolder extends RecyclerView.ViewHolder{
        TextView tv_left;
        public LeftHolder(View itemView) {
            super(itemView);
            tv_left=itemView.findViewById(R.id.tv_left);
        }
    }
}
