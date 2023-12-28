# 11.	Movies Database
-- CREATE DATABASE `movies`;
-- USE `movies`;

CREATE TABLE `directors`(
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`director_name` VARCHAR(50) NOT NULL, 
`notes` TEXT
);
 
 INSERT INTO `directors` (`director_name`)
 VALUES 
 ('Director1'),
 ('Director2'),
 ('Director3'),
 ('Director4'),
 ('Director5');

CREATE TABLE `genres` (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`genre_name` VARCHAR(50) NOT NULL,
`notes` TEXT
);

 INSERT INTO `genres` (`genre_name`)
 VALUES 
 ('Genre1'),
 ('Genre2'),
 ('Genre3'),
 ('Genre4'),
 ('Genre5');
 
CREATE TABLE `categories` (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`category_name` VARCHAR(50) NOT NULL, 
`notes` TEXT
);

INSERT INTO `categories` (`category_name`)
VALUES
('Category1'),
('Category2'),
('Category3'),
('Category4'),
('Category5');

CREATE TABLE `movies` (
`id` INT PRIMARY KEY AUTO_INCREMENT, 
`title` VARCHAR(50) NOT NULL, 
`director_id` INT, FOREIGN KEY (`director_id`) REFERENCES `directors` (`id`), 
`copyright_year` INT, 
`length` DOUBLE, 
`genre_id` INT , FOREIGN KEY (`genre_id`) REFERENCES `genres` (`id`), 
`category_id` INT, FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`), 
`rating` DOUBLE, 
`notes` TEXT
);

INSERT INTO `movies` (`title`)
VALUES
('Movie1'),
('Movie2'),
('Movie3'),
('Movie4'),
('Movie5');
