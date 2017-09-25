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

import com.business.trip.model.BtHotelInfo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt hotel info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtHotelInfoPersistenceImpl
 * @see BtHotelInfoUtil
 * @generated
 */
public interface BtHotelInfoPersistence extends BasePersistence<BtHotelInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtHotelInfoUtil} to access the bt hotel info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @return the range of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo findByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo fetchByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo findByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo fetchByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt hotel infos before and after the current bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param btHotelInfoId the primary key of the current bt hotel info
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo[] findByT_T_PrevAndNext(
		long btHotelInfoId, java.lang.String ticketNo,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt hotel infos where ticketNo = &#63; and tripType = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_T(java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the number of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_T(java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @return the range of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo findByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo fetchByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo findByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo fetchByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt hotel infos before and after the current bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param btHotelInfoId the primary key of the current bt hotel info
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo[] findByB_T_PrevAndNext(
		long btHotelInfoId, long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the number of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bt hotel info in the entity cache if it is enabled.
	*
	* @param btHotelInfo the bt hotel info
	*/
	public void cacheResult(com.business.trip.model.BtHotelInfo btHotelInfo);

	/**
	* Caches the bt hotel infos in the entity cache if it is enabled.
	*
	* @param btHotelInfos the bt hotel infos
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtHotelInfo> btHotelInfos);

	/**
	* Creates a new bt hotel info with the primary key. Does not add the bt hotel info to the database.
	*
	* @param btHotelInfoId the primary key for the new bt hotel info
	* @return the new bt hotel info
	*/
	public com.business.trip.model.BtHotelInfo create(long btHotelInfoId);

	/**
	* Removes the bt hotel info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info that was removed
	* @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo remove(long btHotelInfoId)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtHotelInfo updateImpl(
		com.business.trip.model.BtHotelInfo btHotelInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt hotel info with the primary key or throws a {@link com.business.trip.NoSuchBtHotelInfoException} if it could not be found.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo findByPrimaryKey(
		long btHotelInfoId)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt hotel info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info, or <code>null</code> if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtHotelInfo fetchByPrimaryKey(
		long btHotelInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt hotel infos.
	*
	* @return the bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt hotel infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @return the range of bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt hotel infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtHotelInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt hotel infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt hotel infos.
	*
	* @return the number of bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}