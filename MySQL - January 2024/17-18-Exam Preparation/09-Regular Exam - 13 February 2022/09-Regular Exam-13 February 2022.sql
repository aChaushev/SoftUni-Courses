CREATE DATABASE online_stores;
USE online_stores;

# 01.	Table Design
CREATE TABLE brands (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE categories (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) UNIQUE NOT NULL
);

CREATE TABLE reviews (
	id INT PRIMARY KEY AUTO_INCREMENT,
	content TEXT,
	rating DECIMAL(10,2) NOT NULL,
	picture_url VARCHAR(80) NOT NULL,
	published_at DATETIME NOT NULL

);

CREATE TABLE products (
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
    price DECIMAL(19,2) NOT NULL,
	quantity_in_stock INT,
	`description` TEXT,
	brand_id INT NOT NULL,
	category_id INT NOT NULL,
	review_id INT,
    FOREIGN KEY (brand_id) REFERENCES brands(id),
    FOREIGN KEY (category_id) REFERENCES categories(id),
    FOREIGN KEY (review_id) REFERENCES reviews(id)
);

CREATE TABLE customers (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
	phone VARCHAR(30) UNIQUE NOT NULL,
	address VARCHAR(60) NOT NULL,
	discount_card BIT(1)
);

CREATE TABLE orders (
	id INT PRIMARY KEY AUTO_INCREMENT,
	order_datetime DATETIME NOT NULL,
	customer_id INT NOT NULL,
	FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE orders_products (
	order_id INT,
	product_id INT,
	FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);


# 02.	Insert
INSERT INTO reviews (content, picture_url, published_at, rating)
(
SELECT
		SUBSTRING(`description`, 1, 15),
        REVERSE(`name`),
        '2010-10-10',
        price/8
FROM products 
WHERE id >= 5
);


 # 03.	Update
UPDATE products
SET quantity_in_stock = quantity_in_stock - 5
WHERE quantity_in_stock BETWEEN 60 AND 70;


# 04.	Delete
DELETE FROM customers
WHERE id NOT IN(SELECT orders.customer_id FROM orders);


# 05.	Categories
SELECT * FROM categories
ORDER BY `name` DESC;


# 06.	Quantity
SELECT
	id,
	brand_id ,
	`name`,
	quantity_in_stock
FROM products
WHERE price > 1000 AND quantity_in_stock < 30
ORDER BY quantity_in_stock, id;



# 07.	Review
SELECT
	id,
	content,
	rating,
	picture_url,
	published_at
FROM reviews
WHERE SUBSTRING(content, 1, 2) = 'My' AND CHAR_LENGTH(content) > 61
ORDER BY rating DESC;


# 08.	First customers
SELECT
	CONCAT(first_name, ' ', last_name) AS full_name,
	c.address,
	o.order_datetime AS order_date
FROM customers AS c
JOIN orders AS o ON c.id = o.customer_id
WHERE YEAR(order_datetime) <= 2018
ORDER BY full_name DESC;


# 09.	Best categories
SELECT
	COUNT(p.id) AS items_count, -- (number of items in the category)
	c.`name`,
	SUM(p.quantity_in_stock) AS total_quantity -- (sum of all items in this category)
FROM categories AS c
JOIN products AS p ON c.id = p.category_id
GROUP BY c.`name`
ORDER BY items_count DESC, total_quantity
LIMIT 5;

# 10.	Extract client card count
DELIMITER //
CREATE FUNCTION udf_customer_products_count(`name` VARCHAR(30)) 
RETURNS INT
DETERMINISTIC
BEGIN
	RETURN (
		SELECT 
		COUNT(p.id) AS total_products
		FROM customers AS c
		JOIN orders AS o ON c.id = o.customer_id
		JOIN orders_products AS op ON o.id = op.order_id
		JOIN products AS p ON op.product_id = p.id
		WHERE c.first_name = `name`
	);
END //
DELIMITER ;
;

-- SELECT 
-- 	c.first_name,
-- 	c.last_name,
-- 	COUNT(p.id) AS total_products -- (udf_customer_products_count)
-- FROM customers AS c
-- JOIN orders AS o ON c.id = o.customer_id
-- JOIN orders_products AS op ON o.id = op.order_id
-- JOIN products AS p ON op.product_id = p.id
-- GROUP BY c.first_name, c.last_name
-- HAVING c.first_name = 'Shirley';


# 11.	Reduce price
DELIMITER //
CREATE PROCEDURE udp_reduce_price (category_name VARCHAR(50)) 
BEGIN
	UPDATE products AS p
    JOIN categories AS c ON p.category_id = c.id
	JOIN reviews AS r ON p.review_id = r.id
    SET price = price * 0.7
    WHERE c.name = category_name
	AND r.rating < 4;	
END //
DELIMITER ;
;

SELECT
	p.name
FROM products AS p
JOIN categories AS c ON p.category_id = c.id
JOIN reviews AS r ON p.review_id = r.id
WHERE c.name = 'Phones and tablets'
AND r.rating < 4;

