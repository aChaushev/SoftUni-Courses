USE `hotel`;

# Problem 1: Select Employee Information
SELECT `id`, `first_name`, `last_name`, `job_title`
FROM `employees` -- FROM `hotel`.`employees`
ORDER BY `id`;


# Problem 2: Select Employees with Filter
SELECT 
	`id`,
    CONCAT_WS(' ', `first_name`, `last_name`) AS 'full_name',
    `job_title`,
	`salary`
FROM `employees` 
WHERE `salary` > 1000
ORDER BY `id`;


# Problem 3: Update Employees Salary
UPDATE `employees`
SET `salary` = `salary` + 100
WHERE `job_title` = 'Manager';

SELECT `salary`
FROM `employees`;


# Problem 4: Top Paid Employee
CREATE VIEW `v_top_paid_employee` AS
	SELECT *
	FROM `employees`
	ORDER BY `salary` DESC
	LIMIT 1;
 
SELECT * FROM `v_top_paid_employee`;


# Problem 5: Select Employees by Multiple Filters
SELECT `id`, `first_name`, `last_name`, `job_title`, `department_id`, `salary`
FROM `employees`
WHERE `department_id` = 4 AND `salary` >= 1000
ORDER BY `id`;


# Problem 6: Delete from Table
DELETE FROM `employees`
WHERE `department_id` IN (1, 2);
-- WHERE `department_id` = 1 OR `department_id` = 2;
-- WHERE `department_id` BETWEEN 1 AND 2;

SELECT * FROM `employees`
ORDER BY `id`;


-- -------------------------------------

# examples
SELECT 
e.`id` AS 'No.', 
e.`first_name` AS 'First Name', 
`last_name` AS 'Last Name', 
`job_title` AS 'Title'
FROM `employees` AS e
ORDER BY `id`;

SELECT `id`, 
CONCAT(`first_name`, ' ', `last_name`) AS 'Full Name'
FROM `employees`;

SELECT `id`, 
CONCAT_WS(' ', `first_name`, `last_name`) AS 'Full Name'
FROM `employees`;

SELECT DISTINCT `department_id`
FROM `employees`;
-- DISTINCT премахва повроренията в селекцията 

SELECT `id`, `first_name`, `department_id`
FROM `employees`
WHERE NOT (`department_id` = 1 OR `department_id` = 2);

SELECT `last_name`, `salary` 
FROM `employees`
WHERE `salary` BETWEEN 1000 AND 2000;
-- 1000 и 2000 включително

SELECT `first_name`, `last_name`, `department_id` 
FROM `employees`
-- WHERE `department_id` IN (109, 3, 16);
WHERE `department_id` NOT IN (109, 3, 16);

SELECT `last_name`, `department_id` 
FROM `employees`
WHERE `department_id` IS NULL; -- IS NOT NULL / валидни проверки за null

SELECT `last_name`, `department_id` 
FROM `employees`
ORDER BY `last_name` DESC, `department_id` ASC;


CREATE VIEW `employees_from_1_2_3_salary_over_1000` AS
	SELECT `first_name`, `last_name`, `department_id` 
	FROM `employees`
	WHERE `department_id` IN (1, 2, 3) AND `salary` >= 1000
	ORDER BY `department_id`
    LIMIT 1,2; -- прескочи 1 ред и ми върни следващите 2 реда;
    
-- SELECT * FROM `employees_from_1_2_3_salary_over_1000`;
-- ALTER VIEW `employees_from_1_2_3_salary_over_1000` AS
-- DROP VIEW `employees_from_1_2_3_salary_over_1000`;