drop database lportal;
create database lportal;
connect to lportal;
create table VgcApon_BtApplication (
	businessTripApplicationId bigint not null primary key,
	ticketNo varchar(75),
	processType varchar(75),
	subType varchar(75),
	printName varchar(75),
	staffCode bigint,
	companyName varchar(75),
	division varchar(75),
	department varchar(75),
	costCenter varchar(75),
	personalID varchar(75),
	passportNo varchar(75),
	officePhone varchar(75),
	mobilePhone varchar(75),
	email varchar(75),
	officeSite varchar(75),
	approverId bigint,
	approverName varchar(75),
	isCrossDepartment smallint,
	targetDepartmentId bigint,
	targetDepartmentName varchar(75),
	targetCostCenter varchar(75),
	targetDepartmentApproverId bigint,
	targetDepartmentApproverName varchar(75),
	tripType integer,
	departureDate timestamp,
	returnDate timestamp,
	purposeOfTheTrip varchar(512),
	visitCountriesCities varchar(75),
	advancePayment double,
	currency_ varchar(75),
	paymentMethods varchar(75),
	totalCostRmb double,
	totalCostEur double,
	hotelTotalCostRmb double,
	hotelTotalCostEur double,
	carRentalTotalCostRmb double,
	carRentalTotalCostEur double,
	remark varchar(512),
	status integer,
	sapStatus integer,
	statusByUserId bigint,
	statusByUserName varchar(75),
	statusDate timestamp,
	isApplicantAgent smallint,
	isApproverAgent smallint,
	groupId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	submittedDate timestamp,
	companyId bigint
);

create table VgcApon_BtReimbursement (
	businessTripReimbursementId bigint not null primary key,
	ticketNo varchar(75),
	bussinessTirpTicketNo varchar(75),
	processType varchar(75),
	subType varchar(75),
	printName varchar(75),
	staffCode bigint,
	companyName varchar(75),
	division varchar(75),
	department varchar(75),
	costCenter varchar(75),
	personalID varchar(75),
	passportNo varchar(75),
	officePhone varchar(75),
	mobilePhone varchar(75),
	email varchar(75),
	officeSite varchar(75),
	approverId bigint,
	approverName varchar(75),
	isCrossDepartment smallint,
	targetDepartmentId bigint,
	targetDepartmentName varchar(75),
	targetCostCenter varchar(75),
	targetDepartmentApproverId bigint,
	targetDepartmentApproverName varchar(75),
	tripType integer,
	departureDate timestamp,
	returnDate timestamp,
	purposeOfTheTrip varchar(512),
	visitCountriesCities varchar(75),
	advancePayment double,
	currency_ varchar(75),
	paymentMethods varchar(75),
	totalCostRmb double,
	totalCostEur double,
	hotelTotalCostRmb double,
	hotelTotalCostEur double,
	carRentalTotalCostRmb double,
	carRentalTotalCostEur double,
	totalTravelExpenseRmb double,
	totalTravelExpenseEur double,
	costListInlandTotalRmb double,
	costListForeignTotalEur double,
	costListForeignTotalRmb double,
	remark varchar(512),
	status integer,
	sapStatus integer,
	statusByUserId bigint,
	statusByUserName varchar(75),
	statusDate timestamp,
	isApplicantAgent smallint,
	isApproverAgent smallint,
	groupId bigint,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	submittedDate timestamp,
	companyId bigint
);

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75),
	pickupLocation varchar(75),
	pickupDate timestamp,
	dropoffLocation varchar(75),
	dropoffDate timestamp,
	carType varchar(75),
	typeOfRental varchar(75),
	price double,
	currency_ varchar(75),
	tripType varchar(75)
);

create table vgcapon_BtCostList (
	btCostListId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75),
	item varchar(75),
	type_ varchar(75),
	invoiceAmount double,
	invoiceCurrency varchar(75),
	country varchar(75),
	city varchar(75),
	ifPayInRmb smallint,
	paymentCurrency varchar(75),
	paymentAmount double,
	paymentMothed varchar(75)
);

create table vgcapon_BtExchangeRate (
	btExchangeRateId bigint not null primary key,
	firstCurrency varchar(75),
	secondCurrency varchar(75),
	firToSecExchangeRate double,
	secToFirExchangeRate double,
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	status integer
);

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75),
	type_ varchar(75),
	fromCity varchar(75),
	toCity varchar(75),
	departureDate timestamp,
	departureFlight varchar(75),
	departureTime timestamp,
	classInfo varchar(75),
	price double,
	currency_ varchar(75),
	tripType varchar(75)
);

create table vgcapon_BtHotelInfo (
	btHotelInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75),
	city varchar(75),
	cityType varchar(75),
	hotel varchar(75),
	checkIn timestamp,
	checkOut timestamp,
	roomCategory varchar(75),
	price double,
	currency_ varchar(75),
	otherReasonInfo varchar(512),
	isNotBookedFromTA smallint,
	isOverBudget integer,
	othersSpecify varchar(512),
	tripType varchar(75)
);

create table vgcapon_BtTrainInfo (
	btTrainInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75),
	fromCity varchar(75),
	toCity varchar(75),
	departureDate timestamp,
	departureTrain varchar(75),
	classInfo varchar(75),
	price double,
	currency_ varchar(75),
	tripType varchar(75)
);

create table vgcapon_BtTravelExpense (
	btTravelExpenseId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75),
	date_ timestamp,
	departure timestamp,
	arrival timestamp,
	fromCity varchar(75),
	toCity varchar(75),
	isHasBreakfast smallint,
	isHasLunch smallint,
	isHasDinner smallint,
	country varchar(75),
	city varchar(75),
	rateOfDma double,
	currency_ varchar(75),
	comments varchar(512)
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


