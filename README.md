# SSM整合

## 1. 搭建整合环境

1. 整合说明: SSM整合可以使用多种方式, 一般选择XML + 注解的方式

2. 整合的思路:

   1. 先搭建整合的环境
   2. 先把`Spring`的配置搭建完成
   3. 再使用`Spring`整合`SpringMVC`框架
   4. 最后使用`Spring`整合`MyBatis`框架

3. 创建数据库和表结构

   ```sql
   CREATE DATABASE ssm;
   use ssm;
   CREATE TABLE account(
   	id INT PRIMARY KEY auto_increment,
   	name VARCHAR(20),
   	money DOUBLE
   );
   ```

4. 导入`pom`坐标

   ```xml
     <properties>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
       <spring.vsersion>5.0.2.RELEASE</spring.vsersion>
       <slf4j.vsersion>1.6.6</slf4j.vsersion>
       <log4j.vsesion>1.2.12</log4j.vsesion>
       <mysql.version>8.0.21</mysql.version>
       <mybatis.vsesion>3.5.0</mybatis.vsesion>
     </properties>
   
     <dependencies>
   
       <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>4.11</version>
         <scope>test</scope>
       </dependency>
   
       <dependency>
         <groupId>org.aspectj</groupId>
         <artifactId>aspectjweaver</artifactId>
         <version>1.6.8</version>
       </dependency>
   
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-aop</artifactId>
         <version>${spring.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-context</artifactId>
         <version>${spring.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-web</artifactId>
         <version>${spring.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-webmvc</artifactId>
         <version>${spring.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-test</artifactId>
         <version>${spring.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>${mysql.version}</version>
       </dependency>
   
       <dependency>
         <groupId>javax.servlet</groupId>
         <artifactId>servlet-api</artifactId>
         <version>2.5</version>
         <scope>provided</scope>
       </dependency>
   
       <dependency>
         <groupId>javax.servlet.jsp</groupId>
         <artifactId>jsp-api</artifactId>
         <version>2.0</version>
         <scope>provided</scope>
       </dependency>
   
       <dependency>
         <groupId>jstl</groupId>
         <artifactId>jstl</artifactId>
         <version>1.2</version>
       </dependency>
   
       <dependency>
         <groupId>log4j</groupId>
         <artifactId>log4j</artifactId>
         <version>${log4j.vsesion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.slf4j</groupId>
         <artifactId>slf4j-api</artifactId>
         <version>${slf4j.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.slf4j</groupId>
         <artifactId>slf4j-log4j12</artifactId>
         <version>${slf4j.vsersion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis</artifactId>
         <version>${mybatis.vsesion}</version>
       </dependency>
   
       <dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis-spring</artifactId>
         <version>1.3.0</version>
       </dependency>
   
       <dependency>
         <groupId>c3p0</groupId>
         <artifactId>c3p0</artifactId>
         <version>0.9.1.2</version>
         <type>jar</type>
       </dependency>
       
     </dependencies>
   ```