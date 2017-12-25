package com.example.gouwuche;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.gouwuche.MyEvenBus.MessageEvent;
import com.example.gouwuche.MyEvenBus.PriceAndCountEvent;
import com.example.gouwuche.adapter.UserAdapter;
import com.example.gouwuche.bean.CartBean;
import com.example.gouwuche.prenester.ShowPrenester;
import com.example.gouwuche.view.IMainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

public class MainActivity  extends AppCompatActivity implements IMainActivity {

    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    /**
     * 0
     */
    private TextView mTvPrice;
    /**
     * 去支付(0)
     */
    private TextView mTvNum;
    private UserAdapter userAdapter;
    private ShowPrenester showPrenester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initView();
        showPrenester = new ShowPrenester(this);
        showPrenester.getshow();
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
    }

    @Override
    public void show(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist) {
        userAdapter = new UserAdapter(this, grouplist, childlist);
        mElv.setAdapter(userAdapter);
        mElv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < grouplist.size(); i++) {
            mElv.expandGroup(i);
        }

    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) findViewById(R.id.checkbox2);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvNum = (TextView) findViewById(R.id.tv_num);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        showPrenester.detach();
    }
    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }


    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("去支付(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }
}