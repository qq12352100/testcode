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

import com.business.trip.model.BusinessTripApplication;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the business trip application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripApplicationPersistenceImpl
 * @see BusinessTripApplicationUtil
 * @generated
 */
public interface BusinessTripApplicationPersistence extends BasePersistence<BusinessTripApplication> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusinessTripApplicationUtil} to access the business trip application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the business trip applications where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the business trip applications where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @return the range of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the business trip applications where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business trip application in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication findByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business trip application in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip application, or <code>null</code> if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business trip application in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication findByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business trip application in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip application, or <code>null</code> if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip applications before and after the current business trip application in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param businessTripApplicationId the primary key of the current business trip application
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication[] findByS_U_PrevAndNext(
		long businessTripApplicationId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the business trip applications where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business trip applications where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the business trip applications where status = &#63;.
	*
	* @param status the status
	* @return the matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the business trip applications where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @return the range of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findByStatus(
		int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the business trip applications where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business trip application in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication findByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first business trip application in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching business trip application, or <code>null</code> if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business trip application in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication findByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last business trip application in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching business trip application, or <code>null</code> if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip applications before and after the current business trip application in the ordered set where status = &#63;.
	*
	* @param businessTripApplicationId the primary key of the current business trip application
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication[] findByStatus_PrevAndNext(
		long businessTripApplicationId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the business trip applications where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business trip applications where status = &#63;.
	*
	* @param status the status
	* @return the number of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByStatus(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip application where ticketNo = &#63; or throws a {@link com.business.trip.NoSuchBusinessTripApplicationException} if it could not be found.
	*
	* @param ticketNo the ticket no
	* @return the matching business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication findByTicketNo(
		java.lang.String ticketNo)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip application where ticketNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ticketNo the ticket no
	* @return the matching business trip application, or <code>null</code> if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByTicketNo(
		java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip application where ticketNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ticketNo the ticket no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching business trip application, or <code>null</code> if a matching business trip application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByTicketNo(
		java.lang.String ticketNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the business trip application where ticketNo = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @return the business trip application that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication removeByTicketNo(
		java.lang.String ticketNo)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business trip applications where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @return the number of matching business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByTicketNo(java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the business trip application in the entity cache if it is enabled.
	*
	* @param businessTripApplication the business trip application
	*/
	public void cacheResult(
		com.business.trip.model.BusinessTripApplication businessTripApplication);

	/**
	* Caches the business trip applications in the entity cache if it is enabled.
	*
	* @param businessTripApplications the business trip applications
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BusinessTripApplication> businessTripApplications);

	/**
	* Creates a new business trip application with the primary key. Does not add the business trip application to the database.
	*
	* @param businessTripApplicationId the primary key for the new business trip application
	* @return the new business trip application
	*/
	public com.business.trip.model.BusinessTripApplication create(
		long businessTripApplicationId);

	/**
	* Removes the business trip application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application that was removed
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication remove(
		long businessTripApplicationId)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BusinessTripApplication updateImpl(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip application with the primary key or throws a {@link com.business.trip.NoSuchBusinessTripApplicationException} if it could not be found.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application
	* @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication findByPrimaryKey(
		long businessTripApplicationId)
		throws com.business.trip.NoSuchBusinessTripApplicationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip application with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application, or <code>null</code> if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BusinessTripApplication fetchByPrimaryKey(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the business trip applications.
	*
	* @return the business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the business trip applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @return the range of business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the business trip applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BusinessTripApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the business trip applications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business trip applications.
	*
	* @return the number of business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}