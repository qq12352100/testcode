package com.company.car.util;

public enum SecondCompanyCarLogEnum {
	APPLICANT(1, "Applicant"), SUPERVISOR(99, "Supervisor"), ADMIN(100, "Admin/FSE Coordination with China");
	
	private int number;
	private String role;
	
	private SecondCompanyCarLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (SecondCompanyCarLogEnum c : SecondCompanyCarLogEnum.values()) {
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
