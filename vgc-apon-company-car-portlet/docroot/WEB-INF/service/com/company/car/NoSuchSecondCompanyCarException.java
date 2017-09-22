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

package com.company.car;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchSecondCompanyCarException extends NoSuchModelException {

	public NoSuchSecondCompanyCarException() {
		super();
	}

	public NoSuchSecondCompanyCarException(String msg) {
		super(msg);
	}

	public NoSuchSecondCompanyCarException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSecondCompanyCarException(Throwable cause) {
		super(cause);
	}

}