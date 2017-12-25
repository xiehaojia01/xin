package com.example.week01;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.week01.bean.NetBean;
import com.example.week01.fragment.fragment01;
import com.example.week01.fragment.fragment02;
import com.example.week01.fragment.fragment03;
import com.example.week01.fragment.fragment04;
import com.example.week01.fragment.fragment05;
import com.example.week01.utils.NetListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.flt)
    ViewPager mFlt;
    @BindView(R.id.shouye)
    RadioButton mShouye;
    @BindView(R.id.xf)
    RadioButton mXf;
    @BindView(R.id.sc)
    RadioButton mSc;
    @BindView(R.id.tt)
    RadioButton mTt;
    @BindView(R.id.gd)
    RadioButton mGd;

    List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments=new ArrayList<>();
        fragments.add(new fragment01());
        fragments.add(new fragment02());
        fragments.add(new fragment03());
        fragments.add(new fragment04());
        fragments.add(new fragment05());
        mFlt.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mFlt.setCurrentItem(0);
        NetBean netBean=new NetBean();
        if(!new NetListener().isNetworkConnected(MainActivity.this))
        {
            netBean.setNetzhuan("当前没网!!!");
        }
        else
        {
            netBean.setNetzhuan("网络连接中~");
        }
        EventBus.getDefault().post(netBean);
    }

    @OnClick({R.id.flt, R.id.shouye, R.id.xf, R.id.sc, R.id.tt, R.id.gd})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.flt:
                break;
            case R.id.shouye:
                mFlt.setCurrentItem(0);//显示页面
                break;
            case R.id.xf:
                mFlt.setCurrentItem(1);
                break;
            case R.id.sc:
                mFlt.setCurrentItem(2);
                break;
            case R.id.tt:
                mFlt.setCurrentItem(3);
                break;
            case R.id.gd:
                mFlt.setCurrentItem(4);
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // EventBus.getDefault().unregister(this);
    }
}
