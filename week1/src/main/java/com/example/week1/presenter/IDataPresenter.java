package com.example.week1.presenter;


import com.example.week1.view.IShowData;

/**
 * Created by len on 2017/12/4.
 */

public interface IDataPresenter<T extends IShowData>{
    public void attach(T view);
    public void detach();
}
