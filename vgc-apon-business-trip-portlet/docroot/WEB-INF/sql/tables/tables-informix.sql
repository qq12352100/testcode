create table VgcApon_BtApplication (
	businessTripApplicationId int8 not null primary key,
	ticketNo varchar(75),
	processType varchar(75),
	subType varchar(75),
	printName varchar(75),
	staffCode int8,
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
	approverId int8,
	approverName varchar(75),
	isCrossDepartment boolean,
	targetDepartmentId int8,
	targetDepartmentName varchar(75),
	targetCostCenter varchar(75),
	targetDepartmentApproverId int8,
	targetDepartmentApproverName varchar(75),
	tripType int,
	departureDate datetime YEAR TO FRACTION,
	returnDate datetime YEAR TO FRACTION,
	purposeOfTheTrip varchar(512),
	visitCountriesCities varchar(75),
	advancePayment float,
	currency_ varchar(75),
	paymentMethods varchar(75),
	totalCostRmb float,
	totalCostEur float,
	hotelTotalCostRmb float,
	hotelTotalCostEur float,
	carRentalTotalCostRmb float,
	carRentalTotalCostEur float,
	remark varchar(512),
	status int,
	sapStatus int,
	statusByUserId int8,
	statusByUserName varchar(75),
	statusDate datetime YEAR TO FRACTION,
	isApplicantAgent boolean,
	isApproverAgent boolean,
	groupId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	submittedDate datetime YEAR TO FRACTION,
	companyId int8
)
extent size 16 next size 16
lock mode row;

create table VgcApon_BtReimbursement (
	businessTripReimbursementId int8 not null primary key,
	ticketNo varchar(75),
	bussinessTirpTicketNo varchar(75),
	processType varchar(75),
	subType varchar(75),
	printName varchar(75),
	staffCode int8,
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
	approverId int8,
	approverName varchar(75),
	isCrossDepartment boolean,
	targetDepartmentId int8,
	targetDepartmentName varchar(75),
	targetCostCenter varchar(75),
	targetDepartmentApproverId int8,
	targetDepartmentApproverName varchar(75),
	tripType int,
	departureDate datetime YEAR TO FRACTION,
	returnDate datetime YEAR TO FRACTION,
	purposeOfTheTrip varchar(512),
	visitCountriesCities varchar(75),
	advancePayment float,
	currency_ varchar(75),
	paymentMethods varchar(75),
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
	remark varchar(512),
	status int,
	sapStatus int,
	statusByUserId int8,
	statusByUserName varchar(75),
	statusDate datetime YEAR TO FRACTION,
	isApplicantAgent boolean,
	isApproverAgent boolean,
	groupId int8,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	submittedDate datetime YEAR TO FRACTION,
	companyId int8
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId int8 not null primary key,
	businessTripPkId int8,
	ticketNo varchar(75),
	pickupLocation varchar(75),
	pickupDate datetime YEAR TO FRACTION,
	dropoffLocation varchar(75),
	dropoffDate datetime YEAR TO FRACTION,
	carType varchar(75),
	typeOfRental varchar(75),
	price float,
	currency_ varchar(75),
	tripType varchar(75)
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtCostList (
	btCostListId int8 not null primary key,
	businessTripPkId int8,
	ticketNo varchar(75),
	item varchar(75),
	type_ varchar(75),
	invoiceAmount float,
	invoiceCurrency varchar(75),
	country varchar(75),
	city varchar(75),
	ifPayInRmb boolean,
	paymentCurrency varchar(75),
	paymentAmount float,
	paymentMothed varchar(75)
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtExchangeRate (
	btExchangeRateId int8 not null primary key,
	firstCurrency varchar(75),
	secondCurrency varchar(75),
	firToSecExchangeRate float,
	secToFirExchangeRate float,
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	modifiedDate datetime YEAR TO FRACTION,
	status int
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId int8 not null primary key,
	businessTripPkId int8,
	ticketNo varchar(75),
	type_ varchar(75),
	fromCity varchar(75),
	toCity varchar(75),
	departureDate datetime YEAR TO FRACTION,
	departureFlight varchar(75),
	departureTime datetime YEAR TO FRACTION,
	classInfo varchar(75),
	price float,
	currency_ varchar(75),
	tripType varchar(75)
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtHotelInfo (
	btHotelInfoId int8 not null primary key,
	businessTripPkId int8,
	ticketNo varchar(75),
	city varchar(75),
	cityType varchar(75),
	hotel varchar(75),
	checkIn datetime YEAR TO FRACTION,
	checkOut datetime YEAR TO FRACTION,
	roomCategory varchar(75),
	price float,
	currency_ varchar(75),
	otherReasonInfo varchar(512),
	isNotBookedFromTA boolean,
	isOverBudget int,
	othersSpecify varchar(512),
	tripType varchar(75)
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtTrainInfo (
	btTrainInfoId int8 not null primary key,
	businessTripPkId int8,
	ticketNo varchar(75),
	fromCity varchar(75),
	toCity varchar(75),
	departureDate datetime YEAR TO FRACTION,
	departureTrain varchar(75),
	classInfo varchar(75),
	price float,
	currency_ varchar(75),
	tripType varchar(75)
)
extent size 16 next size 16
lock mode row;

create table vgcapon_BtTravelExpense (
	btTravelExpenseId int8 not null primary key,
	businessTripPkId int8,
	ticketNo varchar(75),
	date_ datetime YEAR TO FRACTION,
	departure datetime YEAR TO FRACTION,
	arrival datetime YEAR TO FRACTION,
	fromCity varchar(75),
	toCity varchar(75),
	isHasBreakfast boolean,
	isHasLunch boolean,
	isHasDinner boolean,
	country varchar(75),
	city varchar(75),
	rateOfDma float,
	currency_ varchar(75),
	comments varchar(512)
)
extent size 16 next size 16
lock mode row;
