insert into users(name) values('Ivan');
insert into users(name) values('Aleksandr');
insert into role(nameOfRole) values('programmer');
insert into role(nameOfRole) values('lead');
insert into rules(nameOfRule) values('commit');
insert into rules(nameOfRule) values('task');
select * from rules;
insert into role_rules(role_id, rules_id) values(9, 9); 
insert into role_rules(role_id, rules_id) values(10, 10);
insert into comments(name) values ('check');
insert into attachs(name) values ('git');
insert into category(nameOfCategory) values('back-end');
insert into state(name) values('done');

