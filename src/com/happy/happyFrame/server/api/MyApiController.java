package com.happy.happyFrame.server.api;

import java.util.HashMap;

import android.content.Context;

import com.happy.happyFrame.server.net.MyVolley;
import com.happy.happyFrame.server.net.MyVolley.VolleyCallBack;

public class MyApiController {
	
	
	private Context mContext;
	private VolleyCallBack mCallBack;
	private MyVolley myVolley;

	public MyApiController(Context ctx, VolleyCallBack callback){
		this.mContext = ctx;
		myVolley = new MyVolley(ctx, callback);
	}
	
	/**
	 * 模拟get请求
	 * @param params
	 */
	public void getHomePicData(int resquestCode,String params){
		String url = String.format("http://api.cstv.hiveview.com:80/user/friends/%s", params);
		myVolley.volleyGet(resquestCode, url, HomePicEntity.class);
	}
	
	/**
	 * 模拟post请求
	 * @param params
	 */
	public void getHomePicData2(int resquestCode,String params){
		String url = String.format("http://api.cstv.hiveview.com:80/user/friends/%s", params);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("city", "beijing");
		myVolley.volleyPost(resquestCode, url, HomePicEntity.class, map);
	}
	
	class HomePicEntity{
		private String picId;
		private String picUrl;
		public String getPicId() {
			return picId;
		}
		public void setPicId(String picId) {
			this.picId = picId;
		}
		public String getPicUrl() {
			return picUrl;
		}
		public void setPicUrl(String picUrl) {
			this.picUrl = picUrl;
		}
		
	}
	
}
