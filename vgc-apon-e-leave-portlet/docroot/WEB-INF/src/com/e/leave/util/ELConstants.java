package com.e.leave.util;

/**
* 
* @author Du Shou Liang
*/

public class ELConstants {
	public static final String PROCESS_TYPE = "For All Employees";

	public static final String SUB_TYPE_E_LEAVE = "E-Leave Application";
	
	public static String getTypeOfLeaveCode(String typeOfLeaveTxt) {
		String typeOfLeaveId="";
		if("Annual Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0100";
		}else if("Sick Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0120";
		}else if("Sick Leave (GE)".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0121";
		}else if("Study Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0122";
		}else if("Marriage Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0140";
		}else if("Maternity Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0300";
		}else if("Maternity Leave (GE)".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0301";
		}else if("Paternity Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0400";
		}else if("Bereavement Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0200";
		}else if("Service Award Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0124";
		}else if("Overtime Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0130";
		}else if("Home office-Case group1".equals(typeOfLeaveTxt)){
			typeOfLeaveId="9001";
		}else if("Home office-Case group2".equals(typeOfLeaveTxt)){
			typeOfLeaveId="9002";
		}else if("Home office-Case group3".equals(typeOfLeaveTxt)){
			typeOfLeaveId="9003";
		}else if("Home office-Case group4".equals(typeOfLeaveTxt)){
			typeOfLeaveId="9004";
		}else if("Medical Treatment Period".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0800";
		}else if("Unpaid Leave".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0900";
		}else if("Others".equals(typeOfLeaveTxt)){
			typeOfLeaveId="0123";
		}
		return typeOfLeaveId;
	}
}
