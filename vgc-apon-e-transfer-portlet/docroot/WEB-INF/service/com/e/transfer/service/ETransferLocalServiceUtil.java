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

package com.e.transfer.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ETransfer. This utility wraps
 * {@link com.e.transfer.service.impl.ETransferLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author EZEYIFE
 * @see ETransferLocalService
 * @see com.e.transfer.service.base.ETransferLocalServiceBaseImpl
 * @see com.e.transfer.service.impl.ETransferLocalServiceImpl
 * @generated
 */
public class ETransferLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.e.transfer.service.impl.ETransferLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e transfer to the database. Also notifies the appropriate model listeners.
	*
	* @param eTransfer the e transfer
	* @return the e transfer that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer addETransfer(
		com.e.transfer.model.ETransfer eTransfer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addETransfer(eTransfer);
	}

	/**
	* Creates a new e transfer with the primary key. Does not add the e transfer to the database.
	*
	* @param eTransferId the primary key for the new e transfer
	* @return the new e transfer
	*/
	public static com.e.transfer.model.ETransfer createETransfer(
		long eTransferId) {
		return getService().createETransfer(eTransferId);
	}

	/**
	* Deletes the e transfer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer that was removed
	* @throws PortalException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer deleteETransfer(
		long eTransferId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteETransfer(eTransferId);
	}

	/**
	* Deletes the e transfer from the database. Also notifies the appropriate model listeners.
	*
	* @param eTransfer the e transfer
	* @return the e transfer that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer deleteETransfer(
		com.e.transfer.model.ETransfer eTransfer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteETransfer(eTransfer);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.e.transfer.model.ETransfer fetchETransfer(
		long eTransferId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchETransfer(eTransferId);
	}

	/**
	* Returns the e transfer with the primary key.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer
	* @throws PortalException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer getETransfer(long eTransferId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getETransfer(eTransferId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e transfers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e transfers
	* @param end the upper bound of the range of e transfers (not inclusive)
	* @return the range of e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> getETransfers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getETransfers(start, end);
	}

	/**
	* Returns the number of e transfers.
	*
	* @return the number of e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static int getETransfersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getETransfersCount();
	}

	/**
	* Updates the e transfer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eTransfer the e transfer
	* @return the e transfer that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer updateETransfer(
		com.e.transfer.model.ETransfer eTransfer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateETransfer(eTransfer);
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

	public static com.e.transfer.model.ETransfer saveOrUpdateETransfer(
		com.e.transfer.model.ETransfer eTransfer,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().saveOrUpdateETransfer(eTransfer, serviceContext);
	}

	public static com.e.transfer.model.ETransfer submitETransfer(
		com.e.transfer.model.ETransfer eTransfer,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().submitETransfer(eTransfer, serviceContext);
	}

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static com.liferay.portal.model.User findSupervisorUser(
		com.e.transfer.model.ETransfer eTransfer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSupervisorUser(eTransfer);
	}

	public static com.e.transfer.model.ETransfer updateStatus(long userId,
		long eTransferId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, eTransferId, status, serviceContext);
	}

	public static java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static com.e.transfer.model.ETransfer updateETransfer(
		com.e.transfer.model.ETransfer eTransfer,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateETransfer(eTransfer, serviceContext);
	}

	public static java.util.List<com.e.transfer.model.ETransfer> findViewList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findViewList(userId);
	}

	public static boolean isHasRole(long userId, java.lang.String roleName) {
		return getService().isHasRole(userId, roleName);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long eTransferId, long operationUserId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId, eTransferId,
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
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOperationUserByRoleName(companyId, roleName);
	}

	public static void clearService() {
		_service = null;
	}

	public static ETransferLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ETransferLocalService.class.getName());

			if (invokableLocalService instanceof ETransferLocalService) {
				_service = (ETransferLocalService)invokableLocalService;
			}
			else {
				_service = new ETransferLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ETransferLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ETransferLocalService service) {
	}

	private static ETransferLocalService _service;
}