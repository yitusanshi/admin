/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : admin

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-01 18:11:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for pro_classify
-- ----------------------------
DROP TABLE IF EXISTS `pro_classify`;
CREATE TABLE `pro_classify` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `classify_id` varchar(255) NOT NULL,
  `classify_name` varchar(255) NOT NULL COMMENT '分类名字',
  `classify_desc` text,
  `insert_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pro_classify
-- ----------------------------
INSERT INTO `pro_classify` VALUES ('1', '1', '产品产出', '', '2018-12-01 17:18:00');
INSERT INTO `pro_classify` VALUES ('2', '2', '原料消耗', null, '2018-12-01 17:18:01');
INSERT INTO `pro_classify` VALUES ('3', '3', '资源消耗_井水', null, '2018-12-01 17:18:02');
INSERT INTO `pro_classify` VALUES ('4', '4', '资源消耗_自来水', null, '2018-12-01 17:18:03');
INSERT INTO `pro_classify` VALUES ('5', '5', '能源消耗', null, '2018-12-01 17:18:03');
INSERT INTO `pro_classify` VALUES ('6', '6', '废气排放', null, '2018-12-01 17:18:30');
INSERT INTO `pro_classify` VALUES ('7', '7', '废水排放', null, '2018-12-01 17:18:05');
INSERT INTO `pro_classify` VALUES ('8', '8', '固体废弃物', null, '2018-12-01 17:18:06');
INSERT INTO `pro_classify` VALUES ('9', '9', '废气排放-天然气明火炉', '钢帘线和胎圈钢丝专有', '2018-12-01 17:18:06');
INSERT INTO `pro_classify` VALUES ('10', '10', '废气排放-线材酸洗、电镀工序', '钢帘线和胎圈钢丝专有', '2018-12-01 17:18:09');
INSERT INTO `pro_classify` VALUES ('11', '11', '废水排放-酸洗废水', '钢帘线和胎圈钢丝专有', '2018-12-01 17:18:10');
INSERT INTO `pro_classify` VALUES ('12', '12', '废水排放-电镀工序', '钢帘线和胎圈钢丝专有', '2018-12-01 17:18:12');
INSERT INTO `pro_classify` VALUES ('13', '13', '运输过程_海运', null, '2018-12-01 17:18:14');
INSERT INTO `pro_classify` VALUES ('14', '14', '运输过程_陆运', null, '2018-12-01 17:18:17');
INSERT INTO `pro_classify` VALUES ('15', '15', '运输过程_空运', null, '2018-12-01 17:18:22');
