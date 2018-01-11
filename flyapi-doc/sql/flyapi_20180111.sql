/*
 Navicat Premium Data Transfer

 Source Server         : docker-mysql
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : flyapi

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 01/11/2018 21:45:21 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `cms_article`
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `article_id` bigint(20) unsigned NOT NULL COMMENT '文章id',
  `subject_id` bigint(20) NOT NULL COMMENT '专题id',
  `user_id` bigint(20) NOT NULL,
  `title` varchar(20) NOT NULL COMMENT '标题',
  `article_des` varchar(150) NOT NULL COMMENT '摘要',
  `cover` varchar(255) DEFAULT NULL COMMENT '封面',
  `md_content` text NOT NULL COMMENT 'md内容',
  `html_content` text NOT NULL COMMENT 'html内容',
  `original` varchar(100) DEFAULT NULL COMMENT '原文链接',
  `view_num` int(11) NOT NULL DEFAULT '0' COMMENT '阅读数',
  `comment_num` int(11) NOT NULL DEFAULT '0' COMMENT '评论数',
  `like_num` int(11) NOT NULL DEFAULT '0' COMMENT '喜欢数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `permissions` tinyint(4) NOT NULL DEFAULT '0' COMMENT '权限0公开1私有',
  `status` tinyint(4) DEFAULT '1' COMMENT '0草稿1发布',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0显示1删除',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- ----------------------------
--  Table structure for `cms_book`
-- ----------------------------
DROP TABLE IF EXISTS `cms_book`;
CREATE TABLE `cms_book` (
  `book_id` bigint(20) unsigned NOT NULL COMMENT '图书id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `book_name` varchar(20) NOT NULL COMMENT '书名',
  `book_price` decimal(10,2) NOT NULL COMMENT '价格',
  `book_cover` varchar(255) NOT NULL DEFAULT '/images/book/default.png' COMMENT '书籍封面',
  `postage` decimal(5,2) NOT NULL DEFAULT '0.00' COMMENT '邮费',
  `address` varchar(20) DEFAULT NULL COMMENT '地址',
  `category` varchar(10) DEFAULT NULL COMMENT '分类',
  `contact` varchar(50) NOT NULL COMMENT '联系方式',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0出售1已售',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图书表';

-- ----------------------------
--  Table structure for `cms_collect_article`
-- ----------------------------
DROP TABLE IF EXISTS `cms_collect_article`;
CREATE TABLE `cms_collect_article` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `article_id` bigint(20) NOT NULL COMMENT '文章id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0收藏1取消',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章收藏表';

-- ----------------------------
--  Table structure for `cms_comment`
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment` (
  `comment_id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `target_id` bigint(20) NOT NULL COMMENT '文章,漫等画,pk榜id',
  `author_id` bigint(20) NOT NULL COMMENT '作者id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `like_num` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `target_type` tinyint(4) NOT NULL COMMENT '1文章2漫画3pk榜等',
  `is_read` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0未读 1已读',
  `create_time` datetime NOT NULL COMMENT '发表时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0显示1删除',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
--  Table structure for `cms_homepage_apply`
-- ----------------------------
DROP TABLE IF EXISTS `cms_homepage_apply`;
CREATE TABLE `cms_homepage_apply` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `article_id` bigint(20) NOT NULL COMMENT '文章id',
  `apply_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0申请中1通过2未通过',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0显示1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='cms_homepage_apply';

-- ----------------------------
--  Table structure for `cms_like`
-- ----------------------------
DROP TABLE IF EXISTS `cms_like`;
CREATE TABLE `cms_like` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户表',
  `target_id` bigint(20) NOT NULL COMMENT '目标id',
  `target_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1文章2漫画3pk榜',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0点赞1取消',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点赞表';

-- ----------------------------
--  Table structure for `cms_pk`
-- ----------------------------
DROP TABLE IF EXISTS `cms_pk`;
CREATE TABLE `cms_pk` (
  `pk_id` bigint(20) NOT NULL COMMENT 'id',
  `pk_title` varchar(50) NOT NULL COMMENT '题目',
  `pk_des` varchar(50) DEFAULT NULL COMMENT '描述',
  `agree_num` int(11) NOT NULL DEFAULT '0' COMMENT '正方',
  `disagree_num` int(11) NOT NULL DEFAULT '0' COMMENT '反方',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1删除',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='PK榜';

-- ----------------------------
--  Table structure for `cms_reply`
-- ----------------------------
DROP TABLE IF EXISTS `cms_reply`;
CREATE TABLE `cms_reply` (
  `reply_id` bigint(20) NOT NULL COMMENT '回复id',
  `comment_id` bigint(20) NOT NULL COMMENT '评论id',
  `re_reply_id` bigint(20) DEFAULT '0' COMMENT '回复某人的回复',
  `content` varchar(255) NOT NULL COMMENT '回复内容',
  `from_user_id` bigint(20) NOT NULL COMMENT '回复人',
  `to_user_id` bigint(20) DEFAULT NULL COMMENT '被回复人',
  `reply_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0回复评论1回复回复',
  `create_time` datetime DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='回复表';

-- ----------------------------
--  Table structure for `cms_rss`
-- ----------------------------
DROP TABLE IF EXISTS `cms_rss`;
CREATE TABLE `cms_rss` (
  `id` int(11) NOT NULL COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '订阅者',
  `subject_id` int(11) NOT NULL COMMENT '专题id',
  `create_time` datetime NOT NULL COMMENT '订阅时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0订阅1取消',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='专题订阅表';

-- ----------------------------
--  Table structure for `cms_subject`
-- ----------------------------
DROP TABLE IF EXISTS `cms_subject`;
CREATE TABLE `cms_subject` (
  `subject_id` bigint(20) unsigned NOT NULL COMMENT '专题id',
  `user_id` bigint(20) NOT NULL,
  `cover` varchar(255) NOT NULL DEFAULT 'default.png' COMMENT '封面',
  `subject_title` varchar(20) NOT NULL COMMENT '专题标题',
  `subject_des` varchar(50) NOT NULL COMMENT '描述',
  `permissions` tinyint(4) NOT NULL DEFAULT '0' COMMENT '权限0公开1私有',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0显示1删除',
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='专题表';

-- ----------------------------
--  Table structure for `cms_type_log`
-- ----------------------------
DROP TABLE IF EXISTS `cms_type_log`;
CREATE TABLE `cms_type_log` (
  `type_id` int(11) NOT NULL COMMENT '记录id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `score` int(11) NOT NULL COMMENT '分数',
  `acc` decimal(2,0) NOT NULL COMMENT '准确率',
  `wpm` int(11) NOT NULL COMMENT '单词数/分钟',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='打字记录';

-- ----------------------------
--  Table structure for `open_source`
-- ----------------------------
DROP TABLE IF EXISTS `open_source`;
CREATE TABLE `open_source` (
  `os_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `os_name` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `os_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1.github 2.oschina',
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`os_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `setting_carousel`
-- ----------------------------
DROP TABLE IF EXISTS `setting_carousel`;
CREATE TABLE `setting_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `img_url` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `detail_url` varchar(255) DEFAULT NULL COMMENT '详情页',
  `sort` tinyint(4) DEFAULT '100' COMMENT '排序',
  `create_time` datetime DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='轮播图表';

-- ----------------------------
--  Table structure for `setting_store`
-- ----------------------------
DROP TABLE IF EXISTS `setting_store`;
CREATE TABLE `setting_store` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `ak` varchar(255) DEFAULT '',
  `sk` varchar(255) DEFAULT '',
  `bucket` varchar(255) DEFAULT '',
  `domain` varchar(255) DEFAULT '' COMMENT '外链域名',
  `vip` tinyint(4) DEFAULT '0' COMMENT '0未,1级',
  `store_type` varchar(20) DEFAULT '七牛' COMMENT '云存储平台',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='图片存储设置表';

-- ----------------------------
--  Table structure for `sys_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `sys_feedback`;
CREATE TABLE `sys_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户反馈表';

-- ----------------------------
--  Table structure for `sys_info`
-- ----------------------------
DROP TABLE IF EXISTS `sys_info`;
CREATE TABLE `sys_info` (
  `info_id` bigint(20) NOT NULL COMMENT 'info_id',
  `part_name` varchar(20) NOT NULL COMMENT '模块名',
  `part_content` varchar(255) NOT NULL COMMENT '内容',
  `language` varchar(2) NOT NULL COMMENT '语言',
  `click_num` int(11) NOT NULL DEFAULT '0' COMMENT '点击数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1删除',
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统信息';

-- ----------------------------
--  Table structure for `sys_notice`
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `notice_id` bigint(20) NOT NULL,
  `notice_content` text NOT NULL,
  `notice_title` varchar(255) NOT NULL,
  `notice_type` tinyint(4) NOT NULL COMMENT '0全员 1单独',
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `sys_report`
-- ----------------------------
DROP TABLE IF EXISTS `sys_report`;
CREATE TABLE `sys_report` (
  `report_id` bigint(20) NOT NULL,
  `target_id` bigint(20) NOT NULL,
  `report_type` tinyint(4) NOT NULL COMMENT '1 文章',
  `report_reason` tinyint(4) NOT NULL COMMENT '举报类型 1 抄袭侵权  2 含色情词汇 3 政治倾向  4 偏激言辞',
  `remarks` varchar(255) NOT NULL COMMENT '备注',
  `reporter_ip` varchar(11) NOT NULL COMMENT '举报人ip',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Table structure for `ucenter_fame`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_fame`;
CREATE TABLE `ucenter_fame` (
  `fame_id` bigint(20) NOT NULL COMMENT '声望id',
  `start_value` int(11) NOT NULL COMMENT '起始值',
  `end_value` int(11) NOT NULL COMMENT '结束值',
  `fame_name` varchar(10) NOT NULL COMMENT '声望名称',
  `fame_icon` varchar(255) NOT NULL COMMENT '声望icon',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0否1是',
  PRIMARY KEY (`fame_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='声望表';

-- ----------------------------
--  Table structure for `ucenter_log`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_log`;
CREATE TABLE `ucenter_log` (
  `log_id` bigint(20) NOT NULL COMMENT '日志id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `spend_time` int(11) NOT NULL COMMENT '花费时间',
  `base_path` varchar(100) NOT NULL COMMENT '基础路径',
  `uri` varchar(155) NOT NULL COMMENT '扩展路径',
  `url` varchar(255) NOT NULL COMMENT '全路径',
  `method` varchar(10) NOT NULL COMMENT '请求方式',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `ip` varchar(15) NOT NULL COMMENT 'ip',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日志表';

-- ----------------------------
--  Table structure for `ucenter_user`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user`;
CREATE TABLE `ucenter_user` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nick_name` varchar(10) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT '/res/images/avatar/flyhero.jpg' COMMENT '头像地址',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0未知1男2女',
  `sign` varchar(100) DEFAULT NULL COMMENT '个性签名',
  `company` varchar(50) DEFAULT NULL COMMENT '公司',
  `country` varchar(20) DEFAULT NULL COMMENT '国家',
  `area` varchar(10) DEFAULT NULL COMMENT '地区',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `platform` varchar(10) DEFAULT 'PC' COMMENT '注册来源',
  `fame_value` int(11) NOT NULL DEFAULT '0' COMMENT '声望值',
  `support_word` varchar(255) DEFAULT NULL,
  `support_qrcode` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1注销',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
--  Table structure for `ucenter_user_auth`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_auth`;
CREATE TABLE `ucenter_user_auth` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `oauth_id` varchar(50) NOT NULL COMMENT '认证方式编号',
  `open_id` varchar(50) NOT NULL COMMENT '第三方id',
  `oauth_type` varchar(10) NOT NULL COMMENT 'weixin,github等',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '绑定状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='第三方登录表';

-- ----------------------------
--  Table structure for `ucenter_user_fame`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_fame`;
CREATE TABLE `ucenter_user_fame` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `score` int(11) NOT NULL COMMENT '增加的分',
  `op_type` int(11) NOT NULL COMMENT '操作类型1登录2发布3评论4阅读',
  `op_desc` varchar(100) DEFAULT NULL COMMENT '操作描述',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='声望值记录表';

-- ----------------------------
--  Table structure for `ucenter_user_relation`
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_relation`;
CREATE TABLE `ucenter_user_relation` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键id',
  `from_user_id` bigint(20) NOT NULL COMMENT '来自id',
  `to_user_id` bigint(20) NOT NULL COMMENT '对应id',
  `rel_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1粉丝关注2拉黑等',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL COMMENT '0正常1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户关系表';

-- ----------------------------
--  Table structure for `upms_admin`
-- ----------------------------
DROP TABLE IF EXISTS `upms_admin`;
CREATE TABLE `upms_admin` (
  `admin_id` bigint(20) NOT NULL COMMENT '管理员id',
  `admin` varchar(10) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `realname` varchar(10) NOT NULL COMMENT '真实姓名',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `email` varchar(50) NOT NULL COMMENT 'email',
  `avatar` varchar(255) NOT NULL COMMENT '头像',
  `sex` tinyint(4) NOT NULL COMMENT '性别',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

-- ----------------------------
--  Table structure for `upms_admin_role`
-- ----------------------------
DROP TABLE IF EXISTS `upms_admin_role`;
CREATE TABLE `upms_admin_role` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `admin_id` bigint(20) NOT NULL COMMENT '管理员id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员角色表';

-- ----------------------------
--  Table structure for `upms_permission`
-- ----------------------------
DROP TABLE IF EXISTS `upms_permission`;
CREATE TABLE `upms_permission` (
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `description` varchar(20) NOT NULL COMMENT '描述',
  `url` varchar(255) NOT NULL COMMENT '地址',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1主菜单 2子菜单 3及以下按钮',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父id',
  `icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1禁止',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- ----------------------------
--  Table structure for `upms_role`
-- ----------------------------
DROP TABLE IF EXISTS `upms_role`;
CREATE TABLE `upms_role` (
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `role_name` varchar(10) NOT NULL COMMENT '角色名',
  `role_des` varchar(20) NOT NULL COMMENT '角色描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1删除',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
--  Table structure for `upms_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `upms_role_permission`;
CREATE TABLE `upms_role_permission` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';

SET FOREIGN_KEY_CHECKS = 1;
