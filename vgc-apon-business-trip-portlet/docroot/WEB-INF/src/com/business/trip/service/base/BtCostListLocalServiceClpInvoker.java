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

import com.business.trip.service.BtCostListLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BtCostListLocalServiceClpInvoker {
	public BtCostListLocalServiceClpInvoker() {
		_methodName0 = "addBtCostList";

		_methodParameterTypes0 = new String[] {
				"com.business.trip.model.BtCostList"
			};

		_methodName1 = "createBtCostList";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBtCostList";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBtCostList";

		_methodParameterTypes3 = new String[] {
				"com.business.trip.model.BtCostList"
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

		_methodName10 = "fetchBtCostList";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBtCostList";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBtCostLists";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBtCostListsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBtCostList";

		_methodParameterTypes15 = new String[] {
				"com.business.trip.model.BtCostList"
			};

		_methodName80 = "getBeanIdentifier";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "setBeanIdentifier";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName86 = "findCountByBusinessTripPkId";

		_methodParameterTypes86 = new String[] { "long" };

		_methodName87 = "findByBusinessTripPkId";

		_methodParameterTypes87 = new String[] { "long", "int", "int" };

		_methodName88 = "findByB_C";

		_methodParameterTypes88 = new String[] { "long", "java.lang.String" };

		_methodName90 = "findSumByCurrency";

		_methodParameterTypes90 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};

		_methodName91 = "findSumEntertainmentByCurrency";

		_methodParameterTypes91 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};

		_methodName92 = "findSumInvoiceAmountByCurrency";

		_methodParameterTypes92 = new String[] { "long", "java.lang.String" };

		_methodName93 = "findEURPayByRMBByCurrency";

		_methodParameterTypes93 = new String[] { "long" };

		_methodName94 = "findSumNetAmountRmbByCurrency";

		_methodParameterTypes94 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};

		_methodName95 = "findSumTaxByCurrency";

		_methodParameterTypes95 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};

		_methodName96 = "isEntertainmentCondition";

		_methodParameterTypes96 = new String[] { "long", "int" };

		_methodName97 = "addCalculate";

		_methodParameterTypes97 = new String[] {
				"double", "java.lang.String", "double", "java.lang.String"
			};

		_methodName98 = "correctAmountRmbCostListOfHistoryData";

		_methodParameterTypes98 = new String[] { "long" };

		_methodName99 = "deleteCostListByBRPKId";

		_methodParameterTypes99 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BtCostListLocalServiceUtil.addBtCostList((com.business.trip.model.BtCostList)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BtCostListLocalServiceUtil.createBtCostList(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BtCostListLocalServiceUtil.deleteBtCostList(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BtCostListLocalServiceUtil.deleteBtCostList((com.business.trip.model.BtCostList)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BtCostListLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BtCostListLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BtCostListLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BtCostListLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BtCostListLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BtCostListLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BtCostListLocalServiceUtil.fetchBtCostList(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BtCostListLocalServiceUtil.getBtCostList(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BtCostListLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BtCostListLocalServiceUtil.getBtCostLists(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BtCostListLocalServiceUtil.getBtCostListsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BtCostListLocalServiceUtil.updateBtCostList((com.business.trip.model.BtCostList)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BtCostListLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			BtCostListLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return BtCostListLocalServiceUtil.findCountByBusinessTripPkId(((Long)arguments[0]).longValue());
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return BtCostListLocalServiceUtil.findByBusinessTripPkId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return BtCostListLocalServiceUtil.findByB_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return BtCostListLocalServiceUtil.findSumByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return BtCostListLocalServiceUtil.findSumEntertainmentByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return BtCostListLocalServiceUtil.findSumInvoiceAmountByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return BtCostListLocalServiceUtil.findEURPayByRMBByCurrency(((Long)arguments[0]).longValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return BtCostListLocalServiceUtil.findSumNetAmountRmbByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return BtCostListLocalServiceUtil.findSumTaxByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return BtCostListLocalServiceUtil.isEntertainmentCondition(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return BtCostListLocalServiceUtil.addCalculate(((Double)arguments[0]).doubleValue(),
				(java.lang.String)arguments[1],
				((Double)arguments[2]).doubleValue(),
				(java.lang.String)arguments[3]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			BtCostListLocalServiceUtil.correctAmountRmbCostListOfHistoryData(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			BtCostListLocalServiceUtil.deleteCostListByBRPKId(((Long)arguments[0]).longValue());

			return null;
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
	private String _methodName90;
	private String[] _methodParameterTypes90;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
}