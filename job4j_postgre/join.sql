create table departments(
	id serial primary key,
	name text
);


create table emploers(
	id serial primary key,
	departments_id int references departments(id),
	name text
);

insert into departments(name) values('sport');
insert into departments(name) values('medicine');
insert into departments(name) values('science');
insert into departments(name) values('build');

insert into emploers(departments_id,name) values(1, 'Petr');
insert into emploers(departments_id,name) values(2, 'Sasha');
insert into emploers(departments_id,name) values(3, 'Ivan');

select * from departments d left join emploers e on d.id = e.departments_id;
select * from departments d right join emploers e on d.id = e.departments_id;
select * from departments d inner join emploers e on d.id = e.departments_id;
select * from departments d cross join emploers e;

select * from departments d left join emploers e on d.id = e.departments_id 
where departments_id is null;

create table marriage (
	id serial primary key,
	name text,
	mariages varchar(10)
);

insert into marriage (name,mariages) values ('Igor','hetero');
insert into marriage (name,mariages) values ('Natasha','hetero');
insert into marriage (name,mariages) values ('Dima','unisexual');
insert into marriage (name,mariages) values ('Nastya','unisexual');

create table teens(
	id serial primary key,
	name text,
	gender varchar(155),
	marriage_id int references marriage(id)
);

insert into teens(name, gender) values('Pavel', 'man');
insert into teens(name, gender) values('Darya', 'woman');
insert into teens(name, gender) values('Ivan', 'man');
insert into teens(name, gender) values('Anna', 'woman');

select t.name, m.name, m.mariages from teens t cross join marriage m 



