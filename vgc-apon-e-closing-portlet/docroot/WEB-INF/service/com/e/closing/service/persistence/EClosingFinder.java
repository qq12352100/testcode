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

package com.e.closing.service.persistence;

/**
 * @author t.a.jiang
 */
public interface EClosingFinder {
	public int findEclosingAllByKaleoInstanceId(long pk, java.lang.String tabs2)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.e.closing.model.EClosing> getEclosingByStaffcode(
		java.lang.String staffcode)
		throws com.liferay.portal.kernel.exception.SystemException;
}