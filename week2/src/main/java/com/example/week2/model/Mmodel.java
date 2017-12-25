package com.example.week2.model;

import com.example.week2.bean.MainBean;

import rx.Observer;

/**
 * Created by lenovo on 2017/12/9.
 */

public interface Mmodel {
    public void shuju(Observer<MainBean> observer);
}
