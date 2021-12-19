create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);
select * from devices_people
insert into devices_people(device_id, people_id) values(1,1);
insert into devices_people(device_id, people_id) values(2,2);
insert into devices_people(device_id, people_id) values(3,3);
insert into devices(name, price) values ('phone', 20000);
insert into devices(name, price) values ('clock', 25000);
insert into devices(name, price) values ('computer', 55000);
insert into devices(name, price) values ('headphones', 5000);

insert into people(name) values ('Петр');
insert into people(name) values ('Саша');
insert into people(name) values ('Маша');
insert into people(name) values ('Настя');

select avg(price) from devices;
select min(price) from devices;
select max(price) from devices;

select p.name as Имя, avg(d.price) as Цена 
from devices as d join people as p on d.id = p.id
join devices_people as dp on d.id = dp.device_id
AND p.id = dp.people_id
group by p.name
having avg(d.price) > 5000;
