package com.example.administrator.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class CadrViewActivity extends AppCompatActivity {

    CardView mCardView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadr_view);

        mCardView = (CardView) findViewById(R.id.card_view);

        mCardView.setOnClickListener(v -> {
        });
    }
}
