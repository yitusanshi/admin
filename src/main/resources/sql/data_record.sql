/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-01 18:10:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_record
-- ----------------------------
DROP TABLE IF EXISTS `data_record`;
CREATE TABLE `data_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firm_id` int(11) NOT NULL COMMENT '厂商id',
  `tag_time` VARCHAR (50) NOT NULL COMMENT '时间戳',
  `category_id` varchar(255) NOT NULL COMMENT '种类id',
  `classify_id` varchar(255) NOT NULL COMMENT '分类id',
  `product_volume` float(20,5) NOT NULL COMMENT '产量/消耗量/数值',
  `data_source` varchar(255) DEFAULT NULL COMMENT '数据来源',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `applicant_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_record
-- ----------------------------
