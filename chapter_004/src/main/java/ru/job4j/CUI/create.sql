create database db;

create table role (
	id serial primary key,
	name varchar(1000)
);

create table users (
	id serial primary key,
	name varchar(1000),
	role_id int references role(id)
);

create table rules (
	id serial primary key,
	name varchar (100)
);

create table rules_role (
	id serial primary key,
	role_id int references role(id),
	rules_id int references rules(id)
);

create table category (
	id serial primary key,
	name varchar(1000)
);

create table state (
	id serial primary key,
	name varchar(100)
);

create table item (
	id serial primary key,
	name varchar(100),
	users_id int references users(id),
	category_id int references category(id),
	state_id int references state(id)
);

create table comments (
	id serial primary key,
	txt varchar (2000),
	item_id int references item(id)
);

create table attachs (
	id serial primary key,
	name varchar (500),
	item_id int references item(id)
);

insert into role(name) values('admin');
insert into role(name) values('guest');

insert into users(name, role_id) values('Иванов', '1');
insert into users(name, role_id) values('Петров', '2');
insert into users(name, role_id) values('Сидоров', '2');

insert into rules(name) values('Запись/Чтение');
insert into rules(name) values('Чтение');

insert into category(name) values('Категория 1');
insert into category(name) values('Категория 2');

insert into state(name) values('Завершена');
insert into state(name) values('В обработке');

insert into item(name, users_id, category_id, state_id) values('Заявка', 1, 1, 2);

insert into comments(txt, item_id) values('Комментрарий', '1');
insert into comments(txt, item_id) values('Комментрарий', '2');
insert into comments(txt, item_id) values('Комментрарий', '2');
insert into comments(txt, item_id) values('Комментрарий', '3');

insert into attachs(name, item_id) values('Файл', '1');
insert into attachs(name, item_id) values('Файл', '2');
insert into attachs(name, item_id) values('Файл', '3');