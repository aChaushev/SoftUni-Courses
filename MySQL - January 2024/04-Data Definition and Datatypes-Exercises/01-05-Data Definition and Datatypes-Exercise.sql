# 0.	Create Database
CREATE DATABASE `minions`;

USE `minions`;

# 1.	Create Tables
CREATE TABLE `minions` (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
    age INT   
);

CREATE TABLE `towns` (
	town_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

# 2.	Alter Minions Table 
ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL,
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns` (`id`);

# 3.	Insert Records in Both Tables 
INSERT INTO `towns`(`id`, `name`) 
VALUES (1, 'Sofia'),(2, 'Plovdiv'),(3, 'Varna');

INSERT INTO `minions`(`id`, `name`, `age`, `town_id`) 
VALUES (1, 'Kevin', 22, 1),(2, 'Bob', 15, 3),(3, 'Steward', NULL, 2);
-- `id`-> PRIMARY KEY / `town_id` -> FOREIGN KEY

# 4.	Truncate Table Minions
TRUNCATE TABLE `minions`; -- delete data from table

# 5.	Drop All Tables
DROP TABLE `minions`; -- delete table
DROP TABLE `towns`;

-- DROP DATABASE `minions`;





