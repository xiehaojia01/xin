package com.example.week1.presenter;

import android.util.Log;


import com.example.week1.bean.Data;
import com.example.week1.model.GetData;
import com.example.week1.view.IShowData;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import rx.Observer;

/**
 * Created by len on 2017/12/4.
 */

public class DataPresenter implements IDataPresenter<IShowData>{
    GetData model;
    List<Data.DataBean.DefaultGoodsListBean> listrv=new ArrayList<>();
    SoftReference<IShowData> softView;

    public DataPresenter(IShowData view) {
        attach(view);
        this.model=new GetData();
    }
    public void getDPData(){
        model.getData(new Observer<Data>(){

            @Override
            public void onCompleted() {
                Log.i("111111P","onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("111111P","onError()");
            }

            @Override
            public void onNext(Data data) {
                Log.i("111111P","onNext()");
                listrv.addAll(data.getData().getDefaultGoodsList());
                softView.get().showData(listrv);
                Log.i("111111P",listrv+"");
            }
        });
    }

    @Override
    public void attach(IShowData view) {
        softView=new SoftReference<IShowData>(view);
    }

    @Override
    public void detach() {
        softView.clear();
    }
}
