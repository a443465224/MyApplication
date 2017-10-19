package com.example.administrator.myapplication;

import android.animation.Animator;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.example.administrator.myapplication.bean.MultiItemEntityBean;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class BaseRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private GeocodeSearch geocoderSearch;
    BaseAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        List<String> data = new ArrayList<>();
        List<MultiItemEntityBean> data = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            data.add(new MultiItemEntityBean(i % 2 == 0 ? MultiItemEntityBean.TYPE1 : MultiItemEntityBean.TYPE2));
        }

//        mAdapter = new BaseAdapter(R.layout.adapter_my, data);
        mAdapter = new BaseAdapter(data);

//        adapter.addHeaderView(inflate);
//        adapter.addFooterView(inflate2);
//        adapter.setHeaderFooterEmpty(true,true);

        mAdapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[0];
            }
        });
        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

//                        Toast.makeText(BaseRecyclerViewActivity.this,"加载一条数据",Toast.LENGTH_SHORT).show();
//                        adapter.addData("这是新填的数据");
//                        adapter.loadMoreComplete();
//                        adapter.loadMoreEnd();
//                        adapter.loadMoreFail();

                    }

                },1000);

              }
        },mRecyclerView);

        mAdapter.setPreLoadNumber(5);

        mAdapter.setLoadMoreView(new CusomLoadMoreView());


//        adapter.setUpFetchEnable(true);
//        adapter.setStartUpFetchPosition(5);
//
//        adapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
//            @Override
//            public void onUpFetch() {
////                adapter.setUpFetching(true);
////                mRecyclerView.postDelayed(new Runnable() {
////                    @Override
////                    public void run() {
////                        adapter.addData(0,"这是个新数据");
////                        adapter.setUpFetching(false);
////                    }
////                },1000);
//
//            }
//        });


//        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(mAdapter);
//        ItemTouchHelper helper = new ItemTouchHelper(itemDragAndSwipeCallback);
//        helper.attachToRecyclerView(mRecyclerView);
//
//        itemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.START | ItemTouchHelper.END);

//        itemDragAndSwipeCallback.setDragMoveFlags(ItemTouchHelper.UP);







//        mAdapter.enableSwipeItem();
//        mAdapter.setOnItemSwipeListener(new OnItemSwipeListener() {
//            @Override
//            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
//
//            }
//
//            @Override
//            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
//
//            }
//
//            @Override
//            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
//
//            }
//
//            @Override
//            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
//
//            }
//        });
//
//
//        mAdapter.enableDragItem(helper);
//        mAdapter.setOnItemDragListener(new OnItemDragListener() {
//            @Override
//            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
//
//            }
//
//            @Override
//            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
//
//            }
//
//            @Override
//            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
//
//            }
//        });



        mRecyclerView.setAdapter(mAdapter);

        View inflate1 = LayoutInflater.from(this).inflate(R.layout.activity_cadr_view, null);
        mAdapter.setEmptyView(inflate1);





    }


}
