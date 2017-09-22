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

package com.e.closing.service.persistence;

import com.e.closing.model.EClosing;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e closing service. This utility wraps {@link EClosingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author t.a.jiang
 * @see EClosingPersistence
 * @see EClosingPersistenceImpl
 * @generated
 */
public class EClosingUtil {
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
	public static void clearCache(EClosing eClosing) {
		getPersistence().clearCache(eClosing);
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
	public static List<EClosing> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EClosing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EClosing> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EClosing update(EClosing eClosing) throws SystemException {
		return getPersistence().update(eClosing);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EClosing update(EClosing eClosing,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eClosing, serviceContext);
	}

	/**
	* Returns all the e closings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the e closings where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e closings
	* @param end the upper bound of the range of e closings (not inclusive)
	* @return the range of matching e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the e closings where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e closings
	* @param end the upper bound of the range of e closings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e closing
	* @throws com.e.closing.NoSuchEClosingException if a matching e closing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e closing, or <code>null</code> if a matching e closing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e closing
	* @throws com.e.closing.NoSuchEClosingException if a matching e closing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e closing, or <code>null</code> if a matching e closing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the e closings before and after the current e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param eclosingId the primary key of the current e closing
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e closing
	* @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing[] findByS_U_PrevAndNext(
		long eclosingId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(eclosingId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the e closings where status = &#63; and userId = &#63; from the database.
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
	* Returns the number of e closings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e closings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the e closing in the entity cache if it is enabled.
	*
	* @param eClosing the e closing
	*/
	public static void cacheResult(com.e.closing.model.EClosing eClosing) {
		getPersistence().cacheResult(eClosing);
	}

	/**
	* Caches the e closings in the entity cache if it is enabled.
	*
	* @param eClosings the e closings
	*/
	public static void cacheResult(
		java.util.List<com.e.closing.model.EClosing> eClosings) {
		getPersistence().cacheResult(eClosings);
	}

	/**
	* Creates a new e closing with the primary key. Does not add the e closing to the database.
	*
	* @param eclosingId the primary key for the new e closing
	* @return the new e closing
	*/
	public static com.e.closing.model.EClosing create(long eclosingId) {
		return getPersistence().create(eclosingId);
	}

	/**
	* Removes the e closing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing that was removed
	* @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing remove(long eclosingId)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eclosingId);
	}

	public static com.e.closing.model.EClosing updateImpl(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eClosing);
	}

	/**
	* Returns the e closing with the primary key or throws a {@link com.e.closing.NoSuchEClosingException} if it could not be found.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing
	* @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing findByPrimaryKey(long eclosingId)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eclosingId);
	}

	/**
	* Returns the e closing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing, or <code>null</code> if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing fetchByPrimaryKey(
		long eclosingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eclosingId);
	}

	/**
	* Returns all the e closings.
	*
	* @return the e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e closings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e closings
	* @param end the upper bound of the range of e closings (not inclusive)
	* @return the range of e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e closings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e closings
	* @param end the upper bound of the range of e closings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e closings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e closings.
	*
	* @return the number of e closings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EClosingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EClosingPersistence)PortletBeanLocatorUtil.locate(com.e.closing.service.ClpSerializer.getServletContextName(),
					EClosingPersistence.class.getName());

			ReferenceRegistry.registerReference(EClosingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EClosingPersistence persistence) {
	}

	private static EClosingPersistence _persistence;
}