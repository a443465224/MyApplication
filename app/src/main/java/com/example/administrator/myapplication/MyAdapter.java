package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    /** 数据集 */
    private List<String> mDatas;
    private LayoutInflater mInflater;
    Context context;
    View.OnClickListener onClickListener;

    public MyAdapter(List<String> mDatas, Context context, View.OnClickListener onClickListener) {
        this.mDatas = mDatas;
        this.context = context;
        this.onClickListener = onClickListener;
        mInflater = LayoutInflater.from(context);

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = mInflater.inflate(R.layout.adapter_my,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.initData(position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }





    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);

        }


        public void initData(int position) {
            tv.setText(mDatas.get(position));
            tv.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv:

                    mDatas.remove(getLayoutPosition());
                    notifyItemRemoved(getLayoutPosition());
                    Log.e("Tag",getLayoutPosition()+"    "+getAdapterPosition());
                    break;
                default:
                    break;
            }
        }
    }
}
