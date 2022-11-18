DROP DATABASE IF EXISTS Logistics_Company;

CREATE DATABASE Logistics_Company;

use Logistics_Company;	

CREATE TABLE city
(
id int auto_increment primary key not null,
city_name varchar(45) not null
);

CREATE TABLE truck
(
id int auto_increment primary key not null,
unique_number varchar(7),
capacity_tons int not null,
t_status bool not null,
id_city int not null unique,
CONSTRAINT FOREIGN KEY(id_city) REFERENCES city(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE driver
(
id int auto_increment not null,
driver_name varchar(45) not null,
surname varchar(45) not null,
personal_number int(7) not null,
working_hours_month int not null,
driver_status boolean not null,
id_city int not null unique,
PRIMARY KEY(id),
CONSTRAINT FOREIGN KEY(id_city) REFERENCES city(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE truck_driver
(
id int auto_increment not null,
id_truck int not null unique,
id_driver int not null unique,
PRIMARY KEY(id),
CONSTRAINT FOREIGN KEY(id_truck) REFERENCES truck(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT FOREIGN KEY(id_driver) REFERENCES driver(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE cargo
(
id int auto_increment primary key not null,
unique_number int not null,
cargo_name varchar(45) not null,
weight_kg int not null,
cargo_status varchar(9) default null
);

CREATE TABLE logistic_order
(
id int auto_increment not null,
completed bool not null,
order_name varchar(45) not null,
id_city_from int not null unique,
id_city_to int not null unique,
id_truck int not null unique,
id_driver int not null unique,
PRIMARY KEY(id),
CONSTRAINT FOREIGN KEY(id_truck) REFERENCES truck(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT FOREIGN KEY(id_driver) REFERENCES driver(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT FOREIGN KEY(id_city_from) REFERENCES city(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT FOREIGN KEY(id_city_to) REFERENCES city(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE cargo_order
(
id int auto_increment not null,
id_cargo int not null unique,
id_order int not null unique,
PRIMARY KEY(id),
CONSTRAINT FOREIGN KEY(id_cargo) REFERENCES cargo(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT FOREIGN KEY(id_order) REFERENCES logistic_order(id) ON DELETE NO ACTION ON UPDATE NO ACTION
);


CREATE TABLE country_map
(
id int auto_increment primary key not null,
id_city_from int not null unique,
id_city_to int not null unique,
distance int not null,
CONSTRAINT FOREIGN KEY(id_city_from) REFERENCES city(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
CONSTRAINT FOREIGN KEY(id_city_to) REFERENCES city(id) ON DELETE NO ACTION ON UPDATE NO ACTION
); 