package com.example.myapplication;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionNo;
import com.yanzhenjie.permission.PermissionYes;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AndPermission.with(this).permission(Manifest.permission.READ_EXTERNAL_STORAGE).requestCode(100).callback(this)
                .rationale((requestCode,rationale) ->
                        AndPermission.rationaleDialog(MainActivity.this,rationale).show())
                .start();


    }

    @PermissionYes(100)
    private void getCalendarYes(List<String> grantedPermissions) {
        Toast.makeText(this, "yyyyyyyyyy", Toast.LENGTH_SHORT).show();
    }
    @PermissionNo(100)
    private void getCalendarNo(List<String> deniedPermissions) {
        Toast.makeText(this, "nnnnnnnnnnnn", Toast.LENGTH_SHORT).show();
        // 用户否勾选了不再提示并且拒绝了权限，那么提示用户到设置中授权。
        if (AndPermission.hasAlwaysDeniedPermission(this, deniedPermissions)) {
            // 第一种：用默认的提示语。
//            AndPermission.defaultSettingDialog(this, 200).show();
            AndPermission.defaultSettingDialog(this,300).setNegativeButton("quxiao", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            }).show();

        }
    }

}
