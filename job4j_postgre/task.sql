CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE user
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values(1, 'lukoil');
insert into company(id, name) values(2, 'gazprom');
insert into company(id, name) values(3, 'sibneft');
select * from company
insert into user(id, name, company_id) values(1, 'alex', 1);
insert into user(id, name, company_id) values(2, 'pavel', 1);
insert into user(id, name, company_id) values(3, 'ivan', 2);
insert into user(id, name, company_id) values(4, 'igor', 2);
insert into user(id, name, company_id) values(5, 'petr', 2);
insert into user(id, name, company_id) values(6, 'tom', 3);
insert into user(id, name, company_id) values(7, 'garry', 3);
insert into user(id, name, company_id) values(8, 'stive', 3);

--1(1)
select p.name, p.company_id from user p left join company c on p.company_id = c.id
where c.id != 5

--1(2)
select c.name, p.name from company c left join user p on c.id = p.company_id;

--2
with task as(
select c.name as name_c, COUNT(p.name) as kolvo
from company c left join user p
on c.id = p.company_id
group by c.name)
select name_c, kolvo from task where kolvo in(select max(kolvo) from task)


