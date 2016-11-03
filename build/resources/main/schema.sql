CREATE SCHEMA IF NOT EXISTS management_app;
USE management_app ;

CREATE TABLE IF NOT EXISTS management_app.products (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  price VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  