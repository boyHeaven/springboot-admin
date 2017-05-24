/*
Navicat MySQL Data Transfer

Source Server         : localhost_mysql
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : test_springboot

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-05-25 17:25:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(32) NOT NULL COMMENT 'id',
  `userName` varchar(10) NOT NULL COMMENT '用户名字',
  `loginName` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `email` varchar(15) NOT NULL COMMENT '邮箱',
  `address` varchar(255) NOT NULL COMMENT '住址',
  `age` int(2) NOT NULL COMMENT '年龄',
  `sex` int(2) NOT NULL COMMENT '性别：0男，1女',
  `createdTime` datetime NOT NULL COMMENT '创建时间',
  `lastModifyTime` datetime NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('123123', 'binbin', 'binbin', '123', '123@qq.com', '北京', '25', '1', '2017-05-23 17:15:40', '2017-05-23 17:15:44');
