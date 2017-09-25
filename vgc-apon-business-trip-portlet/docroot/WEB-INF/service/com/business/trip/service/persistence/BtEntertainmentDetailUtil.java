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

import com.business.trip.model.BtEntertainmentDetail;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bt entertainment detail service. This utility wraps {@link BtEntertainmentDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetailPersistence
 * @see BtEntertainmentDetailPersistenceImpl
 * @generated
 */
public class BtEntertainmentDetailUtil {
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
	public static void clearCache(BtEntertainmentDetail btEntertainmentDetail) {
		getPersistence().clearCache(btEntertainmentDetail);
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
	public static List<BtEntertainmentDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BtEntertainmentDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BtEntertainmentDetail> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BtEntertainmentDetail update(
		BtEntertainmentDetail btEntertainmentDetail) throws SystemException {
		return getPersistence().update(btEntertainmentDetail);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BtEntertainmentDetail update(
		BtEntertainmentDetail btEntertainmentDetail,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(btEntertainmentDetail, serviceContext);
	}

	/**
	* Returns all the bt entertainment details where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @return the matching bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBtCostListId(btCostListId);
	}

	/**
	* Returns a range of all the bt entertainment details where btCostListId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param btCostListId the bt cost list ID
	* @param start the lower bound of the range of bt entertainment details
	* @param end the upper bound of the range of bt entertainment details (not inclusive)
	* @return the range of matching bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBtCostListId(btCostListId, start, end);
	}

	/**
	* Returns an ordered range of all the bt entertainment details where btCostListId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param btCostListId the bt cost list ID
	* @param start the lower bound of the range of bt entertainment details
	* @param end the upper bound of the range of bt entertainment details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBtCostListId(btCostListId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail findByBtCostListId_First(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBtCostListId_First(btCostListId, orderByComparator);
	}

	/**
	* Returns the first bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt entertainment detail, or <code>null</code> if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail fetchByBtCostListId_First(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBtCostListId_First(btCostListId, orderByComparator);
	}

	/**
	* Returns the last bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail findByBtCostListId_Last(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBtCostListId_Last(btCostListId, orderByComparator);
	}

	/**
	* Returns the last bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt entertainment detail, or <code>null</code> if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail fetchByBtCostListId_Last(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByBtCostListId_Last(btCostListId, orderByComparator);
	}

	/**
	* Returns the bt entertainment details before and after the current bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btEntertainmentDetailId the primary key of the current bt entertainment detail
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail[] findByBtCostListId_PrevAndNext(
		long btEntertainmentDetailId, long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBtCostListId_PrevAndNext(btEntertainmentDetailId,
			btCostListId, orderByComparator);
	}

	/**
	* Removes all the bt entertainment details where btCostListId = &#63; from the database.
	*
	* @param btCostListId the bt cost list ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBtCostListId(long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBtCostListId(btCostListId);
	}

	/**
	* Returns the number of bt entertainment details where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @return the number of matching bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBtCostListId(long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBtCostListId(btCostListId);
	}

	/**
	* Caches the bt entertainment detail in the entity cache if it is enabled.
	*
	* @param btEntertainmentDetail the bt entertainment detail
	*/
	public static void cacheResult(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail) {
		getPersistence().cacheResult(btEntertainmentDetail);
	}

	/**
	* Caches the bt entertainment details in the entity cache if it is enabled.
	*
	* @param btEntertainmentDetails the bt entertainment details
	*/
	public static void cacheResult(
		java.util.List<com.business.trip.model.BtEntertainmentDetail> btEntertainmentDetails) {
		getPersistence().cacheResult(btEntertainmentDetails);
	}

	/**
	* Creates a new bt entertainment detail with the primary key. Does not add the bt entertainment detail to the database.
	*
	* @param btEntertainmentDetailId the primary key for the new bt entertainment detail
	* @return the new bt entertainment detail
	*/
	public static com.business.trip.model.BtEntertainmentDetail create(
		long btEntertainmentDetailId) {
		return getPersistence().create(btEntertainmentDetailId);
	}

	/**
	* Removes the bt entertainment detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail that was removed
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail remove(
		long btEntertainmentDetailId)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(btEntertainmentDetailId);
	}

	public static com.business.trip.model.BtEntertainmentDetail updateImpl(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(btEntertainmentDetail);
	}

	/**
	* Returns the bt entertainment detail with the primary key or throws a {@link com.business.trip.NoSuchBtEntertainmentDetailException} if it could not be found.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail findByPrimaryKey(
		long btEntertainmentDetailId)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(btEntertainmentDetailId);
	}

	/**
	* Returns the bt entertainment detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail, or <code>null</code> if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail fetchByPrimaryKey(
		long btEntertainmentDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(btEntertainmentDetailId);
	}

	/**
	* Returns all the bt entertainment details.
	*
	* @return the bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bt entertainment details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt entertainment details
	* @param end the upper bound of the range of bt entertainment details (not inclusive)
	* @return the range of bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bt entertainment details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt entertainment details
	* @param end the upper bound of the range of bt entertainment details (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bt entertainment details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bt entertainment details.
	*
	* @return the number of bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BtEntertainmentDetailPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BtEntertainmentDetailPersistence)PortletBeanLocatorUtil.locate(com.business.trip.service.ClpSerializer.getServletContextName(),
					BtEntertainmentDetailPersistence.class.getName());

			ReferenceRegistry.registerReference(BtEntertainmentDetailUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BtEntertainmentDetailPersistence persistence) {
	}

	private static BtEntertainmentDetailPersistence _persistence;
}