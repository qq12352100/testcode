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

package com.business.trip.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BtFlightTrainInfo service. Represents a row in the &quot;vgcapon_BtFlightTrainInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.business.trip.model.impl.BtFlightTrainInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtFlightTrainInfo
 * @see com.business.trip.model.impl.BtFlightTrainInfoImpl
 * @see com.business.trip.model.impl.BtFlightTrainInfoModelImpl
 * @generated
 */
public interface BtFlightTrainInfoModel extends BaseModel<BtFlightTrainInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bt flight train info model instance should use the {@link BtFlightTrainInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this bt flight train info.
	 *
	 * @return the primary key of this bt flight train info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bt flight train info.
	 *
	 * @param primaryKey the primary key of this bt flight train info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the bt flight train info ID of this bt flight train info.
	 *
	 * @return the bt flight train info ID of this bt flight train info
	 */
	public long getBtFlightTrainInfoId();

	/**
	 * Sets the bt flight train info ID of this bt flight train info.
	 *
	 * @param btFlightTrainInfoId the bt flight train info ID of this bt flight train info
	 */
	public void setBtFlightTrainInfoId(long btFlightTrainInfoId);

	/**
	 * Returns the business trip pk ID of this bt flight train info.
	 *
	 * @return the business trip pk ID of this bt flight train info
	 */
	public long getBusinessTripPkId();

	/**
	 * Sets the business trip pk ID of this bt flight train info.
	 *
	 * @param businessTripPkId the business trip pk ID of this bt flight train info
	 */
	public void setBusinessTripPkId(long businessTripPkId);

	/**
	 * Returns the ticket no of this bt flight train info.
	 *
	 * @return the ticket no of this bt flight train info
	 */
	@AutoEscape
	public String getTicketNo();

	/**
	 * Sets the ticket no of this bt flight train info.
	 *
	 * @param ticketNo the ticket no of this bt flight train info
	 */
	public void setTicketNo(String ticketNo);

	/**
	 * Returns the type of this bt flight train info.
	 *
	 * @return the type of this bt flight train info
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this bt flight train info.
	 *
	 * @param type the type of this bt flight train info
	 */
	public void setType(String type);

	/**
	 * Returns the from city of this bt flight train info.
	 *
	 * @return the from city of this bt flight train info
	 */
	@AutoEscape
	public String getFromCity();

	/**
	 * Sets the from city of this bt flight train info.
	 *
	 * @param fromCity the from city of this bt flight train info
	 */
	public void setFromCity(String fromCity);

	/**
	 * Returns the to city of this bt flight train info.
	 *
	 * @return the to city of this bt flight train info
	 */
	@AutoEscape
	public String getToCity();

	/**
	 * Sets the to city of this bt flight train info.
	 *
	 * @param toCity the to city of this bt flight train info
	 */
	public void setToCity(String toCity);

	/**
	 * Returns the departure date of this bt flight train info.
	 *
	 * @return the departure date of this bt flight train info
	 */
	public Date getDepartureDate();

	/**
	 * Sets the departure date of this bt flight train info.
	 *
	 * @param departureDate the departure date of this bt flight train info
	 */
	public void setDepartureDate(Date departureDate);

	/**
	 * Returns the departure flight of this bt flight train info.
	 *
	 * @return the departure flight of this bt flight train info
	 */
	@AutoEscape
	public String getDepartureFlight();

	/**
	 * Sets the departure flight of this bt flight train info.
	 *
	 * @param departureFlight the departure flight of this bt flight train info
	 */
	public void setDepartureFlight(String departureFlight);

	/**
	 * Returns the departure time of this bt flight train info.
	 *
	 * @return the departure time of this bt flight train info
	 */
	public Date getDepartureTime();

	/**
	 * Sets the departure time of this bt flight train info.
	 *
	 * @param departureTime the departure time of this bt flight train info
	 */
	public void setDepartureTime(Date departureTime);

	/**
	 * Returns the class info of this bt flight train info.
	 *
	 * @return the class info of this bt flight train info
	 */
	@AutoEscape
	public String getClassInfo();

	/**
	 * Sets the class info of this bt flight train info.
	 *
	 * @param classInfo the class info of this bt flight train info
	 */
	public void setClassInfo(String classInfo);

	/**
	 * Returns the price of this bt flight train info.
	 *
	 * @return the price of this bt flight train info
	 */
	public double getPrice();

	/**
	 * Sets the price of this bt flight train info.
	 *
	 * @param price the price of this bt flight train info
	 */
	public void setPrice(double price);

	/**
	 * Returns the currency of this bt flight train info.
	 *
	 * @return the currency of this bt flight train info
	 */
	@AutoEscape
	public String getCurrency();

	/**
	 * Sets the currency of this bt flight train info.
	 *
	 * @param currency the currency of this bt flight train info
	 */
	public void setCurrency(String currency);

	/**
	 * Returns the trip type of this bt flight train info.
	 *
	 * @return the trip type of this bt flight train info
	 */
	@AutoEscape
	public String getTripType();

	/**
	 * Sets the trip type of this bt flight train info.
	 *
	 * @param tripType the trip type of this bt flight train info
	 */
	public void setTripType(String tripType);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.business.trip.model.BtFlightTrainInfo> toCacheModel();

	@Override
	public com.business.trip.model.BtFlightTrainInfo toEscapedModel();

	@Override
	public com.business.trip.model.BtFlightTrainInfo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}