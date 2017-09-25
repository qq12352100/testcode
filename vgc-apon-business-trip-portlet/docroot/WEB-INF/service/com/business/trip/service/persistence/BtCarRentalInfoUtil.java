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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt car rental info service. This utility wraps {@link BtCarRentalInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfoPersistence
 * @see BtCarRentalInfoPersistenceImpl
 * @generated
 */
public class BtCarRentalInfoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(BtCarRentalInfo btCarRentalInfo) {
		getPersistence().clearCache(btCarRentalInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BtCarRentalInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtCarRentalInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtCarRentalInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtCarRentalInfo update(BtCarRentalInfo btCarRentalInfo)
		throws SystemException {
		return getPersistence().update(btCarRentalInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtCarRentalInfo update(BtCarRentalInfo btCarRentalInfo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(btCarRentalInfo, serviceContext);
	}

	/**
	* Returns all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(ticketNo, tripType);
	}

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
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(ticketNo, tripType, start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T(ticketNo, tripType, start, end, orderByComparator);
	}

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
	public static com.business.trip.model.BtCarRentalInfo findByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_First(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the first bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo fetchByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_First(ticketNo, tripType, orderByComparator);
	}

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
	public static com.business.trip.model.BtCarRentalInfo findByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_Last(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the last bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo fetchByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_Last(ticketNo, tripType, orderByComparator);
	}

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
	public static com.business.trip.model.BtCarRentalInfo[] findByT_T_PrevAndNext(
		long btCarRentalInfoId, java.lang.String ticketNo,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_PrevAndNext(btCarRentalInfoId, ticketNo,
			tripType, orderByComparator);
	}

	/**
	* Removes all the bt car rental infos where ticketNo = &#63; and tripType = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByT_T(java.lang.String ticketNo,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByT_T(ticketNo, tripType);
	}

	/**
	* Returns the number of bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the number of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_T(java.lang.String ticketNo,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_T(ticketNo, tripType);
	}

	/**
	* Returns all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_T(businessTripPkId, tripType);
	}

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
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_T(businessTripPkId, tripType, start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T(businessTripPkId, tripType, start, end,
			orderByComparator);
	}

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
	public static com.business.trip.model.BtCarRentalInfo findByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_First(businessTripPkId, tripType,
			orderByComparator);
	}

	/**
	* Returns the first bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo fetchByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_T_First(businessTripPkId, tripType,
			orderByComparator);
	}

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
	public static com.business.trip.model.BtCarRentalInfo findByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_Last(businessTripPkId, tripType, orderByComparator);
	}

	/**
	* Returns the last bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo fetchByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_T_Last(businessTripPkId, tripType,
			orderByComparator);
	}

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
	public static com.business.trip.model.BtCarRentalInfo[] findByB_T_PrevAndNext(
		long btCarRentalInfoId, long businessTripPkId,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_PrevAndNext(btCarRentalInfoId, businessTripPkId,
			tripType, orderByComparator);
	}

	/**
	* Removes all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByB_T(businessTripPkId, tripType);
	}

	/**
	* Returns the number of bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the number of matching bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByB_T(businessTripPkId, tripType);
	}

	/**
	* Caches the bt car rental info in the entity cache if it is enabled.
	*
	* @param btCarRentalInfo the bt car rental info
	*/
	public static void cacheResult(
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo) {
		getPersistence().cacheResult(btCarRentalInfo);
	}

	/**
	* Caches the bt car rental infos in the entity cache if it is enabled.
	*
	* @param btCarRentalInfos the bt car rental infos
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtCarRentalInfo> btCarRentalInfos) {
		getPersistence().cacheResult(btCarRentalInfos);
	}

	/**
	* Creates a new bt car rental info with the primary key. Does not add the bt car rental info to the database.
	*
	* @param btCarRentalInfoId the primary key for the new bt car rental info
	* @return the new bt car rental info
	*/
	public static com.business.trip.model.BtCarRentalInfo create(
		long btCarRentalInfoId) {
		return getPersistence().create(btCarRentalInfoId);
	}

	/**
	* Removes the bt car rental info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btCarRentalInfoId the primary key of the bt car rental info
	* @return the bt car rental info that was removed
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo remove(
		long btCarRentalInfoId)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btCarRentalInfoId);
	}

	public static com.business.trip.model.BtCarRentalInfo updateImpl(
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btCarRentalInfo);
	}

	/**
	* Returns the bt car rental info with the primary key or throws a {@link com.business.trip.NoSuchBtCarRentalInfoException} if it could not be found.
	*
	* @param btCarRentalInfoId the primary key of the bt car rental info
	* @return the bt car rental info
	* @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo findByPrimaryKey(
		long btCarRentalInfoId)
		throws com.business.trip.NoSuchBtCarRentalInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btCarRentalInfoId);
	}

	/**
	* Returns the bt car rental info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btCarRentalInfoId the primary key of the bt car rental info
	* @return the bt car rental info, or <code>null</code> if a bt car rental info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCarRentalInfo fetchByPrimaryKey(
		long btCarRentalInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btCarRentalInfoId);
	}

	/**
	* Returns all the bt car rental infos.
	*
	* @return the bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtCarRentalInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt car rental infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt car rental infos.
	*
	* @return the number of bt car rental infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtCarRentalInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtCarRentalInfoPersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtCarRentalInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(BtCarRentalInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtCarRentalInfoPersistence persistence) {
	}

	private static BtCarRentalInfoPersistence _persistence;
}