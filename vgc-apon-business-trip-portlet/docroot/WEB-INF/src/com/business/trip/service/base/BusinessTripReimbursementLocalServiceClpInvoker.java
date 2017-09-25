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

import com.business.trip.service.BusinessTripReimbursementLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class BusinessTripReimbursementLocalServiceClpInvoker {
	public BusinessTripReimbursementLocalServiceClpInvoker() {
		_methodName0 = "addBusinessTripReimbursement";

		_methodParameterTypes0 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement"
			};

		_methodName1 = "createBusinessTripReimbursement";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBusinessTripReimbursement";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBusinessTripReimbursement";

		_methodParameterTypes3 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement"
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

		_methodName10 = "fetchBusinessTripReimbursement";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBusinessTripReimbursement";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBusinessTripReimbursements";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBusinessTripReimbursementsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBusinessTripReimbursement";

		_methodParameterTypes15 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement"
			};

		_methodName80 = "getBeanIdentifier";

		_methodParameterTypes80 = new String[] {  };

		_methodName81 = "setBeanIdentifier";

		_methodParameterTypes81 = new String[] { "java.lang.String" };

		_methodName86 = "reimbursementTravelForReport";

		_methodParameterTypes86 = new String[] {
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String"
			};

		_methodName87 = "saveOrUpdateBusinessTripReimbursement";

		_methodParameterTypes87 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName88 = "submitBusinessTripReimbursement";

		_methodParameterTypes88 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement",
				"com.liferay.portal.service.ServiceContext", "boolean"
			};

		_methodName90 = "paymentCompletedSendEmailtoApplicant";

		_methodParameterTypes90 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement"
			};

		_methodName91 = "updateStatus";

		_methodParameterTypes91 = new String[] {
				"long", "long", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName92 = "findByS_U";

		_methodParameterTypes92 = new String[] { "int", "long" };

		_methodName93 = "findByBussinessTirpTicketNo";

		_methodParameterTypes93 = new String[] { "java.lang.String" };

		_methodName94 = "saveOrUpdateAuditTrailLog";

		_methodParameterTypes94 = new String[] {
				"long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName95 = "findEmailsOfPendingApprover";

		_methodParameterTypes95 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement"
			};

		_methodName97 = "getRoleTrailLogName";

		_methodParameterTypes97 = new String[] { "java.lang.String" };

		_methodName98 = "getCurrentOperationNo";

		_methodParameterTypes98 = new String[] { "java.util.List" };

		_methodName99 = "getOperationNo";

		_methodParameterTypes99 = new String[] { "java.util.List" };

		_methodName100 = "getOperationUserByRoleName";

		_methodParameterTypes100 = new String[] { "long", "java.lang.String" };

		_methodName101 = "getCssContent";

		_methodParameterTypes101 = new String[] {  };

		_methodName102 = "getDDNames";

		_methodParameterTypes102 = new String[] {
				"com.business.trip.model.BusinessTripReimbursement"
			};

		_methodName103 = "findCountByS_U_SAP";

		_methodParameterTypes103 = new String[] {
				"int", "java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName104 = "findRejectCountByS_U_SAP";

		_methodParameterTypes104 = new String[] {
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName105 = "findByS_U_SAP";

		_methodParameterTypes105 = new String[] {
				"int", "java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName106 = "findRejectByS_U_SAP";

		_methodParameterTypes106 = new String[] {
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "int"
			};

		_methodName107 = "updateSAPStatusAsSAPInfo";

		_methodParameterTypes107 = new String[] {
				"java.util.List", "com.liferay.portal.service.ServiceContext"
			};

		_methodName108 = "updateSAPStatus";

		_methodParameterTypes108 = new String[] {
				"long", "int", "com.liferay.portal.service.ServiceContext",
				"java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.addBusinessTripReimbursement((com.business.trip.model.BusinessTripReimbursement)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.createBusinessTripReimbursement(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.deleteBusinessTripReimbursement(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.deleteBusinessTripReimbursement((com.business.trip.model.BusinessTripReimbursement)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.fetchBusinessTripReimbursement(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getBusinessTripReimbursement(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getBusinessTripReimbursements(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getBusinessTripReimbursementsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.updateBusinessTripReimbursement((com.business.trip.model.BusinessTripReimbursement)arguments[0]);
		}

		if (_methodName80.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes80, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName81.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes81, parameterTypes)) {
			BusinessTripReimbursementLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.reimbursementTravelForReport((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName87.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes87, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.saveOrUpdateBusinessTripReimbursement((com.business.trip.model.BusinessTripReimbursement)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName88.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes88, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.submitBusinessTripReimbursement((com.business.trip.model.BusinessTripReimbursement)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1],
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName90.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes90, parameterTypes)) {
			BusinessTripReimbursementLocalServiceUtil.paymentCompletedSendEmailtoApplicant((com.business.trip.model.BusinessTripReimbursement)arguments[0]);

			return null;
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findByS_U(((Integer)arguments[0]).intValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findByBussinessTirpTicketNo((java.lang.String)arguments[0]);
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			BusinessTripReimbursementLocalServiceUtil.saveOrUpdateAuditTrailLog(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6]);

			return null;
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findEmailsOfPendingApprover((com.business.trip.model.BusinessTripReimbursement)arguments[0]);
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getRoleTrailLogName((java.lang.String)arguments[0]);
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getCurrentOperationNo((java.util.List<com.audit.trail.model.AuditTrailLog>)arguments[0]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getOperationNo((java.util.List<com.audit.trail.model.AuditTrailLog>)arguments[0]);
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getOperationUserByRoleName(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getCssContent();
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.getDDNames((com.business.trip.model.BusinessTripReimbursement)arguments[0]);
		}

		if (_methodName103.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes103, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findCountByS_U_SAP(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6]);
		}

		if (_methodName104.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes104, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findRejectCountByS_U_SAP((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName105.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes105, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findByS_U_SAP(((Integer)arguments[0]).intValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				(java.lang.String)arguments[4], (java.lang.String)arguments[5],
				(java.lang.String)arguments[6],
				((Integer)arguments[7]).intValue(),
				((Integer)arguments[8]).intValue());
		}

		if (_methodName106.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes106, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.findRejectByS_U_SAP((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5],
				((Integer)arguments[6]).intValue(),
				((Integer)arguments[7]).intValue());
		}

		if (_methodName107.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes107, parameterTypes)) {
			BusinessTripReimbursementLocalServiceUtil.updateSAPStatusAsSAPInfo((java.util.List<java.util.Map<java.lang.String, java.lang.Object>>)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName108.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes108, parameterTypes)) {
			return BusinessTripReimbursementLocalServiceUtil.updateSAPStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
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
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
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
	private String _methodName108;
	private String[] _methodParameterTypes108;
}