package com.happy.happyFrame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.bmob.v3.listener.BmobUpdateListener;
import cn.bmob.v3.update.BmobUpdateAgent;
import cn.bmob.v3.update.UpdateResponse;
import cn.bmob.v3.update.UpdateStatus;

import com.gc.materialdesign.views.ProgressBarCircularIndetermininate;
import com.happy.happyFrame.R;
import com.happy.happyFrame.utils.Logger;
import com.happy.happyFrame.utils.ResolutionUtil;
import com.happy.happyFrame.utils.SysUtils;

public class SplashActivity extends BaseActivity {
	
	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			startActivity(new Intent(SplashActivity.this,MainActivity.class));
			finish();
		};
	};
	protected UpdateResponse ur;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		//在你需要调用自动更新功能之前先进行初始化建表操作
		BmobUpdateAgent.initAppVersion(this);
		
		ResolutionUtil resolution = new ResolutionUtil(this);
		TextView tv_ver = (TextView) findViewById(R.id.tv_version);
		tv_ver.setText("version:" + SysUtils.getVersion(this));
		RelativeLayout.LayoutParams verParams = (LayoutParams) tv_ver.getLayoutParams();
		verParams.topMargin = resolution.px2dp2px(800, false);
		
		ProgressBarCircularIndetermininate pb = (ProgressBarCircularIndetermininate)findViewById(R.id.progress);
		RelativeLayout.LayoutParams pb_params = (LayoutParams) pb.getLayoutParams();
		pb_params.topMargin = resolution.px2dp2px(700, false);
		
		
//		initUpdate();
		mHandler.sendEmptyMessageDelayed(0, 1000);
		
		
	}
	private void initUpdate() {
		BmobUpdateAgent.update(this);
		BmobUpdateAgent.setUpdateOnlyWifi(false);
		BmobUpdateAgent.initAppVersion(this);
		BmobUpdateAgent.setUpdateListener(new BmobUpdateListener() {
			
			@Override
			public void onUpdateReturned(int updateStatus, UpdateResponse updateInfo) {
				// TODO Auto-generated method stub
				if (updateStatus == UpdateStatus.Yes) {
					ur = updateInfo;
					Logger.i("update", updateInfo.path + ":" + updateInfo.version);
				}else{
					mHandler.sendEmptyMessageDelayed(0, 3000);
				}
			}
		});
	}


}
