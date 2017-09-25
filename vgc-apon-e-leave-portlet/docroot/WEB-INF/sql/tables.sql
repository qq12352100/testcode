create table vgcapon_ELeave (
	eLeaveId LONG not null primary key,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	companyId LONG,
	ticketNo VARCHAR(75) null,
	staffName VARCHAR(75) null,
	staffCode VARCHAR(75) null,
	company VARCHAR(75) null,
	division VARCHAR(75) null,
	department VARCHAR(75) null,
	costCenter VARCHAR(75) null,
	officePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	email VARCHAR(75) null,
	positionType VARCHAR(75) null,
	isApplicantAgent BOOLEAN,
	isApproverAgent BOOLEAN,
	processType VARCHAR(75) null,
	subProcessType VARCHAR(75) null,
	submittedDate DATE null,
	comments VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	totalLeaveEntitlement VARCHAR(75) null,
	totalDuration VARCHAR(75) null,
	remainingLeaveDaysBefore VARCHAR(75) null,
	remainingLeaveDaysAfter VARCHAR(75) null
);

create table vgcapon_ELeaveInfo (
	eLeaveInfoId LONG not null primary key,
	eLeaveId LONG,
	startDate DATE null,
	endDate DATE null,
	startTime VARCHAR(75) null,
	endTime VARCHAR(75) null,
	typeOfLeave VARCHAR(75) null,
	typeOfLeaveId VARCHAR(75) null,
	absenceDays VARCHAR(75) null,
	remark VARCHAR(250) null
);

ALTER TABLE vgcapon_ELeave ADD (totalLeaveEntitlement VARCHAR(75),totalDuration VARCHAR(75),remainingLeaveDaysBefore VARCHAR(75),remainingLeaveDaysAfter VARCHAR(75));