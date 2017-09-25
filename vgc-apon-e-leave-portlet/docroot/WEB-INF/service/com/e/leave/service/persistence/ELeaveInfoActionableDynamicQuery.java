/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.e.leave.service.persistence;

import com.e.leave.model.ELeaveInfo;
import com.e.leave.service.ELeaveInfoLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author EZEYIFE
 * @generated
 */
public abstract class ELeaveInfoActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ELeaveInfoActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ELeaveInfoLocalServiceUtil.getService());
		setClass(ELeaveInfo.class);

		setClassLoader(com.e.leave.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("eLeaveInfoId");
	}
}