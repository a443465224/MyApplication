package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by Administrator on 2017/6/15.
 */

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);



        btn = (Button) findViewById(R.id.button5);

        btn.setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);


    }


//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onMessageEvent(SendMsg event){
//        System.out.println("jieshou:"+Thread.currentThread().getId());
////        Toast.makeText(this,event.getMsg(),Toast.LENGTH_SHORT).show();
////        btn.setText(event.getMsg());
//
//    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onStickyMessageEvent(SendMsg event){
        System.out.println("jieshou:"+Thread.currentThread().getId());
        Toast.makeText(this,event.getMsg(),Toast.LENGTH_SHORT).show();
        btn.setText(event.getMsg());







    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                startActivity(new Intent(this, EventBusActivity2.class));

                break;
            case R.id.button7:
                EventBus.getDefault().register(this);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
