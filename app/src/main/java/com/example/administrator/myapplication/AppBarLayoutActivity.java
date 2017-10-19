package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by Administrator on 2017/6/16.
 */

public class AppBarLayoutActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private AppBarLayout appBarLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barlayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("标题栏");
        toolbar.setTitleTextColor(0x8800ffff);
        setSupportActionBar(toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);



//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
////                System.out.println("offset:  "+verticalOffset);
//                System.out.println("range:  "+appBarLayout.getTotalScrollRange());
//            }
//        });
//
//        findViewById(R.id.image3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                appBarLayout.setExpanded(false,false);
//            }
//        });

    }
}
