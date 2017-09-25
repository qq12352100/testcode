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

import com.business.trip.model.BtReimbursementSAPInfo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt reimbursement s a p info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfoPersistenceImpl
 * @see BtReimbursementSAPInfoUtil
 * @generated
 */
public interface BtReimbursementSAPInfoPersistence extends BasePersistence<BtReimbursementSAPInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtReimbursementSAPInfoUtil} to access the bt reimbursement s a p info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or throws a {@link com.business.trip.NoSuchBtReimbursementSAPInfoException} if it could not be found.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the matching bt reimbursement s a p info
	* @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a matching bt reimbursement s a p info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo findByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the matching bt reimbursement s a p info, or <code>null</code> if a matching bt reimbursement s a p info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo fetchByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bt reimbursement s a p info, or <code>null</code> if a matching bt reimbursement s a p info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo fetchByB_C(
		java.lang.String currency, long businessTripPkId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; from the database.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the bt reimbursement s a p info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo removeByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt reimbursement s a p infos where currency = &#63; and businessTripPkId = &#63;.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the number of matching bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByB_C(java.lang.String currency, long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bt reimbursement s a p info in the entity cache if it is enabled.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	*/
	public void cacheResult(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo);

	/**
	* Caches the bt reimbursement s a p infos in the entity cache if it is enabled.
	*
	* @param btReimbursementSAPInfos the bt reimbursement s a p infos
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtReimbursementSAPInfo> btReimbursementSAPInfos);

	/**
	* Creates a new bt reimbursement s a p info with the primary key. Does not add the bt reimbursement s a p info to the database.
	*
	* @param btReimbursementSAPInfoId the primary key for the new bt reimbursement s a p info
	* @return the new bt reimbursement s a p info
	*/
	public com.business.trip.model.BtReimbursementSAPInfo create(
		long btReimbursementSAPInfoId);

	/**
	* Removes the bt reimbursement s a p info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was removed
	* @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo remove(
		long btReimbursementSAPInfoId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtReimbursementSAPInfo updateImpl(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt reimbursement s a p info with the primary key or throws a {@link com.business.trip.NoSuchBtReimbursementSAPInfoException} if it could not be found.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info
	* @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo findByPrimaryKey(
		long btReimbursementSAPInfoId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt reimbursement s a p info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info, or <code>null</code> if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtReimbursementSAPInfo fetchByPrimaryKey(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt reimbursement s a p infos.
	*
	* @return the bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtReimbursementSAPInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt reimbursement s a p infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt reimbursement s a p infos
	* @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	* @return the range of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtReimbursementSAPInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt reimbursement s a p infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt reimbursement s a p infos
	* @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtReimbursementSAPInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt reimbursement s a p infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt reimbursement s a p infos.
	*
	* @return the number of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}