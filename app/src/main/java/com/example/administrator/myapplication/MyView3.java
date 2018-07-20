package com.example.administrator.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.administrator.myapplication.bean.Bean;
import com.example.administrator.myapplication.bean.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDH.
 */
public class MyView3 extends View {
    private Paint mPaint;
    private String text = "abch";
    private int textHalfH,textBottom;
    private int offset;
    private Rect rect;

    public MyView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
//        mPaint.setStrokeWidth(5);
//
////        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(60);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        rect = new Rect();
        mPaint.getTextBounds(text, 0, text.length(), rect);
        textHalfH = rect.height()/2;
        textBottom = rect.bottom;

        LogUtils.e(true, rect.left, rect.top, rect.right,rect.bottom ,rect.width(),rect.height());

         fontMetrics = mPaint.getFontMetrics();
        LogUtils.e(true,fontMetrics.ascent,fontMetrics.descent,fontMetrics.top,fontMetrics.bottom,fontMetrics.leading);

//        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "offset", 0,rect.width());
//        ofInt.setDuration(1500);
//        ofInt.start();
//        ofInt.setRepeatCount(ValueAnimator.INFINITE);
//        ofInt.setRepeatMode(ValueAnimator.REVERSE);

    }
    Paint.FontMetrics fontMetrics;

    public void setOffset(int offset) {
        this.offset = offset;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerID = canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);

        mPaint.setColor(0x88ff0000);
        canvas.drawRect(new RectF(300,1500 + fontMetrics.ascent, 490,1500 + fontMetrics.descent),mPaint);

        mPaint.setColor(0x88000000);
        canvas.drawText(text, 300, 1500, mPaint);


        Bitmap bitmap = Bitmap.createBitmap(80, textHalfH*2, Bitmap.Config.ARGB_8888);
        Canvas cc = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setShader(new LinearGradient(0,0,80,textHalfH*2,0xffff0000,0xff00ff00, Shader.TileMode.CLAMP));
        cc.drawRect(new Rect(0,0,80,textHalfH*2), paint);


//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(bitmap,300+offset, 1500-(textHalfH*2), mPaint);
//
//
//        mPaint.setXfermode(null);

        canvas.restoreToCount(layerID);
    }

}
