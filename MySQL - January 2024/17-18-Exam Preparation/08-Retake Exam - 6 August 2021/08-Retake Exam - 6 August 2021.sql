-- CREATE DATABASE softUni_game_dev_branch; 
-- USE softUni_game_dev_branch;

# 1. Table Design

CREATE TABLE addresses (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL
);  

 CREATE TABLE categories (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(10) NOT NULL
);  

CREATE TABLE offices (
	id INT PRIMARY KEY AUTO_INCREMENT,
    workspace_capacity INT NOT NULL,
    website VARCHAR(50),
	address_id INT NOT NULL,
	FOREIGN KEY (address_id) REFERENCES addresses(id)
); 

CREATE TABLE employees (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL, 
	last_name VARCHAR(30) NOT NULL, 
	age INT NOT NULL,
    salary decimal(10,2) NOT NULL,
    job_title VARCHAR(20) NOT NULL,
    happiness_level CHAR(1) NOT NULL
);

CREATE TABLE teams (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL, 
	office_id INT NOT NULL,
	leader_id INT NOT NULL UNIQUE,
	FOREIGN KEY (office_id) REFERENCES offices(id),
	FOREIGN KEY (leader_id) REFERENCES employees(id)
);

CREATE TABLE games (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL UNIQUE, 
    `description` TEXT, 
    rating FLOAT NOT NULL DEFAULT 5.5, 
    budget DECIMAL(10,2) NOT NULL, 
    `release_date` DATE,
    team_id INT NOT NULL,
    FOREIGN KEY (team_id) REFERENCES teams(id)
);

CREATE TABLE games_categories (
	game_id INT NOT NULL,
	category_id INT NOT NULL,
    PRIMARY KEY (game_id, category_id),
	FOREIGN KEY (game_id) REFERENCES games(id),
	FOREIGN KEY (category_id) REFERENCES categories(id)
);    
   
   
   # 2. Insert
INSERT INTO games ( `name`, rating, budget, team_id ) 
( SELECT 
   LOWER(REVERSE(SUBSTRING(`name`, 2))) AS `name`,
   id AS rating, 
   leader_id * 1000 AS budget, 
   id AS team_id
   FROM teams
   WHERE id BETWEEN 1 AND 9
);
   
   
# 3. Update
UPDATE employees e
JOIN teams t ON e.id = t.leader_id
SET e.salary = e.salary + 1000
WHERE e.age < 40 AND e.salary < 5000;
   
   
# 4. Delete
DELETE g 
FROM games g 
LEFT JOIN games_categories gc ON g.id = gc.game_id
WHERE gc.category_id IS NULL AND g.release_date IS NULL;
   
   
# 5. Employees   
SELECT 
	first_name,
	last_name,
	age,
	salary,
	happiness_level
FROM employees
ORDER BY salary, id;


# 6. Addresses of the teams
SELECT
	t.`name` team_name,
    a.`name` address_name,
    CHAR_LENGTH(a.`name`)
FROM teams t
JOIN offices o ON t.office_id = o.id
JOIN addresses a ON o.address_id = a.id
WHERE o.website IS NOT NULL
ORDER BY t.`name`, a.`name`;


# 7. Categories Info
SELECT
	c.`name`,
	COUNT(g.id) AS games_count,
	ROUND(AVG(g.budget), 2) AS avg_budget,
	MAX(g.rating) AS max_rating
FROM categories c
JOIN games_categories gc ON c.id = gc.category_id
JOIN games g ON gc.game_id = g.id
GROUP BY c.`name`
HAVING max_rating >= 9.5
ORDER BY games_count DESC, c.`name`;


# 8. Games of 2022
SELECT
	g.`name`,
    g.release_date,
    CONCAT(SUBSTRING(g.`description`, 1, 10), '...') AS summary,
    (CASE
		WHEN MONTH(g.release_date) <= 3 THEN 'Q1'
		WHEN MONTH(g.release_date) <= 6 THEN 'Q2'
		WHEN MONTH(g.release_date) <= 9 THEN 'Q3'
		WHEN MONTH(g.release_date) <= 12 THEN 'Q4'
    END) AS `quarter`,
    t.`name` AS team_name
FROM games g
JOIN teams t ON g.team_id = t.id
WHERE g.`name` LIKE '%2'
AND MONTH(g.release_date) % 2 = 0
AND YEAR(g.release_date) = 2022
ORDER BY `quarter`;


# 9. Full info for games
SELECT
	g.`name`,
	( CASE
		WHEN g.budget < 50000 THEN 'Normal budget'
		ELSE 'Insufficient budget'
    END
    )AS budget_level,
	t.`name` AS team_name,
	a.`name` AS address_name 
FROM games g
LEFT JOIN games_categories gc ON g.id = gc.game_id
JOIN teams t ON g.team_id = t.id
JOIN offices o ON t.office_id = o.id
JOIN addresses a ON o.address_id = a.id
WHERE g.release_date IS NULL
AND category_id IS NULL
ORDER BY g.`name`;


# 10. Find all basic information for a game
DELIMITER //
CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS TEXT
DETERMINISTIC
BEGIN
	RETURN
    (
    SELECT
	CONCAT('The ', g.`name`, ' is developed by a ', t.`name`, ' in an office with an address ', a.`name`)
	FROM games g 
	JOIN teams t ON g.team_id = t.id
	JOIN offices o ON t.office_id = o.id
	JOIN addresses a ON o.address_id = a.id
	WHERE g.`name` = game_name);
END //
DELIMITER ;
;


# 11.	Update the budget of the games
DELIMITER //
CREATE PROCEDURE udp_update_budget( min_game_rating FLOAT )
BEGIN
	UPDATE games g
	LEFT JOIN games_categories gc ON g.id = gc.game_id
	SET g.budget = g.budget + 100000,
	release_date = DATE_ADD(release_date, INTERVAL 1 YEAR)
	WHERE category_id IS NULL
	AND g.rating > min_game_rating
	AND g.release_date IS NOT NULL;
END //
DELIMITER ;
;

