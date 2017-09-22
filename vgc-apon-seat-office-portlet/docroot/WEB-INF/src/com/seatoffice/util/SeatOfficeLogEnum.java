package com.seatoffice.util;

public enum SeatOfficeLogEnum {
	APPLICANT(1, "Applicant"), 
	ADMINSEAT(98, "SO_Admin Seat Management"),
	SUPERVISOR(101, "Supervisor"),
	HeadADMIN(102, "SO_Head of Admin"),
	ADMINSEAT1(103, "SO_Admin Seat Management");
	
	private int number;
	private String role;
	
	private SeatOfficeLogEnum(int number, String role) {
		this.number = number;
		this.role = role;
	}
	
	public static int getNumber(String role) {
		for (SeatOfficeLogEnum c : SeatOfficeLogEnum.values()) {
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
