package com.e.closing.common;

/**
 * Common Util
 * @author t.a.jiang
 *
 */
public enum EClosingEnum {
	HRCONSULTANT(1,"EC_HR Consultant"),	
	ADMINISTRATIONDEPARTMENT(101,"EC_Administration Department"),
	FLEETSERVICES(102,"EC_Fleet Services"),
	FSELECONSULTANT(103,"EC_FSE/LE Consultant"),	
	HRTRAININGDEPARTMENT(106,"EC_HR Training Department"),
	HRDEPARTMENT(107,"EC_HR Department"),
	FINANCEDEPARTMENT(108,"EC_Finance Department"),
	ITDEPARTMENT(105,"EC_IT Department"),
	SECURITY(104,"EC_Security"),
	SUPERVISOR(100,"EC_Supervisor");
	
	private int number;
	private String role;
	
	private EClosingEnum(int number, String role){
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		int result = 7;
		for (EClosingEnum e : EClosingEnum.values()) {
			if (e.getRole().equals(role)) {
				result = e.number;
			}
		}
		return result;
	}
	
	public static String getRole(int number) {
		String result = "";
		for (EClosingEnum e : EClosingEnum.values()) {
			if (e.getNumber() == number) {
				result = e.role;
			}
		}
		return result;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
