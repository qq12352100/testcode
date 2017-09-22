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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the distribution service. This utility wraps {@link DistributionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sanguine
 * @see DistributionPersistence
 * @see DistributionPersistenceImpl
 * @generated
 */
public class DistributionUtil {
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
	public static void clearCache(Distribution distribution) {
		getPersistence().clearCache(distribution);
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
	public static List<Distribution> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Distribution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Distribution> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Distribution update(Distribution distribution)
		throws SystemException {
		return getPersistence().update(distribution);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Distribution update(Distribution distribution,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(distribution, serviceContext);
	}

	/**
	* Returns all the distributions where type = &#63;.
	*
	* @param type the type
	* @return the matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.Distribution> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type);
	}

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
	public static java.util.List<com.e.onboarding.model.Distribution> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end);
	}

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
	public static java.util.List<com.e.onboarding.model.Distribution> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType(type, start, end, orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_First(type, orderByComparator);
	}

	/**
	* Returns the first distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_First(type, orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByType_Last(type, orderByComparator);
	}

	/**
	* Returns the last distribution in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByType_Last(type, orderByComparator);
	}

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
	public static com.e.onboarding.model.Distribution[] findByType_PrevAndNext(
		long distributionId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByType_PrevAndNext(distributionId, type,
			orderByComparator);
	}

	/**
	* Removes all the distributions where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByType(type);
	}

	/**
	* Returns the number of distributions where type = &#63;.
	*
	* @param type the type
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByType(type);
	}

	/**
	* Returns the distribution where emailAddress = &#63; or throws a {@link com.e.onboarding.NoSuchDistributionException} if it could not be found.
	*
	* @param emailAddress the email address
	* @return the matching distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution findByemailAddress(
		java.lang.String emailAddress)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByemailAddress(emailAddress);
	}

	/**
	* Returns the distribution where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param emailAddress the email address
	* @return the matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution fetchByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByemailAddress(emailAddress);
	}

	/**
	* Returns the distribution where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching distribution, or <code>null</code> if a matching distribution could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution fetchByemailAddress(
		java.lang.String emailAddress, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByemailAddress(emailAddress, retrieveFromCache);
	}

	/**
	* Removes the distribution where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @return the distribution that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution removeByemailAddress(
		java.lang.String emailAddress)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByemailAddress(emailAddress);
	}

	/**
	* Returns the number of distributions where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByemailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByemailAddress(emailAddress);
	}

	/**
	* Caches the distribution in the entity cache if it is enabled.
	*
	* @param distribution the distribution
	*/
	public static void cacheResult(
		com.e.onboarding.model.Distribution distribution) {
		getPersistence().cacheResult(distribution);
	}

	/**
	* Caches the distributions in the entity cache if it is enabled.
	*
	* @param distributions the distributions
	*/
	public static void cacheResult(
		java.util.List<com.e.onboarding.model.Distribution> distributions) {
		getPersistence().cacheResult(distributions);
	}

	/**
	* Creates a new distribution with the primary key. Does not add the distribution to the database.
	*
	* @param distributionId the primary key for the new distribution
	* @return the new distribution
	*/
	public static com.e.onboarding.model.Distribution create(
		long distributionId) {
		return getPersistence().create(distributionId);
	}

	/**
	* Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution that was removed
	* @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution remove(
		long distributionId)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(distributionId);
	}

	public static com.e.onboarding.model.Distribution updateImpl(
		com.e.onboarding.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(distribution);
	}

	/**
	* Returns the distribution with the primary key or throws a {@link com.e.onboarding.NoSuchDistributionException} if it could not be found.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution
	* @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution findByPrimaryKey(
		long distributionId)
		throws com.e.onboarding.NoSuchDistributionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(distributionId);
	}

	/**
	* Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution fetchByPrimaryKey(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(distributionId);
	}

	/**
	* Returns all the distributions.
	*
	* @return the distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.Distribution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.e.onboarding.model.Distribution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.e.onboarding.model.Distribution> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the distributions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of distributions.
	*
	* @return the number of distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DistributionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DistributionPersistence)PortletBeanLocatorUtil.locate(com.e.onboarding.service.ClpSerializer.getServletContextName(),
					DistributionPersistence.class.getName());

			ReferenceRegistry.registerReference(DistributionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DistributionPersistence persistence) {
	}

	private static DistributionPersistence _persistence;
}