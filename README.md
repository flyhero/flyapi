# flyapi
## 项目简介
![flyapi](flyapi-doc/images/flyapi-logo.png)

[![Version](https://img.shields.io/badge/license-Apache2.0-blue.svg)](https://github.com/flyhero/flyapi)

[![Version](https://img.shields.io/badge/version-1.0-green.svg)](https://github.com/flyhero/flyapi)

源于 2016年10月 接口管理系统 基于SSM+Maven的多模块项目
后因其它相关系统比较完善，遂放弃继续开发。

如今将编写多人博客系统,由于许多知名博客界面在我看来较丑，所以准备自己写一个吧。
本来要写个人博客，但感觉自己用的话，比较浪费，不如让同样喜欢这个博客的人一起使用。

这个项目并不优秀，反而存在许多问题，诸如：参数校验不完整，异常未合理抛出，api设计不规范等

## 目录Contents

## 快速入门Quick start
## 项目地址
Github: https://github.com/flyhero/flyapi


## 技术与架构 Technology And Architecture
### 架构图
![flyapi架构](flyapi-doc/images/flyapi-architecture.png)
### 技术选择
#### 后端

- 核心框架：Spring Framework 4.1.7
- 视图框架：Spring MVC 4.1.7
- 持久层框架：MyBatis 3.2.6
- 任务调度：Spring + Quartz 2.2.2
- 分页插件：Mybatis-PageHelper 4.0.0
- 数据库：MySql 5.6
- 数据库连接池：Alibaba Druid 1.0.9
- 日志管理：SLF4J 1.7.7、Log4j2
- 即时消息：Spring WebSocket
- 消息队列： Apache ActiveMQ
- 校验框架：FluentValidator

#### 前端

- JS框架：jQuery 1.9
- UI风格：layUI 2
- 客户端验证：Bootstrap-Validator
- 数据表格：Bootstrap-table
- 日期控件： My97DatePicker
- 弹层组件：layer2.4
- 数据可视化：echarts 3
- markdown编辑器: editor.md
- 弹幕插件：jquery.barrager.js

### 项目结构
``` lua
flyapi
├── flyapi-admin -- 管理端
├── flyapi-core -- 核心模块
├── flyapi-dao -- 数据库操作和实体类
├── flyapi-doc -- 开发过程中的文档，软件说明等
├── flyapi-service -- 业务逻辑实现层
├── flyapi-service-api -- 业务逻辑接口层
└── flyapi-web -- 控制器
```

## 配置Configuration
### 注意
- 当静态资源服务器变化时需要修改 editormd.js中102，103行库和插件的位置

## 环境搭建
    本人是在mac下开发的，若在win下使用，自行修改
    - 安装mysql server 5.6+ ,导入flyapi_*.sql文件
    - 安装tomcat 7+ ,端口设为8090

    IDEA
    
    - 安装maven
### host 设置
127.0.0.1	www.iflyapi.cn
## 演示地址
http://  用户名：   密码：

## 演示界面 Screenshots
### 登录注册页面
![flyapi架构](flyapi-doc/images/login.png)

### 首页面


### 主题页面

### 设置

### 个人中心


## 待办事项


## 交流Discussing
1. 独自开发中是否有必要写service接口？
2. 每个页面都是一个资源，可单独请求
3. 前端接收18位数字id时，四舍五入了？
> 整数（不使用小数点或指数计数法）最多为 15 位。
  小数的最大位数是 17，但是浮点运算并不总是 100% 准确,怎么解决呢？
  
## Contributing

我们欢迎反馈，缺陷报告和提交请求！


对于提交请求，请坚持下面的方针：



## 版权声明
本软件使用 Apache License 2.0 协议，请严格遵照协议内容：


- [功能描述]：主要描述一下这个项目的主要功能列表。
- [开发环境]：罗列使用本工程项目所需要安装的开发环境及配置，以及所需软件的版本说明和对应的下载链接。
- [项目结构简介]：简单介绍项目模块结构目录树，对用户可以修改的文件做重点说明。
- [测试DEMO]：此处可以简单介绍一下DEMO程序的思路，具体实现代码放在example文件夹中。
- [作者列表]：对于多人合作的项目，可以在这里简单介绍并感谢所有参与开发的研发人员。
- [更新链接]：提供后续更新的代码链接。
- [历史版本]：对历史版本更改 记录做个简单的罗列，让用户直观的了解到哪些版本解决了哪些问题。
- [联系方式]：可以提供微信、邮箱等联系方式，其他人对这个工程不明白的地方可以通过该联系方式与你联系。