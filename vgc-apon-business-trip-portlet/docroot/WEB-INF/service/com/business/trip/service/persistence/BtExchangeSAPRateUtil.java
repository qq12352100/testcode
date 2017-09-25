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

import com.business.trip.model.BtExchangeSAPRate;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt exchange s a p rate service. This utility wraps {@link BtExchangeSAPRatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRatePersistence
 * @see BtExchangeSAPRatePersistenceImpl
 * @generated
 */
public class BtExchangeSAPRateUtil {
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
	public static void clearCache(BtExchangeSAPRate btExchangeSAPRate) {
		getPersistence().clearCache(btExchangeSAPRate);
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
	public static List<BtExchangeSAPRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtExchangeSAPRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtExchangeSAPRate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtExchangeSAPRate update(BtExchangeSAPRate btExchangeSAPRate)
		throws SystemException {
		return getPersistence().update(btExchangeSAPRate);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtExchangeSAPRate update(
		BtExchangeSAPRate btExchangeSAPRate, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(btExchangeSAPRate, serviceContext);
	}

	/**
	* Caches the bt exchange s a p rate in the entity cache if it is enabled.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	*/
	public static void cacheResult(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate) {
		getPersistence().cacheResult(btExchangeSAPRate);
	}

	/**
	* Caches the bt exchange s a p rates in the entity cache if it is enabled.
	*
	* @param btExchangeSAPRates the bt exchange s a p rates
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtExchangeSAPRate> btExchangeSAPRates) {
		getPersistence().cacheResult(btExchangeSAPRates);
	}

	/**
	* Creates a new bt exchange s a p rate with the primary key. Does not add the bt exchange s a p rate to the database.
	*
	* @param btExchangeSAPRateId the primary key for the new bt exchange s a p rate
	* @return the new bt exchange s a p rate
	*/
	public static com.business.trip.model.BtExchangeSAPRate create(
		long btExchangeSAPRateId) {
		return getPersistence().create(btExchangeSAPRateId);
	}

	/**
	* Removes the bt exchange s a p rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate that was removed
	* @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate remove(
		long btExchangeSAPRateId)
		throws com.business.trip.NoSuchBtExchangeSAPRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btExchangeSAPRateId);
	}

	public static com.business.trip.model.BtExchangeSAPRate updateImpl(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btExchangeSAPRate);
	}

	/**
	* Returns the bt exchange s a p rate with the primary key or throws a {@link com.business.trip.NoSuchBtExchangeSAPRateException} if it could not be found.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate
	* @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate findByPrimaryKey(
		long btExchangeSAPRateId)
		throws com.business.trip.NoSuchBtExchangeSAPRateException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btExchangeSAPRateId);
	}

	/**
	* Returns the bt exchange s a p rate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate, or <code>null</code> if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate fetchByPrimaryKey(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btExchangeSAPRateId);
	}

	/**
	* Returns all the bt exchange s a p rates.
	*
	* @return the bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtExchangeSAPRate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bt exchange s a p rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange s a p rates
	* @param end the upper bound of the range of bt exchange s a p rates (not inclusive)
	* @return the range of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtExchangeSAPRate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bt exchange s a p rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange s a p rates
	* @param end the upper bound of the range of bt exchange s a p rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtExchangeSAPRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt exchange s a p rates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt exchange s a p rates.
	*
	* @return the number of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtExchangeSAPRatePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtExchangeSAPRatePersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtExchangeSAPRatePersistence.class.getName());

			ReferenceRegistry.registerReference(BtExchangeSAPRateUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtExchangeSAPRatePersistence persistence) {
	}

	private static BtExchangeSAPRatePersistence _persistence;
}