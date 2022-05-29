/*
 * Engine: MySQL
 * Version: 0.0.1
 * Description: Initial database structure
 */

/*
-- create schema
CREATE SCHEMA aes_demo;
-- use schema
USE aes_demo;
-- Create user
create user 'aes_demo'@'localhost' identified by 'Aesdemo@123#';
-- Grant privileges to user
grant all privileges on *.* to 'aes_demo'@'localhost' with grant option;
 */

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varbinary(150),
  `last_name` varbinary(150),
  `address` varchar(200),
  PRIMARY KEY (`id`)
)ENGINE = InnoDB; -- DEFAULT CHARACTER SET = latin1;

/*
 * Data
 */
INSERT INTO user(first_name, last_name, address) VALUES (to_base64(AES_ENCRYPT('John','dsfdfdsfsdfdfsfs'))  ,'Doe','USA');