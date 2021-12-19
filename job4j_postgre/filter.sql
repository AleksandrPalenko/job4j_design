create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expire_date bool,
	price float
);
select * from type;
insert into type(name) values('СЫР');
insert into type(name) values('КОЛБАСА');
insert into product(name, type_id, expire_date, price) values('parmesan', 1, false, 300);
insert into type(name) values('МОЛОКО');
insert into product(name, type_id, expire_date, price) values('milk', 2, true, 100);

--1
select * from product as p join type as t on p.type_id = t.id
where t.name like '%СЫР%';

--2
select * from product as p join type as t on p.type_id = t.id
where t.name like '%мороженое%';

--3
select * from product as p join type as t on p.type_id = t.id
where p.expire_date = true;

--4
select MAX(price) from product as p join type as t on p.type_id = t.id;

--5
select t.name, COUNT(p.name) from product as p join type as t on p.type_id = t.id
group by t.name;

--6
select t.name from product as p join type as t on p.type_id = t.id
where t.name like '%МОЛОКО%' OR t.name like '%СЫР%';

--7
select t.name from product as p join type as t on p.type_id = t.id
group by t.name
having SUM(p.id) < 10;

--8
select t.name, p.name from product as p join type as t on p.type_id = t.id;


