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
 * Provides the local service interface for BusinessTripApplication. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripApplicationLocalServiceUtil
 * @see com.business.trip.service.base.BusinessTripApplicationLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BusinessTripApplicationLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BusinessTripApplicationLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BusinessTripApplicationLocalServiceUtil} to access the business trip application local service. Add custom service methods to {@link com.business.trip.service.impl.BusinessTripApplicationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the business trip application to the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplication the business trip application
	* @return the business trip application that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BusinessTripApplication addBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new business trip application with the primary key. Does not add the business trip application to the database.
	*
	* @param businessTripApplicationId the primary key for the new business trip application
	* @return the new business trip application
	*/
	public com.business.trip.model.BusinessTripApplication createBusinessTripApplication(
		long businessTripApplicationId);

	/**
	* Deletes the business trip application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application that was removed
	* @throws PortalException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BusinessTripApplication deleteBusinessTripApplication(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the business trip application from the database. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplication the business trip application
	* @return the business trip application that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BusinessTripApplication deleteBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.business.trip.model.BusinessTripApplication fetchBusinessTripApplication(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the business trip application with the primary key.
	*
	* @param businessTripApplicationId the primary key of the business trip application
	* @return the business trip application
	* @throws PortalException if a business trip application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BusinessTripApplication getBusinessTripApplication(
		long businessTripApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.business.trip.model.BusinessTripApplication> getBusinessTripApplications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of business trip applications.
	*
	* @return the number of business trip applications
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBusinessTripApplicationsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the business trip application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param businessTripApplication the business trip application
	* @return the business trip application that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BusinessTripApplication updateBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
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

	public com.business.trip.model.BusinessTripApplication saveOrUpdateBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* @param businessTripApplication
	* @return isCanReselectTripType
	*/
	public boolean preValidate(
		com.business.trip.model.BusinessTripApplication businessTripApplication);

	public com.business.trip.model.BusinessTripApplication submitBusinessTripApplication(
		com.business.trip.model.BusinessTripApplication businessTripApplication,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void sendEmailtoApprover(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String[] findEmailsOfPendingApprover(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BusinessTripApplication updateStatus(
		long userId, long businessTripApplicationId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.business.trip.model.BusinessTripApplication> findByStatus(
		int status) throws com.liferay.portal.kernel.exception.SystemException;

	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long businessTripApplicationId, long userId,
		java.lang.String operationUser, java.lang.String action,
		java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getOperationNo(
		java.util.List<com.audit.trail.model.AuditTrailLog> list);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getOperationUserByRoleName(long companyId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.Map<java.lang.String, java.lang.Object> searchBusinessTripApplicationByTicketNo(
		java.lang.String TicketNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BusinessTripApplication getBusinessTripApplicationByTicketNo(
		java.lang.String TicketNo)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCssContent();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDDNames(
		com.business.trip.model.BusinessTripApplication businessTripApplication);

	public void updateSAPStatusAsSAPInfo(
		java.util.List<java.util.Map<java.lang.String, java.lang.Object>> params,
		int sapStatus, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.business.trip.model.BusinessTripApplication updateSAPStatus(
		long businessTripApplicationId, int sapStatus,
		com.liferay.portal.service.ServiceContext serviceContext,
		java.lang.String SAPcomments, java.lang.String SAPducumentId,
		java.lang.String sapCertificateNo, java.lang.String sapCompany,
		java.lang.String sapYear)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public long findCountByS_U_SAP(int status, java.lang.String ticketNo,
		java.lang.String printName, int sapStatus, java.lang.String startDate,
		java.lang.String endDate, java.lang.String sapDocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

	public java.util.List<com.business.trip.model.BusinessTripApplication> findByS_U_SAP(
		int status, java.lang.String ticketNo, java.lang.String printName,
		int sapStatus, java.lang.String startDate, java.lang.String endDate,
		java.lang.String sapDocumentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException;

	public java.util.List<com.business.trip.model.BusinessTripApplication> findByT_P_S_P(
		java.lang.String ticketNo, java.lang.String printName,
		java.lang.String staffCode, java.lang.String personalID, long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int findCountByT_P_S_P(java.lang.String ticketNo,
		java.lang.String printName, java.lang.String staffCode,
		java.lang.String personalID, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BusinessTripApplication fetchBusinessTripApplicationByTicketNo(
		java.lang.String ticketNo)
		throws com.liferay.portal.kernel.exception.SystemException;
}