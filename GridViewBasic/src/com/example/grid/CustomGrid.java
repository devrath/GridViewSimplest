package com.example.grid;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.GridViewBasic.R;

public class CustomGrid extends BaseAdapter{
	
	private Context mContext;
	LinkedList<LinkedHashMap<String, String>> messengerListObject;
	
	public CustomGrid(Context _mContext,LinkedList<LinkedHashMap<String, String>> _messengerListObject) {
		messengerListObject=_messengerListObject;
		mContext=_mContext;
	}
	
	@Override
	public int getCount() {
		return messengerListObject.size();
	}
	
	@Override
	public Object getItem(int position) {
		return null;
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	class ViewHolder {
		public TextView textView;

		public ViewHolder(View base) {
			textView = (TextView) base.findViewById(R.id.textView);
		}
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = convertView;  
		ViewHolder vHolder;  
		
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(R.layout.grid_single, null);
			vHolder = new ViewHolder(view);
			view.setTag(vHolder);  
		} else {  
			vHolder = (ViewHolder) view.getTag();  
		}
		
		HashMap<String, String> messengerMapObject= messengerListObject.get(position);

		for (Entry<String, String> entry : messengerMapObject.entrySet()) {	
			vHolder.textView.setText(entry.getValue());
		}
		
		return view;
	}
}