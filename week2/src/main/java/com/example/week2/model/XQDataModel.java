package com.example.week2.model;

import com.example.week2.GetRequest_In;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/9.
 */

public class XQDataModel implements IXQDataModel {
    @Override
    public void getXQData(int goods_id, Observer observer) {
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://apiv4.yangkeduo.com/")
                .build();
        GetRequest_In getRequest_in=retrofit.create(GetRequest_In.class);
        getRequest_in.getXq(goods_id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
