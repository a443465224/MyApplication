package com.example.administrator.myapplication.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDH on 2018/4/26.
 */
public class TestBean {
    public static String s = "s";

    public String s1 = "a";
    public String s2 = "b";

    public List<String> c= new ArrayList<>();
    public void insert (){

        System.out.println("第一部分");

        synchronized (this) {

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                c.add(i + "");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }


            System.out.println("最后部分");


    }

    public synchronized static void insert2(String s){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"   insert2");
    }





    
    public synchronized static void  m2(){

        System.out.println("这是方法2");
    }

    public static void m3(String str){
        s=str;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
