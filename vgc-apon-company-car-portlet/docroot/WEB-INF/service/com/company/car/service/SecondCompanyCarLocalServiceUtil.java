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

package com.company.car.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SecondCompanyCar. This utility wraps
 * {@link com.company.car.service.impl.SecondCompanyCarLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCarLocalService
 * @see com.company.car.service.base.SecondCompanyCarLocalServiceBaseImpl
 * @see com.company.car.service.impl.SecondCompanyCarLocalServiceImpl
 * @generated
 */
public class SecondCompanyCarLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.company.car.service.impl.SecondCompanyCarLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the second company car to the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCar the second company car
	* @return the second company car that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar addSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSecondCompanyCar(secondCompanyCar);
	}

	/**
	* Creates a new second company car with the primary key. Does not add the second company car to the database.
	*
	* @param secondCompanyCarId the primary key for the new second company car
	* @return the new second company car
	*/
	public static com.company.car.model.SecondCompanyCar createSecondCompanyCar(
		long secondCompanyCarId) {
		return getService().createSecondCompanyCar(secondCompanyCarId);
	}

	/**
	* Deletes the second company car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car that was removed
	* @throws PortalException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar deleteSecondCompanyCar(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSecondCompanyCar(secondCompanyCarId);
	}

	/**
	* Deletes the second company car from the database. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCar the second company car
	* @return the second company car that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar deleteSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSecondCompanyCar(secondCompanyCar);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.company.car.model.SecondCompanyCar fetchSecondCompanyCar(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSecondCompanyCar(secondCompanyCarId);
	}

	/**
	* Returns the second company car with the primary key.
	*
	* @param secondCompanyCarId the primary key of the second company car
	* @return the second company car
	* @throws PortalException if a second company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar getSecondCompanyCar(
		long secondCompanyCarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSecondCompanyCar(secondCompanyCarId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the second company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of second company cars
	* @param end the upper bound of the range of second company cars (not inclusive)
	* @return the range of second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.SecondCompanyCar> getSecondCompanyCars(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSecondCompanyCars(start, end);
	}

	/**
	* Returns the number of second company cars.
	*
	* @return the number of second company cars
	* @throws SystemException if a system exception occurred
	*/
	public static int getSecondCompanyCarsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSecondCompanyCarsCount();
	}

	/**
	* Updates the second company car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param secondCompanyCar the second company car
	* @return the second company car that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.SecondCompanyCar updateSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSecondCompanyCar(secondCompanyCar);
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

	public static com.company.car.model.SecondCompanyCar saveOrUpdateSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveOrUpdateSecondCompanyCar(secondCompanyCar,
			serviceContext);
	}

	public static com.company.car.model.SecondCompanyCar submitSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .submitSecondCompanyCar(secondCompanyCar, serviceContext);
	}

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static java.lang.String[] getRoleName(long staffCode) {
		return getService().getRoleName(staffCode);
	}

	public static com.liferay.portal.model.User findSupervisorUser(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSupervisorUser(secondCompanyCar);
	}

	public static com.company.car.model.SecondCompanyCar updateStatus(
		long userId, long secondCompanyCarId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, secondCompanyCarId, status,
			serviceContext);
	}

	public static java.util.List<com.company.car.model.SecondCompanyCar> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long secondCompanyCarId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId, secondCompanyCarId,
			operationUser, action, operationComment);
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

	public static com.company.car.model.SecondCompanyCar updateSecondCompanyCar(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSecondCompanyCar(secondCompanyCar, serviceContext);
	}

	public static java.lang.String findDrivingLicenseInformation(
		com.company.car.model.SecondCompanyCar secondCompanyCar,
		java.util.Locale loc) {
		return getService().findDrivingLicenseInformation(secondCompanyCar, loc);
	}

	public static void clearService() {
		_service = null;
	}

	public static SecondCompanyCarLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SecondCompanyCarLocalService.class.getName());

			if (invokableLocalService instanceof SecondCompanyCarLocalService) {
				_service = (SecondCompanyCarLocalService)invokableLocalService;
			}
			else {
				_service = new SecondCompanyCarLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SecondCompanyCarLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SecondCompanyCarLocalService service) {
	}

	private static SecondCompanyCarLocalService _service;
}