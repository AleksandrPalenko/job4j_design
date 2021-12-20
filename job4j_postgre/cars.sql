create table body (
	id serial primary key,
	name text
);

create table engine (
	id serial primary key,
	name text
);

create table transmission (
	id serial primary key,
	name text
);

create table car (
	id serial primary key,
	name text,
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id int references transmission(id)
);

insert into body(name) values('minivan');
insert into body(name) values('cabriolet');
insert into body(name) values('picap');
insert into body(name) values('coupe');
insert into body(name) values('hatchbak');

insert into engine(name) values('disel');
insert into engine(name) values('gas');
insert into engine(name) values('electric');
insert into engine(name) values('steam');

insert into transmission(name) values('mechanical');
insert into transmission(name) values('automatic');
insert into transmission(name) values('robot');

insert into car(name, body_id, engine_id, transmission_id) values('bmw', 1, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values('lada', 4, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values('porsche', 2, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values('audi', 3, 3, 2);

select c.name as Машина, b.name as Кузов, e.name as Двигатель, t.name as Коробка 
from car c join body b on c.body_id = b.id join engine e on c.engine_id = e.id
join transmission t on c.transmission_id = t.id

select b.name as Кузов from body b left join car c on b.id = c.body_id where c.name is null
select e.name as Двигатель from engine e left join car c on e.id = c.engine_id where c.name is null
select t.name as Коробка from transmission t left join car c on t.id = c.transmission_id where c.name is null