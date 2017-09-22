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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SeatOffice. This utility wraps
 * {@link com.seatoffice.service.impl.SeatOfficeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alice.zou
 * @see SeatOfficeLocalService
 * @see com.seatoffice.service.base.SeatOfficeLocalServiceBaseImpl
 * @see com.seatoffice.service.impl.SeatOfficeLocalServiceImpl
 * @generated
 */
public class SeatOfficeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.seatoffice.service.impl.SeatOfficeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the seat office to the database. Also notifies the appropriate model listeners.
	*
	* @param seatOffice the seat office
	* @return the seat office that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice addSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSeatOffice(seatOffice);
	}

	/**
	* Creates a new seat office with the primary key. Does not add the seat office to the database.
	*
	* @param seatId the primary key for the new seat office
	* @return the new seat office
	*/
	public static com.seatoffice.model.SeatOffice createSeatOffice(long seatId) {
		return getService().createSeatOffice(seatId);
	}

	/**
	* Deletes the seat office with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office that was removed
	* @throws PortalException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice deleteSeatOffice(long seatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeatOffice(seatId);
	}

	/**
	* Deletes the seat office from the database. Also notifies the appropriate model listeners.
	*
	* @param seatOffice the seat office
	* @return the seat office that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice deleteSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSeatOffice(seatOffice);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.seatoffice.model.SeatOffice fetchSeatOffice(long seatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSeatOffice(seatId);
	}

	/**
	* Returns the seat office with the primary key.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office
	* @throws PortalException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice getSeatOffice(long seatId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeatOffice(seatId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.seatoffice.model.SeatOffice> getSeatOffices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeatOffices(start, end);
	}

	/**
	* Returns the number of seat offices.
	*
	* @return the number of seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static int getSeatOfficesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSeatOfficesCount();
	}

	/**
	* Updates the seat office in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param seatOffice the seat office
	* @return the seat office that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice updateSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSeatOffice(seatOffice);
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

	public static com.seatoffice.model.SeatOffice updateStatus(long userId,
		long seatOfficeId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, seatOfficeId, status, serviceContext);
	}

	public static com.seatoffice.model.SeatOffice updateSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSeatOffice(seatOffice, serviceContext);
	}

	public static com.seatoffice.model.SeatOffice saveOrUpdateSeatOffice(
		com.seatoffice.model.SeatOffice SeatOffice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().saveOrUpdateSeatOffice(SeatOffice, serviceContext);
	}

	public static com.seatoffice.model.SeatOffice submitSeatOffice(
		com.seatoffice.model.SeatOffice seatOffice,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().submitSeatOffice(seatOffice, serviceContext);
	}

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static com.liferay.portal.model.User findSupervisorUser(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSupervisorUser(seatOffice);
	}

	public static java.util.List<com.seatoffice.model.SeatOffice> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long seatOfficeId, long userId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId, seatOfficeId,
			userId, operationUser, action, operationComment);
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
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOperationUserByRoleName(companyId, roleName);
	}

	public static java.lang.String generateTicketNo(java.lang.String prefix) {
		return getService().generateTicketNo(prefix);
	}

	public static void clearService() {
		_service = null;
	}

	public static SeatOfficeLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SeatOfficeLocalService.class.getName());

			if (invokableLocalService instanceof SeatOfficeLocalService) {
				_service = (SeatOfficeLocalService)invokableLocalService;
			}
			else {
				_service = new SeatOfficeLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SeatOfficeLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SeatOfficeLocalService service) {
	}

	private static SeatOfficeLocalService _service;
}