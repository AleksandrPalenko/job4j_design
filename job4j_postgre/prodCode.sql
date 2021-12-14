create table code (
	id serial primary key,
	number int
);
insert into code(number) values(123456789);

create table products (
	id serial primary key,
	computer varchar(255),
	product_id int references code(id) unique
);
insert into products(computer) values('acer nitro 5');
