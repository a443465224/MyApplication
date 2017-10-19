package com.example.administrator.myapplication.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by XDH on 2017/9/11.
 */

public class MultiItemEntityBean implements MultiItemEntity {
    public static final int TYPE1 = 1001;
    public static final int TYPE2 = 1002;

    private int itemType;

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public MultiItemEntityBean(int itemType) {
        this.itemType = itemType;
    }
}
