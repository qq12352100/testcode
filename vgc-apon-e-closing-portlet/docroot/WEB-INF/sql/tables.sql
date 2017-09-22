create table vgcapon_EClosing (
	eclosingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ticketNo VARCHAR(75) null,
	staffCode INTEGER,
	staffName VARCHAR(75) null,
	company VARCHAR(75) null,
	division VARCHAR(75) null,
	department VARCHAR(75) null,
	costCenter VARCHAR(75) null,
	functionName VARCHAR(75) null,
	positionCode VARCHAR(75) null,
	employeeGroupId VARCHAR(75) null,
	employeeGroupName VARCHAR(75) null,
	privateEmailAddress VARCHAR(75) null,
	startingDate DATE null,
	lastWorkingDay DATE null,
	finishContractDate DATE null,
	seatOfficeNumber VARCHAR(75) null,
	permanentAddress VARCHAR(75) null,
	dmOption1 BOOLEAN,
	dmOption2 BOOLEAN,
	dmStatus VARCHAR(75) null,
	dmComments VARCHAR(500) null,
	adOption1 BOOLEAN,
	adOption2 BOOLEAN,
	adOption3 BOOLEAN,
	adOption4 BOOLEAN,
	adFinanceFee DOUBLE,
	adStatus VARCHAR(75) null,
	adComments VARCHAR(500) null,
	fsOption1 BOOLEAN,
	fsStatus VARCHAR(75) null,
	fsComments VARCHAR(500) null,
	flcOption1 BOOLEAN,
	flcOption2 BOOLEAN,
	flcStatus VARCHAR(75) null,
	flcComments VARCHAR(500) null,
	securityOption1 BOOLEAN,
	securityFinanceFee DOUBLE,
	securityStatus VARCHAR(75) null,
	securityComments VARCHAR(500) null,
	idOption1 BOOLEAN,
	idOption2 BOOLEAN,
	idOption3 BOOLEAN,
	idOption4 BOOLEAN,
	idOption5 BOOLEAN,
	idOption6 BOOLEAN,
	idOption7 BOOLEAN,
	idOption8 BOOLEAN,
	idOption9 BOOLEAN,
	idHrFee DOUBLE,
	idFinanceFee DOUBLE,
	idStatus VARCHAR(75) null,
	idComments VARCHAR(500) null,
	htdOption1 BOOLEAN,
	htdHrFee DOUBLE,
	htdFinanceFee DOUBLE,
	htdStatus VARCHAR(75) null,
	htdComments VARCHAR(500) null,
	hdOption1 BOOLEAN,
	hdOption2 BOOLEAN,
	hdOption2Text VARCHAR(75) null,
	hdOption3 BOOLEAN,
	hdOption3Money DOUBLE,
	hdOption4 BOOLEAN,
	hdOption4Money DOUBLE,
	hdStatus VARCHAR(75) null,
	hdComments VARCHAR(500) null,
	hdleaveText VARCHAR(75) null,
	fdOption1 BOOLEAN,
	fdOption2 BOOLEAN,
	fdOption3 BOOLEAN,
	fdOption4 BOOLEAN,
	fdOption4Text VARCHAR(75) null,
	fdStatus VARCHAR(75) null,
	fdComments VARCHAR(500) null,
	applicantAgent BOOLEAN,
	approverAgent BOOLEAN,
	processType VARCHAR(75) null,
	subProcessType VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);