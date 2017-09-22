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

package com.e.onboarding.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EOnBoarding. This utility wraps
 * {@link com.e.onboarding.service.impl.EOnBoardingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sanguine
 * @see EOnBoardingLocalService
 * @see com.e.onboarding.service.base.EOnBoardingLocalServiceBaseImpl
 * @see com.e.onboarding.service.impl.EOnBoardingLocalServiceImpl
 * @generated
 */
public class EOnBoardingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.e.onboarding.service.impl.EOnBoardingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the e on boarding to the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoarding the e on boarding
	* @return the e on boarding that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding addEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEOnBoarding(eOnBoarding);
	}

	/**
	* Creates a new e on boarding with the primary key. Does not add the e on boarding to the database.
	*
	* @param eOnBoardingId the primary key for the new e on boarding
	* @return the new e on boarding
	*/
	public static com.e.onboarding.model.EOnBoarding createEOnBoarding(
		long eOnBoardingId) {
		return getService().createEOnBoarding(eOnBoardingId);
	}

	/**
	* Deletes the e on boarding with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding that was removed
	* @throws PortalException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding deleteEOnBoarding(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEOnBoarding(eOnBoardingId);
	}

	/**
	* Deletes the e on boarding from the database. Also notifies the appropriate model listeners.
	*
	* @param eOnBoarding the e on boarding
	* @return the e on boarding that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding deleteEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteEOnBoarding(eOnBoarding);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.e.onboarding.model.EOnBoarding fetchEOnBoarding(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchEOnBoarding(eOnBoardingId);
	}

	/**
	* Returns the e on boarding with the primary key.
	*
	* @param eOnBoardingId the primary key of the e on boarding
	* @return the e on boarding
	* @throws PortalException if a e on boarding with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding getEOnBoarding(
		long eOnBoardingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getEOnBoarding(eOnBoardingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e on boardings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e on boardings
	* @param end the upper bound of the range of e on boardings (not inclusive)
	* @return the range of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.EOnBoarding> getEOnBoardings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEOnBoardings(start, end);
	}

	/**
	* Returns the number of e on boardings.
	*
	* @return the number of e on boardings
	* @throws SystemException if a system exception occurred
	*/
	public static int getEOnBoardingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getEOnBoardingsCount();
	}

	/**
	* Updates the e on boarding in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eOnBoarding the e on boarding
	* @return the e on boarding that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.EOnBoarding updateEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateEOnBoarding(eOnBoarding);
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

	public static com.e.onboarding.model.EOnBoarding addEOnBoarding(
		com.e.onboarding.model.EOnBoarding newEOnBoarding,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addEOnBoarding(newEOnBoarding, serviceContext);
	}

	public static com.e.onboarding.model.EOnBoarding saveAsDraft(
		com.e.onboarding.model.EOnBoarding eOnBoarding,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().saveAsDraft(eOnBoarding, serviceContext);
	}

	public static com.e.onboarding.model.EOnBoarding submitEOnBoarding(
		com.e.onboarding.model.EOnBoarding eOnBoarding,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().submitEOnBoarding(eOnBoarding, serviceContext);
	}

	public static com.e.onboarding.model.EOnBoarding updateStatus(long userId,
		long eOnBoardingId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, eOnBoardingId, status, serviceContext);
	}

	public static java.util.List<com.e.onboarding.model.EOnBoarding> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static java.util.List<com.e.onboarding.model.EOnBoarding> findDraftListByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findDraftListByUserId(userId);
	}

	public static java.util.List<com.e.onboarding.model.EOnBoarding> findViewList(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findViewList(userId);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long eOnBoardingId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment,
		java.lang.String OperationRole)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId, eOnBoardingId,
			operationUser, action, operationComment, OperationRole);
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

	public static boolean isHasRole(long userId, java.lang.String roleName) {
		return getService().isHasRole(userId, roleName);
	}

	/**
	* Generate the ticket no for the workflow for example:EO20150300000001
	*/
	public static java.lang.String generateTicketNo(java.lang.String prefix) {
		return getService().generateTicketNo(prefix);
	}

	public static void clearService() {
		_service = null;
	}

	public static EOnBoardingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					EOnBoardingLocalService.class.getName());

			if (invokableLocalService instanceof EOnBoardingLocalService) {
				_service = (EOnBoardingLocalService)invokableLocalService;
			}
			else {
				_service = new EOnBoardingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(EOnBoardingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(EOnBoardingLocalService service) {
	}

	private static EOnBoardingLocalService _service;
}