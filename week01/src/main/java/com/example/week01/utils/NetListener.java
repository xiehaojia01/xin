package com.example.week01.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2017/12/2.
 * 网络状态判断工具类
 */

public class NetListener {

    public boolean isNetworkConnected(Context context) {
            if (context != null) {
                   ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                          .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
                if (mNetworkInfo != null) {
                          return mNetworkInfo.isAvailable();
                    }
             }
            return false;
        }
}
