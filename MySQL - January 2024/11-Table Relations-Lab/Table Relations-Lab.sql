
# 1. Mountains and Peaks

-- CREATE DATABASE IF NOT EXISTS mountains;
-- USE mountains;

CREATE TABLE `mountains` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    CONSTRAINT pk_mountains_id PRIMARY KEY (id)
);

INSERT INTO `mountains`(`name`) VALUES ('Rila'), ('Pirin');

SELECT * FROM `mountains`;

CREATE TABLE peaks (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `mountain_id` INT NOT NULL,
    CONSTRAINT fk_peaks_id_mountain_id_mountains_id 
		FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (`id`)
);

INSERT INTO `peaks` (`name`, `mountain_id`)
VALUES ('Musala', 1), ('Vihren', 2), ('Another Peak', 1);

-- ------------------------------------------
SELECT * FROM `mountains`, `peaks`;

SELECT p.`id`, p.`name`, `mountains`.`name` 
FROM `peaks` AS p
	JOIN `mountains` ON p.`mountain_id` = `mountains`.`id`;
-- ------------------------------------------

# 2. Trip Organization
-- USE `camp`;

SELECT 
	`driver_id`, 
    `vehicle_type`, 
	CONCAT_WS(' ', `first_name`, `last_name`) AS 'driver_name'
FROM `vehicles` AS v
	JOIN `campers` AS c 
    ON v.`driver_id` = c.`id`;
    
# 3. SoftUni Hiking
-- USE `camp`;

SELECT 
	`starting_point` AS 'route_starting_point',
    `end_point` AS 'route_ending_point',
    `leader_id`,
	CONCAT_WS(' ', `first_name`, `last_name`) AS 'leader_name'
FROM `routes` AS r
	JOIN `campers` AS c
    ON r.`leader_id` = c.`id`;


# 4. Delete Mountains / CASCADE DELETE
-- DROP TABLE mountains;
-- DROP TABLE peaks;

CREATE TABLE `mountains` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    CONSTRAINT pk_mountains_id PRIMARY KEY (id)
);

CREATE TABLE peaks (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `mountain_id` INT NOT NULL,
    CONSTRAINT fk_peaks_id_mountain_id_mountains_id 
		FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (`id`)
        ON DELETE CASCADE
);


# 5. Project Management DB
CREATE DATABASE project_management;
USE project_management;

CREATE TABLE clients (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_name VARCHAR(100)
);

CREATE TABLE projects (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    client_id INT,
    project_lead_id INT,
    CONSTRAINT fk__projects_client_id__clients_id 
		FOREIGN KEY (client_id)
        REFERENCES clients (id)
);

CREATE TABLE employees (
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    project_id INT,
    CONSTRAINT fr__employees_project_id__projects_id 
		FOREIGN KEY (project_id)
        REFERENCES projects (id)
);

ALTER TABLE projects 
ADD CONSTRAINT fr__projects_project_lead_id__employees_id
	FOREIGN KEY (project_lead_id)
    REFERENCES employees (id);


