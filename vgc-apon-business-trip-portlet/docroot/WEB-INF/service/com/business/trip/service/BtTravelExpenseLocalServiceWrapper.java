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
 * Provides a wrapper for {@link BtTravelExpenseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtTravelExpenseLocalService
 * @generated
 */
public class BtTravelExpenseLocalServiceWrapper
	implements BtTravelExpenseLocalService,
		ServiceWrapper<BtTravelExpenseLocalService> {
	public BtTravelExpenseLocalServiceWrapper(
		BtTravelExpenseLocalService btTravelExpenseLocalService) {
		_btTravelExpenseLocalService = btTravelExpenseLocalService;
	}

	/**
	* Adds the bt travel expense to the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpense the bt travel expense
	* @return the bt travel expense that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTravelExpense addBtTravelExpense(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.addBtTravelExpense(btTravelExpense);
	}

	/**
	* Creates a new bt travel expense with the primary key. Does not add the bt travel expense to the database.
	*
	* @param btTravelExpenseId the primary key for the new bt travel expense
	* @return the new bt travel expense
	*/
	@Override
	public com.business.trip.model.BtTravelExpense createBtTravelExpense(
		long btTravelExpenseId) {
		return _btTravelExpenseLocalService.createBtTravelExpense(btTravelExpenseId);
	}

	/**
	* Deletes the bt travel expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense that was removed
	* @throws PortalException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTravelExpense deleteBtTravelExpense(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.deleteBtTravelExpense(btTravelExpenseId);
	}

	/**
	* Deletes the bt travel expense from the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpense the bt travel expense
	* @return the bt travel expense that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTravelExpense deleteBtTravelExpense(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.deleteBtTravelExpense(btTravelExpense);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btTravelExpenseLocalService.dynamicQuery();
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
		return _btTravelExpenseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btTravelExpenseLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btTravelExpenseLocalService.dynamicQuery(dynamicQuery, start,
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
		return _btTravelExpenseLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btTravelExpenseLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtTravelExpense fetchBtTravelExpense(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.fetchBtTravelExpense(btTravelExpenseId);
	}

	/**
	* Returns the bt travel expense with the primary key.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense
	* @throws PortalException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTravelExpense getBtTravelExpense(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.getBtTravelExpense(btTravelExpenseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt travel expenses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt travel expenses
	* @param end the upper bound of the range of bt travel expenses (not inclusive)
	* @return the range of bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtTravelExpense> getBtTravelExpenses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.getBtTravelExpenses(start, end);
	}

	/**
	* Returns the number of bt travel expenses.
	*
	* @return the number of bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtTravelExpensesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.getBtTravelExpensesCount();
	}

	/**
	* Updates the bt travel expense in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpense the bt travel expense
	* @return the bt travel expense that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTravelExpense updateBtTravelExpense(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.updateBtTravelExpense(btTravelExpense);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btTravelExpenseLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btTravelExpenseLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btTravelExpenseLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int findCountByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.findCountByB_T(businessTripPkId,
			tripType);
	}

	@Override
	public java.util.List<com.business.trip.model.BtTravelExpense> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.findByB_T(businessTripPkId,
			tripType, start, end);
	}

	@Override
	public java.util.List<com.business.trip.model.BtTravelExpense> findByB_C(
		long businessTripPkId, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.findByB_C(businessTripPkId, currency);
	}

	@Override
	public java.util.List<com.business.trip.model.BtTravelExpense> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.findAll();
	}

	@Override
	public java.lang.Double findSumByCurrency(long businessTripPkId,
		java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.findSumByCurrency(businessTripPkId,
			currency);
	}

	@Override
	public java.lang.Double findSumInRMBByCurrency(long businessTripPkId,
		java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.findSumInRMBByCurrency(businessTripPkId,
			currency);
	}

	@Override
	public void copyBtTravelExpenseByB_T(long businessTripPkId,
		long targetBusinessTripPkId, java.lang.String tripType,
		java.lang.String targetTripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btTravelExpenseLocalService.copyBtTravelExpenseByB_T(businessTripPkId,
			targetBusinessTripPkId, tripType, targetTripType);
	}

	@Override
	public void deleteBtTravelExpenseByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btTravelExpenseLocalService.deleteBtTravelExpenseByB_T(businessTripPkId,
			tripType);
	}

	/**
	* String startDate,String endDate,
	*
	* @throws ParseException
	*/
	@Override
	public java.util.List<com.business.trip.model.BusinessTripReimbursement> getDomesticBusinessTripReimbursementTravelExpenses(
		java.lang.String startDate, java.lang.String endDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _btTravelExpenseLocalService.getDomesticBusinessTripReimbursementTravelExpenses(startDate,
			endDate, start, end);
	}

	@Override
	public long getDomesticBusinessTripReimbursementTravelExpensesCount(
		java.lang.String startDate, java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _btTravelExpenseLocalService.getDomesticBusinessTripReimbursementTravelExpensesCount(startDate,
			endDate);
	}

	@Override
	public java.lang.String getTravelExpenseStartOrEndDate(
		long businessTripReimbursementId, int flag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.getTravelExpenseStartOrEndDate(businessTripReimbursementId,
			flag);
	}

	@Override
	public com.business.trip.model.BtTravelExpense getTravelExpense(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTravelExpenseLocalService.getTravelExpense(businessTripReimbursementId);
	}

	@Override
	public double getAllowance(java.lang.String today,
		java.util.Date fromTravelDate, java.util.Date toTravelDate,
		java.lang.String departure, java.lang.String arrival, double rateOfDma,
		boolean isHasBreakfast, boolean isHasLunch, boolean isHasDinner)
		throws java.text.ParseException {
		return _btTravelExpenseLocalService.getAllowance(today, fromTravelDate,
			toTravelDate, departure, arrival, rateOfDma, isHasBreakfast,
			isHasLunch, isHasDinner);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtTravelExpenseLocalService getWrappedBtTravelExpenseLocalService() {
		return _btTravelExpenseLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtTravelExpenseLocalService(
		BtTravelExpenseLocalService btTravelExpenseLocalService) {
		_btTravelExpenseLocalService = btTravelExpenseLocalService;
	}

	@Override
	public BtTravelExpenseLocalService getWrappedService() {
		return _btTravelExpenseLocalService;
	}

	@Override
	public void setWrappedService(
		BtTravelExpenseLocalService btTravelExpenseLocalService) {
		_btTravelExpenseLocalService = btTravelExpenseLocalService;
	}

	private BtTravelExpenseLocalService _btTravelExpenseLocalService;
}