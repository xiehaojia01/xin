package com.example.retrofitdemo;

import com.example.retrofitdemo.bean.Bean;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetRequest_In {
    @GET("?key=71e58b5b2f930eaf1f937407acde08fe&num=10")
    Call<Bean> getCall();
}