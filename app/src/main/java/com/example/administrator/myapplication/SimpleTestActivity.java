package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import org.w3c.dom.Text;

public class SimpleTestActivity extends AppCompatActivity {
private TextView editText;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_test);
        editText = (TextView) findViewById(R.id.editText);
//        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});

        toast = Toast.makeText(this, "测试", Toast.LENGTH_LONG);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(BuildConfig.VERSION_NAME);
                editText.setText(BuildConfig.CONFIG_ENDPOINT);
                Toast.makeText(SimpleTestActivity.this, BuildConfig.CONFIG_ENDPOINT, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast =null;
            }
        });
    }
}
