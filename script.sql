create table car (
	id serial primary key,
	type varchar(255),
	carName varchar(30),
	price numeric
);
select * from Car;
insert into Car(type, carName, price) values('Sedan','BMW','2350000');
update Car set carName = 'Lada', price = '1350000';
insert into Car(type,carName,price) values('jeep','landCruzer','3500000');
delete from Car;
update Car set carName = 'BMW' where id = '3';