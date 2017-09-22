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

package com.seatoffice;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Alice.zou
 */
public class NoSuchSeatOfficeException extends NoSuchModelException {

	public NoSuchSeatOfficeException() {
		super();
	}

	public NoSuchSeatOfficeException(String msg) {
		super(msg);
	}

	public NoSuchSeatOfficeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchSeatOfficeException(Throwable cause) {
		super(cause);
	}

}