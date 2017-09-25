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

package com.business.trip.service.base;

import com.business.trip.service.BtExchangeRateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BtExchangeRateLocalServiceClpInvoker {
	public BtExchangeRateLocalServiceClpInvoker() {
		_methodName0 = "addBtExchangeRate";

		_methodParameterTypes0 = new String[] {
				"com.business.trip.model.BtExchangeRate"
			};

		_methodName1 = "createBtExchangeRate";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBtExchangeRate";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBtExchangeRate";

		_methodParameterTypes3 = new String[] {
				"com.business.trip.model.BtExchangeRate"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchBtExchangeRate";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBtExchangeRate";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBtExchangeRates";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBtExchangeRatesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBtExchangeRate";

		_methodParameterTypes15 = new String[] {
				"com.business.trip.model.BtExchangeRate"
			};

		_methodName80 = "getBeanIdentifier";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "setBeanIdentifier";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName86 = "fetchByF_S_S";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "java.lang.String", "int"
			};

		_methodName87 = "fetchByS";

		_methodParameterTypes87 = new String[] { "int" };

		_methodName88 = "changeEURToRMB";

		_methodParameterTypes88 = new String[] { "double" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.addBtExchangeRate((com.business.trip.model.BtExchangeRate)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.createBtExchangeRate(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.deleteBtExchangeRate(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.deleteBtExchangeRate((com.business.trip.model.BtExchangeRate)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.fetchBtExchangeRate(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.getBtExchangeRate(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.getBtExchangeRates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.getBtExchangeRatesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.updateBtExchangeRate((com.business.trip.model.BtExchangeRate)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			BtExchangeRateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.fetchByF_S_S((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.fetchByS(((Integer)arguments[0]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return BtExchangeRateLocalServiceUtil.changeEURToRMB(((Double)arguments[0]).doubleValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName87;
	private String[] _methodParameterTypes87;
	private String _methodName88;
	private String[] _methodParameterTypes88;
}