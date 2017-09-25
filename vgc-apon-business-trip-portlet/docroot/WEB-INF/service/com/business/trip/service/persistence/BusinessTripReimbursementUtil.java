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

import com.business.trip.model.BusinessTripReimbursement;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the business trip reimbursement service. This utility wraps {@link BusinessTripReimbursementPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursementPersistence
 * @see BusinessTripReimbursementPersistenceImpl
 * @generated
 */
public class BusinessTripReimbursementUtil {
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
	public static void clearCache(
		BusinessTripReimbursement businessTripReimbursement) {
		getPersistence().clearCache(businessTripReimbursement);
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
	public static List<BusinessTripReimbursement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BusinessTripReimbursement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BusinessTripReimbursement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BusinessTripReimbursement update(
		BusinessTripReimbursement businessTripReimbursement)
		throws SystemException {
		return getPersistence().update(businessTripReimbursement);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BusinessTripReimbursement update(
		BusinessTripReimbursement businessTripReimbursement,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(businessTripReimbursement, serviceContext);
	}

	/**
	* Returns all the business trip reimbursements where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the business trip reimbursements where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @return the range of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the business trip reimbursements where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement findByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement findByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the business trip reimbursements before and after the current business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param businessTripReimbursementId the primary key of the current business trip reimbursement
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement[] findByS_U_PrevAndNext(
		long businessTripReimbursementId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(businessTripReimbursementId, status,
			userId, orderByComparator);
	}

	/**
	* Removes all the business trip reimbursements where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_U(status, userId);
	}

	/**
	* Returns the number of business trip reimbursements where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Returns all the business trip reimbursements where bussinessTirpTicketNo = &#63;.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @return the matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBussinessTirpTicketNo(bussinessTirpTicketNo);
	}

	/**
	* Returns a range of all the business trip reimbursements where bussinessTirpTicketNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @return the range of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBussinessTirpTicketNo(bussinessTirpTicketNo, start,
			end);
	}

	/**
	* Returns an ordered range of all the business trip reimbursements where bussinessTirpTicketNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBussinessTirpTicketNo(bussinessTirpTicketNo, start,
			end, orderByComparator);
	}

	/**
	* Returns the first business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement findByBussinessTirpTicketNo_First(
		java.lang.String bussinessTirpTicketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBussinessTirpTicketNo_First(bussinessTirpTicketNo,
			orderByComparator);
	}

	/**
	* Returns the first business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByBussinessTirpTicketNo_First(
		java.lang.String bussinessTirpTicketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBussinessTirpTicketNo_First(bussinessTirpTicketNo,
			orderByComparator);
	}

	/**
	* Returns the last business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement findByBussinessTirpTicketNo_Last(
		java.lang.String bussinessTirpTicketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBussinessTirpTicketNo_Last(bussinessTirpTicketNo,
			orderByComparator);
	}

	/**
	* Returns the last business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByBussinessTirpTicketNo_Last(
		java.lang.String bussinessTirpTicketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBussinessTirpTicketNo_Last(bussinessTirpTicketNo,
			orderByComparator);
	}

	/**
	* Returns the business trip reimbursements before and after the current business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	*
	* @param businessTripReimbursementId the primary key of the current business trip reimbursement
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement[] findByBussinessTirpTicketNo_PrevAndNext(
		long businessTripReimbursementId,
		java.lang.String bussinessTirpTicketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBussinessTirpTicketNo_PrevAndNext(businessTripReimbursementId,
			bussinessTirpTicketNo, orderByComparator);
	}

	/**
	* Removes all the business trip reimbursements where bussinessTirpTicketNo = &#63; from the database.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBussinessTirpTicketNo(bussinessTirpTicketNo);
	}

	/**
	* Returns the number of business trip reimbursements where bussinessTirpTicketNo = &#63;.
	*
	* @param bussinessTirpTicketNo the bussiness tirp ticket no
	* @return the number of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByBussinessTirpTicketNo(bussinessTirpTicketNo);
	}

	/**
	* Returns the business trip reimbursement where ticketNo = &#63; or throws a {@link com.business.trip.NoSuchBusinessTripReimbursementException} if it could not be found.
	*
	* @param ticketNo the ticket no
	* @return the matching business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement findByTicketNo(
		java.lang.String ticketNo)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTicketNo(ticketNo);
	}

	/**
	* Returns the business trip reimbursement where ticketNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ticketNo the ticket no
	* @return the matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByTicketNo(
		java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTicketNo(ticketNo);
	}

	/**
	* Returns the business trip reimbursement where ticketNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ticketNo the ticket no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByTicketNo(
		java.lang.String ticketNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTicketNo(ticketNo, retrieveFromCache);
	}

	/**
	* Removes the business trip reimbursement where ticketNo = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @return the business trip reimbursement that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement removeByTicketNo(
		java.lang.String ticketNo)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByTicketNo(ticketNo);
	}

	/**
	* Returns the number of business trip reimbursements where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @return the number of matching business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTicketNo(java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTicketNo(ticketNo);
	}

	/**
	* Caches the business trip reimbursement in the entity cache if it is enabled.
	*
	* @param businessTripReimbursement the business trip reimbursement
	*/
	public static void cacheResult(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement) {
		getPersistence().cacheResult(businessTripReimbursement);
	}

	/**
	* Caches the business trip reimbursements in the entity cache if it is enabled.
	*
	* @param businessTripReimbursements the business trip reimbursements
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BusinessTripReimbursement> businessTripReimbursements) {
		getPersistence().cacheResult(businessTripReimbursements);
	}

	/**
	* Creates a new business trip reimbursement with the primary key. Does not add the business trip reimbursement to the database.
	*
	* @param businessTripReimbursementId the primary key for the new business trip reimbursement
	* @return the new business trip reimbursement
	*/
	public static com.business.trip.model.BusinessTripReimbursement create(
		long businessTripReimbursementId) {
		return getPersistence().create(businessTripReimbursementId);
	}

	/**
	* Removes the business trip reimbursement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement that was removed
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement remove(
		long businessTripReimbursementId)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(businessTripReimbursementId);
	}

	public static com.business.trip.model.BusinessTripReimbursement updateImpl(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(businessTripReimbursement);
	}

	/**
	* Returns the business trip reimbursement with the primary key or throws a {@link com.business.trip.NoSuchBusinessTripReimbursementException} if it could not be found.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement
	* @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement findByPrimaryKey(
		long businessTripReimbursementId)
		throws com.business.trip.NoSuchBusinessTripReimbursementException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(businessTripReimbursementId);
	}

	/**
	* Returns the business trip reimbursement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement, or <code>null</code> if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement fetchByPrimaryKey(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(businessTripReimbursementId);
	}

	/**
	* Returns all the business trip reimbursements.
	*
	* @return the business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the business trip reimbursements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @return the range of business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the business trip reimbursements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the business trip reimbursements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of business trip reimbursements.
	*
	* @return the number of business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BusinessTripReimbursementPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BusinessTripReimbursementPersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BusinessTripReimbursementPersistence.class.getName());

			ReferenceRegistry.registerReference(BusinessTripReimbursementUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BusinessTripReimbursementPersistence persistence) {
	}

	private static BusinessTripReimbursementPersistence _persistence;
}