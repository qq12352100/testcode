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

import com.business.trip.model.BtReimbursementSAPInfo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt reimbursement s a p info service. This utility wraps {@link BtReimbursementSAPInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfoPersistence
 * @see BtReimbursementSAPInfoPersistenceImpl
 * @generated
 */
public class BtReimbursementSAPInfoUtil {
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
	public static void clearCache(BtReimbursementSAPInfo btReimbursementSAPInfo) {
		getPersistence().clearCache(btReimbursementSAPInfo);
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
	public static List<BtReimbursementSAPInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtReimbursementSAPInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtReimbursementSAPInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtReimbursementSAPInfo update(
		BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws SystemException {
		return getPersistence().update(btReimbursementSAPInfo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtReimbursementSAPInfo update(
		BtReimbursementSAPInfo btReimbursementSAPInfo,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(btReimbursementSAPInfo, serviceContext);
	}

	/**
	* Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or throws a {@link com.business.trip.NoSuchBtReimbursementSAPInfoException} if it could not be found.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the matching bt reimbursement s a p info
	* @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a matching bt reimbursement s a p info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo findByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByB_C(currency, businessTripPkId);
	}

	/**
	* Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the matching bt reimbursement s a p info, or <code>null</code> if a matching bt reimbursement s a p info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo fetchByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByB_C(currency, businessTripPkId);
	}

	/**
	* Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bt reimbursement s a p info, or <code>null</code> if a matching bt reimbursement s a p info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo fetchByB_C(
		java.lang.String currency, long businessTripPkId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByB_C(currency, businessTripPkId, retrieveFromCache);
	}

	/**
	* Removes the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; from the database.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the bt reimbursement s a p info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo removeByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByB_C(currency, businessTripPkId);
	}

	/**
	* Returns the number of bt reimbursement s a p infos where currency = &#63; and businessTripPkId = &#63;.
	*
	* @param currency the currency
	* @param businessTripPkId the business trip pk ID
	* @return the number of matching bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countByB_C(java.lang.String currency,
		long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByB_C(currency, businessTripPkId);
	}

	/**
	* Caches the bt reimbursement s a p info in the entity cache if it is enabled.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	*/
	public static void cacheResult(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo) {
		getPersistence().cacheResult(btReimbursementSAPInfo);
	}

	/**
	* Caches the bt reimbursement s a p infos in the entity cache if it is enabled.
	*
	* @param btReimbursementSAPInfos the bt reimbursement s a p infos
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtReimbursementSAPInfo> btReimbursementSAPInfos) {
		getPersistence().cacheResult(btReimbursementSAPInfos);
	}

	/**
	* Creates a new bt reimbursement s a p info with the primary key. Does not add the bt reimbursement s a p info to the database.
	*
	* @param btReimbursementSAPInfoId the primary key for the new bt reimbursement s a p info
	* @return the new bt reimbursement s a p info
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo create(
		long btReimbursementSAPInfoId) {
		return getPersistence().create(btReimbursementSAPInfoId);
	}

	/**
	* Removes the bt reimbursement s a p info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was removed
	* @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo remove(
		long btReimbursementSAPInfoId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btReimbursementSAPInfoId);
	}

	public static com.business.trip.model.BtReimbursementSAPInfo updateImpl(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btReimbursementSAPInfo);
	}

	/**
	* Returns the bt reimbursement s a p info with the primary key or throws a {@link com.business.trip.NoSuchBtReimbursementSAPInfoException} if it could not be found.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info
	* @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo findByPrimaryKey(
		long btReimbursementSAPInfoId)
		throws com.business.trip.NoSuchBtReimbursementSAPInfoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btReimbursementSAPInfoId);
	}

	/**
	* Returns the bt reimbursement s a p info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info, or <code>null</code> if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtReimbursementSAPInfo fetchByPrimaryKey(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btReimbursementSAPInfoId);
	}

	/**
	* Returns all the bt reimbursement s a p infos.
	*
	* @return the bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtReimbursementSAPInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bt reimbursement s a p infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt reimbursement s a p infos
	* @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	* @return the range of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtReimbursementSAPInfo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bt reimbursement s a p infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt reimbursement s a p infos
	* @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtReimbursementSAPInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt reimbursement s a p infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt reimbursement s a p infos.
	*
	* @return the number of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtReimbursementSAPInfoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtReimbursementSAPInfoPersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtReimbursementSAPInfoPersistence.class.getName());

			ReferenceRegistry.registerReference(BtReimbursementSAPInfoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtReimbursementSAPInfoPersistence persistence) {
	}

	private static BtReimbursementSAPInfoPersistence _persistence;
}