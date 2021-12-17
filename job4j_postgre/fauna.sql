create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);
insert into fauna(name, avg_age, discovery_date) values('горилла', 18250, null);
insert into fauna(name, avg_age, discovery_date) values('шагающая акула', 10950, date '2006-10-10');
insert into fauna(name, avg_age, discovery_date) values('паук дарвина', 7300, date '2001-04-01');

select * from fauna;
select * from fauna where name like '%fish%';
select * from fauna where avg_age BETWEEN '10000' AND '210000';
select * from fauna where discovery_date is null;
select * from fauna where discovery_date <= '1950-01-01';
