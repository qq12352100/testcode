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

import com.e.leave.model.ELeaveInfo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e leave info service. This utility wraps {@link ELeaveInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ELeaveInfoPersistence
 * @see ELeaveInfoPersistenceImpl
 * @generated
 */
public class ELeaveInfoUtil {
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
	public static void clearCache(ELeaveInfo eLeaveInfo) {
		getPersistence().clearCache(eLeaveInfo);
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
	public static List<ELeaveInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ELeaveInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ELeaveInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ELeaveInfo update(ELeaveInfo eLeaveInfo)
		throws SystemException {
		return getPersistence().update(eLeaveInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ELeaveInfo update(ELeaveInfo eLeaveInfo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eLeaveInfo, serviceContext);
	}

	/**
	* Caches the e leave info in the entity cache if it is enabled.
	*
	* @param eLeaveInfo the e leave info
	*/
	public static void cacheResult(com.e.leave.model.ELeaveInfo eLeaveInfo) {
		getPersistence().cacheResult(eLeaveInfo);
	}

	/**
	* Caches the e leave infos in the entity cache if it is enabled.
	*
	* @param eLeaveInfos the e leave infos
	*/
	public static void cacheResult(
		java.util.List<com.e.leave.model.ELeaveInfo> eLeaveInfos) {
		getPersistence().cacheResult(eLeaveInfos);
	}

	/**
	* Creates a new e leave info with the primary key. Does not add the e leave info to the database.
	*
	* @param eLeaveInfoId the primary key for the new e leave info
	* @return the new e leave info
	*/
	public static com.e.leave.model.ELeaveInfo create(long eLeaveInfoId) {
		return getPersistence().create(eLeaveInfoId);
	}

	/**
	* Removes the e leave info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info that was removed
	* @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo remove(long eLeaveInfoId)
		throws com.e.leave.NoSuchELeaveInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eLeaveInfoId);
	}

	public static com.e.leave.model.ELeaveInfo updateImpl(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eLeaveInfo);
	}

	/**
	* Returns the e leave info with the primary key or throws a {@link com.e.leave.NoSuchELeaveInfoException} if it could not be found.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info
	* @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo findByPrimaryKey(
		long eLeaveInfoId)
		throws com.e.leave.NoSuchELeaveInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eLeaveInfoId);
	}

	/**
	* Returns the e leave info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info, or <code>null</code> if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo fetchByPrimaryKey(
		long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eLeaveInfoId);
	}

	/**
	* Returns all the e leave infos.
	*
	* @return the e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeaveInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e leave infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leave infos
	* @param end the upper bound of the range of e leave infos (not inclusive)
	* @return the range of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeaveInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e leave infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leave infos
	* @param end the upper bound of the range of e leave infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeaveInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e leave infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e leave infos.
	*
	* @return the number of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ELeaveInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ELeaveInfoPersistence)PortletBeanLocatorUtil.locate(com.e.leave.service.ClpSerializer.getServletContextName(),
					ELeaveInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(ELeaveInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ELeaveInfoPersistence persistence) {
	}

	private static ELeaveInfoPersistence _persistence;
}