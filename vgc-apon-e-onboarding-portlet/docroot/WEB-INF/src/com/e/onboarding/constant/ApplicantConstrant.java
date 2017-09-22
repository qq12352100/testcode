package com.e.onboarding.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicantConstrant {

	public static final List<String> TITLELIST = new ArrayList<String>();
	public static final List<String> WORKLOCATION = new ArrayList<String>();
	public static final List<String> OFFICESITE = new ArrayList<String>();
	public static final Map<String, Object> CONTRACTTYPE = new HashMap<String, Object>();
	public static final List<String> CONTRACTTYPELIST = new ArrayList<String>();

	public static final List<String> APPROVALSTATUSLIST = new ArrayList<String>();
	public static final List<String> VACANCYSTATUSLIST = new ArrayList<String>();

	// The ApplicationFomr Status
	public static final String DRAFT = "Draft";
	public static final String IN_PROGRESS = "In Process";
	public static final String COMPLETED = "Completed";

	// The E-Onboarding Application ProcessType
	public static final String EO_PROCESSTYPE = "E-Onboarding/Transfer/Closing";
	public static final String EO_SUB_PROCESSTYPE_APPLICANT = "E-Onboarding";

	// Generate E-Onboarding Ticket
	public static final String EO = "EO";

	static {
		APPROVALSTATUSLIST.add(IN_PROGRESS);
		APPROVALSTATUSLIST.add(COMPLETED);
	}

	static {
		VACANCYSTATUSLIST.add("Open");
		VACANCYSTATUSLIST.add("Filled");
	}

	static {
		TITLELIST.add("Mr.");
		TITLELIST.add("Mrs");
		TITLELIST.add("Ms.");
		TITLELIST.add("Dr.");
	}

	static {
		WORKLOCATION.add("Beijing");
		WORKLOCATION.add("Changchun");
		WORKLOCATION.add("Guangzhou");
		WORKLOCATION.add("Tianjin");
		WORKLOCATION.add("Yizheng");
		WORKLOCATION.add("Nanjing");
		WORKLOCATION.add("Shanghai");
		WORKLOCATION.add("Chengdu");
		WORKLOCATION.add("Changsha");
		WORKLOCATION.add("Foshan");
		WORKLOCATION.add("Hongkong");
		WORKLOCATION.add("Ningbo");
		WORKLOCATION.add("Urumqi");
		WORKLOCATION.add("Ingolstadt");
		WORKLOCATION.add("Neckarsulm");
		WORKLOCATION.add("Germany");
		WORKLOCATION.add("Dalian");
		WORKLOCATION.add("Qingdao");
	}

	static {
		OFFICESITE.add("Beijing-SLT");
		OFFICESITE.add("Beijing-ACB");
		OFFICESITE.add("Beijing-Indigo");
		OFFICESITE.add("Beijing-VTA");
		OFFICESITE.add("Beijing-HLP");
		OFFICESITE.add("Beijing-Audi City");
		OFFICESITE.add("Beijing-Audi TCB");
		OFFICESITE.add("Bejing-Audi ATA");
		OFFICESITE.add("Beijing-Audi DealerNo.1");
		OFFICESITE.add("N/A");
	}

	static {
		CONTRACTTYPELIST.add("LOCAL");
		CONTRACTTYPELIST.add("LE");
		CONTRACTTYPELIST.add("FSE");
		CONTRACTTYPELIST.add("Contractor");
		CONTRACTTYPELIST.add("Intern");
	}

	public static List<String> getTitile() {
		return TITLELIST;
	}

	public static List<String> getWorkLocation() {
		return WORKLOCATION;
	}

	public static List<String> getOfficeSite() {

		return OFFICESITE;
	}

	public static List<String> getContractType() {
		return CONTRACTTYPELIST;
	}

}
