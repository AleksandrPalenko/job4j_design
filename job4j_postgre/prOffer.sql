create table programmer (
	id serial primary key,
	name varchar(255)
);
create table jobOffer (
	id serial primary key,
	offer boolean
);
create table programmer_jobOffer (
	id serial primary key,
	programmer_id int references programmer(id),
	jobOffer_id int references jobOffer(id)
);

insert into programmer(name) values ('Ivan');
insert into programmer(name) values ('Kirill');
insert into programmer(name) values ('Roman');

insert into jobOffer(offer) values (true);
insert into jobOffer(offer) values (false);
insert into jobOffer(offer) values (true);

insert into programmer_jobOffer(programmer_id, jobOffer_id) values (1, 1);
insert into programmer_jobOffer(programmer_id, jobOffer_id) values (2, 2);
insert into programmer_jobOffer(programmer_id, jobOffer_id) values (3, 1);
select * from programmer_jobOffer