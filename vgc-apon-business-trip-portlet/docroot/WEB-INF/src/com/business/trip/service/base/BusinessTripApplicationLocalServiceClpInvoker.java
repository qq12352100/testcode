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

import com.business.trip.service.BusinessTripApplicationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BusinessTripApplicationLocalServiceClpInvoker {
	public BusinessTripApplicationLocalServiceClpInvoker() {
		_methodName0 = "addBusinessTripApplication";

		_methodParameterTypes0 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
			};

		_methodName1 = "createBusinessTripApplication";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBusinessTripApplication";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBusinessTripApplication";

		_methodParameterTypes3 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
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

		_methodName10 = "fetchBusinessTripApplication";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBusinessTripApplication";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBusinessTripApplications";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBusinessTripApplicationsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBusinessTripApplication";

		_methodParameterTypes15 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
			};

		_methodName80 = "getBeanIdentifier";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "setBeanIdentifier";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName86 = "saveOrUpdateBusinessTripApplication";

		_methodParameterTypes86 = new String[] {
				"com.business.trip.model.BusinessTripApplication",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName87 = "preValidate";

		_methodParameterTypes87 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
			};

		_methodName88 = "submitBusinessTripApplication";

		_methodParameterTypes88 = new String[] {
				"com.business.trip.model.BusinessTripApplication",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName90 = "sendEmailtoApprover";

		_methodParameterTypes90 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
			};

		_methodName91 = "findEmailsOfPendingApprover";

		_methodParameterTypes91 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
			};

		_methodName92 = "updateStatus";

		_methodParameterTypes92 = new String[] {
				"long", "long", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName93 = "findByS_U";

		_methodParameterTypes93 = new String[] { "int", "long" };

		_methodName94 = "findByStatus";

		_methodParameterTypes94 = new String[] { "int" };

		_methodName95 = "saveOrUpdateAuditTrailLog";

		_methodParameterTypes95 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName96 = "getOperationNo";

		_methodParameterTypes96 = new String[] { "java.util.List" };

		_methodName101 = "getOperationUserByRoleName";

		_methodParameterTypes101 = new String[] { "long", "java.lang.String" };

		_methodName102 = "searchBusinessTripApplicationByTicketNo";

		_methodParameterTypes102 = new String[] { "java.lang.String" };

		_methodName103 = "getBusinessTripApplicationByTicketNo";

		_methodParameterTypes103 = new String[] { "java.lang.String" };

		_methodName104 = "getCssContent";

		_methodParameterTypes104 = new String[] {  };

		_methodName105 = "getDDNames";

		_methodParameterTypes105 = new String[] {
				"com.business.trip.model.BusinessTripApplication"
			};

		_methodName106 = "updateSAPStatusAsSAPInfo";

		_methodParameterTypes106 = new String[] {
				"java.util.List", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName107 = "updateSAPStatus";

		_methodParameterTypes107 = new String[] {
				"long", "int", "com.liferay.portal.service.ServiceContext",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName110 = "findCountByS_U_SAP";

		_methodParameterTypes110 = new String[] {
				"int", "java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName111 = "findByS_U_SAP";

		_methodParameterTypes111 = new String[] {
				"int", "java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName113 = "findByT_P_S_P";

		_methodParameterTypes113 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "int", "int"
			};

		_methodName114 = "findCountByT_P_S_P";

		_methodParameterTypes114 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long"
			};

		_methodName115 = "fetchBusinessTripApplicationByTicketNo";

		_methodParameterTypes115 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.addBusinessTripApplication((com.business.trip.model.BusinessTripApplication)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.createBusinessTripApplication(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.deleteBusinessTripApplication(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.deleteBusinessTripApplication((com.business.trip.model.BusinessTripApplication)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplication(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getBusinessTripApplication(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getBusinessTripApplications(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getBusinessTripApplicationsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.updateBusinessTripApplication((com.business.trip.model.BusinessTripApplication)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			BusinessTripApplicationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.saveOrUpdateBusinessTripApplication((com.business.trip.model.BusinessTripApplication)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.preValidate((com.business.trip.model.BusinessTripApplication)arguments[0]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.submitBusinessTripApplication((com.business.trip.model.BusinessTripApplication)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			BusinessTripApplicationLocalServiceUtil.sendEmailtoApprover((com.business.trip.model.BusinessTripApplication)arguments[0]);

			return null;
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findEmailsOfPendingApprover((com.business.trip.model.BusinessTripApplication)arguments[0]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findByS_U(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findByStatus(((Integer)arguments[0]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			BusinessTripApplicationLocalServiceUtil.saveOrUpdateAuditTrailLog(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6]);

			return null;
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getOperationNo((java.util.List<com.audit.trail.model.AuditTrailLog>)arguments[0]);
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getOperationUserByRoleName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.searchBusinessTripApplicationByTicketNo((java.lang.String)arguments[0]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getBusinessTripApplicationByTicketNo((java.lang.String)arguments[0]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getCssContent();
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.getDDNames((com.business.trip.model.BusinessTripApplication)arguments[0]);
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			BusinessTripApplicationLocalServiceUtil.updateSAPStatusAsSAPInfo((java.util.List<java.util.Map<java.lang.String, java.lang.Object>>)arguments[0],
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.updateSAPStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findCountByS_U_SAP(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6]);
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findByS_U_SAP(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

		if (_methodName113.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes113, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findByT_P_S_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName114.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes114, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.findCountByT_P_S_P((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], ((Long)arguments[4]).longValue());
		}

		if (_methodName115.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes115, parameterTypes)) {
			return BusinessTripApplicationLocalServiceUtil.fetchBusinessTripApplicationByTicketNo((java.lang.String)arguments[0]);
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
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
	private String _methodName103;
	private String[] _methodParameterTypes103;
	private String _methodName104;
	private String[] _methodParameterTypes104;
	private String _methodName105;
	private String[] _methodParameterTypes105;
	private String _methodName106;
	private String[] _methodParameterTypes106;
	private String _methodName107;
	private String[] _methodParameterTypes107;
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName113;
	private String[] _methodParameterTypes113;
	private String _methodName114;
	private String[] _methodParameterTypes114;
	private String _methodName115;
	private String[] _methodParameterTypes115;
}