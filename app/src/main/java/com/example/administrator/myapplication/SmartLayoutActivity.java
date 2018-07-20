package com.example.administrator.myapplication;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.administrator.myapplication.bean.LogUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.net.UnknownHostException;
import java.util.Queue;

public class SmartLayoutActivity extends AppCompatActivity {

    private SmartRefreshLayout smartRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_layout);
        smartRefreshLayout = (SmartRefreshLayout) findViewById(R.id.smart_layout);

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishRefresh(3000,true);

                ConnectivityManager cm = (ConnectivityManager) SmartLayoutActivity.this.getSystemService(Context.CONNECTIVITY_SERVICE);
                LogUtils.e(true,"isavailable："+cm.getActiveNetworkInfo().isAvailable());
                LogUtils.e(true,"isConnec:"+cm.getActiveNetworkInfo().isConnected());
                LogUtils.e(true,"Type:"+cm.getActiveNetworkInfo().getTypeName());
                
                LogUtils.e(cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI);




            }
        });
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setHeaderHeight(70);
        smartRefreshLayout.setEnableOverScrollBounce(false);

        smartRefreshLayout.autoRefresh();
        smartRefreshLayout.finishRefresh();


    }
}
