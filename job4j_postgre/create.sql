create table role(
	id serial primary key,
	nameOfRole varchar(255)
);

create table users(
	id serial primary key,
	name text,
	role_id int reference role(id)
);

create table rules(
	id serial primary key,
	nameOfRule varchar(255)
);

create table role_rules(
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table category (
	id serial primary key,
	nameOfCategory varchar(255)
);

create table state (
	id serial primary key,
	name varchar(255)
);

create table item (
	id serial primary key,
	nameOfItem varchar(255),
	users_id int references users(id),
	category_id references category(id),
	state_id references category(id)
);

create table comments (
	id serial primary key,
	name varchar(255),
	item_id int references item(id)
);

create table attachs (
	id serial primary key,
	name varchar(255),
	item_id int references item(id)
);
