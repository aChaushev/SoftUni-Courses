# 5. Online Store Database
-- CREATE DATABASE online_store;
-- USE online_store;

CREATE TABLE item_types (
item_type_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE items (
    item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    item_type_id INT,
    CONSTRAINT fk__item_item_type_id__item_type_item_type_id 
		FOREIGN KEY (item_type_id)
        REFERENCES item_types (item_type_id)
);

CREATE TABLE cities (
city_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50)
);

CREATE TABLE customers (
    customer_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    birthday DATE,
    city_id INT,
    CONSTRAINT fk__customers_city_id__cities_city_id
		FOREIGN KEY (city_id)
        REFERENCES cities (city_id)
);

CREATE TABLE orders (
order_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
customer_id INT,
CONSTRAINT fk__order_customer_id__customers_customer_id
		FOREIGN KEY (customer_id)
        REFERENCES customers (customer_id)
);

CREATE TABLE order_items (
order_id INT,
item_id INT,
CONSTRAINT pk_orders
	PRIMARY KEY ( order_id, item_id ),
CONSTRAINT fk_order_items_order_id
	FOREIGN KEY (order_id)
    REFERENCES orders (order_id),
CONSTRAINT fk_order_items_item_id
	FOREIGN KEY (item_id)
    REFERENCES items (item_id)
);

