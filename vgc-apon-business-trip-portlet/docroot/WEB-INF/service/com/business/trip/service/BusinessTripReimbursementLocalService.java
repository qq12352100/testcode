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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for BusinessTripReimbursement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursementLocalServiceUtil
 * @see com.business.trip.service.base.BusinessTripReimbursementLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BusinessTripReimbursementLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BusinessTripReimbursementLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusinessTripReimbursementLocalServiceUtil} to access the business trip reimbursement local service. Add custom service methods to {@link com.business.trip.service.impl.BusinessTripReimbursementLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the business trip reimbursement to the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursement the business trip reimbursement
	* @return the business trip reimbursement that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BusinessTripReimbursement addBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new business trip reimbursement with the primary key. Does not add the business trip reimbursement to the database.
	*
	* @param businessTripReimbursementId the primary key for the new business trip reimbursement
	* @return the new business trip reimbursement
	*/
	public com.business.trip.model.BusinessTripReimbursement createBusinessTripReimbursement(
		long businessTripReimbursementId);

	/**
	* Deletes the business trip reimbursement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement that was removed
	* @throws PortalException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BusinessTripReimbursement deleteBusinessTripReimbursement(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the business trip reimbursement from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursement the business trip reimbursement
	* @return the business trip reimbursement that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BusinessTripReimbursement deleteBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BusinessTripReimbursement fetchBusinessTripReimbursement(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip reimbursement with the primary key.
	*
	* @param businessTripReimbursementId the primary key of the business trip reimbursement
	* @return the business trip reimbursement
	* @throws PortalException if a business trip reimbursement with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BusinessTripReimbursement getBusinessTripReimbursement(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.business.trip.model.BusinessTripReimbursement> getBusinessTripReimbursements(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business trip reimbursements.
	*
	* @return the number of business trip reimbursements
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBusinessTripReimbursementsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the business trip reimbursement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param businessTripReimbursement the business trip reimbursement
	* @return the business trip reimbursement that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BusinessTripReimbursement updateBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.util.List<java.lang.Object[]> reimbursementTravelForReport(
		java.lang.String travelType, java.lang.String ticketNo, int status,
		java.lang.String periodStart, java.lang.String periodEnd);

	public com.business.trip.model.BusinessTripReimbursement saveOrUpdateBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.business.trip.model.BusinessTripReimbursement submitBusinessTripReimbursement(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement,
		com.liferay.portal.service.ServiceContext serviceContext,
		boolean autoNewAterAccountReject)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Get Total Payment Amount
	*
	* @param businessTripReimbursement
	* @return
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.Double[] getTotalPaymentAmount(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void paymentCompletedSendEmailtoApplicant(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BusinessTripReimbursement updateStatus(
		long userId, long businessTripReimbursementId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.business.trip.model.BusinessTripReimbursement> findByBussinessTirpTicketNo(
		java.lang.String bussinessTirpTicketNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long businessTripReimbursementId, long operationUserId,
		java.lang.String operationUser, java.lang.String action,
		java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String[] findEmailsOfPendingApprover(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getRoleTrailLogName(java.lang.String roleName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCurrentOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCssContent();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDDNames(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement);

	public long findCountByS_U_SAP(int status, java.lang.String ticketNo,
		java.lang.String printName, int sapStatus, java.lang.String startDate,
		java.lang.String endDate, java.lang.String sapDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

	/**
	* select reject ticket by account For Reimbursement
	*/
	public long findRejectCountByS_U_SAP(java.lang.String ticketNo,
		java.lang.String printName, int sapStatus, java.lang.String startDate,
		java.lang.String endDate, java.lang.String sapDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

	public java.util.List<com.business.trip.model.BusinessTripReimbursement> findByS_U_SAP(
		int status, java.lang.String ticketNo, java.lang.String printName,
		int sapStatus, java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

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
	public java.util.List<com.business.trip.model.BusinessTripReimbursement> findRejectByS_U_SAP(
		java.lang.String ticketNo, java.lang.String printName, int sapStatus,
		java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

	public void updateSAPStatusAsSAPInfo(
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> params,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BusinessTripReimbursement updateSAPStatus(
		long businessTripReimbursementId, int sapStatus,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String SAPcomments, java.lang.String SAPducumentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}