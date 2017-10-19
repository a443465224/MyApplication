package com.example.administrator.myapplication;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.administrator.myapplication.bean.MultiItemEntityBean;

import java.util.List;

/**
 * Created by XDH on 2017/7/21.
 */

public class BaseAdapter extends BaseMultiItemQuickAdapter<MultiItemEntityBean,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public BaseAdapter(List<MultiItemEntityBean> data) {
        super(data);
        addItemType(MultiItemEntityBean.TYPE1,R.layout.adapter_base_recy);
        addItemType(MultiItemEntityBean.TYPE2,R.layout.adapter_my);
    }



//    @Override
//    protected void convert(final BaseViewHolder helper, String item) {
//        helper.setText(R.id.tv,item);
////        TextView tv = helper.getView(R.id.tv);
////        tv.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Log.e("pos",helper.getLayoutPosition()+"");
////            }
////        });
//
//    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntityBean item) {
        switch(helper.getItemViewType()){
        case MultiItemEntityBean.TYPE1:
            helper.setText(R.id.tv,"类型1");
            break;
        case MultiItemEntityBean.TYPE2:
            helper.setText(R.id.tv,"类型2");
            break;
        default:
            break;
        }
    }
}
