
USE `soft_uni`;

# 1. Managers
SELECT 
	e.employee_id, 
    CONCAT(e.first_name, ' ', e.last_name) AS 'full_name', 
    d.department_id, 
    d.name AS department_name
FROM employees AS e
RIGHT JOIN departments AS d 
ON d.manager_id = e.employee_id
ORDER BY e.employee_id
LIMIT 5;


# 2. Towns Addresses
SELECT 
	t.town_id, 
    t.name AS town_name, 
    a.address_text
FROM towns AS t
JOIN addresses AS a
ON t.town_id = a.town_id
WHERE t.name IN ('San Francisco', 'Sofia', 'Carnation')
ORDER BY t.town_id, a.address_id;


# 3. Employees Without Managers
SELECT 
	employee_id, 
    first_name, 
    last_name, 
    department_id, 
    salary
FROM employees
WHERE manager_id IS NULL;

# 4. Higher Salary
SELECT COUNT(*) AS 'count'
FROM employees
WHERE salary > (
	SELECT AVG(salary) FROM employees
);


-- --------------------------------
# EXAMPLE:
-- JOINs -> ползваме данни от две или повече таблициalter
-- 1. INNER JOIN <-> JOIN -> ползваме само записи от t1, които имат стойност в t2
-- 2. LEFT JOIN -> ползваме всички записи от t1, независимо дали имат стойност в t2
-- 3. RIGHT JOIN -> ползваме всички записи от t2, независимо дали имат стойност в t1

USE `restaurant`;

SELECT first_name, department_id, departments.name
FROM employees
INNER JOIN departments ON departments.id = employees.department_id;

SELECT first_name, department_id, departments.name
FROM employees
LEFT JOIN departments ON departments.id = employees.department_id;

SELECT first_name, department_id, departments.name
FROM employees
RIGHT JOIN departments ON departments.id = employees.department_id;

SELECT first_name, department_id, departments.name
FROM employees
LEFT JOIN departments ON departments.id = employees.department_id
UNION
SELECT first_name, department_id, departments.name
FROM employees
RIGHT JOIN departments ON departments.id = employees.department_id;

SELECT * FROM employees
CROSS JOIN departments;
--
USE `soft_uni`;

SELECT *
FROM addresses
WHERE town_id IN (
	SELECT town_id FROM towns
    WHERE name LIKE 'S%'
);

EXPLAIN towns;

-- join same table
SELECT
	e.employee_id,
    e.first_name,
    e.last_name,
    e.manager_id,
    ' -> ',
    m.first_name,
    m.last_name,
    m.manager_id,
	' -> ',
    mm.first_name,
    mm.last_name,
    mm.manager_id
FROM employees AS e
INNER JOIN employees AS m ON e.manager_id = m.employee_id
INNER JOIN employees AS mm ON m.manager_id = mm.employee_id;

-- join multiple tables
SELECT
	p.project_id,
    p.name,
    CONCAT(e.first_name, ' ', e.last_name)
FROM projects AS p
JOIN employees_projects AS ep ON ep.project_id= p.project_id
JOIN employees AS e ON ep.employee_id = e.employee_id;


SELECT * FROM towns WHERE town_id < 4
UNION
SELECT * FROM towns WHERE town_id BETWEEN 10 AND 12
UNION
SELECT * FROM towns WHERE town_id > 29;


SELECT
	p.project_id,
    p.name,
    COUNT(ep.employee_id) AS 'AllEmoployees',
    (
		SELECT COUNT(e1.employee_id)
        FROM employees_projects AS ep1
			JOIN employees AS e1 ON ep1.employee_id = e1.employee_id
            JOIN addresses AS a1 ON e1.address_id = a1.address_id
            JOIN towns AS t1 ON a1.town_id = t1.town_id
		WHERE t1.name = 'Bellevue' AND ep1.project_id = p.project_id
	) AS 'BellEmployees'
FROM projects AS p
		JOIN employees_projects AS ep ON ep.project_id = p.project_id
		JOIN employees AS e ON ep.employee_id = e.employee_id
		JOIN addresses AS a ON e.address_id = a.address_id
		JOIN towns AS t ON a.town_id = t.town_id
GROUP BY p.project_id
HAVING BellEmployees = AllEmoployees -- example > 3
ORDER BY project_id
LIMIT 200;







