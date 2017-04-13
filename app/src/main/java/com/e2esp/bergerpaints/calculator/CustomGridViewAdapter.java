package com.e2esp.bergerpaints.calculator;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.e2esp.bergerpaints.calculator.Model.Paint_list;
import com.e2esp.bergerpaints.calculator.R;


public class CustomGridViewAdapter extends ArrayAdapter<Paint_list> {
	Context context;

	Paint_list[] paint_list ={};

	public CustomGridViewAdapter(Context context,Paint_list[] paint_list) {
		super(context, R.layout.color_box, paint_list);
		this.context = context;
		this.paint_list = paint_list;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;

		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(R.layout.color_box, parent, false);
			holder = new RecordHolder();

			holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
			holder.backg = (ImageView) row.findViewById(R.id.backgrond);

			row.setTag(holder);
		} else {
			holder = (RecordHolder) row.getTag();
		}
		holder.backg.setImageDrawable(context.getResources().getDrawable(paint_list[position].getImage_id()));
		holder.txtTitle.setText(paint_list[position].getName());

		if(position==Paint_Select.extra_postion){
			holder.backg.setBackgroundResource(R.drawable.select_image_boder);
		}else{

			holder.backg.setBackgroundColor(Color.TRANSPARENT);
		}


		return row;

	}

	static class RecordHolder {
		TextView txtTitle;
		ImageView backg;
	}
}