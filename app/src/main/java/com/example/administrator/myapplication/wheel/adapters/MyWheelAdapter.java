package com.example.administrator.myapplication.wheel.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyWheelAdapter<T> extends AbstractWheelTextAdapter{
	private List<T> items;

	public MyWheelAdapter(Context context, List<T> items) {
		super(context);
		this.items = items;
	}

	@Override
	public View getItem(int index, View convertView, ViewGroup parent) {
		if (index >= 0 && index < getItemsCount()) {
			if (convertView == null) {
				convertView = getView(itemResourceId, parent);
			}
			TextView textView = getTextView(convertView, itemTextResourceId);
			textView.setTextColor(0xff4b4b4b);
			textView.setText(getItemText(index));
			textView.setGravity(Gravity.CENTER);
			textView.setLines(1);
			textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
			return convertView;
		}
		return null;
	}

	@Override
	public int getItemsCount() {
		return items == null ? 0 : items.size();
	}

	@Override
	protected CharSequence getItemText(int index) {
		if (index >= 0 && index < items.size()) {
			T item = items.get(index);
			if (item instanceof CharSequence) {
				return (CharSequence) item;
			}
			return item.toString();
		}
		return null;
	}
}
