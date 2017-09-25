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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BtTravelExpense. This utility wraps
 * {@link com.business.trip.service.impl.BtTravelExpenseLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtTravelExpenseLocalService
 * @see com.business.trip.service.base.BtTravelExpenseLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtTravelExpenseLocalServiceImpl
 * @generated
 */
public class BtTravelExpenseLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BtTravelExpenseLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bt travel expense to the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpense the bt travel expense
	* @return the bt travel expense that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense addBtTravelExpense(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBtTravelExpense(btTravelExpense);
	}

	/**
	* Creates a new bt travel expense with the primary key. Does not add the bt travel expense to the database.
	*
	* @param btTravelExpenseId the primary key for the new bt travel expense
	* @return the new bt travel expense
	*/
	public static com.business.trip.model.BtTravelExpense createBtTravelExpense(
		long btTravelExpenseId) {
		return getService().createBtTravelExpense(btTravelExpenseId);
	}

	/**
	* Deletes the bt travel expense with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense that was removed
	* @throws PortalException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense deleteBtTravelExpense(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtTravelExpense(btTravelExpenseId);
	}

	/**
	* Deletes the bt travel expense from the database. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpense the bt travel expense
	* @return the bt travel expense that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense deleteBtTravelExpense(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtTravelExpense(btTravelExpense);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.business.trip.model.BtTravelExpense fetchBtTravelExpense(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBtTravelExpense(btTravelExpenseId);
	}

	/**
	* Returns the bt travel expense with the primary key.
	*
	* @param btTravelExpenseId the primary key of the bt travel expense
	* @return the bt travel expense
	* @throws PortalException if a bt travel expense with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense getBtTravelExpense(
		long btTravelExpenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtTravelExpense(btTravelExpenseId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.business.trip.model.BtTravelExpense> getBtTravelExpenses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtTravelExpenses(start, end);
	}

	/**
	* Returns the number of bt travel expenses.
	*
	* @return the number of bt travel expenses
	* @throws SystemException if a system exception occurred
	*/
	public static int getBtTravelExpensesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtTravelExpensesCount();
	}

	/**
	* Updates the bt travel expense in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btTravelExpense the bt travel expense
	* @return the bt travel expense that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtTravelExpense updateBtTravelExpense(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBtTravelExpense(btTravelExpense);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static int findCountByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findCountByB_T(businessTripPkId, tripType);
	}

	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByB_T(businessTripPkId, tripType, start, end);
	}

	public static java.util.List<com.business.trip.model.BtTravelExpense> findByB_C(
		long businessTripPkId, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByB_C(businessTripPkId, currency);
	}

	public static java.util.List<com.business.trip.model.BtTravelExpense> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.lang.Double findSumByCurrency(long businessTripPkId,
		java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSumByCurrency(businessTripPkId, currency);
	}

	public static java.lang.Double findSumInRMBByCurrency(
		long businessTripPkId, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSumInRMBByCurrency(businessTripPkId, currency);
	}

	public static void copyBtTravelExpenseByB_T(long businessTripPkId,
		long targetBusinessTripPkId, java.lang.String tripType,
		java.lang.String targetTripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.copyBtTravelExpenseByB_T(businessTripPkId, targetBusinessTripPkId,
			tripType, targetTripType);
	}

	public static void deleteBtTravelExpenseByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBtTravelExpenseByB_T(businessTripPkId, tripType);
	}

	/**
	* String startDate,String endDate,
	*
	* @throws ParseException
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> getDomesticBusinessTripReimbursementTravelExpenses(
		java.lang.String startDate, java.lang.String endDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .getDomesticBusinessTripReimbursementTravelExpenses(startDate,
			endDate, start, end);
	}

	public static long getDomesticBusinessTripReimbursementTravelExpensesCount(
		java.lang.String startDate, java.lang.String endDate)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .getDomesticBusinessTripReimbursementTravelExpensesCount(startDate,
			endDate);
	}

	public static java.lang.String getTravelExpenseStartOrEndDate(
		long businessTripReimbursementId, int flag)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTravelExpenseStartOrEndDate(businessTripReimbursementId,
			flag);
	}

	public static com.business.trip.model.BtTravelExpense getTravelExpense(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTravelExpense(businessTripReimbursementId);
	}

	public static double getAllowance(java.lang.String today,
		java.util.Date fromTravelDate, java.util.Date toTravelDate,
		java.lang.String departure, java.lang.String arrival, double rateOfDma,
		boolean isHasBreakfast, boolean isHasLunch, boolean isHasDinner)
		throws java.text.ParseException {
		return getService()
				   .getAllowance(today, fromTravelDate, toTravelDate,
			departure, arrival, rateOfDma, isHasBreakfast, isHasLunch,
			isHasDinner);
	}

	/**
	* To corrected the history data  cost list netAmountRMB value
	*
	* @param businessTripReimbursementId
	* @throws SystemException
	*/
	public static void correctAmountRmbDAOfHistoryData(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().correctAmountRmbDAOfHistoryData(businessTripReimbursementId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BtTravelExpenseLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BtTravelExpenseLocalService.class.getName());

			if (invokableLocalService instanceof BtTravelExpenseLocalService) {
				_service = (BtTravelExpenseLocalService)invokableLocalService;
			}
			else {
				_service = new BtTravelExpenseLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BtTravelExpenseLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BtTravelExpenseLocalService service) {
	}

	private static BtTravelExpenseLocalService _service;
}