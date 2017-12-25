package com.example.fenlei.presenter;

import android.util.Log;

import com.example.fenlei.bean.ClassifyLeft;
import com.example.fenlei.model.LeftDataModel;
import com.example.fenlei.view.ILeftDataView;

import java.util.ArrayList;
import java.util.List;
import rx.Observer;

public class LeftPresenter {
    LeftDataModel model;
    ILeftDataView view;
    List<ClassifyLeft.DatasBean.ClassListBean> leftlist=new ArrayList<>();
    public LeftPresenter(ILeftDataView view) {
        this.view = view;
        model=new LeftDataModel();
    }
    public void lpGetData(){
        model.getLeftData(new Observer<ClassifyLeft>(){
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.i("111111","onError");
            }
            @Override
            public void onNext(ClassifyLeft classifyLeft) {
                leftlist.addAll(classifyLeft.getDatas().getClass_list());
                view.showLeft(leftlist);
                Log.i("111111","onNext"+leftlist);
            }
        });
    }
}
