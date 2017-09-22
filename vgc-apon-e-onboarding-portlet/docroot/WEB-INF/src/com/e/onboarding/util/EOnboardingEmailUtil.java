package com.e.onboarding.util;

public class EOnboardingEmailUtil {
	public static final String[] FOUR_ROLES = new String[]{"EO_Admin","EO_Security","EO_ITP","EO_Controlling/Finance"};	
	
	//Get the css content
	public static String getCssContent() {
		StringBuffer sb = new StringBuffer();
		sb.append(".emailTmp{padding:10px 5px;line-height:2;margin-bottom:30px;}")
		  .append(".emailTmp p .name{background-color:#E4E4E5;font-style:italic;text-transform:capitalize;}")
		  .append(".emailTmp p .warning{color:red;}")
		  .append(".emailTmp p .warning02{text-transform:uppercase;}")
		  .append(".emailTmp p .href{color:blue;}")
		  .append(".emailTmp p a{color:blue;text-decoration:underline;}")
		  .append(".emailTmp .value{background-color:#E4E4E5;}")
		  .append(".emailTmp .oper{color:#4DA0D1;}")
		  .append(".emailTmp table{width:40%;margin:10px;border-collapse :separate;border-spacing:0px;}")
		  .append(".emailTmp table.grid{border:1px solid #000;}")
		  .append(".emailTmp table.grid td {border:1px solid #000;}")
		  .append(".emailTmp table tr {height:40px;}");
		return sb.toString();
	}
}
