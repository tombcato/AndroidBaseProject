package com.happy.happyFrame;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import cn.bmob.v3.Bmob;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.happy.happyFrame.utils.ResolutionUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class APP extends Application {
	public static String APPID = "df470c0e32b549db2a41182701fde031";
	
	private static APP app;
	private RequestQueue queue;

	private ResolutionUtil resolution;

	private static DisplayImageOptions options;
	@Override
	public void onCreate() {
		super.onCreate();
		Bmob.initialize(this, APPID);
		
		//����Application
		app = this;
		//�����ʼ��Volley����
		queue = Volley.newRequestQueue(getApplicationContext());
		resolution = new ResolutionUtil(this);
		
		//ȫ������ImageLoader
        initImageLoader(getApplicationContext());
        
        //ע������������
//        CrashHandler.getInstance().init(getApplicationContext());
	}
	 /** ��ȡApplication */
    public static APP getApp() {
        return app;
    }
    /**
     * ��ȡVolleyʵ�����?
     */
    public RequestQueue getVolleyQueue() {
		return queue;
	}
    
    public ResolutionUtil getResolution(){
    	return resolution;
    }
	
	/** ��ʼ��ImageLoader */
    public void initImageLoader(Context context) {
    	options = new DisplayImageOptions.Builder()  
                .showImageOnLoading(R.drawable.ic_launcher)  
                .showImageOnFail(R.drawable.ic_launcher)  
                .cacheInMemory(true)  
                .cacheOnDisc(true) 
                .bitmapConfig(Bitmap.Config.RGB_565)  
                .build(); 
    	//创建默认的ImageLoader配置参数  
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);  
        //Initialize ImageLoader with configuration.  
        ImageLoader.getInstance().init(configuration);  
    }
    
    public DisplayImageOptions getDefalutOptions(){
        return options;
    }
    
    
	
}
