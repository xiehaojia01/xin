package com.example.week1.model;
import com.example.week1.LoggingInterceptor;
import com.example.week1.UserUrl;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by len on 2017/12/4.
 */

public class GetData implements TGetData {

    @Override
    public void getData(Observer observer) {
        OkHttpClient client=new OkHttpClient.Builder()
                .addNetworkInterceptor(new LoggingInterceptor())
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://result.eolinker.com/")
                .client(client)
                .build();
        UserUrl userUrl=retrofit.create(UserUrl.class);
        userUrl.getCall().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer);
    }
}
