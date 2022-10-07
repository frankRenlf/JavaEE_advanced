/*
 Navicat Premium Data Transfer
 Source Server         : 本地数据库Root
 Source Server Type    : MySQL
 Source Schema         : SpringBoot

 Date: 08/06/2021 08:59:31
*/
CREATE DATABASE SpringBoot;
USE SpringBoot;
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', 'user', 'user');

SET FOREIGN_KEY_CHECKS = 1;
