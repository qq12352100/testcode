package com.e.leave.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

public class TicketNoGeneration {
	/**
	 * Generate the ticket no for the workflow
	 * for example:HC20150300000001
	 */
	public static String generateTicketNo(String prefix) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String name = prefix + dateFormat.format(date);
		long number = 0L;

		try {
			number = CounterLocalServiceUtil.increment(name, 1);
	
			return name + String.format("%07d", number, 1);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
