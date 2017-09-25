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

import com.business.trip.model.BtExchangeSAPRate;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bt exchange s a p rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRatePersistenceImpl
 * @see BtExchangeSAPRateUtil
 * @generated
 */
public interface BtExchangeSAPRatePersistence extends BasePersistence<BtExchangeSAPRate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtExchangeSAPRateUtil} to access the bt exchange s a p rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the bt exchange s a p rate in the entity cache if it is enabled.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	*/
	public void cacheResult(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate);

	/**
	* Caches the bt exchange s a p rates in the entity cache if it is enabled.
	*
	* @param btExchangeSAPRates the bt exchange s a p rates
	*/
	public void cacheResult(
		java.util.List<com.business.trip.model.BtExchangeSAPRate> btExchangeSAPRates);

	/**
	* Creates a new bt exchange s a p rate with the primary key. Does not add the bt exchange s a p rate to the database.
	*
	* @param btExchangeSAPRateId the primary key for the new bt exchange s a p rate
	* @return the new bt exchange s a p rate
	*/
	public com.business.trip.model.BtExchangeSAPRate create(
		long btExchangeSAPRateId);

	/**
	* Removes the bt exchange s a p rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate that was removed
	* @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeSAPRate remove(
		long btExchangeSAPRateId)
		throws com.business.trip.NoSuchBtExchangeSAPRateException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BtExchangeSAPRate updateImpl(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange s a p rate with the primary key or throws a {@link com.business.trip.NoSuchBtExchangeSAPRateException} if it could not be found.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate
	* @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeSAPRate findByPrimaryKey(
		long btExchangeSAPRateId)
		throws com.business.trip.NoSuchBtExchangeSAPRateException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt exchange s a p rate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate, or <code>null</code> if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.business.trip.model.BtExchangeSAPRate fetchByPrimaryKey(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bt exchange s a p rates.
	*
	* @return the bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtExchangeSAPRate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bt exchange s a p rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange s a p rates
	* @param end the upper bound of the range of bt exchange s a p rates (not inclusive)
	* @return the range of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtExchangeSAPRate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bt exchange s a p rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange s a p rates
	* @param end the upper bound of the range of bt exchange s a p rates (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.business.trip.model.BtExchangeSAPRate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bt exchange s a p rates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt exchange s a p rates.
	*
	* @return the number of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}