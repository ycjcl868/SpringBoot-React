/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 100125
 Source Host           : localhost:3306
 Source Schema         : kylin

 Target Server Type    : MySQL
 Target Server Version : 100125
 File Encoding         : 65001

 Date: 11/12/2017 23:44:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `thumbnail` varchar(100) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `number` float(11,1) NOT NULL,
  `salenum` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, '英伦对决', '成龙', 55, 'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2499135561.jpg', '2017-12-11 22:45:06', 6.9, 4);
INSERT INTO `goods` VALUES (2, '王牌特工2', '塔伦·埃格顿', 34, 'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2499792043.jpg', '2017-12-11 22:44:55', 7.8, 7);
INSERT INTO `goods` VALUES (3, '方法派', '朴圣雄', 34, 'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2502082901.jpg', '2017-12-11 22:44:52', 7.6, 3);
INSERT INTO `goods` VALUES (4, '敦刻尔克', '菲恩·怀特海德', 25, 'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2494950714.jpg', '2017-12-11 22:44:48', 8.6, 6);
INSERT INTO `goods` VALUES (5, '西游记', '六小龄童', 46, 'https://img1.doubanio.com/view/photo/m/public/p2265959269.webp', '2017-12-11 22:44:46', 6.8, 15);
INSERT INTO `goods` VALUES (6, '寻梦环游记', '安东尼', 33, 'https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2503997609.webp', '2017-12-11 22:44:43', 9.6, 9);
INSERT INTO `goods` VALUES (7, '帕丁顿熊2', '本·卫肖', 88, 'https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2506466229.webp', '2017-12-11 22:44:40', 6.9, 8);
INSERT INTO `goods` VALUES (8, '老兽', '涂们', 70, 'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2507370070.webp', '2017-12-11 22:40:16', 7.5, 0);
COMMIT;

-- ----------------------------
-- Table structure for information
-- ----------------------------
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

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (9, 'jcl@qq.com', 'QrcOUmuBX8g+');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
