drop database lportal;
create database lportal encoding = 'UNICODE';
\c lportal;

create table VgcApon_BtApplication (
	businessTripApplicationId bigint not null primary key,
	ticketNo varchar(75) null,
	processType varchar(75) null,
	subType varchar(75) null,
	printName varchar(75) null,
	staffCode bigint,
	companyName varchar(75) null,
	division varchar(75) null,
	department varchar(75) null,
	costCenter varchar(75) null,
	personalID varchar(75) null,
	passportNo varchar(75) null,
	officePhone varchar(75) null,
	mobilePhone varchar(75) null,
	email varchar(75) null,
	officeSite varchar(75) null,
	approverId bigint,
	approverName varchar(75) null,
	isCrossDepartment bool,
	targetDepartmentId bigint,
	targetDepartmentName varchar(75) null,
	targetCostCenter varchar(75) null,
	targetDepartmentApproverId bigint,
	targetDepartmentApproverName varchar(75) null,
	tripType integer,
	departureDate timestamp null,
	returnDate timestamp null,
	purposeOfTheTrip varchar(512) null,
	visitCountriesCities varchar(75) null,
	advancePayment double precision,
	currency_ varchar(75) null,
	paymentMethods varchar(75) null,
	totalCostRmb double precision,
	totalCostEur double precision,
	hotelTotalCostRmb double precision,
	hotelTotalCostEur double precision,
	carRentalTotalCostRmb double precision,
	carRentalTotalCostEur double precision,
	remark varchar(512) null,
	status integer,
	sapStatus integer,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null,
	isApplicantAgent bool,
	isApproverAgent bool,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	submittedDate timestamp null,
	companyId bigint
);

create table VgcApon_BtReimbursement (
	businessTripReimbursementId bigint not null primary key,
	ticketNo varchar(75) null,
	bussinessTirpTicketNo varchar(75) null,
	processType varchar(75) null,
	subType varchar(75) null,
	printName varchar(75) null,
	staffCode bigint,
	companyName varchar(75) null,
	division varchar(75) null,
	department varchar(75) null,
	costCenter varchar(75) null,
	personalID varchar(75) null,
	passportNo varchar(75) null,
	officePhone varchar(75) null,
	mobilePhone varchar(75) null,
	email varchar(75) null,
	officeSite varchar(75) null,
	approverId bigint,
	approverName varchar(75) null,
	isCrossDepartment bool,
	targetDepartmentId bigint,
	targetDepartmentName varchar(75) null,
	targetCostCenter varchar(75) null,
	targetDepartmentApproverId bigint,
	targetDepartmentApproverName varchar(75) null,
	tripType integer,
	departureDate timestamp null,
	returnDate timestamp null,
	purposeOfTheTrip varchar(512) null,
	visitCountriesCities varchar(75) null,
	advancePayment double precision,
	currency_ varchar(75) null,
	paymentMethods varchar(75) null,
	totalCostRmb double precision,
	totalCostEur double precision,
	hotelTotalCostRmb double precision,
	hotelTotalCostEur double precision,
	carRentalTotalCostRmb double precision,
	carRentalTotalCostEur double precision,
	totalTravelExpenseRmb double precision,
	totalTravelExpenseEur double precision,
	costListInlandTotalRmb double precision,
	costListForeignTotalEur double precision,
	costListForeignTotalRmb double precision,
	remark varchar(512) null,
	status integer,
	sapStatus integer,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate timestamp null,
	isApplicantAgent bool,
	isApproverAgent bool,
	groupId bigint,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	submittedDate timestamp null,
	companyId bigint
);

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75) null,
	pickupLocation varchar(75) null,
	pickupDate timestamp null,
	dropoffLocation varchar(75) null,
	dropoffDate timestamp null,
	carType varchar(75) null,
	typeOfRental varchar(75) null,
	price double precision,
	currency_ varchar(75) null,
	tripType varchar(75) null
);

create table vgcapon_BtCostList (
	btCostListId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75) null,
	item varchar(75) null,
	type_ varchar(75) null,
	invoiceAmount double precision,
	invoiceCurrency varchar(75) null,
	country varchar(75) null,
	city varchar(75) null,
	ifPayInRmb bool,
	paymentCurrency varchar(75) null,
	paymentAmount double precision,
	paymentMothed varchar(75) null
);

create table vgcapon_BtExchangeRate (
	btExchangeRateId bigint not null primary key,
	firstCurrency varchar(75) null,
	secondCurrency varchar(75) null,
	firToSecExchangeRate double precision,
	secToFirExchangeRate double precision,
	userId bigint,
	userName varchar(75) null,
	createDate timestamp null,
	modifiedDate timestamp null,
	status integer
);

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75) null,
	type_ varchar(75) null,
	fromCity varchar(75) null,
	toCity varchar(75) null,
	departureDate timestamp null,
	departureFlight varchar(75) null,
	departureTime timestamp null,
	classInfo varchar(75) null,
	price double precision,
	currency_ varchar(75) null,
	tripType varchar(75) null
);

create table vgcapon_BtHotelInfo (
	btHotelInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75) null,
	city varchar(75) null,
	cityType varchar(75) null,
	hotel varchar(75) null,
	checkIn timestamp null,
	checkOut timestamp null,
	roomCategory varchar(75) null,
	price double precision,
	currency_ varchar(75) null,
	otherReasonInfo varchar(512) null,
	isNotBookedFromTA bool,
	isOverBudget integer,
	othersSpecify varchar(512) null,
	tripType varchar(75) null
);

create table vgcapon_BtTrainInfo (
	btTrainInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75) null,
	fromCity varchar(75) null,
	toCity varchar(75) null,
	departureDate timestamp null,
	departureTrain varchar(75) null,
	classInfo varchar(75) null,
	price double precision,
	currency_ varchar(75) null,
	tripType varchar(75) null
);

create table vgcapon_BtTravelExpense (
	btTravelExpenseId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo varchar(75) null,
	date_ timestamp null,
	departure timestamp null,
	arrival timestamp null,
	fromCity varchar(75) null,
	toCity varchar(75) null,
	isHasBreakfast bool,
	isHasLunch bool,
	isHasDinner bool,
	country varchar(75) null,
	city varchar(75) null,
	rateOfDma double precision,
	currency_ varchar(75) null,
	comments varchar(512) null
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


