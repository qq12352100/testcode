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
import com.business.trip.model.BtEntertainmentDetailModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BtEntertainmentDetail service. Represents a row in the &quot;vgcapon_BtEntertainmentDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.business.trip.model.BtEntertainmentDetailModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BtEntertainmentDetailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetailImpl
 * @see com.business.trip.model.BtEntertainmentDetail
 * @see com.business.trip.model.BtEntertainmentDetailModel
 * @generated
 */
public class BtEntertainmentDetailModelImpl extends BaseModelImpl<BtEntertainmentDetail>
	implements BtEntertainmentDetailModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bt entertainment detail model instance should use the {@link com.business.trip.model.BtEntertainmentDetail} interface instead.
	 */
	public static final String TABLE_NAME = "vgcapon_BtEntertainmentDetail";
	public static final Object[][] TABLE_COLUMNS = {
			{ "btEntertainmentDetailId", Types.BIGINT },
			{ "btCostListId", Types.BIGINT },
			{ "businessTripPkId", Types.BIGINT },
			{ "fullName", Types.VARCHAR },
			{ "positionTitle", Types.VARCHAR },
			{ "company", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vgcapon_BtEntertainmentDetail (btEntertainmentDetailId LONG not null primary key,btCostListId LONG,businessTripPkId LONG,fullName VARCHAR(75) null,positionTitle VARCHAR(75) null,company VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vgcapon_BtEntertainmentDetail";
	public static final String ORDER_BY_JPQL = " ORDER BY btEntertainmentDetail.btEntertainmentDetailId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY vgcapon_BtEntertainmentDetail.btEntertainmentDetailId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.business.trip.model.BtEntertainmentDetail"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.business.trip.model.BtEntertainmentDetail"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.business.trip.model.BtEntertainmentDetail"),
			true);
	public static long BTCOSTLISTID_COLUMN_BITMASK = 1L;
	public static long BTENTERTAINMENTDETAILID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.business.trip.model.BtEntertainmentDetail"));

	public BtEntertainmentDetailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _btEntertainmentDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtEntertainmentDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btEntertainmentDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BtEntertainmentDetail.class;
	}

	@Override
	public String getModelClassName() {
		return BtEntertainmentDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btEntertainmentDetailId", getBtEntertainmentDetailId());
		attributes.put("btCostListId", getBtCostListId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("fullName", getFullName());
		attributes.put("positionTitle", getPositionTitle());
		attributes.put("company", getCompany());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btEntertainmentDetailId = (Long)attributes.get(
				"btEntertainmentDetailId");

		if (btEntertainmentDetailId != null) {
			setBtEntertainmentDetailId(btEntertainmentDetailId);
		}

		Long btCostListId = (Long)attributes.get("btCostListId");

		if (btCostListId != null) {
			setBtCostListId(btCostListId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String positionTitle = (String)attributes.get("positionTitle");

		if (positionTitle != null) {
			setPositionTitle(positionTitle);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}
	}

	@Override
	public long getBtEntertainmentDetailId() {
		return _btEntertainmentDetailId;
	}

	@Override
	public void setBtEntertainmentDetailId(long btEntertainmentDetailId) {
		_btEntertainmentDetailId = btEntertainmentDetailId;
	}

	@Override
	public long getBtCostListId() {
		return _btCostListId;
	}

	@Override
	public void setBtCostListId(long btCostListId) {
		_columnBitmask |= BTCOSTLISTID_COLUMN_BITMASK;

		if (!_setOriginalBtCostListId) {
			_setOriginalBtCostListId = true;

			_originalBtCostListId = _btCostListId;
		}

		_btCostListId = btCostListId;
	}

	public long getOriginalBtCostListId() {
		return _originalBtCostListId;
	}

	@Override
	public long getBusinessTripPkId() {
		return _businessTripPkId;
	}

	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_businessTripPkId = businessTripPkId;
	}

	@Override
	public String getFullName() {
		if (_fullName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@Override
	public String getPositionTitle() {
		if (_positionTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _positionTitle;
		}
	}

	@Override
	public void setPositionTitle(String positionTitle) {
		_positionTitle = positionTitle;
	}

	@Override
	public String getCompany() {
		if (_company == null) {
			return StringPool.BLANK;
		}
		else {
			return _company;
		}
	}

	@Override
	public void setCompany(String company) {
		_company = company;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BtEntertainmentDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BtEntertainmentDetail toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BtEntertainmentDetail)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BtEntertainmentDetailImpl btEntertainmentDetailImpl = new BtEntertainmentDetailImpl();

		btEntertainmentDetailImpl.setBtEntertainmentDetailId(getBtEntertainmentDetailId());
		btEntertainmentDetailImpl.setBtCostListId(getBtCostListId());
		btEntertainmentDetailImpl.setBusinessTripPkId(getBusinessTripPkId());
		btEntertainmentDetailImpl.setFullName(getFullName());
		btEntertainmentDetailImpl.setPositionTitle(getPositionTitle());
		btEntertainmentDetailImpl.setCompany(getCompany());

		btEntertainmentDetailImpl.resetOriginalValues();

		return btEntertainmentDetailImpl;
	}

	@Override
	public int compareTo(BtEntertainmentDetail btEntertainmentDetail) {
		long primaryKey = btEntertainmentDetail.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BtEntertainmentDetail)) {
			return false;
		}

		BtEntertainmentDetail btEntertainmentDetail = (BtEntertainmentDetail)obj;

		long primaryKey = btEntertainmentDetail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		BtEntertainmentDetailModelImpl btEntertainmentDetailModelImpl = this;

		btEntertainmentDetailModelImpl._originalBtCostListId = btEntertainmentDetailModelImpl._btCostListId;

		btEntertainmentDetailModelImpl._setOriginalBtCostListId = false;

		btEntertainmentDetailModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BtEntertainmentDetail> toCacheModel() {
		BtEntertainmentDetailCacheModel btEntertainmentDetailCacheModel = new BtEntertainmentDetailCacheModel();

		btEntertainmentDetailCacheModel.btEntertainmentDetailId = getBtEntertainmentDetailId();

		btEntertainmentDetailCacheModel.btCostListId = getBtCostListId();

		btEntertainmentDetailCacheModel.businessTripPkId = getBusinessTripPkId();

		btEntertainmentDetailCacheModel.fullName = getFullName();

		String fullName = btEntertainmentDetailCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			btEntertainmentDetailCacheModel.fullName = null;
		}

		btEntertainmentDetailCacheModel.positionTitle = getPositionTitle();

		String positionTitle = btEntertainmentDetailCacheModel.positionTitle;

		if ((positionTitle != null) && (positionTitle.length() == 0)) {
			btEntertainmentDetailCacheModel.positionTitle = null;
		}

		btEntertainmentDetailCacheModel.company = getCompany();

		String company = btEntertainmentDetailCacheModel.company;

		if ((company != null) && (company.length() == 0)) {
			btEntertainmentDetailCacheModel.company = null;
		}

		return btEntertainmentDetailCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{btEntertainmentDetailId=");
		sb.append(getBtEntertainmentDetailId());
		sb.append(", btCostListId=");
		sb.append(getBtCostListId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", positionTitle=");
		sb.append(getPositionTitle());
		sb.append(", company=");
		sb.append(getCompany());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtEntertainmentDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btEntertainmentDetailId</column-name><column-value><![CDATA[");
		sb.append(getBtEntertainmentDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>btCostListId</column-name><column-value><![CDATA[");
		sb.append(getBtCostListId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessTripPkId</column-name><column-value><![CDATA[");
		sb.append(getBusinessTripPkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionTitle</column-name><column-value><![CDATA[");
		sb.append(getPositionTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>company</column-name><column-value><![CDATA[");
		sb.append(getCompany());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BtEntertainmentDetail.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BtEntertainmentDetail.class
		};
	private long _btEntertainmentDetailId;
	private long _btCostListId;
	private long _originalBtCostListId;
	private boolean _setOriginalBtCostListId;
	private long _businessTripPkId;
	private String _fullName;
	private String _positionTitle;
	private String _company;
	private long _columnBitmask;
	private BtEntertainmentDetail _escapedModel;
}