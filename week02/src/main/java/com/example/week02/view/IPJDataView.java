package com.example.week02.view;

import com.example.week02.bean.Pj_Bean;
import java.util.List;

public interface IPJDataView {
    public void pjShowData(List<Pj_Bean.DataBean> pjlist);
    public String getId();
}
