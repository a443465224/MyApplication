package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by XDH on 2017/11/3.
 */
public class TouchEventActivity extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_camera);
//        LinearLayout ll = (LinearLayout) findViewById(R.id.llayout);
////        ll.setCameraDistance(getResources().getDisplayMetrics().density * 1000);
//
//
//        new TestDialog(this).show();
//        findViewById(R.id.myView).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("点击了");
//            }
//        });
//        findViewById(R.id.image).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(TouchEventActivity.this,"dianji",Toast.LENGTH_SHORT).show();
//                System.out.println("I点击了");
//            }
//        });
        imageView = (ImageView) findViewById(R.id.image);
    }

    float downX,downY;
    /** 是否在检查移动方向 */
    private boolean checkOrientation = true;
    /** 移动动作类型 */
    private int moveAction;
    /** 横向移动 */
    private static final int HORIZONTAL_MOVE = 1000;
    /** 纵向移动 */
    private static final int VERTICAL_MOVE = 1001;
    /** 上次的触摸坐标 */
    private float lastX,lastY;
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch(ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX=ev.getX();
                downY=ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
//                System.out.println("进入检测" + downX +","+downY+";           "+ev.getX()+","+ev.getY());
                if (checkOrientation) {
                    if (Math.abs(downX - ev.getX()) > 20 && Math.abs(downY - ev.getY()) < 10) {
                        moveAction = HORIZONTAL_MOVE;
                        checkOrientation = false;
//                        System.out.println("横向移动");
                    }
                    if (Math.abs(downX - ev.getX()) <10 && Math.abs(downY - ev.getY()) > 20) {
                        moveAction = VERTICAL_MOVE;
                        checkOrientation = false;
//                        System.out.println("纵向移动");
                    }
                    if (moveAction == 0) {
//                        System.out.println("-----------检测失败-----------------");
                    }
                    break;
                }
//                System.out.println("检测成功");
                if (moveAction == VERTICAL_MOVE) {
                    System.out.println((int)(ev.getY() - lastY));
                    imageView.scrollBy(0, -(int)(ev.getY() - lastY));
                } else if (moveAction == HORIZONTAL_MOVE) {
                    System.out.println((int)(ev.getX() - lastX));
                    imageView.scrollBy(-(int)(ev.getX() - lastX), 0);
                }


                break;
            case MotionEvent.ACTION_UP:
                checkOrientation = true;
                moveAction = 0;
                break;
        default:
            break;
        }
        lastX = ev.getX();
        lastY = ev.getY();
        return true;
    }
}
