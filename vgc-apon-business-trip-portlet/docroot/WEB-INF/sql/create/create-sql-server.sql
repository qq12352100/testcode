drop database lportal;
create database lportal;

go

use lportal;

create table VgcApon_BtApplication (
	businessTripApplicationId bigint not null primary key,
	ticketNo nvarchar(75) null,
	processType nvarchar(75) null,
	subType nvarchar(75) null,
	printName nvarchar(75) null,
	staffCode bigint,
	companyName nvarchar(75) null,
	division nvarchar(75) null,
	department nvarchar(75) null,
	costCenter nvarchar(75) null,
	personalID nvarchar(75) null,
	passportNo nvarchar(75) null,
	officePhone nvarchar(75) null,
	mobilePhone nvarchar(75) null,
	email nvarchar(75) null,
	officeSite nvarchar(75) null,
	approverId bigint,
	approverName nvarchar(75) null,
	isCrossDepartment bit,
	targetDepartmentId bigint,
	targetDepartmentName nvarchar(75) null,
	targetCostCenter nvarchar(75) null,
	targetDepartmentApproverId bigint,
	targetDepartmentApproverName nvarchar(75) null,
	tripType int,
	departureDate datetime null,
	returnDate datetime null,
	purposeOfTheTrip nvarchar(512) null,
	visitCountriesCities nvarchar(75) null,
	advancePayment float,
	currency_ nvarchar(75) null,
	paymentMethods nvarchar(75) null,
	totalCostRmb float,
	totalCostEur float,
	hotelTotalCostRmb float,
	hotelTotalCostEur float,
	carRentalTotalCostRmb float,
	carRentalTotalCostEur float,
	remark nvarchar(512) null,
	status int,
	sapStatus int,
	statusByUserId bigint,
	statusByUserName nvarchar(75) null,
	statusDate datetime null,
	isApplicantAgent bit,
	isApproverAgent bit,
	groupId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	submittedDate datetime null,
	companyId bigint
);

create table VgcApon_BtReimbursement (
	businessTripReimbursementId bigint not null primary key,
	ticketNo nvarchar(75) null,
	bussinessTirpTicketNo nvarchar(75) null,
	processType nvarchar(75) null,
	subType nvarchar(75) null,
	printName nvarchar(75) null,
	staffCode bigint,
	companyName nvarchar(75) null,
	division nvarchar(75) null,
	department nvarchar(75) null,
	costCenter nvarchar(75) null,
	personalID nvarchar(75) null,
	passportNo nvarchar(75) null,
	officePhone nvarchar(75) null,
	mobilePhone nvarchar(75) null,
	email nvarchar(75) null,
	officeSite nvarchar(75) null,
	approverId bigint,
	approverName nvarchar(75) null,
	isCrossDepartment bit,
	targetDepartmentId bigint,
	targetDepartmentName nvarchar(75) null,
	targetCostCenter nvarchar(75) null,
	targetDepartmentApproverId bigint,
	targetDepartmentApproverName nvarchar(75) null,
	tripType int,
	departureDate datetime null,
	returnDate datetime null,
	purposeOfTheTrip nvarchar(512) null,
	visitCountriesCities nvarchar(75) null,
	advancePayment float,
	currency_ nvarchar(75) null,
	paymentMethods nvarchar(75) null,
	totalCostRmb float,
	totalCostEur float,
	hotelTotalCostRmb float,
	hotelTotalCostEur float,
	carRentalTotalCostRmb float,
	carRentalTotalCostEur float,
	totalTravelExpenseRmb float,
	totalTravelExpenseEur float,
	costListInlandTotalRmb float,
	costListForeignTotalEur float,
	costListForeignTotalRmb float,
	remark nvarchar(512) null,
	status int,
	sapStatus int,
	statusByUserId bigint,
	statusByUserName nvarchar(75) null,
	statusDate datetime null,
	isApplicantAgent bit,
	isApproverAgent bit,
	groupId bigint,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	submittedDate datetime null,
	companyId bigint
);

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo nvarchar(75) null,
	pickupLocation nvarchar(75) null,
	pickupDate datetime null,
	dropoffLocation nvarchar(75) null,
	dropoffDate datetime null,
	carType nvarchar(75) null,
	typeOfRental nvarchar(75) null,
	price float,
	currency_ nvarchar(75) null,
	tripType nvarchar(75) null
);

create table vgcapon_BtCostList (
	btCostListId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo nvarchar(75) null,
	item nvarchar(75) null,
	type_ nvarchar(75) null,
	invoiceAmount float,
	invoiceCurrency nvarchar(75) null,
	country nvarchar(75) null,
	city nvarchar(75) null,
	ifPayInRmb bit,
	paymentCurrency nvarchar(75) null,
	paymentAmount float,
	paymentMothed nvarchar(75) null
);

create table vgcapon_BtExchangeRate (
	btExchangeRateId bigint not null primary key,
	firstCurrency nvarchar(75) null,
	secondCurrency nvarchar(75) null,
	firToSecExchangeRate float,
	secToFirExchangeRate float,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	status int
);

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo nvarchar(75) null,
	type_ nvarchar(75) null,
	fromCity nvarchar(75) null,
	toCity nvarchar(75) null,
	departureDate datetime null,
	departureFlight nvarchar(75) null,
	departureTime datetime null,
	classInfo nvarchar(75) null,
	price float,
	currency_ nvarchar(75) null,
	tripType nvarchar(75) null
);

create table vgcapon_BtHotelInfo (
	btHotelInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo nvarchar(75) null,
	city nvarchar(75) null,
	cityType nvarchar(75) null,
	hotel nvarchar(75) null,
	checkIn datetime null,
	checkOut datetime null,
	roomCategory nvarchar(75) null,
	price float,
	currency_ nvarchar(75) null,
	otherReasonInfo nvarchar(512) null,
	isNotBookedFromTA bit,
	isOverBudget int,
	othersSpecify nvarchar(512) null,
	tripType nvarchar(75) null
);

create table vgcapon_BtTrainInfo (
	btTrainInfoId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo nvarchar(75) null,
	fromCity nvarchar(75) null,
	toCity nvarchar(75) null,
	departureDate datetime null,
	departureTrain nvarchar(75) null,
	classInfo nvarchar(75) null,
	price float,
	currency_ nvarchar(75) null,
	tripType nvarchar(75) null
);

create table vgcapon_BtTravelExpense (
	btTravelExpenseId bigint not null primary key,
	businessTripPkId bigint,
	ticketNo nvarchar(75) null,
	date_ datetime null,
	departure datetime null,
	arrival datetime null,
	fromCity nvarchar(75) null,
	toCity nvarchar(75) null,
	isHasBreakfast bit,
	isHasLunch bit,
	isHasDinner bit,
	country nvarchar(75) null,
	city nvarchar(75) null,
	rateOfDma float,
	currency_ nvarchar(75) null,
	comments nvarchar(512) null
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


