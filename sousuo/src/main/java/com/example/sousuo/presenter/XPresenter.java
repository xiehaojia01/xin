package com.example.sousuo.presenter;

import android.util.Log;

import com.example.sousuo.bean.XiangBean;
import com.example.sousuo.model.XiangModel;
import com.example.sousuo.view.Xview;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;

public class XPresenter {
    XiangModel xmodel;
    Xview xview;
    //List<XiangBean.DataBean> xlist=new ArrayList<>();

    public XPresenter(Xview view) {
        this.xview = view;
        xmodel=new XiangModel();
    }
    public void ppData(String goods_id){

        xmodel.getXData(goods_id,new Observer<XiangBean>(){
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.i("111111banner","onError......");
            }
            @Override
            public void onNext(XiangBean xiangBean) {
               // xlist.add(xiangBean.getData());
                xview.showData(xiangBean);
               // Log.i("111111banner","onNext"+xlist);
            }
        });
    }
}
