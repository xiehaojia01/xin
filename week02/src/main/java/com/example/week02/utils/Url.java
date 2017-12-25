package com.example.week02.utils;

import com.example.week02.bean.Bn_Bean;
import com.example.week02.bean.Pj_Bean;
import com.example.week02.bean.Sy_bean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface Url {

    @GET("v5/goods/{goods_id}?pdduid=3470667255")
    Observable<Bn_Bean> getPj(@Path("goods_id") String goods_id);

    @GET("reviews/{id}?page=1&size=10&label=1&is_back=1&pdduid=3470667255")
    Observable<Pj_Bean> getPjl(@Path("id") String id);

    @GET("v5/newlist?page=1&size=20&ver=1512745500001&pdduid=3470667255")
    Observable<Sy_bean> getSy();
}
