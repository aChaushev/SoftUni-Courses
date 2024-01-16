
CREATE DATABASE `table_raletions`;
USE `table_raletions`;


# 1. One-To-One Relationship
CREATE TABLE passports (
    passport_id INT AUTO_INCREMENT PRIMARY KEY,
    passport_number VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO `passports` (`passport_id`, `passport_number`) 
VALUES 
	(101, 'N34FG21B'), 
	(102, 'K65LO4R7'), 
	(103, 'ZE657QP2');

CREATE TABLE people (
    person_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL ,
    salary DECIMAL(10, 2),
	passport_id INT UNIQUE,
    CONSTRAINT fk__people_person_id__passports_passport_id
    FOREIGN KEY (passport_id)
    REFERENCES passports (passport_id)
);

INSERT INTO `people` (`person_id`, `first_name`, `salary`, `passport_id`) 
VALUES 
	(1, 'Roberto', 43300.00, 102), 
	(2, 'Tom', 56100.00, 103), 
	(3, 'Yana', 60200.00, 101);


# 2. One-To-Many Relationship
CREATE TABLE manufacturers (
	manufacturer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE,
    established_on DATE
);

INSERT INTO `manufacturers` (`manufacturer_id`, `name`, `established_on`) 
VALUES 
	(1, 'BMW', '1916/03/01'), 
	(2, 'Tesla', '2003/01/01'), 
	(3, 'Lada', '1966/05/01');
    
CREATE TABLE models (
	model_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL UNIQUE,
	manufacturer_id INT,
	CONSTRAINT fk__models_manufacturer_id__manufacturers_manufacturer_id
		FOREIGN KEY (manufacturer_id)
        REFERENCES manufacturers (manufacturer_id)
);

INSERT INTO `models` (`model_id`, `name`, `manufacturer_id`) 
VALUES 
	(101, 'X1', 1),
	(102, 'i6', 1),
	(103, 'Model S', 2),
	(104, 'Model X', 2),
	(105, 'Model 3', 2),
	(106, 'Nova', 3);
    
    
# 3. Many-To-Many Relationship
    CREATE TABLE students (
    	student_id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50) NOT NULL
    );
    
    INSERT INTO `students` (`student_id`, `name`) 
VALUES 
	(1, 'Mila'), 
	(2, 'Toni'), 
	(3, 'Ron');
    
	CREATE TABLE exams (
    	exam_id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50) NOT NULL
    );
    
    
ALTER TABLE `exams` AUTO_INCREMENT = 101;

    INSERT INTO `exams` ( `name`) 
VALUES 
	('Spring MVC'), 
	('Neo4j'), 
	('Oracle 11g');
    
	CREATE TABLE students_exams (
    student_id INT NOT NULL,
    exam_id INT NOT NULL,
    CONSTRAINT pk_students_exams
    PRIMARY KEY (student_id, exam_id),
    CONSTRAINT fk_student_id FOREIGN KEY (student_id)
        REFERENCES students (student_id),
    CONSTRAINT fk_exam_id FOREIGN KEY (exam_id)
        REFERENCES exams (exam_id)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`) 
VALUES 
	(1,	101),
	(1,	102),
	(2,	101),
	(3,	103),
	(2,	102),
	(2,	103);
    
    
# 4. Self-Referencing
CREATE TABLE teachers (
    teacher_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    manager_id INT
);

ALTER TABLE teachers AUTO_INCREMENT = 101;

INSERT INTO `teachers` (`name`, `manager_id`) 
VALUES 
	('John', NULL),		
	('Maya', 106),
	('Silvia', 106),
	('Ted', 105),
	('Mark', 101),
	('Greta', 101);

ALTER TABLE teachers
ADD CONSTRAINT fk_teacher_id_manager_id FOREIGN KEY (manager_id)
        REFERENCES teachers (teacher_id);


