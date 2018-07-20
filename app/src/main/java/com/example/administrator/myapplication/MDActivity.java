package com.example.administrator.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.bean.LogUtils;

/**
 * Created by XDH.
 */
public class MDActivity extends AppCompatActivity {
    ImageView img1;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md);
        img1 = (ImageView) findViewById(R.id.img1);

        img1.setOnClickListener(v -> {
            LogUtils.e(true,"dianji");
        });


        Button bt = (Button) findViewById(R.id.text1);
        bt.setHighlightColor(0x88ff0000);

    }
}
