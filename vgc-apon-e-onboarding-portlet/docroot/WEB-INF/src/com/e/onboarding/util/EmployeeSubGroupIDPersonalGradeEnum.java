package com.e.onboarding.util;

public enum EmployeeSubGroupIDPersonalGradeEnum {
	PG1("15/16", "6"), PG2("17/18", "7"),PG3("19/20", "8"),PG4("29", "29"),
	PG5("30", "30"),PG6("31", "31"),PG7("32", "32"),PG8("33", "33"),
	PG9("34", "34"),PG10("35", "35"),PG11("36", "36");
	
	private String pg;
	private String index;
	
	private EmployeeSubGroupIDPersonalGradeEnum(String pg, String index) {
		this.pg = pg;
		this.index = index;
	}
	
	public static EmployeeSubGroupIDPersonalGradeEnum getPgEnum(String index) {
		for (EmployeeSubGroupIDPersonalGradeEnum e : EmployeeSubGroupIDPersonalGradeEnum.values()) {
			if (e.getIndex().equals(index)) {
				return e;
			}
		}
		return EmployeeSubGroupIDPersonalGradeEnum.PG1;
	}
	
	public static String getPg(String index) {
		for (EmployeeSubGroupIDPersonalGradeEnum e : EmployeeSubGroupIDPersonalGradeEnum.values()) {
			if (e.getIndex().equals(index)) {
				return e.pg;
			}
		}
		return null;
	}
	
	public String getPg() {
		return pg;
	}
	public void setPg(String pg) {
		this.pg = pg;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	
	public static void main(String[] args) {
		System.out.println(EmployeeSubGroupIDPersonalGradeEnum.PG2.compareTo(EmployeeSubGroupIDPersonalGradeEnum.PG3));
	}
}
