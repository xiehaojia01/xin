package com.example.week1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week1.adapter.MyAdapter;
import com.example.week1.bean.Data;
import com.example.week1.presenter.DataPresenter;
import com.example.week1.view.IShowData;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IShowData {
    DataPresenter presenter;
    MyAdapter adapter;
    List<Data.DataBean.DefaultGoodsListBean> listrv;
    private RecyclerView mRv;
    private Banner mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listrv = new ArrayList<>();
        presenter = new DataPresenter(this);
        showData(listrv);
        presenter.getDPData();


    }

    @Override
    public void showData(List<Data.DataBean.DefaultGoodsListBean> listrv) {
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        mRv.setLayoutManager(manager);
        adapter = new MyAdapter(this, listrv);
        mRv.setAdapter(adapter);

        ArrayList<String> pic = new ArrayList<>();
        for (int i = 0; i <listrv.size() ; i++) {
            pic.add(listrv.get(i).getGoods_img());
        }

        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(pic);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mBanner = (Banner) findViewById(R.id.banner);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
