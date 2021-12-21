create table transaction (
	id serial primary key,
	name int
);

create table Support (
	id serial primary key,
	name varchar(255)
);

create table ADB (
	id serial primary key,
	name varchar(255),
	Support_id int references Support(id)
);

create table DB (
	id serial primary key,
	name varchar(255),
	ADB_id int references ADB(id),
	Transaction_id int references Transaction(id)
);

create table Engenier (
	id serial primary key,
	name varchar(255)
);

create table bank_processing (
	id serial primary key,
	name varchar(255),
	DB_id int references DB(id),
	Engenier_id int references Engenier(id),
	Support_id int references Support(id),
	transaction_id int references transaction(id)
);

insert into Transaction(name) values('48941');
insert into Transaction(name) values('48942');
insert into Transaction(name) values('48943');
insert into Transaction(name) values('48944');

insert into support(name) values('otrs');

insert into ADB(name, Support_id) values('Petr', 1);
insert into ADB(name, Support_id) values('Anna', 1);
insert into ADB(name, Support_id) values('Alexey', 1);

insert into DB(name, ADB_id, Transaction_id) values('Postgre', 1 , 1);
insert into DB(name, ADB_id, Transaction_id) values('Oracle DB', 2 , 2);
insert into DB(name, ADB_id, Transaction_id) values('Mongo DB', 3 , 3);


insert into Engenier(name) values('duty');

insert into bank_processing(name, DB_id, Engenier_id, Support_id, transaction_id) values('way4', 1, 1, 1, 1);
insert into bank_processing(name, DB_id, Engenier_id, Support_id, transaction_id) values('way4', 2, 1, 1, 2);
insert into bank_processing(name, DB_id, Engenier_id, Support_id, transaction_id) values('way4', 3, 1, 1, 3);
insert into bank_processing(name, DB_id, Engenier_id, Support_id, transaction_id) values('way4', 3, 1, 1, 4);
insert into bank_processing(name, DB_id, Engenier_id, Support_id, transaction_id) values('way4', 2, 1, 1, 4);
insert into bank_processing(name, DB_id, Engenier_id, Support_id, transaction_id) values('way4', 2, 1, 1, 4);

create view show_transaction_with_2_or_more_in_db
as select DB.name as БД, count(DB.name), T.name as Транзакция from transaction t
join bank_processing bp on t.id = bp.transaction_id
join DB on bp.DB_id = DB.id
join ADB on DB.ADB_id = ADB.id
join support s on ADB.support_id = s.id
group by (DB.name, T.name) having count(DB.name) >= 2;

select * from show_transaction_with_2_or_more_in_db;

alter view show_transaction_with_2_or_more_in_db rename to show_transactions_with_2_or_more_operaton_in_db;