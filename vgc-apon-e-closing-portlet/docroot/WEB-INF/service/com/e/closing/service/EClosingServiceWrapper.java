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
 * Provides a wrapper for {@link EClosingService}.
 *
 * @author t.a.jiang
 * @see EClosingService
 * @generated
 */
public class EClosingServiceWrapper implements EClosingService,
	ServiceWrapper<EClosingService> {
	public EClosingServiceWrapper(EClosingService eClosingService) {
		_eClosingService = eClosingService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eClosingService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eClosingService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eClosingService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EClosingService getWrappedEClosingService() {
		return _eClosingService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEClosingService(EClosingService eClosingService) {
		_eClosingService = eClosingService;
	}

	@Override
	public EClosingService getWrappedService() {
		return _eClosingService;
	}

	@Override
	public void setWrappedService(EClosingService eClosingService) {
		_eClosingService = eClosingService;
	}

	private EClosingService _eClosingService;
}