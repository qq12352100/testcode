drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table VgcApon_BtApplication (
	businessTripApplicationId number(30,0) not null primary key,
	ticketNo VARCHAR2(75 CHAR) null,
	processType VARCHAR2(75 CHAR) null,
	subType VARCHAR2(75 CHAR) null,
	printName VARCHAR2(75 CHAR) null,
	staffCode number(30,0),
	companyName VARCHAR2(75 CHAR) null,
	division VARCHAR2(75 CHAR) null,
	department VARCHAR2(75 CHAR) null,
	costCenter VARCHAR2(75 CHAR) null,
	personalID VARCHAR2(75 CHAR) null,
	passportNo VARCHAR2(75 CHAR) null,
	officePhone VARCHAR2(75 CHAR) null,
	mobilePhone VARCHAR2(75 CHAR) null,
	email VARCHAR2(75 CHAR) null,
	officeSite VARCHAR2(75 CHAR) null,
	approverId number(30,0),
	approverName VARCHAR2(75 CHAR) null,
	isCrossDepartment number(1, 0),
	targetDepartmentId number(30,0),
	targetDepartmentName VARCHAR2(75 CHAR) null,
	targetCostCenter VARCHAR2(75 CHAR) null,
	targetDepartmentApproverId number(30,0),
	targetDepartmentApproverName VARCHAR2(75 CHAR) null,
	tripType number(30,0),
	departureDate timestamp null,
	returnDate timestamp null,
	purposeOfTheTrip VARCHAR2(512 CHAR) null,
	visitCountriesCities VARCHAR2(75 CHAR) null,
	advancePayment number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	paymentMethods VARCHAR2(75 CHAR) null,
	totalCostRmb number(30,20),
	totalCostEur number(30,20),
	hotelTotalCostRmb number(30,20),
	hotelTotalCostEur number(30,20),
	carRentalTotalCostRmb number(30,20),
	carRentalTotalCostEur number(30,20),
	remark VARCHAR2(512 CHAR) null,
	status number(30,0),
	sapStatus number(30,0),
	statusByUserId number(30,0),
	statusByUserName VARCHAR2(75 CHAR) null,
	statusDate timestamp null,
	isApplicantAgent number(1, 0),
	isApproverAgent number(1, 0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	submittedDate timestamp null,
	companyId number(30,0)
);

create table VgcApon_BtReimbursement (
	businessTripReimbursementId number(30,0) not null primary key,
	ticketNo VARCHAR2(75 CHAR) null,
	bussinessTirpTicketNo VARCHAR2(75 CHAR) null,
	processType VARCHAR2(75 CHAR) null,
	subType VARCHAR2(75 CHAR) null,
	printName VARCHAR2(75 CHAR) null,
	staffCode number(30,0),
	companyName VARCHAR2(75 CHAR) null,
	division VARCHAR2(75 CHAR) null,
	department VARCHAR2(75 CHAR) null,
	costCenter VARCHAR2(75 CHAR) null,
	personalID VARCHAR2(75 CHAR) null,
	passportNo VARCHAR2(75 CHAR) null,
	officePhone VARCHAR2(75 CHAR) null,
	mobilePhone VARCHAR2(75 CHAR) null,
	email VARCHAR2(75 CHAR) null,
	officeSite VARCHAR2(75 CHAR) null,
	approverId number(30,0),
	approverName VARCHAR2(75 CHAR) null,
	isCrossDepartment number(1, 0),
	targetDepartmentId number(30,0),
	targetDepartmentName VARCHAR2(75 CHAR) null,
	targetCostCenter VARCHAR2(75 CHAR) null,
	targetDepartmentApproverId number(30,0),
	targetDepartmentApproverName VARCHAR2(75 CHAR) null,
	tripType number(30,0),
	departureDate timestamp null,
	returnDate timestamp null,
	purposeOfTheTrip VARCHAR2(512 CHAR) null,
	visitCountriesCities VARCHAR2(75 CHAR) null,
	advancePayment number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	paymentMethods VARCHAR2(75 CHAR) null,
	totalCostRmb number(30,20),
	totalCostEur number(30,20),
	hotelTotalCostRmb number(30,20),
	hotelTotalCostEur number(30,20),
	carRentalTotalCostRmb number(30,20),
	carRentalTotalCostEur number(30,20),
	totalTravelExpenseRmb number(30,20),
	totalTravelExpenseEur number(30,20),
	costListInlandTotalRmb number(30,20),
	costListForeignTotalEur number(30,20),
	costListForeignTotalRmb number(30,20),
	remark VARCHAR2(512 CHAR) null,
	status number(30,0),
	sapStatus number(30,0),
	statusByUserId number(30,0),
	statusByUserName VARCHAR2(75 CHAR) null,
	statusDate timestamp null,
	isApplicantAgent number(1, 0),
	isApproverAgent number(1, 0),
	groupId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	submittedDate timestamp null,
	companyId number(30,0)
);

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId number(30,0) not null primary key,
	businessTripPkId number(30,0),
	ticketNo VARCHAR2(75 CHAR) null,
	pickupLocation VARCHAR2(75 CHAR) null,
	pickupDate timestamp null,
	dropoffLocation VARCHAR2(75 CHAR) null,
	dropoffDate timestamp null,
	carType VARCHAR2(75 CHAR) null,
	typeOfRental VARCHAR2(75 CHAR) null,
	price number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	tripType VARCHAR2(75 CHAR) null
);

create table vgcapon_BtCostList (
	btCostListId number(30,0) not null primary key,
	businessTripPkId number(30,0),
	ticketNo VARCHAR2(75 CHAR) null,
	item VARCHAR2(75 CHAR) null,
	type_ VARCHAR2(75 CHAR) null,
	invoiceAmount number(30,20),
	invoiceCurrency VARCHAR2(75 CHAR) null,
	country VARCHAR2(75 CHAR) null,
	city VARCHAR2(75 CHAR) null,
	ifPayInRmb number(1, 0),
	paymentCurrency VARCHAR2(75 CHAR) null,
	paymentAmount number(30,20),
	paymentMothed VARCHAR2(75 CHAR) null
);

create table vgcapon_BtExchangeRate (
	btExchangeRateId number(30,0) not null primary key,
	firstCurrency VARCHAR2(75 CHAR) null,
	secondCurrency VARCHAR2(75 CHAR) null,
	firToSecExchangeRate number(30,20),
	secToFirExchangeRate number(30,20),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	status number(30,0)
);

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId number(30,0) not null primary key,
	businessTripPkId number(30,0),
	ticketNo VARCHAR2(75 CHAR) null,
	type_ VARCHAR2(75 CHAR) null,
	fromCity VARCHAR2(75 CHAR) null,
	toCity VARCHAR2(75 CHAR) null,
	departureDate timestamp null,
	departureFlight VARCHAR2(75 CHAR) null,
	departureTime timestamp null,
	classInfo VARCHAR2(75 CHAR) null,
	price number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	tripType VARCHAR2(75 CHAR) null
);

create table vgcapon_BtHotelInfo (
	btHotelInfoId number(30,0) not null primary key,
	businessTripPkId number(30,0),
	ticketNo VARCHAR2(75 CHAR) null,
	city VARCHAR2(75 CHAR) null,
	cityType VARCHAR2(75 CHAR) null,
	hotel VARCHAR2(75 CHAR) null,
	checkIn timestamp null,
	checkOut timestamp null,
	roomCategory VARCHAR2(75 CHAR) null,
	price number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	otherReasonInfo VARCHAR2(512 CHAR) null,
	isNotBookedFromTA number(1, 0),
	isOverBudget number(30,0),
	othersSpecify VARCHAR2(512 CHAR) null,
	tripType VARCHAR2(75 CHAR) null
);

create table vgcapon_BtTrainInfo (
	btTrainInfoId number(30,0) not null primary key,
	businessTripPkId number(30,0),
	ticketNo VARCHAR2(75 CHAR) null,
	fromCity VARCHAR2(75 CHAR) null,
	toCity VARCHAR2(75 CHAR) null,
	departureDate timestamp null,
	departureTrain VARCHAR2(75 CHAR) null,
	classInfo VARCHAR2(75 CHAR) null,
	price number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	tripType VARCHAR2(75 CHAR) null
);

create table vgcapon_BtTravelExpense (
	btTravelExpenseId number(30,0) not null primary key,
	businessTripPkId number(30,0),
	ticketNo VARCHAR2(75 CHAR) null,
	date_ timestamp null,
	departure timestamp null,
	arrival timestamp null,
	fromCity VARCHAR2(75 CHAR) null,
	toCity VARCHAR2(75 CHAR) null,
	isHasBreakfast number(1, 0),
	isHasLunch number(1, 0),
	isHasDinner number(1, 0),
	country VARCHAR2(75 CHAR) null,
	city VARCHAR2(75 CHAR) null,
	rateOfDma number(30,20),
	currency_ VARCHAR2(75 CHAR) null,
	comments VARCHAR2(512 CHAR) null
);


create index IX_C31DC7C5 on VgcApon_BtApplication (status, userId);
create index IX_75F6CC06 on VgcApon_BtApplication (ticketNo);

create index IX_C651DED on VgcApon_BtReimbursement (status, userId);
create index IX_C463E02E on VgcApon_BtReimbursement (ticketNo);

create index IX_EFFD9C3D on vgcapon_BtCarRentalInfo (businessTripPkId, tripType);
create index IX_C7752A0F on vgcapon_BtCarRentalInfo (ticketNo, tripType);

create index IX_889695B1 on vgcapon_BtCostList (businessTripPkId);
create index IX_D5AEF903 on vgcapon_BtCostList (ticketNo);

create index IX_A05EFAD6 on vgcapon_BtExchangeRate (firstCurrency, secondCurrency, status);

create index IX_C046B5DD on vgcapon_BtFlightTrainInfo (businessTripPkId, tripType);
create index IX_84C1E3AF on vgcapon_BtFlightTrainInfo (ticketNo, tripType);

create index IX_58E6BC59 on vgcapon_BtHotelInfo (businessTripPkId, tripType);
create index IX_439E262B on vgcapon_BtHotelInfo (ticketNo, tripType);

create index IX_1223D7AD on vgcapon_BtTrainInfo (businessTripPkId, tripType);
create index IX_6585D57F on vgcapon_BtTrainInfo (ticketNo, tripType);

create index IX_43CE2982 on vgcapon_BtTravelExpense (businessTripPkId);
create index IX_973BEDD4 on vgcapon_BtTravelExpense (ticketNo);



quit