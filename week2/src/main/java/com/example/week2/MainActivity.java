package com.example.week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.week2.adapter.Myadapter;
import com.example.week2.bean.MainBean;
import com.example.week2.presenter.Mpresenter;
import com.example.week2.view.Mview;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Mview {

    @BindView(R.id.recycle)
    RecyclerView rv;

    Mpresenter pp;
    Myadapter rvadapter;
    MainBean mainBean;
    private List<MainBean.GoodsListBean> goods_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pp=new Mpresenter(this,this);
        pp.getData();



    }

    @Override
    public void ShowView(final MainBean mbean) {

        GridLayoutManager manager=new GridLayoutManager(this,2);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

        rvadapter=new Myadapter(this,mbean);
        rvadapter.setOnItemClick(new Myadapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {

                MainBean.GoodsListBean goodsListBean=mbean.getGoods_list().get(position);

                int num1 = goodsListBean.getGoods_id();
                String name=goodsListBean.getGoods_name();
                int price=goodsListBean.getNormal_price();

                Intent intent = new Intent();
                intent.putExtra("one", num1);
                intent.putExtra("name", name);
                intent.putExtra("price", price);

                intent.setClass(MainActivity.this, ShopActivity.class);
                startActivity(intent);
            }
        });
        rv.setAdapter(rvadapter);

    }
}
