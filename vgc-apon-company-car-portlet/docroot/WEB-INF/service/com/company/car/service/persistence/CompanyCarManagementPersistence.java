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

package com.company.car.service.persistence;

import com.company.car.model.CompanyCarManagement;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the company car management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagementPersistenceImpl
 * @see CompanyCarManagementUtil
 * @generated
 */
public interface CompanyCarManagementPersistence extends BasePersistence<CompanyCarManagement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CompanyCarManagementUtil} to access the company car management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the company car management where carNo = &#63; or throws a {@link com.company.car.NoSuchCompanyCarManagementException} if it could not be found.
	*
	* @param carNo the car no
	* @return the matching company car management
	* @throws com.company.car.NoSuchCompanyCarManagementException if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement findBycarNo(
		java.lang.String carNo)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company car management where carNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param carNo the car no
	* @return the matching company car management, or <code>null</code> if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement fetchBycarNo(
		java.lang.String carNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company car management where carNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param carNo the car no
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching company car management, or <code>null</code> if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement fetchBycarNo(
		java.lang.String carNo, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the company car management where carNo = &#63; from the database.
	*
	* @param carNo the car no
	* @return the company car management that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement removeBycarNo(
		java.lang.String carNo)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of company car managements where carNo = &#63;.
	*
	* @param carNo the car no
	* @return the number of matching company car managements
	* @throws SystemException if a system exception occurred
	*/
	public int countBycarNo(java.lang.String carNo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @return the matching company car managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param start the lower bound of the range of company car managements
	* @param end the upper bound of the range of company car managements (not inclusive)
	* @return the range of matching company car managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param start the lower bound of the range of company car managements
	* @param end the upper bound of the range of company car managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching company car managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findByC_C_C_C(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company car management
	* @throws com.company.car.NoSuchCompanyCarManagementException if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement findByC_C_C_C_First(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching company car management, or <code>null</code> if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement fetchByC_C_C_C_First(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company car management
	* @throws com.company.car.NoSuchCompanyCarManagementException if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement findByC_C_C_C_Last(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching company car management, or <code>null</code> if a matching company car management could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement fetchByC_C_C_C_Last(
		java.lang.String carType, java.lang.String contractType,
		java.lang.String carBrand, java.lang.String carCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company car managements before and after the current company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param companyCarManagementId the primary key of the current company car management
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next company car management
	* @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement[] findByC_C_C_C_PrevAndNext(
		long companyCarManagementId, java.lang.String carType,
		java.lang.String contractType, java.lang.String carBrand,
		java.lang.String carCategory,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63; from the database.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C_C(java.lang.String carType,
		java.lang.String contractType, java.lang.String carBrand,
		java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	*
	* @param carType the car type
	* @param contractType the contract type
	* @param carBrand the car brand
	* @param carCategory the car category
	* @return the number of matching company car managements
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C_C(java.lang.String carType,
		java.lang.String contractType, java.lang.String carBrand,
		java.lang.String carCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the company car management in the entity cache if it is enabled.
	*
	* @param companyCarManagement the company car management
	*/
	public void cacheResult(
		com.company.car.model.CompanyCarManagement companyCarManagement);

	/**
	* Caches the company car managements in the entity cache if it is enabled.
	*
	* @param companyCarManagements the company car managements
	*/
	public void cacheResult(
		java.util.List<com.company.car.model.CompanyCarManagement> companyCarManagements);

	/**
	* Creates a new company car management with the primary key. Does not add the company car management to the database.
	*
	* @param companyCarManagementId the primary key for the new company car management
	* @return the new company car management
	*/
	public com.company.car.model.CompanyCarManagement create(
		long companyCarManagementId);

	/**
	* Removes the company car management with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management that was removed
	* @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement remove(
		long companyCarManagementId)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.company.car.model.CompanyCarManagement updateImpl(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company car management with the primary key or throws a {@link com.company.car.NoSuchCompanyCarManagementException} if it could not be found.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management
	* @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement findByPrimaryKey(
		long companyCarManagementId)
		throws com.company.car.NoSuchCompanyCarManagementException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the company car management with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyCarManagementId the primary key of the company car management
	* @return the company car management, or <code>null</code> if a company car management with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.company.car.model.CompanyCarManagement fetchByPrimaryKey(
		long companyCarManagementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the company car managements.
	*
	* @return the company car managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.company.car.model.CompanyCarManagement> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the company car managements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of company car managements
	* @param end the upper bound of the range of company car managements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of company car managements
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.company.car.model.CompanyCarManagement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the company car managements from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of company car managements.
	*
	* @return the number of company car managements
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}