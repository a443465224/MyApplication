package com.example.administrator.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


public class UriActivity extends AppCompatActivity {
private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);

        img = (ImageView) findViewById(R.id.image9);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String var1 = "http://api.map.baidu.com/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving&region=西安&output=html&src=yourCompanyName|yourAppName";
//                Intent baidu = new Intent("android.intent.action.VIEW");
//                baidu.addCategory("android.intent.category.DEFAULT");
//                baidu.setData(Uri.parse(var1));
//                startActivity(baidu);

//                final String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517403447702&di=9ff2bcf706f4c333b6001444bcef933e&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F10dfa9ec8a1363274059091e9a8fa0ec08fac763.jpg";
                final String url = "https://pic4.zhimg.com/50/v2-dc040bb4b89828d236754c37c6bd43e6_hd.jpg";

                String encodedUrl = Uri.encode(url, "@#&=*+-_.,:!?()/~'%");
//                System.out.println("-------------------"+encodedUrl);

                    new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            try {
                            URL url1 = new URL(url);
                            InputStream inputStream = url1.openStream();
                            final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    img.setImageBitmap(bitmap);
                                }
                            });
                            System.out.println("大小-------------"+bitmap.getHeight()+"-----"+bitmap.getWidth());
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();




            }
        });
    }

}
