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
 * Provides the local service utility for FirstCompanyCar. This utility wraps
 * {@link com.company.car.service.impl.FirstCompanyCarLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FirstCompanyCarLocalService
 * @see com.company.car.service.base.FirstCompanyCarLocalServiceBaseImpl
 * @see com.company.car.service.impl.FirstCompanyCarLocalServiceImpl
 * @generated
 */
public class FirstCompanyCarLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.company.car.service.impl.FirstCompanyCarLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the first company car to the database. Also notifies the appropriate model listeners.
	*
	* @param firstCompanyCar the first company car
	* @return the first company car that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar addFirstCompanyCar(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFirstCompanyCar(firstCompanyCar);
	}

	/**
	* Creates a new first company car with the primary key. Does not add the first company car to the database.
	*
	* @param firstCompanyCarId the primary key for the new first company car
	* @return the new first company car
	*/
	public static com.company.car.model.FirstCompanyCar createFirstCompanyCar(
		long firstCompanyCarId) {
		return getService().createFirstCompanyCar(firstCompanyCarId);
	}

	/**
	* Deletes the first company car with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car that was removed
	* @throws PortalException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar deleteFirstCompanyCar(
		long firstCompanyCarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFirstCompanyCar(firstCompanyCarId);
	}

	/**
	* Deletes the first company car from the database. Also notifies the appropriate model listeners.
	*
	* @param firstCompanyCar the first company car
	* @return the first company car that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar deleteFirstCompanyCar(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFirstCompanyCar(firstCompanyCar);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.company.car.model.FirstCompanyCar fetchFirstCompanyCar(
		long firstCompanyCarId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFirstCompanyCar(firstCompanyCarId);
	}

	/**
	* Returns the first company car with the primary key.
	*
	* @param firstCompanyCarId the primary key of the first company car
	* @return the first company car
	* @throws PortalException if a first company car with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar getFirstCompanyCar(
		long firstCompanyCarId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFirstCompanyCar(firstCompanyCarId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the first company cars.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of first company cars
	* @param end the upper bound of the range of first company cars (not inclusive)
	* @return the range of first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.FirstCompanyCar> getFirstCompanyCars(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFirstCompanyCars(start, end);
	}

	/**
	* Returns the number of first company cars.
	*
	* @return the number of first company cars
	* @throws SystemException if a system exception occurred
	*/
	public static int getFirstCompanyCarsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFirstCompanyCarsCount();
	}

	/**
	* Updates the first company car in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param firstCompanyCar the first company car
	* @return the first company car that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.FirstCompanyCar updateFirstCompanyCar(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFirstCompanyCar(firstCompanyCar);
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

	public static com.company.car.model.FirstCompanyCar saveOrUpdateFirstCompanyCar(
		com.company.car.model.FirstCompanyCar firstCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .saveOrUpdateFirstCompanyCar(firstCompanyCar, serviceContext);
	}

	public static com.company.car.model.FirstCompanyCar submitFirstCompanyCar(
		com.company.car.model.FirstCompanyCar firstCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .submitFirstCompanyCar(firstCompanyCar, serviceContext);
	}

	public static java.lang.String getCssContent() {
		return getService().getCssContent();
	}

	public static java.lang.String[] getRoleName(long staffCode) {
		return getService().getRoleName(staffCode);
	}

	public static com.liferay.portal.model.User findSupervisorUser(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findSupervisorUser(firstCompanyCar);
	}

	public static com.company.car.model.FirstCompanyCar updateStatus(
		long userId, long firstCompanyCarId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, firstCompanyCarId, status,
			serviceContext);
	}

	public static java.util.List<com.company.car.model.FirstCompanyCar> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByS_U(status, userId);
	}

	public static void saveOrUpdateAuditTrailLog(long companyId, long groupId,
		long firstCompanyCarId, java.lang.String operationUser,
		java.lang.String action, java.lang.String operationComment)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.saveOrUpdateAuditTrailLog(companyId, groupId, firstCompanyCarId,
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

	public static com.company.car.model.FirstCompanyCar updateFirstCompanyCar(
		com.company.car.model.FirstCompanyCar firstCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateFirstCompanyCar(firstCompanyCar, serviceContext);
	}

	public static java.lang.String findDrivingLicenseInformation(
		com.company.car.model.FirstCompanyCar firstCompanyCar,
		java.util.Locale loc) {
		return getService().findDrivingLicenseInformation(firstCompanyCar, loc);
	}

	public static void clearService() {
		_service = null;
	}

	public static FirstCompanyCarLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FirstCompanyCarLocalService.class.getName());

			if (invokableLocalService instanceof FirstCompanyCarLocalService) {
				_service = (FirstCompanyCarLocalService)invokableLocalService;
			}
			else {
				_service = new FirstCompanyCarLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FirstCompanyCarLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(FirstCompanyCarLocalService service) {
	}

	private static FirstCompanyCarLocalService _service;
}