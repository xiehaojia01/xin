package com.example.week02.view;

import com.example.week02.bean.Bn_Bean;
import java.util.List;

public interface IBNDataView {
    public void bnShowData(List<Bn_Bean.SkuBean> bnlist);
    public String getBnId();
}
