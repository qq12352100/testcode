package com.seatoffice.util;

public enum WorkLocationEnum {
	Beijing("Beijing", "01"), Changchun("Changchun", "02"), Guangzhou("Guangzhou", "03"), Tianjin("Tianjin", "04"),
	Yizheng("Yizheng", "05"), Nanjing("Nanjing", "06"), Shanghai("Shanghai", "07"), Chengdu("Chengdu", "08"),
	Changsha("Changsha", "09"), Foshan("Foshan", "10"), Hongkong("Hongkong", "11"), Ningbo("Ningbo", "12"),	
	Urumqi("Urumqi", "13"), Ingolstadt("Ingolstadt", "14"), Neckarsulm("Neckarsulm", "15"), Germany("Germany", "16"),
	Dalian("Dalian", "17"),Qingdao("Qingdao", "18");
	
	private String name;
	private String index;
	
	private WorkLocationEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}
	
	public static String getName(String index) {
		for (WorkLocationEnum c : WorkLocationEnum.values()) {
			if (c.getIndex().equals(index)) {
				return c.name;
			}
		}
		return "";
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
