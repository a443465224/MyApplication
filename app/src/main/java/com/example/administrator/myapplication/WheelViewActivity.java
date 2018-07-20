package com.example.administrator.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myapplication.wheel.adapters.AbstractWheelTextAdapter;

import java.util.ArrayList;
import java.util.List;

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
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i+"");
        }
        wheelView.setItems(list);

    }

    public class MyWheelAdapter extends AbstractWheelTextAdapter {
        private List<String> items;

        public MyWheelAdapter(Context context, List<String> items) {
            super(context);
            this.items = items;
        }

        @Override
        public View getItem(int index, View convertView, ViewGroup parent) {
            if (index >= 0 && index < getItemsCount()) {
                if (convertView == null) {
                    convertView = getView(itemResourceId, parent);
                }
                TextView textView = getTextView(convertView, itemTextResourceId);
                textView.setTextColor(0xff4b4b4b);
                textView.setText(getItemText(index));
                textView.setGravity(Gravity.CENTER);
                textView.setLines(1);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                return convertView;
            }
            return null;
        }

        @Override
        public int getItemsCount() {
            return items == null ? 0 : items.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            if (index >= 0 && index < items.size()) {
                return items.get(index);
            }
            return null;
        }
    }
}
