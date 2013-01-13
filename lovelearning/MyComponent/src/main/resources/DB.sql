DROP DATABASE IF EXISTS `myexample`; 
CREATE DATABASE `myexample`; 
USE `myexample`; 
CREATE TABLE `phonebook` ( 
	`name` VARCHAR(20) NOT NULL, 
	`number` VARCHAR(20) NOT NULL 
);

CREATE TABLE `tools` ( 
	`name` VARCHAR(20) NOT NULL, 
	`description` VARCHAR(20) NOT NULL, 
	`downUrl` VARCHAR(200) NOT NULL
);