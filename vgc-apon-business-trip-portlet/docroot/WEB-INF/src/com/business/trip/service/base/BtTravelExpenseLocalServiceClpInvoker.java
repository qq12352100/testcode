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

import com.business.trip.service.BtTravelExpenseLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BtTravelExpenseLocalServiceClpInvoker {
	public BtTravelExpenseLocalServiceClpInvoker() {
		_methodName0 = "addBtTravelExpense";

		_methodParameterTypes0 = new String[] {
				"com.business.trip.model.BtTravelExpense"
			};

		_methodName1 = "createBtTravelExpense";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBtTravelExpense";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBtTravelExpense";

		_methodParameterTypes3 = new String[] {
				"com.business.trip.model.BtTravelExpense"
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

		_methodName10 = "fetchBtTravelExpense";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBtTravelExpense";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBtTravelExpenses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBtTravelExpensesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBtTravelExpense";

		_methodParameterTypes15 = new String[] {
				"com.business.trip.model.BtTravelExpense"
			};

		_methodName80 = "getBeanIdentifier";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "setBeanIdentifier";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName86 = "findCountByB_T";

		_methodParameterTypes86 = new String[] { "long", "java.lang.String" };

		_methodName87 = "findByB_T";

		_methodParameterTypes87 = new String[] {
				"long", "java.lang.String", "int", "int"
			};

		_methodName88 = "findByB_C";

		_methodParameterTypes88 = new String[] { "long", "java.lang.String" };

		_methodName89 = "findAll";

		_methodParameterTypes89 = new String[] {  };

		_methodName90 = "findSumByCurrency";

		_methodParameterTypes90 = new String[] { "long", "java.lang.String" };

		_methodName91 = "findSumInRMBByCurrency";

		_methodParameterTypes91 = new String[] { "long", "java.lang.String" };

		_methodName92 = "copyBtTravelExpenseByB_T";

		_methodParameterTypes92 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName93 = "deleteBtTravelExpenseByB_T";

		_methodParameterTypes93 = new String[] { "long", "java.lang.String" };

		_methodName94 = "getDomesticBusinessTripReimbursementTravelExpenses";

		_methodParameterTypes94 = new String[] {
				"java.lang.String", "java.lang.String", "int", "int"
			};

		_methodName95 = "getDomesticBusinessTripReimbursementTravelExpensesCount";

		_methodParameterTypes95 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName96 = "getTravelExpenseStartOrEndDate";

		_methodParameterTypes96 = new String[] { "long", "int" };

		_methodName97 = "getTravelExpense";

		_methodParameterTypes97 = new String[] { "long" };

		_methodName98 = "getAllowance";

		_methodParameterTypes98 = new String[] {
				"java.lang.String", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.lang.String", "double", "boolean",
				"boolean", "boolean"
			};

		_methodName102 = "correctAmountRmbDAOfHistoryData";

		_methodParameterTypes102 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.addBtTravelExpense((com.business.trip.model.BtTravelExpense)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.createBtTravelExpense(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.deleteBtTravelExpense(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.deleteBtTravelExpense((com.business.trip.model.BtTravelExpense)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.fetchBtTravelExpense(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getBtTravelExpense(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getBtTravelExpenses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getBtTravelExpensesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.updateBtTravelExpense((com.business.trip.model.BtTravelExpense)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			BtTravelExpenseLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.findCountByB_T(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.findByB_T(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.findByB_C(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName89.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes89, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.findAll();
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.findSumByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.findSumInRMBByCurrency(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			BtTravelExpenseLocalServiceUtil.copyBtTravelExpenseByB_T(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			BtTravelExpenseLocalServiceUtil.deleteBtTravelExpenseByB_T(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getDomesticBusinessTripReimbursementTravelExpenses((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getDomesticBusinessTripReimbursementTravelExpensesCount((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getTravelExpenseStartOrEndDate(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getTravelExpense(((Long)arguments[0]).longValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return BtTravelExpenseLocalServiceUtil.getAllowance((java.lang.String)arguments[0],
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Double)arguments[5]).doubleValue(),
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				((Boolean)arguments[8]).booleanValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			BtTravelExpenseLocalServiceUtil.correctAmountRmbDAOfHistoryData(((Long)arguments[0]).longValue());

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
	private String _methodName89;
	private String[] _methodParameterTypes89;
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
	private String _methodName102;
	private String[] _methodParameterTypes102;
}