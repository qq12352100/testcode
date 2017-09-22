create index IX_1568426 on vgcapon_CompanyCarManagement (carNo);
create index IX_E435A81C on vgcapon_CompanyCarManagement (carType, contractType, carBrand, carCategory);

create index IX_CBB4C68E on vgcapon_FirstCompanyCar (status, userId);

create index IX_85250970 on vgcapon_SecondCompanyCar (status, userId);