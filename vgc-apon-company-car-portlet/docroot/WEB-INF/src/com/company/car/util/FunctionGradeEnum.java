package com.company.car.util;

public enum FunctionGradeEnum {
	FGL21(2, "TM"), FGL22(2, "35/36"), FGL23(2, "36/TM"), FGL31(3, "34/35"),
	FGL32(3, "33/34"), FGL41(4, "32/33"), FGL42(4, "31/32"), FGL43(4, "30/31"),
	FGL51(5, "29/30"), FGL52(5, "T+/29"),FGL61(6, "*");
	
	private int level;
	private String index;
	
	private FunctionGradeEnum(int level, String index) {
		this.level = level;
		this.index = index;
	}
	
	public static int getlevel(String index) {
		for (FunctionGradeEnum c : FunctionGradeEnum.values()) {
			if (c.getIndex().equals(index)) {
				return c.level;
			}
		}
		return 7;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
}
