package com.example.week2.presenter;

import android.content.Context;

import com.example.week2.bean.MainBean;
import com.example.week2.model.MainModel;
import com.example.week2.view.Mview;

import rx.Observer;

/**
 * Created by lenovo on 2017/12/9.
 */

public class Mpresenter {
    //定义属性
    Context context;
    MainModel mm;
    Mview vv;

    public Mpresenter(Context context, Mview vv) {
        this.context = context;
        mm=new MainModel();
        this.vv = vv;
    }

    //创建方法
    public void getData(){
        mm.shuju(new Observer<MainBean>() {
            @Override
            public void onCompleted() {
                System.out.println("ssssss");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("xxxxxxx");
            }

            //将bean的值让V层接受
            @Override
            public void onNext(MainBean mbean) {
                vv.ShowView(mbean);
            }
        });
    }


}
