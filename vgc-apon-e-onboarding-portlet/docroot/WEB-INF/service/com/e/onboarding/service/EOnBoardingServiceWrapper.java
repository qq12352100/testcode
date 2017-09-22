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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EOnBoardingService}.
 *
 * @author sanguine
 * @see EOnBoardingService
 * @generated
 */
public class EOnBoardingServiceWrapper implements EOnBoardingService,
	ServiceWrapper<EOnBoardingService> {
	public EOnBoardingServiceWrapper(EOnBoardingService eOnBoardingService) {
		_eOnBoardingService = eOnBoardingService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eOnBoardingService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eOnBoardingService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eOnBoardingService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EOnBoardingService getWrappedEOnBoardingService() {
		return _eOnBoardingService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEOnBoardingService(
		EOnBoardingService eOnBoardingService) {
		_eOnBoardingService = eOnBoardingService;
	}

	@Override
	public EOnBoardingService getWrappedService() {
		return _eOnBoardingService;
	}

	@Override
	public void setWrappedService(EOnBoardingService eOnBoardingService) {
		_eOnBoardingService = eOnBoardingService;
	}

	private EOnBoardingService _eOnBoardingService;
}