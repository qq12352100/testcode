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

package com.e.leave.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author EZEYIFE
 * @generated
 */
public class ELeaveInfoPK implements Comparable<ELeaveInfoPK>, Serializable {
	public long eLeaveInfoId;
	public long eLeaveId;

	public ELeaveInfoPK() {
	}

	public ELeaveInfoPK(long eLeaveInfoId, long eLeaveId) {
		this.eLeaveInfoId = eLeaveInfoId;
		this.eLeaveId = eLeaveId;
	}

	public long getELeaveInfoId() {
		return eLeaveInfoId;
	}

	public void setELeaveInfoId(long eLeaveInfoId) {
		this.eLeaveInfoId = eLeaveInfoId;
	}

	public long getELeaveId() {
		return eLeaveId;
	}

	public void setELeaveId(long eLeaveId) {
		this.eLeaveId = eLeaveId;
	}

	@Override
	public int compareTo(ELeaveInfoPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (eLeaveInfoId < pk.eLeaveInfoId) {
			value = -1;
		}
		else if (eLeaveInfoId > pk.eLeaveInfoId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (eLeaveId < pk.eLeaveId) {
			value = -1;
		}
		else if (eLeaveId > pk.eLeaveId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ELeaveInfoPK)) {
			return false;
		}

		ELeaveInfoPK pk = (ELeaveInfoPK)obj;

		if ((eLeaveInfoId == pk.eLeaveInfoId) && (eLeaveId == pk.eLeaveId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(eLeaveInfoId) + String.valueOf(eLeaveId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("eLeaveInfoId");
		sb.append(StringPool.EQUAL);
		sb.append(eLeaveInfoId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("eLeaveId");
		sb.append(StringPool.EQUAL);
		sb.append(eLeaveId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}