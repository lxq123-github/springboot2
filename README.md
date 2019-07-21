# springboot练习小项目
## 执行步骤：
1. 导入resources/sql下面的两个表order.sql，urlmgr.sql
2. 运行Springboot2Application.java文件
3. 在页面输入 http://localhost:8080/index

---
# mysql8安装步骤：  
1、下载zip安装包：  
MySQL8.0 For Windows zip包下载地址：https://dev.mysql.com/downloads/file/?id=476233，进入页面后可以不登录。后点击底部“No thanks, just start my download.”即可开始下载。

2、安装  
>> 2.1 解压zip包到安装目录  
>> 2.2 配置环境变量  
将解压文件夹下的bin路径添加到变量值中，前后以 ; 开头结尾
>> 2.3 配置初始化的my.ini文件  
`[mysqld]`  
`# 设置3306端口`  
`port=3306`  
`# 设置mysql的安装目录`  
`basedir=E:\\software\\mysql\\mysql-8.0.11-winx64   # 切记此处一定要用双斜杠\\，单斜杠我这里会出错，不过看别人的教程，有的是单斜杠。自己尝试吧`  
`# 设置mysql数据库的数据的存放目录`  
`datadir=E:\\software\\mysql\\mysql-8.0.11-winx64\\Data   # 此处同上`  
`# 允许最大连接数`  
`max_connections=200`  
`# 允许连接失败的次数。这是为了防止有人从该主机试图攻击数据库系统`  
`max_connect_errors=10`  
`# 服务端使用的字符集默认为UTF8`  
`character-set-server=utf8`  
`# 创建新表时将使用的默认存储引擎`  
`default-storage-engine=INNODB`  
`# 默认使用“mysql_native_password”插件认证`  
`default_authentication_plugin=mysql_native_password`  
`[mysql]`  
`# 设置mysql客户端默认字符集`  
`default-character-set=utf8`  
`[client]`  
`# 设置mysql客户端连接服务端时默认使用的端口`  
`port=3306`  
`default-character-set=utf8`  
注意：其中的data目录不需要创建，下一步初始化工作中会自动创建。  

3、安装mysql  
在安装时，必须以管理员身份运行cmd，否则在安装时会报错，会导致安装失败的情况  
>> 3.1 初始化数据库  
在MySQL安装目录的 bin 目录下执行命令：    
mysqld --initialize --console  
注意！执行输出结果里面有一段： [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: rI5rvf5x5G,E 其中root@localhost:后面的“rI5rvf5x5G,E”就是初始密码（不含首位空格）。在没有更改密码前，需要记住这个密码，后续登录需要用到。    
　　要是你手贱，关快了，或者没记住，那也没事，删掉初始化的 datadir 目录，再执行一遍初始化命令，又会重新生成的。当然，也可以使用安全工具，强制改密码，用什么方法，自己随意。  
参考：https://dev.mysql.com/doc/refman/8.0/en/data-directory-initialization-mysqld.html
  
>> 3.2 安装服务    
mysqld --install [服务名]    

4、更改密码  
在MySQL安装目录的 bin 目录下执行命令：    
mysql -u root -p    

在MySQL中执行命令：  

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '新密码';    

修改密码，注意命令尾的；一定要有，这是mysql的语法  

到此，安装部署就完成了。官方说测试速度MySQL8比5快两倍。  

---
# 创建spring boot工程

1. 访问https://start.spring.io/  
2. Project -> Maven Project  
   Language -> Java  
   Spring Boot -> 2.1.6  
   Project Metadata -> Group(com.example)  
                       Artifact(demo)  
3. 点击"Generate the project"按钮，生成在本地一个压缩包  
4. 将该压缩包导入IntelliJ IDEA中，spring boot工程就创建完毕了  
