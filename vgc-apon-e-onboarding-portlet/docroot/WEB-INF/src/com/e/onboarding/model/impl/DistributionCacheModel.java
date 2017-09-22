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

package com.e.onboarding.model.impl;

import com.e.onboarding.model.Distribution;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Distribution in entity cache.
 *
 * @author sanguine
 * @see Distribution
 * @generated
 */
public class DistributionCacheModel implements CacheModel<Distribution>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{distributionId=");
		sb.append(distributionId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", name=");
		sb.append(name);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Distribution toEntityModel() {
		DistributionImpl distributionImpl = new DistributionImpl();

		distributionImpl.setDistributionId(distributionId);
		distributionImpl.setGroupId(groupId);
		distributionImpl.setCompanyId(companyId);
		distributionImpl.setUserId(userId);

		if (userName == null) {
			distributionImpl.setUserName(StringPool.BLANK);
		}
		else {
			distributionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			distributionImpl.setCreateDate(null);
		}
		else {
			distributionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			distributionImpl.setModifiedDate(null);
		}
		else {
			distributionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (emailAddress == null) {
			distributionImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			distributionImpl.setEmailAddress(emailAddress);
		}

		if (name == null) {
			distributionImpl.setName(StringPool.BLANK);
		}
		else {
			distributionImpl.setName(name);
		}

		if (comments == null) {
			distributionImpl.setComments(StringPool.BLANK);
		}
		else {
			distributionImpl.setComments(comments);
		}

		if (type == null) {
			distributionImpl.setType(StringPool.BLANK);
		}
		else {
			distributionImpl.setType(type);
		}

		distributionImpl.resetOriginalValues();

		return distributionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		distributionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		name = objectInput.readUTF();
		comments = objectInput.readUTF();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(distributionId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long distributionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String emailAddress;
	public String name;
	public String comments;
	public String type;
}