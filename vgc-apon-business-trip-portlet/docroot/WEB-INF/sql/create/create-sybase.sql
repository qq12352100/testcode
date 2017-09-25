use master
exec sp_dboption 'lportal', 'allow nulls by default' , true
go

exec sp_dboption 'lportal', 'select into/bulkcopy/pllsort' , true
go

use lportal

create table VgcApon_BtApplication (
	businessTripApplicationId decimal(20,0) not null primary key,
	ticketNo varchar(75) null,
	processType varchar(75) null,
	subType varchar(75) null,
	printName varchar(75) null,
	staffCode decimal(20,0),
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
	approverId decimal(20,0),
	approverName varchar(75) null,
	isCrossDepartment int,
	targetDepartmentId decimal(20,0),
	targetDepartmentName varchar(75) null,
	targetCostCenter varchar(75) null,
	targetDepartmentApproverId decimal(20,0),
	targetDepartmentApproverName varchar(75) null,
	tripType int,
	departureDate datetime null,
	returnDate datetime null,
	purposeOfTheTrip varchar(512) null,
	visitCountriesCities varchar(75) null,
	advancePayment float,
	currency_ varchar(75) null,
	paymentMethods varchar(75) null,
	totalCostRmb float,
	totalCostEur float,
	hotelTotalCostRmb float,
	hotelTotalCostEur float,
	carRentalTotalCostRmb float,
	carRentalTotalCostEur float,
	remark varchar(512) null,
	status int,
	sapStatus int,
	statusByUserId decimal(20,0),
	statusByUserName varchar(75) null,
	statusDate datetime null,
	isApplicantAgent int,
	isApproverAgent int,
	groupId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	submittedDate datetime null,
	companyId decimal(20,0)
)
go

create table VgcApon_BtReimbursement (
	businessTripReimbursementId decimal(20,0) not null primary key,
	ticketNo varchar(75) null,
	bussinessTirpTicketNo varchar(75) null,
	processType varchar(75) null,
	subType varchar(75) null,
	printName varchar(75) null,
	staffCode decimal(20,0),
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
	approverId decimal(20,0),
	approverName varchar(75) null,
	isCrossDepartment int,
	targetDepartmentId decimal(20,0),
	targetDepartmentName varchar(75) null,
	targetCostCenter varchar(75) null,
	targetDepartmentApproverId decimal(20,0),
	targetDepartmentApproverName varchar(75) null,
	tripType int,
	departureDate datetime null,
	returnDate datetime null,
	purposeOfTheTrip varchar(512) null,
	visitCountriesCities varchar(75) null,
	advancePayment float,
	currency_ varchar(75) null,
	paymentMethods varchar(75) null,
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
	remark varchar(512) null,
	status int,
	sapStatus int,
	statusByUserId decimal(20,0),
	statusByUserName varchar(75) null,
	statusDate datetime null,
	isApplicantAgent int,
	isApproverAgent int,
	groupId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	submittedDate datetime null,
	companyId decimal(20,0)
)
go

create table vgcapon_BtCarRentalInfo (
	btCarRentalInfoId decimal(20,0) not null primary key,
	businessTripPkId decimal(20,0),
	ticketNo varchar(75) null,
	pickupLocation varchar(75) null,
	pickupDate datetime null,
	dropoffLocation varchar(75) null,
	dropoffDate datetime null,
	carType varchar(75) null,
	typeOfRental varchar(75) null,
	price float,
	currency_ varchar(75) null,
	tripType varchar(75) null
)
go

create table vgcapon_BtCostList (
	btCostListId decimal(20,0) not null primary key,
	businessTripPkId decimal(20,0),
	ticketNo varchar(75) null,
	item varchar(75) null,
	type_ varchar(75) null,
	invoiceAmount float,
	invoiceCurrency varchar(75) null,
	country varchar(75) null,
	city varchar(75) null,
	ifPayInRmb int,
	paymentCurrency varchar(75) null,
	paymentAmount float,
	paymentMothed varchar(75) null
)
go

create table vgcapon_BtExchangeRate (
	btExchangeRateId decimal(20,0) not null primary key,
	firstCurrency varchar(75) null,
	secondCurrency varchar(75) null,
	firToSecExchangeRate float,
	secToFirExchangeRate float,
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	modifiedDate datetime null,
	status int
)
go

create table vgcapon_BtFlightTrainInfo (
	btFlightTrainInfoId decimal(20,0) not null primary key,
	businessTripPkId decimal(20,0),
	ticketNo varchar(75) null,
	type_ varchar(75) null,
	fromCity varchar(75) null,
	toCity varchar(75) null,
	departureDate datetime null,
	departureFlight varchar(75) null,
	departureTime datetime null,
	classInfo varchar(75) null,
	price float,
	currency_ varchar(75) null,
	tripType varchar(75) null
)
go

create table vgcapon_BtHotelInfo (
	btHotelInfoId decimal(20,0) not null primary key,
	businessTripPkId decimal(20,0),
	ticketNo varchar(75) null,
	city varchar(75) null,
	cityType varchar(75) null,
	hotel varchar(75) null,
	checkIn datetime null,
	checkOut datetime null,
	roomCategory varchar(75) null,
	price float,
	currency_ varchar(75) null,
	otherReasonInfo varchar(512) null,
	isNotBookedFromTA int,
	isOverBudget int,
	othersSpecify varchar(512) null,
	tripType varchar(75) null
)
go

create table vgcapon_BtTrainInfo (
	btTrainInfoId decimal(20,0) not null primary key,
	businessTripPkId decimal(20,0),
	ticketNo varchar(75) null,
	fromCity varchar(75) null,
	toCity varchar(75) null,
	departureDate datetime null,
	departureTrain varchar(75) null,
	classInfo varchar(75) null,
	price float,
	currency_ varchar(75) null,
	tripType varchar(75) null
)
go

create table vgcapon_BtTravelExpense (
	btTravelExpenseId decimal(20,0) not null primary key,
	businessTripPkId decimal(20,0),
	ticketNo varchar(75) null,
	date_ datetime null,
	departure datetime null,
	arrival datetime null,
	fromCity varchar(75) null,
	toCity varchar(75) null,
	isHasBreakfast int,
	isHasLunch int,
	isHasDinner int,
	country varchar(75) null,
	city varchar(75) null,
	rateOfDma float,
	currency_ varchar(75) null,
	comments varchar(512) null
)
go




