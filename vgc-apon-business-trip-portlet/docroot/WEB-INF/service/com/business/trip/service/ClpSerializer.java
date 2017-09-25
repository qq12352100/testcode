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

package com.business.trip.service;

import com.business.trip.model.BtCarRentalInfoClp;
import com.business.trip.model.BtCostListClp;
import com.business.trip.model.BtEntertainmentDetailClp;
import com.business.trip.model.BtExchangeRateClp;
import com.business.trip.model.BtExchangeSAPRateClp;
import com.business.trip.model.BtFlightTrainInfoClp;
import com.business.trip.model.BtHotelInfoClp;
import com.business.trip.model.BtReimbursementSAPInfoClp;
import com.business.trip.model.BtTrainInfoClp;
import com.business.trip.model.BtTravelExpenseClp;
import com.business.trip.model.BusinessTripApplicationClp;
import com.business.trip.model.BusinessTripReimbursementClp;
import com.business.trip.model.RateCityClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"vgc-apon-business-trip-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"vgc-apon-business-trip-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "vgc-apon-business-trip-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BtCarRentalInfoClp.class.getName())) {
			return translateInputBtCarRentalInfo(oldModel);
		}

		if (oldModelClassName.equals(BtCostListClp.class.getName())) {
			return translateInputBtCostList(oldModel);
		}

		if (oldModelClassName.equals(BtEntertainmentDetailClp.class.getName())) {
			return translateInputBtEntertainmentDetail(oldModel);
		}

		if (oldModelClassName.equals(BtExchangeRateClp.class.getName())) {
			return translateInputBtExchangeRate(oldModel);
		}

		if (oldModelClassName.equals(BtExchangeSAPRateClp.class.getName())) {
			return translateInputBtExchangeSAPRate(oldModel);
		}

		if (oldModelClassName.equals(BtFlightTrainInfoClp.class.getName())) {
			return translateInputBtFlightTrainInfo(oldModel);
		}

		if (oldModelClassName.equals(BtHotelInfoClp.class.getName())) {
			return translateInputBtHotelInfo(oldModel);
		}

		if (oldModelClassName.equals(BtReimbursementSAPInfoClp.class.getName())) {
			return translateInputBtReimbursementSAPInfo(oldModel);
		}

		if (oldModelClassName.equals(BtTrainInfoClp.class.getName())) {
			return translateInputBtTrainInfo(oldModel);
		}

		if (oldModelClassName.equals(BtTravelExpenseClp.class.getName())) {
			return translateInputBtTravelExpense(oldModel);
		}

		if (oldModelClassName.equals(BusinessTripApplicationClp.class.getName())) {
			return translateInputBusinessTripApplication(oldModel);
		}

		if (oldModelClassName.equals(
					BusinessTripReimbursementClp.class.getName())) {
			return translateInputBusinessTripReimbursement(oldModel);
		}

		if (oldModelClassName.equals(RateCityClp.class.getName())) {
			return translateInputRateCity(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputBtCarRentalInfo(BaseModel<?> oldModel) {
		BtCarRentalInfoClp oldClpModel = (BtCarRentalInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtCarRentalInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtCostList(BaseModel<?> oldModel) {
		BtCostListClp oldClpModel = (BtCostListClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtCostListRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtEntertainmentDetail(
		BaseModel<?> oldModel) {
		BtEntertainmentDetailClp oldClpModel = (BtEntertainmentDetailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtEntertainmentDetailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtExchangeRate(BaseModel<?> oldModel) {
		BtExchangeRateClp oldClpModel = (BtExchangeRateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtExchangeRateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtExchangeSAPRate(BaseModel<?> oldModel) {
		BtExchangeSAPRateClp oldClpModel = (BtExchangeSAPRateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtExchangeSAPRateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtFlightTrainInfo(BaseModel<?> oldModel) {
		BtFlightTrainInfoClp oldClpModel = (BtFlightTrainInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtFlightTrainInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtHotelInfo(BaseModel<?> oldModel) {
		BtHotelInfoClp oldClpModel = (BtHotelInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtHotelInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtReimbursementSAPInfo(
		BaseModel<?> oldModel) {
		BtReimbursementSAPInfoClp oldClpModel = (BtReimbursementSAPInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtReimbursementSAPInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtTrainInfo(BaseModel<?> oldModel) {
		BtTrainInfoClp oldClpModel = (BtTrainInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtTrainInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBtTravelExpense(BaseModel<?> oldModel) {
		BtTravelExpenseClp oldClpModel = (BtTravelExpenseClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBtTravelExpenseRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBusinessTripApplication(
		BaseModel<?> oldModel) {
		BusinessTripApplicationClp oldClpModel = (BusinessTripApplicationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBusinessTripApplicationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBusinessTripReimbursement(
		BaseModel<?> oldModel) {
		BusinessTripReimbursementClp oldClpModel = (BusinessTripReimbursementClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBusinessTripReimbursementRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputRateCity(BaseModel<?> oldModel) {
		RateCityClp oldClpModel = (RateCityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getRateCityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtCarRentalInfoImpl")) {
			return translateOutputBtCarRentalInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtCostListImpl")) {
			return translateOutputBtCostList(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtEntertainmentDetailImpl")) {
			return translateOutputBtEntertainmentDetail(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtExchangeRateImpl")) {
			return translateOutputBtExchangeRate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtExchangeSAPRateImpl")) {
			return translateOutputBtExchangeSAPRate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtFlightTrainInfoImpl")) {
			return translateOutputBtFlightTrainInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtHotelInfoImpl")) {
			return translateOutputBtHotelInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtReimbursementSAPInfoImpl")) {
			return translateOutputBtReimbursementSAPInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtTrainInfoImpl")) {
			return translateOutputBtTrainInfo(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BtTravelExpenseImpl")) {
			return translateOutputBtTravelExpense(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BusinessTripApplicationImpl")) {
			return translateOutputBusinessTripApplication(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.BusinessTripReimbursementImpl")) {
			return translateOutputBusinessTripReimbursement(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.business.trip.model.impl.RateCityImpl")) {
			return translateOutputRateCity(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.business.trip.NoSuchBtCarRentalInfoException")) {
			return new com.business.trip.NoSuchBtCarRentalInfoException();
		}

		if (className.equals("com.business.trip.NoSuchBtCostListException")) {
			return new com.business.trip.NoSuchBtCostListException();
		}

		if (className.equals(
					"com.business.trip.NoSuchBtEntertainmentDetailException")) {
			return new com.business.trip.NoSuchBtEntertainmentDetailException();
		}

		if (className.equals("com.business.trip.NoSuchBtExchangeRateException")) {
			return new com.business.trip.NoSuchBtExchangeRateException();
		}

		if (className.equals(
					"com.business.trip.NoSuchBtExchangeSAPRateException")) {
			return new com.business.trip.NoSuchBtExchangeSAPRateException();
		}

		if (className.equals(
					"com.business.trip.NoSuchBtFlightTrainInfoException")) {
			return new com.business.trip.NoSuchBtFlightTrainInfoException();
		}

		if (className.equals("com.business.trip.NoSuchBtHotelInfoException")) {
			return new com.business.trip.NoSuchBtHotelInfoException();
		}

		if (className.equals(
					"com.business.trip.NoSuchBtReimbursementSAPInfoException")) {
			return new com.business.trip.NoSuchBtReimbursementSAPInfoException();
		}

		if (className.equals("com.business.trip.NoSuchBtTrainInfoException")) {
			return new com.business.trip.NoSuchBtTrainInfoException();
		}

		if (className.equals("com.business.trip.NoSuchBtTravelExpenseException")) {
			return new com.business.trip.NoSuchBtTravelExpenseException();
		}

		if (className.equals(
					"com.business.trip.NoSuchBusinessTripApplicationException")) {
			return new com.business.trip.NoSuchBusinessTripApplicationException();
		}

		if (className.equals(
					"com.business.trip.NoSuchBusinessTripReimbursementException")) {
			return new com.business.trip.NoSuchBusinessTripReimbursementException();
		}

		if (className.equals("com.business.trip.NoSuchRateCityException")) {
			return new com.business.trip.NoSuchRateCityException();
		}

		return throwable;
	}

	public static Object translateOutputBtCarRentalInfo(BaseModel<?> oldModel) {
		BtCarRentalInfoClp newModel = new BtCarRentalInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtCarRentalInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtCostList(BaseModel<?> oldModel) {
		BtCostListClp newModel = new BtCostListClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtCostListRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtEntertainmentDetail(
		BaseModel<?> oldModel) {
		BtEntertainmentDetailClp newModel = new BtEntertainmentDetailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtEntertainmentDetailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtExchangeRate(BaseModel<?> oldModel) {
		BtExchangeRateClp newModel = new BtExchangeRateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtExchangeRateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtExchangeSAPRate(BaseModel<?> oldModel) {
		BtExchangeSAPRateClp newModel = new BtExchangeSAPRateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtExchangeSAPRateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtFlightTrainInfo(BaseModel<?> oldModel) {
		BtFlightTrainInfoClp newModel = new BtFlightTrainInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtFlightTrainInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtHotelInfo(BaseModel<?> oldModel) {
		BtHotelInfoClp newModel = new BtHotelInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtHotelInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtReimbursementSAPInfo(
		BaseModel<?> oldModel) {
		BtReimbursementSAPInfoClp newModel = new BtReimbursementSAPInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtReimbursementSAPInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtTrainInfo(BaseModel<?> oldModel) {
		BtTrainInfoClp newModel = new BtTrainInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtTrainInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBtTravelExpense(BaseModel<?> oldModel) {
		BtTravelExpenseClp newModel = new BtTravelExpenseClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBtTravelExpenseRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBusinessTripApplication(
		BaseModel<?> oldModel) {
		BusinessTripApplicationClp newModel = new BusinessTripApplicationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBusinessTripApplicationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBusinessTripReimbursement(
		BaseModel<?> oldModel) {
		BusinessTripReimbursementClp newModel = new BusinessTripReimbursementClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBusinessTripReimbursementRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputRateCity(BaseModel<?> oldModel) {
		RateCityClp newModel = new RateCityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setRateCityRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}