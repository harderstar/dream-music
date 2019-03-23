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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `programeId` int(11) NOT NULL,
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
  KEY `user_id_idx` (`programeId`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`programeId`) REFERENCES `programe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`id`,`programeId`,`title`,`external_link`,`digest`,`issuer`,`uptime`,`stick_level`,`type`,`comment_image`,`subtitle`,`detail`,`title_color`,`click_num`,`commit`) values (1,50,'dsf','sdf','sd','sd','2019-03-20',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `label` */

insert  into `label`(`id`,`name`,`is_cash`,`is_tip`,`cash_num`,`source_times`) values (1,'热血',1,1,NULL,NULL),(2,'激情',NULL,NULL,NULL,NULL),(3,'动漫',NULL,NULL,NULL,NULL),(4,'游戏',NULL,NULL,NULL,NULL),(5,'爱情',NULL,NULL,NULL,NULL);

/*Table structure for table `label_and_music` */

DROP TABLE IF EXISTS `label_and_music`;

CREATE TABLE `label_and_music` (
  `music_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  PRIMARY KEY (`music_id`,`label_id`),
  KEY `label_id` (`label_id`),
  CONSTRAINT `label_and_music_ibfk_1` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`),
  CONSTRAINT `label_and_music_ibfk_2` FOREIGN KEY (`label_id`) REFERENCES `label` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `label_and_music` */

insert  into `label_and_music`(`music_id`,`label_id`) values (4,1),(4,3),(1,4),(4,4),(5,4),(6,4),(4,5),(5,5);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `last_login` datetime NOT NULL,
  `power` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

/*Table structure for table `music` */

DROP TABLE IF EXISTS `music`;

CREATE TABLE `music` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `music` */

insert  into `music`(`id`,`name`,`audition_url`,`lyric`,`photo`,`popularity`,`size`,`like`,`download_num`,`collect`,`power`,`composer`,`download_url`,`dance_template`,`uptime`,`commit`,`recommend`) values (1,'asdasd','sada','asd','asd',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(2,'sad','asd','asd','asd',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(3,'ads','ads','asdasd','asdasdas',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(4,'zxczxc','asdasdas','xxcvxcv','asdasdas',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(5,'fgbgdbgdb','dfvdfvdfv','fdvfdd','xvcvxc',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(6,'fsdfsd','sdfdsf','zxczxc','fdgfdfd',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(7,'asdsadas','zczxcxz','zxczxcxz','sdfdsfds',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL),(8,'zczxczxc','sfsdfsdfsd','zxczxczxc','sdsdfsdf',0,0,0,0,0,0,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `programe` */

DROP TABLE IF EXISTS `programe`;

CREATE TABLE `programe` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `value` varchar(100) DEFAULT NULL,
  `model_location` varchar(100) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `is_show` int(11) DEFAULT NULL,
  `parent_id` int(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `station_id` int(11) DEFAULT NULL,
  `is_parent` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;

/*Data for the table `programe` */

insert  into `programe`(`id`,`value`,`model_location`,`order`,`is_show`,`parent_id`,`model`,`count`,`type`,`station_id`,`is_parent`) values (3,'语种','dasda',1,1,9,'232',1,2,1,1),(5,'首页',NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,1),(7,'根目录','23423',NULL,1,0,NULL,1,NULL,1,1),(9,'歌单',NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,1),(11,'热门推荐',NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,1),(39,'轮播图','爱仕达',NULL,NULL,5,NULL,NULL,NULL,NULL,0),(40,'入驻歌手','32432',NULL,1,5,NULL,11,NULL,1,0),(41,'新碟上架','1',NULL,1,5,NULL,1,NULL,1,0),(42,'华语','sd',NULL,1,11,NULL,1,NULL,1,0),(43,'流行','232',NULL,23,11,NULL,1,NULL,1,0),(48,'主播电台',NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,0),(49,'歌手',NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,1),(50,'新碟上架',NULL,NULL,NULL,7,NULL,NULL,NULL,NULL,0),(51,'摇滚',NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,0),(52,'民谣',NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,0),(53,'电子',NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,0),(54,'榜单',NULL,NULL,NULL,5,NULL,NULL,NULL,NULL,1),(56,'云音乐新歌榜',NULL,NULL,NULL,54,NULL,NULL,NULL,NULL,0),(57,'网易创新榜',NULL,NULL,NULL,54,NULL,NULL,NULL,NULL,1),(61,'风格',NULL,NULL,NULL,9,NULL,NULL,NULL,NULL,1),(62,'场景',NULL,NULL,NULL,9,NULL,NULL,NULL,NULL,1),(63,'情感',NULL,NULL,NULL,9,NULL,NULL,NULL,NULL,1),(65,'华语',NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,0),(66,'欧美',NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,0),(67,'日语',NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,0),(68,'韩语',NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,0),(69,'粤语',NULL,NULL,NULL,3,NULL,NULL,NULL,NULL,0),(70,'流行',NULL,NULL,NULL,61,NULL,NULL,NULL,NULL,0),(71,'摇滚',NULL,NULL,NULL,61,NULL,NULL,NULL,NULL,0),(72,'民谣',NULL,NULL,NULL,61,NULL,NULL,NULL,NULL,0),(73,'电子',NULL,NULL,NULL,61,NULL,NULL,NULL,NULL,0),(74,'清晨',NULL,NULL,NULL,62,NULL,NULL,NULL,NULL,0),(75,'夜晚',NULL,NULL,NULL,62,NULL,NULL,NULL,NULL,0),(76,'学习',NULL,NULL,NULL,62,NULL,NULL,NULL,NULL,0),(77,'下午茶',NULL,NULL,NULL,62,NULL,NULL,NULL,NULL,0),(78,'怀旧',NULL,NULL,NULL,63,NULL,NULL,NULL,NULL,0),(79,'清新',NULL,NULL,NULL,63,NULL,NULL,NULL,NULL,0),(80,'浪漫',NULL,NULL,NULL,63,NULL,NULL,NULL,NULL,0),(81,'性感',NULL,NULL,NULL,63,NULL,NULL,NULL,NULL,0),(86,'推荐',NULL,NULL,NULL,49,NULL,NULL,NULL,NULL,0),(87,'华语',NULL,NULL,NULL,49,NULL,NULL,NULL,NULL,0),(89,'韩国',NULL,NULL,NULL,49,NULL,NULL,NULL,NULL,0),(90,'其他',NULL,NULL,NULL,49,NULL,NULL,NULL,NULL,0),(91,'热门歌手',NULL,NULL,NULL,49,NULL,NULL,NULL,NULL,0);

/*Table structure for table `ranking_list` */

DROP TABLE IF EXISTS `ranking_list`;

CREATE TABLE `ranking_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ranking_list` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `download_size` int(11) DEFAULT NULL,
  `is_load` int(11) DEFAULT NULL,
  `is_content` int(11) DEFAULT NULL,
  `default` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `singer` */

insert  into `singer`(`id`,`name`,`sex`,`birthdate`,`introduction`,`hot_level`) values (1,'周杰伦','男','2019-03-23','台湾歌手代表作-----',5),(2,'薛之谦','男','2019-03-29','大陆男歌手代表着---',5),(3,'林俊杰','男','2019-03-18',NULL,5);

/*Table structure for table `singer_and_music` */

DROP TABLE IF EXISTS `singer_and_music`;

CREATE TABLE `singer_and_music` (
  `singer_id` int(11) NOT NULL,
  `music_id` int(11) NOT NULL,
  PRIMARY KEY (`singer_id`,`music_id`),
  KEY `music_id` (`music_id`),
  CONSTRAINT `singer_and_music_ibfk_1` FOREIGN KEY (`singer_id`) REFERENCES `singer` (`id`),
  CONSTRAINT `singer_and_music_ibfk_2` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `singer_and_music` */

insert  into `singer_and_music`(`singer_id`,`music_id`) values (1,1),(3,1),(2,2),(1,3),(1,4),(3,4),(2,6),(2,7),(3,7);

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
  `last_login_time` date DEFAULT NULL,
  `vip` int(11) DEFAULT NULL,
  `download_size` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`password`,`sex`,`birthdate`,`sign`,`phonenumber`,`wechat`,`safe_question`,`safe_answer`,`last_login_time`,`vip`,`download_size`) values (1,'simdy','111111','1','2019-03-15','23232','11111111','1111','11','111','2019-03-15',1,100),(2,'jimy','1111','1','2019-03-15',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(3,'asas','11111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(4,'ghjmb','1111',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(5,'cgj','11112',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'vdgdfg','12121121',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(7,'vbcvbxcvxc','1221232',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(8,'dsf','234324',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(9,'sdvxc','23423423',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(10,'fghgf','23423423',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(11,'3dffg45','fsdfsdfsd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(12,'sdfsdf','sdfsdfsfs',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL),(13,'3423edf','dsfdsfsdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL),(14,'dsfxcvfdgdfg','sdfsdfds',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL),(16,'jimya','dasdsa',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(17,'dsfsdf','435',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,3,NULL),(18,'jmjhm','565',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(19,'fghgfhfgh','879ikjhnbv c',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(20,'dsfsdfdsf','65yhgbvcxzcsc',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,NULL),(21,'dsfdsfxcvcx','sdsadsd',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL);

/*Table structure for table `vip` */

DROP TABLE IF EXISTS `vip`;

CREATE TABLE `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `is_base` int(11) DEFAULT NULL,
  `download_size` int(11) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `is_comtent` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `vip` */

insert  into `vip`(`id`,`name`,`is_base`,`download_size`,`fee`,`is_comtent`) values (1,'黄砖',1,100,20,1),(2,'蓝砖',2,1000,10,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
