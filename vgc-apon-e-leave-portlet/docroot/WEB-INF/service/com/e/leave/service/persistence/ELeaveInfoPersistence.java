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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e leave info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ELeaveInfoPersistenceImpl
 * @see ELeaveInfoUtil
 * @generated
 */
public interface ELeaveInfoPersistence extends BasePersistence<ELeaveInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ELeaveInfoUtil} to access the e leave info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the e leave info in the entity cache if it is enabled.
	*
	* @param eLeaveInfo the e leave info
	*/
	public void cacheResult(com.e.leave.model.ELeaveInfo eLeaveInfo);

	/**
	* Caches the e leave infos in the entity cache if it is enabled.
	*
	* @param eLeaveInfos the e leave infos
	*/
	public void cacheResult(
		java.util.List<com.e.leave.model.ELeaveInfo> eLeaveInfos);

	/**
	* Creates a new e leave info with the primary key. Does not add the e leave info to the database.
	*
	* @param eLeaveInfoId the primary key for the new e leave info
	* @return the new e leave info
	*/
	public com.e.leave.model.ELeaveInfo create(long eLeaveInfoId);

	/**
	* Removes the e leave info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info that was removed
	* @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeaveInfo remove(long eLeaveInfoId)
		throws com.e.leave.NoSuchELeaveInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.e.leave.model.ELeaveInfo updateImpl(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e leave info with the primary key or throws a {@link com.e.leave.NoSuchELeaveInfoException} if it could not be found.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info
	* @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeaveInfo findByPrimaryKey(long eLeaveInfoId)
		throws com.e.leave.NoSuchELeaveInfoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e leave info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info, or <code>null</code> if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeaveInfo fetchByPrimaryKey(long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e leave infos.
	*
	* @return the e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.leave.model.ELeaveInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.leave.model.ELeaveInfo> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.leave.model.ELeaveInfo> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e leave infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e leave infos.
	*
	* @return the number of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}