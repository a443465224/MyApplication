package com.example.administrator.myapplication;

import android.Manifest;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/2.
 */

public class DBActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);



        SQLiteDatabase database = openOrCreateDatabase("user", MODE_PRIVATE, null);
        database.execSQL("create table if not exists Book (_id integer primary key autoincrement,author text,price real,pages integer,name text)");
        ContentValues contentValues = new ContentValues();
        contentValues.put("author","test");
        long book = database.insert("Book", null, contentValues);
        System.out.println("chenggong   "+book);


        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File filesDir = DBActivity.this.getFilesDir();
                String path = filesDir.getAbsolutePath().substring(0,filesDir.getAbsolutePath().length()-6);
                File dbFile = new File("/data/user/0/com.example.account/databases/account.db");
                System.out.println(dbFile.exists());
//                Toast.makeText(DBActivity.this,filesDir.getAbsolutePath(),Toast.LENGTH_LONG).show();
                File sdFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath(),"/1Log/account.db");
                byte[] bytes = new byte[10*1024];
                int len = 0;
                try {
                    FileOutputStream outputStream = new FileOutputStream(sdFile);
                    FileInputStream inputStream = new FileInputStream(dbFile);
                    while ((len = inputStream.read(bytes))!=-1){
                        outputStream.write(bytes,0,len);
                    }
                    outputStream.close();
                    inputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }





            }
        });

    }
}
