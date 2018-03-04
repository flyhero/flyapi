# flyapi
## 项目简介
[![Version](https://img.shields.io/badge/license-Apache2.0-blue.svg)](https://github.com/flyhero/flyapi)

[![Version](https://img.shields.io/badge/version-1.0-green.svg)](https://github.com/flyhero/flyapi)

源于 2016年10月 接口管理系统 基于SSM+Maven的多模块项目
后因其它相关系统比较完善，遂放弃继续开发。

如今将编写多人博客系统,由于许多知名博客界面在我看来较丑，所以准备自己写一个吧。
本来要写个人博客，但感觉自己用的话，比较浪费，不如让同样喜欢这个博客的人一起使用。

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
![flyapi架构](flyapi-doc/images/login-register.png)

### 首页面


### 专题页面


### 易书页面
### 设置
### 我的消息
### 个人中心


## 待办事项To Do List
增加类似github贡献 图表，以活跃度
1. 直播文字[有弹幕]
2. 加入需求调查问卷，数据分析
3. 二维码生成器
4. 捐助榜
5. 增加招聘页
6. 在线简历页，github登录后生成贡献报告【https://github.com/ecmadao/hacknical】
7. 第三方登录【QQ，微信，github】
8. 成长图谱
9. 头像自动生成
10. 情景对话式段子（自选对话人物）

## 更新日志CHANGELOG
V1.0.1(2016/12/03 )
- 列表
- 列表2

## 交流Discussing
1. 独自开发中是否有必要写service接口？
2. 每个页面都是一个资源，可单独请求
## Contributing

We welcome feedback, bug reports, and pull requests!

For pull requests, please stick to the following guidelines:

- Add tests for any new features and bug fixes. Ideally, each PR should increase the test coverage.
- Follow the existing code style (e.g., indents). A PEP8 code linting target is included in the Makefile.
- Put a reasonable amount of comments into the code.
- Separate unrelated changes into multiple pull requests.
Please note that we need to collect a signed Contributors License Agreement from each individual developer who contributes code to this repository. Please refer to the following links:

- https://
- https://
