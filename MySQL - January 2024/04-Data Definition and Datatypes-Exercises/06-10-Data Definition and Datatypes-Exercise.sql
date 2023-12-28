# 6.	Create Table People

-- CREATE DATABASE `profiles`;
-- USE `profiles`;

CREATE TABLE `people` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(200) NOT NULL, -- NOT NULL -> REQURED
`picture` BLOB, -- BLOB -> an object that stores a certain amount of data
`height` DOUBLE(10, 2), -- max 10 digits(length) / 2 digits after floating point
`weight` DOUBLE(10, 2),
`gender` CHAR(1) NOT NULL, -- ENUM('m', 'f') -> изброими стойности, които може да са 'm' и 'f'
`birthdate` DATE NOT NULL,
`biography` TEXT -- deafult TEXT(255)
);

INSERT INTO `people`(`name`, `gender`, `birthdate`)
VALUE
	('Tosho', 'm', DATE(NOW())), -- DATE(NOW()) -> сегашна дата
	('Maria', 'f', DATE(NOW())),
	('Anton', 'm', DATE(NOW())),
	('Galka', 'f', DATE(NOW())),
	('Shtilion', 'm', DATE(NOW()));

# 7.	Create Table Users
CREATE TABLE `users` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`username` VARCHAR(30) NOT NULL,
`password` VARCHAR(26) NOT NULL,
`profile_picture` BLOB,
`last_login_time` TIME,
`is_deleted` BOOLEAN -- true/false
);

INSERT INTO `users` (`username`, `password`)
VALUES 
('tosho1', '1234'),
('marata', '456'),
('ton34', '98765'),
('gal13', '1234'),
('shtoto', '1234');

# 8.	Change Primary Key
ALTER TABLE `users`
DROP PRIMARY KEY, -- remove primary key
ADD PRIMARY KEY pk_users (`id`, `username`);


# 9.	Set Default Value of a Field
-- ALTER COLUMN -> set or remove def value of column
-- CHANGE COLUMN -> rename, change type, move
-- MODIFY COLUMN -> like change but without rename
-- CHANGE [COLUMN] old_col_name new_col_name column_definition
ALTER TABLE `users`
MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();
-- INSERT INTO `users` (`username`, `password`)
-- VALUES ('testUser', '1234');
-- INSERT INTO `users` (`username`, `password`, 1last_login_time1)
-- VALUES ('testUserData', '1234', '2012-12-12);

# 10.	 Set Unique Field
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT pk_users PRIMARY KEY `users` (`id`), -- pk_users по условие иначе не е нужно
MODIFY COLUMN `username` VARCHAR(30) UNIQUE; -- добавя се отново типът на колоната освен новия constraint

 -- When there are more than one PRYMARY KEYs in a table -> COMPOSITE PRIMARY KEY
 



