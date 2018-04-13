-- V3__alter_author_table.sql

ALTER TABLE `author`
ADD `gender` varchar(255) DEFAULT NULL,
ADD `date_of_birth` date DEFAULT NULL;