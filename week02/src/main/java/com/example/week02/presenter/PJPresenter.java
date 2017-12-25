package com.example.week02.presenter;

import android.util.Log;
import com.example.week02.bean.Pj_Bean;
import com.example.week02.model.PJDataModel;
import com.example.week02.view.IPJDataView;
import java.util.ArrayList;
import java.util.List;
import rx.Observer;

public class PJPresenter {
    PJDataModel model;
    IPJDataView view;
    List<Pj_Bean.DataBean> pjlist=new ArrayList<>();

    public PJPresenter(IPJDataView view) {
        this.view = view;
        model=new PJDataModel();
    }
    public void ppData(){
        String id=view.getId();
        model.getPJData(id,new Observer<Pj_Bean>(){

            @Override
            public void onCompleted() {
            }
            @Override
            public void onError(Throwable e) {
                Log.i("111111p","onError");
            }
            @Override
            public void onNext(Pj_Bean pj_bean) {
                pjlist.addAll(pj_bean.getData());
                view.pjShowData(pjlist);
            }
        });
    }
}
