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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EClosingLocalService}.
 *
 * @author t.a.jiang
 * @see EClosingLocalService
 * @generated
 */
public class EClosingLocalServiceWrapper implements EClosingLocalService,
	ServiceWrapper<EClosingLocalService> {
	public EClosingLocalServiceWrapper(
		EClosingLocalService eClosingLocalService) {
		_eClosingLocalService = eClosingLocalService;
	}

	/**
	* Adds the e closing to the database. Also notifies the appropriate model listeners.
	*
	* @param eClosing the e closing
	* @return the e closing that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.closing.model.EClosing addEClosing(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.addEClosing(eClosing);
	}

	/**
	* Creates a new e closing with the primary key. Does not add the e closing to the database.
	*
	* @param eclosingId the primary key for the new e closing
	* @return the new e closing
	*/
	@Override
	public com.e.closing.model.EClosing createEClosing(long eclosingId) {
		return _eClosingLocalService.createEClosing(eclosingId);
	}

	/**
	* Deletes the e closing with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing that was removed
	* @throws PortalException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.closing.model.EClosing deleteEClosing(long eclosingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.deleteEClosing(eclosingId);
	}

	/**
	* Deletes the e closing from the database. Also notifies the appropriate model listeners.
	*
	* @param eClosing the e closing
	* @return the e closing that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.closing.model.EClosing deleteEClosing(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.deleteEClosing(eClosing);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eClosingLocalService.dynamicQuery();
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
		return _eClosingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _eClosingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eClosingLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.e.closing.model.EClosing fetchEClosing(long eclosingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.fetchEClosing(eclosingId);
	}

	/**
	* Returns the e closing with the primary key.
	*
	* @param eclosingId the primary key of the e closing
	* @return the e closing
	* @throws PortalException if a e closing with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.closing.model.EClosing getEClosing(long eclosingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getEClosing(eclosingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.e.closing.model.EClosing> getEClosings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getEClosings(start, end);
	}

	/**
	* Returns the number of e closings.
	*
	* @return the number of e closings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEClosingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getEClosingsCount();
	}

	/**
	* Updates the e closing in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eClosing the e closing
	* @return the e closing that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.closing.model.EClosing updateEClosing(
		com.e.closing.model.EClosing eClosing)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.updateEClosing(eClosing);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eClosingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eClosingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eClosingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.e.closing.model.EClosing> findByS_U(int status,
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.findByS_U(status, userId);
	}

	@Override
	public boolean isHasRole(long userId, java.lang.String roleName) {
		return _eClosingLocalService.isHasRole(userId, roleName);
	}

	@Override
	public java.util.List<com.e.closing.model.EClosing> findViewList(
		long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.findViewList(userId);
	}

	@Override
	public com.e.closing.model.EClosing updateStatus(long userId,
		long eClosingId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.updateStatus(userId, eClosingId, status,
			serviceContext);
	}

	@Override
	public com.e.closing.model.EClosing saveOrUpdateEClosing(
		java.lang.String action, long userId,
		com.e.closing.model.EClosing eClosing,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.saveOrUpdateEClosing(action, userId,
			eClosing, serviceContext);
	}

	@Override
	public void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long eClosingId, long operationUserId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment,
		boolean isDelegation)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_eClosingLocalService.saveOrUpdateAuditTrailLog(companyId, groupId,
			eClosingId, operationUserId, operationUser, action,
			operationComment, isDelegation);
	}

	@Override
	public void sendMail(long eClosingId, java.lang.String emailId,
		java.util.List<java.lang.String> toAddressesList,
		java.util.List<java.lang.String> ccAddressesList)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_eClosingLocalService.sendMail(eClosingId, emailId, toAddressesList,
			ccAddressesList);
	}

	@Override
	public java.lang.String getOperationUserName(long userId, long companyId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getOperationUserName(userId, companyId,
			roleName);
	}

	@Override
	public java.util.List<java.lang.String> getEmailAddress(long userId,
		long companyId, java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getEmailAddress(userId, companyId, roleName);
	}

	@Override
	public java.lang.String getTicketNo(java.lang.String prefix) {
		return _eClosingLocalService.getTicketNo(prefix);
	}

	@Override
	public java.lang.String replaceAll(java.lang.String content,
		java.util.Map<java.lang.String, java.lang.String> allParametersMap) {
		return _eClosingLocalService.replaceAll(content, allParametersMap);
	}

	@Override
	public java.lang.String getCssContent(java.lang.String emailId) {
		return _eClosingLocalService.getCssContent(emailId);
	}

	@Override
	public java.lang.String getSubject(java.lang.String emailId) {
		return _eClosingLocalService.getSubject(emailId);
	}

	@Override
	public java.lang.String getMailbody(java.lang.String emailId) {
		return _eClosingLocalService.getMailbody(emailId);
	}

	@Override
	public java.util.List<java.lang.String> removeDuplicate(
		java.util.List<java.lang.String> addressesList) {
		return _eClosingLocalService.removeDuplicate(addressesList);
	}

	@Override
	public java.util.List<com.e.closing.model.EClosing> getEclosingByStaffcode(
		java.lang.String staffcode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.getEclosingByStaffcode(staffcode);
	}

	@Override
	public int findEclosingAllByKaleoInstanceId(long pk, java.lang.String tabs2)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eClosingLocalService.findEclosingAllByKaleoInstanceId(pk, tabs2);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EClosingLocalService getWrappedEClosingLocalService() {
		return _eClosingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEClosingLocalService(
		EClosingLocalService eClosingLocalService) {
		_eClosingLocalService = eClosingLocalService;
	}

	@Override
	public EClosingLocalService getWrappedService() {
		return _eClosingLocalService;
	}

	@Override
	public void setWrappedService(EClosingLocalService eClosingLocalService) {
		_eClosingLocalService = eClosingLocalService;
	}

	private EClosingLocalService _eClosingLocalService;
}