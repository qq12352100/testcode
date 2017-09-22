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

package com.company.car.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SecondCompanyCarLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCarLocalService
 * @generated
 */
public class SecondCompanyCarLocalServiceWrapper
	implements SecondCompanyCarLocalService,
		ServiceWrapper<SecondCompanyCarLocalService> {
	public SecondCompanyCarLocalServiceWrapper(
		SecondCompanyCarLocalService secondCompanyCarLocalService) {
		_secondCompanyCarLocalService = secondCompanyCarLocalService;
	}

	/**
	* Adds the second company car to the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCar the second company car
	* @return the second company car that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.company.car.model.SecondCompanyCar addSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.addSecondCompanyCar(secondCompanyCar);
	}

	/**
	* Creates a new second company car with the primary key. Does not add the second company car to the database.
	*
	* @param secondCompanyCarId the primary key for the new second company car
	* @return the new second company car
	*/
	@Override
	public com.company.car.model.SecondCompanyCar createSecondCompanyCar(
		long secondCompanyCarId) {
		return _secondCompanyCarLocalService.createSecondCompanyCar(secondCompanyCarId);
	}

	/**
	* Deletes the second company car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car that was removed
	* @throws PortalException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.company.car.model.SecondCompanyCar deleteSecondCompanyCar(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.deleteSecondCompanyCar(secondCompanyCarId);
	}

	/**
	* Deletes the second company car from the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCar the second company car
	* @return the second company car that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.company.car.model.SecondCompanyCar deleteSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.deleteSecondCompanyCar(secondCompanyCar);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _secondCompanyCarLocalService.dynamicQuery();
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
		return _secondCompanyCarLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _secondCompanyCarLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _secondCompanyCarLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _secondCompanyCarLocalService.dynamicQueryCount(dynamicQuery);
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
		return _secondCompanyCarLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.company.car.model.SecondCompanyCar fetchSecondCompanyCar(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.fetchSecondCompanyCar(secondCompanyCarId);
	}

	/**
	* Returns the second company car with the primary key.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car
	* @throws PortalException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.company.car.model.SecondCompanyCar getSecondCompanyCar(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.getSecondCompanyCar(secondCompanyCarId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the second company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of second company cars
	* @param end the upper bound of the range of second company cars (not inclusive)
	* @return the range of second company cars
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.company.car.model.SecondCompanyCar> getSecondCompanyCars(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.getSecondCompanyCars(start, end);
	}

	/**
	* Returns the number of second company cars.
	*
	* @return the number of second company cars
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSecondCompanyCarsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.getSecondCompanyCarsCount();
	}

	/**
	* Updates the second company car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCar the second company car
	* @return the second company car that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.company.car.model.SecondCompanyCar updateSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.updateSecondCompanyCar(secondCompanyCar);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _secondCompanyCarLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_secondCompanyCarLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _secondCompanyCarLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.company.car.model.SecondCompanyCar saveOrUpdateSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.saveOrUpdateSecondCompanyCar(secondCompanyCar,
			serviceContext);
	}

	@Override
	public com.company.car.model.SecondCompanyCar submitSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.submitSecondCompanyCar(secondCompanyCar,
			serviceContext);
	}

	@Override
	public java.lang.String getCssContent() {
		return _secondCompanyCarLocalService.getCssContent();
	}

	@Override
	public java.lang.String[] getRoleName(long staffCode) {
		return _secondCompanyCarLocalService.getRoleName(staffCode);
	}

	@Override
	public com.liferay.portal.model.User findSupervisorUser(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.findSupervisorUser(secondCompanyCar);
	}

	@Override
	public com.company.car.model.SecondCompanyCar updateStatus(long userId,
		long secondCompanyCarId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.updateStatus(userId,
			secondCompanyCarId, status, serviceContext);
	}

	@Override
	public java.util.List<com.company.car.model.SecondCompanyCar> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.findByS_U(status, userId);
	}

	@Override
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long secondCompanyCarId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_secondCompanyCarLocalService.saveOrUpdateAuditTrailLog(companyId,
			groupId, secondCompanyCarId, operationUser, action, operationComment);
	}

	@Override
	public int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return _secondCompanyCarLocalService.getOperationNo(list);
	}

	@Override
	public java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.getOperationUserByRoleName(companyId,
			roleName);
	}

	@Override
	public com.company.car.model.SecondCompanyCar updateSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _secondCompanyCarLocalService.updateSecondCompanyCar(secondCompanyCar,
			serviceContext);
	}

	@Override
	public java.lang.String findDrivingLicenseInformation(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		java.util.Locale loc) {
		return _secondCompanyCarLocalService.findDrivingLicenseInformation(secondCompanyCar,
			loc);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SecondCompanyCarLocalService getWrappedSecondCompanyCarLocalService() {
		return _secondCompanyCarLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSecondCompanyCarLocalService(
		SecondCompanyCarLocalService secondCompanyCarLocalService) {
		_secondCompanyCarLocalService = secondCompanyCarLocalService;
	}

	@Override
	public SecondCompanyCarLocalService getWrappedService() {
		return _secondCompanyCarLocalService;
	}

	@Override
	public void setWrappedService(
		SecondCompanyCarLocalService secondCompanyCarLocalService) {
		_secondCompanyCarLocalService = secondCompanyCarLocalService;
	}

	private SecondCompanyCarLocalService _secondCompanyCarLocalService;
}