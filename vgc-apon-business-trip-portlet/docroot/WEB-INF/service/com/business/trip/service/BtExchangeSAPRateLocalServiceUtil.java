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
 * Provides the local service utility for BtExchangeSAPRate. This utility wraps
 * {@link com.business.trip.service.impl.BtExchangeSAPRateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRateLocalService
 * @see com.business.trip.service.base.BtExchangeSAPRateLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtExchangeSAPRateLocalServiceImpl
 * @generated
 */
public class BtExchangeSAPRateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BtExchangeSAPRateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bt exchange s a p rate to the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	* @return the bt exchange s a p rate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate addBtExchangeSAPRate(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBtExchangeSAPRate(btExchangeSAPRate);
	}

	/**
	* Creates a new bt exchange s a p rate with the primary key. Does not add the bt exchange s a p rate to the database.
	*
	* @param btExchangeSAPRateId the primary key for the new bt exchange s a p rate
	* @return the new bt exchange s a p rate
	*/
	public static com.business.trip.model.BtExchangeSAPRate createBtExchangeSAPRate(
		long btExchangeSAPRateId) {
		return getService().createBtExchangeSAPRate(btExchangeSAPRateId);
	}

	/**
	* Deletes the bt exchange s a p rate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate that was removed
	* @throws PortalException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate deleteBtExchangeSAPRate(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtExchangeSAPRate(btExchangeSAPRateId);
	}

	/**
	* Deletes the bt exchange s a p rate from the database. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	* @return the bt exchange s a p rate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate deleteBtExchangeSAPRate(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtExchangeSAPRate(btExchangeSAPRate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BtExchangeSAPRate fetchBtExchangeSAPRate(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBtExchangeSAPRate(btExchangeSAPRateId);
	}

	/**
	* Returns the bt exchange s a p rate with the primary key.
	*
	* @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	* @return the bt exchange s a p rate
	* @throws PortalException if a bt exchange s a p rate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate getBtExchangeSAPRate(
		long btExchangeSAPRateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtExchangeSAPRate(btExchangeSAPRateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.business.trip.model.BtExchangeSAPRate> getBtExchangeSAPRates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtExchangeSAPRates(start, end);
	}

	/**
	* Returns the number of bt exchange s a p rates.
	*
	* @return the number of bt exchange s a p rates
	* @throws SystemException if a system exception occurred
	*/
	public static int getBtExchangeSAPRatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtExchangeSAPRatesCount();
	}

	/**
	* Updates the bt exchange s a p rate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btExchangeSAPRate the bt exchange s a p rate
	* @return the bt exchange s a p rate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtExchangeSAPRate updateBtExchangeSAPRate(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBtExchangeSAPRate(btExchangeSAPRate);
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

	public static void clearService() {
		_service = null;
	}

	public static BtExchangeSAPRateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BtExchangeSAPRateLocalService.class.getName());

			if (invokableLocalService instanceof BtExchangeSAPRateLocalService) {
				_service = (BtExchangeSAPRateLocalService)invokableLocalService;
			}
			else {
				_service = new BtExchangeSAPRateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BtExchangeSAPRateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BtExchangeSAPRateLocalService service) {
	}

	private static BtExchangeSAPRateLocalService _service;
}