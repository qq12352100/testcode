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

package com.business.trip.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BtExchangeRateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRateLocalService
 * @generated
 */
public class BtExchangeRateLocalServiceWrapper
	implements BtExchangeRateLocalService,
		ServiceWrapper<BtExchangeRateLocalService> {
	public BtExchangeRateLocalServiceWrapper(
		BtExchangeRateLocalService btExchangeRateLocalService) {
		_btExchangeRateLocalService = btExchangeRateLocalService;
	}

	/**
	* Adds the bt exchange rate to the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRate the bt exchange rate
	* @return the bt exchange rate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeRate addBtExchangeRate(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.addBtExchangeRate(btExchangeRate);
	}

	/**
	* Creates a new bt exchange rate with the primary key. Does not add the bt exchange rate to the database.
	*
	* @param btExchangeRateId the primary key for the new bt exchange rate
	* @return the new bt exchange rate
	*/
	@Override
	public com.business.trip.model.BtExchangeRate createBtExchangeRate(
		long btExchangeRateId) {
		return _btExchangeRateLocalService.createBtExchangeRate(btExchangeRateId);
	}

	/**
	* Deletes the bt exchange rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate that was removed
	* @throws PortalException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeRate deleteBtExchangeRate(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.deleteBtExchangeRate(btExchangeRateId);
	}

	/**
	* Deletes the bt exchange rate from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRate the bt exchange rate
	* @return the bt exchange rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeRate deleteBtExchangeRate(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.deleteBtExchangeRate(btExchangeRate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btExchangeRateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtExchangeRate fetchBtExchangeRate(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.fetchBtExchangeRate(btExchangeRateId);
	}

	/**
	* Returns the bt exchange rate with the primary key.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate
	* @throws PortalException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeRate getBtExchangeRate(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.getBtExchangeRate(btExchangeRateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt exchange rates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt exchange rates
	* @param end the upper bound of the range of bt exchange rates (not inclusive)
	* @return the range of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtExchangeRate> getBtExchangeRates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.getBtExchangeRates(start, end);
	}

	/**
	* Returns the number of bt exchange rates.
	*
	* @return the number of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtExchangeRatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.getBtExchangeRatesCount();
	}

	/**
	* Updates the bt exchange rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRate the bt exchange rate
	* @return the bt exchange rate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeRate updateBtExchangeRate(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.updateBtExchangeRate(btExchangeRate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btExchangeRateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btExchangeRateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btExchangeRateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.business.trip.model.BtExchangeRate fetchByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.fetchByF_S_S(firstCurrency,
			secondCurrency, status);
	}

	@Override
	public com.business.trip.model.BtExchangeRate fetchByS(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.fetchByS(status);
	}

	/**
	* change the EUR to RMB
	*
	* @param amountEUR
	* @return
	* @throws SystemException
	*/
	@Override
	public double changeEURToRMB(double amountEUR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeRateLocalService.changeEURToRMB(amountEUR);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtExchangeRateLocalService getWrappedBtExchangeRateLocalService() {
		return _btExchangeRateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtExchangeRateLocalService(
		BtExchangeRateLocalService btExchangeRateLocalService) {
		_btExchangeRateLocalService = btExchangeRateLocalService;
	}

	@Override
	public BtExchangeRateLocalService getWrappedService() {
		return _btExchangeRateLocalService;
	}

	@Override
	public void setWrappedService(
		BtExchangeRateLocalService btExchangeRateLocalService) {
		_btExchangeRateLocalService = btExchangeRateLocalService;
	}

	private BtExchangeRateLocalService _btExchangeRateLocalService;
}