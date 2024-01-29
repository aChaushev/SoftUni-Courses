CREATE DATABASE restaurant_db;
USE restaurant_db;


# 01. Table Design

CREATE TABLE products(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL UNIQUE,
    type VARCHAR(30) NOT NULL,
    price DECIMAL (10, 2) NOT NULL
);

CREATE TABLE clients(
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	birthdate DATE NOT NULL,
	card  VARCHAR(50),
	review TEXT
);

CREATE TABLE `tables` (
	id INT PRIMARY KEY AUTO_INCREMENT,
    floor INT NOT NULL,
    reserved TINYINT(1),
    capacity INT NOT NULL
);

CREATE TABLE waiters (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    phone VARCHAR(50),
    salary DECIMAL (10,2)
);

CREATE TABLE orders (
	id INT PRIMARY KEY AUTO_INCREMENT,
	table_id INT NOT NULL,
    waiter_id INT NOT NULL,
    order_time TIME NOT NULL,
    payed_status TINYINT(1),
    FOREIGN KEY (table_id) REFERENCES `tables`(id),
    FOREIGN KEY (waiter_id) REFERENCES `waiters`(id)
);

CREATE TABLE orders_clients (
	order_id INT,
    client_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE orders_products (
	order_id INT,
    product_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);


# 02. Insert 
-- SELECT COUNT(*) FROM products;

INSERT INTO products(name, type, price)
( 
	SELECT
		CONCAT(last_name, ' specialty') AS name,
	   'Cocktail' AS type,
		CEIL(salary * 0.01) AS price
	FROM waiters
	WHERE id  > 6
);

-- SELECT * FROM products
-- WHERE id > 199;


# 03.	Update
-- SELECT * FROM orders WHERE id BETWEEN 12 AND 23;

UPDATE orders
SET table_id = table_id - 1
WHERE id BETWEEN 12 AND 23;


# 04.	Delete
/* SELECT
	w.id,
	(SELECT COUNT(*) FROM orders WHERE waiter_id = w.id) AS o_count
    FROM waiters AS w
    HAVING o_count = 0;
*/

DELETE FROM waiters AS w
WHERE (SELECT COUNT(*) FROM orders WHERE waiter_id = w.id) = 0;


# 05.	Clients
SELECT
	id,
	first_name,
	last_name,
	birthdate,
	card,
	review
FROM clients
ORDER BY birthdate DESC, id DESC;


# 06.	Birthdate
SELECT
	first_name,
	last_name,
	birthdate,
	review
FROM clients
WHERE card IS NULL
AND YEAR(birthdate) BETWEEN 1978 AND 1993
ORDER BY last_name DESC, id
LIMIT 5;


# 07.	Accounts
SELECT
	CONCAT(last_name, first_name, CHAR_LENGTH(first_name), 'Restaurant') AS username,
    REVERSE(SUBSTRING(email, 2, 12)) AS  'password'
FROM waiters
WHERE salary IS NOT NULL
ORDER BY `password` DESC;


# 08.	Top from menu
SELECT
	p.id,
	p.`name`,
	COUNT(p.`name`) AS 'count'
FROM products AS p
JOIN orders_products AS op ON p.id = op.product_id
GROUP BY p.`name`
HAVING `count` >= 5
ORDER BY `count` DESC, p.`name`;


# 09.	Availability
SELECT
	t.id AS table_id,
	t.capacity,
    COUNT(oc.client_id) AS 'count_clients',
    (CASE 
		WHEN t.capacity = COUNT(oc.client_id) THEN 'Full'
        WHEN t.capacity > COUNT(oc.client_id) THEN 'Free seats'
        WHEN t.capacity < COUNT(oc.client_id) THEN 'Extra seats'
	END) AS availability
FROM `tables` AS t
JOIN orders AS o ON t.id = o.table_id
JOIN orders_clients AS oc ON o.id = order_id
WHERE t.`floor` = 1
GROUP BY t.id
ORDER BY t.id DESC;

/*
CASE SIGN(t.capacity - COUNT(oc.client_id))
	WHEN 0 THEN 'Full'
    WHEN 1 THEN 'Free seats'
    WHEN -1 THEN 'Extra seats'
END
*/


# 10.	Extract bill
DELIMITER $$
CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))
RETURNS DECIMAL(19,2)
DETERMINISTIC
BEGIN
	DECLARE space_index INT;
    SET space_index := LOCATE(' ', full_name);
    
	RETURN (
		SELECT
			SUM(p.price) AS 'bill'
		FROM clients AS c
		JOIN orders_clients AS oc ON c.id = oc.client_id
		JOIN orders_products AS op ON oc.order_id = op.order_id
		JOIN products AS p ON op.product_id = p.id
		WHERE c.first_name = SUBSTRING(full_name, 1 , space_index - 1)
			AND c.last_name = SUBSTRING(full_name, space_index + 1)
		);
END $$
DELIMITER ;
;

-- SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
-- WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';

-- SELECT SUBSTRING('Silvio Blyth', 1 , LOCATE(' ', 'Silvio Blyth') - 1);
-- SELECT SUBSTRING('Silvio Blyth', LOCATE(' ', 'Silvio Blyth') + 1);

/* SELECT
    SUM(p.price)
FROM clients AS c
JOIN orders_clients AS oc ON c.id = oc.client_id
JOIN orders_products AS op ON oc.order_id = op.order_id
JOIN products AS p ON op.product_id = p.id
GROUP BY c.first_name, c.last_name;
*/


# 11.	Happy hour
DELIMITER $$
CREATE PROCEDURE udp_happy_hour (inpt_type VARCHAR(50))
BEGIN
	UPDATE products
	SET price = price * 0.8
	WHERE `type`= inpt_type AND price >= 10;
END $$
DELIMITER ;
;

-- SELECT `name`, `type`, price FROM products WHERE `type`= 'Cognac';
-- CALL udp_happy_hour ('Cognac');
-- SELECT `name`, `type`, price FROM products WHERE `type`= 'Cognac';






