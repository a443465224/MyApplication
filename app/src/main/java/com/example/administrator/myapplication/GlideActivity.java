package com.example.administrator.myapplication;

import android.Manifest;
import android.Manifest.permission;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import static android.R.attr.bitmap;
import static android.R.attr.configChanges;

/**
 * Created by Administrator on 2017/5/25.
 */

public class GlideActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImg;
    private ImageView mImg2;
    private final String TAG = "GlideActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        mImg = (ImageView) findViewById(R.id.image);

        mImg2 = (ImageView) findViewById(R.id.image2);

//        Glide.with(this).load("http://img2.imgtn.bdimg.com/it/u=3592644171,2667616623&fm=23&gp=0.jpg").into(mImg);
        RequestManager requestManager = Glide.with(this);

//        requestManager.load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1495705844310&di=d8dc4c11d4406b18dac9e7e2d3674efc&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F3bf33a87e950352a3aa7701d5043fbf2b3118be5.jpg")
//                .thumbnail(0.2f).into(mImg);
//        requestManager.load("").listener(new RequestListener<String, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                Log.d(TAG, "onException: shibai");
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                return false;
//            }
//        }).into(mImg);


        if (ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
        }



        mImg.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.image:
            Glide.with(this).load("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=12061520,174344021&fm=23&gp=0.jpg")
                    .transform(new BitmapHandler(this)).diskCacheStrategy(DiskCacheStrategy.NONE).into(mImg);


//            Drawable drawable = mImg.getDrawable();
//
//            Log.d(TAG, "onClick: "+drawable.getIntrinsicWidth() +"   "+drawable.getIntrinsicHeight());
            break;
        default:
            break;
        }

    }


    class BitmapHandler extends BitmapTransformation{

        public BitmapHandler(Context context) {
            super(context);
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            Log.d("tag","zhixingle");

            Bitmap result = Bitmap.createBitmap(toTransform.getWidth(), toTransform.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setColor(0xffffffff);
            canvas.drawCircle(toTransform.getWidth()/2,toTransform.getHeight()/2,toTransform.getHeight()/2,paint);

            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

            canvas.drawBitmap(toTransform,0,0,paint);
            Log.d("tag","zhixingle2");





//            File img2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/1Log/source.jpg");
//            try {
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(img2));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }




            return result;
        }

        @Override
        public String getId() {
            return getClass().getName() + Math.round(4);
        }
    }
}
