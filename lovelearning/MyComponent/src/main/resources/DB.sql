DROP DATABASE IF EXISTS `myexample`; 
CREATE DATABASE `myexample`; 
USE `myexample`; 
CREATE TABLE `phonebook` ( 
	`name` VARCHAR(20) NOT NULL, 
	`number` VARCHAR(20) NOT NULL 
);