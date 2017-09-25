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

import com.business.trip.model.BtCarRentalInfo;
import com.business.trip.model.BtCarRentalInfoModel;

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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BtCarRentalInfo service. Represents a row in the &quot;vgcapon_BtCarRentalInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.business.trip.model.BtCarRentalInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BtCarRentalInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfoImpl
 * @see com.business.trip.model.BtCarRentalInfo
 * @see com.business.trip.model.BtCarRentalInfoModel
 * @generated
 */
public class BtCarRentalInfoModelImpl extends BaseModelImpl<BtCarRentalInfo>
	implements BtCarRentalInfoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bt car rental info model instance should use the {@link com.business.trip.model.BtCarRentalInfo} interface instead.
	 */
	public static final String TABLE_NAME = "vgcapon_BtCarRentalInfo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "btCarRentalInfoId", Types.BIGINT },
			{ "businessTripPkId", Types.BIGINT },
			{ "ticketNo", Types.VARCHAR },
			{ "pickupLocation", Types.VARCHAR },
			{ "pickupDate", Types.TIMESTAMP },
			{ "dropoffLocation", Types.VARCHAR },
			{ "dropoffDate", Types.TIMESTAMP },
			{ "carType", Types.VARCHAR },
			{ "typeOfRental", Types.VARCHAR },
			{ "price", Types.DOUBLE },
			{ "currency_", Types.VARCHAR },
			{ "tripType", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table vgcapon_BtCarRentalInfo (btCarRentalInfoId LONG not null primary key,businessTripPkId LONG,ticketNo VARCHAR(75) null,pickupLocation VARCHAR(75) null,pickupDate DATE null,dropoffLocation VARCHAR(75) null,dropoffDate DATE null,carType VARCHAR(75) null,typeOfRental VARCHAR(75) null,price DOUBLE,currency_ VARCHAR(75) null,tripType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table vgcapon_BtCarRentalInfo";
	public static final String ORDER_BY_JPQL = " ORDER BY btCarRentalInfo.btCarRentalInfoId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY vgcapon_BtCarRentalInfo.btCarRentalInfoId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.business.trip.model.BtCarRentalInfo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.business.trip.model.BtCarRentalInfo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.business.trip.model.BtCarRentalInfo"),
			true);
	public static long BUSINESSTRIPPKID_COLUMN_BITMASK = 1L;
	public static long TICKETNO_COLUMN_BITMASK = 2L;
	public static long TRIPTYPE_COLUMN_BITMASK = 4L;
	public static long BTCARRENTALINFOID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.business.trip.model.BtCarRentalInfo"));

	public BtCarRentalInfoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _btCarRentalInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBtCarRentalInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _btCarRentalInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BtCarRentalInfo.class;
	}

	@Override
	public String getModelClassName() {
		return BtCarRentalInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("btCarRentalInfoId", getBtCarRentalInfoId());
		attributes.put("businessTripPkId", getBusinessTripPkId());
		attributes.put("ticketNo", getTicketNo());
		attributes.put("pickupLocation", getPickupLocation());
		attributes.put("pickupDate", getPickupDate());
		attributes.put("dropoffLocation", getDropoffLocation());
		attributes.put("dropoffDate", getDropoffDate());
		attributes.put("carType", getCarType());
		attributes.put("typeOfRental", getTypeOfRental());
		attributes.put("price", getPrice());
		attributes.put("currency", getCurrency());
		attributes.put("tripType", getTripType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long btCarRentalInfoId = (Long)attributes.get("btCarRentalInfoId");

		if (btCarRentalInfoId != null) {
			setBtCarRentalInfoId(btCarRentalInfoId);
		}

		Long businessTripPkId = (Long)attributes.get("businessTripPkId");

		if (businessTripPkId != null) {
			setBusinessTripPkId(businessTripPkId);
		}

		String ticketNo = (String)attributes.get("ticketNo");

		if (ticketNo != null) {
			setTicketNo(ticketNo);
		}

		String pickupLocation = (String)attributes.get("pickupLocation");

		if (pickupLocation != null) {
			setPickupLocation(pickupLocation);
		}

		Date pickupDate = (Date)attributes.get("pickupDate");

		if (pickupDate != null) {
			setPickupDate(pickupDate);
		}

		String dropoffLocation = (String)attributes.get("dropoffLocation");

		if (dropoffLocation != null) {
			setDropoffLocation(dropoffLocation);
		}

		Date dropoffDate = (Date)attributes.get("dropoffDate");

		if (dropoffDate != null) {
			setDropoffDate(dropoffDate);
		}

		String carType = (String)attributes.get("carType");

		if (carType != null) {
			setCarType(carType);
		}

		String typeOfRental = (String)attributes.get("typeOfRental");

		if (typeOfRental != null) {
			setTypeOfRental(typeOfRental);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		String tripType = (String)attributes.get("tripType");

		if (tripType != null) {
			setTripType(tripType);
		}
	}

	@Override
	public long getBtCarRentalInfoId() {
		return _btCarRentalInfoId;
	}

	@Override
	public void setBtCarRentalInfoId(long btCarRentalInfoId) {
		_btCarRentalInfoId = btCarRentalInfoId;
	}

	@Override
	public long getBusinessTripPkId() {
		return _businessTripPkId;
	}

	@Override
	public void setBusinessTripPkId(long businessTripPkId) {
		_columnBitmask |= BUSINESSTRIPPKID_COLUMN_BITMASK;

		if (!_setOriginalBusinessTripPkId) {
			_setOriginalBusinessTripPkId = true;

			_originalBusinessTripPkId = _businessTripPkId;
		}

		_businessTripPkId = businessTripPkId;
	}

	public long getOriginalBusinessTripPkId() {
		return _originalBusinessTripPkId;
	}

	@Override
	public String getTicketNo() {
		if (_ticketNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _ticketNo;
		}
	}

	@Override
	public void setTicketNo(String ticketNo) {
		_columnBitmask |= TICKETNO_COLUMN_BITMASK;

		if (_originalTicketNo == null) {
			_originalTicketNo = _ticketNo;
		}

		_ticketNo = ticketNo;
	}

	public String getOriginalTicketNo() {
		return GetterUtil.getString(_originalTicketNo);
	}

	@Override
	public String getPickupLocation() {
		if (_pickupLocation == null) {
			return StringPool.BLANK;
		}
		else {
			return _pickupLocation;
		}
	}

	@Override
	public void setPickupLocation(String pickupLocation) {
		_pickupLocation = pickupLocation;
	}

	@Override
	public Date getPickupDate() {
		return _pickupDate;
	}

	@Override
	public void setPickupDate(Date pickupDate) {
		_pickupDate = pickupDate;
	}

	@Override
	public String getDropoffLocation() {
		if (_dropoffLocation == null) {
			return StringPool.BLANK;
		}
		else {
			return _dropoffLocation;
		}
	}

	@Override
	public void setDropoffLocation(String dropoffLocation) {
		_dropoffLocation = dropoffLocation;
	}

	@Override
	public Date getDropoffDate() {
		return _dropoffDate;
	}

	@Override
	public void setDropoffDate(Date dropoffDate) {
		_dropoffDate = dropoffDate;
	}

	@Override
	public String getCarType() {
		if (_carType == null) {
			return StringPool.BLANK;
		}
		else {
			return _carType;
		}
	}

	@Override
	public void setCarType(String carType) {
		_carType = carType;
	}

	@Override
	public String getTypeOfRental() {
		if (_typeOfRental == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeOfRental;
		}
	}

	@Override
	public void setTypeOfRental(String typeOfRental) {
		_typeOfRental = typeOfRental;
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;
	}

	@Override
	public String getCurrency() {
		if (_currency == null) {
			return StringPool.BLANK;
		}
		else {
			return _currency;
		}
	}

	@Override
	public void setCurrency(String currency) {
		_currency = currency;
	}

	@Override
	public String getTripType() {
		if (_tripType == null) {
			return StringPool.BLANK;
		}
		else {
			return _tripType;
		}
	}

	@Override
	public void setTripType(String tripType) {
		_columnBitmask |= TRIPTYPE_COLUMN_BITMASK;

		if (_originalTripType == null) {
			_originalTripType = _tripType;
		}

		_tripType = tripType;
	}

	public String getOriginalTripType() {
		return GetterUtil.getString(_originalTripType);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			BtCarRentalInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BtCarRentalInfo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BtCarRentalInfo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BtCarRentalInfoImpl btCarRentalInfoImpl = new BtCarRentalInfoImpl();

		btCarRentalInfoImpl.setBtCarRentalInfoId(getBtCarRentalInfoId());
		btCarRentalInfoImpl.setBusinessTripPkId(getBusinessTripPkId());
		btCarRentalInfoImpl.setTicketNo(getTicketNo());
		btCarRentalInfoImpl.setPickupLocation(getPickupLocation());
		btCarRentalInfoImpl.setPickupDate(getPickupDate());
		btCarRentalInfoImpl.setDropoffLocation(getDropoffLocation());
		btCarRentalInfoImpl.setDropoffDate(getDropoffDate());
		btCarRentalInfoImpl.setCarType(getCarType());
		btCarRentalInfoImpl.setTypeOfRental(getTypeOfRental());
		btCarRentalInfoImpl.setPrice(getPrice());
		btCarRentalInfoImpl.setCurrency(getCurrency());
		btCarRentalInfoImpl.setTripType(getTripType());

		btCarRentalInfoImpl.resetOriginalValues();

		return btCarRentalInfoImpl;
	}

	@Override
	public int compareTo(BtCarRentalInfo btCarRentalInfo) {
		long primaryKey = btCarRentalInfo.getPrimaryKey();

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

		if (!(obj instanceof BtCarRentalInfo)) {
			return false;
		}

		BtCarRentalInfo btCarRentalInfo = (BtCarRentalInfo)obj;

		long primaryKey = btCarRentalInfo.getPrimaryKey();

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
		BtCarRentalInfoModelImpl btCarRentalInfoModelImpl = this;

		btCarRentalInfoModelImpl._originalBusinessTripPkId = btCarRentalInfoModelImpl._businessTripPkId;

		btCarRentalInfoModelImpl._setOriginalBusinessTripPkId = false;

		btCarRentalInfoModelImpl._originalTicketNo = btCarRentalInfoModelImpl._ticketNo;

		btCarRentalInfoModelImpl._originalTripType = btCarRentalInfoModelImpl._tripType;

		btCarRentalInfoModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BtCarRentalInfo> toCacheModel() {
		BtCarRentalInfoCacheModel btCarRentalInfoCacheModel = new BtCarRentalInfoCacheModel();

		btCarRentalInfoCacheModel.btCarRentalInfoId = getBtCarRentalInfoId();

		btCarRentalInfoCacheModel.businessTripPkId = getBusinessTripPkId();

		btCarRentalInfoCacheModel.ticketNo = getTicketNo();

		String ticketNo = btCarRentalInfoCacheModel.ticketNo;

		if ((ticketNo != null) && (ticketNo.length() == 0)) {
			btCarRentalInfoCacheModel.ticketNo = null;
		}

		btCarRentalInfoCacheModel.pickupLocation = getPickupLocation();

		String pickupLocation = btCarRentalInfoCacheModel.pickupLocation;

		if ((pickupLocation != null) && (pickupLocation.length() == 0)) {
			btCarRentalInfoCacheModel.pickupLocation = null;
		}

		Date pickupDate = getPickupDate();

		if (pickupDate != null) {
			btCarRentalInfoCacheModel.pickupDate = pickupDate.getTime();
		}
		else {
			btCarRentalInfoCacheModel.pickupDate = Long.MIN_VALUE;
		}

		btCarRentalInfoCacheModel.dropoffLocation = getDropoffLocation();

		String dropoffLocation = btCarRentalInfoCacheModel.dropoffLocation;

		if ((dropoffLocation != null) && (dropoffLocation.length() == 0)) {
			btCarRentalInfoCacheModel.dropoffLocation = null;
		}

		Date dropoffDate = getDropoffDate();

		if (dropoffDate != null) {
			btCarRentalInfoCacheModel.dropoffDate = dropoffDate.getTime();
		}
		else {
			btCarRentalInfoCacheModel.dropoffDate = Long.MIN_VALUE;
		}

		btCarRentalInfoCacheModel.carType = getCarType();

		String carType = btCarRentalInfoCacheModel.carType;

		if ((carType != null) && (carType.length() == 0)) {
			btCarRentalInfoCacheModel.carType = null;
		}

		btCarRentalInfoCacheModel.typeOfRental = getTypeOfRental();

		String typeOfRental = btCarRentalInfoCacheModel.typeOfRental;

		if ((typeOfRental != null) && (typeOfRental.length() == 0)) {
			btCarRentalInfoCacheModel.typeOfRental = null;
		}

		btCarRentalInfoCacheModel.price = getPrice();

		btCarRentalInfoCacheModel.currency = getCurrency();

		String currency = btCarRentalInfoCacheModel.currency;

		if ((currency != null) && (currency.length() == 0)) {
			btCarRentalInfoCacheModel.currency = null;
		}

		btCarRentalInfoCacheModel.tripType = getTripType();

		String tripType = btCarRentalInfoCacheModel.tripType;

		if ((tripType != null) && (tripType.length() == 0)) {
			btCarRentalInfoCacheModel.tripType = null;
		}

		return btCarRentalInfoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{btCarRentalInfoId=");
		sb.append(getBtCarRentalInfoId());
		sb.append(", businessTripPkId=");
		sb.append(getBusinessTripPkId());
		sb.append(", ticketNo=");
		sb.append(getTicketNo());
		sb.append(", pickupLocation=");
		sb.append(getPickupLocation());
		sb.append(", pickupDate=");
		sb.append(getPickupDate());
		sb.append(", dropoffLocation=");
		sb.append(getDropoffLocation());
		sb.append(", dropoffDate=");
		sb.append(getDropoffDate());
		sb.append(", carType=");
		sb.append(getCarType());
		sb.append(", typeOfRental=");
		sb.append(getTypeOfRental());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", currency=");
		sb.append(getCurrency());
		sb.append(", tripType=");
		sb.append(getTripType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.business.trip.model.BtCarRentalInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>btCarRentalInfoId</column-name><column-value><![CDATA[");
		sb.append(getBtCarRentalInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessTripPkId</column-name><column-value><![CDATA[");
		sb.append(getBusinessTripPkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ticketNo</column-name><column-value><![CDATA[");
		sb.append(getTicketNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pickupLocation</column-name><column-value><![CDATA[");
		sb.append(getPickupLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pickupDate</column-name><column-value><![CDATA[");
		sb.append(getPickupDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dropoffLocation</column-name><column-value><![CDATA[");
		sb.append(getDropoffLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dropoffDate</column-name><column-value><![CDATA[");
		sb.append(getDropoffDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>carType</column-name><column-value><![CDATA[");
		sb.append(getCarType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeOfRental</column-name><column-value><![CDATA[");
		sb.append(getTypeOfRental());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currency</column-name><column-value><![CDATA[");
		sb.append(getCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tripType</column-name><column-value><![CDATA[");
		sb.append(getTripType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BtCarRentalInfo.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BtCarRentalInfo.class
		};
	private long _btCarRentalInfoId;
	private long _businessTripPkId;
	private long _originalBusinessTripPkId;
	private boolean _setOriginalBusinessTripPkId;
	private String _ticketNo;
	private String _originalTicketNo;
	private String _pickupLocation;
	private Date _pickupDate;
	private String _dropoffLocation;
	private Date _dropoffDate;
	private String _carType;
	private String _typeOfRental;
	private double _price;
	private String _currency;
	private String _tripType;
	private String _originalTripType;
	private long _columnBitmask;
	private BtCarRentalInfo _escapedModel;
}