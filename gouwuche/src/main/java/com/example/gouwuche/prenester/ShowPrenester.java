package com.example.gouwuche.prenester;

import com.example.gouwuche.bean.CartBean;
import com.example.gouwuche.model.ShowModel;
import com.example.gouwuche.newWork.IDataInter;
import com.example.gouwuche.newWork.OnNetListine;
import com.example.gouwuche.view.IMainActivity;


import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class ShowPrenester implements IDataInter<IMainActivity> {
    IMainActivity iMainActivity;
    ShowModel showModel;
    private SoftReference<IMainActivity> softReference;
    public ShowPrenester(IMainActivity iMainActivity) {
        attach(iMainActivity);
        showModel=new ShowModel();
    }
    public void getshow(){
        showModel.getshow(new OnNetListine<CartBean>() {
            @Override
            public void OnSucc(CartBean cartBean) {
                List<CartBean.DataBean> data = cartBean.getData();
                List<List<CartBean.DataBean.ListBean>> childlist=new ArrayList<List<CartBean.DataBean.ListBean>>();
                for (int i = 0; i <data.size() ; i++) {
                    List<CartBean.DataBean.ListBean> list = data.get(i).getList();
                    childlist.add(list);
                }
               softReference.get().show(data,childlist);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }

    @Override
    public void attach(IMainActivity view) {
        softReference=new SoftReference<IMainActivity>(view);
    }

    @Override
    public void detach() {
        softReference.clear();
    }
}
