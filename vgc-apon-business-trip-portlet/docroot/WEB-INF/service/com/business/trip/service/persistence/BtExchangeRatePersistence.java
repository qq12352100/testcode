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

import com.business.trip.model.BtExchangeRate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt exchange rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRatePersistenceImpl
 * @see BtExchangeRateUtil
 * @generated
 */
public interface BtExchangeRatePersistence extends BasePersistence<BtExchangeRate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtExchangeRateUtil} to access the bt exchange rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the bt exchange rate where status = &#63; or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	*
	* @param status the status
	* @return the matching bt exchange rate
	* @throws com.business.trip.NoSuchBtExchangeRateException if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate findByS(int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate fetchByS(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate fetchByS(int status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bt exchange rate where status = &#63; from the database.
	*
	* @param status the status
	* @return the bt exchange rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate removeByS(int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt exchange rates where status = &#63;.
	*
	* @param status the status
	* @return the number of matching bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public int countByS(int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the matching bt exchange rate
	* @throws com.business.trip.NoSuchBtExchangeRateException if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate findByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate fetchByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate fetchByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; from the database.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the bt exchange rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate removeByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt exchange rates where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63;.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the number of matching bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public int countByF_S_S(java.lang.String firstCurrency,
		java.lang.String secondCurrency, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bt exchange rate in the entity cache if it is enabled.
	*
	* @param btExchangeRate the bt exchange rate
	*/
	public void cacheResult(
		com.business.trip.model.BtExchangeRate btExchangeRate);

	/**
	* Caches the bt exchange rates in the entity cache if it is enabled.
	*
	* @param btExchangeRates the bt exchange rates
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtExchangeRate> btExchangeRates);

	/**
	* Creates a new bt exchange rate with the primary key. Does not add the bt exchange rate to the database.
	*
	* @param btExchangeRateId the primary key for the new bt exchange rate
	* @return the new bt exchange rate
	*/
	public com.business.trip.model.BtExchangeRate create(long btExchangeRateId);

	/**
	* Removes the bt exchange rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate that was removed
	* @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate remove(long btExchangeRateId)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtExchangeRate updateImpl(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate with the primary key or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate
	* @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate findByPrimaryKey(
		long btExchangeRateId)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange rate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate, or <code>null</code> if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeRate fetchByPrimaryKey(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt exchange rates.
	*
	* @return the bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtExchangeRate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt exchange rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange rates
	* @param end the upper bound of the range of bt exchange rates (not inclusive)
	* @return the range of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtExchangeRate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt exchange rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange rates
	* @param end the upper bound of the range of bt exchange rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtExchangeRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt exchange rates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt exchange rates.
	*
	* @return the number of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}