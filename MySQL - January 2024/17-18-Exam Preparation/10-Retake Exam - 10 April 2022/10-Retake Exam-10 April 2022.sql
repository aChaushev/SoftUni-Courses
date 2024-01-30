CREATE DATABASE softuni_imdb’s;
USE softuni_imdb’s;

# 01.	Table Design
CREATE TABLE countries (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) UNIQUE NOT NULL,
	continent VARCHAR(30) NOT NULL,
	currency VARCHAR(5) NOT NULL
);

CREATE TABLE genres (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE actors (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
	birthdate DATE NOT NULL,
	height INT,
	awards INT,
	country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE movies_additional_info (
	id INT PRIMARY KEY AUTO_INCREMENT,
	rating DECIMAL(10,2) NOT NULL,
	runtime INT NOT NULL,
	picture_url VARCHAR(80) NOT NULL,
	budget DECIMAL(10,2),
	release_date DATE NOT NULL,
	has_subtitles TINYINT(1),
	`description` TEXT
);

CREATE TABLE movies (
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(70) UNIQUE NOT NULL,
    country_id INT NOT NULL,
	movie_info_id INT UNIQUE NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(id),
    FOREIGN KEY (movie_info_id) REFERENCES movies_additional_info(id)
);

CREATE TABLE movies_actors (
	movie_id INT,
	actor_id INT,
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (actor_id) REFERENCES actors(id)
);

CREATE TABLE genres_movies (
	genre_id INT,
	movie_id INT,
    FOREIGN KEY (genre_id) REFERENCES genres(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);


# 02.	Insert
INSERT INTO actors(first_name, last_name, birthdate, height, awards, country_id)
(
	SELECT
		REVERSE(first_name),
        REVERSE(last_name),
		TIMESTAMPADD(DAY, -2, birthdate),
        height + 10,
        country_id,
        3
	FROM actors
	WHERE  id <= 10
);


# 03.	Update
UPDATE movies_additional_info
SET runtime = runtime - 10
WHERE id BETWEEN 15 AND 25;


# 04.	Delete
DELETE c FROM countries AS c
LEFT JOIN movies AS m ON c.id = m.country_id
WHERE m.id IS NULL;

# 04.	Delete (2)
DELETE FROM countries
WHERE id NOT IN (SELECT country_id FROM movies);

-- SELECT
-- 	c.id,
--     m.id
-- FROM countries AS c
-- LEFT JOIN movies AS m ON c.id = m.country_id
-- WHERE m.id IS NULL;

# 05.	Countries
SELECT
	id,
	`name`,
	continent,
	currency
FROM countries
ORDER BY currency DESC, id;


# 06.	Old movies
SELECT
	m.id,
	m.title,
	mai.runtime,
	mai.budget,
	mai.release_date
FROM movies AS m
JOIN movies_additional_info AS mai ON m.movie_info_id = mai.id
WHERE YEAR(release_date) BETWEEN 1996 AND 1999
ORDER BY mai.runtime, m.id
LIMIT 20;


# 07.	Movie casting
SELECT
	CONCAT(a.first_name, ' ', a.last_name) AS full_name,
	CONCAT(REVERSE(a.last_name), CHAR_LENGTH(a.last_name), '@cast.com') AS email,
	2022 - YEAR(a.birthdate) AS age,
	height
FROM actors AS a
LEFT JOIN movies_actors AS ma ON a.id = ma.actor_id
WHERE ma.actor_id IS NULL
ORDER BY height;

# 07.	Movie casting(2)
SELECT
	CONCAT(first_name, ' ', last_name) AS full_name,
	CONCAT(REVERSE(last_name), CHAR_LENGTH(last_name), '@cast.com') AS email,
	2022 - YEAR(birthdate) AS age,
	height
FROM actors
WHERE id NOT IN (SELECT actor_id FROM movies_actors)
ORDER BY height;


# 08.	International festival
SELECT 
	c.`name`,
    COUNT(m.id) AS movies_count
FROM countries AS c
JOIN movies AS m ON c.id = m.country_id
GROUP BY c.`name`
HAVING movies_count >= 7
ORDER BY c.`name` DESC;


# 09.	Rating system
SELECT
	m.title,
    (CASE
		WHEN mai.rating <= 4 THEN 'poor'
		WHEN mai.rating <= 7 THEN 'good'
        WHEN mai.rating > 7 THEN 'excellent'
	END) AS rating,
	IF (mai.has_subtitles = 1,'english', '-') AS subtitles ,
	mai.budget
FROM movies AS m
JOIN movies_additional_info AS mai ON m.movie_info_id = mai.id
ORDER BY budget DESC;


# 10.	History movies
DELIMITER //
CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE space_index int;
    SET space_index := POSITION(' ' IN full_name);
    
	RETURN(
    SELECT 
	COUNT(a.id)
	FROM actors AS a
	JOIN movies_actors AS ma ON a.id = ma.actor_id
	JOIN genres_movies AS gm USING(movie_id)
	WHERE gm.genre_id = 12
    AND full_name = CONCAT(a.first_name, ' ', a.last_name)
-- 	AND a.first_name = SUBSTRING(full_name, 1, space_index - 1) 
--  AND a.last_name = SUBSTRING(full_name , space_index + 1)
    );

END //
DELIMITER ;
;






SELECT udf_actor_history_movies_count('Stephan Lundberg')  AS 'history_movies';


# 11.	Movie awards
DELIMITER //
CREATE PROCEDURE udp_award_movie (movie_title VARCHAR(50))
BEGIN
	UPDATE actors AS a
    JOIN movies_actors AS ma ON a.id = actor_id
	JOIN movies AS m ON ma.movie_id = m.id
	SET a.awards = a.awards + 1
	WHERE m.title = movie_title;
END //
DELIMITER ;
;

SELECT
	a.first_name
FROM actors AS a
JOIN movies_actors AS ma ON a.id = actor_id
JOIN movies AS m ON ma.movie_id = m.id
WHERE m.title = 'Tea For Two';




