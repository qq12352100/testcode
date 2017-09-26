/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.business.trip.util;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.portlet.PortletProps;

public class PortletPropsValues {

	public static final String[] CITY_TYPE =
			StringUtil.split(PortletProps.get(PortletPropsKeys.CITY_TYPE), ",");

	public static final String[] ROOM_CATEGORY =
			StringUtil.split(PortletProps.get(PortletPropsKeys.ROOM_CATEGORY), ",");
	
	public static final String[] CURRENCY =
			StringUtil.split(PortletProps.get(PortletPropsKeys.CURRENCY), ",");
}