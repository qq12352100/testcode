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

package com.seatoffice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SeatOfficeLocalService}.
 *
 * @author Alice.zou
 * @see SeatOfficeLocalService
 * @generated
 */
public class SeatOfficeLocalServiceWrapper implements SeatOfficeLocalService,
	ServiceWrapper<SeatOfficeLocalService> {
	public SeatOfficeLocalServiceWrapper(
		SeatOfficeLocalService seatOfficeLocalService) {
		_seatOfficeLocalService = seatOfficeLocalService;
	}

	/**
	* Adds the seat office to the database. Also notifies the appropriate model listeners.
	*
	* @param seatOffice the seat office
	* @return the seat office that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.seatoffice.model.SeatOffice addSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.addSeatOffice(seatOffice);
	}

	/**
	* Creates a new seat office with the primary key. Does not add the seat office to the database.
	*
	* @param seatId the primary key for the new seat office
	* @return the new seat office
	*/
	@Override
	public com.seatoffice.model.SeatOffice createSeatOffice(long seatId) {
		return _seatOfficeLocalService.createSeatOffice(seatId);
	}

	/**
	* Deletes the seat office with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office that was removed
	* @throws PortalException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.seatoffice.model.SeatOffice deleteSeatOffice(long seatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.deleteSeatOffice(seatId);
	}

	/**
	* Deletes the seat office from the database. Also notifies the appropriate model listeners.
	*
	* @param seatOffice the seat office
	* @return the seat office that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.seatoffice.model.SeatOffice deleteSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.deleteSeatOffice(seatOffice);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _seatOfficeLocalService.dynamicQuery();
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
		return _seatOfficeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _seatOfficeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _seatOfficeLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _seatOfficeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _seatOfficeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.seatoffice.model.SeatOffice fetchSeatOffice(long seatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.fetchSeatOffice(seatId);
	}

	/**
	* Returns the seat office with the primary key.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office
	* @throws PortalException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.seatoffice.model.SeatOffice getSeatOffice(long seatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.getSeatOffice(seatId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the seat offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seat offices
	* @param end the upper bound of the range of seat offices (not inclusive)
	* @return the range of seat offices
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.seatoffice.model.SeatOffice> getSeatOffices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.getSeatOffices(start, end);
	}

	/**
	* Returns the number of seat offices.
	*
	* @return the number of seat offices
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSeatOfficesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.getSeatOfficesCount();
	}

	/**
	* Updates the seat office in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param seatOffice the seat office
	* @return the seat office that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.seatoffice.model.SeatOffice updateSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.updateSeatOffice(seatOffice);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _seatOfficeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_seatOfficeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _seatOfficeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.seatoffice.model.SeatOffice updateStatus(long userId,
		long seatOfficeId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.updateStatus(userId, seatOfficeId,
			status, serviceContext);
	}

	@Override
	public com.seatoffice.model.SeatOffice updateSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.updateSeatOffice(seatOffice,
			serviceContext);
	}

	@Override
	public com.seatoffice.model.SeatOffice saveOrUpdateSeatOffice(
		com.seatoffice.model.SeatOffice SeatOffice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.saveOrUpdateSeatOffice(SeatOffice,
			serviceContext);
	}

	@Override
	public com.seatoffice.model.SeatOffice submitSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.submitSeatOffice(seatOffice,
			serviceContext);
	}

	@Override
	public java.lang.String getCssContent() {
		return _seatOfficeLocalService.getCssContent();
	}

	@Override
	public com.liferay.portal.model.User findSupervisorUser(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.findSupervisorUser(seatOffice);
	}

	@Override
	public java.util.List<com.seatoffice.model.SeatOffice> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.findByS_U(status, userId);
	}

	@Override
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long seatOfficeId, long userId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_seatOfficeLocalService.saveOrUpdateAuditTrailLog(companyId, groupId,
			seatOfficeId, userId, operationUser, action, operationComment);
	}

	@Override
	public java.lang.String getRoleTrailLogName(java.lang.String roleName) {
		return _seatOfficeLocalService.getRoleTrailLogName(roleName);
	}

	@Override
	public int getCurrentOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return _seatOfficeLocalService.getCurrentOperationNo(list);
	}

	@Override
	public int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list) {
		return _seatOfficeLocalService.getOperationNo(list);
	}

	@Override
	public java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _seatOfficeLocalService.getOperationUserByRoleName(companyId,
			roleName);
	}

	@Override
	public java.lang.String generateTicketNo(java.lang.String prefix) {
		return _seatOfficeLocalService.generateTicketNo(prefix);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SeatOfficeLocalService getWrappedSeatOfficeLocalService() {
		return _seatOfficeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSeatOfficeLocalService(
		SeatOfficeLocalService seatOfficeLocalService) {
		_seatOfficeLocalService = seatOfficeLocalService;
	}

	@Override
	public SeatOfficeLocalService getWrappedService() {
		return _seatOfficeLocalService;
	}

	@Override
	public void setWrappedService(SeatOfficeLocalService seatOfficeLocalService) {
		_seatOfficeLocalService = seatOfficeLocalService;
	}

	private SeatOfficeLocalService _seatOfficeLocalService;
}