USE `soft_uni`;

# 1.	Find Names of All Employees by First Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE SUBSTRING(`first_name`, 1, 2) = 'Sa'
ORDER BY `employee_id`;

/*
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;
*/

# 2.	Find Names of All Employees by Last Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE LOCATE('ei', `last_name`)
ORDER BY `employee_id`;

/*
SELECT `first_name`, `last_name` from `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;
*/

# 3.	Find First Names of All Employees
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN (3, 10) 
AND
EXTRACT(YEAR FROM `hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

/*
SELECT `first_name` 
FROM `employees`
WHERE `department_id` IN (3, 10)
AND 
YEAR(`hire_date`) BETWEEN 1995 and 2005
ORDER BY `employee_id`;
*/

# 4.	Find All Employees Except Engineers
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

# 5.	Find Towns with Name Length
SELECT `name`
FROM `towns`
WHERE CHAR_LENGTH(`name`) IN (5, 6)
ORDER BY `name`;

# 6.	 Find Towns Starting With
SELECT `town_id`, `name`
FROM `towns`
WHERE SUBSTRING(`name`, 1, 1) IN ('M', 'K', 'B', 'E')
ORDER BY `name`;

SELECT `town_id`, `name`
FROM `towns`
WHERE `name` REGEXP '^[MKBE]'
ORDER BY `name`;

/*
SELECT `town_id`, `name`
FROM `towns`
WHERE `name` LIKE ('M%') OR `name` LIKE ('K%') OR `name` LIKE ('B%') OR `name` LIKE ('E%')
ORDER BY `name`;
*/

# 7.	 Find Towns Not Starting With
SELECT `town_id`, `name`
FROM `towns`
WHERE SUBSTRING(`name`, 1, 1) NOT IN ('R', 'B', 'D')
ORDER BY `name`;

SELECT `town_id`, `name`
FROM `towns`
WHERE `name` REGEXP '^[^RBD]'
ORDER BY `name`;

/*
SELECT * FROM `towns`
WHERE `name` NOT LIKE ('r%') AND `name` NOT LIKE ('b%') AND `name` NOT LIKE ('d%')
ORDER BY `name`;
*/

# 8.	Create View Employees Hired After 2000 Year
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name` 
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;
-- WHERE EXTRACT(YEAR FROM `hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

# 9.	Length of Last Name
SELECT `first_name`, `last_name`
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;
