package com.seatoffice.util;

public enum SeatOfficeCategoryEnum {
	Workstation(1, "Workstation"), 
	TwinOffice(2, "Twin Office"),
	SingleOffice(3, "Single Office"),
	TeamLeaderSeat(4, "Team Leader Seat(ACB)");
	
	private long number;
	private String category;
	
	private SeatOfficeCategoryEnum(long number, String category) {
		this.number = number;
		this.category = category;
	}
	
	public static long getNumber(String category) {
		for (SeatOfficeCategoryEnum c : SeatOfficeCategoryEnum.values()) {
			if (c.getCategory().equals(category)) {
				return c.number;
			}
		}
		return 7;
	}
	public static String getCategory(long num) {
		for (SeatOfficeCategoryEnum c : SeatOfficeCategoryEnum.values()) {
			if (c.getNumber()==num) {
				return c.category;
			}
		}
		return "";
	}
	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
