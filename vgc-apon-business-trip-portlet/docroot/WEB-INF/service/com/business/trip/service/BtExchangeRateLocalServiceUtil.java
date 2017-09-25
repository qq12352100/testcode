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
 * Provides the local service utility for BtExchangeRate. This utility wraps
 * {@link com.business.trip.service.impl.BtExchangeRateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRateLocalService
 * @see com.business.trip.service.base.BtExchangeRateLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtExchangeRateLocalServiceImpl
 * @generated
 */
public class BtExchangeRateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BtExchangeRateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bt exchange rate to the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRate the bt exchange rate
	* @return the bt exchange rate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate addBtExchangeRate(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBtExchangeRate(btExchangeRate);
	}

	/**
	* Creates a new bt exchange rate with the primary key. Does not add the bt exchange rate to the database.
	*
	* @param btExchangeRateId the primary key for the new bt exchange rate
	* @return the new bt exchange rate
	*/
	public static com.business.trip.model.BtExchangeRate createBtExchangeRate(
		long btExchangeRateId) {
		return getService().createBtExchangeRate(btExchangeRateId);
	}

	/**
	* Deletes the bt exchange rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate that was removed
	* @throws PortalException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate deleteBtExchangeRate(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtExchangeRate(btExchangeRateId);
	}

	/**
	* Deletes the bt exchange rate from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRate the bt exchange rate
	* @return the bt exchange rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate deleteBtExchangeRate(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtExchangeRate(btExchangeRate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BtExchangeRate fetchBtExchangeRate(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBtExchangeRate(btExchangeRateId);
	}

	/**
	* Returns the bt exchange rate with the primary key.
	*
	* @param btExchangeRateId the primary key of the bt exchange rate
	* @return the bt exchange rate
	* @throws PortalException if a bt exchange rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate getBtExchangeRate(
		long btExchangeRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtExchangeRate(btExchangeRateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.business.trip.model.BtExchangeRate> getBtExchangeRates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtExchangeRates(start, end);
	}

	/**
	* Returns the number of bt exchange rates.
	*
	* @return the number of bt exchange rates
	* @throws SystemException if a system exception occurred
	*/
	public static int getBtExchangeRatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtExchangeRatesCount();
	}

	/**
	* Updates the bt exchange rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btExchangeRate the bt exchange rate
	* @return the bt exchange rate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeRate updateBtExchangeRate(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBtExchangeRate(btExchangeRate);
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

	public static com.business.trip.model.BtExchangeRate fetchByF_S_S(
		java.lang.String firstCurrency, java.lang.String secondCurrency,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByF_S_S(firstCurrency, secondCurrency, status);
	}

	public static com.business.trip.model.BtExchangeRate fetchByS(int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByS(status);
	}

	/**
	* change the EUR to RMB
	*
	* @param amountEUR
	* @return
	* @throws SystemException
	*/
	public static double changeEURToRMB(double amountEUR)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().changeEURToRMB(amountEUR);
	}

	public static void clearService() {
		_service = null;
	}

	public static BtExchangeRateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BtExchangeRateLocalService.class.getName());

			if (invokableLocalService instanceof BtExchangeRateLocalService) {
				_service = (BtExchangeRateLocalService)invokableLocalService;
			}
			else {
				_service = new BtExchangeRateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BtExchangeRateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BtExchangeRateLocalService service) {
	}

	private static BtExchangeRateLocalService _service;
}