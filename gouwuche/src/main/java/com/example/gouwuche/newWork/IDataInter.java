package com.example.gouwuche.newWork;

import com.example.gouwuche.view.IMainActivity;
//P层解绑
public interface IDataInter<T extends IMainActivity> {
    void attach(T view);
    void detach();
}
