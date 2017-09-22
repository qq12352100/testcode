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

package com.e.onboarding.service.persistence;

import com.e.onboarding.model.EOnBoarding;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e on boarding service. This utility wraps {@link EOnBoardingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sanguine
 * @see EOnBoardingPersistence
 * @see EOnBoardingPersistenceImpl
 * @generated
 */
public class EOnBoardingUtil {
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
	public static void clearCache(EOnBoarding eOnBoarding) {
		getPersistence().clearCache(eOnBoarding);
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
	public static List<EOnBoarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EOnBoarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EOnBoarding> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EOnBoarding update(EOnBoarding eOnBoarding)
		throws SystemException {
		return getPersistence().update(eOnBoarding);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EOnBoarding update(EOnBoarding eOnBoarding,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eOnBoarding, serviceContext);
	}

	/**
	* Returns all the e on boardings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the e on boardings where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e on boardings
	* @param end the upper bound of the range of e on boardings (not inclusive)
	* @return the range of matching e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the e on boardings where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e on boardings
	* @param end the upper bound of the range of e on boardings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e on boarding
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a matching e on boarding could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding findByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e on boarding, or <code>null</code> if a matching e on boarding could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding fetchByS_U_First(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e on boarding
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a matching e on boarding could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding findByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e on boarding, or <code>null</code> if a matching e on boarding could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding fetchByS_U_Last(
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the e on boardings before and after the current e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param eOnBoardingId the primary key of the current e on boarding
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e on boarding
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding[] findByS_U_PrevAndNext(
		long eOnBoardingId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(eOnBoardingId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the e on boardings where status = &#63; and userId = &#63; from the database.
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
	* Returns the number of e on boardings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the e on boarding in the entity cache if it is enabled.
	*
	* @param eOnBoarding the e on boarding
	*/
	public static void cacheResult(
		com.e.onboarding.model.EOnBoarding eOnBoarding) {
		getPersistence().cacheResult(eOnBoarding);
	}

	/**
	* Caches the e on boardings in the entity cache if it is enabled.
	*
	* @param eOnBoardings the e on boardings
	*/
	public static void cacheResult(
		java.util.List<com.e.onboarding.model.EOnBoarding> eOnBoardings) {
		getPersistence().cacheResult(eOnBoardings);
	}

	/**
	* Creates a new e on boarding with the primary key. Does not add the e on boarding to the database.
	*
	* @param eOnBoardingId the primary key for the new e on boarding
	* @return the new e on boarding
	*/
	public static com.e.onboarding.model.EOnBoarding create(long eOnBoardingId) {
		return getPersistence().create(eOnBoardingId);
	}

	/**
	* Removes the e on boarding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding that was removed
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding remove(long eOnBoardingId)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eOnBoardingId);
	}

	public static com.e.onboarding.model.EOnBoarding updateImpl(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eOnBoarding);
	}

	/**
	* Returns the e on boarding with the primary key or throws a {@link com.e.onboarding.NoSuchEOnBoardingException} if it could not be found.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding findByPrimaryKey(
		long eOnBoardingId)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eOnBoardingId);
	}

	/**
	* Returns the e on boarding with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding, or <code>null</code> if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding fetchByPrimaryKey(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eOnBoardingId);
	}

	/**
	* Returns all the e on boardings.
	*
	* @return the e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e on boardings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e on boardings
	* @param end the upper bound of the range of e on boardings (not inclusive)
	* @return the range of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e on boardings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e on boardings
	* @param end the upper bound of the range of e on boardings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e on boardings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e on boardings.
	*
	* @return the number of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EOnBoardingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EOnBoardingPersistence)PortletBeanLocatorUtil.locate(com.e.onboarding.service.ClpSerializer.getServletContextName(),
					EOnBoardingPersistence.class.getName());

			ReferenceRegistry.registerReference(EOnBoardingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EOnBoardingPersistence persistence) {
	}

	private static EOnBoardingPersistence _persistence;
}