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
 * Provides the local service interface for CompanyCarManagement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagementLocalServiceUtil
 * @see com.company.car.service.base.CompanyCarManagementLocalServiceBaseImpl
 * @see com.company.car.service.impl.CompanyCarManagementLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CompanyCarManagementLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompanyCarManagementLocalServiceUtil} to access the company car management local service. Add custom service methods to {@link com.company.car.service.impl.CompanyCarManagementLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the company car management to the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagement the company car management
	* @return the company car management that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.company.car.model.CompanyCarManagement addCompanyCarManagement(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new company car management with the primary key. Does not add the company car management to the database.
	*
	* @param companyCarManagementId the primary key for the new company car management
	* @return the new company car management
	*/
	public com.company.car.model.CompanyCarManagement createCompanyCarManagement(
		long companyCarManagementId);

	/**
	* Deletes the company car management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management that was removed
	* @throws PortalException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.company.car.model.CompanyCarManagement deleteCompanyCarManagement(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the company car management from the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagement the company car management
	* @return the company car management that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.company.car.model.CompanyCarManagement deleteCompanyCarManagement(
		com.company.car.model.CompanyCarManagement companyCarManagement)
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.company.car.model.CompanyCarManagement fetchCompanyCarManagement(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company car management with the primary key.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management
	* @throws PortalException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.company.car.model.CompanyCarManagement getCompanyCarManagement(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.company.car.model.CompanyCarManagement> getCompanyCarManagements(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of company car managements.
	*
	* @return the number of company car managements
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCompanyCarManagementsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the company car management in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagement the company car management
	* @return the company car management that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.company.car.model.CompanyCarManagement updateCompanyCarManagement(
		com.company.car.model.CompanyCarManagement companyCarManagement)
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

	/**
	* Import the excel info to the database
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> importCompanyCarManagement(
		java.util.List<java.util.Map<java.lang.String, java.lang.String>> list)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Query the CompanyCarManagement
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Query the count
	*/
	public long findCountByC_C_C_C(java.lang.String carType,
		java.lang.String contractType, java.lang.String carBrand,
		java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Query the Car Category level according the grade
	*/
	public java.lang.String findCartegoryByC_G_G(java.lang.String carType,
		java.lang.String gradeType, java.lang.String grade)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Query the CompanyCarManagement
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByS_F_C_C_C(
		java.lang.String staffCode, int childrenNumber,
		java.lang.String carType, java.lang.String carCategory,
		java.lang.String carBrand)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Query the CompanyCarManagement
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByS_F_C_C_C(
		java.lang.String staffCode, int childrenNumber,
		java.lang.String carType, java.lang.String carCategory,
		java.lang.String carBrand, int start, int end);

	public java.util.List<com.company.car.model.CompanyCarManagement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.company.car.model.CompanyCarManagement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Query the CompanyCarManagement for paginition
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	public com.company.car.model.CompanyCarManagement addCompanyCarManagement(
		com.company.car.model.CompanyCarManagement newCompanyCar,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.company.car.model.CompanyCarManagement deleteCompanyCar(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.company.car.model.CompanyCarManagement deleteCompanyCar(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Generate the ticket no for the workflow
	* for example:CC20150300000001
	*/
	public java.lang.String generateTicketNo(java.lang.String prefix);
}