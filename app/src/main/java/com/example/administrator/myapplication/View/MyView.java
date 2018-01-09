package com.example.administrator.myapplication.View;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by XDH on 2017/11/17.
 */

public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0x88ff0000);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                System.out.println("onDown");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("onMove");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("onUp");
                break;
        default:
            break;
        }




        return super.onTouchEvent(event);
    }
}
