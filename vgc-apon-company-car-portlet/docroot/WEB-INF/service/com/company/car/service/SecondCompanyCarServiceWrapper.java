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
 * Provides a wrapper for {@link SecondCompanyCarService}.
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCarService
 * @generated
 */
public class SecondCompanyCarServiceWrapper implements SecondCompanyCarService,
	ServiceWrapper<SecondCompanyCarService> {
	public SecondCompanyCarServiceWrapper(
		SecondCompanyCarService secondCompanyCarService) {
		_secondCompanyCarService = secondCompanyCarService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _secondCompanyCarService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_secondCompanyCarService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _secondCompanyCarService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SecondCompanyCarService getWrappedSecondCompanyCarService() {
		return _secondCompanyCarService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSecondCompanyCarService(
		SecondCompanyCarService secondCompanyCarService) {
		_secondCompanyCarService = secondCompanyCarService;
	}

	@Override
	public SecondCompanyCarService getWrappedService() {
		return _secondCompanyCarService;
	}

	@Override
	public void setWrappedService(
		SecondCompanyCarService secondCompanyCarService) {
		_secondCompanyCarService = secondCompanyCarService;
	}

	private SecondCompanyCarService _secondCompanyCarService;
}