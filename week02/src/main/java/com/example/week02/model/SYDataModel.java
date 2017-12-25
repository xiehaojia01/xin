package com.example.week02.model;

import com.example.week02.utils.RetrofitManager;
import com.example.week02.utils.Url;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SYDataModel implements ISYDataModel{

    @Override
    public void getSYData(Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://apiv3.yangkeduo.com/",client)
                .setCreate(Url.class)
                .getSy().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(observer);
    }
}
