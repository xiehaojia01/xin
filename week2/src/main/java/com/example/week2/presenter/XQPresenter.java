package com.example.week2.presenter;

import com.example.week2.bean.XiangBean;
import com.example.week2.model.XQDataModel;
import com.example.week2.view.IXQDataView;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by lenovo on 2017/12/9.
 */

public class XQPresenter {
    XQDataModel model;
    IXQDataView view;
    List<XiangBean.SkuBean> xqlist=new ArrayList<>();

    public XQPresenter(IXQDataView view) {
        this.view = view;
        model=new XQDataModel();
    }
    public void getXQData(){
        int goods_id=view.getGoods_id();
        model.getXQData(goods_id,new Observer<XiangBean>(){

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(XiangBean xiangBean) {
                xqlist.addAll(xiangBean.getSku());
                view.xqShow(xqlist);
            }
        });
    }
}
