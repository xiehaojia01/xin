package com.example.week02.model;
import rx.Observer;

public interface IBNDataModel {
    public void getBNData(String goods_id, Observer observer);
}
