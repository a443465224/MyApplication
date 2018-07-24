/*
 *  Copyright 2011 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.example.administrator.myapplication.wheelHYH.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.util.List;

public class ListWheelAdapter extends AbstractWheelTextAdapter {

	private List<String> mData;

	private int mCurrentCenterIndex;

	/** item的高度 */
	private int mItemHeight;
	/** 选中项字体大小 */
	private int mSelectTextSize = 18;
	/** 普通项字体大小 */
	private int mNormalTextSize = 12;
	/** 选中项字体颜色 */
	private int mSelectTextColor = 0x88FF0000;
	/** 普通项字体颜色 */
	private int mNormalTextColor = 0xFF222222;
	
	/**
	 * Constructor
	 * 
	 * @param context	the current context
	 * @param data 	the items
	 */
	public ListWheelAdapter(Context context, List data) {
		super(context);

		this.mData = data;

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        mItemHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, metrics);

	}

	public void updateData(List data) {
        this.mData = data;
		this.notifyDataChangedEvent();
	}

	public void setCurrentCenterIndex(int index) {
		this.mCurrentCenterIndex = index;
		this.notifyDataChangedEvent();
	}

	public View getItem(final int index, View convertView, ViewGroup parent) {
		if (index >= 0 && index < getItemsCount()) {
			if (convertView == null) {
				convertView = getView(itemResourceId, parent);
			}
			TextView textView = getTextView(convertView, itemTextResourceId);
			if (textView != null) {
				CharSequence text = getItemText(index);
				if (text == null)
					text = "";

				LayoutParams lp = textView.getLayoutParams();
				if (lp == null) {
					lp = new LayoutParams(LayoutParams.FILL_PARENT, mItemHeight);
				} else{
					lp.height = mItemHeight;
				}
				textView.setLayoutParams(lp);

				textView.setText(text);

				if (itemResourceId == TEXT_VIEW_ITEM_RESOURCE) {
                    configureTextView(textView);
                }

                //设置选中未选择的文字大小和颜色
				if (mCurrentCenterIndex == index) {
					textView.setTextColor(mSelectTextColor);
					textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mSelectTextSize);
				} else {
					textView.setTextColor(mNormalTextColor);
					textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mNormalTextSize);
				}
                textView.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
			}
			return convertView;
		}
		return null;
	}

	public CharSequence getItemText(int index) {
		if (index >= 0 && index < mData.size()) {
			return mData.get(index);
		}
		return null;
	}

	public int getItemsCount() {
		return mData.size();
	}
}
