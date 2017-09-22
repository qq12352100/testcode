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
 * Provides the local service utility for CompanyCarManagement. This utility wraps
 * {@link com.company.car.service.impl.CompanyCarManagementLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagementLocalService
 * @see com.company.car.service.base.CompanyCarManagementLocalServiceBaseImpl
 * @see com.company.car.service.impl.CompanyCarManagementLocalServiceImpl
 * @generated
 */
public class CompanyCarManagementLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.company.car.service.impl.CompanyCarManagementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the company car management to the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagement the company car management
	* @return the company car management that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.CompanyCarManagement addCompanyCarManagement(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCompanyCarManagement(companyCarManagement);
	}

	/**
	* Creates a new company car management with the primary key. Does not add the company car management to the database.
	*
	* @param companyCarManagementId the primary key for the new company car management
	* @return the new company car management
	*/
	public static com.company.car.model.CompanyCarManagement createCompanyCarManagement(
		long companyCarManagementId) {
		return getService().createCompanyCarManagement(companyCarManagementId);
	}

	/**
	* Deletes the company car management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management that was removed
	* @throws PortalException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.CompanyCarManagement deleteCompanyCarManagement(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCompanyCarManagement(companyCarManagementId);
	}

	/**
	* Deletes the company car management from the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagement the company car management
	* @return the company car management that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.CompanyCarManagement deleteCompanyCarManagement(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCompanyCarManagement(companyCarManagement);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.company.car.model.CompanyCarManagement fetchCompanyCarManagement(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCompanyCarManagement(companyCarManagementId);
	}

	/**
	* Returns the company car management with the primary key.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management
	* @throws PortalException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.CompanyCarManagement getCompanyCarManagement(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyCarManagement(companyCarManagementId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the company car managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company car managements
	* @param end the upper bound of the range of company car managements (not inclusive)
	* @return the range of company car managements
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.company.car.model.CompanyCarManagement> getCompanyCarManagements(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyCarManagements(start, end);
	}

	/**
	* Returns the number of company car managements.
	*
	* @return the number of company car managements
	* @throws SystemException if a system exception occurred
	*/
	public static int getCompanyCarManagementsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCompanyCarManagementsCount();
	}

	/**
	* Updates the company car management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagement the company car management
	* @return the company car management that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.company.car.model.CompanyCarManagement updateCompanyCarManagement(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCompanyCarManagement(companyCarManagement);
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

	/**
	* Import the excel info to the database
	*/
	public static java.util.List<com.company.car.model.CompanyCarManagement> importCompanyCarManagement(
		java.util.List<java.util.Map<java.lang.String, java.lang.String>> list)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().importCompanyCarManagement(list);
	}

	/**
	* Query the CompanyCarManagement
	*/
	public static java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByC_C_C_C(carType, contractType, carBrand, carCategory);
	}

	/**
	* Query the count
	*/
	public static long findCountByC_C_C_C(java.lang.String carType,
		java.lang.String contractType, java.lang.String carBrand,
		java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findCountByC_C_C_C(carType, contractType, carBrand,
			carCategory);
	}

	/**
	* Query the Car Category level according the grade
	*/
	public static java.lang.String findCartegoryByC_G_G(
		java.lang.String carType, java.lang.String gradeType,
		java.lang.String grade)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findCartegoryByC_G_G(carType, gradeType, grade);
	}

	/**
	* Query the CompanyCarManagement
	*/
	public static java.util.List<com.company.car.model.CompanyCarManagement> findByS_F_C_C_C(
		java.lang.String staffCode, int childrenNumber,
		java.lang.String carType, java.lang.String carCategory,
		java.lang.String carBrand)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByS_F_C_C_C(staffCode, childrenNumber, carType,
			carCategory, carBrand);
	}

	/**
	* Query the CompanyCarManagement
	*/
	public static java.util.List<com.company.car.model.CompanyCarManagement> findByS_F_C_C_C(
		java.lang.String staffCode, int childrenNumber,
		java.lang.String carType, java.lang.String carCategory,
		java.lang.String carBrand, int start, int end) {
		return getService()
				   .findByS_F_C_C_C(staffCode, childrenNumber, carType,
			carCategory, carBrand, start, end);
	}

	public static java.util.List<com.company.car.model.CompanyCarManagement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.util.List<com.company.car.model.CompanyCarManagement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(start, end);
	}

	/**
	* Query the CompanyCarManagement for paginition
	*/
	public static java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByC_C_C_C(carType, contractType, carBrand, carCategory,
			start, end);
	}

	public static com.company.car.model.CompanyCarManagement addCompanyCarManagement(
		com.company.car.model.CompanyCarManagement newCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCompanyCarManagement(newCompanyCar, serviceContext);
	}

	public static com.company.car.model.CompanyCarManagement deleteCompanyCar(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCompanyCar(companyCarManagement);
	}

	public static com.company.car.model.CompanyCarManagement deleteCompanyCar(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCompanyCar(companyCarManagementId);
	}

	/**
	* Generate the ticket no for the workflow
	* for example:CC20150300000001
	*/
	public static java.lang.String generateTicketNo(java.lang.String prefix) {
		return getService().generateTicketNo(prefix);
	}

	public static void clearService() {
		_service = null;
	}

	public static CompanyCarManagementLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CompanyCarManagementLocalService.class.getName());

			if (invokableLocalService instanceof CompanyCarManagementLocalService) {
				_service = (CompanyCarManagementLocalService)invokableLocalService;
			}
			else {
				_service = new CompanyCarManagementLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CompanyCarManagementLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CompanyCarManagementLocalService service) {
	}

	private static CompanyCarManagementLocalService _service;
}