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

package com.company.car.service.persistence;

import com.company.car.model.FirstCompanyCar;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the first company car service. This utility wraps {@link FirstCompanyCarPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FirstCompanyCarPersistence
 * @see FirstCompanyCarPersistenceImpl
 * @generated
 */
public class FirstCompanyCarUtil {
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
	public static void clearCache(FirstCompanyCar firstCompanyCar) {
		getPersistence().clearCache(firstCompanyCar);
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
	public static List<FirstCompanyCar> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FirstCompanyCar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FirstCompanyCar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static FirstCompanyCar update(FirstCompanyCar firstCompanyCar)
		throws SystemException {
		return getPersistence().update(firstCompanyCar);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static FirstCompanyCar update(FirstCompanyCar firstCompanyCar,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(firstCompanyCar, serviceContext);
	}

	/**
	* Returns all the first company cars where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the first company cars where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of first company cars
	* @param end the upper bound of the range of first company cars (not inclusive)
	* @return the range of matching first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the first company cars where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of first company cars
	* @param end the upper bound of the range of first company cars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching first company car
	* @throws com.company.car.NoSuchFirstCompanyCarException if a matching first company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar findByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching first company car, or <code>null</code> if a matching first company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar fetchByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching first company car
	* @throws com.company.car.NoSuchFirstCompanyCarException if a matching first company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar findByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching first company car, or <code>null</code> if a matching first company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar fetchByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the first company cars before and after the current first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param firstCompanyCarId the primary key of the current first company car
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next first company car
	* @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar[] findByS_U_PrevAndNext(
		long firstCompanyCarId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(firstCompanyCarId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the first company cars where status = &#63; and userId = &#63; from the database.
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
	* Returns the number of first company cars where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the first company car in the entity cache if it is enabled.
	*
	* @param firstCompanyCar the first company car
	*/
	public static void cacheResult(
		com.company.car.model.FirstCompanyCar firstCompanyCar) {
		getPersistence().cacheResult(firstCompanyCar);
	}

	/**
	* Caches the first company cars in the entity cache if it is enabled.
	*
	* @param firstCompanyCars the first company cars
	*/
	public static void cacheResult(
		java.util.List<com.company.car.model.FirstCompanyCar> firstCompanyCars) {
		getPersistence().cacheResult(firstCompanyCars);
	}

	/**
	* Creates a new first company car with the primary key. Does not add the first company car to the database.
	*
	* @param firstCompanyCarId the primary key for the new first company car
	* @return the new first company car
	*/
	public static com.company.car.model.FirstCompanyCar create(
		long firstCompanyCarId) {
		return getPersistence().create(firstCompanyCarId);
	}

	/**
	* Removes the first company car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car that was removed
	* @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar remove(
		long firstCompanyCarId)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(firstCompanyCarId);
	}

	public static com.company.car.model.FirstCompanyCar updateImpl(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(firstCompanyCar);
	}

	/**
	* Returns the first company car with the primary key or throws a {@link com.company.car.NoSuchFirstCompanyCarException} if it could not be found.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car
	* @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar findByPrimaryKey(
		long firstCompanyCarId)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(firstCompanyCarId);
	}

	/**
	* Returns the first company car with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car, or <code>null</code> if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar fetchByPrimaryKey(
		long firstCompanyCarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(firstCompanyCarId);
	}

	/**
	* Returns all the first company cars.
	*
	* @return the first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the first company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of first company cars
	* @param end the upper bound of the range of first company cars (not inclusive)
	* @return the range of first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the first company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of first company cars
	* @param end the upper bound of the range of first company cars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the first company cars from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of first company cars.
	*
	* @return the number of first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FirstCompanyCarPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FirstCompanyCarPersistence)PortletBeanLocatorUtil.locate(com.company.car.service.ClpSerializer.getServletContextName(),
					FirstCompanyCarPersistence.class.getName());

			ReferenceRegistry.registerReference(FirstCompanyCarUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(FirstCompanyCarPersistence persistence) {
	}

	private static FirstCompanyCarPersistence _persistence;
}