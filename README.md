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

* mybatis-plus 3.3.2

* springfox 3.0.0

* hutool 5.3.10

#### 项目结构

```
├── aube-bootstrap -> 项目工程, 业务代码编写
├── aube-common -> 基类模块, 存放一些公共的基类
├── aube-starter -> 三方项目starter, 当引入三方的项目时, 通常需要根据自身业务再度进行配置, 在这个项目配置后, 再在bootstrap项目引入starter工程. 
    ├── aube-mybatis-plus-starter -> mybatis-plus参数配置工程
    ├── aube-swagger-starter -> swagger参数配置工程
    ├── aube-web-starter -> 配置项目的一些web设置, 如全局统一异常返回, 参数日志打印等
```


> 为什么这么分层？为什么把common和starter当作工程分出来, 直接在bootstrap下写一个common和config文件夹不就好了？
>
> 首先, 这样可以完全的把需求代码, 和公共基础代码分离. 并且不仅是代码层面的分离, 同时也是责任上的分离, 
> 如`aube-common`和`aube-starter`工程只能由Leader才能修改.
>
> 其次, 如果把基础公共代码和需求代码写在一个工程下, 一旦公司需要新建一个项目, 那么还要把这个部分项目复制粘贴到新的项目. 一旦需要修改, 就要改动所有项目的公共代码. 
> 现在分离成工程, 可以用`maven`的`deploy`方法将公共工程推到远程(或内网)仓库, 每个项目再通过`maven`引入这些依赖即可.

#### 项目引入（已经引入的一些功能，及封装）

> maven引入，如果引入第三方, 比如统一在父工程声明版本, 再在子工程使用, 如无特殊原因子工程不允许自行声明版本, 避免各个工程引用同一个库的不同版本. 如:
>
> ```xml
> <properties>
>     <mybatis-plus.version>3.3.2</mybatis-plus.version>
>     <hutool.version>5.3.10</hutool.version>
>     <springfox.version>3.0.0</springfox.version>
>     ...
> </properties>
> 
> <dependencyManagement>
>     <dependencies>
>         <dependency>
>             <groupId>io.springfox</groupId>
>             <artifactId>springfox-boot-starter</artifactId>
>             <version>${springfox.version}</version>
>         </dependency>
>         <dependency>
>             <groupId>cn.hutool</groupId>
>             <artifactId>hutool-all</artifactId>
>             <version>${hutool.version}</version>
>         </dependency>
>         <dependency>
>             <groupId>com.baomidou</groupId>
>             <artifactId>mybatis-plus-boot-starter</artifactId>
>             <version>${mybatis-plus.version}</version>
>         </dependency>
>         ...
>     </dependencies>
> </dependencyManagement>
> ```

##### Mybatis-Plus引入

> [MyBatis-Plus](https://github.com/baomidou/mybatis-plus) （简称 MP）是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。





2. Swagger3引入

3. 自定义全局异常拦截, 自定义全局返回拦截, 日志拦截器, AOP日志与Interceptor日志

### 开发规范

* `Response`、`BaseException`介绍、何时返回`Response`何时抛出`BaseException`

* 枚举处理

* 时间处理

### 注意事项