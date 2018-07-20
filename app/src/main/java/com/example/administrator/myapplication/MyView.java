package com.example.administrator.myapplication;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.administrator.myapplication.bean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDH.
 */
public class MyView extends View {
    private Paint paint,paint2;
    private String str = "测试12345Texting";
    private int radius= 100;
    private List<Point> list = new ArrayList<Point>();
    Path path;
    int mItemLen = 400;

    public MyView(Context context, AttributeSet a) {
        super(context,a);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setTextSize(90);
        paint.setStyle(Paint.Style.STROKE.FILL_AND_STROKE);
        paint.setColor(0xffff0000);


        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(10);
        paint2.setTextSize(90);
        paint2.setStyle(Paint.Style.STROKE.STROKE);
        paint2.setColor(0xff000000);
        path = new Path();
//		startAnimator();
    }
    private Integer dx,dy;
    StringBuffer sb = new StringBuffer();
    public void startAnimator() {
        ValueAnimator valueAnimator1 = ValueAnimator.ofInt(0,mItemLen);
        valueAnimator1.setDuration(1000);
        valueAnimator1.setInterpolator(new LinearInterpolator());
        valueAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
//		valueAnimator1.start();

        ValueAnimator valueAnimator = ValueAnimator.ofInt(0,height);
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new LinearInterpolator());
//		valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dy = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
//		valueAnimator.start();
        AnimatorSet set = new AnimatorSet();
        set.playTogether(valueAnimator1,valueAnimator);
        set.start();
    }
    private int height;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        int originY = 300;
        int halfLen = mItemLen / 2;
        int width = getWidth();
        height = getHeight()-300;
        path.moveTo(-mItemLen+dx, originY+dy);

        for (int i = -mItemLen; i <=width +mItemLen ; i+=mItemLen) {
            path.rQuadTo(halfLen/2, -50, halfLen,0);

            path.rQuadTo(halfLen/2, 50, halfLen,0);
        }

        path.lineTo(width, getHeight());
        path.lineTo(0, getHeight());
        path.close();

        canvas.drawPath(path, paint);

    }

    public void setRadius(Bean bean){
        this.radius = bean.radius;
        invalidate();
    }
    private float lastQX,lastQY,lastEX,lastEY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {


//		switch (event.getAction()) {
//		case MotionEvent.ACTION_DOWN:
//			path.moveTo(event.getX(), event.getY());
//			break;
//		case MotionEvent.ACTION_MOVE:
//			float endX = (event.getX() + lastX) / 2;
//			float endY = (event.getY() + lastY) / 2;
//			path.quadTo(lastX, lastY, endX, endY);
//
//		default:
//			break;
//		}
//		lastX=event.getX();
//		lastY=event.getY();
//		invalidate();
        return true;
    }
}
