package com.example.gouwuche.view;

import com.example.gouwuche.bean.CartBean;

import java.util.List;


public interface IMainActivity {
    public void show(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist);
}
