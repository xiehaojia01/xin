package com.example.week02.presenter;

import android.util.Log;
import com.example.week02.bean.Bn_Bean;
import com.example.week02.model.BNDataModel;
import com.example.week02.view.IBNDataView;
import java.util.ArrayList;
import java.util.List;
import rx.Observer;

public class BNPresenter {
    BNDataModel model;
    IBNDataView view;
    List<Bn_Bean.SkuBean> bnlist=new ArrayList<>();
    public BNPresenter(IBNDataView view) {
        this.view = view;
        model=new BNDataModel();
    }
    public void ppData(){
        String goods_id=view.getBnId();
        model.getBNData(goods_id,new Observer<Bn_Bean>(){
            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.i("111111banner","onError......");
            }
            @Override
            public void onNext(Bn_Bean bn_bean) {
                bnlist.addAll(bn_bean.getSku());
                view.bnShowData(bnlist);
                Log.i("111111banner","onNext"+bnlist);
            }
        });
    }
}
