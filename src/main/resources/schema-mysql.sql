CREATE TABLE if not exists `person_info` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `age` int DEFAULT '0',
  `city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE if not exists `quiz` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `questions` varchar(500) NOT NULL,
  `published` tinyint DEFAULT '0',
  PRIMARY KEY (`id`)
);

CREATE TABLE if not exists `response` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quiz_id` int NOT NULL DEFAULT '0',
  `name` varchar(45) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(45) NOT NULL,
  `age` int DEFAULT '0',
  `fillin` varchar(500) NOT NULL,
  `fillin_date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

