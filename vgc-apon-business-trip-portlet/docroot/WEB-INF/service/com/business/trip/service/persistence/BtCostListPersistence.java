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

import com.business.trip.model.BtCostList;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt cost list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCostListPersistenceImpl
 * @see BtCostListUtil
 * @generated
 */
public interface BtCostListPersistence extends BasePersistence<BtCostList> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtCostListUtil} to access the bt cost list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bt cost lists where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @return the matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByTicketNo(
		java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt cost lists where ticketNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @return the range of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByTicketNo(
		java.lang.String ticketNo, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt cost lists where ticketNo = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ticketNo the ticket no
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByTicketNo(
		java.lang.String ticketNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt cost list in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByTicketNo_First(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt cost list in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByTicketNo_First(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt cost list in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByTicketNo_Last(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt cost list in the ordered set where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByTicketNo_Last(
		java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt cost lists before and after the current bt cost list in the ordered set where ticketNo = &#63;.
	*
	* @param btCostListId the primary key of the current bt cost list
	* @param ticketNo the ticket no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList[] findByTicketNo_PrevAndNext(
		long btCostListId, java.lang.String ticketNo,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt cost lists where ticketNo = &#63; from the database.
	*
	* @param ticketNo the ticket no
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTicketNo(java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt cost lists where ticketNo = &#63;.
	*
	* @param ticketNo the ticket no
	* @return the number of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByTicketNo(java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt cost lists where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @return the matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByBusinessTripPkId(
		long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt cost lists where businessTripPkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @return the range of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByBusinessTripPkId(
		long businessTripPkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt cost lists where businessTripPkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByBusinessTripPkId(
		long businessTripPkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt cost list in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByBusinessTripPkId_First(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt cost list in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByBusinessTripPkId_First(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt cost list in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByBusinessTripPkId_Last(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt cost list in the ordered set where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByBusinessTripPkId_Last(
		long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt cost lists before and after the current bt cost list in the ordered set where businessTripPkId = &#63;.
	*
	* @param btCostListId the primary key of the current bt cost list
	* @param businessTripPkId the business trip pk ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList[] findByBusinessTripPkId_PrevAndNext(
		long btCostListId, long businessTripPkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt cost lists where businessTripPkId = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt cost lists where businessTripPkId = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @return the number of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @return the matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByB_C(
		long businessTripPkId, java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @return the range of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByB_C(
		long businessTripPkId, java.lang.String paymentCurrency, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findByB_C(
		long businessTripPkId, java.lang.String paymentCurrency, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByB_C_First(
		long businessTripPkId, java.lang.String paymentCurrency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByB_C_First(
		long businessTripPkId, java.lang.String paymentCurrency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByB_C_Last(
		long businessTripPkId, java.lang.String paymentCurrency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByB_C_Last(
		long businessTripPkId, java.lang.String paymentCurrency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt cost lists before and after the current bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param btCostListId the primary key of the current bt cost list
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList[] findByB_C_PrevAndNext(
		long btCostListId, long businessTripPkId,
		java.lang.String paymentCurrency,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63; from the database.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @throws SystemException if a system exception occurred
	*/
	public void removeByB_C(long businessTripPkId,
		java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	*
	* @param businessTripPkId the business trip pk ID
	* @param paymentCurrency the payment currency
	* @return the number of matching bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public int countByB_C(long businessTripPkId,
		java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bt cost list in the entity cache if it is enabled.
	*
	* @param btCostList the bt cost list
	*/
	public void cacheResult(com.business.trip.model.BtCostList btCostList);

	/**
	* Caches the bt cost lists in the entity cache if it is enabled.
	*
	* @param btCostLists the bt cost lists
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtCostList> btCostLists);

	/**
	* Creates a new bt cost list with the primary key. Does not add the bt cost list to the database.
	*
	* @param btCostListId the primary key for the new bt cost list
	* @return the new bt cost list
	*/
	public com.business.trip.model.BtCostList create(long btCostListId);

	/**
	* Removes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list that was removed
	* @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList remove(long btCostListId)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtCostList updateImpl(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt cost list with the primary key or throws a {@link com.business.trip.NoSuchBtCostListException} if it could not be found.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list
	* @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList findByPrimaryKey(
		long btCostListId)
		throws com.business.trip.NoSuchBtCostListException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt cost list with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list, or <code>null</code> if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtCostList fetchByPrimaryKey(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt cost lists.
	*
	* @return the bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt cost lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @return the range of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt cost lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtCostList> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt cost lists from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt cost lists.
	*
	* @return the number of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}