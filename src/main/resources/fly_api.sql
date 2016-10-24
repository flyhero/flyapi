/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.22
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : fly_api

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2016-10-24 17:57:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d1_user
-- ----------------------------
DROP TABLE IF EXISTS `d1_user`;
CREATE TABLE `d1_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT '2016-08-08 00:00:00',
  `user_name` varchar(50) NOT NULL,
  `user_pw` varchar(20) NOT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  `login_count` int(10) NOT NULL DEFAULT '0',
  `login_ip` varchar(50) DEFAULT '',
  `email` varchar(50) DEFAULT '',
  `sex` int(2) NOT NULL DEFAULT '0' COMMENT '0女1男',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d3_project
-- ----------------------------
DROP TABLE IF EXISTS `d3_project`;
CREATE TABLE `d3_project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `project_name` varchar(50) NOT NULL DEFAULT '' COMMENT '项目名称',
  `description` varchar(255) DEFAULT '' COMMENT '项目描述',
  `project_version` varchar(10) NOT NULL DEFAULT '' COMMENT '项目版本号',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d4_module
-- ----------------------------
DROP TABLE IF EXISTS `d4_module`;
CREATE TABLE `d4_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `module_name` varchar(255) NOT NULL,
  `module_des` varchar(255) DEFAULT NULL,
  `project_id` int(11) NOT NULL,
  `update_time` timestamp NULL DEFAULT '2016-08-08 00:00:00',
  `is_delete` int(1) DEFAULT '0',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d5_interfaces
-- ----------------------------
DROP TABLE IF EXISTS `d5_interfaces`;
CREATE TABLE `d5_interfaces` (
  `interface_id` int(11) NOT NULL AUTO_INCREMENT,
  `inter_name` varchar(50) NOT NULL DEFAULT '' COMMENT '接口名称',
  `inter_des` varchar(255) DEFAULT '' COMMENT '接口描述',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0可用1废弃',
  `inter_url` varchar(255) NOT NULL DEFAULT '' COMMENT '接口地址',
  `method` varchar(10) NOT NULL DEFAULT '' COMMENT '请求方式',
  `param` text COMMENT '请求参数',
  `requestExam` text COMMENT '请求示例',
  `responseParam` text COMMENT '返回参数说明',
  `trueExam` text COMMENT '返回成功示例',
  `falseExam` text COMMENT '返回失败示例',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT '2016-08-08 00:00:00',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '0显示1不显示',
  `module_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`interface_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for r1_user_project
-- ----------------------------
DROP TABLE IF EXISTS `r1_user_project`;
CREATE TABLE `r1_user_project` (
  `r1_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `is_edit` int(1) NOT NULL DEFAULT '0' COMMENT '0可编辑1不可编辑',
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`r1_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
