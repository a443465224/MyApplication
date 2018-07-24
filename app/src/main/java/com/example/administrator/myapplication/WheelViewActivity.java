package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.wheelHYH.adapters.ListWheelAdapter;
import com.example.administrator.myapplication.wheelHYH.widget.WheelView;

/**
 * Created by XDH on 2018/5/7.
 */
public class WheelViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheelview);

        WheelView wheelView = (WheelView) findViewById(R.id.wheel);
//
        String[] list = new String[150];
        for (int i = 0; i < 150; i++) {
            list[i] = i+"";
        }

//        wheelView.setViewAdapter(new NumericWheelAdapter(this, 1,100));


    }

}
