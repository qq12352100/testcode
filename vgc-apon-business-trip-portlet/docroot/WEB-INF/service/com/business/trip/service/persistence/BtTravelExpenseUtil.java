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

import com.business.trip.model.BtTravelExpense;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt travel expense service. This utility wraps {@link BtTravelExpensePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtTravelExpensePersistence
 * @see BtTravelExpensePersistenceImpl
 * @generated
 */
public class BtTravelExpenseUtil {
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
	public static void clearCache(BtTravelExpense btTravelExpense) {
		getPersistence().clearCache(btTravelExpense);
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
	public static List<BtTravelExpense> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtTravelExpense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtTravelExpense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtTravelExpense update(BtTravelExpense btTravelExpense)
		throws SystemException {
		return getPersistence().update(btTravelExpense);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtTravelExpense update(BtTravelExpense btTravelExpense,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(btTravelExpense, serviceContext);
	}

	/**
	* Returns all the bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(ticketNo, tripType);
	}

	/**
	* Returns a range of all the bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByT_T(ticketNo, tripType, start, end);
	}

	/**
	* Returns an ordered range of all the bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByT_T(
		java.lang.String ticketNo, java.lang.String tripType, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T(ticketNo, tripType, start, end, orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_First(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByT_T_First(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_First(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_Last(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByT_T_Last(
		java.lang.String ticketNo, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByT_T_Last(ticketNo, tripType, orderByComparator);
	}

	/**
	* Returns the bt travel expenses before and after the current bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	*
	* @param btTravelExpenseId the primary key of the current bt travel expense
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense[] findByT_T_PrevAndNext(
		long btTravelExpenseId, java.lang.String ticketNo,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByT_T_PrevAndNext(btTravelExpenseId, ticketNo,
			tripType, orderByComparator);
	}

	/**
	* Removes all the bt travel expenses where ticketNo = &#63; and tripType = &#63; from the database.
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
	* Returns the number of bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	*
	* @param ticketNo the ticket no
	* @param tripType the trip type
	* @return the number of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByT_T(java.lang.String ticketNo,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByT_T(ticketNo, tripType);
	}

	/**
	* Returns all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_T(
		long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_T(businessTripPkId, tripType);
	}

	/**
	* Returns a range of all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_T(businessTripPkId, tripType, start, end);
	}

	/**
	* Returns an ordered range of all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T(businessTripPkId, tripType, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_First(businessTripPkId, tripType,
			orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByB_T_First(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_T_First(businessTripPkId, tripType,
			orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_Last(businessTripPkId, tripType, orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByB_T_Last(
		long businessTripPkId, java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_T_Last(businessTripPkId, tripType,
			orderByComparator);
	}

	/**
	* Returns the bt travel expenses before and after the current bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param btTravelExpenseId the primary key of the current bt travel expense
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense[] findByB_T_PrevAndNext(
		long btTravelExpenseId, long businessTripPkId,
		java.lang.String tripType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_T_PrevAndNext(btTravelExpenseId, businessTripPkId,
			tripType, orderByComparator);
	}

	/**
	* Removes all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63; from the database.
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
	* Returns the number of bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param tripType the trip type
	* @return the number of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByB_T(businessTripPkId, tripType);
	}

	/**
	* Returns all the bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @return the matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_C(
		long businessTripPkId, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_C(businessTripPkId, currency);
	}

	/**
	* Returns a range of all the bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_C(
		long businessTripPkId, java.lang.String currency, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_C(businessTripPkId, currency, start, end);
	}

	/**
	* Returns an ordered range of all the bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_C(
		long businessTripPkId, java.lang.String currency, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_C(businessTripPkId, currency, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByB_C_First(
		long businessTripPkId, java.lang.String currency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_C_First(businessTripPkId, currency,
			orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByB_C_First(
		long businessTripPkId, java.lang.String currency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_C_First(businessTripPkId, currency,
			orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByB_C_Last(
		long businessTripPkId, java.lang.String currency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_C_Last(businessTripPkId, currency, orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByB_C_Last(
		long businessTripPkId, java.lang.String currency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_C_Last(businessTripPkId, currency,
			orderByComparator);
	}

	/**
	* Returns the bt travel expenses before and after the current bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param btTravelExpenseId the primary key of the current bt travel expense
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense[] findByB_C_PrevAndNext(
		long btTravelExpenseId, long businessTripPkId,
		java.lang.String currency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByB_C_PrevAndNext(btTravelExpenseId, businessTripPkId,
			currency, orderByComparator);
	}

	/**
	* Removes all the bt travel expenses where businessTripPkId = &#63; and currency = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByB_C(long businessTripPkId,
		java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByB_C(businessTripPkId, currency);
	}

	/**
	* Returns the number of bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param currency the currency
	* @return the number of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByB_C(long businessTripPkId,
		java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByB_C(businessTripPkId, currency);
	}

	/**
	* Returns all the bt travel expenses where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @return the matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByTicketNo(
		java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTicketNo(ticketNo);
	}

	/**
	* Returns a range of all the bt travel expenses where ticketNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByTicketNo(
		java.lang.String ticketNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTicketNo(ticketNo, start, end);
	}

	/**
	* Returns an ordered range of all the bt travel expenses where ticketNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByTicketNo(
		java.lang.String ticketNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTicketNo(ticketNo, start, end, orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByTicketNo_First(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTicketNo_First(ticketNo, orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByTicketNo_First(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTicketNo_First(ticketNo, orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByTicketNo_Last(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTicketNo_Last(ticketNo, orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByTicketNo_Last(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTicketNo_Last(ticketNo, orderByComparator);
	}

	/**
	* Returns the bt travel expenses before and after the current bt travel expense in the ordered set where ticketNo = &#63;.
	*
	* @param btTravelExpenseId the primary key of the current bt travel expense
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense[] findByTicketNo_PrevAndNext(
		long btTravelExpenseId, java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTicketNo_PrevAndNext(btTravelExpenseId, ticketNo,
			orderByComparator);
	}

	/**
	* Removes all the bt travel expenses where ticketNo = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTicketNo(java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTicketNo(ticketNo);
	}

	/**
	* Returns the number of bt travel expenses where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @return the number of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTicketNo(java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTicketNo(ticketNo);
	}

	/**
	* Returns all the bt travel expenses where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @return the matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByBusinessTripPkId(
		long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns a range of all the bt travel expenses where businessTripPkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByBusinessTripPkId(
		long businessTripPkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessTripPkId(businessTripPkId, start, end);
	}

	/**
	* Returns an ordered range of all the bt travel expenses where businessTripPkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findByBusinessTripPkId(
		long businessTripPkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessTripPkId(businessTripPkId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByBusinessTripPkId_First(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessTripPkId_First(businessTripPkId,
			orderByComparator);
	}

	/**
	* Returns the first bt travel expense in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByBusinessTripPkId_First(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBusinessTripPkId_First(businessTripPkId,
			orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByBusinessTripPkId_Last(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessTripPkId_Last(businessTripPkId,
			orderByComparator);
	}

	/**
	* Returns the last bt travel expense in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByBusinessTripPkId_Last(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBusinessTripPkId_Last(businessTripPkId,
			orderByComparator);
	}

	/**
	* Returns the bt travel expenses before and after the current bt travel expense in the ordered set where businessTripPkId = &#63;.
	*
	* @param btTravelExpenseId the primary key of the current bt travel expense
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense[] findByBusinessTripPkId_PrevAndNext(
		long btTravelExpenseId, long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBusinessTripPkId_PrevAndNext(btTravelExpenseId,
			businessTripPkId, orderByComparator);
	}

	/**
	* Removes all the bt travel expenses where businessTripPkId = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBusinessTripPkId(businessTripPkId);
	}

	/**
	* Returns the number of bt travel expenses where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @return the number of matching bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBusinessTripPkId(businessTripPkId);
	}

	/**
	* Caches the bt travel expense in the entity cache if it is enabled.
	*
	* @param btTravelExpense the bt travel expense
	*/
	public static void cacheResult(
		com.business.trip.model.BtTravelExpense btTravelExpense) {
		getPersistence().cacheResult(btTravelExpense);
	}

	/**
	* Caches the bt travel expenses in the entity cache if it is enabled.
	*
	* @param btTravelExpenses the bt travel expenses
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtTravelExpense> btTravelExpenses) {
		getPersistence().cacheResult(btTravelExpenses);
	}

	/**
	* Creates a new bt travel expense with the primary key. Does not add the bt travel expense to the database.
	*
	* @param btTravelExpenseId the primary key for the new bt travel expense
	* @return the new bt travel expense
	*/
	public static com.business.trip.model.BtTravelExpense create(
		long btTravelExpenseId) {
		return getPersistence().create(btTravelExpenseId);
	}

	/**
	* Removes the bt travel expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense that was removed
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense remove(
		long btTravelExpenseId)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btTravelExpenseId);
	}

	public static com.business.trip.model.BtTravelExpense updateImpl(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btTravelExpense);
	}

	/**
	* Returns the bt travel expense with the primary key or throws a {@link com.business.trip.NoSuchBtTravelExpenseException} if it could not be found.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense
	* @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense findByPrimaryKey(
		long btTravelExpenseId)
		throws com.business.trip.NoSuchBtTravelExpenseException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btTravelExpenseId);
	}

	/**
	* Returns the bt travel expense with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense, or <code>null</code> if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense fetchByPrimaryKey(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btTravelExpenseId);
	}

	/**
	* Returns all the bt travel expenses.
	*
	* @return the bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bt travel expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bt travel expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtTravelExpense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt travel expenses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt travel expenses.
	*
	* @return the number of bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtTravelExpensePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtTravelExpensePersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtTravelExpensePersistence.class.getName());

			ReferenceRegistry.registerReference(BtTravelExpenseUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtTravelExpensePersistence persistence) {
	}

	private static BtTravelExpensePersistence _persistence;
}