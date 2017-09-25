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

import com.e.leave.model.ELeave;
import com.e.leave.service.ELeaveLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author EZEYIFE
 * @generated
 */
public abstract class ELeaveActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ELeaveActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ELeaveLocalServiceUtil.getService());
		setClass(ELeave.class);

		setClassLoader(com.e.leave.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("eLeaveId");
	}
}