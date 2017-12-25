package com.example.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.retrofitdemo.adapter.Myadapter;
import com.example.retrofitdemo.bean.Bean;
import com.example.retrofitdemo.persenter.Persenter;
import com.example.retrofitdemo.view.Iview;
import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.rv)
    RecyclerView rv;

    Persenter pp;
    Myadapter rvadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        pp=new Persenter(this,this);
        pp.getData();



    }

    @Override
    public void ShowView(Bean bean) {

        LinearLayoutManager manager=new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        rvadapter=new Myadapter(this,bean);
        rv.setAdapter(rvadapter);

    }
}