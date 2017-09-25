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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt hotel info service. This utility wraps {@link BtHotelInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtHotelInfoPersistence
 * @see BtHotelInfoPersistenceImpl
 * @generated
 */
public class BtHotelInfoUtil {
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
	public static void clearCache(BtHotelInfo btHotelInfo) {
		getPersistence().clearCache(btHotelInfo);
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
	public static List<BtHotelInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtHotelInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtHotelInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtHotelInfo update(BtHotelInfo btHotelInfo)
		throws SystemException {
		return getPersistence().update(btHotelInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtHotelInfo update(BtHotelInfo btHotelInfo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(btHotelInfo, serviceContext);
	}

	/**
	* Returns all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtHotelInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(ticketNo, tripType);
	}

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
	public static java.util.List<com.business.trip.model.BtHotelInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(ticketNo, tripType, start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtHotelInfo> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T(ticketNo, tripType, start, end, orderByComparator);
	}

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
	public static com.business.trip.model.BtHotelInfo findByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_First(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the first bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo fetchByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_First(ticketNo, tripType, orderByComparator);
	}

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
	public static com.business.trip.model.BtHotelInfo findByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_Last(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the last bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo fetchByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_Last(ticketNo, tripType, orderByComparator);
	}

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
	public static com.business.trip.model.BtHotelInfo[] findByT_T_PrevAndNext(
		long btHotelInfoId, java.lang.String ticketNo,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_PrevAndNext(btHotelInfoId, ticketNo, tripType,
			orderByComparator);
	}

	/**
	* Removes all the bt hotel infos where ticketNo = &#63; and tripType = &#63; from the database.
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
	* Returns the number of bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the number of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_T(java.lang.String ticketNo,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_T(ticketNo, tripType);
	}

	/**
	* Returns all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_T(businessTripPkId, tripType);
	}

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
	public static java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_T(businessTripPkId, tripType, start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T(businessTripPkId, tripType, start, end,
			orderByComparator);
	}

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
	public static com.business.trip.model.BtHotelInfo findByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_First(businessTripPkId, tripType,
			orderByComparator);
	}

	/**
	* Returns the first bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo fetchByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_T_First(businessTripPkId, tripType,
			orderByComparator);
	}

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
	public static com.business.trip.model.BtHotelInfo findByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_Last(businessTripPkId, tripType, orderByComparator);
	}

	/**
	* Returns the last bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo fetchByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_T_Last(businessTripPkId, tripType,
			orderByComparator);
	}

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
	public static com.business.trip.model.BtHotelInfo[] findByB_T_PrevAndNext(
		long btHotelInfoId, long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_PrevAndNext(btHotelInfoId, businessTripPkId,
			tripType, orderByComparator);
	}

	/**
	* Removes all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63; from the database.
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
	* Returns the number of bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the number of matching bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByB_T(businessTripPkId, tripType);
	}

	/**
	* Caches the bt hotel info in the entity cache if it is enabled.
	*
	* @param btHotelInfo the bt hotel info
	*/
	public static void cacheResult(
		com.business.trip.model.BtHotelInfo btHotelInfo) {
		getPersistence().cacheResult(btHotelInfo);
	}

	/**
	* Caches the bt hotel infos in the entity cache if it is enabled.
	*
	* @param btHotelInfos the bt hotel infos
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtHotelInfo> btHotelInfos) {
		getPersistence().cacheResult(btHotelInfos);
	}

	/**
	* Creates a new bt hotel info with the primary key. Does not add the bt hotel info to the database.
	*
	* @param btHotelInfoId the primary key for the new bt hotel info
	* @return the new bt hotel info
	*/
	public static com.business.trip.model.BtHotelInfo create(long btHotelInfoId) {
		return getPersistence().create(btHotelInfoId);
	}

	/**
	* Removes the bt hotel info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info that was removed
	* @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo remove(long btHotelInfoId)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btHotelInfoId);
	}

	public static com.business.trip.model.BtHotelInfo updateImpl(
		com.business.trip.model.BtHotelInfo btHotelInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btHotelInfo);
	}

	/**
	* Returns the bt hotel info with the primary key or throws a {@link com.business.trip.NoSuchBtHotelInfoException} if it could not be found.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info
	* @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo findByPrimaryKey(
		long btHotelInfoId)
		throws com.business.trip.NoSuchBtHotelInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btHotelInfoId);
	}

	/**
	* Returns the bt hotel info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info, or <code>null</code> if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtHotelInfo fetchByPrimaryKey(
		long btHotelInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btHotelInfoId);
	}

	/**
	* Returns all the bt hotel infos.
	*
	* @return the bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtHotelInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.business.trip.model.BtHotelInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtHotelInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt hotel infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt hotel infos.
	*
	* @return the number of bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtHotelInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtHotelInfoPersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtHotelInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(BtHotelInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtHotelInfoPersistence persistence) {
	}

	private static BtHotelInfoPersistence _persistence;
}