package com.example.fenlei.model;

import com.example.fenlei.url.RightUrl;
import com.example.fenlei.utils.RetrofitManager;
import okhttp3.OkHttpClient;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RightDataModel implements IRightDataModel {
    @Override
    public void getRightData(String gc_id, Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder().build();
        RetrofitManager.getInstance("http://169.254.194.209/mobile/",client).setCreate(RightUrl.class).getRight(gc_id).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
