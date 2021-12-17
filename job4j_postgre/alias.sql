create table code (
	id serial primary key,
	number int
);
insert into code(number) values(123456789);
insert into code(number) values(459498124);
insert into code(number) values(484511213);

create table products (
	id serial primary key,
	computer varchar(255),
	product_id int references code(id) uniq
);
insert into products(computer, product_id) values('acer nitro 5', 1);
insert into products(computer, product_id) values('HUAWEI MateBook D 14', 2);
insert into products(computer, product_id) values('Apple MacBook Air 13', 3);

select * from products p join code c on p.id = c.id; 

select p.computer, c.number from products as p join
code as c on p.id = c.id;

select p.computer as Название, 
c.number as Серийный_номер from products as p 
join code as c on p.product_id = c.id;