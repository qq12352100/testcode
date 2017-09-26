package com.business.trip.util;

public enum BusinessTripApplicationLogEnum {
	APPLICANT(1, "Applicant"), 
	SUPERVISOR(101, "Supervisor"), 
	DEPARTMENT_LEAD(102, "Department Lead"),
	EVP(103, "EVP"),
	APP(104, "Applicant"), 
	HEAD_OF_CONTROLLING(105, "Head of Controlling"),
	ACCOUNTING(106, "Accounting");
	
	private int number;
	private String role;
	
	private BusinessTripApplicationLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (BusinessTripApplicationLogEnum c : BusinessTripApplicationLogEnum.values()) {
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
