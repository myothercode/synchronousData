package com.util.commUtil.comm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;

import java.lang.reflect.Type;


public class JSONSimpler {
	static GsonBuilder gbuilder = new GsonBuilder().disableHtmlEscaping();// 不转义html标记
	static Gson gson = null;

	public static String toJson(Object beanClazz) {
		return toJson(beanClazz, null);
	}

	public static String toJson(Object beanClazz, TypeAdapter typeAdapter) {
		gson = gbuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();// 格式时间
		return gson.toJson(beanClazz);
	}

	public static Object fromJson(String jsonStr, Class beanClazz) {
		return fromJson(jsonStr, beanClazz, null);
	}
	
	public static Object fromJson(String jsonStr, Class beanClazz, TypeAdapter typeAdapter) {
		gson = gbuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();// 格式时间
		return gson.fromJson(jsonStr, beanClazz);
	}
	
	public static Object fromJson(String jsonStr, Type type) {
		return fromJson(jsonStr, type, null);
	}
	
	public static Object fromJson(String jsonStr, Type type, TypeAdapter typeAdapter) {
		gson = gbuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();// 格式时间
		return gson.fromJson(jsonStr, type);
	}
	
}
