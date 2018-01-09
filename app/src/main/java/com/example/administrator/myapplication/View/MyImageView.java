package com.example.administrator.myapplication.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by XDH on 2017/11/17.
 */

public class MyImageView extends ImageView {
    public MyImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                System.out.println("IonDown");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("IonMove");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("IonUp");
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
