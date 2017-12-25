package com.example.retrofitdemo.persenter;

import android.content.Context;
import android.util.Log;

import com.example.retrofitdemo.bean.Bean;
import com.example.retrofitdemo.model.Model;
import com.example.retrofitdemo.view.Iview;

import rx.Observer;

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
    public void getData(){
        mm.shuju(new Observer<Bean>() {
            @Override
            public void onCompleted() {
                Log.i("1111111","onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("1111111","onError");
            }

            //将bean的值让V层接受
            @Override
            public void onNext(Bean bean) {
                Log.i("1111111",bean+"");
                vv.ShowView(bean);
            }
        });
    }


}