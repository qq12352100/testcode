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
 * Provides a wrapper for {@link BtExchangeSAPRateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRateLocalService
 * @generated
 */
public class BtExchangeSAPRateLocalServiceWrapper
	implements BtExchangeSAPRateLocalService,
		ServiceWrapper<BtExchangeSAPRateLocalService> {
	public BtExchangeSAPRateLocalServiceWrapper(
		BtExchangeSAPRateLocalService btExchangeSAPRateLocalService) {
		_btExchangeSAPRateLocalService = btExchangeSAPRateLocalService;
	}

	/**
	* Adds the bt exchange s a p rate to the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	* @return the bt exchange s a p rate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeSAPRate addBtExchangeSAPRate(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.addBtExchangeSAPRate(btExchangeSAPRate);
	}

	/**
	* Creates a new bt exchange s a p rate with the primary key. Does not add the bt exchange s a p rate to the database.
	*
	* @param btExchangeSAPRateId the primary key for the new bt exchange s a p rate
	* @return the new bt exchange s a p rate
	*/
	@Override
	public com.business.trip.model.BtExchangeSAPRate createBtExchangeSAPRate(
		long btExchangeSAPRateId) {
		return _btExchangeSAPRateLocalService.createBtExchangeSAPRate(btExchangeSAPRateId);
	}

	/**
	* Deletes the bt exchange s a p rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate that was removed
	* @throws PortalException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeSAPRate deleteBtExchangeSAPRate(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.deleteBtExchangeSAPRate(btExchangeSAPRateId);
	}

	/**
	* Deletes the bt exchange s a p rate from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	* @return the bt exchange s a p rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeSAPRate deleteBtExchangeSAPRate(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.deleteBtExchangeSAPRate(btExchangeSAPRate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btExchangeSAPRateLocalService.dynamicQuery();
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
		return _btExchangeSAPRateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btExchangeSAPRateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btExchangeSAPRateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _btExchangeSAPRateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btExchangeSAPRateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtExchangeSAPRate fetchBtExchangeSAPRate(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.fetchBtExchangeSAPRate(btExchangeSAPRateId);
	}

	/**
	* Returns the bt exchange s a p rate with the primary key.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate
	* @throws PortalException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeSAPRate getBtExchangeSAPRate(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.getBtExchangeSAPRate(btExchangeSAPRateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.business.trip.model.BtExchangeSAPRate> getBtExchangeSAPRates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.getBtExchangeSAPRates(start, end);
	}

	/**
	* Returns the number of bt exchange s a p rates.
	*
	* @return the number of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtExchangeSAPRatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.getBtExchangeSAPRatesCount();
	}

	/**
	* Updates the bt exchange s a p rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	* @return the bt exchange s a p rate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtExchangeSAPRate updateBtExchangeSAPRate(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btExchangeSAPRateLocalService.updateBtExchangeSAPRate(btExchangeSAPRate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btExchangeSAPRateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btExchangeSAPRateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btExchangeSAPRateLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtExchangeSAPRateLocalService getWrappedBtExchangeSAPRateLocalService() {
		return _btExchangeSAPRateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtExchangeSAPRateLocalService(
		BtExchangeSAPRateLocalService btExchangeSAPRateLocalService) {
		_btExchangeSAPRateLocalService = btExchangeSAPRateLocalService;
	}

	@Override
	public BtExchangeSAPRateLocalService getWrappedService() {
		return _btExchangeSAPRateLocalService;
	}

	@Override
	public void setWrappedService(
		BtExchangeSAPRateLocalService btExchangeSAPRateLocalService) {
		_btExchangeSAPRateLocalService = btExchangeSAPRateLocalService;
	}

	private BtExchangeSAPRateLocalService _btExchangeSAPRateLocalService;
}