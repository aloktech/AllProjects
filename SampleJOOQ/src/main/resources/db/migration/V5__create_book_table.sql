-- V5__create_book_table.sql

CREATE TABLE `book` (
  `id` int NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `year_of_edition` date DEFAULT NULL,
  `type_of_book` varchar(255) DEFAULT NULL,
  `domain` varchar(255) DEFAULT NULL,
  `author_id` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`author_id`) REFERENCES author(`id`)
);