package com.example.week01.utils;


import com.example.week01.bean.LogBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/12/2.
 */

public interface ServerApi {

      @GET(UrlApi.URL)
     Call<LogBean> logBeanCall();
}
