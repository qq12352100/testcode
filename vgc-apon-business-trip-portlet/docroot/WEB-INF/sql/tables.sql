create table VgcApon_BtApplication (
	businessTripApplicationId LONG not null primary key,
	ticketNo VARCHAR(75) null,
	processType VARCHAR(75) null,
	subType VARCHAR(75) null,
	printName VARCHAR(75) null,
	staffCode LONG,
	companyName VARCHAR(75) null,
	division VARCHAR(75) null,
	department VARCHAR(75) null,
	costCenter VARCHAR(75) null,
	personalID VARCHAR(75) null,
	passportNo VARCHAR(75) null,
	officePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	email VARCHAR(75) null,
	officeSite VARCHAR(75) null,
	approverId LONG,
	approverName VARCHAR(75) null,
	evpId LONG,
	evpName VARCHAR(75) null,
	isCrossDepartment BOOLEAN,
	targetDepartmentId LONG,
	targetDepartmentName VARCHAR(75) null,
	targetCostCenter VARCHAR(75) null,
	targetDepartmentApproverId LONG,
	targetDepartmentApproverName VARCHAR(75) null,
	tripType INTEGER,
	departureDate DATE null,
	returnDate DATE null,
	purposeOfTheTrip VARCHAR(512) null,
	visitCountriesCities VARCHAR(75) null,
	advancePayment DOUBLE,
	currency_ VARCHAR(75) null,
	paymentMethods VARCHAR(75) null,
	totalCostRmb DOUBLE,
	totalCostEur DOUBLE,
	hotelTotalCostRmb DOUBLE,
	hotelTotalCostEur DOUBLE,
	carRentalTotalCostRmb DOUBLE,
	carRentalTotalCostEur DOUBLE,
	remark VARCHAR(512) null,
	otherEmails VARCHAR(1024) null,
	status INTEGER,
	sapStatus INTEGER,
	sapComments VARCHAR(1024) null,
	sapDocumentId VARCHAR(512) null,
	sapCertificateNo VARCHAR(75) null,
	sapCompany VARCHAR(75) null,
	sapYear VARCHAR(75) null,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	isApplicantAgent BOOLEAN,
	isApproverAgent BOOLEAN,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	submittedDate DATE null,
	companyId LONG
);

create table VgcApon_BtReimbursement (
	businessTripReimbursementId LONG not null primary key,
	ticketNo VARCHAR(75) null,
	bussinessTirpTicketNo VARCHAR(75) null,
	processType VARCHAR(75) null,
	subType VARCHAR(75) null,
	printName VARCHAR(75) null,
	staffCode LONG,
	companyName VARCHAR(75) null,
	division VARCHAR(75) null,
	department VARCHAR(75) null,
	costCenter VARCHAR(75) null,
	personalID VARCHAR(75) null,
	passportNo VARCHAR(75) null,
	officePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	email VARCHAR(75) null,
	officeSite VARCHAR(75) null,
	approverId LONG,
	approverName VARCHAR(75) null,
	isCrossDepartment BOOLEAN,
	targetDepartmentId LONG,
	targetDepartmentName VARCHAR(75) null,
	targetCostCenter VARCHAR(75) null,
	targetDepartmentApproverId LONG,
	targetDepartmentApproverName VARCHAR(75) null,
	tripType INTEGER,
	departureDate DATE null,
	returnDate DATE null,
	purposeOfTheTrip VARCHAR(512) null,
	visitCountriesCities VARCHAR(75) null,
	advancePayment DOUBLE,
	currency_ VARCHAR(75) null,
	paymentMethods VARCHAR(75) null,
	totalCostRmb DOUBLE,
	totalCostEur DOUBLE,
	orgTotalCostRmb DOUBLE,
	orgTotalCostEur DOUBLE,
	hotelTotalCostRmb DOUBLE,
	hotelTotalCostEur DOUBLE,
	carRentalTotalCostRmb DOUBLE,
	carRentalTotalCostEur DOUBLE,
	flightCurrency VARCHAR(75) null,
	flightTotal DOUBLE,
	flightAirFare DOUBLE,
	flightTaxes DOUBLE,
	flightTransactionFee DOUBLE,
	totalTravelExpenseRmb DOUBLE,
	totalTravelExpenseEur DOUBLE,
	costListInlandTotalRmb DOUBLE,
	costListForeignTotalEur DOUBLE,
	costListForeignTotalRmb DOUBLE,
	remark VARCHAR(512) null,
	isPaybyRmb BOOLEAN,
	evpId LONG,
	evpName VARCHAR(75) null,
	status INTEGER,
	sapStatus INTEGER,
	sapComments VARCHAR(1024) null,
	sapDocumentId VARCHAR(512) null,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	isApplicantAgent BOOLEAN,
	isApproverAgent BOOLEAN,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	submittedDate DATE null,
	companyId LONG
);

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	pickupLocation VARCHAR(75) null,
	pickupDate DATE null,
	dropoffLocation VARCHAR(75) null,
	dropoffDate DATE null,
	carType VARCHAR(75) null,
	typeOfRental VARCHAR(75) null,
	price DOUBLE,
	currency_ VARCHAR(75) null,
	tripType VARCHAR(75) null
);

create table vgcapon_BtCostList (
	btCostListId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	item VARCHAR(75) null,
	invoiceCurrency VARCHAR(75) null,
	paymentAmount DOUBLE,
	paymentCurrency VARCHAR(75) null,
	countryCity VARCHAR(75) null,
	type_ VARCHAR(75) null,
	invoiceAmount DOUBLE,
	taxRate DOUBLE,
	netAmount DOUBLE,
	taxAmount DOUBLE,
	netAmountRmb DOUBLE,
	entertainmentDate DATE null,
	entertainmentPlace VARCHAR(75) null,
	reasonesInfo VARCHAR(75) null,
	attendeesTotal INTEGER,
	averageSpend DOUBLE,
	mealCategory VARCHAR(75) null
);

create table vgcapon_BtEntertainmentDetail (
	btEntertainmentDetailId LONG not null primary key,
	btCostListId LONG,
	businessTripPkId LONG,
	fullName VARCHAR(75) null,
	positionTitle VARCHAR(75) null,
	company VARCHAR(75) null
);

create table vgcapon_BtExchangeRate (
	btExchangeRateId LONG not null primary key,
	firstCurrency VARCHAR(75) null,
	secondCurrency VARCHAR(75) null,
	firToSecExchangeRate DOUBLE,
	secToFirExchangeRate DOUBLE,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table vgcapon_BtExchangeSAPRate (
	btExchangeSAPRateId LONG not null primary key,
	fromCurrency VARCHAR(75) null,
	toCurrency VARCHAR(75) null,
	currencyRate DOUBLE,
	rateType VARCHAR(75) null,
	sapDate DATE null,
	importDate DATE null
);

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	type_ VARCHAR(75) null,
	fromCity VARCHAR(75) null,
	toCity VARCHAR(75) null,
	departureDate DATE null,
	departureFlight VARCHAR(75) null,
	departureTime DATE null,
	classInfo VARCHAR(75) null,
	price DOUBLE,
	currency_ VARCHAR(75) null,
	tripType VARCHAR(75) null
);

create table vgcapon_BtHotelInfo (
	btHotelInfoId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	city VARCHAR(75) null,
	cityType VARCHAR(75) null,
	hotel VARCHAR(75) null,
	checkIn DATE null,
	checkOut DATE null,
	roomCategory VARCHAR(75) null,
	price DOUBLE,
	currency_ VARCHAR(75) null,
	otherReasonInfo VARCHAR(512) null,
	isNotBookedFromTA BOOLEAN,
	isOverBudget INTEGER,
	othersSpecify VARCHAR(512) null,
	tripType VARCHAR(75) null
);

create table vgcapon_BtReimbursementSAPInfo (
	btReimbursementSAPInfoId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	step INTEGER,
	messageType VARCHAR(75) null,
	message VARCHAR(1024) null,
	certificateNo VARCHAR(75) null,
	company VARCHAR(75) null,
	year VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table vgcapon_BtTrainInfo (
	btTrainInfoId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	fromCity VARCHAR(75) null,
	toCity VARCHAR(75) null,
	departureDate DATE null,
	departureTrain VARCHAR(75) null,
	classInfo VARCHAR(75) null,
	price DOUBLE,
	currency_ VARCHAR(75) null,
	tripType VARCHAR(75) null
);

create table vgcapon_BtTravelExpense (
	btTravelExpenseId LONG not null primary key,
	businessTripPkId LONG,
	ticketNo VARCHAR(75) null,
	travelDate VARCHAR(75) null,
	departure VARCHAR(75) null,
	arrival VARCHAR(75) null,
	fromCity VARCHAR(75) null,
	toCity VARCHAR(75) null,
	isHasBreakfast BOOLEAN,
	isHasLunch BOOLEAN,
	isHasDinner BOOLEAN,
	country VARCHAR(75) null,
	city VARCHAR(75) null,
	rateOfDma DOUBLE,
	currency_ VARCHAR(75) null,
	allowance DOUBLE,
	comments VARCHAR(512) null,
	tripType VARCHAR(75) null,
	allowanceRmb DOUBLE
);

create table vgcapon_RateCity (
	ratecityId LONG not null primary key,
	areaName VARCHAR(75) null,
	rateOfDma DOUBLE,
	currency_ VARCHAR(75) null,
	parentId LONG
);

ALTER TABLE VGCAPON_BTREIMBURSEMENT ADD orgTotalCostEur NUMBER(30,20) null;
ALTER TABLE VGCAPON_BTREIMBURSEMENT ADD orgTotalCostRmb NUMBER(30,20) null;
ALTER TABLE vgcapon_BtTravelExpense ADD allowanceRmb NUMBER(30,20);
ALTER TABLE vgcapon_BtCostList ADD netAmountRmb NUMBER(30,20);
ALTER TABLE VGCAPON_BTREIMBURSEMENT ADD isPaybyRmb NUMBER(1,0);
Alter table VGCAPON_BTCOSTLIST modify(REASONESINFO  varchar(250));

ALTER TABLE VGCAPON_BTREIMBURSEMENT ADD EVPID  NUMBER(30) NULL;
ALTER TABLE VGCAPON_BTREIMBURSEMENT ADD EVPNAME VARCHAR(75) NULL;