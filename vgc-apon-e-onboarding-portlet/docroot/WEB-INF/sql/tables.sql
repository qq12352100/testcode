create table vgcapon_Distribution (
	distributionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	emailAddress VARCHAR(75) null,
	name VARCHAR(75) null,
	comments VARCHAR(250) null,
	type_ VARCHAR(75) null
);

create table vgcapon_EOnBoarding (
	eOnBoardingId LONG not null primary key,
	ticketNo VARCHAR(75) null,
	processType VARCHAR(75) null,
	subType VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	submittedDate DATE null,
	modifiedUserId LONG,
	modifiedUserName VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	staffCode VARCHAR(75) null,
	lastName VARCHAR(75) null,
	firstName VARCHAR(75) null,
	name VARCHAR(75) null,
	gender VARCHAR(75) null,
	birthday DATE null,
	photoPath VARCHAR(250) null,
	contractType VARCHAR(75) null,
	workLocation VARCHAR(75) null,
	division VARCHAR(75) null,
	officeSite VARCHAR(75) null,
	department VARCHAR(75) null,
	startingDate DATE null,
	positionCode VARCHAR(75) null,
	serviceLength VARCHAR(75) null,
	functionName VARCHAR(75) null,
	reportTo VARCHAR(75) null,
	reportToStaffName VARCHAR(75) null,
	title VARCHAR(75) null,
	costCenter VARCHAR(75) null,
	itRelatedHardware BOOLEAN,
	companyCar BOOLEAN,
	replacement BOOLEAN,
	nameOfReplacedPerson VARCHAR(75) null,
	contactInfo VARCHAR(250) null,
	comments VARCHAR(250) null,
	isApplicantAgent BOOLEAN,
	isApproverAgent BOOLEAN,
	adminEntitlement VARCHAR(75) null,
	adminSeatNo VARCHAR(75) null,
	adminTasks VARCHAR(250) null,
	adminStatus VARCHAR(75) null,
	adminComments VARCHAR(250) null,
	securityTasks VARCHAR(250) null,
	securityStatus VARCHAR(75) null,
	securityComments VARCHAR(250) null,
	itpTasks VARCHAR(250) null,
	itpStatus VARCHAR(75) null,
	iptComments VARCHAR(250) null,
	financeTasks VARCHAR(250) null,
	financeStatus VARCHAR(75) null,
	financeComments VARCHAR(250) null
);