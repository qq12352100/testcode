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

package com.business.trip.model.impl;

import com.business.trip.model.RateCity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RateCity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see RateCity
 * @generated
 */
public class RateCityCacheModel implements CacheModel<RateCity>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ratecityId=");
		sb.append(ratecityId);
		sb.append(", areaName=");
		sb.append(areaName);
		sb.append(", rateOfDma=");
		sb.append(rateOfDma);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RateCity toEntityModel() {
		RateCityImpl rateCityImpl = new RateCityImpl();

		rateCityImpl.setRatecityId(ratecityId);

		if (areaName == null) {
			rateCityImpl.setAreaName(StringPool.BLANK);
		}
		else {
			rateCityImpl.setAreaName(areaName);
		}

		rateCityImpl.setRateOfDma(rateOfDma);

		if (currency == null) {
			rateCityImpl.setCurrency(StringPool.BLANK);
		}
		else {
			rateCityImpl.setCurrency(currency);
		}

		rateCityImpl.setParentId(parentId);

		rateCityImpl.resetOriginalValues();

		return rateCityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ratecityId = objectInput.readLong();
		areaName = objectInput.readUTF();
		rateOfDma = objectInput.readDouble();
		currency = objectInput.readUTF();
		parentId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ratecityId);

		if (areaName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(areaName);
		}

		objectOutput.writeDouble(rateOfDma);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(parentId);
	}

	public long ratecityId;
	public String areaName;
	public double rateOfDma;
	public String currency;
	public long parentId;
}