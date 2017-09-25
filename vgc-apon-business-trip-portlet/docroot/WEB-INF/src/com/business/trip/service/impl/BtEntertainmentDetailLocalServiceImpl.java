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

package com.business.trip.service.impl;

import java.util.List;

import com.business.trip.model.BtEntertainmentDetail;
import com.business.trip.service.base.BtEntertainmentDetailLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;


/**
 * The implementation of the bt entertainment detail local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.business.trip.service.BtEntertainmentDetailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.base.BtEntertainmentDetailLocalServiceBaseImpl
 * @see com.business.trip.service.BtEntertainmentDetailLocalServiceUtil
 */
public class BtEntertainmentDetailLocalServiceImpl
	extends BtEntertainmentDetailLocalServiceBaseImpl {
	//find BtEntertainmentDetails
	public List<BtEntertainmentDetail> findByBtCostListId(long btCostListId) throws SystemException {
		return btEntertainmentDetailPersistence.findByBtCostListId(btCostListId);
	}
}