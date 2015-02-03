package com.happy.happyFrame.view;

import android.view.View;

/**
 * listAsGrid itemclick
 * @author Amor
 *
 */
public interface GridItemClickListener {

	void onGridItemClicked(View v, int position, long itemId);
	void onGridItemLongClicked(View v,int position, long itemId);
}