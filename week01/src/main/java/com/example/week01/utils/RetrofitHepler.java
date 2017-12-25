package com.example.week01.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/2.
 */

public class RetrofitHepler {

        public  static OkHttpClient okHttpClient;
        public static ServerApi serverApi;

         static
         {
             initOkHttpClent();
         }

         //初始化OkHttpClient
         public  static void initOkHttpClent()
         {
             if(okHttpClient==null)
             {
                 synchronized (RetrofitHepler.class)
                 {
                     if(okHttpClient==null)
                     {
                         okHttpClient=new OkHttpClient();
                     }
                 }
             }
         }


         public  static ServerApi getServerApi()
         {
             if(serverApi==null)
             {
                 synchronized (ServerApi.class)
                 {
                     if(serverApi==null)
                     {
                         serverApi=OnCreatApi(ServerApi.class,UrlApi.HOST_URL);
                     }
                 }
             }
             return serverApi;
         }

         //定义方法初始化ServerApi
         public  static<T> T OnCreatApi(Class<T> tClass,String url)
         {
             Retrofit retrofit=new Retrofit
                     .Builder().baseUrl(url)
                     .addConverterFactory(GsonConverterFactory.create())
                     .build();
             return retrofit.create(tClass);
         }
 }
