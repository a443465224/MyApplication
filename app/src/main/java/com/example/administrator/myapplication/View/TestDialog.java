package com.example.administrator.myapplication.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.example.administrator.myapplication.R;

/**
 * Created by XDH on 2017/11/10.
 */

public class TestDialog extends Dialog {
    public TestDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
    }
}
