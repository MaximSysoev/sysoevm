/**** Создание таблиц ****/

create table body (
	id serial primary key,
	name varchar(500)
);

create table engine (
	id serial primary key,
	name varchar(500)
);

create table transmission (
	id serial primary key,
	name varchar(500)
);

create table car (
	id serial primary key,
	name varchar(200),
	body_id int references body(id),
	engine_id int references engine(id),
	transmission_id references transmission(id)
);



/**** Заполнение таблиц ****/

insert into car(name, body_id, engine_id, transmission_id) values('Мерен', 1, 1, 3);
insert into car(name, engine_id) values('Бумер', 1);
insert into car(name, body_id) values('Митцубиши', 1);
insert into car(name, body_id, engine_id, transmission_id) values('Тесла', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values('Вольва', 4, 2, 3);
insert into car(name, body_id, engine_id) values('Крузак', 3, 1);

insert into body(name) values('Седан');
insert into body(name) values('Хетчбек');
insert into body(name) values('Паркетник');
insert into body(name) values('Фургон');
insert into body(name) values('Прицеп');

insert into engine(name) values('2.0');
insert into engine(name) values('1.6');
insert into engine(name) values('3.0');

insert into transmission(name) values('Автомат');
insert into transmission(name) values('Вариатор');
insert into transmission(name) values('Механика');

/**** Запросы ****/

/* 1. Вывести список всех машин и все привязанные к ним детали. */
select c.name, b.name, e.name, t.name from car as c left outer join body as b on c.body_id = b.id
left outer join engine as e on c.engine_id = e.id
left outer join transmission as t on c.transmission_id = t.id where (c.body_id & c.engine_id & c.transmission_id) is not null

/*2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.*/

/**** Вывод всех неиспользуемых кузовов ****/
select b.name from body as b left outer join car as c on c.body_id = b.id where c.id is null;

/**** Вывод всех неиспользуемых двигателей ****/
select e.name from engine as e left outer join car as c on c.engine_id = e.id where c.id is null;

/**** Вывод всех неиспользуемых трансмиссий ****/
select t.name from transmission as t left outer join car as c on c.transmission_id = t.id where c.id is null;
