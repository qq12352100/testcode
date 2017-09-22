package com.e.onboarding.util;

public enum EOnboardingLogEnum {
	APPLICANT(1, "HR Consulting"), ADMIN(97, "Admin"), SECURITY(98, "Security"),
	ITP(99, "ITP"), CONTROLLING_FINANCE(100, "Controlling/Finance");
	
	private int number;
	private String role;
	
	private EOnboardingLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (EOnboardingLogEnum c : EOnboardingLogEnum.values()) {
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
