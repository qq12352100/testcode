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

import com.business.trip.model.BtCarRentalInfo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt car rental info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfoPersistenceImpl
 * @see BtCarRentalInfoUtil
 * @generated
 */
public interface BtCarRentalInfoPersistence extends BasePersistence<BtCarRentalInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtCarRentalInfoUtil} to access the bt car rental info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param start the lower bound of the range of bt car rental infos
	* @param end the upper bound of the range of bt car rental infos (not inclusive)
	* @return the range of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param start the lower bound of the range of bt car rental infos
	* @param end the upper bound of the range of bt car rental infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo findByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo fetchByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo findByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo fetchByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt car rental infos before and after the current bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param btCarRentalInfoId the primary key of the current bt car rental info
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo[] findByT_T_PrevAndNext(
		long btCarRentalInfoId, java.lang.String ticketNo,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt car rental infos where ticketNo = &#63; and tripType = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_T(java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the number of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_T(java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param start the lower bound of the range of bt car rental infos
	* @param end the upper bound of the range of bt car rental infos (not inclusive)
	* @return the range of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param start the lower bound of the range of bt car rental infos
	* @param end the upper bound of the range of bt car rental infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo findByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo fetchByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo findByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo fetchByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt car rental infos before and after the current bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param btCarRentalInfoId the primary key of the current bt car rental info
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo[] findByB_T_PrevAndNext(
		long btCarRentalInfoId, long businessTripPkId,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the number of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bt car rental info in the entity cache if it is enabled.
	*
	* @param btCarRentalInfo the bt car rental info
	*/
	public void cacheResult(
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo);

	/**
	* Caches the bt car rental infos in the entity cache if it is enabled.
	*
	* @param btCarRentalInfos the bt car rental infos
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtCarRentalInfo> btCarRentalInfos);

	/**
	* Creates a new bt car rental info with the primary key. Does not add the bt car rental info to the database.
	*
	* @param btCarRentalInfoId the primary key for the new bt car rental info
	* @return the new bt car rental info
	*/
	public com.business.trip.model.BtCarRentalInfo create(
		long btCarRentalInfoId);

	/**
	* Removes the bt car rental info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btCarRentalInfoId the primary key of the bt car rental info
	* @return the bt car rental info that was removed
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo remove(
		long btCarRentalInfoId)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtCarRentalInfo updateImpl(
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt car rental info with the primary key or throws a {@link com.business.trip.NoSuchBtCarRentalInfoException} if it could not be found.
	*
	* @param btCarRentalInfoId the primary key of the bt car rental info
	* @return the bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo findByPrimaryKey(
		long btCarRentalInfoId)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt car rental info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btCarRentalInfoId the primary key of the bt car rental info
	* @return the bt car rental info, or <code>null</code> if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCarRentalInfo fetchByPrimaryKey(
		long btCarRentalInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt car rental infos.
	*
	* @return the bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt car rental infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt car rental infos
	* @param end the upper bound of the range of bt car rental infos (not inclusive)
	* @return the range of bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt car rental infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt car rental infos
	* @param end the upper bound of the range of bt car rental infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCarRentalInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt car rental infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt car rental infos.
	*
	* @return the number of bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}