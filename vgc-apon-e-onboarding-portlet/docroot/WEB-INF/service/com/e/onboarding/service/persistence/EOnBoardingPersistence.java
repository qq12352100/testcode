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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e on boarding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sanguine
 * @see EOnBoardingPersistenceImpl
 * @see EOnBoardingUtil
 * @generated
 */
public interface EOnBoardingPersistence extends BasePersistence<EOnBoarding> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EOnBoardingUtil} to access the e on boarding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e on boardings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.onboarding.model.EOnBoarding findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e on boarding, or <code>null</code> if a matching e on boarding could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.EOnBoarding fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.onboarding.model.EOnBoarding findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e on boarding in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e on boarding, or <code>null</code> if a matching e on boarding could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.EOnBoarding fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.onboarding.model.EOnBoarding[] findByS_U_PrevAndNext(
		long eOnBoardingId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e on boardings where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e on boardings where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e on boarding in the entity cache if it is enabled.
	*
	* @param eOnBoarding the e on boarding
	*/
	public void cacheResult(com.e.onboarding.model.EOnBoarding eOnBoarding);

	/**
	* Caches the e on boardings in the entity cache if it is enabled.
	*
	* @param eOnBoardings the e on boardings
	*/
	public void cacheResult(
		java.util.List<com.e.onboarding.model.EOnBoarding> eOnBoardings);

	/**
	* Creates a new e on boarding with the primary key. Does not add the e on boarding to the database.
	*
	* @param eOnBoardingId the primary key for the new e on boarding
	* @return the new e on boarding
	*/
	public com.e.onboarding.model.EOnBoarding create(long eOnBoardingId);

	/**
	* Removes the e on boarding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding that was removed
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.EOnBoarding remove(long eOnBoardingId)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.e.onboarding.model.EOnBoarding updateImpl(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e on boarding with the primary key or throws a {@link com.e.onboarding.NoSuchEOnBoardingException} if it could not be found.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding
	* @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.EOnBoarding findByPrimaryKey(
		long eOnBoardingId)
		throws com.e.onboarding.NoSuchEOnBoardingException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e on boarding with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding, or <code>null</code> if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.EOnBoarding fetchByPrimaryKey(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e on boardings.
	*
	* @return the e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.EOnBoarding> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.onboarding.model.EOnBoarding> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.onboarding.model.EOnBoarding> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e on boardings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e on boardings.
	*
	* @return the number of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}