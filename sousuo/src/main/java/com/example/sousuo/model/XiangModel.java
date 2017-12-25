package com.example.sousuo.model;

import com.example.sousuo.GetRequest_In;
import com.example.sousuo.RetrofitManager;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class XiangModel implements Xmodel{


    @Override
    public void getXData(String goods_id, Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://120.27.23.105/product/",client)
                .setCreate(GetRequest_In.class).getxiang(goods_id,"android").observeOn(AndroidSchedulers
                .mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
