/*
Navicat MySQL Data Transfer

Source Server         : mysql8
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-22 23:14:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for urlmgr
-- ----------------------------
DROP TABLE IF EXISTS `urlmgr`;
CREATE TABLE `urlmgr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `urlName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of urlmgr
-- ----------------------------
INSERT INTO `urlmgr` VALUES ('1', '订单管理', '/order', null);
INSERT INTO `urlmgr` VALUES ('2', '客户管理', null, null);
INSERT INTO `urlmgr` VALUES ('3', '权限管理', null, null);
