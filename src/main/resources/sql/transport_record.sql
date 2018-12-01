/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-01 18:11:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for transport_record
-- ----------------------------
DROP TABLE IF EXISTS `transport_record`;
CREATE TABLE `transport_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firm_id` int(10) NOT NULL COMMENT '厂商id',
  `tag_time` int(30) NOT NULL COMMENT '时间标识',
  `category_id` varchar(255) NOT NULL COMMENT '种类id',
  `transport_volume` float(30,5) NOT NULL DEFAULT '0.00000',
  `transport_distance` float(30,5) DEFAULT '0.00000' COMMENT '运输距离',
  `is_load` int(10) NOT NULL DEFAULT '0',
  `applicant` varchar(255) DEFAULT NULL COMMENT '申请人',
  `applicant_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '填报时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transport_record
-- ----------------------------
