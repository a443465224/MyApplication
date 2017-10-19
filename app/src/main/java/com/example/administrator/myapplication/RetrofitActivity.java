package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.administrator.myapplication.bean.WeaterBean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/6/5.
 */

public class RetrofitActivity extends AppCompatActivity implements View.OnClickListener {
    public interface DoubanService{
        @POST("weather/ip")
        @FormUrlEncoded
        Call<WeaterBean> getBook(@FieldMap Map<String,String>map);
    }




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        
        
        findViewById(R.id.button3).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.button3:
            RequestBody body = new FormBody.Builder().add("name", "lisi").build();





            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            DoubanService doubanService = retrofit.create(DoubanService.class);
            Map<String,String> map = new HashMap<String,String>();
            map.put("ip","58.215.185.154");
            map.put("dtype","json");
            map.put("key","2b8a66f9f6d5e6522abd47b156bcac42");
            Call<WeaterBean> call = doubanService.getBook(map);
            call.enqueue(new Callback<WeaterBean>() {
                @Override
                public void onResponse(Call<WeaterBean> call, Response<WeaterBean> response) {
                    WeaterBean weaterBean = response.body();
                    System.out.println("今天天气："+weaterBean.getResult().getSk().getTemp());

                }

                @Override
                public void onFailure(Call<WeaterBean> call, Throwable t) {

                }
            });


            break;
        default:
            break;
        }
    }
}
