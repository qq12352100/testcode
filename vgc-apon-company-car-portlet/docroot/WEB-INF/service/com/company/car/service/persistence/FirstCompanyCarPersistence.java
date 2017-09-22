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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the first company car service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FirstCompanyCarPersistenceImpl
 * @see FirstCompanyCarUtil
 * @generated
 */
public interface FirstCompanyCarPersistence extends BasePersistence<FirstCompanyCar> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FirstCompanyCarUtil} to access the first company car persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the first company cars where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching first company cars
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.company.car.model.FirstCompanyCar findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching first company car, or <code>null</code> if a matching first company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.FirstCompanyCar fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.company.car.model.FirstCompanyCar findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last first company car in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching first company car, or <code>null</code> if a matching first company car could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.FirstCompanyCar fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.company.car.model.FirstCompanyCar[] findByS_U_PrevAndNext(
		long firstCompanyCarId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the first company cars where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of first company cars where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching first company cars
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the first company car in the entity cache if it is enabled.
	*
	* @param firstCompanyCar the first company car
	*/
	public void cacheResult(
		com.company.car.model.FirstCompanyCar firstCompanyCar);

	/**
	* Caches the first company cars in the entity cache if it is enabled.
	*
	* @param firstCompanyCars the first company cars
	*/
	public void cacheResult(
		java.util.List<com.company.car.model.FirstCompanyCar> firstCompanyCars);

	/**
	* Creates a new first company car with the primary key. Does not add the first company car to the database.
	*
	* @param firstCompanyCarId the primary key for the new first company car
	* @return the new first company car
	*/
	public com.company.car.model.FirstCompanyCar create(long firstCompanyCarId);

	/**
	* Removes the first company car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car that was removed
	* @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.FirstCompanyCar remove(long firstCompanyCarId)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.company.car.model.FirstCompanyCar updateImpl(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company car with the primary key or throws a {@link com.company.car.NoSuchFirstCompanyCarException} if it could not be found.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car
	* @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.FirstCompanyCar findByPrimaryKey(
		long firstCompanyCarId)
		throws com.company.car.NoSuchFirstCompanyCarException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company car with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car, or <code>null</code> if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.FirstCompanyCar fetchByPrimaryKey(
		long firstCompanyCarId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the first company cars.
	*
	* @return the first company cars
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.FirstCompanyCar> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.company.car.model.FirstCompanyCar> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.company.car.model.FirstCompanyCar> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the first company cars from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of first company cars.
	*
	* @return the number of first company cars
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}