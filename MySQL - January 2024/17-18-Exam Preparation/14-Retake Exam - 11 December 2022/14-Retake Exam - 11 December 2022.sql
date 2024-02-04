-- CREATE DATABASE airlines_db;
-- USE airlines_db;


# 01.	Table Design

CREATE TABLE countries (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL UNIQUE,
	`description` TEXT,
	currency VARCHAR(5) NOT NULL
);


CREATE TABLE airplanes (
	id INT PRIMARY KEY AUTO_INCREMENT,
	model VARCHAR(50) NOT NULL UNIQUE,
	passengers_capacity INT NOT NULL,
	tank_capacity DECIMAL(19,2) NOT NULL,
	cost DECIMAL(19,2) NOT NULL
);

CREATE TABLE passengers (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(30) NOT NULL,
	last_name VARCHAR(30) NOT NULL,
	country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE flights (
	id INT PRIMARY KEY AUTO_INCREMENT,
	flight_code  VARCHAR(30) NOT NULL UNIQUE,
	departure_country INT NOT NULL,
	destination_country INT NOT NULL,
	airplane_id INT NOT NULL,
	has_delay TINYINT(1),
	departure DATETIME,
	FOREIGN KEY (departure_country) REFERENCES countries(id),
	FOREIGN KEY (destination_country) REFERENCES countries(id),
	FOREIGN KEY (airplane_id) REFERENCES airplanes(id)
);

CREATE TABLE flights_passengers (
	flight_id INT,
	passenger_id INT,
	FOREIGN KEY (flight_id) REFERENCES flights(id),
	FOREIGN KEY (passenger_id) REFERENCES passengers(id)
);


# 02.	Insert
INSERT INTO airplanes (model, passengers_capacity, tank_capacity, cost) (
SELECT
	CONCAT(REVERSE(first_name), '797') AS model, 
    CHAR_LENGTH(last_name) * 17 AS passengers_capacity, 
    id * 790 AS tank_capacity, 
    CHAR_LENGTH(first_name) * 50.6 AS cost
FROM passengers
WHERE id <= 5
);


# 03.	Update
UPDATE flights 
SET airplane_id = airplane_id + 1
WHERE departure_country = 22;


# 04.	Delete
DELETE f 
FROM flights AS f
LEFT JOIN flights_passengers AS fp ON f.id = fp.flight_id
WHERE passenger_id IS NULL;


# 05.	Airplanes
SELECT 
	id,
	model,
	passengers_capacity,
	tank_capacity,
	cost
FROM airplanes
ORDER BY cost DESC, id DESC;


# 06.	Flights from 2022
SELECT
	flight_code,
	departure_country,
	airplane_id,
	departure
FROM flights
WHERE YEAR(departure) = 2022
ORDER BY airplane_id, flight_code
LIMIT 20;


# 07.	Private flights
SELECT
	CONCAT(UPPER(LEFT(last_name, 2)), country_id) AS flight_code,
	CONCAT(first_name, " " ,last_name) AS full_name,
	country_id
FROM passengers AS p
LEFT JOIN flights_passengers AS fp ON p.id = fp.passenger_id
WHERE flight_id IS NULL
ORDER BY country_id;


# 08.	Leading destinations
SELECT
	c.`name`,
	c.currency,
	COUNT(f.destination_country) AS booked_tickets
FROM flights AS f
JOIN flights_passengers AS fp ON f.id = fp.flight_id
JOIN countries AS c ON f.destination_country = c.id
GROUP BY c.`name`
HAVING booked_tickets >= 20
ORDER BY booked_tickets DESC;


# 09.	Parts of the day
SELECT
	flight_code,
	departure,
	CASE
		WHEN HOUR(departure) >= 5 AND HOUR(departure) < 12 THEN 'Morning'
		WHEN HOUR(departure) >= 12 AND HOUR(departure) < 17 THEN 'Afternoon'
		WHEN HOUR(departure) >= 17 AND HOUR(departure) < 21 THEN 'Evening'
		ELSE 'Night'
        END
    AS day_part
FROM flights
ORDER BY flight_code DESC;


# 10.	Number of flights
DELIMITER //
CREATE FUNCTION udf_count_flights_from_country(country VARCHAR(50)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN
    (
	SELECT
		COUNT(f.id) AS flights_count
	FROM flights AS f
	JOIN countries AS c ON f.departure_country = c.id
	WHERE c.name = country
	);
END//
DELIMITER ;
;


# 11.	Delay flight
DELIMITER //
CREATE PROCEDURE udp_delay_flight(code VARCHAR(50))
BEGIN
	UPDATE flights
	SET has_delay = 1, departure = ADDTIME(departure, "0:30:0")
	WHERE flight_code = code;
END//
DELIMITER ;
;


	

