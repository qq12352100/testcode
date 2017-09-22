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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e closing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author t.a.jiang
 * @see EClosingPersistenceImpl
 * @see EClosingUtil
 * @generated
 */
public interface EClosingPersistence extends BasePersistence<EClosing> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EClosingUtil} to access the e closing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e closings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e closings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.closing.model.EClosing> findByS_U(int status,
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.closing.model.EClosing> findByS_U(int status,
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.closing.model.EClosing> findByS_U(int status,
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.closing.model.EClosing findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e closing, or <code>null</code> if a matching e closing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.closing.model.EClosing fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.closing.model.EClosing findByS_U_Last(int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e closing in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e closing, or <code>null</code> if a matching e closing could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.closing.model.EClosing fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.closing.model.EClosing[] findByS_U_PrevAndNext(
		long eclosingId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e closings where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e closings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e closings
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e closing in the entity cache if it is enabled.
	*
	* @param eClosing the e closing
	*/
	public void cacheResult(com.e.closing.model.EClosing eClosing);

	/**
	* Caches the e closings in the entity cache if it is enabled.
	*
	* @param eClosings the e closings
	*/
	public void cacheResult(
		java.util.List<com.e.closing.model.EClosing> eClosings);

	/**
	* Creates a new e closing with the primary key. Does not add the e closing to the database.
	*
	* @param eclosingId the primary key for the new e closing
	* @return the new e closing
	*/
	public com.e.closing.model.EClosing create(long eclosingId);

	/**
	* Removes the e closing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing that was removed
	* @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.closing.model.EClosing remove(long eclosingId)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.e.closing.model.EClosing updateImpl(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e closing with the primary key or throws a {@link com.e.closing.NoSuchEClosingException} if it could not be found.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing
	* @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.closing.model.EClosing findByPrimaryKey(long eclosingId)
		throws com.e.closing.NoSuchEClosingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e closing with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing, or <code>null</code> if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.closing.model.EClosing fetchByPrimaryKey(long eclosingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e closings.
	*
	* @return the e closings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.closing.model.EClosing> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.closing.model.EClosing> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.closing.model.EClosing> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e closings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e closings.
	*
	* @return the number of e closings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}