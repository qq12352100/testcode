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

package com.e.closing.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EClosing. This utility wraps
 * {@link com.e.closing.service.impl.EClosingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author t.a.jiang
 * @see EClosingLocalService
 * @see com.e.closing.service.base.EClosingLocalServiceBaseImpl
 * @see com.e.closing.service.impl.EClosingLocalServiceImpl
 * @generated
 */
public class EClosingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.e.closing.service.impl.EClosingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e closing to the database. Also notifies the appropriate model listeners.
	*
	* @param eClosing the e closing
	* @return the e closing that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing addEClosing(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEClosing(eClosing);
	}

	/**
	* Creates a new e closing with the primary key. Does not add the e closing to the database.
	*
	* @param eclosingId the primary key for the new e closing
	* @return the new e closing
	*/
	public static com.e.closing.model.EClosing createEClosing(long eclosingId) {
		return getService().createEClosing(eclosingId);
	}

	/**
	* Deletes the e closing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing that was removed
	* @throws PortalException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing deleteEClosing(long eclosingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEClosing(eclosingId);
	}

	/**
	* Deletes the e closing from the database. Also notifies the appropriate model listeners.
	*
	* @param eClosing the e closing
	* @return the e closing that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing deleteEClosing(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEClosing(eClosing);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.e.closing.model.EClosing fetchEClosing(long eclosingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEClosing(eclosingId);
	}

	/**
	* Returns the e closing with the primary key.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing
	* @throws PortalException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing getEClosing(long eclosingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEClosing(eclosingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e closings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e closings
	* @param end the upper bound of the range of e closings (not inclusive)
	* @return the range of e closings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.closing.model.EClosing> getEClosings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEClosings(start, end);
	}

	/**
	* Returns the number of e closings.
	*
	* @return the number of e closings
	* @throws SystemException if a system exception occurred
	*/
	public static int getEClosingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEClosingsCount();
	}

	/**
	* Updates the e closing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eClosing the e closing
	* @return the e closing that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.closing.model.EClosing updateEClosing(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEClosing(eClosing);
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

	public static java.util.List<com.e.closing.model.EClosing> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static boolean isHasRole(long userId, java.lang.String roleName) {
		return getService().isHasRole(userId, roleName);
	}

	public static java.util.List<com.e.closing.model.EClosing> findViewList(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findViewList(userId);
	}

	public static com.e.closing.model.EClosing updateStatus(long userId,
		long eClosingId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, eClosingId, status, serviceContext);
	}

	public static com.e.closing.model.EClosing saveOrUpdateEClosing(
		java.lang.String action, long userId,
		com.e.closing.model.EClosing eClosing,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveOrUpdateEClosing(action, userId, eClosing,
			serviceContext);
	}

	public static void saveOrUpdateAuditTrailLog(
		java.lang.String workflowRoleName, long companyId, long groupId,
		long eClosingId, long operationUserId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment,
		boolean isDelegation)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(workflowRoleName, companyId, groupId,
			eClosingId, operationUserId, operationUser, action,
			operationComment, isDelegation);
	}

	public static void sendMail(long eClosingId, java.lang.String emailId,
		java.util.List<java.lang.String> toAddressesList,
		java.util.List<java.lang.String> ccAddressesList)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.sendMail(eClosingId, emailId, toAddressesList, ccAddressesList);
	}

	public static java.lang.String getOperationUserName(long userId,
		long companyId, java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOperationUserName(userId, companyId, roleName);
	}

	public static java.util.List<java.lang.String> getEmailAddress(
		long userId, long companyId, java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEmailAddress(userId, companyId, roleName);
	}

	public static java.lang.String getTicketNo(java.lang.String prefix) {
		return getService().getTicketNo(prefix);
	}

	public static java.lang.String replaceAll(java.lang.String content,
		java.util.Map<java.lang.String, java.lang.String> allParametersMap) {
		return getService().replaceAll(content, allParametersMap);
	}

	public static java.lang.String getCssContent(java.lang.String emailId) {
		return getService().getCssContent(emailId);
	}

	public static java.lang.String getSubject(java.lang.String emailId) {
		return getService().getSubject(emailId);
	}

	public static java.lang.String getMailbody(java.lang.String emailId) {
		return getService().getMailbody(emailId);
	}

	public static java.util.List<java.lang.String> removeDuplicate(
		java.util.List<java.lang.String> addressesList) {
		return getService().removeDuplicate(addressesList);
	}

	public static java.util.List<com.e.closing.model.EClosing> getEclosingByStaffcode(
		java.lang.String staffcode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEclosingByStaffcode(staffcode);
	}

	public static int findEclosingAllByKaleoInstanceId(long pk,
		java.lang.String tabs2)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().findEclosingAllByKaleoInstanceId(pk, tabs2);
	}

	public static void clearService() {
		_service = null;
	}

	public static EClosingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EClosingLocalService.class.getName());

			if (invokableLocalService instanceof EClosingLocalService) {
				_service = (EClosingLocalService)invokableLocalService;
			}
			else {
				_service = new EClosingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EClosingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EClosingLocalService service) {
	}

	private static EClosingLocalService _service;
}