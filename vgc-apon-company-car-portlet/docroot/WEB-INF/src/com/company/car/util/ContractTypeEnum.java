package com.company.car.util;

public enum ContractTypeEnum {
	LOCAL("LOCAL", "1"), LE("LE", "5"), FSE4("FSE", "4"), FSE6("FSE", "6"),
	CONTRACTOR("Contractor", "9"), INTERN("Intern", "7");
	
	private String name;
	private String index;
	
	private ContractTypeEnum(String name, String index) {
		this.name = name;
		this.index = index;
	}
	
	public static String getName(String index) {
		for (ContractTypeEnum c : ContractTypeEnum.values()) {
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
