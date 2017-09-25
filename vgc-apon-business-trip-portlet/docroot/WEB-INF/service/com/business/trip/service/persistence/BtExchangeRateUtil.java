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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt exchange rate service. This utility wraps {@link BtExchangeRatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRatePersistence
 * @see BtExchangeRatePersistenceImpl
 * @generated
 */
public class BtExchangeRateUtil {
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
	public static void clearCache(BtExchangeRate btExchangeRate) {
		getPersistence().clearCache(btExchangeRate);
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
	public static List<BtExchangeRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtExchangeRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtExchangeRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtExchangeRate update(BtExchangeRate btExchangeRate)
		throws SystemException {
		return getPersistence().update(btExchangeRate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtExchangeRate update(BtExchangeRate btExchangeRate,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(btExchangeRate, serviceContext);
	}

	/**
	* Returns the bt exchange rate where status = &#63; or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	*
	* @param status the status
	* @return the matching bt exchange rate
	* @throws com.business.trip.NoSuchBtExchangeRateException if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate findByS(int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS(status);
	}

	/**
	* Returns the bt exchange rate where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param status the status
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate fetchByS(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS(status);
	}

	/**
	* Returns the bt exchange rate where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param status the status
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate fetchByS(int status,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByS(status, retrieveFromCache);
	}

	/**
	* Removes the bt exchange rate where status = &#63; from the database.
	*
	* @param status the status
	* @return the bt exchange rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate removeByS(int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByS(status);
	}

	/**
	* Returns the number of bt exchange rates where status = &#63;.
	*
	* @param status the status
	* @return the number of matching bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS(status);
	}

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
	public static com.business.trip.model.BtExchangeRate findByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByF_S_S(firstCurrency, secondCurrency, status);
	}

	/**
	* Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate fetchByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByF_S_S(firstCurrency, secondCurrency, status);
	}

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
	public static com.business.trip.model.BtExchangeRate fetchByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByF_S_S(firstCurrency, secondCurrency, status,
			retrieveFromCache);
	}

	/**
	* Removes the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; from the database.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the bt exchange rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate removeByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByF_S_S(firstCurrency, secondCurrency, status);
	}

	/**
	* Returns the number of bt exchange rates where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63;.
	*
	* @param firstCurrency the first currency
	* @param secondCurrency the second currency
	* @param status the status
	* @return the number of matching bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countByF_S_S(java.lang.String firstCurrency,
		java.lang.String secondCurrency, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByF_S_S(firstCurrency, secondCurrency, status);
	}

	/**
	* Caches the bt exchange rate in the entity cache if it is enabled.
	*
	* @param btExchangeRate the bt exchange rate
	*/
	public static void cacheResult(
		com.business.trip.model.BtExchangeRate btExchangeRate) {
		getPersistence().cacheResult(btExchangeRate);
	}

	/**
	* Caches the bt exchange rates in the entity cache if it is enabled.
	*
	* @param btExchangeRates the bt exchange rates
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtExchangeRate> btExchangeRates) {
		getPersistence().cacheResult(btExchangeRates);
	}

	/**
	* Creates a new bt exchange rate with the primary key. Does not add the bt exchange rate to the database.
	*
	* @param btExchangeRateId the primary key for the new bt exchange rate
	* @return the new bt exchange rate
	*/
	public static com.business.trip.model.BtExchangeRate create(
		long btExchangeRateId) {
		return getPersistence().create(btExchangeRateId);
	}

	/**
	* Removes the bt exchange rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate that was removed
	* @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate remove(
		long btExchangeRateId)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btExchangeRateId);
	}

	public static com.business.trip.model.BtExchangeRate updateImpl(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btExchangeRate);
	}

	/**
	* Returns the bt exchange rate with the primary key or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate
	* @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate findByPrimaryKey(
		long btExchangeRateId)
		throws com.business.trip.NoSuchBtExchangeRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btExchangeRateId);
	}

	/**
	* Returns the bt exchange rate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate, or <code>null</code> if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate fetchByPrimaryKey(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btExchangeRateId);
	}

	/**
	* Returns all the bt exchange rates.
	*
	* @return the bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtExchangeRate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.business.trip.model.BtExchangeRate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.business.trip.model.BtExchangeRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt exchange rates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt exchange rates.
	*
	* @return the number of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtExchangeRatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtExchangeRatePersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtExchangeRatePersistence.class.getName());

			ReferenceRegistry.registerReference(BtExchangeRateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtExchangeRatePersistence persistence) {
	}

	private static BtExchangeRatePersistence _persistence;
}