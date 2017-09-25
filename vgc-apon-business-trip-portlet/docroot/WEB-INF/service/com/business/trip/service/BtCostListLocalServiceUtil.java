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
 * Provides the local service utility for BtCostList. This utility wraps
 * {@link com.business.trip.service.impl.BtCostListLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtCostListLocalService
 * @see com.business.trip.service.base.BtCostListLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtCostListLocalServiceImpl
 * @generated
 */
public class BtCostListLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BtCostListLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bt cost list to the database. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCostList addBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBtCostList(btCostList);
	}

	/**
	* Creates a new bt cost list with the primary key. Does not add the bt cost list to the database.
	*
	* @param btCostListId the primary key for the new bt cost list
	* @return the new bt cost list
	*/
	public static com.business.trip.model.BtCostList createBtCostList(
		long btCostListId) {
		return getService().createBtCostList(btCostListId);
	}

	/**
	* Deletes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list that was removed
	* @throws PortalException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCostList deleteBtCostList(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtCostList(btCostListId);
	}

	/**
	* Deletes the bt cost list from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCostList deleteBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtCostList(btCostList);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BtCostList fetchBtCostList(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBtCostList(btCostListId);
	}

	/**
	* Returns the bt cost list with the primary key.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list
	* @throws PortalException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCostList getBtCostList(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtCostList(btCostListId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.business.trip.model.BtCostList> getBtCostLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtCostLists(start, end);
	}

	/**
	* Returns the number of bt cost lists.
	*
	* @return the number of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	public static int getBtCostListsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtCostListsCount();
	}

	/**
	* Updates the bt cost list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtCostList updateBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBtCostList(btCostList);
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

	public static int findCountByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findCountByBusinessTripPkId(businessTripPkId);
	}

	public static java.util.List<com.business.trip.model.BtCostList> findByBusinessTripPkId(
		long businessTripPkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBusinessTripPkId(businessTripPkId, start, end);
	}

	public static java.util.List<com.business.trip.model.BtCostList> findByB_C(
		long businessTripPkId, java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByB_C(businessTripPkId, paymentCurrency);
	}

	public static java.lang.Double findSumByCurrency(long businessTripPkId,
		java.lang.String paymentCurrency, java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSumByCurrency(businessTripPkId, paymentCurrency, items);
	}

	public static java.lang.Double findSumEntertainmentByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency,
		java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSumEntertainmentByCurrency(businessTripPkId,
			paymentCurrency, items);
	}

	public static java.lang.Double findSumNetAmountRmbByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency,
		java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSumNetAmountRmbByCurrency(businessTripPkId,
			paymentCurrency, items);
	}

	public static java.lang.Double findSumTaxByCurrency(long businessTripPkId,
		java.lang.String paymentCurrency, java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findSumTaxByCurrency(businessTripPkId, paymentCurrency,
			items);
	}

	public static boolean isEntertainmentCondition(long businessTripPkId,
		int type) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isEntertainmentCondition(businessTripPkId, type);
	}

	public static double addCalculate(double oldTotal,
		java.lang.String totalCurrency, double amount, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCalculate(oldTotal, totalCurrency, amount, currency);
	}

	public static void clearService() {
		_service = null;
	}

	public static BtCostListLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BtCostListLocalService.class.getName());

			if (invokableLocalService instanceof BtCostListLocalService) {
				_service = (BtCostListLocalService)invokableLocalService;
			}
			else {
				_service = new BtCostListLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BtCostListLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BtCostListLocalService service) {
	}

	private static BtCostListLocalService _service;
}