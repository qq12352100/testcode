package com.e.onboarding.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.portal.kernel.util.Validator;

public class DateUtil {

	
	public static String formateDate(Date date)
	{
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	       String dateString = sdf.format(date); 
	       return dateString;
	}
	
	public static Date parseString(String dataString) throws ParseException{
		if(Validator.isNull(dataString))
		{
			return null;
		}
		  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");  
		  return sdf.parse(dataString);
	}
	
	
}
