package com.example.greendao;


import android.app.Application;

import com.example.greendao.db.DaoMaster;
import com.example.greendao.db.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by lenovo on 2017/11/30.
 */

public class MyApp  extends Application {

    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new  DaoMaster.DevOpenHelper(this, ENCRYPTED ? "users-db-encrypted" : "users-db");
        Database db =  helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
    public DaoSession getDaoSession() {
        return daoSession;
    }
}