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

package com.e.leave.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ELeaveInfo. This utility wraps
 * {@link com.e.leave.service.impl.ELeaveInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EZEYIFE
 * @see ELeaveInfoLocalService
 * @see com.e.leave.service.base.ELeaveInfoLocalServiceBaseImpl
 * @see com.e.leave.service.impl.ELeaveInfoLocalServiceImpl
 * @generated
 */
public class ELeaveInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.e.leave.service.impl.ELeaveInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e leave info to the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfo the e leave info
	* @return the e leave info that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo addELeaveInfo(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addELeaveInfo(eLeaveInfo);
	}

	/**
	* Creates a new e leave info with the primary key. Does not add the e leave info to the database.
	*
	* @param eLeaveInfoId the primary key for the new e leave info
	* @return the new e leave info
	*/
	public static com.e.leave.model.ELeaveInfo createELeaveInfo(
		long eLeaveInfoId) {
		return getService().createELeaveInfo(eLeaveInfoId);
	}

	/**
	* Deletes the e leave info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info that was removed
	* @throws PortalException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo deleteELeaveInfo(
		long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteELeaveInfo(eLeaveInfoId);
	}

	/**
	* Deletes the e leave info from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfo the e leave info
	* @return the e leave info that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo deleteELeaveInfo(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteELeaveInfo(eLeaveInfo);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.e.leave.model.ELeaveInfo fetchELeaveInfo(
		long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchELeaveInfo(eLeaveInfoId);
	}

	/**
	* Returns the e leave info with the primary key.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info
	* @throws PortalException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo getELeaveInfo(long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getELeaveInfo(eLeaveInfoId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e leave infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leave infos
	* @param end the upper bound of the range of e leave infos (not inclusive)
	* @return the range of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeaveInfo> getELeaveInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getELeaveInfos(start, end);
	}

	/**
	* Returns the number of e leave infos.
	*
	* @return the number of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	public static int getELeaveInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getELeaveInfosCount();
	}

	/**
	* Updates the e leave info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfo the e leave info
	* @return the e leave info that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeaveInfo updateELeaveInfo(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateELeaveInfo(eLeaveInfo);
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

	public static java.util.List<com.e.leave.model.ELeaveInfo> findLeaveListByELeaveId(
		long eLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findLeaveListByELeaveId(eLeaveId);
	}

	public static boolean saveOrUpdateELeaveInfo(long eLeaveId,
		java.lang.String typeOfLeave, java.util.Date[] startDates,
		java.util.Date[] endDates, java.lang.String[] startTimes,
		java.lang.String[] endTimes, java.lang.String[] leaveDays,
		java.lang.String remark)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveOrUpdateELeaveInfo(eLeaveId, typeOfLeave, startDates,
			endDates, startTimes, endTimes, leaveDays, remark);
	}

	public static boolean isLeaveInfoExist(long eleaveId,
		java.lang.String typeOfLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().isLeaveInfoExist(eleaveId, typeOfLeave);
	}

	public static boolean checkDateList(java.lang.String typeOfLeaveId,
		java.util.Date startDates, java.util.Date endDates,
		java.lang.String startTimes, java.lang.String endTimes,
		java.util.List<com.e.leave.model.ELeaveInfo> eLeaveInfoList) {
		return getService()
				   .checkDateList(typeOfLeaveId, startDates, endDates,
			startTimes, endTimes, eLeaveInfoList);
	}

	public static void clearService() {
		_service = null;
	}

	public static ELeaveInfoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ELeaveInfoLocalService.class.getName());

			if (invokableLocalService instanceof ELeaveInfoLocalService) {
				_service = (ELeaveInfoLocalService)invokableLocalService;
			}
			else {
				_service = new ELeaveInfoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ELeaveInfoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ELeaveInfoLocalService service) {
	}

	private static ELeaveInfoLocalService _service;
}