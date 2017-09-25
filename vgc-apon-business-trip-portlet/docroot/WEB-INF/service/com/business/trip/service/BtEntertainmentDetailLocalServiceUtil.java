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
 * Provides the local service utility for BtEntertainmentDetail. This utility wraps
 * {@link com.business.trip.service.impl.BtEntertainmentDetailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetailLocalService
 * @see com.business.trip.service.base.BtEntertainmentDetailLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtEntertainmentDetailLocalServiceImpl
 * @generated
 */
public class BtEntertainmentDetailLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BtEntertainmentDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bt entertainment detail to the database. Also notifies the appropriate model listeners.
	*
	* @param btEntertainmentDetail the bt entertainment detail
	* @return the bt entertainment detail that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail addBtEntertainmentDetail(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBtEntertainmentDetail(btEntertainmentDetail);
	}

	/**
	* Creates a new bt entertainment detail with the primary key. Does not add the bt entertainment detail to the database.
	*
	* @param btEntertainmentDetailId the primary key for the new bt entertainment detail
	* @return the new bt entertainment detail
	*/
	public static com.business.trip.model.BtEntertainmentDetail createBtEntertainmentDetail(
		long btEntertainmentDetailId) {
		return getService().createBtEntertainmentDetail(btEntertainmentDetailId);
	}

	/**
	* Deletes the bt entertainment detail with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail that was removed
	* @throws PortalException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail deleteBtEntertainmentDetail(
		long btEntertainmentDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtEntertainmentDetail(btEntertainmentDetailId);
	}

	/**
	* Deletes the bt entertainment detail from the database. Also notifies the appropriate model listeners.
	*
	* @param btEntertainmentDetail the bt entertainment detail
	* @return the bt entertainment detail that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail deleteBtEntertainmentDetail(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtEntertainmentDetail(btEntertainmentDetail);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BtEntertainmentDetail fetchBtEntertainmentDetail(
		long btEntertainmentDetailId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBtEntertainmentDetail(btEntertainmentDetailId);
	}

	/**
	* Returns the bt entertainment detail with the primary key.
	*
	* @param btEntertainmentDetailId the primary key of the bt entertainment detail
	* @return the bt entertainment detail
	* @throws PortalException if a bt entertainment detail with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail getBtEntertainmentDetail(
		long btEntertainmentDetailId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtEntertainmentDetail(btEntertainmentDetailId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt entertainment details.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt entertainment details
	* @param end the upper bound of the range of bt entertainment details (not inclusive)
	* @return the range of bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> getBtEntertainmentDetails(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtEntertainmentDetails(start, end);
	}

	/**
	* Returns the number of bt entertainment details.
	*
	* @return the number of bt entertainment details
	* @throws SystemException if a system exception occurred
	*/
	public static int getBtEntertainmentDetailsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtEntertainmentDetailsCount();
	}

	/**
	* Updates the bt entertainment detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btEntertainmentDetail the bt entertainment detail
	* @return the bt entertainment detail that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtEntertainmentDetail updateBtEntertainmentDetail(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBtEntertainmentDetail(btEntertainmentDetail);
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

	public static java.util.List<com.business.trip.model.BtEntertainmentDetail> findByBtCostListId(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBtCostListId(btCostListId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BtEntertainmentDetailLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BtEntertainmentDetailLocalService.class.getName());

			if (invokableLocalService instanceof BtEntertainmentDetailLocalService) {
				_service = (BtEntertainmentDetailLocalService)invokableLocalService;
			}
			else {
				_service = new BtEntertainmentDetailLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BtEntertainmentDetailLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BtEntertainmentDetailLocalService service) {
	}

	private static BtEntertainmentDetailLocalService _service;
}