package com.example.week2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week2.bean.MainBean;
import com.example.week2.bean.ShopBean;
import com.example.week2.bean.XiangBean;
import com.example.week2.presenter.Mpresenter;
import com.example.week2.presenter.XQPresenter;
import com.example.week2.view.IXQDataView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/12/9.
 */

public class ShopActivity extends AppCompatActivity implements IXQDataView{


    private XiangBean shopbean;
    private SimpleDraweeView sdv;
    private TextView shop_name;
    private TextView shop_desc;
    int goods_id;
    XQPresenter xqPresenter;
    List<XiangBean.SkuBean> xqlist;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);
        xqlist=new ArrayList<>();

        sdv= (SimpleDraweeView) findViewById(R.id.sdv);
        shop_name=(TextView)findViewById(R.id.sname);
        shop_desc=(TextView)findViewById(R.id.sdesc);
        //获得id
        Intent intent = getIntent();
        goods_id = intent.getIntExtra("one",0);

        name=intent.getStringExtra("name");
        shop_name.setText(name);



        xqPresenter=new XQPresenter(this);
        xqPresenter.getXQData();

    }

    @Override
    public void xqShow(List<XiangBean.SkuBean> xqlist) {

    }

    @Override
    public int getGoods_id() {
        return goods_id;
    }
}
