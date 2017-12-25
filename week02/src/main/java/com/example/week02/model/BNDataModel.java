package com.example.week02.model;


import com.example.week02.utils.RetrofitManager;
import com.example.week02.utils.Url;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BNDataModel implements IBNDataModel{

    @Override
    public void getBNData(String goods_id,Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv4.yangkeduo.com/",client)
                .setCreate(Url.class).getPj(goods_id).observeOn(AndroidSchedulers
                .mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
