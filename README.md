# 众帮管家项目开发介绍

开发框架为SSH(Struts2.3 + Spring4.3 + hibernate5.2)

## 开发环境

框架搭建环境:
* MyEclipse 2017 CI 3
* JDK1.8.0.121
* Tomcat 8.0
* MySQL 5.6.35

## 开发框架介绍

#### 数据库

数据库配置文件在src/db.properties中，根据自己电脑上的环境进行数据库的配置

#### 包介绍

所有的实现都在com.linestore.dao.impl包下

## 注意事项

* hql语句中表名应该是ORM映射的类名，而不是数据库中的表名

* 注意数据库配置文件中（db.properties）不能含有空格

* 域名跳转时时在Struts.xml result中添加type属性可进行请求转发与域名重定向

  重定向：<result name="success" type="redirect">admin/index.jsp</result>

  请求转发：<result name="success" type="request">admin/index.jsp</result>

## 

Copyright 2017-2018 ZButler众帮管家.
