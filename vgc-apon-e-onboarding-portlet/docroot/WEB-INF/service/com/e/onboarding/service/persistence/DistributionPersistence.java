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

import com.e.onboarding.model.Distribution;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the distribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sanguine
 * @see DistributionPersistenceImpl
 * @see DistributionUtil
 * @generated
 */
public interface DistributionPersistence extends BasePersistence<Distribution> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DistributionUtil} to access the distribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the distributions where type = &#63;.
	*
	* @param type the type
	* @return the matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.Distribution> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the distributions where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.Distribution> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the distributions where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.Distribution> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distributions before and after the current distribution in the ordered set where type = &#63;.
	*
	* @param distributionId the primary key of the current distribution
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution[] findByType_PrevAndNext(
		long distributionId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the distributions where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of distributions where type = &#63;.
	*
	* @param type the type
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distribution where emailAddress = &#63; or throws a {@link com.e.onboarding.NoSuchDistributionException} if it could not be found.
	*
	* @param emailAddress the email address
	* @return the matching distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution findByemailAddress(
		java.lang.String emailAddress)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distribution where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @return the matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution fetchByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distribution where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution fetchByemailAddress(
		java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the distribution where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @return the distribution that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution removeByemailAddress(
		java.lang.String emailAddress)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of distributions where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public int countByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the distribution in the entity cache if it is enabled.
	*
	* @param distribution the distribution
	*/
	public void cacheResult(com.e.onboarding.model.Distribution distribution);

	/**
	* Caches the distributions in the entity cache if it is enabled.
	*
	* @param distributions the distributions
	*/
	public void cacheResult(
		java.util.List<com.e.onboarding.model.Distribution> distributions);

	/**
	* Creates a new distribution with the primary key. Does not add the distribution to the database.
	*
	* @param distributionId the primary key for the new distribution
	* @return the new distribution
	*/
	public com.e.onboarding.model.Distribution create(long distributionId);

	/**
	* Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution that was removed
	* @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution remove(long distributionId)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.e.onboarding.model.Distribution updateImpl(
		com.e.onboarding.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distribution with the primary key or throws a {@link com.e.onboarding.NoSuchDistributionException} if it could not be found.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution findByPrimaryKey(
		long distributionId)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.onboarding.model.Distribution fetchByPrimaryKey(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the distributions.
	*
	* @return the distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.Distribution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.Distribution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of distributions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.onboarding.model.Distribution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the distributions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of distributions.
	*
	* @return the number of distributions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}