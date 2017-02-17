/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.22
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : flyapi_v2.2

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2016-12-29 18:00:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fly_comments
-- ----------------------------
DROP TABLE IF EXISTS `fly_comments`;
CREATE TABLE `fly_comments` (
  `comment_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '评论人',
  `content` varchar(255) NOT NULL COMMENT '评论内容',
  `interface_id` int(11) DEFAULT '0' COMMENT '接口id',
  `target_id` int(11) DEFAULT NULL COMMENT '被回复人id',
  `create_time` datetime NOT NULL,
  `is_delete` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_comments
-- ----------------------------

-- ----------------------------
-- Table structure for fly_data_base
-- ----------------------------
DROP TABLE IF EXISTS `fly_data_base`;
CREATE TABLE `fly_data_base` (
  `db_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `db_url` varchar(100) NOT NULL,
  `db_name` varchar(50) NOT NULL,
  `db_root` varchar(10) NOT NULL,
  `db_password` varchar(20) NOT NULL,
  `db_driver` varchar(50) NOT NULL,
  `update_way` int(11) DEFAULT NULL COMMENT '1.每天2.每周3.每月4.不更新',
  `update_day` int(2) DEFAULT NULL COMMENT '每月中的几号',
  `update_week` varchar(10) DEFAULT NULL COMMENT '每周中的周几',
  `update_hour` varchar(10) DEFAULT NULL COMMENT '具体的时分秒',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `task_status` int(2) NOT NULL DEFAULT '0' COMMENT '0关闭1进行中2开启',
  `is_delete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_data_base
-- ----------------------------
INSERT INTO `fly_data_base` VALUES ('1', '2', 'jdbc:mysql://localhost:3306', 'flyapi_v2.0', 'admin', '123456', 'com.mysql.jdbc.Driver', '2', '1', 'MON', '11:05', '2016-11-28 11:14:14', '2016-11-28 13:10:43', '0', '0');
INSERT INTO `fly_data_base` VALUES ('2', '2', 'jdbc:mysql://localhost:3306', 'flyapi_v2.0', 'admin', '123456', 'oracle.jdbc.driver.OracleDriver', '2', '1', 'TUES', '13:10', '2016-11-28 11:16:43', '2016-11-28 13:10:39', '0', '0');

-- ----------------------------
-- Table structure for fly_flyapi_version
-- ----------------------------
DROP TABLE IF EXISTS `fly_flyapi_version`;
CREATE TABLE `fly_flyapi_version` (
  `version_id` int(11) NOT NULL AUTO_INCREMENT,
  `version_num` varchar(255) NOT NULL,
  `version_des` tinytext NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`version_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_flyapi_version
-- ----------------------------
INSERT INTO `fly_flyapi_version` VALUES ('1', 'V1.0', '基本功能', '2016-12-19 13:33:40', null, '0');

-- ----------------------------
-- Table structure for fly_interfaces
-- ----------------------------
DROP TABLE IF EXISTS `fly_interfaces`;
CREATE TABLE `fly_interfaces` (
  `interface_id` int(11) NOT NULL AUTO_INCREMENT,
  `inter_name` varchar(50) NOT NULL DEFAULT '' COMMENT '接口名称',
  `inter_des` varchar(255) DEFAULT '' COMMENT '接口描述',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '0可用1废弃',
  `inter_url` varchar(255) NOT NULL DEFAULT '' COMMENT '接口地址',
  `method` varchar(10) NOT NULL DEFAULT '' COMMENT '请求方式',
  `param` text COMMENT '请求参数',
  `request_exam` text COMMENT '请求示例',
  `response_param` text COMMENT '返回参数说明',
  `true_exam` text COMMENT '返回成功示例',
  `false_exam` text COMMENT '返回失败示例',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `module_id` int(11) DEFAULT NULL,
  `creator` int(11) NOT NULL COMMENT '创建者',
  `content` text,
  `is_delete` int(1) NOT NULL DEFAULT '0' COMMENT '0显示1不显示',
  PRIMARY KEY (`interface_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_interfaces
-- ----------------------------
INSERT INTO `fly_interfaces` VALUES ('1', '获取我的项目', '测试一下', '0', 'http://192.168.1.217:8080/flyapi/project/findUserProject.do', 'POST', '[{\"name\":\"userId\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"用户id\",\"state\":true}]', '{\"userId\":1}', '{\"description\":\"大学生发布的讲座\",\"projectId\":1,\"projectName\":\"讲座来了\",\"projectVersion\":\"V1.0\"}', '{\"msg\":\"ok\",\"result\":{\"currentPage\":1,\"currentResult\":0}}', '{\"msg\":\"error\",\"status\":200,\"data\":\"\",}', '2016-11-16 10:26:13', '2016-12-28 17:31:13', '1', '2', null, '0');
INSERT INTO `fly_interfaces` VALUES ('2', '接口2', '测试', '0', 'http://192.168.1.217:8080/flyapi/project/findUserProject.do', 'GET', '[{\"name\":\"userId\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"用户id\",\"state\":true}]', '{\n   \"userId\":1\n}', '{\n	\"description\":\"大学生发布的讲座\",\n	\"projectId\":1,\n	\"projectName\":\"讲座来了\",\n	\"projectVersion\":\"V1.0\"\n}', '{\n	\"msg\":\"ok\",\n	\"status\":200,\n	\"data\":\"\",\n}', '{\n	\"msg\":\"error\",\n	\"status\":200,\n	\"data\":\"\",\n}', '2016-11-18 15:40:35', '2016-11-18 15:41:01', '1', '2', null, '0');
INSERT INTO `fly_interfaces` VALUES ('3', '景点推荐', '推荐一些新的好的景点', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"userId\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"用户编号\",\"state\":true}]', '{\n    “userId”：1\n}', '{\n	\"description\":\"大学生发布的讲座\",\n	\"projectId\":1,\n	\"projectName\":\"讲座来了\",\n	\"projectVersion\":\"V1.0\"\n}', '{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}', '{\n	\"msg\":\"error\",\n	\"status\":404,\n	\"data\":\"\",\n}', '2016-11-21 12:56:43', '2016-11-24 15:08:22', '2', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('4', '推荐景点', '这是对用户推荐的景点', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '2016-11-21 13:02:48', '2016-11-24 15:08:17', '2', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('5', '推荐经景点', '这是为用户推荐的景点', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '', '{\n    \"id\":1\n}', '2016-11-21 13:06:04', '2016-11-24 15:08:20', '2', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('6', '景点推荐', '这是对用户推荐景点', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '{\n    \"id\":1\n}', '2016-11-21 13:10:37', '2016-11-24 15:08:14', '1', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('7', 'qweqweqw', 'eweferfgsf', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"描述\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\n    \"\"id\":1\n}', '{\n    \"\"id\":1\n}', '{\n    \"\"id\":1\n}', '{\n    \"\"id\":1\n}', '2016-11-21 13:18:27', '2016-11-24 15:08:10', '2', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('8', '撒旦法撒旦', '撒旦法是', '0', '是发达啊', 'POST', '[{\"name\":\"描述\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '烦死哒', '我师傅说', '撒旦法撒旦', '是打发十大', '2016-11-22 10:34:02', '2016-11-24 15:08:05', '1', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('9', '十多个第三方', '阿斯顿发生的', '0', '撒打发士大夫撒的', 'POST', '[{\"name\":\"描述\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '多个', '第三方十大', '沙发是', '是打发是', '2016-11-22 10:36:52', '2016-11-24 15:08:03', '1', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('10', '士大夫撒旦法', '是打发是', '0', '是对方发送', 'POST', '[{\"name\":\"描述\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '是打发', '是短发是', '是打发', '是发达', '2016-11-22 10:37:52', '2016-11-24 15:08:01', '1', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('11', '的方式告诉对方', '东方广东省', '0', '对方告诉对方', 'POST', '[{\"name\":\"描述\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '撒旦法', '沙发', '撒旦法', '撒旦法', '2016-11-22 10:39:38', '2016-11-24 15:06:52', '1', '2', '# 支撑起整个互联网时代的 7 款开源软件\r\n\r\n[TOCM]\r\n\r\n[TOC]\r\n\r\n开源软件现在成为整个互联网时代的支撑技术，你可能已经无法离开由开源软件构建起来的网络世界了。下面我们就来看看一些最重要的开源技术。\r\n\r\n### 为互联网而生的操作系统linux\r\n\r\nLinux是一款免费的操作系统，诞生于1991年，用户可以通过网络或其他途径免费获得，并可以任意修改其源代码。\r\n\r\n#### linux A\r\n\r\n它能运行主要的UNIX工具软件、应用程序和网络协议。它支持32位和64位硬件。Linux继承了Unix以网络为核心的设计思想，是一个性能稳 定的多用户网络操作系统。这个系统是由全世界各地的成千上万的程序员设计和实现的。其目的是建立不受任何商品化软件的版权制约的、全世界都能自由使用的 Unix兼容产品。\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n#支撑起整个互联网时代的 7 款开源软件-2\r\n\r\nLinux可以说是已经无处不在，像Android手机就是以Linux为基础开发的，世界上大多的超级计算机也都采用的Linux系统，大多数的 数据中心使用Linux作为其支撑操作系统。谷歌、百度、淘宝等都通过Linuxt提供了我们每天用的互联网服务。Linux在航空控制系统中也扮演着重 要角色。\r\n\r\n###加密互联网的安全协议OpenSSL\r\n\r\nOpenSSL是套开放源代码的软件库包，实现了SSL与TLS协议。OpenSSL可以说是一个基于密码学的安全开发包，囊括了主要的密码算法、常用的密钥和证书封装管理功能以及SSL协议，并提供了丰富的应用程序供测试或其它目的使用。\r\n\r\n也可以说OpenSSL是网络通信提供安全及数据完整性的一种安全协议，SSL可以在Internet上提供秘密性传输，能使用户/服务器应用之间的通信不被攻击者窃听。OpenSSL被网银、在线支付、电商网站、门户网站、电子邮件等重要网站广泛使用。\r\n\r\n去年OpenSSL爆出安全漏洞，因为其应用如此之广，该漏洞爆出让整个互联网都为之震颤。\r\n\r\n### 互联网的记忆——MySQL\r\n\r\nMySQL是一个开源的小型的数据库管理系统，原开发者为瑞典的MySQL AB公司，该公司于2008年被Sun公司收购。2009年，甲骨文公司（Oracle）收购Sun公司，MySQL成为Oracle旗下产品。\r\n\r\n很多信息都是存在数据库里面的，很多工程师在开发一些的小型项目时都会采用这个MySQL数据库。MySQL为C、C++、JAVA、PHP等多重 编程语言提供了API接口。而且支持windows、Mac、Linux等多种系统。这种广泛的支持使其得到更多开发者的青睐，MySQL是开发者需要掌 握的数据库之一。\r\n\r\nMysql最初为小型应用而开发，但现在的Mysql已经不是一个小型数据库了。基本上所有的互联网公司都会使用这个数据库系统，一些金融交易也会 采用Mysql作为数据库引擎。Mysql通过相应的调优既可以支撑大规模的访问，又可以保证数据安全性，已经成为威胁传统商业数据库系统的重要力量。\r\n\r\n### 万能开发工具Eclipse\r\n\r\nEclipse 是一个开放源代码的、基于Java的可扩展开发平台。Eclipse最初由OTI和IBM两家公司的IDE产品开发组创建，起始于1999年4月。目前由 IBM牵头，围绕着Eclipse项目已经发展成为了一个庞大的Eclipse联盟，有150多家软件公司参与到Eclipse项目中，其中包括 Borland、Rational Software、Red Hat及Sybase等。\r\n\r\n就其本身而言，它只是一个框架和一组服务，用于通过插件组件构建开发环境。很多Java编程软件都是在Eclipse平台开发的，还有包括 Oracle在内的许多大公司也纷纷加入了该项目，并宣称Eclipse将来能成为可进行任何语言开发的IDE集大成者，使用者只需下载各种语言的插件即 可。\r\n\r\nEclipse并不是一个直接服务于消费者的产品，它更像一个工匠手中万用工具，用Eclipse开发者可以打造出各种充满创造性的服务来满足最终用户的需求。\r\n\r\n### 互联网的门卫Apache\r\n\r\nApache HTTP Server（简称Apache）是Apache软件基金会的一个开放源码的网页服务器，可以在大多数计算机操作系统中运行，由于其多平台和安全性被广泛 使用，也是最流行的Web服务器端软件之一，市场占有率达60%左右。它快速、可靠并且可通过简单的API扩展，它可以和各种解释器配合使用，包括 PHP/Perl/Python等。\r\n\r\nApache就像一个负责的门卫，管理着服务器数据的进出。每当你在你的地址栏里输入 http://XXX.com 的时候，在遥远的远端，很有可能正是一台跑着Apache的服务器，将你需要的信息传输给浏览器。\r\n\r\n###大数据的心脏Hadoop\r\n\r\nHadoop 是一个能够对大量数据进行分布式处理的软件框架，由Apache基金会开发。用户可以在不了解分布式底层细节的情况下，开发分布式程序。Hadoop 一 直帮助解决各种问题，包括超大型数据集的排序和大文件的搜索。它还是各种搜索引擎的核心，比如 Amazon 的 A9 和用于查找酒信息 的 Able Grape 垂直搜索引擎。阿里巴巴集团在商品推荐、用户行为分析、信用计算领域也都有hadoop的应用。\r\n\r\n在“大数据”已经成为潮流的当下，Hadoop已经成为最主要的一项技术。可以毫不夸张的说，没有Hadoop，就没有大多数的大数据应用。可以说对一个不知道Hadoop的程序员而言，你已经out了。\r\n\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n#### Test link heading [linux B](https://github.com/pandao/editor.md)   Test link heading [linux B](https://github.com/pandao/editor.md)  Test link heading, Test link heading, [linux B](https://github.com/pandao/editor.md)  Test link heading\r\n\r\n##### linux B-1\r\n\r\n###### linux B-1-1\r\n\r\n###### linux B-1-2\r\n\r\n##### linux B-2\r\n\r\n###### linux B-2-1\r\n\r\n###### linux B-2-2\r\n\r\n### 互联网的“排版引擎”WebKit\r\n\r\n说是浏览器内核，其实“排版引擎”更容易理解一些。通过服务器传输给浏览器的信息只是一串乱糟糟的文本。要看到我们平时看到精美的网友，需要浏览器内核对这些文本进行解析，将枯燥的描述“画”成美丽的浏览界面。\r\n\r\nWebKit 是一个开源的浏览器引擎，与之相应的引擎有 Gecko（Mozilla Firefox 等使用的排版引擎）和 Trident（也称为 MSHTML，IE 使用的排版引擎）。根据 StatCounter 的浏览器市场份额调查，于2012年11月，Webkit 市占超过了 40%，它已经成为拥有最大市场份额的 排版引擎，超越了 Internet Explorer 所使用的Trident 及 Firefox 所使用的 Gecko 引擎，并且 WebKit 份额正在逐年增加。\r\n\r\n目前几乎所有网站和网银已经逐渐支持 WebKit 。WebKit 内核在手机上的应用也十分广泛，例如苹果的 Safari 、谷歌的 Chrome 浏览器都是基于这个框架来开发的。\r\n\r\n### 小结\r\n\r\n很多人可能尚未意识到，我们使用的电脑中运行有开源软件，手机中运行有开源软件，家里的电视也运行有开源软件，甚至小小的数码产品中也运行有开源软件，尤其是互联网服务器端软件，几乎全部是开源软件。毫不夸张地说，开源软件已经渗透到了我们日常生活的方方面面。\r\n\r\n稿源：[钛媒体](http://www.tmtpost.com/194306.html)\r\n', '0');
INSERT INTO `fly_interfaces` VALUES ('12', '排行榜', '对用户积分进行排行', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"userId\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\n	\"msg\":\"error\",\n	\"status\":404,\n	\"data\":\"\",\n}', '{\n	\"msg\":\"error\",\n	\"status\":404,\n	\"data\":\"\",\n}', '{\n	\"msg\":\"error\",\n	\"status\":404,\n	\"data\":\"\",\n}', '{\n	\"msg\":\"error\",\n	\"status\":404,\n	\"data\":\"\",\n}', '2016-11-22 11:23:11', null, '1', '2', '<h1 id=\"h1-u6392u884Cu699C\"><a name=\"排行榜\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>排行榜</h1><p>[TOCM]<br>[TOC]</p>\n<h2 id=\"h2-u529Fu80FDu8BF4u660E\"><a name=\"功能说明\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>功能说明</h2><h3 id=\"h3-u63A5u53E3u540Du79F0\"><a name=\"接口名称\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>接口名称</h3><p>排行榜</p>\n<h3 id=\"h3-u63A5u53E3u63CFu8FF0\"><a name=\"接口描述\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>接口描述</h3><p>对用户积分进行排行</p>\n<h3 id=\"h3-u63A5u53E3u72B6u6001\"><a name=\"接口状态\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>接口状态</h3><p>可用</p>\n<h2 id=\"h2-u8C03u7528u8BF4u660E\"><a name=\"调用说明\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>调用说明</h2><h3 id=\"h3-u8C03u7528u5730u5740\"><a name=\"调用地址\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>调用地址</h3><p><a href=\"http://localhost:8080/flyapi/forward/new_interfaces.html\">http://localhost:8080/flyapi/forward/new_interfaces.html</a></p>\n<h3 id=\"h3-u8BF7u6C42u65B9u5F0F\"><a name=\"请求方式\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>请求方式</h3><p>POST</p>\n<h3 id=\"h3-u8BF7u6C42u53C2u6570\"><a name=\"请求参数\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>请求参数</h3><table>\n<thead>\n<tr>\n<th>名称</th>\n<th>是否必须</th>\n<th>类型</th>\n<th>说明</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td>userId</td>\n<td>undefined</td>\n<td>int</td>\n<td>描述</td>\n</tr>\n</tbody>\n</table>\n', '0');
INSERT INTO `fly_interfaces` VALUES ('13', '核心涂料', '获取公司主要的涂料', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\n   \"id\":2\n}', 'msg是成功或失败\nstatus是状态码\ndata存放数据', '{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\"\n}', '{\n	\"msg\":\"error\",\n	\"status\":404,\n	\"data\":\"\",\n}', '2016-11-24 15:18:01', '2016-12-02 17:39:42', '3', '2', '#核心涂料\r\n\n[TOCM]\n\n[TOC]\r\n\n###功能说明\n####接口名称\n核心涂料\n####接口描述\n获取公司主要的涂料\n####接口状态\n可用\n###调用说明\n####调用地址\nhttp://localhost:8080/flyapi/forward/new_interfaces.html\n####请求方式 \nPOST\n####请求参数\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n  |id|undefined|int|描述|\n\n####请求示例\r\n```\n{\"id\":2\n}\r\n```\n####返回参数说明\n    msg是成功或失败\n    status是状态码\n    data存放数据\n####成功示例\n{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}\n####失败示例\r\n	{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '0');
INSERT INTO `fly_interfaces` VALUES ('14', '获取售价', '获取指定涂料的售价', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\"id\":3}', 'msg是成功或失败\n    status是状态码\n    data存放数据', '{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}', '{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '2016-11-24 15:29:20', null, '3', '2', '#获取售价\n[TOCM]\n\n[TOC]\n###功能说明\n####接口名称\n获取售价\n####接口描述\n获取指定涂料的售价\n####接口状态\n可用\n###调用说明\n####调用地址\nhttp://localhost:8080/flyapi/forward/new_interfaces.html\n####请求方式 \nPOST\n####请求参数\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n  |id|true|int|描述|\n\n####请求示例\n\"{\\\"id\\\":3}\"\n####返回参数说明\n    msg是成功或失败\n    status是状态码\n    data存放数据\n####成功示例\n{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}\n####失败示例	{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '0');
INSERT INTO `fly_interfaces` VALUES ('15', '订单支付', '用户购买涂料后支付', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\"id\":3}', 'msg是成功或失败\n    status是状态码\n    data存放数据', '{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}', '{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '2016-11-24 15:34:43', null, '3', '2', '#订单支付\n[TOCM]\n\n[TOC]\n###功能说明\n####接口名称\n订单支付\n####接口描述\n用户购买涂料后支付\n####接口状态\n可用\n###调用说明\n####调用地址\nhttp://localhost:8080/flyapi/forward/new_interfaces.html\n####请求方式 \nPOST\n####请求参数\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n  |id|true|int|描述|\n\n####请求示例\n\"{\\\"id\\\":3}\"\n####返回参数说明\n    msg是成功或失败\n    status是状态码\n    data存放数据\n####成功示例\n{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}\n####失败示例{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '0');
INSERT INTO `fly_interfaces` VALUES ('16', '新建项目', '这是我的接口描述', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\"id\":4}', 'msg是成功或失败\n    status是状态码\n    data存放数据', '{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}', '{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '2016-11-24 15:41:10', null, '3', '2', '#新建项目\n[TOCM]\n\n[TOC]\n###功能说明\n####接口名称\n新建项目\n####接口描述\n这是我的接口描述\n####接口状态\n可用\n###调用说明\n####调用地址\nhttp://localhost:8080/flyapi/forward/new_interfaces.html\n####请求方式 \nPOST\n####请求参数\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n  |id|true|int|描述|\n\n####请求示例\n\"{\\\"id\\\":4}\"\n####返回参数说明\n    msg是成功或失败\n    status是状态码\n    data存放数据\n####成功示例\n{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}\n####失败示例{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '0');
INSERT INTO `fly_interfaces` VALUES ('17', '获取日志', '操作的日志详情', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '\"{\\\"id\\\":5}\"', 'msg是成功或失败\n    status是状态码\n    data存放数据', '{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}', '{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '2016-11-24 15:47:14', null, '3', '2', '#获取日志\n[TOCM]\n\n[TOC]\n###功能说明\n####接口名称\n获取日志\n####接口描述\n操作的日志详情\n####接口状态\n可用\n###调用说明\n####调用地址\nhttp://localhost:8080/flyapi/forward/new_interfaces.html\n####请求方式 \nPOST\n####请求参数\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n  |id|true|int|描述|\n\n####请求示例\n\"{\\\"id\\\":5}\"\n####返回参数说明\n    msg是成功或失败\n    status是状态码\n    data存放数据\n####成功示例\n{\n	\"msg\":\"success\",\n	\"status\":200,\n	\"data\":\"\",\n}\n####失败示例{\n		\"msg\":\"error\",\n		\"status\":404,\n		\"data\":\"\",\n	}', '0');
INSERT INTO `fly_interfaces` VALUES ('18', '今日登陆人数', '用户数据统计', '0', 'http://localhost:8080/flyapi/forward/new_interfaces.html', 'POST', '[{\"name\":\"id\",\"isTrue\":\"true\",\"interType\":\"int\",\"des\":\"描述\",\"state\":true}]', '{\"id\":8}', '{\"id\":8}', '{\"id\":8}', '{\"id\":8}', '2016-11-24 16:23:22', '2016-11-24 16:27:48', '3', '2', '#今日登陆人数\n[TOCM]\n\n[TOC]\n###功能说明\n####接口名称\n今日登陆人数\n####接口描述\n用户数据统计\n#### **接口状态**\n可用\n###调用说明\n####调用地址\nhttp://localhost:8080/flyapi/forward/new_interfaces.html\n####请求方式 \nPOST\n####请求参数\n | 名称   | 是否必须   |  类型  |说明 | \n | ---------- | --------- | --------- | --------- |\n  |id|true|int|描述|\n\n####请求示例\n{\n    \"id\": 8\n}\n####返回参数说明\n{\"id\":8}\n####成功示例\n{\n    \"id\": 8\n}\n####失败示例{\n    \"id\": 8\n}', '0');

-- ----------------------------
-- Table structure for fly_module
-- ----------------------------
DROP TABLE IF EXISTS `fly_module`;
CREATE TABLE `fly_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(50) NOT NULL COMMENT '模块名称',
  `module_des` varchar(255) DEFAULT NULL COMMENT '描述',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_detele` int(2) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_module
-- ----------------------------
INSERT INTO `fly_module` VALUES ('1', '首页', '推荐一些活动的主页', '11', '2016-11-15 13:10:52', null, '0');
INSERT INTO `fly_module` VALUES ('2', '发现', '发现新鲜事物2', '11', '2016-11-16 10:57:23', '2016-12-12 17:47:28', '0');
INSERT INTO `fly_module` VALUES ('3', '测试模块', '这是测试的', '15', '2016-11-22 16:51:54', null, '0');

-- ----------------------------
-- Table structure for fly_operate_log
-- ----------------------------
DROP TABLE IF EXISTS `fly_operate_log`;
CREATE TABLE `fly_operate_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL COMMENT '项目名',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operate_type` varchar(20) NOT NULL COMMENT '操作类型：update,insert,delete,select',
  `model_class` varchar(20) NOT NULL COMMENT '模块：project,module,interface',
  `model_name` varchar(20) DEFAULT NULL COMMENT '模块名：某项目，某模块，某接口',
  `remark` varchar(255) DEFAULT NULL,
  `content` text,
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`log_id`),
  KEY `u_index` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=705 DEFAULT CHARSET=utf8 COMMENT='操作日志表';

-- ----------------------------
-- Records of fly_operate_log
-- ----------------------------
INSERT INTO `fly_operate_log` VALUES ('1', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 13:05:27', '0');
INSERT INTO `fly_operate_log` VALUES ('2', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 13:09:41', '0');
INSERT INTO `fly_operate_log` VALUES ('3', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 13:27:42', '0');
INSERT INTO `fly_operate_log` VALUES ('4', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:16:55', '0');
INSERT INTO `fly_operate_log` VALUES ('5', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:17:27', '0');
INSERT INTO `fly_operate_log` VALUES ('6', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:25:16', '0');
INSERT INTO `fly_operate_log` VALUES ('7', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:31:53', '0');
INSERT INTO `fly_operate_log` VALUES ('8', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:36:37', '0');
INSERT INTO `fly_operate_log` VALUES ('9', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:37:19', '0');
INSERT INTO `fly_operate_log` VALUES ('10', '1', '0', null, 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 14:45:13', '0');
INSERT INTO `fly_operate_log` VALUES ('11', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:20:39', '0');
INSERT INTO `fly_operate_log` VALUES ('12', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:22:02', '0');
INSERT INTO `fly_operate_log` VALUES ('13', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:25:52', '0');
INSERT INTO `fly_operate_log` VALUES ('14', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:31:45', '0');
INSERT INTO `fly_operate_log` VALUES ('15', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:32:17', '0');
INSERT INTO `fly_operate_log` VALUES ('16', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:33:38', '0');
INSERT INTO `fly_operate_log` VALUES ('17', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:56:16', '0');
INSERT INTO `fly_operate_log` VALUES ('18', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 15:57:43', '0');
INSERT INTO `fly_operate_log` VALUES ('19', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:02:23', '0');
INSERT INTO `fly_operate_log` VALUES ('20', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:04:45', '0');
INSERT INTO `fly_operate_log` VALUES ('21', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:06:37', '0');
INSERT INTO `fly_operate_log` VALUES ('22', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:11:44', '0');
INSERT INTO `fly_operate_log` VALUES ('23', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:15:29', '0');
INSERT INTO `fly_operate_log` VALUES ('24', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-09 16:15:39', '0');
INSERT INTO `fly_operate_log` VALUES ('25', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:16:00', '0');
INSERT INTO `fly_operate_log` VALUES ('26', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:17:52', '0');
INSERT INTO `fly_operate_log` VALUES ('27', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:18:45', '0');
INSERT INTO `fly_operate_log` VALUES ('28', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:19:49', '0');
INSERT INTO `fly_operate_log` VALUES ('29', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:20:24', '0');
INSERT INTO `fly_operate_log` VALUES ('30', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:21:23', '0');
INSERT INTO `fly_operate_log` VALUES ('31', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:27:08', '0');
INSERT INTO `fly_operate_log` VALUES ('32', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:30:43', '0');
INSERT INTO `fly_operate_log` VALUES ('33', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:31:25', '0');
INSERT INTO `fly_operate_log` VALUES ('34', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:34:11', '0');
INSERT INTO `fly_operate_log` VALUES ('35', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:38:01', '0');
INSERT INTO `fly_operate_log` VALUES ('36', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:40:13', '0');
INSERT INTO `fly_operate_log` VALUES ('37', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:45:13', '0');
INSERT INTO `fly_operate_log` VALUES ('38', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:45:39', '0');
INSERT INTO `fly_operate_log` VALUES ('39', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 16:48:31', '0');
INSERT INTO `fly_operate_log` VALUES ('40', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 17:00:52', '0');
INSERT INTO `fly_operate_log` VALUES ('41', '1', '1', 'flyhero', 'UPDATE', 'project', '项目', '更新：测试项目项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"这是一个测试数据1\",\"proName\":\"测试项目\",\"projectId\":1,\"targetCount\":100}', '2016-11-09 17:01:00', '0');
INSERT INTO `fly_operate_log` VALUES ('42', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 17:01:02', '0');
INSERT INTO `fly_operate_log` VALUES ('43', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-09 17:05:10', '0');
INSERT INTO `fly_operate_log` VALUES ('44', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-09 18:24:56', '0');
INSERT INTO `fly_operate_log` VALUES ('45', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-09 18:25:07', '0');
INSERT INTO `fly_operate_log` VALUES ('46', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-09 18:35:59', '0');
INSERT INTO `fly_operate_log` VALUES ('47', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-10 09:49:04', '0');
INSERT INTO `fly_operate_log` VALUES ('48', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 09:49:09', '0');
INSERT INTO `fly_operate_log` VALUES ('49', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-10 09:51:25', '0');
INSERT INTO `fly_operate_log` VALUES ('50', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 09:52:40', '0');
INSERT INTO `fly_operate_log` VALUES ('51', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 09:54:52', '0');
INSERT INTO `fly_operate_log` VALUES ('52', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 09:56:03', '0');
INSERT INTO `fly_operate_log` VALUES ('53', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 09:59:47', '0');
INSERT INTO `fly_operate_log` VALUES ('54', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-10 10:42:51', '0');
INSERT INTO `fly_operate_log` VALUES ('55', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 10:42:53', '0');
INSERT INTO `fly_operate_log` VALUES ('56', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":1}', '2016-11-10 11:15:45', '0');
INSERT INTO `fly_operate_log` VALUES ('57', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 11:15:48', '0');
INSERT INTO `fly_operate_log` VALUES ('58', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-10 11:22:53', '0');
INSERT INTO `fly_operate_log` VALUES ('59', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"和上海政府合作的一款旅游app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"targetCount\":150}', '2016-11-10 13:36:45', '0');
INSERT INTO `fly_operate_log` VALUES ('60', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-10 13:41:25', '0');
INSERT INTO `fly_operate_log` VALUES ('61', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"这是一个和政府合作的旅游app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"targetCount\":160}', '2016-11-10 14:10:51', '0');
INSERT INTO `fly_operate_log` VALUES ('62', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"这是一个和政府合作的旅游app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"targetCount\":160}', '2016-11-10 14:12:42', '0');
INSERT INTO `fly_operate_log` VALUES ('63', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"旅游类的app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"targetCount\":140}', '2016-11-10 14:13:31', '0');
INSERT INTO `fly_operate_log` VALUES ('64', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"旅游类的app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"projectId\":7,\"targetCount\":140}', '2016-11-10 14:17:14', '0');
INSERT INTO `fly_operate_log` VALUES ('65', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"旅游类的app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"projectId\":8,\"targetCount\":140}', '2016-11-10 14:20:38', '0');
INSERT INTO `fly_operate_log` VALUES ('66', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"和政府合作旅游类app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"projectId\":10,\"targetCount\":140}', '2016-11-10 14:43:44', '0');
INSERT INTO `fly_operate_log` VALUES ('67', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"和政府合作旅游类app\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"projectId\":9,\"targetCount\":140}', '2016-11-10 14:43:44', '0');
INSERT INTO `fly_operate_log` VALUES ('68', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"按时到敬爱发售\",\"proName\":\"遛遛旅游\",\"proVersion\":\"V1.0\",\"projectId\":11,\"targetCount\":140}', '2016-11-10 14:48:44', '0');
INSERT INTO `fly_operate_log` VALUES ('69', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：企鹅企鹅项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"请问\",\"proName\":\"企鹅企鹅\",\"proVersion\":\"v1.1\",\"projectId\":12,\"targetCount\":112}', '2016-11-10 14:52:11', '0');
INSERT INTO `fly_operate_log` VALUES ('70', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：王企鹅企鹅拳王项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"他如果换地方\",\"proName\":\"王企鹅企鹅拳王\",\"proVersion\":\"V1.0\",\"projectId\":13,\"targetCount\":200}', '2016-11-10 14:54:25', '0');
INSERT INTO `fly_operate_log` VALUES ('71', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：王企鹅企鹅拳王项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"他如果换地方\",\"proName\":\"王企鹅企鹅拳王\",\"proVersion\":\"V1.0\",\"projectId\":14,\"targetCount\":200}', '2016-11-10 14:54:25', '0');
INSERT INTO `fly_operate_log` VALUES ('72', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：是噻短时阿萨德项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"爱的暗示的沃尔夫\",\"proName\":\"是噻短时阿萨德\",\"proVersion\":\"v1.1\",\"projectId\":15,\"targetCount\":400}', '2016-11-10 14:58:19', '0');
INSERT INTO `fly_operate_log` VALUES ('73', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：非官方大哥说项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"阿萨德访问\",\"proName\":\"非官方大哥说\",\"proVersion\":\"V1.0\",\"projectId\":16,\"targetCount\":300}', '2016-11-10 14:59:26', '0');
INSERT INTO `fly_operate_log` VALUES ('74', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-10 15:01:30', '0');
INSERT INTO `fly_operate_log` VALUES ('75', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":2,\"pageSize\":1,\"userId\":2}', '2016-11-10 15:01:38', '0');
INSERT INTO `fly_operate_log` VALUES ('76', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":3,\"pageSize\":1,\"userId\":2}', '2016-11-10 15:01:40', '0');
INSERT INTO `fly_operate_log` VALUES ('77', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-10 15:01:45', '0');
INSERT INTO `fly_operate_log` VALUES ('78', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":1,\"userId\":2}', '2016-11-10 15:02:41', '0');
INSERT INTO `fly_operate_log` VALUES ('79', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:03:31', '0');
INSERT INTO `fly_operate_log` VALUES ('80', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:28', '0');
INSERT INTO `fly_operate_log` VALUES ('81', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:31', '0');
INSERT INTO `fly_operate_log` VALUES ('82', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:36', '0');
INSERT INTO `fly_operate_log` VALUES ('83', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:37', '0');
INSERT INTO `fly_operate_log` VALUES ('84', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:44', '0');
INSERT INTO `fly_operate_log` VALUES ('85', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:50', '0');
INSERT INTO `fly_operate_log` VALUES ('86', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:04:58', '0');
INSERT INTO `fly_operate_log` VALUES ('87', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:10:42', '0');
INSERT INTO `fly_operate_log` VALUES ('88', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:27', '0');
INSERT INTO `fly_operate_log` VALUES ('89', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:34', '0');
INSERT INTO `fly_operate_log` VALUES ('90', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:39', '0');
INSERT INTO `fly_operate_log` VALUES ('91', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:39', '0');
INSERT INTO `fly_operate_log` VALUES ('92', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:41', '0');
INSERT INTO `fly_operate_log` VALUES ('93', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:42', '0');
INSERT INTO `fly_operate_log` VALUES ('94', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:17:49', '0');
INSERT INTO `fly_operate_log` VALUES ('95', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:18:33', '0');
INSERT INTO `fly_operate_log` VALUES ('96', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:18:55', '0');
INSERT INTO `fly_operate_log` VALUES ('97', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:19:01', '0');
INSERT INTO `fly_operate_log` VALUES ('98', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-10 15:20:02', '0');
INSERT INTO `fly_operate_log` VALUES ('99', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-10 15:47:51', '0');
INSERT INTO `fly_operate_log` VALUES ('100', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:50:57', '0');
INSERT INTO `fly_operate_log` VALUES ('101', '2', '15', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":15,\"userId\":2}', '2016-11-10 15:51:02', '0');
INSERT INTO `fly_operate_log` VALUES ('102', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:52:45', '0');
INSERT INTO `fly_operate_log` VALUES ('103', '2', '12', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":12,\"userId\":2}', '2016-11-10 15:52:48', '0');
INSERT INTO `fly_operate_log` VALUES ('104', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-10 15:55:13', '0');
INSERT INTO `fly_operate_log` VALUES ('105', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-10 15:55:15', '0');
INSERT INTO `fly_operate_log` VALUES ('106', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-10 16:00:10', '0');
INSERT INTO `fly_operate_log` VALUES ('107', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-10 16:18:26', '0');
INSERT INTO `fly_operate_log` VALUES ('108', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 10:20:39', '0');
INSERT INTO `fly_operate_log` VALUES ('109', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 10:20:47', '0');
INSERT INTO `fly_operate_log` VALUES ('110', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 11:52:50', '0');
INSERT INTO `fly_operate_log` VALUES ('111', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 11:52:52', '0');
INSERT INTO `fly_operate_log` VALUES ('112', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 12:02:37', '0');
INSERT INTO `fly_operate_log` VALUES ('113', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 12:03:12', '0');
INSERT INTO `fly_operate_log` VALUES ('114', '2', '12', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":12,\"userId\":2}', '2016-11-15 12:03:14', '0');
INSERT INTO `fly_operate_log` VALUES ('115', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 12:12:28', '0');
INSERT INTO `fly_operate_log` VALUES ('116', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 12:12:30', '0');
INSERT INTO `fly_operate_log` VALUES ('117', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 12:15:11', '0');
INSERT INTO `fly_operate_log` VALUES ('118', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 12:15:29', '0');
INSERT INTO `fly_operate_log` VALUES ('119', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 12:15:46', '0');
INSERT INTO `fly_operate_log` VALUES ('120', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 13:09:51', '0');
INSERT INTO `fly_operate_log` VALUES ('121', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 13:09:57', '0');
INSERT INTO `fly_operate_log` VALUES ('122', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 13:11:12', '0');
INSERT INTO `fly_operate_log` VALUES ('123', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 13:14:59', '0');
INSERT INTO `fly_operate_log` VALUES ('124', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 14:40:38', '0');
INSERT INTO `fly_operate_log` VALUES ('125', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:40:40', '0');
INSERT INTO `fly_operate_log` VALUES ('126', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 14:40:48', '0');
INSERT INTO `fly_operate_log` VALUES ('127', '2', '12', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":12,\"userId\":2}', '2016-11-15 14:40:49', '0');
INSERT INTO `fly_operate_log` VALUES ('128', '2', '12', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":12,\"userId\":2}', '2016-11-15 14:42:25', '0');
INSERT INTO `fly_operate_log` VALUES ('129', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 14:44:10', '0');
INSERT INTO `fly_operate_log` VALUES ('130', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:44:14', '0');
INSERT INTO `fly_operate_log` VALUES ('131', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 14:46:25', '0');
INSERT INTO `fly_operate_log` VALUES ('132', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:46:29', '0');
INSERT INTO `fly_operate_log` VALUES ('133', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 14:48:00', '0');
INSERT INTO `fly_operate_log` VALUES ('134', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:48:02', '0');
INSERT INTO `fly_operate_log` VALUES ('135', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:50:09', '0');
INSERT INTO `fly_operate_log` VALUES ('136', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:50:46', '0');
INSERT INTO `fly_operate_log` VALUES ('137', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:51:39', '0');
INSERT INTO `fly_operate_log` VALUES ('138', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:51:58', '0');
INSERT INTO `fly_operate_log` VALUES ('139', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:53:31', '0');
INSERT INTO `fly_operate_log` VALUES ('140', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:56:16', '0');
INSERT INTO `fly_operate_log` VALUES ('141', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:57:03', '0');
INSERT INTO `fly_operate_log` VALUES ('142', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:57:21', '0');
INSERT INTO `fly_operate_log` VALUES ('143', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:57:36', '0');
INSERT INTO `fly_operate_log` VALUES ('144', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 14:58:56', '0');
INSERT INTO `fly_operate_log` VALUES ('145', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 15:00:14', '0');
INSERT INTO `fly_operate_log` VALUES ('146', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 15:03:09', '0');
INSERT INTO `fly_operate_log` VALUES ('147', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 15:04:11', '0');
INSERT INTO `fly_operate_log` VALUES ('148', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 15:28:58', '0');
INSERT INTO `fly_operate_log` VALUES ('149', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 15:32:52', '0');
INSERT INTO `fly_operate_log` VALUES ('150', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 15:33:16', '0');
INSERT INTO `fly_operate_log` VALUES ('151', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 15:35:26', '0');
INSERT INTO `fly_operate_log` VALUES ('152', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 15:37:22', '0');
INSERT INTO `fly_operate_log` VALUES ('153', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 16:16:38', '0');
INSERT INTO `fly_operate_log` VALUES ('154', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-15 16:16:46', '0');
INSERT INTO `fly_operate_log` VALUES ('155', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-15 18:08:45', '0');
INSERT INTO `fly_operate_log` VALUES ('156', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 09:49:16', '0');
INSERT INTO `fly_operate_log` VALUES ('157', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 10:29:31', '0');
INSERT INTO `fly_operate_log` VALUES ('158', '2', '11', 'admin', 'UPDATE', 'project', '项目', '更新：遛遛旅游项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"一个旅游类的app\",\"proName\":\"遛遛旅游\",\"projectId\":11,\"targetCount\":140}', '2016-11-16 10:29:56', '0');
INSERT INTO `fly_operate_log` VALUES ('159', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 10:30:09', '0');
INSERT INTO `fly_operate_log` VALUES ('160', '2', '12', 'admin', 'DELETE', 'project', '项目', '删除：企鹅企鹅项目', '{\"isDelete\":1,\"pageNumber\":1,\"pageSize\":10,\"proName\":\"企鹅企鹅\",\"projectId\":12}', '2016-11-16 10:30:25', '0');
INSERT INTO `fly_operate_log` VALUES ('161', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 10:30:26', '0');
INSERT INTO `fly_operate_log` VALUES ('162', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 10:30:42', '0');
INSERT INTO `fly_operate_log` VALUES ('163', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 10:57:03', '0');
INSERT INTO `fly_operate_log` VALUES ('164', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 10:57:06', '0');
INSERT INTO `fly_operate_log` VALUES ('165', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:25:06', '0');
INSERT INTO `fly_operate_log` VALUES ('166', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:26:13', '0');
INSERT INTO `fly_operate_log` VALUES ('167', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:28:02', '0');
INSERT INTO `fly_operate_log` VALUES ('168', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:28:16', '0');
INSERT INTO `fly_operate_log` VALUES ('169', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:32:33', '0');
INSERT INTO `fly_operate_log` VALUES ('170', '2', '15', 'admin', 'UPDATE', 'project', '项目', '更新：聚心涂料项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"出售涂料的app\",\"proName\":\"聚心涂料\",\"projectId\":15,\"targetCount\":400}', '2016-11-16 11:33:47', '0');
INSERT INTO `fly_operate_log` VALUES ('171', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:33:49', '0');
INSERT INTO `fly_operate_log` VALUES ('172', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:34:35', '0');
INSERT INTO `fly_operate_log` VALUES ('173', '2', '16', 'admin', 'UPDATE', 'project', '项目', '更新：安全审计项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"政府日志审查\",\"proName\":\"安全审计\",\"projectId\":16,\"targetCount\":300}', '2016-11-16 11:35:15', '0');
INSERT INTO `fly_operate_log` VALUES ('174', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:35:15', '0');
INSERT INTO `fly_operate_log` VALUES ('175', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:35:46', '0');
INSERT INTO `fly_operate_log` VALUES ('176', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:38:40', '0');
INSERT INTO `fly_operate_log` VALUES ('177', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:38:42', '0');
INSERT INTO `fly_operate_log` VALUES ('178', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:40:33', '0');
INSERT INTO `fly_operate_log` VALUES ('179', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:41:09', '0');
INSERT INTO `fly_operate_log` VALUES ('180', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:45:53', '0');
INSERT INTO `fly_operate_log` VALUES ('181', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 11:50:23', '0');
INSERT INTO `fly_operate_log` VALUES ('182', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 11:50:32', '0');
INSERT INTO `fly_operate_log` VALUES ('183', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 15:16:28', '0');
INSERT INTO `fly_operate_log` VALUES ('184', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 15:16:54', '0');
INSERT INTO `fly_operate_log` VALUES ('185', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 15:17:05', '0');
INSERT INTO `fly_operate_log` VALUES ('186', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 15:33:13', '0');
INSERT INTO `fly_operate_log` VALUES ('187', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 15:33:51', '0');
INSERT INTO `fly_operate_log` VALUES ('188', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 15:38:32', '0');
INSERT INTO `fly_operate_log` VALUES ('189', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-16 15:49:20', '0');
INSERT INTO `fly_operate_log` VALUES ('190', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-16 16:05:43', '0');
INSERT INTO `fly_operate_log` VALUES ('191', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-18 13:50:09', '0');
INSERT INTO `fly_operate_log` VALUES ('192', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：景点推荐接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n    \\\"id\\\":1\\n}\",\"interDes\":\"这是对用户推荐景点\",\"interName\":\"景点推荐\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":1,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\n    \\\"id\\\":1\\n}\",\"responseParam\":\"{\\n    \\\"id\\\":1\\n}\",\"status\":0,\"trueExam\":\"{\\n    \\\"id\\\":1\\n}\"}', '2016-11-21 13:10:37', '0');
INSERT INTO `fly_operate_log` VALUES ('193', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：qweqweqw接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n    \\\"\\\"id\\\":1\\n}\",\"interDes\":\"eweferfgsf\",\"interName\":\"qweqweqw\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":2,\"param\":\"[{\\\"name\\\":\\\"描述\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\n    \\\"\\\"id\\\":1\\n}\",\"responseParam\":\"{\\n    \\\"\\\"id\\\":1\\n}\",\"status\":0,\"trueExam\":\"{\\n    \\\"\\\"id\\\":1\\n}\"}', '2016-11-21 13:18:27', '0');
INSERT INTO `fly_operate_log` VALUES ('194', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：撒旦法撒旦接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"是打发十大\",\"interDes\":\"撒旦法是\",\"interName\":\"撒旦法撒旦\",\"interUrl\":\"是发达啊\",\"method\":\"POST\",\"moduleId\":1,\"param\":\"[{\\\"name\\\":\\\"描述\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"烦死哒\",\"responseParam\":\"我师傅说\",\"status\":0,\"trueExam\":\"撒旦法撒旦\"}', '2016-11-22 10:34:02', '0');
INSERT INTO `fly_operate_log` VALUES ('195', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：十多个第三方接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"是打发是\",\"interDes\":\"阿斯顿发生的\",\"interName\":\"十多个第三方\",\"interUrl\":\"撒打发士大夫撒的\",\"method\":\"POST\",\"moduleId\":1,\"param\":\"[{\\\"name\\\":\\\"描述\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"多个\",\"responseParam\":\"第三方十大\",\"status\":0,\"trueExam\":\"沙发是\"}', '2016-11-22 10:36:52', '0');
INSERT INTO `fly_operate_log` VALUES ('196', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：士大夫撒旦法接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"是发达\",\"interDes\":\"是打发是\",\"interName\":\"士大夫撒旦法\",\"interUrl\":\"是对方发送\",\"method\":\"POST\",\"moduleId\":1,\"param\":\"[{\\\"name\\\":\\\"描述\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"是打发\",\"responseParam\":\"是短发是\",\"status\":0,\"trueExam\":\"是打发\"}', '2016-11-22 10:37:52', '0');
INSERT INTO `fly_operate_log` VALUES ('197', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：的方式告诉对方接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"撒旦法\",\"interDes\":\"东方广东省\",\"interName\":\"的方式告诉对方\",\"interUrl\":\"对方告诉对方\",\"method\":\"POST\",\"moduleId\":1,\"param\":\"[{\\\"name\\\":\\\"描述\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"撒旦法\",\"responseParam\":\"沙发\",\"status\":0,\"trueExam\":\"撒旦法\"}', '2016-11-22 10:39:38', '0');
INSERT INTO `fly_operate_log` VALUES ('198', '2', '11', 'admin', 'INSERT', 'interface', '接口', '新建：排行榜接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\\"status\\\":404,\\n\\t\\\"data\\\":\\\"\\\",\\n}\",\"interDes\":\"对用户积分进行排行\",\"interName\":\"排行榜\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":1,\"param\":\"[{\\\"name\\\":\\\"userId\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\n\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\\"status\\\":404,\\n\\t\\\"data\\\":\\\"\\\",\\n}\",\"responseParam\":\"{\\n\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\\"status\\\":404,\\n\\t\\\"data\\\":\\\"\\\",\\n}\",\"status\":0,\"trueExam\":\"{\\n\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\\"status\\\":404,\\n\\t\\\"data\\\":\\\"\\\",\\n}\"}', '2016-11-22 11:23:11', '0');
INSERT INTO `fly_operate_log` VALUES ('199', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 14:52:50', '0');
INSERT INTO `fly_operate_log` VALUES ('200', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 15:01:15', '0');
INSERT INTO `fly_operate_log` VALUES ('201', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:31:58', '0');
INSERT INTO `fly_operate_log` VALUES ('202', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:32:45', '0');
INSERT INTO `fly_operate_log` VALUES ('203', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:32:47', '0');
INSERT INTO `fly_operate_log` VALUES ('204', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:35:04', '0');
INSERT INTO `fly_operate_log` VALUES ('205', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:36:00', '0');
INSERT INTO `fly_operate_log` VALUES ('206', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:38:22', '0');
INSERT INTO `fly_operate_log` VALUES ('207', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:43:31', '0');
INSERT INTO `fly_operate_log` VALUES ('208', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:44:16', '0');
INSERT INTO `fly_operate_log` VALUES ('209', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:44:19', '0');
INSERT INTO `fly_operate_log` VALUES ('210', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-22 16:44:34', '0');
INSERT INTO `fly_operate_log` VALUES ('211', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:51:05', '0');
INSERT INTO `fly_operate_log` VALUES ('212', '2', '15', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":15,\"userId\":2}', '2016-11-22 16:51:28', '0');
INSERT INTO `fly_operate_log` VALUES ('213', '2', '15', 'admin', 'INSERT', 'module', '模块', '新建：测试模块模块', '{\"moduleDes\":\"这是测试的\",\"moduleName\":\"测试模块\",\"pageNumber\":1,\"pageSize\":10,\"projectId\":15}', '2016-11-22 16:51:54', '0');
INSERT INTO `fly_operate_log` VALUES ('214', '2', '15', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":15,\"userId\":2}', '2016-11-22 16:51:59', '0');
INSERT INTO `fly_operate_log` VALUES ('215', '2', '15', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":15,\"userId\":2}', '2016-11-22 16:52:44', '0');
INSERT INTO `fly_operate_log` VALUES ('216', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:52:56', '0');
INSERT INTO `fly_operate_log` VALUES ('217', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-22 16:53:12', '0');
INSERT INTO `fly_operate_log` VALUES ('218', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-22 18:19:50', '0');
INSERT INTO `fly_operate_log` VALUES ('219', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-22 18:20:00', '0');
INSERT INTO `fly_operate_log` VALUES ('220', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 10:22:39', '0');
INSERT INTO `fly_operate_log` VALUES ('221', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 10:27:15', '0');
INSERT INTO `fly_operate_log` VALUES ('222', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 10:29:01', '0');
INSERT INTO `fly_operate_log` VALUES ('223', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 10:36:59', '0');
INSERT INTO `fly_operate_log` VALUES ('224', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 10:37:08', '0');
INSERT INTO `fly_operate_log` VALUES ('225', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 11:20:12', '0');
INSERT INTO `fly_operate_log` VALUES ('226', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 11:20:15', '0');
INSERT INTO `fly_operate_log` VALUES ('227', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 11:24:58', '0');
INSERT INTO `fly_operate_log` VALUES ('228', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 11:31:39', '0');
INSERT INTO `fly_operate_log` VALUES ('229', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 11:38:26', '0');
INSERT INTO `fly_operate_log` VALUES ('230', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 11:39:39', '0');
INSERT INTO `fly_operate_log` VALUES ('231', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 11:39:42', '0');
INSERT INTO `fly_operate_log` VALUES ('232', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 11:40:12', '0');
INSERT INTO `fly_operate_log` VALUES ('233', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-23 11:40:14', '0');
INSERT INTO `fly_operate_log` VALUES ('234', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-23 11:43:11', '0');
INSERT INTO `fly_operate_log` VALUES ('235', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-23 11:43:14', '0');
INSERT INTO `fly_operate_log` VALUES ('236', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-23 11:44:42', '0');
INSERT INTO `fly_operate_log` VALUES ('237', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 13:47:29', '0');
INSERT INTO `fly_operate_log` VALUES ('238', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 14:55:42', '0');
INSERT INTO `fly_operate_log` VALUES ('239', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 17:31:41', '0');
INSERT INTO `fly_operate_log` VALUES ('240', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-23 17:33:17', '0');
INSERT INTO `fly_operate_log` VALUES ('241', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 11:38:32', '0');
INSERT INTO `fly_operate_log` VALUES ('242', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 11:39:50', '0');
INSERT INTO `fly_operate_log` VALUES ('243', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 11:43:04', '0');
INSERT INTO `fly_operate_log` VALUES ('244', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 11:45:22', '0');
INSERT INTO `fly_operate_log` VALUES ('245', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 13:00:00', '0');
INSERT INTO `fly_operate_log` VALUES ('246', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 13:07:38', '0');
INSERT INTO `fly_operate_log` VALUES ('247', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 13:08:16', '0');
INSERT INTO `fly_operate_log` VALUES ('248', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 13:55:36', '0');
INSERT INTO `fly_operate_log` VALUES ('249', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 14:43:55', '0');
INSERT INTO `fly_operate_log` VALUES ('250', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 14:46:26', '0');
INSERT INTO `fly_operate_log` VALUES ('251', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 14:52:28', '0');
INSERT INTO `fly_operate_log` VALUES ('252', '2', '15', 'admin', 'INSERT', 'interface', '接口', '新建：核心涂料接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\\"status\\\":404,\\n\\t\\\"data\\\":\\\"\\\",\\n}\",\"interDes\":\"获取公司主要的涂料\",\"interName\":\"核心涂料\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":3,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\n   \\\"id\\\":2\\n}\",\"responseParam\":\"msg是成功或失败\\nstatus是状态码\\ndata存放数据\",\"status\":0,\"trueExam\":\"{\\n\\t\\\"msg\\\":\\\"success\\\",\\n\\t\\\"status\\\":200,\\n\\t\\\"data\\\":\\\"\\\",\\n}\"}', '2016-11-24 15:18:01', '0');
INSERT INTO `fly_operate_log` VALUES ('253', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 15:18:29', '0');
INSERT INTO `fly_operate_log` VALUES ('254', '2', '15', 'admin', 'INSERT', 'interface', '接口', '新建：获取售价接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n\\t\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\t\\\"status\\\":404,\\n\\t\\t\\\"data\\\":\\\"\\\",\\n\\t}\",\"interDes\":\"获取指定涂料的售价\",\"interName\":\"获取售价\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":3,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\\"id\\\":3}\",\"responseParam\":\"msg是成功或失败\\n    status是状态码\\n    data存放数据\",\"status\":0,\"trueExam\":\"{\\n\\t\\\"msg\\\":\\\"success\\\",\\n\\t\\\"status\\\":200,\\n\\t\\\"data\\\":\\\"\\\",\\n}\"}', '2016-11-24 15:29:20', '0');
INSERT INTO `fly_operate_log` VALUES ('255', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 15:29:25', '0');
INSERT INTO `fly_operate_log` VALUES ('256', '2', '15', 'admin', 'INSERT', 'interface', '接口', '新建：订单支付接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n\\t\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\t\\\"status\\\":404,\\n\\t\\t\\\"data\\\":\\\"\\\",\\n\\t}\",\"interDes\":\"用户购买涂料后支付\",\"interName\":\"订单支付\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":3,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\\"id\\\":3}\",\"responseParam\":\"msg是成功或失败\\n    status是状态码\\n    data存放数据\",\"status\":0,\"trueExam\":\"{\\n\\t\\\"msg\\\":\\\"success\\\",\\n\\t\\\"status\\\":200,\\n\\t\\\"data\\\":\\\"\\\",\\n}\"}', '2016-11-24 15:34:43', '0');
INSERT INTO `fly_operate_log` VALUES ('257', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 15:34:47', '0');
INSERT INTO `fly_operate_log` VALUES ('258', '2', '15', 'admin', 'INSERT', 'interface', '接口', '新建：新建项目接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n\\t\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\t\\\"status\\\":404,\\n\\t\\t\\\"data\\\":\\\"\\\",\\n\\t}\",\"interDes\":\"这是我的接口描述\",\"interName\":\"新建项目\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":3,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\\"id\\\":4}\",\"responseParam\":\"msg是成功或失败\\n    status是状态码\\n    data存放数据\",\"status\":0,\"trueExam\":\"{\\n\\t\\\"msg\\\":\\\"success\\\",\\n\\t\\\"status\\\":200,\\n\\t\\\"data\\\":\\\"\\\",\\n}\"}', '2016-11-24 15:41:10', '0');
INSERT INTO `fly_operate_log` VALUES ('259', '2', '15', 'admin', 'INSERT', 'interface', '接口', '新建：获取日志接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\n\\t\\t\\\"msg\\\":\\\"error\\\",\\n\\t\\t\\\"status\\\":404,\\n\\t\\t\\\"data\\\":\\\"\\\",\\n\\t}\",\"interDes\":\"操作的日志详情\",\"interName\":\"获取日志\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":3,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"\\\"{\\\\\\\"id\\\\\\\":5}\\\"\",\"responseParam\":\"msg是成功或失败\\n    status是状态码\\n    data存放数据\",\"status\":0,\"trueExam\":\"{\\n\\t\\\"msg\\\":\\\"success\\\",\\n\\t\\\"status\\\":200,\\n\\t\\\"data\\\":\\\"\\\",\\n}\"}', '2016-11-24 15:47:14', '0');
INSERT INTO `fly_operate_log` VALUES ('260', '2', '15', 'admin', 'INSERT', 'interface', '接口', '新建：【今日登陆人数】接口', '{\"content\":\"\",\"creator\":2,\"falseExam\":\"{\\\"id\\\":8}\",\"interDes\":\"用户数据统计\",\"interName\":\"今日登陆人数\",\"interUrl\":\"http://localhost:8080/flyapi/forward/new_interfaces.html\",\"method\":\"POST\",\"moduleId\":3,\"param\":\"[{\\\"name\\\":\\\"id\\\",\\\"isTrue\\\":\\\"true\\\",\\\"interType\\\":\\\"int\\\",\\\"des\\\":\\\"描述\\\",\\\"state\\\":true}]\",\"requestExam\":\"{\\\"id\\\":8}\",\"responseParam\":\"{\\\"id\\\":8}\",\"status\":0,\"trueExam\":\"{\\\"id\\\":8}\"}', '2016-12-12 16:58:46', '0');
INSERT INTO `fly_operate_log` VALUES ('261', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 16:23:28', '0');
INSERT INTO `fly_operate_log` VALUES ('262', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 16:45:16', '0');
INSERT INTO `fly_operate_log` VALUES ('263', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 16:47:05', '0');
INSERT INTO `fly_operate_log` VALUES ('264', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 16:49:12', '0');
INSERT INTO `fly_operate_log` VALUES ('265', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-24 17:05:30', '0');
INSERT INTO `fly_operate_log` VALUES ('266', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 09:43:38', '0');
INSERT INTO `fly_operate_log` VALUES ('267', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 09:43:58', '0');
INSERT INTO `fly_operate_log` VALUES ('268', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 09:53:09', '0');
INSERT INTO `fly_operate_log` VALUES ('269', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 14:18:00', '0');
INSERT INTO `fly_operate_log` VALUES ('270', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 14:20:37', '0');
INSERT INTO `fly_operate_log` VALUES ('271', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:20:54', '0');
INSERT INTO `fly_operate_log` VALUES ('272', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:24:55', '0');
INSERT INTO `fly_operate_log` VALUES ('273', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:25:06', '0');
INSERT INTO `fly_operate_log` VALUES ('274', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:27:58', '0');
INSERT INTO `fly_operate_log` VALUES ('275', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:29:01', '0');
INSERT INTO `fly_operate_log` VALUES ('276', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:30:08', '0');
INSERT INTO `fly_operate_log` VALUES ('277', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:30:20', '0');
INSERT INTO `fly_operate_log` VALUES ('278', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:31:17', '0');
INSERT INTO `fly_operate_log` VALUES ('279', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 14:32:07', '0');
INSERT INTO `fly_operate_log` VALUES ('280', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:32:10', '0');
INSERT INTO `fly_operate_log` VALUES ('281', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:35:14', '0');
INSERT INTO `fly_operate_log` VALUES ('282', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 14:35:32', '0');
INSERT INTO `fly_operate_log` VALUES ('283', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 14:35:36', '0');
INSERT INTO `fly_operate_log` VALUES ('284', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:35:38', '0');
INSERT INTO `fly_operate_log` VALUES ('285', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:35:58', '0');
INSERT INTO `fly_operate_log` VALUES ('286', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:40:27', '0');
INSERT INTO `fly_operate_log` VALUES ('287', '2', '11', 'admin', 'INSERT', 'team', '成员', '添加：项目成员-flyhero', '{\"isCreator\":0,\"isEdit\":0,\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 14:40:38', '0');
INSERT INTO `fly_operate_log` VALUES ('288', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 14:40:41', '0');
INSERT INTO `fly_operate_log` VALUES ('289', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 14:51:35', '0');
INSERT INTO `fly_operate_log` VALUES ('290', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 15:01:09', '0');
INSERT INTO `fly_operate_log` VALUES ('291', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 15:01:14', '0');
INSERT INTO `fly_operate_log` VALUES ('292', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 15:01:18', '0');
INSERT INTO `fly_operate_log` VALUES ('293', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 15:11:12', '0');
INSERT INTO `fly_operate_log` VALUES ('294', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 15:11:44', '0');
INSERT INTO `fly_operate_log` VALUES ('295', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 15:12:02', '0');
INSERT INTO `fly_operate_log` VALUES ('296', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 15:12:06', '0');
INSERT INTO `fly_operate_log` VALUES ('297', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 15:12:12', '0');
INSERT INTO `fly_operate_log` VALUES ('298', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 15:21:43', '0');
INSERT INTO `fly_operate_log` VALUES ('299', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 15:21:46', '0');
INSERT INTO `fly_operate_log` VALUES ('300', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 15:21:50', '0');
INSERT INTO `fly_operate_log` VALUES ('301', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 15:21:54', '0');
INSERT INTO `fly_operate_log` VALUES ('302', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 15:27:07', '0');
INSERT INTO `fly_operate_log` VALUES ('303', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 16:14:15', '0');
INSERT INTO `fly_operate_log` VALUES ('304', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-28 16:14:19', '0');
INSERT INTO `fly_operate_log` VALUES ('305', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 16:14:27', '0');
INSERT INTO `fly_operate_log` VALUES ('306', '2', '15', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":15,\"userId\":2}', '2016-11-28 16:14:29', '0');
INSERT INTO `fly_operate_log` VALUES ('307', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 16:14:36', '0');
INSERT INTO `fly_operate_log` VALUES ('308', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-28 16:14:38', '0');
INSERT INTO `fly_operate_log` VALUES ('309', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-28 16:14:49', '0');
INSERT INTO `fly_operate_log` VALUES ('310', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-28 16:14:51', '0');
INSERT INTO `fly_operate_log` VALUES ('311', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:15:12', '0');
INSERT INTO `fly_operate_log` VALUES ('312', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 16:15:13', '0');
INSERT INTO `fly_operate_log` VALUES ('313', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:15:31', '0');
INSERT INTO `fly_operate_log` VALUES ('314', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 16:15:34', '0');
INSERT INTO `fly_operate_log` VALUES ('315', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:18:23', '0');
INSERT INTO `fly_operate_log` VALUES ('316', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 16:18:35', '0');
INSERT INTO `fly_operate_log` VALUES ('317', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:21:40', '0');
INSERT INTO `fly_operate_log` VALUES ('318', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:21:42', '0');
INSERT INTO `fly_operate_log` VALUES ('319', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:21:53', '0');
INSERT INTO `fly_operate_log` VALUES ('320', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:21:59', '0');
INSERT INTO `fly_operate_log` VALUES ('321', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:23:51', '0');
INSERT INTO `fly_operate_log` VALUES ('322', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:24:20', '0');
INSERT INTO `fly_operate_log` VALUES ('323', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:26:08', '0');
INSERT INTO `fly_operate_log` VALUES ('324', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:26:56', '0');
INSERT INTO `fly_operate_log` VALUES ('325', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:27:27', '0');
INSERT INTO `fly_operate_log` VALUES ('326', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:28:08', '0');
INSERT INTO `fly_operate_log` VALUES ('327', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:28:46', '0');
INSERT INTO `fly_operate_log` VALUES ('328', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:29:53', '0');
INSERT INTO `fly_operate_log` VALUES ('329', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:29:55', '0');
INSERT INTO `fly_operate_log` VALUES ('330', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:32:34', '0');
INSERT INTO `fly_operate_log` VALUES ('331', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:57:18', '0');
INSERT INTO `fly_operate_log` VALUES ('332', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:57:59', '0');
INSERT INTO `fly_operate_log` VALUES ('333', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:58:40', '0');
INSERT INTO `fly_operate_log` VALUES ('334', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:58:44', '0');
INSERT INTO `fly_operate_log` VALUES ('335', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 16:58:46', '0');
INSERT INTO `fly_operate_log` VALUES ('336', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 16:59:20', '0');
INSERT INTO `fly_operate_log` VALUES ('337', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:59:23', '0');
INSERT INTO `fly_operate_log` VALUES ('338', '1', '1', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":1}', '2016-11-28 16:59:25', '0');
INSERT INTO `fly_operate_log` VALUES ('339', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 16:59:32', '0');
INSERT INTO `fly_operate_log` VALUES ('340', '1', '11', 'flyhero', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":1}', '2016-11-28 16:59:33', '0');
INSERT INTO `fly_operate_log` VALUES ('341', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 17:15:53', '0');
INSERT INTO `fly_operate_log` VALUES ('342', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 17:17:03', '0');
INSERT INTO `fly_operate_log` VALUES ('343', '1', '0', 'flyhero', 'SELECT', 'project', '项目', '查询：flyhero参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":1}', '2016-11-28 17:17:20', '0');
INSERT INTO `fly_operate_log` VALUES ('344', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 10:25:39', '0');
INSERT INTO `fly_operate_log` VALUES ('345', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-29 10:25:43', '0');
INSERT INTO `fly_operate_log` VALUES ('346', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-29 10:27:12', '0');
INSERT INTO `fly_operate_log` VALUES ('347', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 10:30:46', '0');
INSERT INTO `fly_operate_log` VALUES ('348', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-29 10:30:47', '0');
INSERT INTO `fly_operate_log` VALUES ('349', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 10:30:56', '0');
INSERT INTO `fly_operate_log` VALUES ('350', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-29 10:31:01', '0');
INSERT INTO `fly_operate_log` VALUES ('351', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 10:33:26', '0');
INSERT INTO `fly_operate_log` VALUES ('352', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-29 10:33:29', '0');
INSERT INTO `fly_operate_log` VALUES ('353', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-29 10:35:30', '0');
INSERT INTO `fly_operate_log` VALUES ('354', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 11:53:42', '0');
INSERT INTO `fly_operate_log` VALUES ('355', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-29 11:53:53', '0');
INSERT INTO `fly_operate_log` VALUES ('356', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 11:54:18', '0');
INSERT INTO `fly_operate_log` VALUES ('357', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-29 11:54:20', '0');
INSERT INTO `fly_operate_log` VALUES ('358', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 11:54:44', '0');
INSERT INTO `fly_operate_log` VALUES ('359', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 11:54:46', '0');
INSERT INTO `fly_operate_log` VALUES ('360', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 11:55:47', '0');
INSERT INTO `fly_operate_log` VALUES ('361', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 11:56:02', '0');
INSERT INTO `fly_operate_log` VALUES ('362', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 16:27:34', '0');
INSERT INTO `fly_operate_log` VALUES ('363', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-29 16:27:49', '0');
INSERT INTO `fly_operate_log` VALUES ('364', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 09:41:03', '0');
INSERT INTO `fly_operate_log` VALUES ('365', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 09:41:06', '0');
INSERT INTO `fly_operate_log` VALUES ('366', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 09:41:30', '0');
INSERT INTO `fly_operate_log` VALUES ('367', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 09:41:47', '0');
INSERT INTO `fly_operate_log` VALUES ('368', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:10:44', '0');
INSERT INTO `fly_operate_log` VALUES ('369', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:11:16', '0');
INSERT INTO `fly_operate_log` VALUES ('370', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:11:28', '0');
INSERT INTO `fly_operate_log` VALUES ('371', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:13:15', '0');
INSERT INTO `fly_operate_log` VALUES ('372', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:16:26', '0');
INSERT INTO `fly_operate_log` VALUES ('373', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:16:31', '0');
INSERT INTO `fly_operate_log` VALUES ('374', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:17:07', '0');
INSERT INTO `fly_operate_log` VALUES ('375', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:28:18', '0');
INSERT INTO `fly_operate_log` VALUES ('376', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-30 10:28:21', '0');
INSERT INTO `fly_operate_log` VALUES ('377', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-30 10:36:08', '0');
INSERT INTO `fly_operate_log` VALUES ('378', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:37:03', '0');
INSERT INTO `fly_operate_log` VALUES ('379', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-11-30 10:37:05', '0');
INSERT INTO `fly_operate_log` VALUES ('380', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:37:35', '0');
INSERT INTO `fly_operate_log` VALUES ('381', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 10:37:37', '0');
INSERT INTO `fly_operate_log` VALUES ('382', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 10:39:02', '0');
INSERT INTO `fly_operate_log` VALUES ('383', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 10:40:33', '0');
INSERT INTO `fly_operate_log` VALUES ('384', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 10:41:16', '0');
INSERT INTO `fly_operate_log` VALUES ('385', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 10:42:01', '0');
INSERT INTO `fly_operate_log` VALUES ('386', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 10:54:29', '0');
INSERT INTO `fly_operate_log` VALUES ('387', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 10:54:34', '0');
INSERT INTO `fly_operate_log` VALUES ('388', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 11:07:36', '0');
INSERT INTO `fly_operate_log` VALUES ('389', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 11:07:53', '0');
INSERT INTO `fly_operate_log` VALUES ('390', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 18:03:29', '0');
INSERT INTO `fly_operate_log` VALUES ('391', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-11-30 18:03:36', '0');
INSERT INTO `fly_operate_log` VALUES ('392', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-11-30 18:03:49', '0');
INSERT INTO `fly_operate_log` VALUES ('393', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 13:29:23', '0');
INSERT INTO `fly_operate_log` VALUES ('394', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:11:46', '0');
INSERT INTO `fly_operate_log` VALUES ('395', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:12:21', '0');
INSERT INTO `fly_operate_log` VALUES ('396', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:16:46', '0');
INSERT INTO `fly_operate_log` VALUES ('397', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:16:50', '0');
INSERT INTO `fly_operate_log` VALUES ('398', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:17:34', '0');
INSERT INTO `fly_operate_log` VALUES ('399', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:17:36', '0');
INSERT INTO `fly_operate_log` VALUES ('400', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:17:57', '0');
INSERT INTO `fly_operate_log` VALUES ('401', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:17:59', '0');
INSERT INTO `fly_operate_log` VALUES ('402', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:18:15', '0');
INSERT INTO `fly_operate_log` VALUES ('403', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:20:48', '0');
INSERT INTO `fly_operate_log` VALUES ('404', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:22:01', '0');
INSERT INTO `fly_operate_log` VALUES ('405', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:28:44', '0');
INSERT INTO `fly_operate_log` VALUES ('406', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:29:29', '0');
INSERT INTO `fly_operate_log` VALUES ('407', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:38:47', '0');
INSERT INTO `fly_operate_log` VALUES ('408', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 15:59:38', '0');
INSERT INTO `fly_operate_log` VALUES ('409', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 16:02:20', '0');
INSERT INTO `fly_operate_log` VALUES ('410', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 16:07:29', '0');
INSERT INTO `fly_operate_log` VALUES ('411', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 16:20:17', '0');
INSERT INTO `fly_operate_log` VALUES ('412', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 16:27:58', '0');
INSERT INTO `fly_operate_log` VALUES ('413', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 16:51:50', '0');
INSERT INTO `fly_operate_log` VALUES ('414', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 18:28:08', '0');
INSERT INTO `fly_operate_log` VALUES ('415', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 18:35:10', '0');
INSERT INTO `fly_operate_log` VALUES ('416', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 18:35:44', '0');
INSERT INTO `fly_operate_log` VALUES ('417', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-01 18:40:18', '0');
INSERT INTO `fly_operate_log` VALUES ('418', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:24:45', '0');
INSERT INTO `fly_operate_log` VALUES ('419', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:31:03', '0');
INSERT INTO `fly_operate_log` VALUES ('420', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:36:11', '0');
INSERT INTO `fly_operate_log` VALUES ('421', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:37:19', '0');
INSERT INTO `fly_operate_log` VALUES ('422', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:40:55', '0');
INSERT INTO `fly_operate_log` VALUES ('423', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:47:01', '0');
INSERT INTO `fly_operate_log` VALUES ('424', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:48:16', '0');
INSERT INTO `fly_operate_log` VALUES ('425', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:49:21', '0');
INSERT INTO `fly_operate_log` VALUES ('426', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:50:35', '0');
INSERT INTO `fly_operate_log` VALUES ('427', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 17:51:57', '0');
INSERT INTO `fly_operate_log` VALUES ('428', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 18:00:20', '0');
INSERT INTO `fly_operate_log` VALUES ('429', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 18:01:31', '0');
INSERT INTO `fly_operate_log` VALUES ('430', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 18:02:43', '0');
INSERT INTO `fly_operate_log` VALUES ('431', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-02 18:51:24', '0');
INSERT INTO `fly_operate_log` VALUES ('432', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:06:24', '0');
INSERT INTO `fly_operate_log` VALUES ('433', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:16:57', '0');
INSERT INTO `fly_operate_log` VALUES ('434', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:19:07', '0');
INSERT INTO `fly_operate_log` VALUES ('435', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:21:02', '0');
INSERT INTO `fly_operate_log` VALUES ('436', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:25:13', '0');
INSERT INTO `fly_operate_log` VALUES ('437', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:26:00', '0');
INSERT INTO `fly_operate_log` VALUES ('438', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:30:08', '0');
INSERT INTO `fly_operate_log` VALUES ('439', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:31:38', '0');
INSERT INTO `fly_operate_log` VALUES ('440', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:32:09', '0');
INSERT INTO `fly_operate_log` VALUES ('441', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:40:57', '0');
INSERT INTO `fly_operate_log` VALUES ('442', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:42:40', '0');
INSERT INTO `fly_operate_log` VALUES ('443', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:43:09', '0');
INSERT INTO `fly_operate_log` VALUES ('444', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:44:07', '0');
INSERT INTO `fly_operate_log` VALUES ('445', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:45:59', '0');
INSERT INTO `fly_operate_log` VALUES ('446', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:46:37', '0');
INSERT INTO `fly_operate_log` VALUES ('447', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:50:38', '0');
INSERT INTO `fly_operate_log` VALUES ('448', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:53:58', '0');
INSERT INTO `fly_operate_log` VALUES ('449', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 11:55:21', '0');
INSERT INTO `fly_operate_log` VALUES ('450', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-05 12:01:06', '0');
INSERT INTO `fly_operate_log` VALUES ('451', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-09 13:46:48', '0');
INSERT INTO `fly_operate_log` VALUES ('452', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-09 14:10:36', '0');
INSERT INTO `fly_operate_log` VALUES ('453', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-09 14:18:27', '0');
INSERT INTO `fly_operate_log` VALUES ('454', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-09 14:18:31', '0');
INSERT INTO `fly_operate_log` VALUES ('455', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 10:08:58', '0');
INSERT INTO `fly_operate_log` VALUES ('456', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:17:29', '0');
INSERT INTO `fly_operate_log` VALUES ('457', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:20:01', '0');
INSERT INTO `fly_operate_log` VALUES ('458', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:20:04', '0');
INSERT INTO `fly_operate_log` VALUES ('459', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:31:57', '0');
INSERT INTO `fly_operate_log` VALUES ('460', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:46:40', '0');
INSERT INTO `fly_operate_log` VALUES ('461', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:47:06', '0');
INSERT INTO `fly_operate_log` VALUES ('462', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 13:47:25', '0');
INSERT INTO `fly_operate_log` VALUES ('463', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 13:47:33', '0');
INSERT INTO `fly_operate_log` VALUES ('464', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:02:52', '0');
INSERT INTO `fly_operate_log` VALUES ('465', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:03:19', '0');
INSERT INTO `fly_operate_log` VALUES ('466', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-12 15:03:27', '0');
INSERT INTO `fly_operate_log` VALUES ('467', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:03:45', '0');
INSERT INTO `fly_operate_log` VALUES ('468', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:06:10', '0');
INSERT INTO `fly_operate_log` VALUES ('469', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:06:55', '0');
INSERT INTO `fly_operate_log` VALUES ('470', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:07:25', '0');
INSERT INTO `fly_operate_log` VALUES ('471', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:07:35', '0');
INSERT INTO `fly_operate_log` VALUES ('472', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:08:23', '0');
INSERT INTO `fly_operate_log` VALUES ('473', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:08:44', '0');
INSERT INTO `fly_operate_log` VALUES ('474', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:09:00', '0');
INSERT INTO `fly_operate_log` VALUES ('475', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:09:15', '0');
INSERT INTO `fly_operate_log` VALUES ('476', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:09:30', '0');
INSERT INTO `fly_operate_log` VALUES ('477', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:11:08', '0');
INSERT INTO `fly_operate_log` VALUES ('478', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:11:13', '0');
INSERT INTO `fly_operate_log` VALUES ('479', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:11:30', '0');
INSERT INTO `fly_operate_log` VALUES ('480', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:12:27', '0');
INSERT INTO `fly_operate_log` VALUES ('481', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:13:00', '0');
INSERT INTO `fly_operate_log` VALUES ('482', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:13:05', '0');
INSERT INTO `fly_operate_log` VALUES ('483', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-12 15:13:07', '0');
INSERT INTO `fly_operate_log` VALUES ('484', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:13:10', '0');
INSERT INTO `fly_operate_log` VALUES ('485', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:13:56', '0');
INSERT INTO `fly_operate_log` VALUES ('486', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:14:31', '0');
INSERT INTO `fly_operate_log` VALUES ('487', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:14:48', '0');
INSERT INTO `fly_operate_log` VALUES ('488', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-12 15:15:32', '0');
INSERT INTO `fly_operate_log` VALUES ('489', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:16:15', '0');
INSERT INTO `fly_operate_log` VALUES ('490', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-12 15:16:17', '0');
INSERT INTO `fly_operate_log` VALUES ('491', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:16:43', '0');
INSERT INTO `fly_operate_log` VALUES ('492', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-12 15:16:45', '0');
INSERT INTO `fly_operate_log` VALUES ('493', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:17:24', '0');
INSERT INTO `fly_operate_log` VALUES ('494', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-12 15:17:27', '0');
INSERT INTO `fly_operate_log` VALUES ('495', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:18:14', '0');
INSERT INTO `fly_operate_log` VALUES ('496', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:18:26', '0');
INSERT INTO `fly_operate_log` VALUES ('497', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:20:07', '0');
INSERT INTO `fly_operate_log` VALUES ('498', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:23:13', '0');
INSERT INTO `fly_operate_log` VALUES ('499', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:23:14', '0');
INSERT INTO `fly_operate_log` VALUES ('500', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 15:24:06', '0');
INSERT INTO `fly_operate_log` VALUES ('501', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:16:42', '0');
INSERT INTO `fly_operate_log` VALUES ('502', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:16:43', '0');
INSERT INTO `fly_operate_log` VALUES ('503', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:16:44', '0');
INSERT INTO `fly_operate_log` VALUES ('504', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:25:59', '0');
INSERT INTO `fly_operate_log` VALUES ('505', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:26:01', '0');
INSERT INTO `fly_operate_log` VALUES ('506', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:26:56', '0');
INSERT INTO `fly_operate_log` VALUES ('507', '2', '16', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":16,\"userId\":2}', '2016-12-12 16:26:59', '0');
INSERT INTO `fly_operate_log` VALUES ('508', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:34:40', '0');
INSERT INTO `fly_operate_log` VALUES ('509', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 16:46:47', '0');
INSERT INTO `fly_operate_log` VALUES ('510', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:00:39', '0');
INSERT INTO `fly_operate_log` VALUES ('511', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:00:55', '0');
INSERT INTO `fly_operate_log` VALUES ('512', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:02:55', '0');
INSERT INTO `fly_operate_log` VALUES ('513', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:03:34', '0');
INSERT INTO `fly_operate_log` VALUES ('514', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:04:46', '0');
INSERT INTO `fly_operate_log` VALUES ('515', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:04:53', '0');
INSERT INTO `fly_operate_log` VALUES ('516', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:24:02', '0');
INSERT INTO `fly_operate_log` VALUES ('517', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:24:06', '0');
INSERT INTO `fly_operate_log` VALUES ('518', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:25:37', '0');
INSERT INTO `fly_operate_log` VALUES ('519', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:25:38', '0');
INSERT INTO `fly_operate_log` VALUES ('520', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:30:24', '0');
INSERT INTO `fly_operate_log` VALUES ('521', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:32:16', '0');
INSERT INTO `fly_operate_log` VALUES ('522', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:32:28', '0');
INSERT INTO `fly_operate_log` VALUES ('523', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:36:42', '0');
INSERT INTO `fly_operate_log` VALUES ('524', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:36:46', '0');
INSERT INTO `fly_operate_log` VALUES ('525', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:38:25', '0');
INSERT INTO `fly_operate_log` VALUES ('526', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:38:27', '0');
INSERT INTO `fly_operate_log` VALUES ('527', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:39:34', '0');
INSERT INTO `fly_operate_log` VALUES ('528', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:39:37', '0');
INSERT INTO `fly_operate_log` VALUES ('529', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:39:50', '0');
INSERT INTO `fly_operate_log` VALUES ('530', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:39:52', '0');
INSERT INTO `fly_operate_log` VALUES ('531', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:40:41', '0');
INSERT INTO `fly_operate_log` VALUES ('532', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:40:43', '0');
INSERT INTO `fly_operate_log` VALUES ('533', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:40:49', '0');
INSERT INTO `fly_operate_log` VALUES ('534', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:40:51', '0');
INSERT INTO `fly_operate_log` VALUES ('535', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:43:03', '0');
INSERT INTO `fly_operate_log` VALUES ('536', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:43:05', '0');
INSERT INTO `fly_operate_log` VALUES ('537', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:44:48', '0');
INSERT INTO `fly_operate_log` VALUES ('538', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:44:50', '0');
INSERT INTO `fly_operate_log` VALUES ('539', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:45:09', '0');
INSERT INTO `fly_operate_log` VALUES ('540', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:45:11', '0');
INSERT INTO `fly_operate_log` VALUES ('541', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:46:49', '0');
INSERT INTO `fly_operate_log` VALUES ('542', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:46:50', '0');
INSERT INTO `fly_operate_log` VALUES ('543', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:47:13', '0');
INSERT INTO `fly_operate_log` VALUES ('544', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:47:14', '0');
INSERT INTO `fly_operate_log` VALUES ('545', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 17:47:39', '0');
INSERT INTO `fly_operate_log` VALUES ('546', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 17:47:40', '0');
INSERT INTO `fly_operate_log` VALUES ('547', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:02:16', '0');
INSERT INTO `fly_operate_log` VALUES ('548', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:02:55', '0');
INSERT INTO `fly_operate_log` VALUES ('549', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:02:57', '0');
INSERT INTO `fly_operate_log` VALUES ('550', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:03:57', '0');
INSERT INTO `fly_operate_log` VALUES ('551', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-12 18:04:00', '0');
INSERT INTO `fly_operate_log` VALUES ('552', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:04:02', '0');
INSERT INTO `fly_operate_log` VALUES ('553', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:04:30', '0');
INSERT INTO `fly_operate_log` VALUES ('554', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:04:56', '0');
INSERT INTO `fly_operate_log` VALUES ('555', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-12 18:05:26', '0');
INSERT INTO `fly_operate_log` VALUES ('556', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:44:35', '0');
INSERT INTO `fly_operate_log` VALUES ('557', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:44:37', '0');
INSERT INTO `fly_operate_log` VALUES ('558', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:44:38', '0');
INSERT INTO `fly_operate_log` VALUES ('559', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:53:57', '0');
INSERT INTO `fly_operate_log` VALUES ('560', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:53:59', '0');
INSERT INTO `fly_operate_log` VALUES ('561', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:54:00', '0');
INSERT INTO `fly_operate_log` VALUES ('562', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:57:38', '0');
INSERT INTO `fly_operate_log` VALUES ('563', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 09:58:27', '0');
INSERT INTO `fly_operate_log` VALUES ('564', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 10:27:20', '0');
INSERT INTO `fly_operate_log` VALUES ('565', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:09:54', '0');
INSERT INTO `fly_operate_log` VALUES ('566', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:11:27', '0');
INSERT INTO `fly_operate_log` VALUES ('567', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:13:01', '0');
INSERT INTO `fly_operate_log` VALUES ('568', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:13:48', '0');
INSERT INTO `fly_operate_log` VALUES ('569', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:14:23', '0');
INSERT INTO `fly_operate_log` VALUES ('570', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:23:23', '0');
INSERT INTO `fly_operate_log` VALUES ('571', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:23:26', '0');
INSERT INTO `fly_operate_log` VALUES ('572', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:24:08', '0');
INSERT INTO `fly_operate_log` VALUES ('573', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-13 13:24:11', '0');
INSERT INTO `fly_operate_log` VALUES ('574', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-15 13:34:13', '0');
INSERT INTO `fly_operate_log` VALUES ('575', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-15 14:19:43', '0');
INSERT INTO `fly_operate_log` VALUES ('576', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-15 14:21:20', '0');
INSERT INTO `fly_operate_log` VALUES ('577', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-15 14:31:44', '0');
INSERT INTO `fly_operate_log` VALUES ('578', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-16 17:23:23', '0');
INSERT INTO `fly_operate_log` VALUES ('579', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-16 17:23:26', '0');
INSERT INTO `fly_operate_log` VALUES ('580', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-16 17:27:00', '0');
INSERT INTO `fly_operate_log` VALUES ('581', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-16 17:27:14', '0');
INSERT INTO `fly_operate_log` VALUES ('582', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-16 17:34:58', '0');
INSERT INTO `fly_operate_log` VALUES ('583', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-19 11:10:12', '0');
INSERT INTO `fly_operate_log` VALUES ('584', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-19 13:27:58', '0');
INSERT INTO `fly_operate_log` VALUES ('585', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-19 13:49:06', '0');
INSERT INTO `fly_operate_log` VALUES ('586', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-19 14:02:54', '0');
INSERT INTO `fly_operate_log` VALUES ('587', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-19 14:58:58', '0');
INSERT INTO `fly_operate_log` VALUES ('588', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-19 14:59:31', '0');
INSERT INTO `fly_operate_log` VALUES ('589', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-19 14:59:43', '0');
INSERT INTO `fly_operate_log` VALUES ('590', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:16:38', '0');
INSERT INTO `fly_operate_log` VALUES ('591', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-22 11:21:54', '0');
INSERT INTO `fly_operate_log` VALUES ('592', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:22:54', '0');
INSERT INTO `fly_operate_log` VALUES ('593', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:39:34', '0');
INSERT INTO `fly_operate_log` VALUES ('594', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:42:39', '0');
INSERT INTO `fly_operate_log` VALUES ('595', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:46:17', '0');
INSERT INTO `fly_operate_log` VALUES ('596', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:47:03', '0');
INSERT INTO `fly_operate_log` VALUES ('597', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:47:41', '0');
INSERT INTO `fly_operate_log` VALUES ('598', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 11:50:32', '0');
INSERT INTO `fly_operate_log` VALUES ('599', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 13:14:32', '0');
INSERT INTO `fly_operate_log` VALUES ('600', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 13:38:40', '0');
INSERT INTO `fly_operate_log` VALUES ('601', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 13:42:44', '0');
INSERT INTO `fly_operate_log` VALUES ('602', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 13:52:36', '0');
INSERT INTO `fly_operate_log` VALUES ('603', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 13:56:50', '0');
INSERT INTO `fly_operate_log` VALUES ('604', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 13:59:05', '0');
INSERT INTO `fly_operate_log` VALUES ('605', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-22 17:46:06', '0');
INSERT INTO `fly_operate_log` VALUES ('606', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 10:28:22', '0');
INSERT INTO `fly_operate_log` VALUES ('607', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 10:31:29', '0');
INSERT INTO `fly_operate_log` VALUES ('608', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 10:37:14', '0');
INSERT INTO `fly_operate_log` VALUES ('609', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:12:09', '0');
INSERT INTO `fly_operate_log` VALUES ('610', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:12:51', '0');
INSERT INTO `fly_operate_log` VALUES ('611', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 16:12:53', '0');
INSERT INTO `fly_operate_log` VALUES ('612', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:14:03', '0');
INSERT INTO `fly_operate_log` VALUES ('613', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 16:14:06', '0');
INSERT INTO `fly_operate_log` VALUES ('614', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:15:42', '0');
INSERT INTO `fly_operate_log` VALUES ('615', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 16:15:43', '0');
INSERT INTO `fly_operate_log` VALUES ('616', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:58:10', '0');
INSERT INTO `fly_operate_log` VALUES ('617', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 16:58:17', '0');
INSERT INTO `fly_operate_log` VALUES ('618', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:58:46', '0');
INSERT INTO `fly_operate_log` VALUES ('619', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 16:58:48', '0');
INSERT INTO `fly_operate_log` VALUES ('620', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 16:59:07', '0');
INSERT INTO `fly_operate_log` VALUES ('621', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 16:59:08', '0');
INSERT INTO `fly_operate_log` VALUES ('622', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 17:00:16', '0');
INSERT INTO `fly_operate_log` VALUES ('623', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 17:00:34', '0');
INSERT INTO `fly_operate_log` VALUES ('624', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 17:00:35', '0');
INSERT INTO `fly_operate_log` VALUES ('625', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-23 17:02:45', '0');
INSERT INTO `fly_operate_log` VALUES ('626', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-23 17:02:51', '0');
INSERT INTO `fly_operate_log` VALUES ('627', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 09:36:35', '0');
INSERT INTO `fly_operate_log` VALUES ('628', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 09:36:56', '0');
INSERT INTO `fly_operate_log` VALUES ('629', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 09:40:28', '0');
INSERT INTO `fly_operate_log` VALUES ('630', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:02:16', '0');
INSERT INTO `fly_operate_log` VALUES ('631', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:06:20', '0');
INSERT INTO `fly_operate_log` VALUES ('632', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:06:24', '0');
INSERT INTO `fly_operate_log` VALUES ('633', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:07:59', '0');
INSERT INTO `fly_operate_log` VALUES ('634', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:09:36', '0');
INSERT INTO `fly_operate_log` VALUES ('635', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:10:41', '0');
INSERT INTO `fly_operate_log` VALUES ('636', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-26 11:12:20', '0');
INSERT INTO `fly_operate_log` VALUES ('637', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:14:37', '0');
INSERT INTO `fly_operate_log` VALUES ('638', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:16:03', '0');
INSERT INTO `fly_operate_log` VALUES ('639', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:17:24', '0');
INSERT INTO `fly_operate_log` VALUES ('640', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 11:18:03', '0');
INSERT INTO `fly_operate_log` VALUES ('641', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 15:49:44', '0');
INSERT INTO `fly_operate_log` VALUES ('642', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 16:23:21', '0');
INSERT INTO `fly_operate_log` VALUES ('643', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 16:24:40', '0');
INSERT INTO `fly_operate_log` VALUES ('644', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 16:25:46', '0');
INSERT INTO `fly_operate_log` VALUES ('645', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 16:43:22', '0');
INSERT INTO `fly_operate_log` VALUES ('646', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 16:48:34', '0');
INSERT INTO `fly_operate_log` VALUES ('647', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-26 16:51:49', '0');
INSERT INTO `fly_operate_log` VALUES ('648', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 11:31:25', '0');
INSERT INTO `fly_operate_log` VALUES ('649', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 11:42:53', '0');
INSERT INTO `fly_operate_log` VALUES ('650', '2', '1', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":1,\"userId\":2}', '2016-12-27 11:43:07', '0');
INSERT INTO `fly_operate_log` VALUES ('651', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 11:43:25', '0');
INSERT INTO `fly_operate_log` VALUES ('652', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 11:44:18', '0');
INSERT INTO `fly_operate_log` VALUES ('653', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 11:47:41', '0');
INSERT INTO `fly_operate_log` VALUES ('654', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 11:50:19', '0');
INSERT INTO `fly_operate_log` VALUES ('655', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 12:40:28', '0');
INSERT INTO `fly_operate_log` VALUES ('656', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 13:09:34', '0');
INSERT INTO `fly_operate_log` VALUES ('657', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 13:09:55', '0');
INSERT INTO `fly_operate_log` VALUES ('658', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 13:10:30', '0');
INSERT INTO `fly_operate_log` VALUES ('659', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 13:13:55', '0');
INSERT INTO `fly_operate_log` VALUES ('660', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 13:15:24', '0');
INSERT INTO `fly_operate_log` VALUES ('661', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-27 13:15:37', '0');
INSERT INTO `fly_operate_log` VALUES ('662', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 16:33:35', '0');
INSERT INTO `fly_operate_log` VALUES ('663', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 16:33:40', '0');
INSERT INTO `fly_operate_log` VALUES ('664', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 16:54:46', '0');
INSERT INTO `fly_operate_log` VALUES ('665', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 16:56:34', '0');
INSERT INTO `fly_operate_log` VALUES ('666', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 17:13:36', '0');
INSERT INTO `fly_operate_log` VALUES ('667', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 17:14:46', '0');
INSERT INTO `fly_operate_log` VALUES ('668', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 17:17:48', '0');
INSERT INTO `fly_operate_log` VALUES ('669', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 17:30:16', '0');
INSERT INTO `fly_operate_log` VALUES ('670', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 17:43:26', '0');
INSERT INTO `fly_operate_log` VALUES ('671', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 19:20:07', '0');
INSERT INTO `fly_operate_log` VALUES ('672', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-28 19:20:58', '0');
INSERT INTO `fly_operate_log` VALUES ('673', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-28 19:23:47', '0');
INSERT INTO `fly_operate_log` VALUES ('674', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-28 19:23:48', '0');
INSERT INTO `fly_operate_log` VALUES ('675', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-28 19:39:51', '0');
INSERT INTO `fly_operate_log` VALUES ('676', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 09:47:24', '0');
INSERT INTO `fly_operate_log` VALUES ('677', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:47:32', '0');
INSERT INTO `fly_operate_log` VALUES ('678', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 09:48:24', '0');
INSERT INTO `fly_operate_log` VALUES ('679', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:48:26', '0');
INSERT INTO `fly_operate_log` VALUES ('680', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 09:49:50', '0');
INSERT INTO `fly_operate_log` VALUES ('681', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:49:51', '0');
INSERT INTO `fly_operate_log` VALUES ('682', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 09:51:17', '0');
INSERT INTO `fly_operate_log` VALUES ('683', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:51:18', '0');
INSERT INTO `fly_operate_log` VALUES ('684', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:52:51', '0');
INSERT INTO `fly_operate_log` VALUES ('685', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:53:30', '0');
INSERT INTO `fly_operate_log` VALUES ('686', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:53:56', '0');
INSERT INTO `fly_operate_log` VALUES ('687', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:55:37', '0');
INSERT INTO `fly_operate_log` VALUES ('688', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:55:54', '0');
INSERT INTO `fly_operate_log` VALUES ('689', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:56:11', '0');
INSERT INTO `fly_operate_log` VALUES ('690', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:57:10', '0');
INSERT INTO `fly_operate_log` VALUES ('691', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:58:07', '0');
INSERT INTO `fly_operate_log` VALUES ('692', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 09:59:00', '0');
INSERT INTO `fly_operate_log` VALUES ('693', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 10:01:41', '0');
INSERT INTO `fly_operate_log` VALUES ('694', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 10:02:24', '0');
INSERT INTO `fly_operate_log` VALUES ('695', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 10:02:57', '0');
INSERT INTO `fly_operate_log` VALUES ('696', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 10:03:51', '0');
INSERT INTO `fly_operate_log` VALUES ('697', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 11:32:44', '0');
INSERT INTO `fly_operate_log` VALUES ('698', '2', '11', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":11,\"userId\":2}', '2016-12-29 11:32:56', '0');
INSERT INTO `fly_operate_log` VALUES ('699', '2', '16', 'admin', 'SELECT', 'team', '成员', '查询：项目成员', '{\"pageNumber\":1,\"pageSize\":10,\"projectId\":16,\"userId\":2}', '2016-12-29 11:34:07', '0');
INSERT INTO `fly_operate_log` VALUES ('700', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"\",\"proName\":\"\",\"proVersion\":\"\",\"projectId\":17}', '2016-12-29 11:53:03', '0');
INSERT INTO `fly_operate_log` VALUES ('701', '2', '0', 'admin', 'INSERT', 'project', '项目', '创建：qqqqqqqqqqqqqqqqeqwewqeqw项目', '{\"pageNumber\":1,\"pageSize\":10,\"proDes\":\"asdasdasdasdas\",\"proName\":\"qqqqqqqqqqqqqqqqeqwewqeqw\",\"proVersion\":\"asdadas\",\"projectId\":18,\"targetCount\":-2}', '2016-12-29 11:56:12', '0');
INSERT INTO `fly_operate_log` VALUES ('702', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin参与的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 13:14:57', '0');
INSERT INTO `fly_operate_log` VALUES ('703', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 13:15:01', '0');
INSERT INTO `fly_operate_log` VALUES ('704', '2', '0', 'admin', 'SELECT', 'project', '项目', '查询：admin创建的项目', '{\"pageNumber\":1,\"pageSize\":10,\"userId\":2}', '2016-12-29 13:15:22', '0');

-- ----------------------------
-- Table structure for fly_project
-- ----------------------------
DROP TABLE IF EXISTS `fly_project`;
CREATE TABLE `fly_project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '项目编号',
  `pro_name` varchar(100) NOT NULL COMMENT '项目名称',
  `pro_des` varchar(255) NOT NULL COMMENT '项目描述',
  `pro_version` varchar(10) NOT NULL COMMENT '版本号',
  `target_count` int(11) NOT NULL DEFAULT '100' COMMENT '预计接口数量',
  `done_count` int(11) NOT NULL DEFAULT '0' COMMENT '完成接口数量',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` int(2) DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Records of fly_project
-- ----------------------------
INSERT INTO `fly_project` VALUES ('1', '测试项目', '这是一个测试数据1', 'V1.0', '100', '20', '2016-11-04 15:27:21', '2016-11-09 17:01:00', '0');
INSERT INTO `fly_project` VALUES ('11', '遛遛旅游', '一个旅游类的app', 'V1.0', '140', '7', '2016-11-10 14:48:44', '2016-11-22 11:23:11', '0');
INSERT INTO `fly_project` VALUES ('12', '企鹅企鹅', '请问', 'v1.1', '112', '0', '2016-11-10 14:52:11', '2016-11-16 10:30:24', '1');
INSERT INTO `fly_project` VALUES ('15', '聚心涂料', '出售涂料的app', 'v1.1', '400', '6', '2016-11-10 14:58:19', '2016-11-24 16:23:22', '0');
INSERT INTO `fly_project` VALUES ('16', '安全审计', '政府日志审查', 'V1.0', '300', '0', '2016-11-10 14:59:26', '2016-11-16 11:35:15', '0');

-- ----------------------------
-- Table structure for fly_table_info
-- ----------------------------
DROP TABLE IF EXISTS `fly_table_info`;
CREATE TABLE `fly_table_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `db_id` int(11) NOT NULL,
  `TABLE_SCHEMA` varchar(255) DEFAULT NULL,
  `TABLE_NAME` varchar(255) DEFAULT NULL,
  `COLUMN_NAME` varchar(255) DEFAULT NULL,
  `IS_NULLABLE` varchar(10) DEFAULT NULL,
  `COLUMN_TYPE` varchar(255) DEFAULT NULL,
  `COLUMN_KEY` varchar(255) DEFAULT NULL,
  `COLUMN_DEFAULT` varchar(255) DEFAULT NULL,
  `COLUMN_COMMENT` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_table_info
-- ----------------------------
INSERT INTO `fly_table_info` VALUES ('1', '1', 'flyapi_v2.0', 'fly_comments', 'user_id', 'NO', 'int(11)', null, null, '评论人', '2016-11-29 13:38:10', null, '0');
INSERT INTO `fly_table_info` VALUES ('2', '1', 'flyapi_v2.0', 'fly_interfaces', 'inter_name', 'NO', 'varchar(50)', null, null, '接口名称', '2016-11-29 13:42:52', '2016-11-29 13:42:54', '0');
INSERT INTO `fly_table_info` VALUES ('3', '1', 'flyapi_v2.0', 'fly_interfaces', 'inter_des', 'YES', 'varchar(255)', null, null, '接口描述', '2016-11-29 13:45:20', '2016-11-29 13:45:22', '0');
INSERT INTO `fly_table_info` VALUES ('4', '1', 'flyapi_v2.0', 'fly_comments', 'interface_id', 'YES', 'int(11)', null, '0', '接口id', '2016-11-29 18:02:51', '2016-11-29 18:02:53', '0');

-- ----------------------------
-- Table structure for fly_user
-- ----------------------------
DROP TABLE IF EXISTS `fly_user`;
CREATE TABLE `fly_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `sex` int(2) DEFAULT '0' COMMENT '0女1男',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `company` varchar(255) DEFAULT NULL COMMENT '公司',
  `login_ip` varchar(50) NOT NULL COMMENT '登录Ip',
  `login_count` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `create_time` datetime NOT NULL COMMENT '注册时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `name_index` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of fly_user
-- ----------------------------
INSERT INTO `fly_user` VALUES ('1', 'flyhero', 'f74f58d012532877', '/static/images/head.jpg', '1', '358681286@qq.com', null, '上海荧客', '0:0:0:0:0:0:0:1', '85', '2016-10-31 17:35:42', '2016-11-28 16:15:09', '0');
INSERT INTO `fly_user` VALUES ('2', 'admin', '49ba59abbe56e057', '/static/images/head.jpg', '1', '928815309@qq.com', null, '上海荧客', '0:0:0:0:0:0:0:1', '227', '2016-10-31 17:41:27', '2016-12-29 17:09:36', '0');

-- ----------------------------
-- Table structure for fly_user_project
-- ----------------------------
DROP TABLE IF EXISTS `fly_user_project`;
CREATE TABLE `fly_user_project` (
  `up_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `project_id` int(11) NOT NULL COMMENT '项目id',
  `is_edit` int(2) NOT NULL DEFAULT '1' COMMENT '0可读1可编辑',
  `is_creator` int(2) NOT NULL COMMENT '0非创建者1创建者',
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` int(2) NOT NULL DEFAULT '0' COMMENT '0可用1不可用',
  PRIMARY KEY (`up_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_user_project
-- ----------------------------
INSERT INTO `fly_user_project` VALUES ('1', '1', '1', '1', '1', '2016-11-04 15:26:43', '2016-11-04 15:26:46', '0');
INSERT INTO `fly_user_project` VALUES ('2', '2', '1', '0', '0', '2016-11-08 16:44:34', '2016-11-08 16:44:37', '0');
INSERT INTO `fly_user_project` VALUES ('5', '2', '11', '1', '1', '2016-11-10 14:48:44', '2016-11-16 11:45:35', '0');
INSERT INTO `fly_user_project` VALUES ('6', '2', '12', '1', '1', '2016-11-10 14:52:11', '2016-11-16 11:45:36', '1');
INSERT INTO `fly_user_project` VALUES ('9', '2', '15', '1', '1', '2016-11-10 14:58:19', '2016-11-16 11:45:37', '0');
INSERT INTO `fly_user_project` VALUES ('10', '2', '16', '1', '1', '2016-11-10 14:59:26', '2016-11-16 11:45:38', '0');
INSERT INTO `fly_user_project` VALUES ('11', '1', '11', '0', '0', '2016-11-28 14:40:38', null, '0');

-- ----------------------------
-- Table structure for fly_version_log
-- ----------------------------
DROP TABLE IF EXISTS `fly_version_log`;
CREATE TABLE `fly_version_log` (
  `version_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `version_log_content` tinytext NOT NULL,
  `version_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`version_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_version_log
-- ----------------------------
INSERT INTO `fly_version_log` VALUES ('1', '登录注册功能', '1', '2016-12-19 13:41:35', null, '0');
INSERT INTO `fly_version_log` VALUES ('2', '新建、修改项目', '1', '2016-12-19 13:42:48', null, '0');
INSERT INTO `fly_version_log` VALUES ('3', '新建、修改模块', '1', '2016-12-19 13:43:15', null, '0');
INSERT INTO `fly_version_log` VALUES ('4', '新建、修改接口', '1', '2016-12-19 13:43:40', null, '0');
INSERT INTO `fly_version_log` VALUES ('5', 'JSON格式化', '1', '2016-12-19 13:44:07', null, '0');
INSERT INTO `fly_version_log` VALUES ('6', '可编辑表格插件', '1', '2016-12-19 13:44:27', null, '0');
INSERT INTO `fly_version_log` VALUES ('7', '添加项目成员', '1', '2016-12-19 13:44:45', null, '0');

-- ----------------------------
-- Table structure for fly_web_info
-- ----------------------------
DROP TABLE IF EXISTS `fly_web_info`;
CREATE TABLE `fly_web_info` (
  `web_id` int(11) NOT NULL AUTO_INCREMENT,
  `part_name` varchar(255) DEFAULT NULL,
  `part_content` text,
  `language` varchar(10) DEFAULT NULL,
  `click_num` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `is_delete` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`web_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_web_info
-- ----------------------------
INSERT INTO `fly_web_info` VALUES ('1', '系统名称', 'flyapi接口管理系统', 'zh', '0', '2016-12-16 16:06:14', '2016-12-16 16:06:17', '0');
INSERT INTO `fly_web_info` VALUES ('2', '系统名称', 'Flyapi interface management system', 'en', '0', '2016-12-16 16:07:47', '2016-12-16 16:08:08', '0');
INSERT INTO `fly_web_info` VALUES ('3', '系统版本', 'V2.2', 'zh', '0', '2016-12-16 16:10:38', null, '0');
INSERT INTO `fly_web_info` VALUES ('4', '系统版本', 'V2.2', 'en', '0', '2016-12-16 16:11:03', null, '0');
INSERT INTO `fly_web_info` VALUES ('5', '网站图标', 'http://192.168.1.84:8080/flyapi2.2/logo.png', 'zh', '0', '2016-12-16 16:12:49', null, '0');
INSERT INTO `fly_web_info` VALUES ('6', '网站图标', 'http://192.168.1.84:8080/flyapi2.2/logo.png', 'en', '0', '2016-12-16 16:13:08', '2016-12-16 16:13:23', '0');
INSERT INTO `fly_web_info` VALUES ('7', '网站描述', '这是一个接口管理系统', 'zh', '0', '2016-12-16 16:14:26', null, '0');
INSERT INTO `fly_web_info` VALUES ('8', '网站描述', 'This is a interface management system.', 'en', '0', '2016-12-16 16:15:07', null, '0');
INSERT INTO `fly_web_info` VALUES ('9', '网站地址', 'http://www.baidu.com', 'zh', '0', '2016-12-16 16:15:51', null, '0');
INSERT INTO `fly_web_info` VALUES ('10', '网站地址', 'http://www.baidu.com', 'en', '0', '2016-12-16 16:16:01', '2016-12-16 16:16:36', '0');
INSERT INTO `fly_web_info` VALUES ('11', '联系地址', '安徽省亳州市', 'zh', '0', '2016-12-16 16:16:41', '2016-12-16 16:19:36', '0');
INSERT INTO `fly_web_info` VALUES ('12', '联系地址', '安徽省亳州市', 'en', '0', '2016-12-16 16:16:49', '2016-12-16 16:19:38', '0');
INSERT INTO `fly_web_info` VALUES ('13', '联系电话', '183****2216', 'zh', '0', '2016-12-16 16:17:09', '2016-12-16 16:19:40', '0');
INSERT INTO `fly_web_info` VALUES ('14', '联系电话', '183****2216', 'en', '0', '2016-12-16 16:17:17', '2016-12-16 16:19:43', '0');
INSERT INTO `fly_web_info` VALUES ('15', '联系邮箱', 'qfwang666@163.com', 'zh', '0', '2016-12-16 16:17:43', '2016-12-16 16:19:45', '0');
INSERT INTO `fly_web_info` VALUES ('16', '联系邮箱', 'qfwang666@163.com', 'en', '0', '2016-12-16 16:17:53', '2016-12-16 16:19:48', '0');
INSERT INTO `fly_web_info` VALUES ('17', '网站备案号', '皖ICP备160***85号-2', 'zh', '0', '2016-12-16 16:18:12', '2016-12-16 16:32:55', '0');
INSERT INTO `fly_web_info` VALUES ('18', '网站备案号', 'Anhui ICP Copy 160***85 Num - 2', 'en', '0', '2016-12-16 16:18:19', '2016-12-16 16:32:59', '0');
INSERT INTO `fly_web_info` VALUES ('19', '帮助中心', 'http://flyhero.top', 'zh', '0', '2016-12-16 16:20:45', '2016-12-16 16:21:57', '0');
INSERT INTO `fly_web_info` VALUES ('20', '帮助中心', 'http://flyhero.top', 'en', '0', '2016-12-16 16:21:05', '2016-12-16 16:22:00', '0');
INSERT INTO `fly_web_info` VALUES ('21', '常见问题', 'http://flyhero.top', 'zh', '0', '2016-12-16 16:21:21', '2016-12-16 16:22:02', '0');
INSERT INTO `fly_web_info` VALUES ('22', '常见问题', 'http://flyhero.top', 'en', '0', '2016-12-16 16:21:28', '2016-12-16 16:22:04', '0');
INSERT INTO `fly_web_info` VALUES ('23', '作者', '王清飞', 'zh', '0', '2016-12-16 16:24:34', null, '0');
INSERT INTO `fly_web_info` VALUES ('24', '作者', 'qfwang', 'en', '0', '2016-12-16 16:24:59', null, '0');
INSERT INTO `fly_web_info` VALUES ('25', '作者博客', 'http://flyhero.top', 'zh', '0', '2016-12-16 16:25:43', '2016-12-16 16:25:53', '0');
INSERT INTO `fly_web_info` VALUES ('26', '作者博客', 'http://flyhero.top', 'en', '0', '2016-12-16 16:26:06', null, '0');
INSERT INTO `fly_web_info` VALUES ('27', '著作权', 'Copyright ©2016', 'zh', '0', '2016-12-16 16:31:41', null, '0');
INSERT INTO `fly_web_info` VALUES ('28', '著作权', 'Copyright ©2016', 'en', '0', '2016-12-16 16:31:57', null, '0');

-- ----------------------------
-- View structure for findinter
-- ----------------------------
DROP VIEW IF EXISTS `findinter`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `findinter` AS select `fly_interfaces`.`interface_id` AS `interface_id`,`fly_interfaces`.`inter_name` AS `inter_name`,`fly_interfaces`.`inter_des` AS `inter_des`,`fly_interfaces`.`status` AS `status`,`fly_interfaces`.`inter_url` AS `inter_url`,`fly_interfaces`.`method` AS `method`,`fly_interfaces`.`param` AS `param`,`fly_interfaces`.`request_exam` AS `request_exam`,`fly_interfaces`.`response_param` AS `response_param`,`fly_interfaces`.`true_exam` AS `true_exam`,`fly_interfaces`.`false_exam` AS `false_exam`,`fly_interfaces`.`create_time` AS `create_time`,`fly_interfaces`.`update_time` AS `update_time`,`fly_interfaces`.`module_id` AS `module_id`,`fly_interfaces`.`creator` AS `creator`,`fly_interfaces`.`content` AS `content`,`fly_interfaces`.`is_delete` AS `is_delete` from `fly_interfaces` where (to_days(`fly_interfaces`.`create_time`) < to_days(now())) ;
