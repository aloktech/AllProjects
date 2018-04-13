-- V4__create_address_table.sql

CREATE TABLE `address` (
  `id` int NOT NULL,
  `first_street` varchar(255) DEFAULT NULL,
  `second_street` varchar(255) DEFAULT NULL,
  `pin` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `land_mark` varchar(255) DEFAULT NULL,
  `premises` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);