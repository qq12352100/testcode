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
 * Provides the local service utility for BtFlightTrainInfo. This utility wraps
 * {@link com.business.trip.service.impl.BtFlightTrainInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtFlightTrainInfoLocalService
 * @see com.business.trip.service.base.BtFlightTrainInfoLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtFlightTrainInfoLocalServiceImpl
 * @generated
 */
public class BtFlightTrainInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BtFlightTrainInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bt flight train info to the database. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfo the bt flight train info
	* @return the bt flight train info that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtFlightTrainInfo addBtFlightTrainInfo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBtFlightTrainInfo(btFlightTrainInfo);
	}

	/**
	* Creates a new bt flight train info with the primary key. Does not add the bt flight train info to the database.
	*
	* @param btFlightTrainInfoId the primary key for the new bt flight train info
	* @return the new bt flight train info
	*/
	public static com.business.trip.model.BtFlightTrainInfo createBtFlightTrainInfo(
		long btFlightTrainInfoId) {
		return getService().createBtFlightTrainInfo(btFlightTrainInfoId);
	}

	/**
	* Deletes the bt flight train info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfoId the primary key of the bt flight train info
	* @return the bt flight train info that was removed
	* @throws PortalException if a bt flight train info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtFlightTrainInfo deleteBtFlightTrainInfo(
		long btFlightTrainInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtFlightTrainInfo(btFlightTrainInfoId);
	}

	/**
	* Deletes the bt flight train info from the database. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfo the bt flight train info
	* @return the bt flight train info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtFlightTrainInfo deleteBtFlightTrainInfo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBtFlightTrainInfo(btFlightTrainInfo);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BtFlightTrainInfo fetchBtFlightTrainInfo(
		long btFlightTrainInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBtFlightTrainInfo(btFlightTrainInfoId);
	}

	/**
	* Returns the bt flight train info with the primary key.
	*
	* @param btFlightTrainInfoId the primary key of the bt flight train info
	* @return the bt flight train info
	* @throws PortalException if a bt flight train info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtFlightTrainInfo getBtFlightTrainInfo(
		long btFlightTrainInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtFlightTrainInfo(btFlightTrainInfoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt flight train infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt flight train infos
	* @param end the upper bound of the range of bt flight train infos (not inclusive)
	* @return the range of bt flight train infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BtFlightTrainInfo> getBtFlightTrainInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtFlightTrainInfos(start, end);
	}

	/**
	* Returns the number of bt flight train infos.
	*
	* @return the number of bt flight train infos
	* @throws SystemException if a system exception occurred
	*/
	public static int getBtFlightTrainInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBtFlightTrainInfosCount();
	}

	/**
	* Updates the bt flight train info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfo the bt flight train info
	* @return the bt flight train info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BtFlightTrainInfo updateBtFlightTrainInfo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateBtFlightTrainInfo(btFlightTrainInfo);
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

	public static java.util.List<com.business.trip.model.BtFlightTrainInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByB_T(businessTripPkId, tripType, start, end);
	}

	public static java.util.List<com.business.trip.model.BtFlightTrainInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static void copyBtFlightTrainInfoByB_T(long businessTripPkId,
		long targetBusinessTripPkId, java.lang.String tripType,
		java.lang.String targetTripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.copyBtFlightTrainInfoByB_T(businessTripPkId,
			targetBusinessTripPkId, tripType, targetTripType);
	}

	public static void deleteBtFlightTrainInfoByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteBtFlightTrainInfoByB_T(businessTripPkId, tripType);
	}

	public static boolean isNeedEVPApprove(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isNeedEVPApprove(businessTripPkId, tripType);
	}

	public static void clearService() {
		_service = null;
	}

	public static BtFlightTrainInfoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BtFlightTrainInfoLocalService.class.getName());

			if (invokableLocalService instanceof BtFlightTrainInfoLocalService) {
				_service = (BtFlightTrainInfoLocalService)invokableLocalService;
			}
			else {
				_service = new BtFlightTrainInfoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BtFlightTrainInfoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BtFlightTrainInfoLocalService service) {
	}

	private static BtFlightTrainInfoLocalService _service;
}