package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2017/6/15.
 */

public class EventBusActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);


        btn = (Button) findViewById(R.id.button6);

        btn.setOnClickListener(this);


    }




    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.button6:
//            EventBus.getDefault().post(new SendMsg("test msg"));
            EventBus.getDefault().postSticky(new SendMsg("test msg"));
            System.out.println("fasong:"+Thread.currentThread().getId());
            break;
        default:
            break;
        }
    }
}
