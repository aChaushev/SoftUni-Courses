# 12.	Car Rental Database
-- CREATE DATABASE `car_rental`;
-- USE `car_rental`;

CREATE TABLE `categories`(
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`category` VARCHAR(50) NOT NULL, 
`daily_rate` DOUBLE,
`weekly_rate` DOUBLE, 
`monthly_rate` DOUBLE, 
`weekend_rate` DOUBLE
);
 
 INSERT INTO `categories` (`category`)
 VALUES 
('Category1'),
('Category2'),
('Category3');

CREATE TABLE `cars`(
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`plate_number` VARCHAR(50) NOT NULL, 
`make` VARCHAR(50), 
`model` VARCHAR(50), 
`car_year` INT, 
`category_id` INT,
`doors` INT, 
`picture` BLOB, 
`car_condition` VARCHAR(50), 
`available` BOOLEAN
);

INSERT INTO `cars`(`plate_number`)
VALUES
('PlateNumber1'),
('PlateNumber2'),
('PlateNumber3');

CREATE TABLE `employees` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`title` VARCHAR(50),
`notes` TEXT
);

 INSERT INTO `employees` (`first_name`, `last_name`)
 VALUES
 ('FirstName1', 'LastName1'),
 ('FirstName2', 'LastName2'),
 ('FirstName2', 'LastName2');

CREATE TABLE `customers` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`driver_licence_number` VARCHAR(50) NOT NULL, 
`full_name` VARCHAR(50) NOT NULL, 
`address` VARCHAR(100), 
`city` VARCHAR(50), 
`zip_code` VARCHAR(50),
`notes` TEXT
);

INSERT INTO `customers` (`driver_licence_number`, `full_name`)
 VALUES
 ('DriverLicence1', 'Name1'),
 ('DriverLicence2', 'Name2'),
 ('DriverLicence3', 'Name2');

CREATE TABLE `rental_orders` (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`employee_id` INT,
`customer_id` INT,
`car_id` INT,
`car_condition` VARCHAR(50), 
`tank_level` VARCHAR(50), 
`kilometrage_start` DOUBLE, 
`kilometrage_end` DOUBLE, 
`total_kilometrage` DOUBLE, 
`start_date` DATE, 
`end_date` DATE, 
`total_days` INT, 
`rate_applied` DOUBLE, 
`tax_rate` DOUBLE, 
`order_status` VARCHAR(50), 
`notes` TEXT
);

INSERT INTO `rental_orders` (`car_condition`)
VALUES 
('good'),
('bad'),
('good');
