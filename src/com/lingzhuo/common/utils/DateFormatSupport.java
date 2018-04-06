/**
 * 
 */
package com.lingzhuo.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: DataFormatSupport
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author LHX
 * @date 2017年9月5日 下午8:35:40
 *
 */
public class DateFormatSupport {
	/**
	 * yyyyMMdd->yyyy-MM-dd
	 * */
	public static String format1(String dataStr){
		String res="";
		if(dataStr!=null&&!dataStr.trim().equals("")){
			SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
			Date day=null;
			try {
				day=f.parse(dataStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleDateFormat fn =new SimpleDateFormat("yyyy-MM-dd");
			res=fn.format(day);
		}
		
		return res;
	
	}
	 /**
		 * HHmmss->HH:mm:ss
	   */
	public static String format2(String dataStr){
		String res="";
		if(dataStr!=null&&!dataStr.trim().equals("")){
			SimpleDateFormat f=new SimpleDateFormat("HHmmss");
			Date day=null;
			try {
				day=f.parse(dataStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleDateFormat fn =new SimpleDateFormat("HH:mm:ss");
			res=fn.format(day);
		}
		
		return res;
	
	}
	/**
	 * yyyyMMddHHmmss->yyyy-MM-dd HH:mm:ss
   */
	public static String format3(String dataStr){
		String res="";
		if(dataStr!=null&&!dataStr.trim().equals("")){
			SimpleDateFormat f=new SimpleDateFormat("yyyyMMddHHmmss");
			Date day=null;
			try {
				day=f.parse(dataStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SimpleDateFormat fn =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			res=fn.format(day);
		}
		
		return res;
	
	}

	public static String getNowDateStr(){
		SimpleDateFormat f=new SimpleDateFormat("yyyyMMdd");
		Date day=new Date();
		String str =f.format(day);
		return str;
		
	}
	public static String getNowDateTimeStr(){
		SimpleDateFormat f=new SimpleDateFormat("HHmmss");
		Date day=new Date();
		String str =f.format(day);
		return str;
		
	}
}
