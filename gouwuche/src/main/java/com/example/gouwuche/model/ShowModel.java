package com.example.gouwuche.model;

import com.example.gouwuche.bean.CartBean;
import com.example.gouwuche.newWork.OnNetListine;
import com.example.gouwuche.newWork.RetrofitHolder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class ShowModel {
    public void getshow(final OnNetListine<CartBean> onNetListine){
        RetrofitHolder.getApi().tags("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        onNetListine.OnSucc(cartBean);
                    }
                });

    }
}
