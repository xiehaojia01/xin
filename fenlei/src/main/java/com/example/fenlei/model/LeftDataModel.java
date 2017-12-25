package com.example.fenlei.model;

import com.example.fenlei.url.LeftUrl;
import com.example.fenlei.utils.RetrofitManager;

import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LeftDataModel implements ILeftDataModel {
    @Override
    public void getLeftData(Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://169.254.194.209/mobile/",client).setCreate(LeftUrl.class).getLeft().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
