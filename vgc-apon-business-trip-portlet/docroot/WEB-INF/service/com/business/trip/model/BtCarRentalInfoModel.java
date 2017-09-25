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
 * The base model interface for the BtCarRentalInfo service. Represents a row in the &quot;vgcapon_BtCarRentalInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.business.trip.model.impl.BtCarRentalInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfo
 * @see com.business.trip.model.impl.BtCarRentalInfoImpl
 * @see com.business.trip.model.impl.BtCarRentalInfoModelImpl
 * @generated
 */
public interface BtCarRentalInfoModel extends BaseModel<BtCarRentalInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bt car rental info model instance should use the {@link BtCarRentalInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this bt car rental info.
	 *
	 * @return the primary key of this bt car rental info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bt car rental info.
	 *
	 * @param primaryKey the primary key of this bt car rental info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the bt car rental info ID of this bt car rental info.
	 *
	 * @return the bt car rental info ID of this bt car rental info
	 */
	public long getBtCarRentalInfoId();

	/**
	 * Sets the bt car rental info ID of this bt car rental info.
	 *
	 * @param btCarRentalInfoId the bt car rental info ID of this bt car rental info
	 */
	public void setBtCarRentalInfoId(long btCarRentalInfoId);

	/**
	 * Returns the business trip pk ID of this bt car rental info.
	 *
	 * @return the business trip pk ID of this bt car rental info
	 */
	public long getBusinessTripPkId();

	/**
	 * Sets the business trip pk ID of this bt car rental info.
	 *
	 * @param businessTripPkId the business trip pk ID of this bt car rental info
	 */
	public void setBusinessTripPkId(long businessTripPkId);

	/**
	 * Returns the ticket no of this bt car rental info.
	 *
	 * @return the ticket no of this bt car rental info
	 */
	@AutoEscape
	public String getTicketNo();

	/**
	 * Sets the ticket no of this bt car rental info.
	 *
	 * @param ticketNo the ticket no of this bt car rental info
	 */
	public void setTicketNo(String ticketNo);

	/**
	 * Returns the pickup location of this bt car rental info.
	 *
	 * @return the pickup location of this bt car rental info
	 */
	@AutoEscape
	public String getPickupLocation();

	/**
	 * Sets the pickup location of this bt car rental info.
	 *
	 * @param pickupLocation the pickup location of this bt car rental info
	 */
	public void setPickupLocation(String pickupLocation);

	/**
	 * Returns the pickup date of this bt car rental info.
	 *
	 * @return the pickup date of this bt car rental info
	 */
	public Date getPickupDate();

	/**
	 * Sets the pickup date of this bt car rental info.
	 *
	 * @param pickupDate the pickup date of this bt car rental info
	 */
	public void setPickupDate(Date pickupDate);

	/**
	 * Returns the dropoff location of this bt car rental info.
	 *
	 * @return the dropoff location of this bt car rental info
	 */
	@AutoEscape
	public String getDropoffLocation();

	/**
	 * Sets the dropoff location of this bt car rental info.
	 *
	 * @param dropoffLocation the dropoff location of this bt car rental info
	 */
	public void setDropoffLocation(String dropoffLocation);

	/**
	 * Returns the dropoff date of this bt car rental info.
	 *
	 * @return the dropoff date of this bt car rental info
	 */
	public Date getDropoffDate();

	/**
	 * Sets the dropoff date of this bt car rental info.
	 *
	 * @param dropoffDate the dropoff date of this bt car rental info
	 */
	public void setDropoffDate(Date dropoffDate);

	/**
	 * Returns the car type of this bt car rental info.
	 *
	 * @return the car type of this bt car rental info
	 */
	@AutoEscape
	public String getCarType();

	/**
	 * Sets the car type of this bt car rental info.
	 *
	 * @param carType the car type of this bt car rental info
	 */
	public void setCarType(String carType);

	/**
	 * Returns the type of rental of this bt car rental info.
	 *
	 * @return the type of rental of this bt car rental info
	 */
	@AutoEscape
	public String getTypeOfRental();

	/**
	 * Sets the type of rental of this bt car rental info.
	 *
	 * @param typeOfRental the type of rental of this bt car rental info
	 */
	public void setTypeOfRental(String typeOfRental);

	/**
	 * Returns the price of this bt car rental info.
	 *
	 * @return the price of this bt car rental info
	 */
	public double getPrice();

	/**
	 * Sets the price of this bt car rental info.
	 *
	 * @param price the price of this bt car rental info
	 */
	public void setPrice(double price);

	/**
	 * Returns the currency of this bt car rental info.
	 *
	 * @return the currency of this bt car rental info
	 */
	@AutoEscape
	public String getCurrency();

	/**
	 * Sets the currency of this bt car rental info.
	 *
	 * @param currency the currency of this bt car rental info
	 */
	public void setCurrency(String currency);

	/**
	 * Returns the trip type of this bt car rental info.
	 *
	 * @return the trip type of this bt car rental info
	 */
	@AutoEscape
	public String getTripType();

	/**
	 * Sets the trip type of this bt car rental info.
	 *
	 * @param tripType the trip type of this bt car rental info
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
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.business.trip.model.BtCarRentalInfo> toCacheModel();

	@Override
	public com.business.trip.model.BtCarRentalInfo toEscapedModel();

	@Override
	public com.business.trip.model.BtCarRentalInfo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}