package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MyAdapter mAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDate();

        mRecyclerView = (RecyclerView) findViewById(R.id.recy);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//        GridLayoutManager layoutManager = new GridLayoutManager(this,4,GridLayoutManager.HORIZONTAL,false);

        mRecyclerView.setLayoutManager(layoutManager);
//        mRecyclerView.setHasFixedSize(true);

        mAdapter = new MyAdapter(mDatas, this,this);
        mRecyclerView.setAdapter(mAdapter);



        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipeRefreshLayout.setColorSchemeColors(0xffff0000,0xff00ff00,0xff0000ff);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
//        swipeRefreshLayout.setDistanceToTriggerSync(600);


    }

    private void initDate() {
        mDatas = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            mDatas.add("这是第"+i+"条数据");
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                int pos = (int) v.getTag();
                Toast.makeText(this,pos+"",Toast.LENGTH_SHORT).show();
                Log.e("TAG",pos+"");
                mDatas.remove(pos);
                mAdapter.notifyItemRemoved(pos);
//                mAdapter.notifyDataSetChanged();
//                mAdapter.notifyItemRangeChanged(pos,mDatas.size()-pos);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRefresh() {
        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mDatas.add(0,"新增数据");
                mAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);

            }
        },2000);

    }
}
