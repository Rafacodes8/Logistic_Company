CREATE DATABASE Logistics_Company;

use Logistics_Company;	

CREATE TABLE Truck
(
Id_Number varchar(7) primary key not null,
Capacity int not null,
T_Status bool not null,
City varchar (25)
);

CREATE TABLE Driver
(
Id_Driver int auto_increment primary key not null,
Driver_Name varchar(45) not null,
Surname varchar(45) not null,
Personal_Number int(7) not null,
Working_Hours_Month int not null,
Driver_Status boolean not null,
Current_City varchar(45),
Current_Truck varchar(7)
);

CREATE TABLE Logistic_Order
(
Id_Order int not null unique,
Completed bool not null,
Appointed_Truck varchar(7),
Appointed_Driver int(7),
PRIMARY KEY (Id_Order)
);

CREATE TABLE Waypoint_ListId_Order
(
Id_Waypoint int not null unique,
City varchar(45) not null,
Cargo varchar(45) not null,
Action_Type varchar(6) not null,
Id_Order int not null unique,
PRIMARY KEY (Id_Waypoint),
FOREIGN KEY(Id_Order) REFERENCES Logistic_Order(Id_Order)
);

CREATE TABLE Cargo
(
Id_cargo int auto_increment primary key not null,
Unique_Number int not null,
Cargo_Name varchar(45) not null,
WeightKg int not null,
Cargo_Status varchar(9)
);

CREATE TABLE Country_Map
(
Id_Country_Map int auto_increment primary key not null,
City varchar(45) not null,
Distance int not null
);