package com.example.gouwuche.newWork;

import com.example.gouwuche.bean.CartBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServesApi {
    //查询购物车
    @GET(UrlUtils.TAG)
    Flowable<CartBean> tags(@Query("source") String str);

    //删除购物车
    @GET(UrlUtils.DELETE)
    Flowable<CartBean> delete();

    //更新购物车购物车
    @GET(UrlUtils.GEN)
    Flowable<CartBean> GEN();
}
