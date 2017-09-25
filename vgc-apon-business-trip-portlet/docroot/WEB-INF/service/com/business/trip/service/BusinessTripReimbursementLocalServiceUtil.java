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
 * Provides the local service utility for BusinessTripReimbursement. This utility wraps
 * {@link com.business.trip.service.impl.BusinessTripReimbursementLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursementLocalService
 * @see com.business.trip.service.base.BusinessTripReimbursementLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BusinessTripReimbursementLocalServiceImpl
 * @generated
 */
public class BusinessTripReimbursementLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BusinessTripReimbursementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the business trip reimbursement to the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursement the business trip reimbursement
	* @return the business trip reimbursement that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement addBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBusinessTripReimbursement(businessTripReimbursement);
	}

	/**
	* Creates a new business trip reimbursement with the primary key. Does not add the business trip reimbursement to the database.
	*
	* @param businessTripReimbursementId the primary key for the new business trip reimbursement
	* @return the new business trip reimbursement
	*/
	public static com.business.trip.model.BusinessTripReimbursement createBusinessTripReimbursement(
		long businessTripReimbursementId) {
		return getService()
				   .createBusinessTripReimbursement(businessTripReimbursementId);
	}

	/**
	* Deletes the business trip reimbursement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement that was removed
	* @throws PortalException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement deleteBusinessTripReimbursement(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBusinessTripReimbursement(businessTripReimbursementId);
	}

	/**
	* Deletes the business trip reimbursement from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursement the business trip reimbursement
	* @return the business trip reimbursement that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement deleteBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBusinessTripReimbursement(businessTripReimbursement);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BusinessTripReimbursement fetchBusinessTripReimbursement(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchBusinessTripReimbursement(businessTripReimbursementId);
	}

	/**
	* Returns the business trip reimbursement with the primary key.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement
	* @throws PortalException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement getBusinessTripReimbursement(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getBusinessTripReimbursement(businessTripReimbursementId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the business trip reimbursements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business trip reimbursements
	* @param end the upper bound of the range of business trip reimbursements (not inclusive)
	* @return the range of business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> getBusinessTripReimbursements(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBusinessTripReimbursements(start, end);
	}

	/**
	* Returns the number of business trip reimbursements.
	*
	* @return the number of business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	public static int getBusinessTripReimbursementsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBusinessTripReimbursementsCount();
	}

	/**
	* Updates the business trip reimbursement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursement the business trip reimbursement
	* @return the business trip reimbursement that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripReimbursement updateBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBusinessTripReimbursement(businessTripReimbursement);
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

	public static com.business.trip.model.BusinessTripReimbursement saveOrUpdateBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveOrUpdateBusinessTripReimbursement(businessTripReimbursement,
			serviceContext);
	}

	/**
	* Submit the BusinessTripApplication to start the workflow
	*
	* @param businessTripReimbursement
	* @param serviceContext
	* @param autoNewAterAccountReject    if is true, means account reject,the system will to create a new one.
	* @return
	* @throws PortalException
	* @throws SystemException
	*/
	public static com.business.trip.model.BusinessTripReimbursement submitBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement,
		com.liferay.portal.service.ServiceContext serviceContext,
		boolean autoNewAterAccountReject)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .submitBusinessTripReimbursement(businessTripReimbursement,
			serviceContext, autoNewAterAccountReject);
	}

	public static void paymentCompletedSendEmailtoApplicant(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.paymentCompletedSendEmailtoApplicant(businessTripReimbursement);
	}

	public static com.business.trip.model.BusinessTripReimbursement updateStatus(
		long userId, long businessTripReimbursementId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, businessTripReimbursementId, status,
			serviceContext);
	}

	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByBussinessTirpTicketNo(bussinessTirpTicketNo);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long businessTripReimbursementId, long operationUserId,
		java.lang.String operationUser, java.lang.String action,
		java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId,
			businessTripReimbursementId, operationUserId, operationUser,
			action, operationComment);
	}

	public static java.lang.String[] findEmailsOfPendingApprover(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findEmailsOfPendingApprover(businessTripReimbursement);
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

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static java.lang.String getDDNames(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement) {
		return getService().getDDNames(businessTripReimbursement);
	}

	public static long findCountByS_U_SAP(int status,
		java.lang.String ticketNo, java.lang.String printName, int sapStatus,
		java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .findCountByS_U_SAP(status, ticketNo, printName, sapStatus,
			startDate, endDate, sapDocumentId);
	}

	/**
	* select reject ticket by account For Reimbursement
	*/
	public static long findRejectCountByS_U_SAP(java.lang.String ticketNo,
		java.lang.String printName, int sapStatus, java.lang.String startDate,
		java.lang.String endDate, java.lang.String sapDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .findRejectCountByS_U_SAP(ticketNo, printName, sapStatus,
			startDate, endDate, sapDocumentId);
	}

	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U_SAP(
		int status, java.lang.String ticketNo, java.lang.String printName,
		int sapStatus, java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .findByS_U_SAP(status, ticketNo, printName, sapStatus,
			startDate, endDate, sapDocumentId, start, end);
	}

	/**
	* select reject ticket by account For Reimbursement
	*
	* @param ticketNo
	* @param printName
	* @param sapStatus
	* @param startDate
	* @param endDate
	* @param sapDocumentId
	* @param start
	* @param end
	* @return
	* @throws SystemException
	* @throws ParseException
	*/
	public static java.util.List<com.business.trip.model.BusinessTripReimbursement> findRejectByS_U_SAP(
		java.lang.String ticketNo, java.lang.String printName, int sapStatus,
		java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .findRejectByS_U_SAP(ticketNo, printName, sapStatus,
			startDate, endDate, sapDocumentId, start, end);
	}

	public static void updateSAPStatusAsSAPInfo(
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> params,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateSAPStatusAsSAPInfo(params, serviceContext);
	}

	public static com.business.trip.model.BusinessTripReimbursement updateSAPStatus(
		long businessTripReimbursementId, int sapStatus,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String SAPcomments, java.lang.String SAPducumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSAPStatus(businessTripReimbursementId, sapStatus,
			serviceContext, SAPcomments, SAPducumentId);
	}

	public static void clearService() {
		_service = null;
	}

	public static BusinessTripReimbursementLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BusinessTripReimbursementLocalService.class.getName());

			if (invokableLocalService instanceof BusinessTripReimbursementLocalService) {
				_service = (BusinessTripReimbursementLocalService)invokableLocalService;
			}
			else {
				_service = new BusinessTripReimbursementLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BusinessTripReimbursementLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BusinessTripReimbursementLocalService service) {
	}

	private static BusinessTripReimbursementLocalService _service;
}