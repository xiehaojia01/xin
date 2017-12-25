package com.example.week02.presenter;

import android.util.Log;
import com.example.week02.bean.Sy_bean;
import com.example.week02.model.SYDataModel;
import com.example.week02.view.ISYDataView;
import java.util.ArrayList;
import java.util.List;
import rx.Observer;

public class SYPresenter {
    SYDataModel model;
    ISYDataView view;
    List<Sy_bean.GoodsListBean> sylist=new ArrayList<>();
    public SYPresenter(ISYDataView view) {
        this.view = view;
        model=new SYDataModel();
    }
    public void spData(){
        model.getSYData(new Observer<Sy_bean>(){

            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.i("111111p","onError");
            }
            @Override
            public void onNext(Sy_bean sy_bean) {
                sylist.addAll(sy_bean.getGoods_list());
                view.showSYData(sylist);
            }
        });
    }
}
