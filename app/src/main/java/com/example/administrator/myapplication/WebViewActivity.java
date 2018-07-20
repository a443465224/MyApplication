package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.myapplication.bean.LogUtils;

public class WebViewActivity extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWebView = (WebView) findViewById(R.id.web_view);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
//        settings.setBuiltInZoomControls(true);


        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                LogUtils.e("加载："+url);
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                LogUtils.e(true,newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });



        findViewById(R.id.bt1).setOnClickListener(v -> {

            Uri uri = Uri.parse("http://www.exlive.cn/home/kaifangpt/dynamicInterface.jsp?type=4");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);


//            mWebView.loadUrl("http://www.exlive.cn/home/kaifangpt/dynamicInterface.jsp?type=4");
        });

    }
}
