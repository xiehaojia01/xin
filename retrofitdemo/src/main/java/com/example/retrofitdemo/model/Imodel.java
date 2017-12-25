package com.example.retrofitdemo.model;


import com.example.retrofitdemo.bean.Bean;

import rx.Observer;

public interface Imodel {
    //将观察者传（bean）进去
    public void shuju(Observer<Bean> observer);
}