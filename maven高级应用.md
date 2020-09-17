# maven高级应用

## maven基础回顾

`maven`是一个项目管理工具.

* **依赖管理**: `maven`对项目中的jar包的管理过程. 传统工程我们直接把jar包放在项目中.maven工程真正的jar包放置在仓库中,项目中只用放置jar包的坐标.
  * **仓库种类**: 本地仓库, 远程仓库(私服), 中央仓库
  * **仓库的关系**: 当我们启动一个`maven`工程时, 会通过`pom.xml`文件中的jar包坐标去本地仓库找, 默认情况下, 如果本地仓库没有对应的jar包, 工程会自动去重要仓库下载jar包到本地仓库. 如果有私服, 会优先从私服下载jar包, 如私服没有jar包, 则可以从中央仓库下载 也可以从本地上传.
  * **依赖关系**: 工程导入jar包的坐标要考虑解决jar包冲突.
    * 声明优先原则: 坐标先声明, 优先使用.
    * 直接依赖: 项目中直接导入jar包.
    * 传递依赖: 通过项目直接依赖jar包, 传递到项目中.

---

* **一键构建**: `maven`自身集成了`tomcat`插件, 可以对项目进行编译, 测试 打包, 安装, 发布等操作.
  * `maven`常用命令: `clean` , `compile`, `test`, `package`, `install`, `deploy`
  * `maven`生命周期: 清理生命周期, 默认生命周期, 站点生命周期

---

* **解决jar包冲突方式**:
  * 优先声明, 直接依赖, 传递依赖
  * **路径近者优先原则**: 直接依赖路径比传递依赖路径近, 那么最终项目导入路径近的直接依赖包.
  * **直接排除法**: 使用`<exclusions>`标签对内部的jar包进行排除.

---
### 锁定jar包版本

`maven`工程时可以分父子依赖关系, 凡是依赖别的项目后, 拿到的别的项目的依赖包, 都属于传递依赖, 为防止父子工程jar包覆盖冲突, 我们可以把项目中主要jar包的坐标锁住, 那么其他依赖该项目中, <u>**即便是有同名jar包直接依赖, 也无法覆盖**</u>.

`<dependencyManagement>`标签: 只能用于锁定jar包, 不能导入jar包

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.vsersion}</version>
        </dependency>
</dependencyManagement>
```

---

### 统一管理jar包版本

`<projecties>`标签

```xml
<properties>
    <spring.vsersion>5.0.2.RELEASE</spring.vsersion>
    <slf4j.vsersion>1.6.6</slf4j.vsersion>
    <log4j.vsesion>1.2.17</log4j.vsesion>
    <mysql.version>8.0.21</mysql.version>
    <mybatis.vsesion>3.5.0</mybatis.vsesion>
</properties>
```
---
---

## maven工程拆分和聚合

`maven`解决代码可重用和便于维护: `maven`把一个完整的项目, 分成不同的独立模块, 这些模块都有各自独立的坐标, 如果需要其中的某个模块, 直接应用该模块的坐标即可.

开发一个新项目, 优先考虑的不是dao, service, utils, domain如何编写, 而是他们是否已经存在, 如果存在则直接引用, 以上为`maven`的拆分思想.

我们可以把拆分的零散的模块聚合到一起编写一个完整的项目, 就是`maven`聚合思想.

---

### 工程和模块的区别

> 工程不等于完整的项目, 模块也不等于完整的项目, 一个完整的项目看的是代码, 代码完整则可以说是一个完整的项目和此项目是否是工程或模块没有关系.

---

**工程**: 工程天生只能使用自己的内部资源, 工程是独立的. 后天可以和其他工程和模块建立关联关系.

**模块**: 模块天生不是独立的, 模块天生是属于父工程的, 模块一旦创建, 父工程的资源都可以使用.

**父子工程**: 子模块天生继承父工程, 可以使用父工程所有资源.

**子模块**: 子模块天生是没有任何联系, 但后天可以引用依赖坐标

---

### 直接依赖\传递依赖作用域

| 直接依赖\传递依赖 | compile  | provided | runtime  | test  |
| :---------------: | :------: | :------: | :------: | :---: |
|      compile      | compile  |  `---`   | runtime  | `---` |
|     provided      | provided | provided | provided | `---` |
|      runtime      | runtime  |  `---`   | runtime  | `---` |
|       test        |   test   |  `---`   |   test   | `---` |

**注**: `---` 表示传递丢失

___

___

## maven父子工程启动方式

### 1. 父工程使用mvn tomcat7: run

### 2.父工程安装mvn install, 运行web层

### 3.本地tomcat运行

---

---

## 安装第三方jar包

需要DgroupId, DartifactId, Dversion



--安装第三方jar包到本地仓库

----进入jar包所在目录运行
mvn install:install-file -DgroupId=com.alibaba -DartifactId=fastjson -Dversion=1.1.37 -Dfile=fastjson-1.1.37.jar -Dpackaging=jar
----打开cmd直接运行
mvn install:install-file -DgroupId=com.alibaba -DartifactId=fastjson -Dversion=1.1.37 -Dpackaging=jar -Dfile=C:\my_java\授课资料\资料：maven【高级】\安装第三方jar包\fastjson-1.1.37.jar