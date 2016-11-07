CREATE SCHEMA IF NOT EXISTS management_app;
USE management_app ;

CREATE TABLE IF NOT EXISTS management_app.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NOT NULL,
  metal VARCHAR(45) NOT NULL,
  price DECIMAL(45) NOT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS management_app.customers (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(16) NOT NULL,
  last_name VARCHAR(16) NOT NULL,
  email VARCHAR(30) NOT NULL,
  phone_number VARCHAR(15) NOT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE IF NOT EXISTS management_app.transactions (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  customer_id VARCHAR(16) NOT NULL,
  product_id VARCHAR(16) NOT NULL,
  transaction_date VARCHAR(40) NOT NULL,
  PRIMARY KEY (id));
  
  