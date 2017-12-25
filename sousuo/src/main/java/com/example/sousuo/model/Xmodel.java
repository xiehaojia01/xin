package com.example.sousuo.model;

/**
 * Created by lenovo on 2017/12/13.
 */

import com.example.sousuo.bean.ShopBean;
import com.example.sousuo.bean.XiangBean;

import rx.Observer;

public  interface Xmodel {
    //将观察者传（bean）进去
    public void getXData(String goods_id, Observer observer);
}