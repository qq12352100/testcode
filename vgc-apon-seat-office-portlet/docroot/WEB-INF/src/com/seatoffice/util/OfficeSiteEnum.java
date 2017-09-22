package com.seatoffice.util;

public enum OfficeSiteEnum {
	SLT("Beijing-SLT", "01"), ACB("Beijing-ACB", "02"), INDIGO("Beijing-Indigo", "03"), VTA("Beijing-VTA", "04"),
	HLP("Beijing-HLP", "05"), CITY("Beijing-Audi City", "06"), TCB("Beijing-Audi TCB", "07"), ATA("Beijing-Audi ATA", "08"),
	DEALER("Beijing-Audi Dealer No.1", "09"), NA("N/A", "10"),EMPTY("","0");
	
	private String name;
	private String index;
	
	private OfficeSiteEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}
	
	public static String getName(String index) {
		for (OfficeSiteEnum c : OfficeSiteEnum.values()) {
			if (c.getIndex().equals(index)) {
				return c.name;
			}
		}
		return null;
	}
	public static String getIndex(String name) {
		for (OfficeSiteEnum c : OfficeSiteEnum.values()) {
			if (c.getName().equals(name)) {
				return c.index;
			}
		}
		return null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
}
