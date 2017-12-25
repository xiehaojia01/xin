package com.example.week01.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.week01.GreenDaoHelper;
import com.example.week01.R;
import com.example.week01.adapter.MyAdapter;
import com.example.week01.adapter.RecAdapter;
import com.example.week01.bean.DaoSession;
import com.example.week01.bean.LogBean;
import com.example.week01.bean.NetBean;
import com.example.week01.bean.UserBean;
import com.example.week01.utils.NetListener;
import com.example.week01.utils.RetrofitHepler;
import com.example.week01.utils.ServerApi;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/12/2.
 */
public class fragment01  extends Fragment {

    ServerApi serverApi;
    RecAdapter adapter;
    @BindView(R.id.rec)
    RecyclerView mRec;
    private View view;
    private Unbinder unbinder;
    private DaoSession session;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //注册
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //加载视图
        View view = View.inflate(getActivity(), R.layout.fragment01, null);
        session= GreenDaoHelper.getDaoSession(getActivity());
        unbinder = ButterKnife.bind(this, view);
        mRec.setLayoutManager(new LinearLayoutManager(getContext()));
        //创建ServerApi对象
        serverApi = RetrofitHepler.getServerApi();

        if(!new NetListener().isNetworkConnected(getActivity()))
        {
            /**
             * 无网状态下
             */
            //查询记录
            List<UserBean> areas = session.getUserBeanDao().loadAll();
            MyAdapter myAdapter=new MyAdapter(areas,getActivity());
            mRec.setAdapter(myAdapter);
        }
        else
        {
            Toast.makeText(getActivity(),"有网",Toast.LENGTH_LONG).show();
            Call<LogBean> logBeanCall = serverApi.logBeanCall();
            logBeanCall.enqueue(new Callback<LogBean>() {
                @Override
                public void onResponse(Call<LogBean> call, Response<LogBean> response) {
                    //请求成功
                    final LogBean logBean = response.body();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //实例化适配器
                            adapter = new RecAdapter(logBean.getResults(), getActivity());
                            mRec.setAdapter(adapter);

                            //存值到数据库
                            for(int i=0;i<logBean.getResults().size();i++)
                            {
                                LogBean.ResultsBean r=logBean.getResults().get(i);
                                UserBean userBean=new UserBean(System.currentTimeMillis(),r.getPublishedAt(),r.getDesc(),r.getType());
                                session.insert(userBean);
                            }

                        }
                    });

                }

                @Override
                public void onFailure(Call<LogBean> call, Throwable t) {

                }
            });
        }
        return view;
    }

    @Subscribe
    public void isNetWork(NetBean netBean) {
        Toast.makeText(getContext(), netBean.getNetzhuan(), Toast.LENGTH_LONG).show();
        //判断
        if (netBean.getNetzhuan().equals("网络连接中~")) {
            Call<LogBean> logBeanCall = serverApi.logBeanCall();
            logBeanCall.enqueue(new Callback<LogBean>() {
                @Override
                public void onResponse(Call<LogBean> call, Response<LogBean> response) {
                    //请求成功
                    LogBean logBean = response.body();
                }

                @Override
                public void onFailure(Call<LogBean> call, Throwable t) {

                }
            });
        }
    }

    //销毁防止内存泄露
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        EventBus.getDefault().unregister(this);
    }
}