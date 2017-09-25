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
 * Provides the local service utility for ELeave. This utility wraps
 * {@link com.e.leave.service.impl.ELeaveLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EZEYIFE
 * @see ELeaveLocalService
 * @see com.e.leave.service.base.ELeaveLocalServiceBaseImpl
 * @see com.e.leave.service.impl.ELeaveLocalServiceImpl
 * @generated
 */
public class ELeaveLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.e.leave.service.impl.ELeaveLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e leave to the database. Also notifies the appropriate model listeners.
	*
	* @param eLeave the e leave
	* @return the e leave that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave addELeave(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addELeave(eLeave);
	}

	/**
	* Creates a new e leave with the primary key. Does not add the e leave to the database.
	*
	* @param eLeaveId the primary key for the new e leave
	* @return the new e leave
	*/
	public static com.e.leave.model.ELeave createELeave(long eLeaveId) {
		return getService().createELeave(eLeaveId);
	}

	/**
	* Deletes the e leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave that was removed
	* @throws PortalException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave deleteELeave(long eLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteELeave(eLeaveId);
	}

	/**
	* Deletes the e leave from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeave the e leave
	* @return the e leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave deleteELeave(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteELeave(eLeave);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.e.leave.model.ELeave fetchELeave(long eLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchELeave(eLeaveId);
	}

	/**
	* Returns the e leave with the primary key.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave
	* @throws PortalException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave getELeave(long eLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getELeave(eLeaveId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leaves
	* @param end the upper bound of the range of e leaves (not inclusive)
	* @return the range of e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.leave.model.ELeave> getELeaves(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getELeaves(start, end);
	}

	/**
	* Returns the number of e leaves.
	*
	* @return the number of e leaves
	* @throws SystemException if a system exception occurred
	*/
	public static int getELeavesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getELeavesCount();
	}

	/**
	* Updates the e leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eLeave the e leave
	* @return the e leave that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.leave.model.ELeave updateELeave(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateELeave(eLeave);
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

	public static com.e.leave.model.ELeave saveOrUpdateELeave(
		com.e.leave.model.ELeave eLeave,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().saveOrUpdateELeave(eLeave, serviceContext);
	}

	public static com.e.leave.model.ELeave submitELeave(
		com.e.leave.model.ELeave eLeave,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().submitELeave(eLeave, serviceContext);
	}

	public static com.liferay.portal.model.User findSupervisorUser(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSupervisorUser(eLeave);
	}

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static java.util.List<com.e.leave.model.ELeave> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static com.e.leave.model.ELeave updateELeave(
		com.e.leave.model.ELeave eLeave,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateELeave(eLeave, serviceContext);
	}

	public static boolean isHasRole(long userId, java.lang.String roleName) {
		return getService().isHasRole(userId, roleName);
	}

	public static boolean isHasPartRoleName(long userId,
		java.lang.String partRoleName) {
		return getService().isHasPartRoleName(userId, partRoleName);
	}

	public static com.e.leave.model.ELeave updateStatus(long userId,
		long eLeaveId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, eLeaveId, status, serviceContext);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long eLeaveId, long operationUserId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId, eLeaveId,
			operationUserId, operationUser, action, operationComment);
	}

	public static java.lang.String getRoleTrailLogName(
		java.lang.String roleName) {
		return getService().getRoleTrailLogName(roleName);
	}

	public static int getCurrentOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return getService().getCurrentOperationNo(list);
	}

	public static int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return getService().getOperationNo(list);
	}

	public static java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName, java.lang.String divisionName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOperationUserByRoleName(companyId, roleName, divisionName);
	}

	public static java.lang.String getOperationUserByRoleNameAsDiv(
		long companyId, java.lang.String roleName, java.lang.String divisionName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOperationUserByRoleNameAsDiv(companyId, roleName,
			divisionName);
	}

	public static double getSubmittedOrApprovedAbsenceDays(
		java.lang.String staffCode, java.lang.String typeOfLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSubmittedOrApprovedAbsenceDays(staffCode, typeOfLeaveId);
	}

	public static double getCompletedOfCurrentDayAbsenceDays(
		java.lang.String staffCode, java.lang.String typeOfLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .getCompletedOfCurrentDayAbsenceDays(staffCode, typeOfLeaveId);
	}

	public static java.util.List<com.e.leave.model.ELeave> findViewList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findViewList(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ELeaveLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ELeaveLocalService.class.getName());

			if (invokableLocalService instanceof ELeaveLocalService) {
				_service = (ELeaveLocalService)invokableLocalService;
			}
			else {
				_service = new ELeaveLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ELeaveLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ELeaveLocalService service) {
	}

	private static ELeaveLocalService _service;
}