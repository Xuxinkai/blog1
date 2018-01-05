package cn.arice.com.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author Arice 徐新凯
 * @description DateHelper 时间帮助类
 * @data 2016-4-3
 */
public class DateHelper {
	
	public static String getDateTimeForNumber(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(new Date());
	}
	public static String getDateTimeFormat(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
	public static String getDateTimeFormatDuan(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	public static String getYearFormat(){
		SimpleDateFormat  sdf=new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}
}
