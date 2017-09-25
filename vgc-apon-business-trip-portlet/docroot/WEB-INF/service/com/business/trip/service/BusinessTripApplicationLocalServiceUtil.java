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
 * Provides the local service utility for BusinessTripApplication. This utility wraps
 * {@link com.business.trip.service.impl.BusinessTripApplicationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripApplicationLocalService
 * @see com.business.trip.service.base.BusinessTripApplicationLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BusinessTripApplicationLocalServiceImpl
 * @generated
 */
public class BusinessTripApplicationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.business.trip.service.impl.BusinessTripApplicationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the business trip application to the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplication the business trip application
	* @return the business trip application that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripApplication addBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addBusinessTripApplication(businessTripApplication);
	}

	/**
	* Creates a new business trip application with the primary key. Does not add the business trip application to the database.
	*
	* @param businessTripApplicationId the primary key for the new business trip application
	* @return the new business trip application
	*/
	public static com.business.trip.model.BusinessTripApplication createBusinessTripApplication(
		long businessTripApplicationId) {
		return getService()
				   .createBusinessTripApplication(businessTripApplicationId);
	}

	/**
	* Deletes the business trip application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application that was removed
	* @throws PortalException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripApplication deleteBusinessTripApplication(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBusinessTripApplication(businessTripApplicationId);
	}

	/**
	* Deletes the business trip application from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplication the business trip application
	* @return the business trip application that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripApplication deleteBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBusinessTripApplication(businessTripApplication);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.business.trip.model.BusinessTripApplication fetchBusinessTripApplication(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchBusinessTripApplication(businessTripApplicationId);
	}

	/**
	* Returns the business trip application with the primary key.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application
	* @throws PortalException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripApplication getBusinessTripApplication(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBusinessTripApplication(businessTripApplicationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the business trip applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of business trip applications
	* @param end the upper bound of the range of business trip applications (not inclusive)
	* @return the range of business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.business.trip.model.BusinessTripApplication> getBusinessTripApplications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBusinessTripApplications(start, end);
	}

	/**
	* Returns the number of business trip applications.
	*
	* @return the number of business trip applications
	* @throws SystemException if a system exception occurred
	*/
	public static int getBusinessTripApplicationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBusinessTripApplicationsCount();
	}

	/**
	* Updates the business trip application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplication the business trip application
	* @return the business trip application that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.business.trip.model.BusinessTripApplication updateBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBusinessTripApplication(businessTripApplication);
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

	public static com.business.trip.model.BusinessTripApplication saveOrUpdateBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveOrUpdateBusinessTripApplication(businessTripApplication,
			serviceContext);
	}

	/**
	* @param businessTripApplication
	* @return isCanReselectTripType
	*/
	public static boolean preValidate(
		com.business.trip.model.BusinessTripApplication businessTripApplication) {
		return getService().preValidate(businessTripApplication);
	}

	public static com.business.trip.model.BusinessTripApplication submitBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .submitBusinessTripApplication(businessTripApplication,
			serviceContext);
	}

	public static void sendEmailtoApprover(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().sendEmailtoApprover(businessTripApplication);
	}

	public static java.lang.String[] findEmailsOfPendingApprover(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findEmailsOfPendingApprover(businessTripApplication);
	}

	public static com.business.trip.model.BusinessTripApplication updateStatus(
		long userId, long businessTripApplicationId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, businessTripApplicationId, status,
			serviceContext);
	}

	public static java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static java.util.List<com.business.trip.model.BusinessTripApplication> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByStatus(status);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long businessTripApplicationId, long userId,
		java.lang.String operationUser, java.lang.String action,
		java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId,
			businessTripApplicationId, userId, operationUser, action,
			operationComment);
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

	public static java.util.Map<java.lang.String, java.lang.Object> searchBusinessTripApplicationByTicketNo(
		java.lang.String TicketNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().searchBusinessTripApplicationByTicketNo(TicketNo);
	}

	public static com.business.trip.model.BusinessTripApplication getBusinessTripApplicationByTicketNo(
		java.lang.String TicketNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBusinessTripApplicationByTicketNo(TicketNo);
	}

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static java.lang.String getDDNames(
		com.business.trip.model.BusinessTripApplication businessTripApplication) {
		return getService().getDDNames(businessTripApplication);
	}

	public static void updateSAPStatusAsSAPInfo(
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> params,
		int sapStatus, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().updateSAPStatusAsSAPInfo(params, sapStatus, serviceContext);
	}

	public static com.business.trip.model.BusinessTripApplication updateSAPStatus(
		long businessTripApplicationId, int sapStatus,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String SAPcomments, java.lang.String SAPducumentId,
		java.lang.String sapCertificateNo, java.lang.String sapCompany,
		java.lang.String sapYear)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSAPStatus(businessTripApplicationId, sapStatus,
			serviceContext, SAPcomments, SAPducumentId, sapCertificateNo,
			sapCompany, sapYear);
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

	public static java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U_SAP(
		int status, java.lang.String ticketNo, java.lang.String printName,
		int sapStatus, java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		return getService()
				   .findByS_U_SAP(status, ticketNo, printName, sapStatus,
			startDate, endDate, sapDocumentId, start, end);
	}

	public static java.util.List<com.business.trip.model.BusinessTripApplication> findByT_P_S_P(
		java.lang.String ticketNo, java.lang.String printName,
		java.lang.String staffCode, java.lang.String personalID, long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByT_P_S_P(ticketNo, printName, staffCode, personalID,
			userId, start, end);
	}

	public static int findCountByT_P_S_P(java.lang.String ticketNo,
		java.lang.String printName, java.lang.String staffCode,
		java.lang.String personalID, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findCountByT_P_S_P(ticketNo, printName, staffCode,
			personalID, userId);
	}

	public static com.business.trip.model.BusinessTripApplication fetchBusinessTripApplicationByTicketNo(
		java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBusinessTripApplicationByTicketNo(ticketNo);
	}

	public static void clearService() {
		_service = null;
	}

	public static BusinessTripApplicationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BusinessTripApplicationLocalService.class.getName());

			if (invokableLocalService instanceof BusinessTripApplicationLocalService) {
				_service = (BusinessTripApplicationLocalService)invokableLocalService;
			}
			else {
				_service = new BusinessTripApplicationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BusinessTripApplicationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BusinessTripApplicationLocalService service) {
	}

	private static BusinessTripApplicationLocalService _service;
}