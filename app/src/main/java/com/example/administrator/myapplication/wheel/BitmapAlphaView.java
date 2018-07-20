package com.example.administrator.myapplication.wheel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.myapplication.R;

/**
 * Created by XDH.
 */
public class BitmapAlphaView extends View {
    Paint mPaint;
    Bitmap dst;
    private Bitmap extractAlpha;
    public BitmapAlphaView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaint.setColor(0xffff0000);
//        mPaint.setShader(new LinearGradient(0,0,500,0,0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));
        dst = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_network_close);
        extractAlpha = dst.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(extractAlpha,null,new RectF(0,0,500,500),mPaint);
        mPaint.setColorFilter(new PorterDuffColorFilter(0xffff0000, PorterDuff.Mode.DST_IN));

        canvas.drawBitmap(dst,0,0,mPaint);


    }
}
