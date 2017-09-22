package com.e.transfer.util;

public enum ETransferLogEnum {
	APPLICANT(1, "ET HR Consultant"),CURRENT_DEPT_SUPERVISOR(99,"Current Dept. Supervisor"),
	RECEIVING_DEPT_SUPERVISOR(100,"Receiving Dept. Supervisor"),ORGATEAM(101,"ET Organization Partner"),
	CONSULTING_MANAGER(102,"ET Controlling Manager");
	
	private int number;
	private String role;
	
	private ETransferLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (ETransferLogEnum c : ETransferLogEnum.values()) {
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
