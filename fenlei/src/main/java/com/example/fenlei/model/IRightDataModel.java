package com.example.fenlei.model;

import rx.Observer;

public interface IRightDataModel {
    public void getRightData(String gc_id, Observer observer);
}
