/*
SQLyog Community Edition- MySQL GUI v5.22a
Host - 5.0.67-community-nt-log : Database - hibernateannotation
*********************************************************************
Server version : 5.0.67-community-nt-log
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL auto_increment,
  `address` varchar(250) NOT NULL,
  `person_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKBB979BF4F7222520` (`person_id`),
  CONSTRAINT `FKBB979BF4F7222520` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`id`,`address`,`person_id`) values (1,'New Delhi, Sector-3',1);

/*Table structure for table `author` */

DROP TABLE IF EXISTS `author`;

CREATE TABLE `author` (
  `id` int(11) NOT NULL auto_increment,
  `authorName` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `author` */

insert  into `author`(`id`,`authorName`) values (1,'Clifford Geertz'),(2,'JP Morgenthal');

/*Table structure for table `author_book` */

DROP TABLE IF EXISTS `author_book`;

CREATE TABLE `author_book` (
  `bookId` int(11) NOT NULL,
  `authorId` int(11) NOT NULL,
  PRIMARY KEY  (`authorId`,`bookId`),
  KEY `FK2A7A111DB63F85B3` (`bookId`),
  KEY `FK2A7A111DFC08F7` (`authorId`),
  CONSTRAINT `FK2A7A111DFC08F7` FOREIGN KEY (`authorId`) REFERENCES `author` (`id`),
  CONSTRAINT `FK2A7A111DB63F85B3` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `author_book` */

insert  into `author_book`(`bookId`,`authorId`) values (1,1),(2,1),(1,2),(2,2);

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL auto_increment,
  `bookName` varchar(250) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`id`,`bookName`) values (1,'Phoenix'),(2,'Enterprise Applications Integration with XML and Java');

/*Table structure for table `child` */

DROP TABLE IF EXISTS `child`;

CREATE TABLE `child` (
  `id` int(11) NOT NULL auto_increment,
  `cname` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `child` */

insert  into `child`(`id`,`cname`) values (1,'Tommy'),(2,'Rocky');

/*Table structure for table `parent` */

DROP TABLE IF EXISTS `parent`;

CREATE TABLE `parent` (
  `id` int(11) NOT NULL auto_increment,
  `pname` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `parent` */

insert  into `parent`(`id`,`pname`) values (1,'Moc');

/*Table structure for table `parentchild` */

DROP TABLE IF EXISTS `parentchild`;

CREATE TABLE `parentchild` (
  `parentId` int(11) NOT NULL default '0',
  `childrenId` int(11) NOT NULL,
  PRIMARY KEY  (`parentId`,`childrenId`),
  UNIQUE KEY `childrenId` (`childrenId`),
  KEY `FK9E5C7E72A1A8B75` (`parentId`),
  KEY `FK9E5C7E725FABE430` (`childrenId`),
  CONSTRAINT `FK9E5C7E725FABE430` FOREIGN KEY (`childrenId`) REFERENCES `child` (`id`),
  CONSTRAINT `FK9E5C7E72A1A8B75` FOREIGN KEY (`parentId`) REFERENCES `parent` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `parentchild` */

insert  into `parentchild`(`parentId`,`childrenId`) values (1,1),(1,2);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `person` */

insert  into `person`(`id`,`name`) values (1,'Vinod Kumar');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
