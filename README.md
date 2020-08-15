# Aube-Boot

### 简介

`Aube` 一词源自法语, 意为黎明、初期。

**Aube-Boot** 项目是一个基于Spring Boot框架的脚手架。

和他的名字一样, 该项目并不会集成大而全的功能, 而是希望提供一个初期的启动代码和编码约定。

### 快速开始

#### 步骤一: 获取代码

从`Github`获取最新代码

`git clone https://github.com/zzzzbw/aube-boot.git`

#### 步骤二: 导入并启动项目

#### 步骤三: 进一步开发

### 开发者指引

#### 版本依赖及已有功能

* JDK 1.8+

* Spring Boot 2.3.2.RELEASE

* mybatis-plus

#### 项目结构

* 项目结构: 
    * aube-bootstrap -> 项目工程, 业务代码编写
    * aube-common -> 基类模块, 存放一些公共的基类
    * aube-starter -> 三方项目starter, 当引入三方的项目时, 通常需要根据自身业务再度进行配置, 在这个项目配置后, 再在bootstrap项目引入starter工程. 

* 
    1. 为什么这么分层？为什么把common和starter当作工程分出来, 直接在bootstrap下写一个common和config包不就好了？
*
    aube-web-starter: 配置项目的一些web设置, 如全局统一异常返回, 参数日志打印等

* maven引入，如果引入第三方, 比如统一在父工程声明版本， 再在子工程使用，避免各个工程引用同一个库的不同版本

* `Response`、`BaseException`介绍、何时返回`Response`何时抛出`BaseException`

### 项目引入（已经引入的一些功能，及封装）

1. Mybatis-Plus引入

2. Swagger3引入

3. 自定义全局异常拦截, 自定义全局返回拦截, 日志拦截器, AOP日志与Interceptor日志

### 开发规范

* 枚举处理

* 时间处理

### 注意事项