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

package com.e.closing.service.persistence;

import com.e.closing.model.EClosing;
import com.e.closing.service.EClosingLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author t.a.jiang
 * @generated
 */
public abstract class EClosingActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public EClosingActionableDynamicQuery() throws SystemException {
		setBaseLocalService(EClosingLocalServiceUtil.getService());
		setClass(EClosing.class);

		setClassLoader(com.e.closing.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("eclosingId");
	}
}