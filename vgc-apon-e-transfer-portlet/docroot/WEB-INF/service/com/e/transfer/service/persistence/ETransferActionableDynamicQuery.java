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

package com.e.transfer.service.persistence;

import com.e.transfer.model.ETransfer;
import com.e.transfer.service.ETransferLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author EZEYIFE
 * @generated
 */
public abstract class ETransferActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public ETransferActionableDynamicQuery() throws SystemException {
		setBaseLocalService(ETransferLocalServiceUtil.getService());
		setClass(ETransfer.class);

		setClassLoader(com.e.transfer.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("eTransferId");
	}
}