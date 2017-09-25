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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ELeaveLocalService}.
 *
 * @author EZEYIFE
 * @see ELeaveLocalService
 * @generated
 */
public class ELeaveLocalServiceWrapper implements ELeaveLocalService,
	ServiceWrapper<ELeaveLocalService> {
	public ELeaveLocalServiceWrapper(ELeaveLocalService eLeaveLocalService) {
		_eLeaveLocalService = eLeaveLocalService;
	}

	/**
	* Adds the e leave to the database. Also notifies the appropriate model listeners.
	*
	* @param eLeave the e leave
	* @return the e leave that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeave addELeave(com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.addELeave(eLeave);
	}

	/**
	* Creates a new e leave with the primary key. Does not add the e leave to the database.
	*
	* @param eLeaveId the primary key for the new e leave
	* @return the new e leave
	*/
	@Override
	public com.e.leave.model.ELeave createELeave(long eLeaveId) {
		return _eLeaveLocalService.createELeave(eLeaveId);
	}

	/**
	* Deletes the e leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave that was removed
	* @throws PortalException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeave deleteELeave(long eLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.deleteELeave(eLeaveId);
	}

	/**
	* Deletes the e leave from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeave the e leave
	* @return the e leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeave deleteELeave(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.deleteELeave(eLeave);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eLeaveLocalService.dynamicQuery();
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
		return _eLeaveLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _eLeaveLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eLeaveLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.e.leave.model.ELeave fetchELeave(long eLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.fetchELeave(eLeaveId);
	}

	/**
	* Returns the e leave with the primary key.
	*
	* @param eLeaveId the primary key of the e leave
	* @return the e leave
	* @throws PortalException if a e leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeave getELeave(long eLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getELeave(eLeaveId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.e.leave.model.ELeave> getELeaves(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getELeaves(start, end);
	}

	/**
	* Returns the number of e leaves.
	*
	* @return the number of e leaves
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getELeavesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getELeavesCount();
	}

	/**
	* Updates the e leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eLeave the e leave
	* @return the e leave that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeave updateELeave(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.updateELeave(eLeave);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eLeaveLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eLeaveLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eLeaveLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.e.leave.model.ELeave saveOrUpdateELeave(
		com.e.leave.model.ELeave eLeave,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.saveOrUpdateELeave(eLeave, serviceContext);
	}

	@Override
	public com.e.leave.model.ELeave submitELeave(
		com.e.leave.model.ELeave eLeave,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.submitELeave(eLeave, serviceContext);
	}

	@Override
	public com.liferay.portal.model.User findSupervisorUser(
		com.e.leave.model.ELeave eLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.findSupervisorUser(eLeave);
	}

	@Override
	public java.lang.String getCssContent() {
		return _eLeaveLocalService.getCssContent();
	}

	@Override
	public java.util.List<com.e.leave.model.ELeave> findByS_U(int status,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.findByS_U(status, userId);
	}

	@Override
	public com.e.leave.model.ELeave updateELeave(
		com.e.leave.model.ELeave eLeave,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.updateELeave(eLeave, serviceContext);
	}

	@Override
	public boolean isHasRole(long userId, java.lang.String roleName) {
		return _eLeaveLocalService.isHasRole(userId, roleName);
	}

	@Override
	public boolean isHasPartRoleName(long userId, java.lang.String partRoleName) {
		return _eLeaveLocalService.isHasPartRoleName(userId, partRoleName);
	}

	@Override
	public com.e.leave.model.ELeave updateStatus(long userId, long eLeaveId,
		int status, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.updateStatus(userId, eLeaveId, status,
			serviceContext);
	}

	@Override
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long eLeaveId, long operationUserId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_eLeaveLocalService.saveOrUpdateAuditTrailLog(companyId, groupId,
			eLeaveId, operationUserId, operationUser, action, operationComment);
	}

	@Override
	public java.lang.String getRoleTrailLogName(java.lang.String roleName) {
		return _eLeaveLocalService.getRoleTrailLogName(roleName);
	}

	@Override
	public int getCurrentOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return _eLeaveLocalService.getCurrentOperationNo(list);
	}

	@Override
	public int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return _eLeaveLocalService.getOperationNo(list);
	}

	@Override
	public java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName, java.lang.String divisionName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getOperationUserByRoleName(companyId,
			roleName, divisionName);
	}

	@Override
	public java.lang.String getOperationUserByRoleNameAsDiv(long companyId,
		java.lang.String roleName, java.lang.String divisionName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getOperationUserByRoleNameAsDiv(companyId,
			roleName, divisionName);
	}

	@Override
	public double getSubmittedOrApprovedAbsenceDays(
		java.lang.String staffCode, java.lang.String typeOfLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.getSubmittedOrApprovedAbsenceDays(staffCode,
			typeOfLeaveId);
	}

	@Override
	public double getCompletedOfCurrentDayAbsenceDays(
		java.lang.String staffCode, java.lang.String typeOfLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return _eLeaveLocalService.getCompletedOfCurrentDayAbsenceDays(staffCode,
			typeOfLeaveId);
	}

	@Override
	public java.util.List<com.e.leave.model.ELeave> findViewList(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveLocalService.findViewList(userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ELeaveLocalService getWrappedELeaveLocalService() {
		return _eLeaveLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedELeaveLocalService(
		ELeaveLocalService eLeaveLocalService) {
		_eLeaveLocalService = eLeaveLocalService;
	}

	@Override
	public ELeaveLocalService getWrappedService() {
		return _eLeaveLocalService;
	}

	@Override
	public void setWrappedService(ELeaveLocalService eLeaveLocalService) {
		_eLeaveLocalService = eLeaveLocalService;
	}

	private ELeaveLocalService _eLeaveLocalService;
}