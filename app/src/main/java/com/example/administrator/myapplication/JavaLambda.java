package com.example.administrator.myapplication;

import junit.framework.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by XDH on 2018/4/3.
 */
public class JavaLambda {
    private static Test myTest;
    public static int i= 1;
    public static void main(String[] args){
        new Thread(() -> i++).start();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            int random = (int)(Math.random() * 30 + 1);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < random; j++) {
                sb.append(i+"");
            }
            list.add(sb.toString());
        }

        list.forEach(System.out::print);

        Collections.shuffle(list);
        System.out.println(list.toString());

        JavaLambda javaLambda = new JavaLambda();
        javaLambda.setMyTest(i1 -> "");


        Collections.sort(list,(String o1, String o2) -> {int a=1;return 1;});
        System.out.println(list.toString());
        System.out.println(javaLambda.myTest.doT("ss"));

        String s ="";
//        boolean b  = String::isEmpty;

    }

    public static void setMyTest(Test myTest) {
        JavaLambda.myTest = myTest;
    }

    interface Test{
        String doT (String i);
//        void do2(String i);
    }
}
