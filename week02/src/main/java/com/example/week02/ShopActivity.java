package com.example.week02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import com.example.week02.adapter.PJAdapter;
import com.example.week02.bean.Bn_Bean;
import com.example.week02.bean.Pj_Bean;
import com.example.week02.presenter.BNPresenter;
import com.example.week02.presenter.PJPresenter;
import com.example.week02.utils.BnImageLoader;
import com.example.week02.view.IBNDataView;
import com.example.week02.view.IPJDataView;
import com.youth.banner.Banner;
import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements IPJDataView,IBNDataView {

    private Banner mbanner;
    private TextView mPriceName;
    private ListView d_pj_lv;
    PJPresenter pjPresenter;
    String name;
    List<Pj_Bean.DataBean> pjlist=new ArrayList<>();
    List<Bn_Bean.SkuBean> bnlist=new ArrayList<>();
    String pic;
    String price;
    String id;
    PJAdapter pjAdapter;
    BNPresenter bnPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();

        Intent intent=getIntent();
        name =intent.getStringExtra("name");
        pic=intent.getStringExtra("pic");
        price=intent.getStringExtra("price");

        id=intent.getStringExtra("id");
        initData();

        pjPresenter=new PJPresenter(this);
        pjShowData(pjlist);

        pjPresenter.ppData();
        bnPresenter=new BNPresenter(this);

        bnShowData(bnlist);
        bnPresenter.ppData();
    }

    private void initData() {

        mPriceName.setText(price+"\r\n"+name);
    }

    private void initView() {
        mbanner = (Banner) findViewById(R.id.mbanner);
        mPriceName = (TextView) findViewById(R.id.price_name);
        d_pj_lv = (ListView) findViewById(R.id.d_pj_lv);
    }

    @Override
    public void pjShowData(List<Pj_Bean.DataBean> pjlist) {
        pjAdapter=new PJAdapter(this,pjlist);
        d_pj_lv.setAdapter(pjAdapter);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void bnShowData(List<Bn_Bean.SkuBean> bnlist) {

        ArrayList<String> pic=new ArrayList<>();
        for(int i=0;i<bnlist.size();i++){
            pic.add(bnlist.get(i).getThumb_url());
            Log.i("111111b",""+bnlist.get(i).getThumb_url());
        }
        mbanner.setImageLoader(new BnImageLoader());
        mbanner.setImages(pic);
        mbanner.start();
    }

    @Override
    public String getBnId() {
        return id;
    }
}