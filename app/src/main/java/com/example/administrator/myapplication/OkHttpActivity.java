package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/5/31.
 */

public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBt;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private OkHttpClient mOkHttp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.connectTimeout(1500, TimeUnit.SECONDS);

        mOkHttp = new OkHttpClient();
        mBt = (Button) findViewById(R.id.button);
        mBt.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.button:
            Request request = new Request.Builder().url("https://api.douban.com/v2/book/1220562").get().build();
            Call call = mOkHttp.newCall(request);



            call.enqueue(new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                   Headers responseHeaders = response.headers();
                   for (int i = 0; i < responseHeaders.size(); i++) {
                       System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                   }

                    System.out.println(response.body().string());
               }
           });


            break;
        default:
            break;
        }
    }
}
