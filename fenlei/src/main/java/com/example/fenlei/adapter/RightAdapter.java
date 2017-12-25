package com.example.fenlei.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.example.fenlei.R;
import com.example.fenlei.bean.ClassifyRight;

import java.util.ArrayList;
import java.util.List;


public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<ClassifyRight.DatasBean.ClassListBean> rightlist;

    public RightAdapter(Context context, List<ClassifyRight.DatasBean.ClassListBean> rightlist) {
        this.context = context;
        this.rightlist = rightlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(context, R.layout.right_item,null);
        return new RightHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RightHolder)holder).tv_right_top.setText(rightlist.get(position).getGc_name());
        List<String> list=new ArrayList<>();
        for(int i=0;i<rightlist.get(position).getChild().size();i++){
          list.add(rightlist.get(position).getChild().get(i).getGc_name());
        }
        GridAdapter gridAdapter=new GridAdapter(context,list);
        ((RightHolder)holder).gv_right.setAdapter(gridAdapter);
    }

    @Override
    public int getItemCount() {
        return rightlist!=null?rightlist.size():0;
    }
    class RightHolder extends RecyclerView.ViewHolder{
        TextView tv_right_top;
        GridView gv_right;
        public RightHolder(View itemView) {
            super(itemView);
            tv_right_top=itemView.findViewById(R.id.tv_right_top);
            gv_right=itemView.findViewById(R.id.gv_right);
        }
    }
}
