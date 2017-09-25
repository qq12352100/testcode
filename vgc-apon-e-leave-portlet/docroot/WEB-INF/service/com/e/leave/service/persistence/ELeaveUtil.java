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

package com.e.leave.service.persistence;

import com.e.leave.model.ELeave;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e leave service. This utility wraps {@link ELeavePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ELeavePersistence
 * @see ELeavePersistenceImpl
 * @generated
 */
public class ELeaveUtil {
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
	public static void clearCache(ELeave eLeave) {
		getPersistence().clearCache(eLeave);
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
	public static List<ELeave> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ELeave> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ELeave> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ELeave update(ELeave eLeave) throws SystemException {
		return getPersistence().update(eLeave);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ELeave update(ELeave eLeave, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(eLeave, serviceContext);
	}

	/**
	* Returns all the e leaves where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the e leaves where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e leaves
	* @param end the upper bound of the range of e leaves (not inclusive)
	* @return the range of matching e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the e leaves where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e leaves
	* @param end the upper bound of the range of e leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e leave
	* @throws com.e.leave.NoSuchELeaveException if a matching e leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e leave, or <code>null</code> if a matching e leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e leave
	* @throws com.e.leave.NoSuchELeaveException if a matching e leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e leave, or <code>null</code> if a matching e leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the e leaves before and after the current e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param eLeaveId the primary key of the current e leave
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e leave
	* @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave[] findByS_U_PrevAndNext(
		long eLeaveId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(eLeaveId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the e leaves where status = &#63; and userId = &#63; from the database.
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
	* Returns the number of e leaves where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the e leave in the entity cache if it is enabled.
	*
	* @param eLeave the e leave
	*/
	public static void cacheResult(com.e.leave.model.ELeave eLeave) {
		getPersistence().cacheResult(eLeave);
	}

	/**
	* Caches the e leaves in the entity cache if it is enabled.
	*
	* @param eLeaves the e leaves
	*/
	public static void cacheResult(
		java.util.List<com.e.leave.model.ELeave> eLeaves) {
		getPersistence().cacheResult(eLeaves);
	}

	/**
	* Creates a new e leave with the primary key. Does not add the e leave to the database.
	*
	* @param eLeaveId the primary key for the new e leave
	* @return the new e leave
	*/
	public static com.e.leave.model.ELeave create(long eLeaveId) {
		return getPersistence().create(eLeaveId);
	}

	/**
	* Removes the e leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave that was removed
	* @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave remove(long eLeaveId)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eLeaveId);
	}

	public static com.e.leave.model.ELeave updateImpl(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eLeave);
	}

	/**
	* Returns the e leave with the primary key or throws a {@link com.e.leave.NoSuchELeaveException} if it could not be found.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave
	* @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave findByPrimaryKey(long eLeaveId)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eLeaveId);
	}

	/**
	* Returns the e leave with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave, or <code>null</code> if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave fetchByPrimaryKey(long eLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eLeaveId);
	}

	/**
	* Returns all the e leaves.
	*
	* @return the e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leaves
	* @param end the upper bound of the range of e leaves (not inclusive)
	* @return the range of e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leaves
	* @param end the upper bound of the range of e leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e leaves from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e leaves.
	*
	* @return the number of e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ELeavePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ELeavePersistence)PortletBeanLocatorUtil.locate(com.e.leave.service.ClpSerializer.getServletContextName(),
					ELeavePersistence.class.getName());

			ReferenceRegistry.registerReference(ELeaveUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ELeavePersistence persistence) {
	}

	private static ELeavePersistence _persistence;
}