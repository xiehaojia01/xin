package com.example.week2.view;

import com.example.week2.bean.XiangBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/9.
 */

public interface IXQDataView {
    public void xqShow(List<XiangBean.SkuBean> xqlist);
    public int getGoods_id();
}
