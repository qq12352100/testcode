package com.business.trip.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TravelExpenseUtil {

	public static void main(String[] args) throws ParseException {
//		Date date1 = StringToDate("29.02.2016 12:15", "dd.MM.yyyy HH:mm");
//		Date date2 = StringToDate("29.02.2016 14:05", "dd.MM.yyyy HH:mm");
//		System.out.println(hoursBetween(date1, date2));
		System.out.println(timeBetween("16:58", "23:59"));
		System.out.println(getTravelDateAsMany(new Date(),15));
	}
	
	public static String getTravelDateAsMany(Date date,int index){
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, index);//增加一天   
         //cd.add(Calendar.MONTH, n);//增加一个月   
          return sdf.format(cal.getTime());   
		
	}
	/**
	 * 计算俩个时间的分钟差
	 */
	public static float timeBetween(String dep, String  arr){
		int dep_hours_minute=Integer.valueOf(dep.split(":")[0])*60;
		int dep_minute=Integer.valueOf(dep.split(":")[1]);
		int depallminute=dep_hours_minute+dep_minute;
		int arr_hours_minute=Integer.valueOf(arr.split(":")[0])*60;
		int arr_minute=Integer.valueOf(arr.split(":")[1]);
		int arrallminute=arr_hours_minute+arr_minute;
		return (arrallminute-depallminute)/60f;
	}
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int hoursBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600);

		return Integer.parseInt(String.valueOf(between_days));
	}
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	public static boolean eqTravelExpenseDate(Date date1, Date date2) {
		return getDateFormat("dd.MM.yyyy").format(date1).equals(
				getDateFormat("dd.MM.yyyy").format(date2));
	}

	public static int subTravelExpenseDateHours(Date date1, Date date2) {
		return getHour(date2) - getHour(date1);
	}


	/**
	 * 获取SimpleDateFormat
	 * 
	 * @param parttern
	 *            日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException
	 *             异常：非法日期格式
	 */
	private static SimpleDateFormat getDateFormat(String parttern)
			throws RuntimeException {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 获取日期的天数。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 天
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DATE);
	}

	/**
	 * 获取日期的小时。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 小时
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期中的某数值。如获取月份
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            日期格式
	 * @return 数值
	 */
	private static int getInteger(Date date, int dateType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType);
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param parttern
	 *            日期格式
	 * @return 日期
	 */
	public static Date StringToDate(String date, String parttern) {
		Date myDate = null;
		if (date != null) {
			try {
				myDate = getDateFormat(parttern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}
}
