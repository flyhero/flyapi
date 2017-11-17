/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.22
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : flyapi

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2017-06-29 16:54:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_article
-- ----------------------------
DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `article_id` bigint(20) unsigned NOT NULL COMMENT '文章id',
  `subject_id` bigint(20) NOT NULL COMMENT '专题id',
  `user_id` bigint(20) NOT NULL,
  `title` varchar(20) NOT NULL COMMENT '标题',
  `article_des` varchar(100) NOT NULL COMMENT '摘要',
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
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0显示1删除',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';

-- ----------------------------
-- Records of cms_article
-- ----------------------------
INSERT INTO `cms_article` VALUES ('4538674455', '947541231654', '325267539200311296', 'Spring AOP详解', '1', '1', '1', '1', null, '0', '2', '0', '2017-06-22 16:15:57', '2017-06-28 11:23:50', '0', '0');
INSERT INTO `cms_article` VALUES ('4546546345', '987541231654', '325267539200311296', 'Spring MVC详解', '5', '5', '5', '5', null, '0', '0', '0', '2017-06-22 16:14:51', '2017-06-28 11:23:57', '0', '0');
INSERT INTO `cms_article` VALUES ('4567869786', '987541231654', '325267539200311296', 'Spring IOC详解', '58', '8', '8', '8', null, '0', '0', '0', '2017-06-22 16:15:06', '2017-06-28 11:24:05', '0', '0');
INSERT INTO `cms_article` VALUES ('68967867645', '987541231654', '325267539200311296', 'Spring 事务详解', '3', '3', '3', '3', null, '0', '0', '0', '2017-06-22 16:15:22', '2017-06-28 11:24:13', '0', '0');
INSERT INTO `cms_article` VALUES ('565678655545', '987541231654', '325267539200311296', 'Spring 注解详解', '456', '456', '456', '456', null, '0', '0', '0', '2017-06-22 16:14:34', '2017-06-28 11:24:26', '0', '0');
INSERT INTO `cms_article` VALUES ('4567891321654', '987541231654', '325267539200311296', '文章主题', '描述', '//upload-images.jianshu.io/upload_images/2263276-65f149645b408224?imageMogr2/auto-orient/strip|imageView2/1/w/375/h/300', '# Editor.md\r\n\r\n![](https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png)\r\n\r\n![](https://img.shields.io/github/stars/pandao/editor.md.svg) ![](https://img.shields.io/github/forks/pandao/editor.md.svg) ![](https://img.shields.io/github/tag/pandao/editor.md.svg) ![](https://img.shields.io/github/release/pandao/editor.md.svg) ![](https://img.shields.io/github/issues/pandao/editor.md.svg) ![](https://img.shields.io/bower/v/editor.md.svg)\r\n\r\n\r\n\r\n#### 标题（用底线的形式）Heading (underline)\r\n\r\nThis is an H1\r\n=============\r\n\r\nThis is an H2\r\n-------------\r\n\r\n### 字符效果和横线等\r\n                \r\n----\r\n\r\n~~删除线~~ <s>删除线（开启识别HTML标签时）</s>\r\n*斜体字*      _斜体字_\r\n**粗体**  __粗体__\r\n***粗斜体*** ___粗斜体___\r\n\r\n上标：X<sub>2</sub>，下标：O<sup>2</sup>\r\n\r\n**缩写(同HTML的abbr标签)**\r\n\r\n> 即更长的单词或短语的缩写形式，前提是开启识别HTML标签时，已默认开启\r\n\r\nThe <abbr title=\"Hyper Text Markup Language\">HTML</abbr> specification is maintained by the <abbr title=\"World Wide Web Consortium\">W3C</abbr>.\r\n\r\n### 引用 Blockquotes\r\n\r\n> 引用文本 Blockquotes\r\n\r\n引用的行内混合 Blockquotes\r\n                    \r\n> 引用：如果想要插入空白换行`即<br />标签`，在插入处先键入两个以上的空格然后回车即可，[普通链接](http://localhost/)。\r\n\r\n### 锚点与链接 Links\r\n\r\n[普通链接](http://localhost/)\r\n\r\n[普通链接带标题](http://localhost/ \"普通链接带标题\")\r\n\r\n直接链接：<https://github.com>\r\n\r\n[锚点链接][anchor-id] \r\n\r\n[anchor-id]: http://www.this-anchor-link.com/\r\n\r\n[mailto:test.test@gmail.com](mailto:test.test@gmail.com)\r\n\r\nGFM a-tail link @pandao  邮箱地址自动链接 test.test@gmail.com  www@vip.qq.com\r\n\r\n> @pandao\r\n\r\n### 多语言代码高亮 Codes\r\n\r\n#### 行内代码 Inline code\r\n\r\n执行命令：`npm install marked`\r\n\r\n#### 缩进风格\r\n\r\n即缩进四个空格，也做为实现类似 `<pre>` 预格式化文本 ( Preformatted Text ) 的功能。\r\n\r\n    <?php\r\n        echo \"Hello world!\";\r\n    ?>\r\n    \r\n预格式化文本：\r\n\r\n    | First Header  | Second Header |\r\n    | ------------- | ------------- |\r\n    | Content Cell  | Content Cell  |\r\n    | Content Cell  | Content Cell  |\r\n\r\n#### JS代码　\r\n\r\n```javascript\r\nfunction test() {\r\n	console.log(\"Hello world!\");\r\n}\r\n \r\n(function(){\r\n    var box = function() {\r\n        return box.fn.init();\r\n    };\r\n\r\n    box.prototype = box.fn = {\r\n        init : function(){\r\n            console.log(\'box.init()\');\r\n\r\n			return this;\r\n        },\r\n\r\n		add : function(str) {\r\n			alert(\"add\", str);\r\n\r\n			return this;\r\n		},\r\n\r\n		remove : function(str) {\r\n			alert(\"remove\", str);\r\n\r\n			return this;\r\n		}\r\n    };\r\n    \r\n    box.fn.init.prototype = box.fn;\r\n    \r\n    window.box =box;\r\n})();\r\n\r\nvar testBox = box();\r\ntestBox.add(\"jQuery\").remove(\"jQuery\");\r\n```\r\n\r\n#### HTML 代码 HTML codes\r\n\r\n```html\r\n<!DOCTYPE html>\r\n<html>\r\n    <head>\r\n        <mate charest=\"utf-8\" />\r\n        <meta name=\"keywords\" content=\"Editor.md, Markdown, Editor\" />\r\n        <title>Hello world!</title>\r\n        <style type=\"text/css\">\r\n            body{font-size:14px;color:#444;font-family: \"Microsoft Yahei\", Tahoma, \"Hiragino Sans GB\", Arial;background:#fff;}\r\n            ul{list-style: none;}\r\n            img{border:none;vertical-align: middle;}\r\n        </style>\r\n    </head>\r\n    <body>\r\n        <h1 class=\"text-xxl\">Hello world!</h1>\r\n        <p class=\"text-green\">Plain text</p>\r\n    </body>\r\n</html>\r\n```\r\n\r\n### 图片 Images\r\n\r\nImage:\r\n\r\n![](https://pandao.github.io/editor.md/examples/images/4.jpg)\r\n\r\n> Follow your heart.\r\n\r\n![](https://pandao.github.io/editor.md/examples/images/8.jpg)\r\n\r\n> 图为：厦门白城沙滩\r\n\r\n图片加链接 (Image + Link)：\r\n\r\n[![](https://pandao.github.io/editor.md/examples/images/7.jpg)](https://pandao.github.io/editor.md/images/7.jpg \"李健首张专辑《似水流年》封面\")\r\n\r\n> 图为：李健首张专辑《似水流年》封面\r\n                \r\n----\r\n\r\n### 列表 Lists\r\n\r\n#### 无序列表（减号）Unordered Lists (-)\r\n                \r\n- 列表一\r\n- 列表二\r\n- 列表三\r\n     \r\n#### 无序列表（星号）Unordered Lists (*)\r\n\r\n* 列表一\r\n* 列表二\r\n* 列表三\r\n\r\n#### 无序列表（加号和嵌套）Unordered Lists (+)\r\n                \r\n+ 列表一\r\n+ 列表二\r\n    + 列表二-1\r\n    + 列表二-2\r\n    + 列表二-3\r\n+ 列表三\r\n    * 列表一\r\n    * 列表二\r\n    * 列表三\r\n\r\n#### 有序列表 Ordered Lists (-)\r\n                \r\n1. 第一行\r\n2. 第二行\r\n3. 第三行\r\n\r\n#### GFM task list\r\n\r\n- [x] GFM task list 1\r\n- [x] GFM task list 2\r\n- [ ] GFM task list 3\r\n    - [ ] GFM task list 3-1\r\n    - [ ] GFM task list 3-2\r\n    - [ ] GFM task list 3-3\r\n- [ ] GFM task list 4\r\n    - [ ] GFM task list 4-1\r\n    - [ ] GFM task list 4-2\r\n                \r\n----\r\n                    \r\n### 绘制表格 Tables\r\n\r\n| 项目        | 价格   |  数量  |\r\n| --------   | -----:  | :----:  |\r\n| 计算机      | $1600   |   5     |\r\n| 手机        |   $12   |   12   |\r\n| 管线        |    $1    |  234  |\r\n                    \r\nFirst Header  | Second Header\r\n------------- | -------------\r\nContent Cell  | Content Cell\r\nContent Cell  | Content Cell \r\n\r\n| First Header  | Second Header |\r\n| ------------- | ------------- |\r\n| Content Cell  | Content Cell  |\r\n| Content Cell  | Content Cell  |\r\n\r\n| Function name | Description                    |\r\n| ------------- | ------------------------------ |\r\n| `help()`      | Display the help window.       |\r\n| `destroy()`   | **Destroy your computer!**     |\r\n\r\n| Left-Aligned  | Center Aligned  | Right Aligned |\r\n| :------------ |:---------------:| -----:|\r\n| col 3 is      | some wordy text | $1600 |\r\n| col 2 is      | centered        |   $12 |\r\n| zebra stripes | are neat        |    $1 |\r\n\r\n| Item      | Value |\r\n| --------- | -----:|\r\n| Computer  | $1600 |\r\n| Phone     |   $12 |\r\n| Pipe      |    $1 |\r\n                \r\n----\r\n\r\n#### 特殊符号 HTML Entities Codes\r\n\r\n&copy; &  &uml; &trade; &iexcl; &pound;\r\n&amp; &lt; &gt; &yen; &euro; &reg; &plusmn; &para; &sect; &brvbar; &macr; &laquo; &middot; \r\n\r\nX&sup2; Y&sup3; &frac34; &frac14;  &times;  &divide;   &raquo;\r\n\r\n18&ordm;C  &quot;  &apos;\r\n\r\n[========]\r\n\r\n### Emoji表情 :smiley:\r\n\r\n> Blockquotes :star:\r\n\r\n#### GFM task lists & Emoji & fontAwesome icon emoji & editormd logo emoji :editormd-logo-5x:\r\n\r\n- [x] :smiley: @mentions, :smiley: #refs, [links](), **formatting**, and <del>tags</del> supported :editormd-logo:;\r\n- [x] list syntax required (any unordered or ordered list supported) :editormd-logo-3x:;\r\n- [x] [ ] :smiley: this is a complete item :smiley:;\r\n- [ ] []this is an incomplete item [test link](#) :fa-star: @pandao; \r\n- [ ] [ ]this is an incomplete item :fa-star: :fa-gear:;\r\n    - [ ] :smiley: this is an incomplete item [test link](#) :fa-star: :fa-gear:;\r\n    - [ ] :smiley: this is  :fa-star: :fa-gear: an incomplete item [test link](#);\r\n \r\n#### 反斜杠 Escape\r\n\r\n\\*literal asterisks\\*\r\n\r\n[========]\r\n            \r\n### 科学公式 TeX(KaTeX)\r\n\r\n$$E=mc^2$$\r\n\r\n行内的公式$$E=mc^2$$行内的公式，行内的$$E=mc^2$$公式。\r\n\r\n$$x > y$$\r\n\r\n$$\\(\\sqrt{3x-1}+(1+x)^2\\)$$\r\n                    \r\n$$\\sin(\\alpha)^{\\theta}=\\sum_{i=0}^{n}(x^i + \\cos(f))$$\r\n\r\n多行公式：\r\n\r\n```math\r\n\\displaystyle\r\n\\left( \\sum\\_{k=1}^n a\\_k b\\_k \\right)^2\r\n\\leq\r\n\\left( \\sum\\_{k=1}^n a\\_k^2 \\right)\r\n\\left( \\sum\\_{k=1}^n b\\_k^2 \\right)\r\n```\r\n\r\n```katex\r\n\\displaystyle \r\n    \\frac{1}{\r\n        \\Bigl(\\sqrt{\\phi \\sqrt{5}}-\\phi\\Bigr) e^{\r\n        \\frac25 \\pi}} = 1+\\frac{e^{-2\\pi}} {1+\\frac{e^{-4\\pi}} {\r\n        1+\\frac{e^{-6\\pi}}\r\n        {1+\\frac{e^{-8\\pi}}\r\n         {1+\\cdots} }\r\n        } \r\n    }\r\n```\r\n\r\n```latex\r\nf(x) = \\int_{-\\infty}^\\infty\r\n    \\hat f(\\xi)\\,e^{2 \\pi i \\xi x}\r\n    \\,d\\xi\r\n```\r\n\r\n### 分页符 Page break\r\n\r\n> Print Test: Ctrl + P\r\n\r\n[========]\r\n\r\n### 绘制流程图 Flowchart\r\n\r\n```flow\r\nst=>start: 用户登陆\r\nop=>operation: 登陆操作\r\ncond=>condition: 登陆成功 Yes or No?\r\ne=>end: 进入后台\r\n\r\nst->op->cond\r\ncond(yes)->e\r\ncond(no)->op\r\n```\r\n\r\n[========]\r\n                    \r\n### 绘制序列图 Sequence Diagram\r\n                    \r\n```seq\r\nAndrew->China: Says Hello \r\nNote right of China: China thinks\\nabout it \r\nChina-->Andrew: How are you? \r\nAndrew->>China: I am good thanks!\r\n```\r\n\r\n### End', 'sdasd', null, '72', '0', '0', '2017-04-02 14:26:47', '2017-06-28 13:50:40', '0', '0');
INSERT INTO `cms_article` VALUES ('9856432654514', '987541231654', '325267539200311296', '第二篇', '阿萨德撒', '//upload-images.jianshu.io/upload_images/2263276-65f149645b408224?imageMogr2/auto-orient/strip|imageView2/1/w/375/h/300', '撒打算', ' 撒打算', null, '1', '0', '0', '2017-06-22 14:30:49', '2017-06-28 11:33:17', '0', '0');

-- ----------------------------
-- Table structure for cms_book
-- ----------------------------
DROP TABLE IF EXISTS `cms_book`;
CREATE TABLE `cms_book` (
  `book_id` bigint(20) unsigned NOT NULL COMMENT '图书id',
  `book_name` varchar(20) NOT NULL COMMENT '书名',
  `book_price` decimal(10,2) NOT NULL COMMENT '价格',
  `postage` decimal(5,2) NOT NULL COMMENT '邮费',
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
-- Records of cms_book
-- ----------------------------

-- ----------------------------
-- Table structure for cms_collect_article
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
-- Records of cms_collect_article
-- ----------------------------

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment` (
  `comment_id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `target_id` bigint(20) NOT NULL COMMENT '文章,漫等画,pk榜id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `content` longtext NOT NULL COMMENT '评论内容',
  `like_num` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `target_type` tinyint(4) NOT NULL COMMENT '1文章2漫画3pk榜等',
  `create_time` datetime NOT NULL COMMENT '发表时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0显示1删除',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of cms_comment
-- ----------------------------

-- ----------------------------
-- Table structure for cms_homepage_apply
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
-- Records of cms_homepage_apply
-- ----------------------------
INSERT INTO `cms_homepage_apply` VALUES ('86459654', '4567891321654', '1', '2017-06-22 16:21:53', '0');
INSERT INTO `cms_homepage_apply` VALUES ('654322165', '9856432654514', '1', '2017-06-08 17:00:35', '0');

-- ----------------------------
-- Table structure for cms_like
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
-- Records of cms_like
-- ----------------------------

-- ----------------------------
-- Table structure for cms_pk
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
-- Records of cms_pk
-- ----------------------------

-- ----------------------------
-- Table structure for cms_reply
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
-- Records of cms_reply
-- ----------------------------

-- ----------------------------
-- Table structure for cms_rss
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
-- Records of cms_rss
-- ----------------------------

-- ----------------------------
-- Table structure for cms_subject
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
-- Records of cms_subject
-- ----------------------------
INSERT INTO `cms_subject` VALUES ('987541231654', '325267539200311296', 'default.png', 'spring源码分析', '描述', '0', '2017-06-22 13:04:57', '0');

-- ----------------------------
-- Table structure for cms_type_log
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
-- Records of cms_type_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_info
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
-- Records of sys_info
-- ----------------------------

-- ----------------------------
-- Table structure for ucenter_fame
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
-- Records of ucenter_fame
-- ----------------------------

-- ----------------------------
-- Table structure for ucenter_log
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_log`;
CREATE TABLE `ucenter_log` (
  `log_id` bigint(20) NOT NULL COMMENT '日志id',
  `username` varchar(20) DEFAULT NULL COMMENT '用户名',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `spend_time` int(11) NOT NULL COMMENT '花费时间',
  `base_path` varchar(100) NOT NULL COMMENT '基础路径',
  `uri` varchar(100) NOT NULL COMMENT '扩展路径',
  `url` varchar(255) NOT NULL COMMENT '全路径',
  `method` varchar(10) NOT NULL COMMENT '请求方式',
  `params` varchar(255) DEFAULT NULL COMMENT '参数',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `ip` varchar(15) NOT NULL COMMENT 'ip',
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='日志表';

-- ----------------------------
-- Records of ucenter_log
-- ----------------------------

-- ----------------------------
-- Table structure for ucenter_user
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user`;
CREATE TABLE `ucenter_user` (
  `user_id` bigint(20) unsigned NOT NULL COMMENT '用户id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `nick_name` varchar(10) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0未知1男2女',
  `sign` varchar(50) DEFAULT NULL COMMENT '个性签名',
  `company` varchar(50) DEFAULT NULL COMMENT '公司',
  `country` varchar(20) DEFAULT NULL COMMENT '国家',
  `area` varchar(10) DEFAULT NULL COMMENT '地区',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `platform` varchar(10) DEFAULT 'PC' COMMENT '注册来源',
  `fame_value` int(11) NOT NULL DEFAULT '0' COMMENT '声望值',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0正常1注销',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of ucenter_user
-- ----------------------------
INSERT INTO `ucenter_user` VALUES ('1234567489', 'wang', '456789', null, null, null, null, '0', null, null, null, null, null, null, 'PC', '0', null, '2017-06-15 16:04:56', '0');
INSERT INTO `ucenter_user` VALUES ('325267539200311296', 'flyhero', '/w5pfRyhAdttKLVQf9agYg==', 'flyhero', null, null, null, '0', null, null, null, null, null, null, 'PC', '2', '2017-06-16 13:37:04', '2017-06-22 16:56:08', '0');
INSERT INTO `ucenter_user` VALUES ('329582284946538496', 'admin', '5Vfelpvq1jxREENCh0lIIw==', 'admin', null, null, null, '0', null, null, null, null, null, null, 'PC', '2', '2017-06-28 11:22:20', '2017-06-28 11:24:42', '0');

-- ----------------------------
-- Table structure for ucenter_user_auth
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
-- Records of ucenter_user_auth
-- ----------------------------

-- ----------------------------
-- Table structure for ucenter_user_fame
-- ----------------------------
DROP TABLE IF EXISTS `ucenter_user_fame`;
CREATE TABLE `ucenter_user_fame` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `score` int(11) NOT NULL COMMENT '增加的分',
  `op_type` int(11) NOT NULL COMMENT '操作类型1登录2发布3评论',
  `op_desc` varchar(100) DEFAULT NULL COMMENT '操作描述',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='声望值记录表';

-- ----------------------------
-- Records of ucenter_user_fame
-- ----------------------------
INSERT INTO `ucenter_user_fame` VALUES ('325330793708650496', '325267539200311296', '2', '1', '登录', '2017-06-19 11:22:21');
INSERT INTO `ucenter_user_fame` VALUES ('327491964440150016', '325267539200311296', '2', '1', '登录', '2017-06-22 16:56:08');
INSERT INTO `ucenter_user_fame` VALUES ('329582881208795136', '329582284946538496', '2', '1', '登录', '2017-06-28 11:24:42');

-- ----------------------------
-- Table structure for ucenter_user_relation
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
-- Records of ucenter_user_relation
-- ----------------------------

-- ----------------------------
-- Table structure for upms_admin
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
-- Records of upms_admin
-- ----------------------------

-- ----------------------------
-- Table structure for upms_admin_role
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
-- Records of upms_admin_role
-- ----------------------------

-- ----------------------------
-- Table structure for upms_permission
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
-- Records of upms_permission
-- ----------------------------

-- ----------------------------
-- Table structure for upms_role
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
-- Records of upms_role
-- ----------------------------

-- ----------------------------
-- Table structure for upms_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `upms_role_permission`;
CREATE TABLE `upms_role_permission` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `permission_id` bigint(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色权限表';

-- ----------------------------
-- Records of upms_role_permission
-- ----------------------------
