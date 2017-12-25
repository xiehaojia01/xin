package com.example.week02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.week02.adapter.SYAdapter;
import com.example.week02.bean.Sy_bean;
import com.example.week02.presenter.SYPresenter;
import com.example.week02.view.ISYDataView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ISYDataView {
    SYAdapter syAdapter;
    private RecyclerView mRv;
    List<Sy_bean.GoodsListBean> sylist=new ArrayList<>();
    SYPresenter syPresenter;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        syPresenter=new SYPresenter(this);
        showSYData(sylist);
        syPresenter.spData();
    }
    @Override
    public void showSYData(final List<Sy_bean.GoodsListBean> sylist) {
        GridLayoutManager manager=new GridLayoutManager(this,2);
        mRv.setLayoutManager(manager);
        syAdapter=new SYAdapter(this,sylist);
        mRv.setAdapter(syAdapter);
        syAdapter.setOnItemClick(new SYAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, String name, String pic, String price) {
                id=sylist.get(position).getGoods_id()+"";
                Intent intent = new Intent(MainActivity.this,ShopActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                intent.putExtra("pic",pic);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
    }
}
