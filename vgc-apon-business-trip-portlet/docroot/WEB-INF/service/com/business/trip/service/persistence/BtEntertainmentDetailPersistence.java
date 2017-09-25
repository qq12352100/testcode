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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt entertainment detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetailPersistenceImpl
 * @see BtEntertainmentDetailUtil
 * @generated
 */
public interface BtEntertainmentDetailPersistence extends BasePersistence<BtEntertainmentDetail> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtEntertainmentDetailUtil} to access the bt entertainment detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bt entertainment details where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @return the matching bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail findByBtCostListId_First(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bt entertainment detail, or <code>null</code> if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail fetchByBtCostListId_First(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail findByBtCostListId_Last(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bt entertainment detail in the ordered set where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bt entertainment detail, or <code>null</code> if a matching bt entertainment detail could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail fetchByBtCostListId_Last(
		long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.business.trip.model.BtEntertainmentDetail[] findByBtCostListId_PrevAndNext(
		long btEntertainmentDetailId, long btCostListId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt entertainment details where btCostListId = &#63; from the database.
	*
	* @param btCostListId the bt cost list ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBtCostListId(long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt entertainment details where btCostListId = &#63;.
	*
	* @param btCostListId the bt cost list ID
	* @return the number of matching bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public int countByBtCostListId(long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bt entertainment detail in the entity cache if it is enabled.
	*
	* @param btEntertainmentDetail the bt entertainment detail
	*/
	public void cacheResult(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail);

	/**
	* Caches the bt entertainment details in the entity cache if it is enabled.
	*
	* @param btEntertainmentDetails the bt entertainment details
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtEntertainmentDetail> btEntertainmentDetails);

	/**
	* Creates a new bt entertainment detail with the primary key. Does not add the bt entertainment detail to the database.
	*
	* @param btEntertainmentDetailId the primary key for the new bt entertainment detail
	* @return the new bt entertainment detail
	*/
	public com.business.trip.model.BtEntertainmentDetail create(
		long btEntertainmentDetailId);

	/**
	* Removes the bt entertainment detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail that was removed
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail remove(
		long btEntertainmentDetailId)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtEntertainmentDetail updateImpl(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt entertainment detail with the primary key or throws a {@link com.business.trip.NoSuchBtEntertainmentDetailException} if it could not be found.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail
	* @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail findByPrimaryKey(
		long btEntertainmentDetailId)
		throws com.business.trip.NoSuchBtEntertainmentDetailException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt entertainment detail with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail, or <code>null</code> if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtEntertainmentDetail fetchByPrimaryKey(
		long btEntertainmentDetailId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt entertainment details.
	*
	* @return the bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtEntertainmentDetail> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.business.trip.model.BtEntertainmentDetail> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.business.trip.model.BtEntertainmentDetail> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt entertainment details from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt entertainment details.
	*
	* @return the number of bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}