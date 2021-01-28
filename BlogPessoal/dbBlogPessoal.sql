create database db_Postagem;
use db_Postagem;

CREATE TABLE `Postagem` (
	`Id` VARCHAR(100) NOT NULL,
	`Titulo` VARCHAR(100) NOT NULL,
	`Texto` VARCHAR(1000) NOT NULL,
	`Data` DATETIME NOT NULL,
	PRIMARY KEY (`Id`)
);
