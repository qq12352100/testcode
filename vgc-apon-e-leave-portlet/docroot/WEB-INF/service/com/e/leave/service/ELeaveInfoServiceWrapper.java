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

package com.e.leave.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ELeaveInfoService}.
 *
 * @author EZEYIFE
 * @see ELeaveInfoService
 * @generated
 */
public class ELeaveInfoServiceWrapper implements ELeaveInfoService,
	ServiceWrapper<ELeaveInfoService> {
	public ELeaveInfoServiceWrapper(ELeaveInfoService eLeaveInfoService) {
		_eLeaveInfoService = eLeaveInfoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eLeaveInfoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eLeaveInfoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eLeaveInfoService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ELeaveInfoService getWrappedELeaveInfoService() {
		return _eLeaveInfoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedELeaveInfoService(ELeaveInfoService eLeaveInfoService) {
		_eLeaveInfoService = eLeaveInfoService;
	}

	@Override
	public ELeaveInfoService getWrappedService() {
		return _eLeaveInfoService;
	}

	@Override
	public void setWrappedService(ELeaveInfoService eLeaveInfoService) {
		_eLeaveInfoService = eLeaveInfoService;
	}

	private ELeaveInfoService _eLeaveInfoService;
}