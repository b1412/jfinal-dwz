/*
SQLyog Ultimate v8.32 
MySQL - 5.5.23 : Database - jfinal_demo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jfinal_demo` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jfinal_demo`;

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` mediumtext NOT NULL,
  `userId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=gbk;

/*Data for the table `blog` */

insert  into `blog`(`id`,`title`,`content`,`userId`) values (26,'11','4443',NULL),(27,'22','44',NULL),(28,'1','2',NULL),(29,'new1','new',NULL),(30,'2','22',NULL),(31,'2','22',NULL),(32,'2','222',NULL),(33,'1','2',NULL),(34,'1','2',NULL),(35,'1','22222222',NULL),(36,'22啊啊','1 我',NULL),(37,'a','f',NULL),(38,'JFinal Demo Title here','22',NULL),(39,'JFinal Demo Title here','22',NULL),(40,'22','222',NULL),(41,'2','2',NULL),(42,'111','111',NULL),(43,'a ','a a ',NULL),(44,'a ','a a ',NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `pwd` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`age`,`name`,`pwd`) values (1,11,'a',NULL),(5,NULL,NULL,'22'),(6,NULL,NULL,NULL),(7,1,'1','1'),(8,NULL,NULL,'1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


-- ----------------------------
-- Table structure for `org`
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orgNum` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orgName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `orgParentNum` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `leader` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES ('1', '001', 'xx', '-1', 'mm');
INSERT INTO `org` VALUES ('2', '002', 'rr', '-1', 'gg');

