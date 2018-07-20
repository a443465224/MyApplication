package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by XDH.
 */
public class MyView4 extends View {
    private Paint mPaint;



    public MyView4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0xffFF4081);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();



        LinearGradient linearGradient = new LinearGradient(width / 2, height / 2, width / 2 + 300, height / 2 + 150, 0xffff0000, 0xff00ff00, Shader.TileMode.REPEAT);

        mPaint.setShader(linearGradient);
        canvas.drawRoundRect(new RectF(width/2,height/2,width/2 + 300, height/2 + 150),20, 20, mPaint);



    }
}
