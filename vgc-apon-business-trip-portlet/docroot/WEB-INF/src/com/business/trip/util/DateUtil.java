/**
 * Copyright (c) 2000-2009 liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.business.trip.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Company;
import com.liferay.portal.util.PortalUtil;

/**
 * format date util method
 * @author CN03303
 * 
 */

public class DateUtil {
	
	private static Log _log = LogFactoryUtil.getLog(DateUtil.class);
	
	private static final String DATEFORMAT ="MM/dd/yyyy";
	private static final String DATETIMEFORMAT ="yyyy-MM-dd HH:mm:ss";
	private static final String TIMEFORMAT = "HH:mm:ss";
	private static final String DATEFORMAT2 = "yyyy-MM-dd";
	private static final String DATEFORMAT_YMD = "yyyyMMdd";
	private static final String DATEFORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
	
	public static Date getCurrentLocalDateTime(TimeZone timeZone) {
		int offset = timeZone.getRawOffset();
		Date nowDateTime = new Date(System.currentTimeMillis() + offset);
		return nowDateTime;
	}
/*
	public static Date getCurrentLocalDateTime(long  companyId)
	throws PortalException, SystemException {
		
		Company company = CompanyLocalServiceUtil.getCompany(companyId);
		return getCurrentLocalDateTime(company.getTimeZone());
	}
*/
	public static Date getCurrentLocalDateTime(PortletRequest portletRequest)
			throws PortalException, SystemException {

		Company company = PortalUtil.getCompany(portletRequest);
		return getCurrentLocalDateTime(company.getTimeZone());
	}

	
	/**
	 * yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static String formatYMDHm(Date date) {
		String txt = StringPool.BLANK;
		if (date != null) {
			txt = new SimpleDateFormat(DATEFORMAT_YYYYMMDDHHMM).format(date);
		}
		return txt;
	}

	/**
	 * parse yyyy-MM-dd HH:mm
	 * @param date
	 * @return
	 */
	public static Date parseYMDHm(String txt){
		Date date = new Date();
		if(txt!= null && txt.length()>0){
			try {
				date =  new SimpleDateFormat(DATEFORMAT_YYYYMMDDHHMM).parse(txt);
			} catch (ParseException e) {
				_log.error("Parse date from text failed, ignore and return current date!", e);
			}
		}
		return date;
	}
	

	public static String format(Date date) {
		String txt = "";
		if (date != null) {
			txt = new SimpleDateFormat(DATEFORMAT).format(date);
		}
		return txt;
	}

	public static String formatTime(Date date) {
		String txt = "";
		if (date != null) {
			txt = new SimpleDateFormat(TIMEFORMAT).format(date);
		}
		return txt;
	}

	public static String formatDateTime(Date date) {
		String txt = "";
		if (date != null) {
			txt = new SimpleDateFormat(DATETIMEFORMAT).format(date);
		}
		return txt;
	}

	/**
	 * parse date time yyyyMMdd HH:MM:SS
	 * @param txt
	 * @return
	 */
	public static Date parseYMDHMS(String txt) {
		Date date = new Date();
		if (txt != null && txt.length() > 0) {
			try {
				date = new SimpleDateFormat(DATETIMEFORMAT).parse(txt);
			} catch (ParseException e) {
				_log.error(
						"Parse date from text failed, ignore and return current date!",
						e);
			}
		}
		return date;
	}
	
	
	public static Date parse(String txt) {
		Date date = new Date();
		if (txt != null && txt.length() > 0) {
			try {
				date = new SimpleDateFormat(DATEFORMAT).parse(txt);
			} catch (ParseException e) {
				_log.error(
						"Parse date from text failed, ignore and return current date!",
						e);
			}
		}
		return date;
	}

	public static String format2yyyy_MM_dd(Date date) {
		String txt = "";
		if (date != null) {
			txt = new SimpleDateFormat(DATEFORMAT2).format(date);
		}
		return txt;
	}

	/**
	 * parse date
	 * @param txt
	 * @return
	 */
	public static Date parseYMD(String txt) {
		Date date = new Date();
		if (txt != null && txt.length() > 0) {
			try {
				date = new SimpleDateFormat(DATEFORMAT2).parse(txt);
			} catch (ParseException e) {
				_log.error(
						"Parse date from text failed, ignore and return current date!",
						e);
			}
		}
		return date;
	}
	
	/**
	 * format date to yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String format_yyyyMMdd(Date date) {
		String txt = "";
		if (date != null) {
			txt = new SimpleDateFormat(DATEFORMAT_YMD).format(date);
		}
		return txt;
	}

	/**
	 * parse date to yyyyMMdd
	 * @param txt
	 * @return
	 */
	public static Date parse_yyyyMMdd(String txt) {
		Date date = new Date();
		if (txt != null && txt.length() > 0) {
			try {
				date = new SimpleDateFormat(DATEFORMAT_YMD).parse(txt);
			} catch (ParseException e) {
				_log.error(
						"Parse date from text failed, ignore and return current date!",
						e);
			}
		}
		return date;
	}
	
	
	public static Date getCurrentGMTDateTime(TimeZone timeZone,
			Date localDateTime) {
		int offset = timeZone.getRawOffset();
		Date nowDateTime = new Date(localDateTime.getTime() - offset);
		return nowDateTime;
	}

	


	public static long getHourFromMinute(long mss) {
		return (mss % (60 * 60 * 24)) / (60 * 60);
	}

	public static long getMinuteFromMinute(long mss) {
		return (mss % (60 * 60)) / (60);
	}

	public static long getSecondeFromMinute(long mss) {
		return (mss % 60);
	}

	public static long getDayFromMinute(long mss) {
		return mss / (60 * 60 * 24);
	}

	/**
	 * ����趨ʱ �� �� ��ʱ��
	 * 
	 * @param date
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date getSettingHms(Date date, int hour, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);

		return calendar.getTime();
	}
	/*
	 * public static String formatDuring(long mss) { long days = mss / (1000 *
	 * 60 * 60 * 24); long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 *
	 * 60); long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60); long seconds
	 * = (mss % (1000 * 60)) / 1000; return days +
	 * "�? + hours + "小时" + minutes + "�? + seconds + "�?; }
	 */
	
	public static String  getCalendarField(int field) {
//		TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
//		Calendar calendar = Calendar.getInstance(timeZone);
		Calendar calendar = Calendar.getInstance();
		int intValue = 0;
		if(Calendar.MONTH == field){
			intValue = calendar.get(field)+1;
		}else{
			intValue = calendar.get(field);
		}
		String strValue = String.valueOf(intValue);	
		return strValue;
	}
	
	
	public static boolean isFirstDayOfMonth(){
		boolean flag = false;
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if(day==1){
			flag = true;
		}		
		return flag;
	}
	
	public static boolean checkDayIsFirstDayOfMonth(Date date){
		boolean flag = false;
		Calendar calendar = Calendar.getInstance();     
	    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
	    String theFirstDay = format2yyyy_MM_dd(calendar.getTime());
	    String theDate = format2yyyy_MM_dd(date);
	    if(theFirstDay.equals(theDate)){
	    	flag = true;
	    }
		return flag;
	}

}