package com.example.administrator.myapplication;

import android.os.SystemClock;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by XDH on 2017/11/17.
 */

public class JavaTest {
    public static String a;
    public static String b;
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>();

        String time = "2017-12-27";
//        time = time.replace("Z", " UTC");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        Calendar calendar = sdf.getCalendar();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(simpleDateFormat.format(sdf.getCalendar().getTime()));

//
//        Date date = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        sdf2.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(sdf2.format(sdf.getCalendar().getTime()));


    }


}
