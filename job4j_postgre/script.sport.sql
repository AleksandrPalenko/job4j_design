create table sport (
	id serial primary key,
	name varchar(255)
);
select * from sport;
insert into sport(name) values('football');
insert into sport(name) values('chess');
update sport set name = 'tennis' where name = 'chess'

create table sportsman(
	id serial primary key,
	name varchar(255),
	sport_id int references sport(id)
);
insert into sportsman(name , sport_id) values ('Andrey', 1);
insert into sportsman(name, sport_id) values ('Ivan', 1);
update sportsman set sport_id = 2 where name = 'Ivan';
select * from sportsman;
select * from sport where id in (select id from sportsman);