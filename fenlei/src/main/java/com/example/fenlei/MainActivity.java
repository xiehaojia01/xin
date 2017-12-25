package com.example.fenlei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.fenlei.adapter.LeftAdapter;
import com.example.fenlei.adapter.RightAdapter;
import com.example.fenlei.bean.ClassifyLeft;
import com.example.fenlei.bean.ClassifyRight;
import com.example.fenlei.presenter.LeftPresenter;
import com.example.fenlei.presenter.RightPresenter;
import com.example.fenlei.view.ILeftDataView;
import com.example.fenlei.view.IRightDataView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ILeftDataView, IRightDataView {
    LeftAdapter leftAdapter;
    RightAdapter rightAdapter;
    List<ClassifyRight.DatasBean.ClassListBean> rightlist=new ArrayList<>();
    List<ClassifyLeft.DatasBean.ClassListBean> leftlist = new ArrayList<>();
    String gc_id ="1";
    private RecyclerView mRvLeft;
    private RecyclerView mRvRight;
    LeftPresenter leftPresenter;
    RightPresenter rightPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        leftPresenter=new LeftPresenter(this);
        showLeft(leftlist);
        leftPresenter.lpGetData();
        rightPresenter=new RightPresenter(this);
        showRight(rightlist);
        rightPresenter.rpGetData();

    }

    @Override
    public void showLeft(final List<ClassifyLeft.DatasBean.ClassListBean> leftlist) {
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRvLeft.setLayoutManager(manager);
        leftAdapter=new LeftAdapter(this,leftlist);
        mRvLeft.setAdapter(leftAdapter);
        leftAdapter.setOnItemClick(new LeftAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                gc_id=leftlist.get(position).getGc_id();
                rightPresenter.rpGetData();
                rightAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showRight(List<ClassifyRight.DatasBean.ClassListBean> rightlist) {
        LinearLayoutManager manager=new LinearLayoutManager(this);
        mRvRight.setLayoutManager(manager);
        rightAdapter=new RightAdapter(this,rightlist);
        mRvRight.setAdapter(rightAdapter);
    }

    @Override
    public String getGc_id() {
        return gc_id;
    }

    private void initView() {
        mRvLeft = (RecyclerView) findViewById(R.id.rv_left);
        mRvRight = (RecyclerView) findViewById(R.id.rv_right);
    }
}
