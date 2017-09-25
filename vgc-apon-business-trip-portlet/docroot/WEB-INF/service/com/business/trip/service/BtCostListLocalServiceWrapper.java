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
 * Provides a wrapper for {@link BtCostListLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtCostListLocalService
 * @generated
 */
public class BtCostListLocalServiceWrapper implements BtCostListLocalService,
	ServiceWrapper<BtCostListLocalService> {
	public BtCostListLocalServiceWrapper(
		BtCostListLocalService btCostListLocalService) {
		_btCostListLocalService = btCostListLocalService;
	}

	/**
	* Adds the bt cost list to the database. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtCostList addBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.addBtCostList(btCostList);
	}

	/**
	* Creates a new bt cost list with the primary key. Does not add the bt cost list to the database.
	*
	* @param btCostListId the primary key for the new bt cost list
	* @return the new bt cost list
	*/
	@Override
	public com.business.trip.model.BtCostList createBtCostList(
		long btCostListId) {
		return _btCostListLocalService.createBtCostList(btCostListId);
	}

	/**
	* Deletes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list that was removed
	* @throws PortalException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtCostList deleteBtCostList(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.deleteBtCostList(btCostListId);
	}

	/**
	* Deletes the bt cost list from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtCostList deleteBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.deleteBtCostList(btCostList);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btCostListLocalService.dynamicQuery();
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
		return _btCostListLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btCostListLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btCostListLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _btCostListLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btCostListLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtCostList fetchBtCostList(long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.fetchBtCostList(btCostListId);
	}

	/**
	* Returns the bt cost list with the primary key.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list
	* @throws PortalException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtCostList getBtCostList(long btCostListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.getBtCostList(btCostListId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt cost lists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt cost lists
	* @param end the upper bound of the range of bt cost lists (not inclusive)
	* @return the range of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtCostList> getBtCostLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.getBtCostLists(start, end);
	}

	/**
	* Returns the number of bt cost lists.
	*
	* @return the number of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtCostListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.getBtCostListsCount();
	}

	/**
	* Updates the bt cost list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtCostList updateBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.updateBtCostList(btCostList);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btCostListLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btCostListLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btCostListLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int findCountByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findCountByBusinessTripPkId(businessTripPkId);
	}

	@Override
	public java.util.List<com.business.trip.model.BtCostList> findByBusinessTripPkId(
		long businessTripPkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findByBusinessTripPkId(businessTripPkId,
			start, end);
	}

	@Override
	public java.util.List<com.business.trip.model.BtCostList> findByB_C(
		long businessTripPkId, java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findByB_C(businessTripPkId,
			paymentCurrency);
	}

	@Override
	public java.lang.Double findSumByCurrency(long businessTripPkId,
		java.lang.String paymentCurrency, java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findSumByCurrency(businessTripPkId,
			paymentCurrency, items);
	}

	@Override
	public java.lang.Double findSumEntertainmentByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency,
		java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findSumEntertainmentByCurrency(businessTripPkId,
			paymentCurrency, items);
	}

	@Override
	public java.lang.Double findSumInvoiceAmountByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findSumInvoiceAmountByCurrency(businessTripPkId,
			paymentCurrency);
	}

	@Override
	public java.lang.Double findEURPayByRMBByCurrency(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findEURPayByRMBByCurrency(businessTripPkId);
	}

	@Override
	public java.lang.Double findSumNetAmountRmbByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency,
		java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findSumNetAmountRmbByCurrency(businessTripPkId,
			paymentCurrency, items);
	}

	@Override
	public java.lang.Double findSumTaxByCurrency(long businessTripPkId,
		java.lang.String paymentCurrency, java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.findSumTaxByCurrency(businessTripPkId,
			paymentCurrency, items);
	}

	@Override
	public boolean isEntertainmentCondition(long businessTripPkId, int type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.isEntertainmentCondition(businessTripPkId,
			type);
	}

	@Override
	public double addCalculate(double oldTotal, java.lang.String totalCurrency,
		double amount, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btCostListLocalService.addCalculate(oldTotal, totalCurrency,
			amount, currency);
	}

	/**
	* To corrected the history data  cost list netAmountRMB value
	*
	* @param businessTripReimbursementId
	* @throws SystemException
	*/
	@Override
	public void correctAmountRmbCostListOfHistoryData(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btCostListLocalService.correctAmountRmbCostListOfHistoryData(businessTripReimbursementId);
	}

	/**
	* Delete all cost list by bussiness trip pk id
	*
	* @param businessTripReimbursementId
	* @throws SystemException
	*/
	@Override
	public void deleteCostListByBRPKId(long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btCostListLocalService.deleteCostListByBRPKId(businessTripReimbursementId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtCostListLocalService getWrappedBtCostListLocalService() {
		return _btCostListLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtCostListLocalService(
		BtCostListLocalService btCostListLocalService) {
		_btCostListLocalService = btCostListLocalService;
	}

	@Override
	public BtCostListLocalService getWrappedService() {
		return _btCostListLocalService;
	}

	@Override
	public void setWrappedService(BtCostListLocalService btCostListLocalService) {
		_btCostListLocalService = btCostListLocalService;
	}

	private BtCostListLocalService _btCostListLocalService;
}