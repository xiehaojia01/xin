package com.example.newfragment;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.newfragment.fragment.fragment01;
import com.example.newfragment.fragment.fragment02;
import com.example.newfragment.fragment.fragment03;
import com.example.newfragment.fragment.fragment04;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {
    private BottomTabBar mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mb=(BottomTabBar)findViewById(R.id.bottom_tab_bar);

        mb.init(getSupportFragmentManager())
                .setImgSize(0,0)
                .setFontSize(10)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.ic_launcher_round, fragment01.class)
                .addTabItem("分类",R.drawable.ic_launcher_round, fragment02.class)
                .addTabItem("购物车",R.drawable.ic_launcher_round, fragment03.class)
                .addTabItem("我的",R.drawable.ic_launcher_round, fragment04.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });

    }
}
