package com.example.administrator.myapplication;

import com.chad.library.adapter.base.loadmore.LoadMoreView;

/**
 * Created by XDH on 2017/8/31.
 */

public class CusomLoadMoreView extends LoadMoreView{
    @Override
    public int getLayoutId() {
        return R.layout.view_load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load1;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load2;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load3;
    }
}
