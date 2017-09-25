package com.e.leave.util;

public enum ELeaveLogEnum {
	APPLICANT(1, "Applicant"),SUPERVISOR(99,"Supervisor"),
	LEAVE_COORDINATOR(100,"EL Leave Coordinator");
	
	private int number;
	private String role;
	
	private ELeaveLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (ELeaveLogEnum c : ELeaveLogEnum.values()) {
			if (c.getRole().equals(role)) {
				return c.number;
			}
		}
		return 7;
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
