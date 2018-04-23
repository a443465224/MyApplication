package com.example.administrator.myapplication.dao;

import android.content.Context;

import com.example.administrator.myapplication.bean.GreenBean;
import com.example.administrator.myapplication.bean.LogUtils;

/**
 * Created by XDH on 2018/4/19.
 */
public class DaoManager {
    private static DaoManager instance;
    private boolean mDaoSession;

    public static DaoManager getInstance(){
        if (instance == null) {
            synchronized (DaoManager.class){
                if (instance == null) {
                    instance = new DaoManager();
                }
            }

        }
        return instance;
    }

    public boolean getDaoSession(Context context){
        if (mDaoSession == false) {
            mDaoSession = true;
            GreenBean greenBean = new GreenBean();
            LogUtils.e(greenBean.toString());
        }
        return  mDaoSession;
    }
}
