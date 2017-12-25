package com.example.sousuo.presenter;

import android.content.Context;
import android.util.Log;

import com.example.sousuo.bean.ShopBean;
import com.example.sousuo.model.Model;
import com.example.sousuo.view.Iview;

import rx.Observer;

/**
 * Created by lenovo on 2017/12/13.
 */

public class Persenter {
    //定义属性
    Context context;
    Model mm;
    Iview vv;

    public Persenter(Context context, Iview vv) {
        this.context = context;
        this.vv = vv;
        mm=new Model();
    }
    //创建方法
    public void getData(String name){
        mm.shuju(new Observer<ShopBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("111111111111", "onError: "+e.getMessage());
            }

            //将bean的值让V层接受
            @Override
            public void onNext(ShopBean bean) {
                Log.i("1111111",""+bean.getData().size());
                vv.ShowView(bean);

            }
        },name);
    }


}

