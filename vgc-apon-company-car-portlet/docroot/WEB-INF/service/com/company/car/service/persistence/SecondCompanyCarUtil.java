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

import com.company.car.model.SecondCompanyCar;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the second company car service. This utility wraps {@link SecondCompanyCarPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCarPersistence
 * @see SecondCompanyCarPersistenceImpl
 * @generated
 */
public class SecondCompanyCarUtil {
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
	public static void clearCache(SecondCompanyCar secondCompanyCar) {
		getPersistence().clearCache(secondCompanyCar);
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
	public static List<SecondCompanyCar> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SecondCompanyCar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SecondCompanyCar> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SecondCompanyCar update(SecondCompanyCar secondCompanyCar)
		throws SystemException {
		return getPersistence().update(secondCompanyCar);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SecondCompanyCar update(SecondCompanyCar secondCompanyCar,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(secondCompanyCar, serviceContext);
	}

	/**
	* Returns all the second company cars where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the second company cars where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of second company cars
	* @param end the upper bound of the range of second company cars (not inclusive)
	* @return the range of matching second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the second company cars where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of second company cars
	* @param end the upper bound of the range of second company cars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first second company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching second company car
	* @throws com.company.car.NoSuchSecondCompanyCarException if a matching second company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar findByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchSecondCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first second company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching second company car, or <code>null</code> if a matching second company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar fetchByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last second company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching second company car
	* @throws com.company.car.NoSuchSecondCompanyCarException if a matching second company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar findByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchSecondCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last second company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching second company car, or <code>null</code> if a matching second company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar fetchByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the second company cars before and after the current second company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param secondCompanyCarId the primary key of the current second company car
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next second company car
	* @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar[] findByS_U_PrevAndNext(
		long secondCompanyCarId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchSecondCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(secondCompanyCarId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the second company cars where status = &#63; and userId = &#63; from the database.
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
	* Returns the number of second company cars where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the second company car in the entity cache if it is enabled.
	*
	* @param secondCompanyCar the second company car
	*/
	public static void cacheResult(
		com.company.car.model.SecondCompanyCar secondCompanyCar) {
		getPersistence().cacheResult(secondCompanyCar);
	}

	/**
	* Caches the second company cars in the entity cache if it is enabled.
	*
	* @param secondCompanyCars the second company cars
	*/
	public static void cacheResult(
		java.util.List<com.company.car.model.SecondCompanyCar> secondCompanyCars) {
		getPersistence().cacheResult(secondCompanyCars);
	}

	/**
	* Creates a new second company car with the primary key. Does not add the second company car to the database.
	*
	* @param secondCompanyCarId the primary key for the new second company car
	* @return the new second company car
	*/
	public static com.company.car.model.SecondCompanyCar create(
		long secondCompanyCarId) {
		return getPersistence().create(secondCompanyCarId);
	}

	/**
	* Removes the second company car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car that was removed
	* @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar remove(
		long secondCompanyCarId)
		throws com.company.car.NoSuchSecondCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(secondCompanyCarId);
	}

	public static com.company.car.model.SecondCompanyCar updateImpl(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(secondCompanyCar);
	}

	/**
	* Returns the second company car with the primary key or throws a {@link com.company.car.NoSuchSecondCompanyCarException} if it could not be found.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car
	* @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar findByPrimaryKey(
		long secondCompanyCarId)
		throws com.company.car.NoSuchSecondCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(secondCompanyCarId);
	}

	/**
	* Returns the second company car with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car, or <code>null</code> if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar fetchByPrimaryKey(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(secondCompanyCarId);
	}

	/**
	* Returns all the second company cars.
	*
	* @return the second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the second company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of second company cars
	* @param end the upper bound of the range of second company cars (not inclusive)
	* @return the range of second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the second company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of second company cars
	* @param end the upper bound of the range of second company cars (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the second company cars from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of second company cars.
	*
	* @return the number of second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SecondCompanyCarPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SecondCompanyCarPersistence)PortletBeanLocatorUtil.locate(com.company.car.service.ClpSerializer.getServletContextName(),
					SecondCompanyCarPersistence.class.getName());

			ReferenceRegistry.registerReference(SecondCompanyCarUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SecondCompanyCarPersistence persistence) {
	}

	private static SecondCompanyCarPersistence _persistence;
}