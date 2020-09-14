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

   1. `junit` - 单元测试
2. `aspectjweaver` - 切入点表达式解析
   3. `spring-aop` - 切面编程
4. `spring-context` - `spring`上下文
   5. `spring-web` - `spring`
   6. `spring-mvc` - `mvc`框架
   7. `spring-test` - `spring`测试
   8. `spring-tx` - 事务管理
   9. `spring-jdbc` - 数据库连接
   10. `mysql-connector-java` - `mysqljdbc`
   11. `servlet-api` - `servlet`jar包
   12. `jsp-api` - `jsp`jar包
   13. `jstl` - `jstl`jar包
   14. `log4j` - 日志打印
   15. `slf4j-api`, `slf4j-log4j12`
   16. `mybatis` 
   17. `mybatis-spring` - `MyBatis`整合`Spring`
   18. `c3p0` - 数据库连接池
   
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
       <version>4.12</version>
       <scope>compile</scope>
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
       <groupId>org.springframework</groupId>
       <artifactId>spring-tx</artifactId>
       <version>${spring.vsersion}</version>
     </dependency>
   
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-jdbc</artifactId>
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
       <groupId>com.mchange</groupId>
       <artifactId>c3p0</artifactId>
       <version>0.9.5.5</version>
       <type>jar</type>
     </dependency>
   
   </dependencies>
   ```

## 2.配置Spring

1. `web.xml`文件配置

   1. 配置`Spring`的监听器, 在服务器启动时加载`Spring`的配置文件

      ```xml
      <!--
      配置Spring的监听器, 默认只加载一次, 用于服务器启动时加载Spring的配置文件
      默认只加载WEB-INF目录下的applicationContext.xml文件
      -->
      <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>
      
       配置加载文件路径
      <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext.xml</param-value>
      </context-param>
      ```

2. `applicationContext.xml`文件配置

   1. 配置`MyBatis`;`Spring`可以整合`MyBatis`, 可以把`MyBatis`的配置写入`Spring`的配置文件中

      ```xml
      <!-- Spring整合Mybatis -->
      
      <!-- 配置连接池 -->
      <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
          <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
          <property name="url" value="jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC"/>
          <property name="username" value="root"/>
          <property name="password" value="Hhn004460"/>
      </bean>
      
      <!-- 配置SqlSessionFactory工厂 -->
      <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
          <property name="dataSource" ref="dataSource"/>
      </bean>
      
      <!-- 配置AccountDao接口所在包 -->
      <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
          <property name="basePackage" value="com.study.dao"/>
      </bean>
      ```

