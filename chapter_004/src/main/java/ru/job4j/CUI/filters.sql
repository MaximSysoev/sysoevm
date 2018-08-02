/**** Создание таблиц ****/

create table type (
	id serial primary key,
	name varchar(500);
);

create table product (
	id serial primary key,
	name varchar(500),
	type_id int references type(id),
	expired_date timestamp,
	price int
);


/******* Заполение таблиц ********/

insert into type(name) values('сыр');
insert into type(name) values('молоко');
insert into type(name) values('мороженное');

insert into product(name, type_id, expired_date, price) values('Пармезан', 1, '2018-07-08', 30);
insert into product(name, type_id, expired_date, price) values('Тильтезер', 1, '2018-07-15', 70);
insert into product(name, type_id, expired_date, price) values('Гауда', 1, '2018-07-05', 30);
insert into product(name, type_id, expired_date, price) values('Российский', 1, '2018-07-20', 30);
insert into product(name, type_id, expired_date, price) values('Голландский', 1, '2018-07-08', 20);
insert into product(name, type_id, expired_date, price) values('Молоко1', 2, '2018-07-12', 10);
insert into product(name, type_id, expired_date, price) values('Молоко2', 2, '2018-07-19', 17);
insert into product(name, type_id, expired_date, price) values('Молоко3', 2, '2018-07-17', 14);
insert into product(name, type_id, expired_date, price) values('Пломбир клубничный', 3, '2018-07-25', 22);
insert into product(name, type_id, expired_date, price) values('Пломбир шоколадный', 3, '2018-07-24', 23);
insert into product(name, type_id, expired_date, price) values('Эскимо', 3, '2018-07-20', 27);

/* 1. Написать запрос получение всех продуктов с типом "СЫР" */
select t.name, p.name, p.expired_date, p.price from type as t inner join product as p on t.id = p.type_id where t.id = 1;

/* 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное" */
select p.name from product as p where p.name like '%Мороженное%';

/* 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.*/
select p.name from product as p where p.expired_date > '2018-07-30 23:59:59';

/* 4. Написать запрос, который вывод самый дорогой продукт. */
select MAX(p.price) from product as p;

/* 5. Написать запрос, который выводит количество всех продуктов определенного типа. */
select count(p.id) from product as p inner join type as t on t.id=p.type_id where t.name = 'сыр';

/* 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО" */
select p.name, p.expired_date, p.price from product as p inner join type as t on t.id=p.type_id where t.name='молоко' or t.name='сыр';

/* 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 5 штук. */
select t.name from type as t inner join product as p on t.id = p.type_id where count(p.name) < 5;

/* 8. Вывести все продукты и их тип. */
select p.name, t.name from product as p inner join type as t on p.type_id = t.id;