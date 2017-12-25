package com.example.week2;

import com.example.week2.bean.MainBean;
import com.example.week2.bean.XiangBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface GetRequest_In {
    @GET("newlist?page=1&size=20&ver=1512745500001&pdduid=3470667255")
    Call<MainBean> getCall();

    @GET("v5/goods/{goods_id}")
    Observable<XiangBean> getXq(@Path("goods_id") int goods_id);
}