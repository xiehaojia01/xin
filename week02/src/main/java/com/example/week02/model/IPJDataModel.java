package com.example.week02.model;
import rx.Observer;

public interface IPJDataModel {
    public void getPJData(String id, Observer observer);
}
