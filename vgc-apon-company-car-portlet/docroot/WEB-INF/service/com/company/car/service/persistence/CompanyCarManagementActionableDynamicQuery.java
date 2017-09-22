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

package com.company.car.service.persistence;

import com.company.car.model.CompanyCarManagement;
import com.company.car.service.CompanyCarManagementLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class CompanyCarManagementActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CompanyCarManagementActionableDynamicQuery()
		throws SystemException {
		setBaseLocalService(CompanyCarManagementLocalServiceUtil.getService());
		setClass(CompanyCarManagement.class);

		setClassLoader(com.company.car.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("companyCarManagementId");
	}
}