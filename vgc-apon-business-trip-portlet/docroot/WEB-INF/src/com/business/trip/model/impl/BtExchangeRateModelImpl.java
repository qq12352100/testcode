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

import com.business.trip.model.BtExchangeRate;
import com.business.trip.model.BtExchangeRateModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BtExchangeRate service. Represents a row in the &quot;vgcapon_BtExchangeRate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.business.trip.model.BtExchangeRateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BtExchangeRateImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRateImpl
 * @see com.business.trip.model.BtExchangeRate
 * @see com.business.trip.model.BtExchangeRateModel
 * @generated
 */
public class BtExchangeRateModelImpl extends BaseModelImpl<BtExchangeRate>
	implements BtExchangeRateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bt exchange rate model instance should use the {@link com.business.trip.model.BtExchangeRate} interface instead.
	 */
	public static final String TABLE_NAME = "vgcapon_BtExchangeRate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "btExchangeRateId", Types.BIGINT },
			{ "firstCurrency", Types.VARCHAR },
			{ "secondCurrency", Types.VARCHAR },
			{ "firToSecExchangeRate", Types.DOUBLE },
			{ "secToFirExchangeRate", Types.DOUBLE },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table vgcapon_BtExchangeRate (btExchangeRateId LONG not null primary key,firstCurrency VARCHAR(75) null,secondCurrency VARCHAR(75) null,firToSecExchangeRate DOUBLE,secToFirExchangeRate DOUBLE,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table vgcapon_BtExchangeRate";
	public static final String ORDER_BY_JPQL = " ORDER BY btExchangeRate.btExchangeRateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY vgcapon_BtExchangeRate.btExchangeRateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.business.trip.model.BtExchangeRate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.business.trip.model.BtExchangeRate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.business.trip.model.BtExchangeRate"),
			true);
	public static long FIRSTCURRENCY_COLUMN_BITMASK = 1L;
	public static long SECONDCURRENCY_COLUMN_BITMASK = 2L;
	public static long STATUS_COLUMN_BITMASK = 4L;
	public static long BTEXCHANGERATEID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.business.trip.model.BtExchangeRate"));

	public BtExchangeRateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _btExchangeRateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtExchangeRateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btExchangeRateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BtExchangeRate.class;
	}

	@Override
	public String getModelClassName() {
		return BtExchangeRate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btExchangeRateId", getBtExchangeRateId());
		attributes.put("firstCurrency", getFirstCurrency());
		attributes.put("secondCurrency", getSecondCurrency());
		attributes.put("firToSecExchangeRate", getFirToSecExchangeRate());
		attributes.put("secToFirExchangeRate", getSecToFirExchangeRate());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btExchangeRateId = (Long)attributes.get("btExchangeRateId");

		if (btExchangeRateId != null) {
			setBtExchangeRateId(btExchangeRateId);
		}

		String firstCurrency = (String)attributes.get("firstCurrency");

		if (firstCurrency != null) {
			setFirstCurrency(firstCurrency);
		}

		String secondCurrency = (String)attributes.get("secondCurrency");

		if (secondCurrency != null) {
			setSecondCurrency(secondCurrency);
		}

		Double firToSecExchangeRate = (Double)attributes.get(
				"firToSecExchangeRate");

		if (firToSecExchangeRate != null) {
			setFirToSecExchangeRate(firToSecExchangeRate);
		}

		Double secToFirExchangeRate = (Double)attributes.get(
				"secToFirExchangeRate");

		if (secToFirExchangeRate != null) {
			setSecToFirExchangeRate(secToFirExchangeRate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getBtExchangeRateId() {
		return _btExchangeRateId;
	}

	@Override
	public void setBtExchangeRateId(long btExchangeRateId) {
		_btExchangeRateId = btExchangeRateId;
	}

	@Override
	public String getFirstCurrency() {
		if (_firstCurrency == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstCurrency;
		}
	}

	@Override
	public void setFirstCurrency(String firstCurrency) {
		_columnBitmask |= FIRSTCURRENCY_COLUMN_BITMASK;

		if (_originalFirstCurrency == null) {
			_originalFirstCurrency = _firstCurrency;
		}

		_firstCurrency = firstCurrency;
	}

	public String getOriginalFirstCurrency() {
		return GetterUtil.getString(_originalFirstCurrency);
	}

	@Override
	public String getSecondCurrency() {
		if (_secondCurrency == null) {
			return StringPool.BLANK;
		}
		else {
			return _secondCurrency;
		}
	}

	@Override
	public void setSecondCurrency(String secondCurrency) {
		_columnBitmask |= SECONDCURRENCY_COLUMN_BITMASK;

		if (_originalSecondCurrency == null) {
			_originalSecondCurrency = _secondCurrency;
		}

		_secondCurrency = secondCurrency;
	}

	public String getOriginalSecondCurrency() {
		return GetterUtil.getString(_originalSecondCurrency);
	}

	@Override
	public double getFirToSecExchangeRate() {
		return _firToSecExchangeRate;
	}

	@Override
	public void setFirToSecExchangeRate(double firToSecExchangeRate) {
		_firToSecExchangeRate = firToSecExchangeRate;
	}

	@Override
	public double getSecToFirExchangeRate() {
		return _secToFirExchangeRate;
	}

	@Override
	public void setSecToFirExchangeRate(double secToFirExchangeRate) {
		_secToFirExchangeRate = secToFirExchangeRate;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BtExchangeRate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BtExchangeRate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BtExchangeRate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BtExchangeRateImpl btExchangeRateImpl = new BtExchangeRateImpl();

		btExchangeRateImpl.setBtExchangeRateId(getBtExchangeRateId());
		btExchangeRateImpl.setFirstCurrency(getFirstCurrency());
		btExchangeRateImpl.setSecondCurrency(getSecondCurrency());
		btExchangeRateImpl.setFirToSecExchangeRate(getFirToSecExchangeRate());
		btExchangeRateImpl.setSecToFirExchangeRate(getSecToFirExchangeRate());
		btExchangeRateImpl.setUserId(getUserId());
		btExchangeRateImpl.setUserName(getUserName());
		btExchangeRateImpl.setCreateDate(getCreateDate());
		btExchangeRateImpl.setModifiedDate(getModifiedDate());
		btExchangeRateImpl.setStatus(getStatus());

		btExchangeRateImpl.resetOriginalValues();

		return btExchangeRateImpl;
	}

	@Override
	public int compareTo(BtExchangeRate btExchangeRate) {
		long primaryKey = btExchangeRate.getPrimaryKey();

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

		if (!(obj instanceof BtExchangeRate)) {
			return false;
		}

		BtExchangeRate btExchangeRate = (BtExchangeRate)obj;

		long primaryKey = btExchangeRate.getPrimaryKey();

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
		BtExchangeRateModelImpl btExchangeRateModelImpl = this;

		btExchangeRateModelImpl._originalFirstCurrency = btExchangeRateModelImpl._firstCurrency;

		btExchangeRateModelImpl._originalSecondCurrency = btExchangeRateModelImpl._secondCurrency;

		btExchangeRateModelImpl._originalStatus = btExchangeRateModelImpl._status;

		btExchangeRateModelImpl._setOriginalStatus = false;

		btExchangeRateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BtExchangeRate> toCacheModel() {
		BtExchangeRateCacheModel btExchangeRateCacheModel = new BtExchangeRateCacheModel();

		btExchangeRateCacheModel.btExchangeRateId = getBtExchangeRateId();

		btExchangeRateCacheModel.firstCurrency = getFirstCurrency();

		String firstCurrency = btExchangeRateCacheModel.firstCurrency;

		if ((firstCurrency != null) && (firstCurrency.length() == 0)) {
			btExchangeRateCacheModel.firstCurrency = null;
		}

		btExchangeRateCacheModel.secondCurrency = getSecondCurrency();

		String secondCurrency = btExchangeRateCacheModel.secondCurrency;

		if ((secondCurrency != null) && (secondCurrency.length() == 0)) {
			btExchangeRateCacheModel.secondCurrency = null;
		}

		btExchangeRateCacheModel.firToSecExchangeRate = getFirToSecExchangeRate();

		btExchangeRateCacheModel.secToFirExchangeRate = getSecToFirExchangeRate();

		btExchangeRateCacheModel.userId = getUserId();

		btExchangeRateCacheModel.userName = getUserName();

		String userName = btExchangeRateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			btExchangeRateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			btExchangeRateCacheModel.createDate = createDate.getTime();
		}
		else {
			btExchangeRateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			btExchangeRateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			btExchangeRateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		btExchangeRateCacheModel.status = getStatus();

		return btExchangeRateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{btExchangeRateId=");
		sb.append(getBtExchangeRateId());
		sb.append(", firstCurrency=");
		sb.append(getFirstCurrency());
		sb.append(", secondCurrency=");
		sb.append(getSecondCurrency());
		sb.append(", firToSecExchangeRate=");
		sb.append(getFirToSecExchangeRate());
		sb.append(", secToFirExchangeRate=");
		sb.append(getSecToFirExchangeRate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtExchangeRate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btExchangeRateId</column-name><column-value><![CDATA[");
		sb.append(getBtExchangeRateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstCurrency</column-name><column-value><![CDATA[");
		sb.append(getFirstCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secondCurrency</column-name><column-value><![CDATA[");
		sb.append(getSecondCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firToSecExchangeRate</column-name><column-value><![CDATA[");
		sb.append(getFirToSecExchangeRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secToFirExchangeRate</column-name><column-value><![CDATA[");
		sb.append(getSecToFirExchangeRate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BtExchangeRate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BtExchangeRate.class
		};
	private long _btExchangeRateId;
	private String _firstCurrency;
	private String _originalFirstCurrency;
	private String _secondCurrency;
	private String _originalSecondCurrency;
	private double _firToSecExchangeRate;
	private double _secToFirExchangeRate;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private BtExchangeRate _escapedModel;
}