/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.12-log : Database - jeework
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jeework` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jeework`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `press` varchar(100) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `number` int(11) NOT NULL,
  `salenum` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goodsname`,`author`,`price`,`press`,`time`,`number`,`salenum`) values (1,'葵花宝典','令狐冲',55,'人民出版社','2017-12-04 10:53:56',30,4),(2,'如来神掌','功夫',34,'人民出版社','2017-12-04 10:53:59',20,7),(3,'java程序设计','孙宇',34,'机械出版社','2017-11-15 23:33:36',24,3),(4,'thinking in java','老师傅',25,'科大出版社','2017-12-04 10:54:06',10,6),(5,'西游记','罗贯中',46,'科大出版社','2017-12-04 10:54:08',20,15),(6,'三国演义','诸葛亮',33,'科大出版社','2017-12-04 10:54:10',15,9),(7,'水浒传','令狐冲',54,'人民出版社','2017-12-04 10:54:15',30,4),(8,'中国功夫','功夫',43,'人民出版社','2017-12-04 10:54:18',20,7),(9,'c++程序设计','孙宇',47,'机械出版社','2017-12-04 10:54:23',24,3),(10,'计算机组成原理','老师傅',44,'科大出版社','2017-12-04 10:54:27',10,6),(11,'操作系统','罗贯中',57,'科大出版社','2017-12-04 10:54:33',20,15),(12,'计算机网络','诸葛亮',46,'科大出版社','2017-12-04 10:54:37',15,9),(14,'mysql','令狐冲',34,'人民出版社','2017-12-04 10:54:43',30,4),(15,'oracle','功夫',26,'人民出版社','2017-12-04 10:54:48',20,7),(16,'数据库原理','孙宇',41,'机械出版社','2017-12-04 10:54:53',24,3),(17,'遮天','老师傅',36,'科大出版社','2017-12-04 10:55:04',10,6),(18,'神墓','罗贯中',54,'科大出版社','2017-12-04 10:55:07',20,15),(19,'Document','诸葛亮',35,'科大出版社','2017-12-04 10:55:15',15,9),(20,'sql service','令狐冲',42,'人民出版社','2017-12-04 10:55:19',30,4),(21,'红罗蒙','功夫',44,'人民出版社','2017-12-04 10:55:23',20,7),(22,'毛泽东思想','孙宇',28,'机械出版社','2017-12-04 10:55:27',24,3),(23,'邓小平理论','老师傅',28,'科大出版社','2017-12-04 10:55:32',10,6),(24,'三个代表','罗贯中',38,'科大出版社','2017-12-04 10:55:35',20,15),(25,'习近平语录','诸葛亮',48,'科大出版社','2017-12-04 10:55:46',15,9);

/*Table structure for table `information` */

DROP TABLE IF EXISTS `information`;

CREATE TABLE `information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `uname` varchar(100) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_information` (`uid`),
  CONSTRAINT `fk_user_information` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `information` */

insert  into `information`(`id`,`uid`,`uname`,`address`,`phone`) values (1,8,'王小明','陕西省西安市临潼区','110');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`pwd`) values (3,'wenhao5@eastmoney.com','qDODtJ7Br/bX'),(7,'1224234234@eastmoney.com','Ujfr5cJaNuNX'),(8,'wang@www.com','QrcOUmuBX8g+');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
