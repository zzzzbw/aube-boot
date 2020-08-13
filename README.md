# Aube-Boot

### 项目介绍、结构

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