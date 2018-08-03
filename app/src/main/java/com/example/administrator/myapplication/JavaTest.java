package com.example.administrator.myapplication;

import android.os.SystemClock;

import com.example.administrator.myapplication.bean.GsonBean;
import com.example.administrator.myapplication.bean.LogUtils;
import com.example.administrator.myapplication.bean.TestBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by XDH on 2017/11/17.
 */

public class JavaTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int j = 0;
        for (int i = 0; i < 10; i++) {
            j++;
            int finalJ = j;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println(finalJ);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 测试TAG功能

    }



        //回滚后又重新改动了文件，上传





















}
