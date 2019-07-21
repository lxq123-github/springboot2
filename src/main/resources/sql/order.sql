/*
Navicat MySQL Data Transfer

Source Server         : mysql8
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-07-17 23:28:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `clientId` varchar(11) NOT NULL,
  `orderDate` datetime NOT NULL,
  `quantity` int(11) NOT NULL,
  `commont` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('5', '1005', '2019-07-17 00:00:00', '22', 'abdc');
INSERT INTO `order` VALUES ('6', '1007', '2019-07-17 07:51:21', '236', 'aaaa');
INSERT INTO `order` VALUES ('7', '1008', '2019-07-17 07:56:26', '1000', 'aaaa');
INSERT INTO `order` VALUES ('8', '1008', '2019-07-17 08:07:15', '1000', 'xxxx');
INSERT INTO `order` VALUES ('10', '1009', '2019-07-17 08:07:15', '1000', 'aaaa');
INSERT INTO `order` VALUES ('11', '1011', '2019-07-17 00:00:00', '200', 'ab');
INSERT INTO `order` VALUES ('12', '1012', '2019-07-17 00:00:00', '300', 'cd');
INSERT INTO `order` VALUES ('13', '1013', '2019-07-17 00:00:00', '400', 'ag');
INSERT INTO `order` VALUES ('14', '1013', '2019-07-17 00:00:00', '500', 'tt');
INSERT INTO `order` VALUES ('16', '12', '2019-07-17 00:00:00', '23', '12');
INSERT INTO `order` VALUES ('17', '13', '2019-07-17 00:00:00', '23', '12');
INSERT INTO `order` VALUES ('20', '1020', '2019-07-17 00:00:00', '23', '12');
INSERT INTO `order` VALUES ('21', '1021', '2019-07-17 00:00:00', '23', '12');
