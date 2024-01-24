USE `soft_uni`;

-- SUBMIT WITHOUT DELIMITER $$ DELIMITER ;

# 1. Employees with Salary Above 35000
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT first_name, last_name FROM employees
    WHERE salary > 35000
    ORDER BY first_name, last_name, employee_id;
END $$
DELIMITER ;
;

-- CALL usp_get_employees_salary_above_35000;


# 2. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(target_salary DECIMAL(19,4))
BEGIN
	SELECT first_name, last_name FROM employees
    WHERE salary >= target_salary
	ORDER BY first_name, last_name, employee_id;
END $$
DELIMITER ;
;

-- CALL usp_get_employees_salary_above(50000);


# 3. Town Names Starting With
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(starting_string VARCHAR(20))
BEGIN
	SELECT name FROM towns
    WHERE name LIKE CONCAT(starting_string, '%')
    ORDER BY name;
END $$
DELIMITER ;
;

-- WHERE LEFT(name , LENGTH(starting_string)) = starting_string
-- CALL usp_get_towns_starting_with('b');


# 4. Employees from Town
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT e.first_name, e.last_name 
    FROM employees AS e
    JOIN addresses AS a ON e.address_id = a.address_id -- JOIN addresses AS a USING (address_id)
    JOIN towns AS t ON a.town_id = t.town_id		   -- JOIN towns AS a USING (town_id)
    WHERE t.name = town_name
    ORDER BY first_name, last_name, employee_id;
END $$
DELIMITER ;
;

-- CALL usp_get_employees_from_town('Sofia')


# 5. Salary Level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(10);
    IF salary < 30000 THEN SET salary_level = 'Low';
    ELSEIF salary <= 50000 THEN SET salary_level = 'Average';
    ELSE SET salary_level = 'High';
    END IF;
    RETURN salary_level;
END $$
DELIMITER ;
;

# 6. Employees by Salary Level
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
	SELECT first_name, last_name FROM employees
    WHERE ufn_get_salary_level(`salary`) = salary_level
    ORDER BY first_name DESC, last_name DESC;
END $$
DELIMITER ;
;

-- Submit with problem 6 function. Put ; after END;
-- CALL usp_get_employees_by_salary_level('high');

# 7. Define Function
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(set_of_letters VARCHAR(50), word VARCHAR(50))
RETURNS INT -- returns 0 or 1
DETERMINISTIC
BEGIN
	RETURN word REGEXP (CONCAT('^[', set_of_letters, ']+$'));
END$$
DELIMITER ;
;




