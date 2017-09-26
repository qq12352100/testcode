package com.business.trip.util;

public enum BusinessTripReimbursementLogEnum {
	APPLICANT(1, "Applicant"),SUPERVISOR(99,"Supervisor"),
	EVP(100,"EVP"),HEAD_CONTROLLING(101,"BR_Head of Controlling"),
	HRG(102,"BR_HRG");
	
	private int number;
	private String role;
	
	private BusinessTripReimbursementLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (BusinessTripReimbursementLogEnum c : BusinessTripReimbursementLogEnum.values()) {
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
