package com.example.fenlei.url;

import com.example.fenlei.bean.ClassifyLeft;
import retrofit2.http.GET;
import rx.Observable;

public interface LeftUrl {
    @GET("index.php?act=goods_class")
    Observable<ClassifyLeft> getLeft();
}
