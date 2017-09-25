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

import com.business.trip.model.RateCity;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the rate city service. This utility wraps {@link RateCityPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RateCityPersistence
 * @see RateCityPersistenceImpl
 * @generated
 */
public class RateCityUtil {
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
	public static void clearCache(RateCity rateCity) {
		getPersistence().clearCache(rateCity);
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
	public static List<RateCity> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RateCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RateCity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static RateCity update(RateCity rateCity) throws SystemException {
		return getPersistence().update(rateCity);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static RateCity update(RateCity rateCity,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(rateCity, serviceContext);
	}

	/**
	* Caches the rate city in the entity cache if it is enabled.
	*
	* @param rateCity the rate city
	*/
	public static void cacheResult(com.business.trip.model.RateCity rateCity) {
		getPersistence().cacheResult(rateCity);
	}

	/**
	* Caches the rate cities in the entity cache if it is enabled.
	*
	* @param rateCities the rate cities
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.RateCity> rateCities) {
		getPersistence().cacheResult(rateCities);
	}

	/**
	* Creates a new rate city with the primary key. Does not add the rate city to the database.
	*
	* @param ratecityId the primary key for the new rate city
	* @return the new rate city
	*/
	public static com.business.trip.model.RateCity create(long ratecityId) {
		return getPersistence().create(ratecityId);
	}

	/**
	* Removes the rate city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratecityId the primary key of the rate city
	* @return the rate city that was removed
	* @throws com.business.trip.NoSuchRateCityException if a rate city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.RateCity remove(long ratecityId)
		throws com.business.trip.NoSuchRateCityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(ratecityId);
	}

	public static com.business.trip.model.RateCity updateImpl(
		com.business.trip.model.RateCity rateCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rateCity);
	}

	/**
	* Returns the rate city with the primary key or throws a {@link com.business.trip.NoSuchRateCityException} if it could not be found.
	*
	* @param ratecityId the primary key of the rate city
	* @return the rate city
	* @throws com.business.trip.NoSuchRateCityException if a rate city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.RateCity findByPrimaryKey(
		long ratecityId)
		throws com.business.trip.NoSuchRateCityException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(ratecityId);
	}

	/**
	* Returns the rate city with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ratecityId the primary key of the rate city
	* @return the rate city, or <code>null</code> if a rate city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.RateCity fetchByPrimaryKey(
		long ratecityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ratecityId);
	}

	/**
	* Returns all the rate cities.
	*
	* @return the rate cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.RateCity> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the rate cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rate cities
	* @param end the upper bound of the range of rate cities (not inclusive)
	* @return the range of rate cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.RateCity> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the rate cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rate cities
	* @param end the upper bound of the range of rate cities (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rate cities
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.RateCity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rate cities from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rate cities.
	*
	* @return the number of rate cities
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RateCityPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RateCityPersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					RateCityPersistence.class.getName());

			ReferenceRegistry.registerReference(RateCityUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RateCityPersistence persistence) {
	}

	private static RateCityPersistence _persistence;
}