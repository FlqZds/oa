/*
SQLyog Community v12.09 (64 bit)
MySQL - 8.0.36 : Database - oa
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`oa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `oa`;

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `log_id` int NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `log_title` varchar(50) NOT NULL DEFAULT '默认标题' COMMENT '日志标题',
  `log_uploadFilePath` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上传文件存储路径',
  `user_id` int NOT NULL COMMENT '用户id',
  `role_id` int NOT NULL COMMENT '权限id',
  `log_content` varchar(4096) NOT NULL COMMENT '日志内容',
  `log_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `log_receiver` varchar(50) NOT NULL COMMENT '接收人',
  PRIMARY KEY (`log_id`),
  KEY `log_id` (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `log` */

insert  into `log`(`log_id`,`log_title`,`log_uploadFilePath`,`user_id`,`role_id`,`log_content`,`log_time`,`log_receiver`) values (1,'默认标题',NULL,1,0,'test测试','2024-04-24 14:43:57','0'),(2,'默认标题',NULL,2,0,'q[oj在一个宁静的夜晚，小兔子抬头看到了满天的星星。它心想：“如果我能有一颗星星作为礼物，那该有多好啊！”于是，小兔子闭上眼睛，许了一个愿望。突然，一颗小小的星星从天空中落了下来，轻轻地落在了小兔子的手中。小兔子惊讶又开心地捧着星星，它发现星星暖暖的，还散发着淡淡的光芒。“这是送给你的礼物，”星星温柔地说，“希望你在每个夜晚都能感受到我的陪伴。”从那以后，小兔子每晚都会抱着星星入睡，它觉得非常温暖和安心。','2024-04-29 09:53:27','0'),(3,'默认标题',NULL,1,0,'小鸭子和小青蛙是好朋友，它们住在一个美丽的小湖边。一天，小鸭子对小青蛙说：“我好想去对岸看看，那里有我没见过的风景。”小青蛙想了想，说：“我听说有一座彩虹桥可以通往对岸，我们一起去找吧！”于是，它们开始踏上了寻找彩虹桥的旅程。经过了一片茂密的森林和一条湍急的河流，它们终于找到了那座传说中的彩虹桥。桥身五彩斑斓，仿佛是由天空中最美的色彩编织而成。小鸭子和小青蛙小心翼翼地踏上了彩虹桥，它们看到了对岸的美丽景色，也感受到了友谊的温暖和力量。','2024-04-30 09:55:23','0'),(4,'默认标题',NULL,2,0,'小熊在寒冷的冬夜里迷路了，它找不到回家的路，感到非常害怕和孤独。这时，它看到了一只大兔子正在不远处烤火取暖。小熊鼓起勇气，走向大兔子并请求帮助。大兔子看到小熊可怜的样子，便邀请它一起烤火取暖。在温暖的火光下，大兔子给了小熊一个温暖的拥抱。小熊感到从未有过的安心和舒适，它知道无论遇到什么困难，都会有人愿意给予它帮助和关爱。最终，在大兔子的帮助下，小熊找到了回家的路。它永远记住了那个温暖的拥抱和那份无私的关爱。','2024-04-18 09:57:12','0'),(5,'默认标题',NULL,1,0,'小女孩有一个美丽的梦想，她希望拥有一个属于自己的花园，里面种满了各种各样的花朵。有一天晚上，她做了一个神奇的梦。在梦中，她来到了一个五彩斑斓的花园，花园里有玫瑰、百合、郁金香等各种美丽的花朵。小女孩在花园里快乐地奔跑着，她闻到了花香，听到了鸟鸣，感受到了大自然的神奇和美丽。当小女孩醒来后，她决定要实现自己的梦想。她开始在自家的院子里种植各种花朵，并用心地照顾它们。没过多久，她的院子里也变成了一个美丽的花园。小女孩每天都会在花园里玩耍和休息，她感到无比幸福和满足。希望这些故事能给你带来温馨和美好的感觉，祝你晚安好梦！','2024-05-23 09:57:27','0');

/*Table structure for table `power` */

DROP TABLE IF EXISTS `power`;

CREATE TABLE `power` (
  `powerId` int NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `powerName` varchar(100) NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`powerId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `power` */

insert  into `power`(`powerId`,`powerName`) values (1,'发工资'),(2,'查日志');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int NOT NULL COMMENT '权限id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role_name`) values (0,'admin');

/*Table structure for table `roletopower` */

DROP TABLE IF EXISTS `roletopower`;

CREATE TABLE `roletopower` (
  `roleId` int NOT NULL COMMENT '角色Id',
  `powerId` int NOT NULL COMMENT '权限Id',
  PRIMARY KEY (`roleId`,`powerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `roletopower` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_count` varchar(255) NOT NULL COMMENT '用户账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户创建时间',
  `userTel` int DEFAULT NULL COMMENT '用户手机号',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`user_count`,`password`,`create_time`,`userTel`) values (1,'admin','admin','123456','2024-04-24 14:43:01',0),(2,'zhangsan','fcfz135246','123456','2024-04-26 13:35:01',0);

/*Table structure for table `usertorole` */

DROP TABLE IF EXISTS `usertorole`;

CREATE TABLE `usertorole` (
  `userId` int NOT NULL COMMENT '用户iD',
  `roleId` int NOT NULL COMMENT '角色iD',
  PRIMARY KEY (`userId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usertorole` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
