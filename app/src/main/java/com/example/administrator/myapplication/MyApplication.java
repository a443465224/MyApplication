package com.example.administrator.myapplication;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.example.administrator.myapplication.bean.LogUtils;
import com.example.administrator.myapplication.dao.DaoMaster;
import com.example.administrator.myapplication.dao.DaoSession;
import com.example.administrator.myapplication.dao.GreenBeanDao;
import com.umeng.commonsdk.UMConfigure;

import org.greenrobot.greendao.database.Database;

/**
 * Created by XDH on 2018/3/2.
 */

public class MyApplication extends Application {
    private static MyApplication instance;
    public static Context getInstance(){
        return  instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        UMConfigure.init(this, null, null, UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setLogEnabled(true);

        LogUtils.Builder builder = new LogUtils.Builder().setBorderSwitch(false);


        DaoMaster.DevOpenHelper item_db = new DaoMaster.DevOpenHelper(this, "item_db", null);
        Database writableDatabase = item_db.getWritableDb();
        DaoSession daoSession = new DaoMaster(writableDatabase).newSession();
        GreenBeanDao greenBeanDao = daoSession.getGreenBeanDao();
//        greenBeanDao.queryBuilder().


    }

}
