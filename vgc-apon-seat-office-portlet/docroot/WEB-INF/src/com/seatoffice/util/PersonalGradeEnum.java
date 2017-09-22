package com.seatoffice.util;

public enum PersonalGradeEnum {
	PGL21(2, "Executive Vice President"), PGL31(3, "Vice President"),
	PGL32(3, "35"), PGL33(3, "36"), PGL41(4, "Vice President"), 
	PGL42(4, "35"), PGL43(4, "36"), 
	PGL51(5, "31"), PGL52(5, "32"), PGL53(5, "33"), PGL54(5, "34");
	
	private int level;
	private String index;
	
	private PersonalGradeEnum(int level, String index) {
		this.level = level;
		this.index = index;
	}
	
	public static int getlevel(String index) {
		for (PersonalGradeEnum c : PersonalGradeEnum.values()) {
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