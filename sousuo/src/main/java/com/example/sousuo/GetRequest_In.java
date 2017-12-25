package com.example.sousuo;

import com.example.sousuo.bean.ShopBean;
import com.example.sousuo.bean.XiangBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by lenovo on 2017/12/13.
 */

public interface GetRequest_In {
    //https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本&page=1
    @GET("searchProducts?page=1")
    Call<ShopBean> getCall(@Query("keywords") String name);

    @GET("getProductDetail")
    Observable<XiangBean> getxiang(@Query("pid") String pid,@Query("source") String str);
}
