package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myapplication.bean.LogUtils;
import com.example.administrator.myapplication.dao.DaoManager;

/**
 * Created by XDH on 2018/4/19.
 */
public class GreenDaoActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lambda);




        img = (ImageView) findViewById(R.id.imageView2);








        img.post(() -> {
            LogUtils.e("",img.getWidth(),img.getHeight(),img.getDrawable().getIntrinsicWidth(),img.getDrawable().getIntrinsicHeight()
            ,img.getDrawable().getBounds().width(),img.getDrawable().getBounds().height());
        });


//        findViewById(R.id.tx1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                for (int i = 0; i < 30; i++) {
//                    new Thread(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                 DaoManager.getInstance().getDaoSession(GreenDaoActivity.this);
//                            }
//                        }
//                    ).start();
//                }
//            }
//        });


    }
}
