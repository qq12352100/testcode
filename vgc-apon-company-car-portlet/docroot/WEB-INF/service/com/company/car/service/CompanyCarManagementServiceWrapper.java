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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CompanyCarManagementService}.
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagementService
 * @generated
 */
public class CompanyCarManagementServiceWrapper
	implements CompanyCarManagementService,
		ServiceWrapper<CompanyCarManagementService> {
	public CompanyCarManagementServiceWrapper(
		CompanyCarManagementService companyCarManagementService) {
		_companyCarManagementService = companyCarManagementService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _companyCarManagementService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_companyCarManagementService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _companyCarManagementService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CompanyCarManagementService getWrappedCompanyCarManagementService() {
		return _companyCarManagementService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCompanyCarManagementService(
		CompanyCarManagementService companyCarManagementService) {
		_companyCarManagementService = companyCarManagementService;
	}

	@Override
	public CompanyCarManagementService getWrappedService() {
		return _companyCarManagementService;
	}

	@Override
	public void setWrappedService(
		CompanyCarManagementService companyCarManagementService) {
		_companyCarManagementService = companyCarManagementService;
	}

	private CompanyCarManagementService _companyCarManagementService;
}