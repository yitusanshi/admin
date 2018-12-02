/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-01 18:11:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pro_category
-- ----------------------------
DROP TABLE IF EXISTS `pro_category`;
CREATE TABLE `pro_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '种类id',
  `category_id` varchar(255) DEFAULT NULL,
  `classify_id` varchar(255) NOT NULL COMMENT '分类id',
  `category_name` varchar(255) NOT NULL COMMENT '分类名字',
  `unit` varchar(255) NOT NULL COMMENT '单位',
  `desc` text COMMENT '描述',
  `steel_cord` int(10) NOT NULL DEFAULT '0' COMMENT '钢帘线',
  `sbr_rubber` int(10) NOT NULL DEFAULT '0' COMMENT '合成橡胶（丁苯橡胶）',
  `cis_rubber` int(10) NOT NULL DEFAULT '0' COMMENT '合成橡胶（顺丁橡胶）',
  `nylon_cord` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '尼龙帘布',
  `bead_wire` int(10) NOT NULL DEFAULT '0' COMMENT '胎圈钢丝',
  `carbon_black` int(10) NOT NULL DEFAULT '0' COMMENT '炭黑',
  `natural_rubber` int(10) NOT NULL DEFAULT '0' COMMENT '天然橡胶',
  `tyre_produce` int(10) NOT NULL DEFAULT '0' COMMENT '轮胎生产',
  `recla_rubber` int(10) NOT NULL DEFAULT '0' COMMENT '再生胶',
  `insert_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_category
-- ----------------------------
INSERT INTO `pro_category` VALUES ('1', '1', '1', '钢帘线', 't', null, '1', '0', '0', '0', '0', '0', '0', '0', '0', '2018-12-01 17:22:31');
INSERT INTO `pro_category` VALUES ('2', '2', '2', '盘条', 't', null, '1', '0', '0', '0', '0', '0', '0', '0', '0', '2018-12-01 17:22:36');
