SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

DROP SCHEMA IF EXISTS `catalog`;
CREATE SCHEMA IF NOT EXISTS `catalog` DEFAULT CHARSET=utf8;

USE `catalog`;


CREATE TABLE IF NOT EXISTS `films` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `existed` tinyint(1) DEFAULT NULL,
  `fileSize` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `version` varchar(32) DEFAULT NULL,
  `watched` tinyint(1) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `path` (`path`),
  UNIQUE KEY `path_2` (`path`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=95 ;

CREATE TABLE IF NOT EXISTS `films_genres` (
  `id` int(11) NOT NULL,
  `ganre_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`ganre_id`),
  KEY `FK53D17E207069E578` (`id`),
  KEY `FK53D17E2080004883` (`ganre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `films_languages` (
  `id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`language_id`),
  KEY `FK3BCB4F4B7069E578` (`id`),
  KEY `FK3BCB4F4BFB92EB93` (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `folders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `folder` (`folder`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

CREATE TABLE IF NOT EXISTS `genres` (
  `ganre_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ganre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `languages` (
  `language_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


ALTER TABLE `films_genres`
  ADD CONSTRAINT `FK53D17E207069E578` FOREIGN KEY (`id`) REFERENCES `films` (`id`),
  ADD CONSTRAINT `FK53D17E2080004883` FOREIGN KEY (`ganre_id`) REFERENCES `genres` (`ganre_id`);

ALTER TABLE `films_languages`
  ADD CONSTRAINT `FK3BCB4F4B7069E578` FOREIGN KEY (`id`) REFERENCES `films` (`id`),
  ADD CONSTRAINT `FK3BCB4F4BFB92EB93` FOREIGN KEY (`language_id`) REFERENCES `languages` (`language_id`);
