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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ELeavePersistenceImpl
 * @see ELeaveUtil
 * @generated
 */
public interface ELeavePersistence extends BasePersistence<ELeave> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ELeaveUtil} to access the e leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e leaves where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.leave.model.ELeave> findByS_U(int status,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.leave.model.ELeave> findByS_U(int status,
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.leave.model.ELeave> findByS_U(int status,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.leave.model.ELeave findByS_U_First(int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e leave, or <code>null</code> if a matching e leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeave fetchByS_U_First(int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.leave.model.ELeave findByS_U_Last(int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e leave in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e leave, or <code>null</code> if a matching e leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeave fetchByS_U_Last(int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.leave.model.ELeave[] findByS_U_PrevAndNext(long eLeaveId,
		int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e leaves where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e leaves where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e leaves
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e leave in the entity cache if it is enabled.
	*
	* @param eLeave the e leave
	*/
	public void cacheResult(com.e.leave.model.ELeave eLeave);

	/**
	* Caches the e leaves in the entity cache if it is enabled.
	*
	* @param eLeaves the e leaves
	*/
	public void cacheResult(java.util.List<com.e.leave.model.ELeave> eLeaves);

	/**
	* Creates a new e leave with the primary key. Does not add the e leave to the database.
	*
	* @param eLeaveId the primary key for the new e leave
	* @return the new e leave
	*/
	public com.e.leave.model.ELeave create(long eLeaveId);

	/**
	* Removes the e leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave that was removed
	* @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeave remove(long eLeaveId)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.e.leave.model.ELeave updateImpl(com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e leave with the primary key or throws a {@link com.e.leave.NoSuchELeaveException} if it could not be found.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave
	* @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeave findByPrimaryKey(long eLeaveId)
		throws com.e.leave.NoSuchELeaveException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e leave with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave, or <code>null</code> if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.leave.model.ELeave fetchByPrimaryKey(long eLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e leaves.
	*
	* @return the e leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.leave.model.ELeave> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.leave.model.ELeave> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.leave.model.ELeave> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e leaves from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e leaves.
	*
	* @return the number of e leaves
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}