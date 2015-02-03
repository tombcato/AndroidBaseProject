package com.happy.happyFrame.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.happy.happyFrame.R;
import com.lidroid.xutils.BitmapUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.squareup.picasso.Picasso.LoadedFrom;

public class MainActivity extends BaseActivity {
	private String imgUrl = "http://d.hiphotos.baidu.com/image/pic/item/4b90f603738da9772a1d41e4b251f8198718e3cb.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final RelativeLayout rl_bg = (RelativeLayout) findViewById(R.id.rl_bg);
		ImageView iv_img = (ImageView) findViewById(R.id.iv_img);
		BitmapUtils bitmapUtils = new BitmapUtils(this);
//		bitmapUtils.display(rl_bg, imgUrl);
		ImageLoader.getInstance().loadImage(imgUrl, new ImageLoadingListener() {
			
			@Override
			public void onLoadingStarted(String imageUri, View view) {
				
			}
			
			@Override
			public void onLoadingFailed(String imageUri, View view,
					FailReason failReason) {
				
			}
			
			@Override
			public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
				rl_bg.setBackgroundDrawable(new BitmapDrawable(loadedImage));
			}
			
			@Override
			public void onLoadingCancelled(String imageUri, View view) {
				
			}
		});
	}

}
