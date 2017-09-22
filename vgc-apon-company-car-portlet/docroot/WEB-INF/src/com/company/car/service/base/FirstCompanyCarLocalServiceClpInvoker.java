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

package com.company.car.service.base;

import com.company.car.service.FirstCompanyCarLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FirstCompanyCarLocalServiceClpInvoker {
	public FirstCompanyCarLocalServiceClpInvoker() {
		_methodName0 = "addFirstCompanyCar";

		_methodParameterTypes0 = new String[] {
				"com.company.car.model.FirstCompanyCar"
			};

		_methodName1 = "createFirstCompanyCar";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteFirstCompanyCar";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteFirstCompanyCar";

		_methodParameterTypes3 = new String[] {
				"com.company.car.model.FirstCompanyCar"
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

		_methodName10 = "fetchFirstCompanyCar";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getFirstCompanyCar";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getFirstCompanyCars";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getFirstCompanyCarsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateFirstCompanyCar";

		_methodParameterTypes15 = new String[] {
				"com.company.car.model.FirstCompanyCar"
			};

		_methodName46 = "getBeanIdentifier";

		_methodParameterTypes46 = new String[] {  };

		_methodName47 = "setBeanIdentifier";

		_methodParameterTypes47 = new String[] { "java.lang.String" };

		_methodName52 = "saveOrUpdateFirstCompanyCar";

		_methodParameterTypes52 = new String[] {
				"com.company.car.model.FirstCompanyCar",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName53 = "submitFirstCompanyCar";

		_methodParameterTypes53 = new String[] {
				"com.company.car.model.FirstCompanyCar",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName54 = "getCssContent";

		_methodParameterTypes54 = new String[] {  };

		_methodName55 = "getRoleName";

		_methodParameterTypes55 = new String[] { "long" };

		_methodName57 = "findSupervisorUser";

		_methodParameterTypes57 = new String[] {
				"com.company.car.model.FirstCompanyCar"
			};

		_methodName58 = "updateStatus";

		_methodParameterTypes58 = new String[] {
				"long", "long", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName59 = "findByS_U";

		_methodParameterTypes59 = new String[] { "int", "long" };

		_methodName60 = "saveOrUpdateAuditTrailLog";

		_methodParameterTypes60 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName61 = "getOperationNo";

		_methodParameterTypes61 = new String[] { "java.util.List" };

		_methodName62 = "getOperationUserByRoleName";

		_methodParameterTypes62 = new String[] { "long", "java.lang.String" };

		_methodName63 = "updateFirstCompanyCar";

		_methodParameterTypes63 = new String[] {
				"com.company.car.model.FirstCompanyCar",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName64 = "findDrivingLicenseInformation";

		_methodParameterTypes64 = new String[] {
				"com.company.car.model.FirstCompanyCar", "java.util.Locale"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.addFirstCompanyCar((com.company.car.model.FirstCompanyCar)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.createFirstCompanyCar(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.deleteFirstCompanyCar(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.deleteFirstCompanyCar((com.company.car.model.FirstCompanyCar)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.fetchFirstCompanyCar(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getFirstCompanyCar(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getFirstCompanyCars(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getFirstCompanyCarsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.updateFirstCompanyCar((com.company.car.model.FirstCompanyCar)arguments[0]);
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			FirstCompanyCarLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.saveOrUpdateFirstCompanyCar((com.company.car.model.FirstCompanyCar)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.submitFirstCompanyCar((com.company.car.model.FirstCompanyCar)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getCssContent();
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getRoleName(((Long)arguments[0]).longValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.findSupervisorUser((com.company.car.model.FirstCompanyCar)arguments[0]);
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.findByS_U(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			FirstCompanyCarLocalServiceUtil.saveOrUpdateAuditTrailLog(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);

			return null;
		}

		if (_methodName61.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getOperationNo((java.util.List<com.audit.trail.model.AuditTrailLog>)arguments[0]);
		}

		if (_methodName62.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.getOperationUserByRoleName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName63.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.updateFirstCompanyCar((com.company.car.model.FirstCompanyCar)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName64.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
			return FirstCompanyCarLocalServiceUtil.findDrivingLicenseInformation((com.company.car.model.FirstCompanyCar)arguments[0],
				(java.util.Locale)arguments[1]);
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
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
}