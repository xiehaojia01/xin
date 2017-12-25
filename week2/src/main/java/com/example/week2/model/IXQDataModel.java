package com.example.week2.model;

import rx.Observer;

/**
 * Created by lenovo on 2017/12/9.
 */

public interface IXQDataModel {
    public void getXQData(int goods_id, Observer observer);
}
