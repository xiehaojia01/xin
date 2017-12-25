package com.example.fenlei.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.fenlei.R;
import java.util.List;


public class GridAdapter extends BaseAdapter{
    List<String> list;
    Context context;

    public GridAdapter( Context context,List<String> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridHolder holder;
        if(convertView==null){
            convertView=View.inflate(context, R.layout.grid_item,null);
            holder=new GridHolder();
            holder.tv_grid=convertView.findViewById(R.id.tv_grid);
            convertView.setTag(holder);
        }else{
            holder= (GridHolder) convertView.getTag();
        }
        holder.tv_grid.setText(list.get(position));
        return convertView;
    }
    class GridHolder{
        TextView tv_grid;
    }
}
