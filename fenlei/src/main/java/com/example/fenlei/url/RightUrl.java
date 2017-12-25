package com.example.fenlei.url;

import com.example.fenlei.bean.ClassifyRight;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RightUrl {
    @GET("index.php?act=goods_class&op=get_child_all&")
    Observable<ClassifyRight> getRight(@Query("gc_id") String gc_id);
}
