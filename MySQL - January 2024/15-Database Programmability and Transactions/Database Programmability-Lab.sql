
-- SUBMIT WITHOUT DELIMITER $$ DELIMITER ;

USE `soft_uni`;

# 1. Count Employees by Town
DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(`town_name` VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	
    RETURN(
		SELECT COUNT(*)
		FROM employees AS e
			JOIN addresses AS a ON e.address_id = a.address_id
			JOIN towns AS t ON a.town_id = t.town_id
		WHERE t.`name` = `town_name`
    );
END$$
DELIMITER ;
;
-- SELECT ufn_count_employees_by_town('Sofia') AS 'Count';
-- SELECT name, ufn_count_employees_by_town(name) FROM towns;


# 2. Employees Promotion

DROP PROCEDURE usp_raise_salaries;
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(50))
BEGIN
    UPDATE employees SET salary = salary * 1.05 
    WHERE department_id = (
		SELECT department_id FROM departments WHERE `name` = department_name
		);
END$$
DELIMITER ;
;

# 3. Employees Promotion by ID
DELIMITER $$
CREATE PROCEDURE usp_raise_salary_by_id(id INT)
BEGIN 
	DECLARE employee_id_count INT;
    SET employee_id_count := (SELECT COUNT(*) FROM employees WHERE employee_id = id);
    
    IF(employee_id_count = 1)
    THEN
		UPDATE employees SET salary = salary * 1.05 WHERE employee_id = id;
	END IF;
END$$
DELIMITER ;
;

# 4. Triggered
CREATE TABLE deleted_employees(
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    middle_name VARCHAR(50),
    job_title VARCHAR(50),
    department_id INT,
    salary DECIMAL(19,4)
);

DELIMITER $$
CREATE TRIGGER tr_after_delete_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN
	INSERT INTO deleted_employees
		(first_name, last_name, middle_name, job_title, department_id, salary)
    VALUES(
    OLD.first_name, 
    OLD.last_name,
    OLD.middle_name,
    OLD.job_title, 
    OLD.department_id,
    OLD.salary
    );
END$$
DELIMITER ;
;

UPDATE employees_projects SET employee_id = 3 WHERE employee_id = 2;

DELETE FROM employees WHERE employee_id = 2; 
SELECT * FROM employees WHERE employee_id = 2; 
SELECT * FROM deleted_employees;







# EXAMPLES				 ----------------

# User-defined Functions ----------------
USE soft_uni;

SELECT town_id FROM towns WHERE name = 'Sofia';
SELECT * FROM addresses WHERE town_id = 32;
SELECT * FROM employees WHERE address_id = 291;

SELECT COUNT(*) FROM employees AS e
JOIN addresses AS a ON a.address_id = e.address_id
JOIN towns AS t ON t.town_id = a.town_id
WHERE t.name = 'Sofia';


SELECT COUNT(*) FROM employees AS e
WHERE e.address_id IN (
	SELECT address_id FROM addresses AS a
    WHERE a.town_id IN (
		SELECT town_id FROM towns WHERE name = 'Sofia'
        )
	);


-- DETERMINISTIC -> за едни исъщи входни елементи, винаги ще имаме един и същ резултат
-- NOT DETERMINISTIC -> връщащи random резултат
-- DELIMITER $$ -> сменя знака за прикючване на заявката от ';' с '$$'


DELIMITER $$
CREATE FUNCTION ufn_select_5()
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN ( SELECT 5);
END$$

DELIMITER ;
DROP FUNCTION ufn_select_5;

SELECT CONCAT('a', 'b'), ufn_select_5();
SELECT * FROM towns WHERE town_id < ufn_select_5();


DELIMITER $$
CREATE FUNCTION ufn_append_before(str VARCHAR(50))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
	RETURN CONCAT('Function ', str);
END$$
DELIMITER ;
;

drop function ufn_append_before;
SELECT ufn_append_before('Test');

SELECT ufn_append_before(first_name) FROM employees;


DELIMITER $$
CREATE FUNCTION ufn_rturn_var()
RETURNs INT
DETERMINISTIC
BEGIN
	DECLARE result INT;
    SET result := 10;
    
    RETURN result;
END$$

SELECT ufn_rturn_var()$$


# Stored Procedures ----------------
DELIMITER $$
DROP PROCEDURE usp_select_employees;
CREATE PROCEDURE usp_select_employees(max_id INT)
BEGIN
	SELECT * FROM employees WHERE employee_id < max_id;
    END$$
DELIMITER ;
;

CALL usp_select_employees(10);

-- Employees Promotion Variant
DROP PROCEDURE usp_raise_salaries;
DELIMITER $$
CREATE PROCEDURE usp_raise_salaries(percent DECIMAL(3,2), OUT total_increase DECIMAL(19,4))
BEGIN
	DECLARE actial_percent DECIMAL(19,4);
    
    SET actial_percent = 1 + percent;
    SET total_increase := (
		SELECT SUM(salary) * actial_percent - SUM(salary)
		FROM employees
    );
    
    UPDATE employees SET salary = salary * actial_percent;
END$$
DELIMITER ;
;

SET @increase = 0;
CALL usp_raise_salaries(0.1, @increase);
SELECT @increase;


DELIMITER $$
DROP PROCEDURE usp_transaction;
CREATE PROCEDURE usp_transaction()
BEGIN
	-- Initial state
	START TRANSACTION;
		UPDATE employees SET first_name = 'Changed';
        UPDATE towns SET name = 'Change';
        UPDATE departments SET name = 'Dep0';
    ROLLBACK; -- Return to initial state
    COMMIT; -- Move to new state with changes applied

END$$
DELIMITER ;
;


SELECT * FROM towns;
CALL usp_transaction();
SELECT * FROM towns;


# Triggers ----------------
DROP TABLE deleted_employees;
CREATE TABLE deleted_employees(
	employee_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    job_title VARCHAR(50),
    departemt_name VARCHAR(50),
    hire_date TIMESTAMP(6),
    fire_date TIMESTAMP(6)
);

DELIMITER $$
CREATE TRIGGER tr_after_delete_employees
AFTER DELETE
ON employees
FOR EACH ROW
BEGIN

	INSERT INTO deleted_employees
    VALUES(
    OLD.employee_id,
    OLD.first_name, 
    OLD.last_name, 
    OLD.job_title, 
    (SELECT 'name' FROM departments WHERE department_id = OLD.department_id), 
    OLD.hire_date
    );
END$$
DELIMITER ;
;

UPDATE employees_projects SET employee_id = 3 WHERE employee_id = 2;

DELETE FROM employees WHERE employee_id = 2; 
SELECT * FROM employees WHERE employee_id = 2; 
SELECT * FROM deleted_employees;




