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

package com.e.onboarding.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EOnBoardingLocalService}.
 *
 * @author sanguine
 * @see EOnBoardingLocalService
 * @generated
 */
public class EOnBoardingLocalServiceWrapper implements EOnBoardingLocalService,
	ServiceWrapper<EOnBoardingLocalService> {
	public EOnBoardingLocalServiceWrapper(
		EOnBoardingLocalService eOnBoardingLocalService) {
		_eOnBoardingLocalService = eOnBoardingLocalService;
	}

	/**
	* Adds the e on boarding to the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoarding the e on boarding
	* @return the e on boarding that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.onboarding.model.EOnBoarding addEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.addEOnBoarding(eOnBoarding);
	}

	/**
	* Creates a new e on boarding with the primary key. Does not add the e on boarding to the database.
	*
	* @param eOnBoardingId the primary key for the new e on boarding
	* @return the new e on boarding
	*/
	@Override
	public com.e.onboarding.model.EOnBoarding createEOnBoarding(
		long eOnBoardingId) {
		return _eOnBoardingLocalService.createEOnBoarding(eOnBoardingId);
	}

	/**
	* Deletes the e on boarding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding that was removed
	* @throws PortalException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.onboarding.model.EOnBoarding deleteEOnBoarding(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.deleteEOnBoarding(eOnBoardingId);
	}

	/**
	* Deletes the e on boarding from the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoarding the e on boarding
	* @return the e on boarding that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.onboarding.model.EOnBoarding deleteEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.deleteEOnBoarding(eOnBoarding);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eOnBoardingLocalService.dynamicQuery();
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
		return _eOnBoardingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eOnBoardingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _eOnBoardingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _eOnBoardingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eOnBoardingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.e.onboarding.model.EOnBoarding fetchEOnBoarding(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.fetchEOnBoarding(eOnBoardingId);
	}

	/**
	* Returns the e on boarding with the primary key.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding
	* @throws PortalException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.onboarding.model.EOnBoarding getEOnBoarding(long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.getEOnBoarding(eOnBoardingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e on boardings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e on boardings
	* @param end the upper bound of the range of e on boardings (not inclusive)
	* @return the range of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.e.onboarding.model.EOnBoarding> getEOnBoardings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.getEOnBoardings(start, end);
	}

	/**
	* Returns the number of e on boardings.
	*
	* @return the number of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEOnBoardingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.getEOnBoardingsCount();
	}

	/**
	* Updates the e on boarding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eOnBoarding the e on boarding
	* @return the e on boarding that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.onboarding.model.EOnBoarding updateEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.updateEOnBoarding(eOnBoarding);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eOnBoardingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eOnBoardingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eOnBoardingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.e.onboarding.model.EOnBoarding addEOnBoarding(
		com.e.onboarding.model.EOnBoarding newEOnBoarding,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.addEOnBoarding(newEOnBoarding,
			serviceContext);
	}

	@Override
	public com.e.onboarding.model.EOnBoarding saveAsDraft(
		com.e.onboarding.model.EOnBoarding eOnBoarding,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.saveAsDraft(eOnBoarding, serviceContext);
	}

	@Override
	public com.e.onboarding.model.EOnBoarding submitEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.submitEOnBoarding(eOnBoarding,
			serviceContext);
	}

	@Override
	public com.e.onboarding.model.EOnBoarding updateStatus(long userId,
		long eOnBoardingId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.updateStatus(userId, eOnBoardingId,
			status, serviceContext);
	}

	@Override
	public java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.findByS_U(status, userId);
	}

	@Override
	public java.util.List<com.e.onboarding.model.EOnBoarding> findDraftListByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.findDraftListByUserId(userId);
	}

	@Override
	public java.util.List<com.e.onboarding.model.EOnBoarding> findViewList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.findViewList(userId);
	}

	@Override
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long eOnBoardingId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment,
		java.lang.String OperationRole)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_eOnBoardingLocalService.saveOrUpdateAuditTrailLog(companyId, groupId,
			eOnBoardingId, operationUser, action, operationComment,
			OperationRole);
	}

	@Override
	public int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return _eOnBoardingLocalService.getOperationNo(list);
	}

	@Override
	public java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eOnBoardingLocalService.getOperationUserByRoleName(companyId,
			roleName);
	}

	@Override
	public boolean isHasRole(long userId, java.lang.String roleName) {
		return _eOnBoardingLocalService.isHasRole(userId, roleName);
	}

	/**
	* Generate the ticket no for the workflow for example:EO20150300000001
	*/
	@Override
	public java.lang.String generateTicketNo(java.lang.String prefix) {
		return _eOnBoardingLocalService.generateTicketNo(prefix);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EOnBoardingLocalService getWrappedEOnBoardingLocalService() {
		return _eOnBoardingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEOnBoardingLocalService(
		EOnBoardingLocalService eOnBoardingLocalService) {
		_eOnBoardingLocalService = eOnBoardingLocalService;
	}

	@Override
	public EOnBoardingLocalService getWrappedService() {
		return _eOnBoardingLocalService;
	}

	@Override
	public void setWrappedService(
		EOnBoardingLocalService eOnBoardingLocalService) {
		_eOnBoardingLocalService = eOnBoardingLocalService;
	}

	private EOnBoardingLocalService _eOnBoardingLocalService;
}