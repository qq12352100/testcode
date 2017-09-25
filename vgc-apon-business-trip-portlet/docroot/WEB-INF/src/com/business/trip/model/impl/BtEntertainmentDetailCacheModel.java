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

import com.business.trip.model.BtEntertainmentDetail;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BtEntertainmentDetail in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetail
 * @generated
 */
public class BtEntertainmentDetailCacheModel implements CacheModel<BtEntertainmentDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{btEntertainmentDetailId=");
		sb.append(btEntertainmentDetailId);
		sb.append(", btCostListId=");
		sb.append(btCostListId);
		sb.append(", businessTripPkId=");
		sb.append(businessTripPkId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", positionTitle=");
		sb.append(positionTitle);
		sb.append(", company=");
		sb.append(company);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BtEntertainmentDetail toEntityModel() {
		BtEntertainmentDetailImpl btEntertainmentDetailImpl = new BtEntertainmentDetailImpl();

		btEntertainmentDetailImpl.setBtEntertainmentDetailId(btEntertainmentDetailId);
		btEntertainmentDetailImpl.setBtCostListId(btCostListId);
		btEntertainmentDetailImpl.setBusinessTripPkId(businessTripPkId);

		if (fullName == null) {
			btEntertainmentDetailImpl.setFullName(StringPool.BLANK);
		}
		else {
			btEntertainmentDetailImpl.setFullName(fullName);
		}

		if (positionTitle == null) {
			btEntertainmentDetailImpl.setPositionTitle(StringPool.BLANK);
		}
		else {
			btEntertainmentDetailImpl.setPositionTitle(positionTitle);
		}

		if (company == null) {
			btEntertainmentDetailImpl.setCompany(StringPool.BLANK);
		}
		else {
			btEntertainmentDetailImpl.setCompany(company);
		}

		btEntertainmentDetailImpl.resetOriginalValues();

		return btEntertainmentDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		btEntertainmentDetailId = objectInput.readLong();
		btCostListId = objectInput.readLong();
		businessTripPkId = objectInput.readLong();
		fullName = objectInput.readUTF();
		positionTitle = objectInput.readUTF();
		company = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(btEntertainmentDetailId);
		objectOutput.writeLong(btCostListId);
		objectOutput.writeLong(businessTripPkId);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (positionTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(positionTitle);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}
	}

	public long btEntertainmentDetailId;
	public long btCostListId;
	public long businessTripPkId;
	public String fullName;
	public String positionTitle;
	public String company;
}