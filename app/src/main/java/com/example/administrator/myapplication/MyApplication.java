package com.example.administrator.myapplication;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import android.support.multidex.MultiDex;
import com.example.administrator.myapplication.bean.LogUtils;
import com.example.administrator.myapplication.dao.DaoMaster;
import com.example.administrator.myapplication.dao.DaoSession;
import com.example.administrator.myapplication.dao.GreenBeanDao;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
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

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                ClassicsHeader classicsHeader = new ClassicsHeader(context);
//                classicsHeader.setAccentColor()
                return classicsHeader;
            }
        });

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex分包
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        UMConfigure.init(this, null, null, UMConfigure.DEVICE_TYPE_PHONE, "");
        UMConfigure.setLogEnabled(true);

//        LogUtils.Builder builder = new LogUtils.Builder().setBorderSwitch(false);


        DaoMaster.DevOpenHelper item_db = new DaoMaster.DevOpenHelper(this, "item_db", null);
        Database writableDatabase = item_db.getWritableDb();
        DaoSession daoSession = new DaoMaster(writableDatabase).newSession();
        GreenBeanDao greenBeanDao = daoSession.getGreenBeanDao();
//        greenBeanDao.queryBuilder().


    }

}
