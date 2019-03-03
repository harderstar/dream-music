/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.17 : Database - dream-music-db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dream-music-db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dream-music-db`;

/*Table structure for table `album` */

DROP TABLE IF EXISTS `album`;

CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `singer_id` int(11) NOT NULL,
  `issue_company` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `photo` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Details` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `3_idx` (`singer_id`),
  CONSTRAINT `3` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `album` */

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `programeId` varchar(100) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `external_link` varchar(100) DEFAULT NULL,
  `digest` varchar(100) DEFAULT NULL,
  `issuer` varchar(45) DEFAULT NULL,
  `uptime` date DEFAULT NULL,
  `stick_level` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `comment_image` varchar(100) DEFAULT NULL,
  `subtitle` varchar(100) DEFAULT NULL,
  `detail` longblob,
  `title_color` varchar(100) DEFAULT NULL,
  `click_num` int(11) DEFAULT NULL,
  `commit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`programeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

/*Table structure for table `label` */

DROP TABLE IF EXISTS `label`;

CREATE TABLE `label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `is_cash` int(11) DEFAULT NULL,
  `is_tip` int(11) DEFAULT NULL,
  `cash_num` int(11) DEFAULT NULL,
  `source_times` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `label` */

/*Table structure for table `music` */

DROP TABLE IF EXISTS `music`;

CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `singer_id` int(11) NOT NULL,
  `album_id` int(11) DEFAULT NULL,
  `audition_url` varchar(100) NOT NULL,
  `lyric` varchar(200) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `popularity` int(11) DEFAULT '0',
  `size` double DEFAULT '0',
  `like` int(11) DEFAULT '0',
  `download_num` int(11) DEFAULT '0',
  `collect` int(11) DEFAULT '0',
  `power` int(11) DEFAULT '0',
  `composer` varchar(45) DEFAULT NULL,
  `download_url` varchar(100) DEFAULT NULL,
  `dance_template` varchar(100) DEFAULT NULL,
  `uptime` date DEFAULT NULL,
  `commit` int(11) DEFAULT NULL,
  `recommend` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `singer_idx` (`singer_id`),
  KEY `5_idx` (`album_id`),
  CONSTRAINT `5` FOREIGN KEY (`album_id`) REFERENCES `album` (`id`),
  CONSTRAINT `6` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `music` */

/*Table structure for table `music_on_list` */

DROP TABLE IF EXISTS `music_on_list`;

CREATE TABLE `music_on_list` (
  `music_id` int(11) NOT NULL,
  `list_id` int(11) NOT NULL,
  PRIMARY KEY (`music_id`,`list_id`),
  KEY `2_idx` (`list_id`),
  CONSTRAINT `1` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`),
  CONSTRAINT `2` FOREIGN KEY (`list_id`) REFERENCES `ranking_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `music_on_list` */

/*Table structure for table `musics_label` */

DROP TABLE IF EXISTS `musics_label`;

CREATE TABLE `musics_label` (
  `music_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  PRIMARY KEY (`music_id`,`label_id`),
  KEY `8_idx` (`label_id`),
  CONSTRAINT `7` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`),
  CONSTRAINT `8` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `musics_label` */

/*Table structure for table `programe` */

DROP TABLE IF EXISTS `programe`;

CREATE TABLE `programe` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `model_location` varchar(100) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `is_show` int(11) DEFAULT NULL,
  `parent_id` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `station_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `programe` */

/*Table structure for table `ranking_list` */

DROP TABLE IF EXISTS `ranking_list`;

CREATE TABLE `ranking_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ranking_list` */

/*Table structure for table `singer` */

DROP TABLE IF EXISTS `singer`;

CREATE TABLE `singer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` varchar(5) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `introduction` varchar(400) DEFAULT NULL,
  `hot_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `singer` */

insert  into `singer`(`id`,`name`,`sex`,`birthdate`,`introduction`,`hot_level`) values (1,'周杰伦','男','2019-03-23','台湾歌手代表作-----',5),(2,'薛之谦','男','2019-03-29','大陆男歌手代表着---',5);

/*Table structure for table `station` */

DROP TABLE IF EXISTS `station`;

CREATE TABLE `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `detail` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `station` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `sign` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(11) DEFAULT NULL,
  `wechat` varchar(20) DEFAULT NULL,
  `safe_question` varchar(60) DEFAULT NULL,
  `safe_answer` varchar(60) DEFAULT NULL,
  `power` int(11) DEFAULT '0',
  `last_login_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
