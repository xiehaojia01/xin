package com.example.week1;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by len on 2017/12/4.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
