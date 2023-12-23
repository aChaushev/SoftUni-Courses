-- 01.	Create Tables	
CREATE DATABASE `gamebar`;

USE `gamebar`;

CREATE TABLE `employees` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(100) NOT NULL,
	`last_name` VARCHAR(100) NOT NULL
);

CREATE TABLE `categories` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL
);
 
CREATE TABLE `products` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `category_id`INT NOT NULL
);

-- 2.	 Insert Data in Tables 
INSERT INTO `employees`(`first_name`, `last_name`) VALUES ("Dasha", "Masha");
INSERT INTO `employees`(`first_name`, `last_name`) VALUES
("Pesho", "Gosho"),
("Sasho", "Tosho");

-- 3. Alter Tables 
ALTER TABLE `employees`
ADD COLUMN `middle_name` VARCHAR(100);

-- 4. Adding Constraints
ALTER TABLE `products`
ADD CONSTRAINT fk_products_categories
FOREIGN KEY (`category_id`)
REFERENCES `categories` (`id`);

-- 5. Modifying Columns 
ALTER TABLE `employees`
MODIFY COLUMN `middle_name` VARCHAR(100) NOT NULL;

