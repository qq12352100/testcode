create index IX_22A8B on VgcApon_BtApplication (status);
create index IX_6C94B4D4 on VgcApon_BtApplication (status, ticketNo, approverName, sapStatus);
create index IX_D1E3FD08 on VgcApon_BtApplication (status, ticketNo, printName, sapStatus);
create index IX_C31DC7C5 on VgcApon_BtApplication (status, userId);
create index IX_75F6CC06 on VgcApon_BtApplication (ticketNo);

create index IX_3948E950 on VgcApon_BtReimbursement (bussinessTirpTicketNo);
create index IX_C651DED on VgcApon_BtReimbursement (status, userId);
create index IX_C463E02E on VgcApon_BtReimbursement (ticketNo);

create index IX_EFFD9C3D on vgcapon_BtCarRentalInfo (businessTripPkId, tripType);
create index IX_C7752A0F on vgcapon_BtCarRentalInfo (ticketNo, tripType);

create index IX_889695B1 on vgcapon_BtCostList (businessTripPkId);
create index IX_F183A216 on vgcapon_BtCostList (businessTripPkId, paymentCurrency);
create index IX_D5AEF903 on vgcapon_BtCostList (ticketNo);

create index IX_C6FE05FA on vgcapon_BtEntertainmentDetail (btCostListId);

create index IX_A05EFAD6 on vgcapon_BtExchangeRate (firstCurrency, secondCurrency, status);
create index IX_59ADE3E0 on vgcapon_BtExchangeRate (status);

create index IX_C046B5DD on vgcapon_BtFlightTrainInfo (businessTripPkId, tripType);
create index IX_84C1E3AF on vgcapon_BtFlightTrainInfo (ticketNo, tripType);

create index IX_58E6BC59 on vgcapon_BtHotelInfo (businessTripPkId, tripType);
create index IX_439E262B on vgcapon_BtHotelInfo (ticketNo, tripType);

create index IX_EA4F7F5E on vgcapon_BtReimbursementSAPInfo (currency_, businessTripPkId);

create index IX_1223D7AD on vgcapon_BtTrainInfo (businessTripPkId, tripType);
create index IX_6585D57F on vgcapon_BtTrainInfo (ticketNo, tripType);

create index IX_43CE2982 on vgcapon_BtTravelExpense (businessTripPkId);
create index IX_69E807DC on vgcapon_BtTravelExpense (businessTripPkId, currency_);
create index IX_8126335 on vgcapon_BtTravelExpense (businessTripPkId, tripType);
create index IX_973BEDD4 on vgcapon_BtTravelExpense (ticketNo);
create index IX_815C6907 on vgcapon_BtTravelExpense (ticketNo, tripType);