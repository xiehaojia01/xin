package com.example.week1;

import com.example.week1.bean.Data;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by len on 2017/12/4.
 */

public interface UserUrl {
    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<Data> getCall();
}
