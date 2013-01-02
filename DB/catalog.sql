SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


DROP TABLE IF EXISTS `actors`;
CREATE TABLE IF NOT EXISTS `actors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

DROP TABLE IF EXISTS `directors`;
CREATE TABLE IF NOT EXISTS `directors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

DROP TABLE IF EXISTS `files`;
CREATE TABLE IF NOT EXISTS `files` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `film_id` int(11) DEFAULT NULL,
  `path` varchar(255) NOT NULL,
  `fileSize` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `path` (`path`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=215 ;

DROP TABLE IF EXISTS `films`;
CREATE TABLE IF NOT EXISTS `films` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `existed` tinyint(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `version` varchar(32) DEFAULT NULL,
  `watched` tinyint(1) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `detail_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `detail_id` (`detail_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1997 ;

DROP TABLE IF EXISTS `films_genres`;
CREATE TABLE IF NOT EXISTS `films_genres` (
  `id` int(11) NOT NULL,
  `ganre_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`ganre_id`),
  KEY `FK53D17E207069E578` (`id`),
  KEY `FK53D17E2080004883` (`ganre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `films_languages`;
CREATE TABLE IF NOT EXISTS `films_languages` (
  `id` int(11) NOT NULL,
  `language_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`language_id`),
  KEY `FK3BCB4F4B7069E578` (`id`),
  KEY `FK3BCB4F4BFB92EB93` (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `folders`;
CREATE TABLE IF NOT EXISTS `folders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `folder` (`folder`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

DROP TABLE IF EXISTS `genres`;
CREATE TABLE IF NOT EXISTS `genres` (
  `ganre_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ganre_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

DROP TABLE IF EXISTS `imdb_details`;
CREATE TABLE IF NOT EXISTS `imdb_details` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `alsoKnownAs` varchar(255) DEFAULT NULL,
  `filmingLocations` varchar(255) DEFAULT NULL,
  `imdbId` varchar(255) DEFAULT NULL,
  `imdbUrl` varchar(255) DEFAULT NULL,
  `localPoster` varchar(255) DEFAULT NULL,
  `plotSimple` longtext,
  `poster` varchar(255) DEFAULT NULL,
  `rating` varchar(8) DEFAULT NULL,
  `ratingCount` int(11) DEFAULT NULL,
  `releaseDate` varchar(16) DEFAULT NULL,
  `runtime` varchar(50) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

DROP TABLE IF EXISTS `languages`;
CREATE TABLE IF NOT EXISTS `languages` (
  `language_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

DROP TABLE IF EXISTS `movies_actors`;
CREATE TABLE IF NOT EXISTS `movies_actors` (
  `detail_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`detail_id`,`id`),
  KEY `FK2D20C99A72B8F03D` (`id`),
  KEY `FK2D20C99AAD5024E5` (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `writers`;
CREATE TABLE IF NOT EXISTS `writers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;


ALTER TABLE `films`
  ADD CONSTRAINT `films_ibfk_1` FOREIGN KEY (`detail_id`) REFERENCES `imdb_details` (`detail_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE `films_genres`
  ADD CONSTRAINT `FK53D17E207069E578` FOREIGN KEY (`id`) REFERENCES `films` (`id`),
  ADD CONSTRAINT `FK53D17E2080004883` FOREIGN KEY (`ganre_id`) REFERENCES `genres` (`ganre_id`);

ALTER TABLE `films_languages`
  ADD CONSTRAINT `FK3BCB4F4B7069E578` FOREIGN KEY (`id`) REFERENCES `films` (`id`),
  ADD CONSTRAINT `FK3BCB4F4BFB92EB93` FOREIGN KEY (`language_id`) REFERENCES `languages` (`language_id`);

ALTER TABLE `movies_actors`
  ADD CONSTRAINT `FK2D20C99A72B8F03D` FOREIGN KEY (`id`) REFERENCES `actors` (`id`),
  ADD CONSTRAINT `FK2D20C99AAD5024E5` FOREIGN KEY (`detail_id`) REFERENCES `imdb_details` (`detail_id`);
