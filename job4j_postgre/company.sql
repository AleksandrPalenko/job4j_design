CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person
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
insert into person(id, name, company_id) values(1, 'alex', 1);
insert into person(id, name, company_id) values(2, 'pavel', 1);
insert into person(id, name, company_id) values(3, 'ivan', 2);
insert into person(id, name, company_id) values(4, 'igor', 2);
insert into person(id, name, company_id) values(5, 'petr', 2);
insert into person(id, name, company_id) values(6, 'tom', 3);
insert into person(id, name, company_id) values(7, 'garry', 3);
insert into person(id, name, company_id) values(8, 'stive', 3);

--1

select c.name, p.name, p.company_id from company c left join person p on c.id = p.company_id
where c.id != 5;

--2(1ый вариант)
with task as(
select c.name as name_c, COUNT(p.name) as kolvo
from company c left join person p 
on c.id = p.company_id
group by c.name)
select name_c, kolvo from task where kolvo in(select max(kolvo) from task);

--(2ой вариант)
-- в подзапросе сгруппировать работников по айди компании, отсортировать по убыванию и использовать limit 1
select c.name as name_c, COUNT(p.name) as kolvo
from company c join person p 
on c.id = p.company_id
group by c.name	
order by count(p.company_id) = (select count(p.company_id)
from person p 
group by p.company_id 
order by count(p.company_id) desc limit 1)



