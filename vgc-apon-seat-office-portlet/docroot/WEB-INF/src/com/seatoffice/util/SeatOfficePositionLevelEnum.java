package com.seatoffice.util;

public enum SeatOfficePositionLevelEnum {
	A(1,"1/2"),B(2,"3/4"),C(3,"5/6"),D(4,"7/8"),E(5,"9/10"),F(6,"11/12"),G(7,"13/14"),
	H(8,"15/16"),I(9,"17/18"),J(10,"19/20"),K(11,"T+"),L(12,"T+/29"),M(13,"29/30"),N(14,"30/31"),
	O(15,"31/32"),P(16,"32/33"),Q(17,"33/34"),R(18,"34/35"),S(19,"35/36"),T(20,"36/TM"),U(21,"TM");
	
	private int level;
	private String fg;
    
    private SeatOfficePositionLevelEnum(int level,String fg) {
        this.level = level;
        this.fg=fg;
    }
    
	public static int getLevel(String fg) {
		for (SeatOfficePositionLevelEnum c : SeatOfficePositionLevelEnum.values()) {
			if (c.getFg().equals(fg)) {
				return c.level;
			}
		}
		return 1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getFg() {
		return fg;
	}

	public void setFg(String fg) {
		this.fg = fg;
	}
}
