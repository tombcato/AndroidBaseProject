package com.happy.happyFrame.utils;import android.util.Log;public class Logger {	/**	 * @author kylinhuang	 * 	 *         切记发布之前更改logger中logleve的级�?	 * 	 *         当前的信息级�?当级别小�?是打印所有的log（开发时�?当级别大�?是不打印log（开发完成时�?	 * */	private static final int LOGLEVER = 0;	private static final int VERBOSE = 1;	private static final int DEBUG = 2;	private static final int INFO = 3;	private static final int WARN = 4;	private static final int ERROR = 5;	public static void v(String tag, String msg) {		if (LOGLEVER < VERBOSE) {			Log.v(tag, msg);		}	}	public static void d(String tag, String msg) {		if (LOGLEVER < DEBUG) {			Log.d(tag, msg);		}	}	public static void i(String tag, String msg) {		if (LOGLEVER < INFO) {			Log.i(tag, msg);		}	}	public static void w(String tag, String msg) {		if (LOGLEVER < WARN) {			Log.w(tag, msg);		}	}	public static void e(String tag, String msg) {		if (LOGLEVER < ERROR) {			Log.e(tag, msg);		}	}}