package com.example.sousuo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.sousuo.bean.ShopBean;
import com.example.sousuo.bean.XiangBean;
import com.example.sousuo.presenter.XPresenter;
import com.example.sousuo.view.Xview;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2017/12/14.
 */

public class XiangqingActivity extends AppCompatActivity implements Xview {
    List<ShopBean.DataBean> mlist = new ArrayList<>();
    List<XiangBean.DataBean> xlist = new ArrayList<>();

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.images_shop)
    SimpleDraweeView imagesShop;


    private String pid;
    XiangBean ba;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);
        pid = intent.getStringExtra("pid");

        XPresenter xPresenter = new XPresenter(this);
        xPresenter.ppData(pid);
    }

    @Override
    public String getxId() {
        return pid;
    }

    @Override
    public void showData(XiangBean bean) {
        ba=bean;
        String images = bean.getData().getImages();
        String[] split = images.split("\\|");
        DraweeController con = Fresco.newDraweeControllerBuilder()
                .setUri(split[0])
                .build();
        imagesShop.setController(con);
        name.setText(bean.getData().getTitle());
    }
}
