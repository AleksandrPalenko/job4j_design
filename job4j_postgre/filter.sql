create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name text,
	type_id int references type(id),
	expire_date date,
	price float
);

select * from type;
insert into type(name) values('СЫР');
insert into type(name) values('КОЛБАСА');
insert into product(name, type_id, expire_date, price) values('parmesan', 1, date '2022-10-12', 300);
insert into type(name) values('МОЛОКО');
insert into product(name, type_id, expire_date, price) values('milk', 2, date '2021-10-10', 1000);
insert into product(name, type_id, expire_date, price) values('Охотничья колбаса', 3, date '2021-12-25', 1500);
insert into product(name, type_id, expire_date, price) values('Hohland', 1, date '2021-11-30', 1010);
insert into product(name, type_id, expire_date, price) values('milkFromKrasnadar', 2, date '2021-12-19', 1080);
insert into product(name, type_id, expire_date, price) values('milkFromSochi', 2, date '2022-01-10', 7854);


--1
select * from product as p join type as t on p.type_id = t.id
where t.name like '%СЫР%';

--2
select * from product where name like '%мороженое%';

--3
select * from product as p join type as t on p.type_id = t.id
where p.expire_date  < current_date;

--4
select name, price from product
where price = (select max(price) from product);

--5
select t.name as Название, COUNT(p.name) as Количество
from product as p join type as t on p.type_id = t.id
group by t.name;

--6
select p.name, p.price, p.expire_date
from product as p join type as t on p.type_id = t.id
where t.name = 'МОЛОКО' OR t.name = 'СЫР';

--7
select p.name from product as p join type as t on p.type_id = t.id
group by p.name
having count(*) < 10;

--8
select t.name, p.name from product as p join type as t on p.type_id = t.id;


