create table products
(
	id serial not null
			primary key,
	name varchar(255),
	amount integer not null
);

INSERT INTO
    products (name, amount)
VALUES ('product1', 10),
       ('product1', 20),
       ('product2', 15),
       ('product3', 11);


