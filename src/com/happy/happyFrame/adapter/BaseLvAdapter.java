package com.happy.happyFrame.adapter;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class BaseLvAdapter<T> extends BaseAdapter {
	
	protected Context ct;
	protected List<T> lists;
	protected LayoutInflater mInflater;
	
	public BaseLvAdapter() {
		super();
	}

	public BaseLvAdapter(Context ct, List<T> lists) {
		super();
		this.ct = ct;
		this.lists = lists;
		init();
	}
	
	public void changeAdapterData(List<T> lists){
		this.lists = lists;
		init();
	}

	private void init() {
		mInflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		if(lists == null) 
			return 0;
		else 
			return lists.size();
	}

	@Override
	public Object getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public abstract View getView(int position, View convertView, ViewGroup parent);
	
	public void insert(int position , T data){  
        lists.add(position, data);  
        this.notifyDataSetChanged();  
	} 
	
	public void removeItem(int position){  
        if(lists.size()<=0)return;  
        if(position<0)return;  
        if(position>lists.size()-1)return;  
          
        lists.remove(position);  
        this.notifyDataSetChanged();  
    }  

}
 
	