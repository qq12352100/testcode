create table VgcApon_BtApplication (
	businessTripApplicationId int64 not null primary key,
	ticketNo varchar(75),
	processType varchar(75),
	subType varchar(75),
	printName varchar(75),
	staffCode int64,
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
	approverId int64,
	approverName varchar(75),
	isCrossDepartment smallint,
	targetDepartmentId int64,
	targetDepartmentName varchar(75),
	targetCostCenter varchar(75),
	targetDepartmentApproverId int64,
	targetDepartmentApproverName varchar(75),
	tripType integer,
	departureDate timestamp,
	returnDate timestamp,
	purposeOfTheTrip varchar(512),
	visitCountriesCities varchar(75),
	advancePayment double precision,
	currency_ varchar(75),
	paymentMethods varchar(75),
	totalCostRmb double precision,
	totalCostEur double precision,
	hotelTotalCostRmb double precision,
	hotelTotalCostEur double precision,
	carRentalTotalCostRmb double precision,
	carRentalTotalCostEur double precision,
	remark varchar(512),
	status integer,
	sapStatus integer,
	statusByUserId int64,
	statusByUserName varchar(75),
	statusDate timestamp,
	isApplicantAgent smallint,
	isApproverAgent smallint,
	groupId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	submittedDate timestamp,
	companyId int64
);

create table VgcApon_BtReimbursement (
	businessTripReimbursementId int64 not null primary key,
	ticketNo varchar(75),
	bussinessTirpTicketNo varchar(75),
	processType varchar(75),
	subType varchar(75),
	printName varchar(75),
	staffCode int64,
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
	approverId int64,
	approverName varchar(75),
	isCrossDepartment smallint,
	targetDepartmentId int64,
	targetDepartmentName varchar(75),
	targetCostCenter varchar(75),
	targetDepartmentApproverId int64,
	targetDepartmentApproverName varchar(75),
	tripType integer,
	departureDate timestamp,
	returnDate timestamp,
	purposeOfTheTrip varchar(512),
	visitCountriesCities varchar(75),
	advancePayment double precision,
	currency_ varchar(75),
	paymentMethods varchar(75),
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
	remark varchar(512),
	status integer,
	sapStatus integer,
	statusByUserId int64,
	statusByUserName varchar(75),
	statusDate timestamp,
	isApplicantAgent smallint,
	isApproverAgent smallint,
	groupId int64,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	submittedDate timestamp,
	companyId int64
);

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId int64 not null primary key,
	businessTripPkId int64,
	ticketNo varchar(75),
	pickupLocation varchar(75),
	pickupDate timestamp,
	dropoffLocation varchar(75),
	dropoffDate timestamp,
	carType varchar(75),
	typeOfRental varchar(75),
	price double precision,
	currency_ varchar(75),
	tripType varchar(75)
);

create table vgcapon_BtCostList (
	btCostListId int64 not null primary key,
	businessTripPkId int64,
	ticketNo varchar(75),
	item varchar(75),
	type_ varchar(75),
	invoiceAmount double precision,
	invoiceCurrency varchar(75),
	country varchar(75),
	city varchar(75),
	ifPayInRmb smallint,
	paymentCurrency varchar(75),
	paymentAmount double precision,
	paymentMothed varchar(75)
);

create table vgcapon_BtExchangeRate (
	btExchangeRateId int64 not null primary key,
	firstCurrency varchar(75),
	secondCurrency varchar(75),
	firToSecExchangeRate double precision,
	secToFirExchangeRate double precision,
	userId int64,
	userName varchar(75),
	createDate timestamp,
	modifiedDate timestamp,
	status integer
);

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId int64 not null primary key,
	businessTripPkId int64,
	ticketNo varchar(75),
	type_ varchar(75),
	fromCity varchar(75),
	toCity varchar(75),
	departureDate timestamp,
	departureFlight varchar(75),
	departureTime timestamp,
	classInfo varchar(75),
	price double precision,
	currency_ varchar(75),
	tripType varchar(75)
);

create table vgcapon_BtHotelInfo (
	btHotelInfoId int64 not null primary key,
	businessTripPkId int64,
	ticketNo varchar(75),
	city varchar(75),
	cityType varchar(75),
	hotel varchar(75),
	checkIn timestamp,
	checkOut timestamp,
	roomCategory varchar(75),
	price double precision,
	currency_ varchar(75),
	otherReasonInfo varchar(512),
	isNotBookedFromTA smallint,
	isOverBudget integer,
	othersSpecify varchar(512),
	tripType varchar(75)
);

create table vgcapon_BtTrainInfo (
	btTrainInfoId int64 not null primary key,
	businessTripPkId int64,
	ticketNo varchar(75),
	fromCity varchar(75),
	toCity varchar(75),
	departureDate timestamp,
	departureTrain varchar(75),
	classInfo varchar(75),
	price double precision,
	currency_ varchar(75),
	tripType varchar(75)
);

create table vgcapon_BtTravelExpense (
	btTravelExpenseId int64 not null primary key,
	businessTripPkId int64,
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
	rateOfDma double precision,
	currency_ varchar(75),
	comments varchar(512)
);