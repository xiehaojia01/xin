package com.example.fenlei.view;

import com.example.fenlei.bean.ClassifyRight;
import java.util.List;

public interface IRightDataView {
    public void showRight(List<ClassifyRight.DatasBean.ClassListBean> rightlist);
    public String getGc_id();
}
