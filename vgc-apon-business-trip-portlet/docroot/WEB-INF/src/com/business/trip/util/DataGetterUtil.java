
package com.business.trip.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import com.liferay.portal.kernel.util.StringPool;

public class DataGetterUtil {

	public static Date getDate(Object obj) {

		if (obj == null) {
			return null;
		}

		return (Date) obj;
	}

	public static String getString(Object obj) {

		if (obj == null) {
			return StringPool.BLANK;
		}

		return (String) obj;
	}

	public static int getInt(Object obj) {

		if (obj == null) {
			return ZERO_INT_VALUE;
		}
		else if (obj instanceof BigDecimal) {
			return Integer.parseInt(((BigDecimal) obj).toString());
		}
		else if (obj instanceof BigInteger) {
			return Integer.parseInt(((BigInteger) obj).toString());
		}
		else if (obj instanceof String) {
			return Integer.parseInt((String) obj);
		}
		else {
			return ZERO_INT_VALUE;
		}
	}

	public static double getDouble(Object obj) {

		if (obj == null) {
			return ZERO_INT_VALUE;
		}
		else if (obj instanceof BigDecimal) {
			return Double.parseDouble(((BigDecimal) obj).toString());
		}
		else if (obj instanceof BigInteger) {
			return Double.parseDouble(((BigInteger) obj).toString());
		}
		else if (obj instanceof String) {
			return Double.parseDouble((String) obj);
		}
		else {
			return ZERO_INT_VALUE;
		}
	}

	public static long getLong(Object obj) {

		if (obj == null) {
			return ZERO_LONG_VALUE;
		}
		else if (obj instanceof BigDecimal) {
			return Long.parseLong(((BigDecimal) obj).toString());
		}
		else if (obj instanceof BigInteger) {
			return Long.parseLong(((BigInteger) obj).toString());
		}
		else if (obj instanceof String) {
			return Long.parseLong((String) obj);
		}
		else {
			return ZERO_LONG_VALUE;
		}
	}

	private static final int ZERO_INT_VALUE = 0;
	private static final long ZERO_LONG_VALUE = 0;
}
