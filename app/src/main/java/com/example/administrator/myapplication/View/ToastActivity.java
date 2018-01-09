package com.example.administrator.myapplication.View;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

public class ToastActivity extends AppCompatActivity {

    private Button mTextMessage;
    private Button mTextMessage2;
    private Toast toast;
    private int i;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        mTextMessage = (Button) findViewById(R.id.message);
        mTextMessage2 = (Button) findViewById(R.id.message2);

        i++;
        toast = Toast.makeText(ToastActivity.this, "测试Toast"+i, Toast.LENGTH_SHORT);


        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toast.show();
            }
        });

        mTextMessage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.cancel();
                toast = Toast.makeText(ToastActivity.this, "改变内容"+i, Toast.LENGTH_LONG);
                toast.show();
            }
        });


    }


    @Override
    protected void onStop() {
        super.onStop();
        toast.cancel();
    }
}
