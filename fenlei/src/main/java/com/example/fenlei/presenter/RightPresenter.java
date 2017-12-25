package com.example.fenlei.presenter;

import com.example.fenlei.bean.ClassifyRight;
import com.example.fenlei.model.RightDataModel;
import com.example.fenlei.view.IRightDataView;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;

public class RightPresenter {
    RightDataModel model;
    IRightDataView view;
    List<ClassifyRight.DatasBean.ClassListBean> rightlist=new ArrayList<>();
    public RightPresenter(IRightDataView view) {
        this.view = view;
        model=new RightDataModel();
    }
    public void rpGetData(){
        String gc_id=view.getGc_id();
       model.getRightData(gc_id,new Observer<ClassifyRight>(){
           @Override
           public void onCompleted() {
           }
           @Override
           public void onError(Throwable e) {
           }
           @Override
           public void onNext(ClassifyRight classifyRight) {
               rightlist.clear();
               rightlist.addAll(classifyRight.getDatas().getClass_list());
               view.showRight(rightlist);
           }
       });
    }
}
