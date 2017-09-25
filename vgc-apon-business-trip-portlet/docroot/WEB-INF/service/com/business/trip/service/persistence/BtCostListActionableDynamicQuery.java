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

package com.business.trip.service.persistence;

import com.business.trip.model.BtCostList;
import com.business.trip.service.BtCostListLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BtCostListActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public BtCostListActionableDynamicQuery() throws SystemException {
		setBaseLocalService(BtCostListLocalServiceUtil.getService());
		setClass(BtCostList.class);

		setClassLoader(com.business.trip.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("btCostListId");
	}
}