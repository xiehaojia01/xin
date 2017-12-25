package com.example.sousuo.model;

/**
 * Created by lenovo on 2017/12/13.
 */

import com.example.sousuo.bean.ShopBean;

import rx.Observer;

public  interface Imodel {
    //将观察者传（bean）进去
    public void shuju(Observer<ShopBean> observer,String name);
}