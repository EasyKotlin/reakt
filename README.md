# React.js  集成 Kotlin Spring Boot 开发 Web 应用实例详解

> Reakt , an example of using React.js  集成 Kotlin Spring Boot 开发 Web 应用实例


![image.png](http://upload-images.jianshu.io/upload_images/1233356-26fb99ae56602d38.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![image.png](http://upload-images.jianshu.io/upload_images/1233356-9cd9497e9e4d24a4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


项目工程目录
```
~/easykotlin/reakt$ tree
.
├── build
│   ├── kotlin
│   │   ├── compileKotlin
│   │   └── compileTestKotlin
│   └── kotlin-build
│       └── version.txt
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── reakt.iml
├── reakt.ipr
├── reakt.iws
├── reakt_main.iml
├── reakt_test.iml
└── src
    ├── main
    │   ├── java
    │   ├── kotlin
    │   │   └── com
    │   │       └── easykotlin
    │   │           └── reakt
    │   │               └── ReaktApplication.kt
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    └── test
        ├── java
        ├── kotlin
        │   └── com
        │       └── easykotlin
        │           └── reakt
        │               └── ReaktApplicationTests.kt
        └── resources

24 directories, 14 files

```










build.gradle

```groovy
buildscript {
	ext {
		kotlinVersion = '1.2.0'
		springBootVersion = '2.0.0.M7'
	}
	repositories {
		mavenCentral()
		maven { url "https://repo.spring.io/snapshot" }
		maven { url "https://repo.spring.io/milestone" }
	}
	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}")
		classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
	}
}

apply plugin: 'kotlin'
apply plugin: 'kotlin-spring'
apply plugin: 'eclipse'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

group = 'com.easykotlin'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = 1.8
compileKotlin {
	kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
	kotlinOptions.jvmTarget = "1.8"
}

repositories {
	mavenCentral()
	maven { url "https://repo.spring.io/snapshot" }
	maven { url "https://repo.spring.io/milestone" }
}


dependencies {
	compile('org.springframework.boot:spring-boot-starter-actuator')
	compile('org.springframework.boot:spring-boot-starter-data-jpa')
	compile('org.springframework.boot:spring-boot-starter-freemarker')
	compile('org.springframework.boot:spring-boot-starter-security')
	compile('org.springframework.boot:spring-boot-starter-web')
	compile("org.jetbrains.kotlin:kotlin-stdlib-jre8:${kotlinVersion}")
	compile("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
	runtime('mysql:mysql-connector-java')
	testCompile('org.springframework.boot:spring-boot-starter-test')
	testCompile('org.springframework.security:spring-security-test')
}

```

ReaktApplication.kt

```kotlin
package com.easykotlin.reakt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReaktApplication

fun main(args: Array<String>) {
    runApplication<ReaktApplication>(*args)
}

```


后端工程目录

```
~/easykotlin/reakt$ tree
.
├── LICENSE
├── README.md
├── build
│   ├── kotlin
│   │   ├── compileKotlin
│   │   └── compileTestKotlin
│   └── kotlin-build
│       └── version.txt
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── out
│   └── production
│       ├── classes
│       │   ├── META-INF
│       │   │   └── reakt_main.kotlin_module
│       │   └── com
│       │       └── easykotlin
│       │           └── reakt
│       │               ├── ReaktApplication.class
│       │               ├── ReaktApplicationKt$main$1$$special$$inlined$bean$1.class
│       │               ├── ReaktApplicationKt$main$1$$special$$inlined$bean$2$1$lambda$1.class
│       │               ├── ReaktApplicationKt$main$1$$special$$inlined$bean$2$1.class
│       │               ├── ReaktApplicationKt$main$1$$special$$inlined$bean$2$2$lambda$1.class
│       │               ├── ReaktApplicationKt$main$1$$special$$inlined$bean$2$2.class
│       │               ├── ReaktApplicationKt$main$1$$special$$inlined$bean$2.class
│       │               ├── ReaktApplicationKt$main$1.class
│       │               ├── ReaktApplicationKt.class
│       │               ├── WebSecurityConfig.class
│       │               ├── advice
│       │               │   └── GlobalExceptionHandlerAdvice.class
│       │               ├── controller
│       │               │   ├── ApiController.class
│       │               │   ├── LoginController.class
│       │               │   └── RouterController.class
│       │               ├── dao
│       │               │   ├── RoleDao.class
│       │               │   └── UserDao.class
│       │               ├── entity
│       │               │   ├── Role.class
│       │               │   └── User.class
│       │               ├── handler
│       │               │   ├── ControllerTools.class
│       │               │   └── MyAccessDeniedHandler.class
│       │               └── service
│       │                   └── MyUserDetailService.class
│       └── resources
│           ├── application-daily.properties
│           ├── application-dev.properties
│           ├── application-prod.properties
│           ├── application.properties
│           └── logback-spring.xml
├── reakt.iml
├── reakt.ipr
├── reakt.iws
├── reakt_main.iml
├── reakt_test.iml
└── src
    ├── main
    │   ├── java
    │   ├── kotlin
    │   │   └── com
    │   │       └── easykotlin
    │   │           └── reakt
    │   │               ├── ReaktApplication.kt
    │   │               ├── advice
    │   │               │   └── GlobalExceptionHandlerAdvice.kt
    │   │               ├── controller
    │   │               │   ├── ApiController.kt
    │   │               │   ├── LoginController.kt
    │   │               │   └── RouterController.kt
    │   │               ├── dao
    │   │               │   ├── RoleDao.kt
    │   │               │   └── UserDao.kt
    │   │               ├── entity
    │   │               │   ├── Role.kt
    │   │               │   └── User.kt
    │   │               ├── handler
    │   │               │   └── MyAccessDeniedHandler.kt
    │   │               ├── security
    │   │               │   └── WebSecurityConfig.kt
    │   │               └── service
    │   │                   └── MyUserDetailService.kt
    │   └── resources
    │       ├── application-daily.properties
    │       ├── application-dev.properties
    │       ├── application-prod.properties
    │       ├── application.properties
    │       ├── logback-spring.xml
    │       ├── static
    │       └── templates
    └── test
        ├── java
        ├── kotlin
        │   └── com
        │       └── easykotlin
        │           └── reakt
        │               └── ReaktApplicationTests.kt
        └── resources

45 directories, 58 files

```

前端Node React 工程部分:

使用 $ nowa init web 命令创建前端 web 工程:

![image.png](http://upload-images.jianshu.io/upload_images/1233356-13c660b76e8a5a4a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


```
~/easykotlin/reakt/front$ nowa init web

Welcome to nowa project generator!
I will use this template to generate your project:
https://github.com/nowa-webpack/template-uxcore/archive/v5.zip
May I ask you some questions?

? Project name reakt
? Project description An awesome project
? Author name jack
? Project version 1.0.0
? Project homepage 
? Project repository 
? Npm registry https://registry.npm.taobao.org
? Do you want SPA feature? Yes
? Do you want i18n feature? (Y/n) Y



Start to copy files ...

Generate file .editorconfig
Generate file .eslintignore
Generate file .eslintrc.json
Generate file .gitignore
Generate file abc.json
Generate file html/index.html
Generate file mock/user/query.js
Generate file package.json
Generate file src/app/app.js
Generate file src/app/app.less
Generate file src/app/db.js
Generate file src/app/routes.jsx
Generate file src/app/util.js
Generate file src/app/variables.js
Generate file src/components/search-data/index.js
Generate file src/components/search-data/SearchData.jsx
Generate file src/components/search-word/index.js
Generate file src/components/search-word/SearchWord.jsx
Generate file src/i18n/en.js
Generate file src/i18n/index.js
Generate file src/i18n/zh-cn.js
Generate file src/images/README.md
Generate file src/pages/demo/index.js
Generate file src/pages/demo/logic.js
Generate file src/pages/demo/PageDemo.jsx
Generate file src/pages/demo/PageDemo.less
Generate file src/pages/error/index.js
Generate file src/pages/error/PageError.jsx
Generate file src/pages/error/PageError.less
Generate file src/pages/home/index.js
Generate file src/pages/home/logic.js
Generate file src/pages/home/PageHome.jsx
Generate file src/pages/home/PageHome.less
Generate file webpack.config.js
npm notice created a lockfile as package-lock.json. You should commit this file.
npm WARN uxcore-layout@1.0.5 requires a peer of react@>=0.13.0 but none is installed. You must install peer dependencies yourself.
npm WARN uxcore-button@0.3.12 requires a peer of react@>=0.13.0 but none is installed. You must install peer dependencies yourself.
npm WARN uxcore-button@0.3.12 requires a peer of react@>=0.13.0 but none is installed. You must install peer dependencies yourself.
npm WARN uxcore-button@0.3.12 requires a peer of react@>=0.13.0 but none is installed. You must install peer dependencies yourself.
npm WARN uxcore-transfer@0.3.10 requires a peer of react@>=0.13.0 but none is installed. You must install peer dependencies yourself.
npm WARN react-slick@0.14.8 requires a peer of react@^0.14.0 || ^15.0.1 but none is installed. You must install peer dependencies yourself.
npm WARN react-slick@0.14.8 requires a peer of react-dom@^0.14.0 || ^15.0.1 but none is installed. You must install peer dependencies yourself.
npm WARN enzyme@2.9.1 requires a peer of react@0.13.x || 0.14.x || ^15.0.0-0 || 15.x but none is installed. You must install peer dependencies yourself.
npm WARN react-test-renderer@15.6.2 requires a peer of react@^15.6.2 but none is installed. You must install peer dependencies yourself.
npm WARN react-hammerjs@0.5.0 requires a peer of react@^0.14.3 || ^15.0.0 but none is installed. You must install peer dependencies yourself.

added 249 packages in 15.628s
```


设置 JavaScript 的版本是 ES6

![image.png](http://upload-images.jianshu.io/upload_images/1233356-3bac4bac5a306a87.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



前端工程

![image.png](http://upload-images.jianshu.io/upload_images/1233356-fa79b6bfe5d81204.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```
~/easykotlin/reakt/front$ nowa server
Listening at http://192.168.0.104:3000
```

![image.png](http://upload-images.jianshu.io/upload_images/1233356-0a25aeb42c5970cb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


```
~/easykotlin/reakt/front$ nowa server
Listening at http://192.168.0.104:3000
webpack built 77b5a8beed9790822bea in 12869ms
Hash: 77b5a8beed9790822bea
Version: webpack 1.13.3
Time: 12869ms
           Asset     Size  Chunks             Chunk Names
    app-zh-cn.js  1.98 MB       0  [emitted]  app
 1.home-zh-cn.js   641 kB       1  [emitted]  home
 2.demo-zh-cn.js   641 kB       2  [emitted]  demo
3.error-zh-cn.js   540 kB       3  [emitted]  error
webpack: bundle is now VALID.

```


nowa build 之后的默认输出目录在 dist 下面. 我们下面写一个构建脚本,分别拷贝这些 js,css,html 到 Spring Boot 工程的 resource 目录下面:


![image.png](http://upload-images.jianshu.io/upload_images/1233356-7e20e0591689bf40.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


reakt.sh

```shell
#!/usr/bin/env bash
#build front js,css,html
cd ./front
nowa build
cd ../
#cp js,css,html to /templates, /static
kotlinc -script reakt.kts
#gradle bootRun
gradle bootRun

```


reakt.kts

```kotlin
import java.io.File
import java.io.FileFilter

val srcPath = File("./front/dist/")

val templatesPath = "src/main/resources/templates/"
val jsFile = "src/main/resources/static/js/"
val cssPath = "src/main/resources/static/css/"

val templatesDir = File("src/main/resources/templates/")
val cssDir = File("src/main/resources/static/css/")
val jsDir = File("src/main/resources/static/js/")

if (!templatesDir.exists()) templatesDir.mkdirs()
if (!cssDir.exists()) cssDir.mkdirs()
if (!jsDir.exists()) jsDir.mkdirs()

srcPath.listFiles().forEach {
    val fileName = it.name
    when {
        fileName.endsWith(".html") -> {
            println("Copy file: $fileName")

            val htmlFile = File("$templatesPath$fileName")
            it.copyTo(target = htmlFile, overwrite = true)
            replaceJsCssSrc(htmlFile)
        }
        fileName.endsWith(".js") -> {
            println("Copy file: $fileName")
            it.copyTo(target = File("$jsFile$fileName"), overwrite = true)
        }
        fileName.endsWith(".css") -> {
            println("Copy file: $fileName")
            it.copyTo(target = File("$cssPath$fileName"), overwrite = true)
        }
    }
}




fun replaceJsCssSrc(htmlFile: File) {
    val oldJsSrc = """<script src="/"""
    val oldJsSrcParticular = """<script src="//"""
    val newJsSrc = """<script src="/js/"""

    val oldCssSrc = """<link rel="stylesheet" href="/"""
    val newCssSrc = """<link rel="stylesheet" href="/css/"""

    var lines = StringBuilder()
    htmlFile.readLines().forEach {
        var line = it
        if (line.contains(oldJsSrc) && !line.contains(oldJsSrcParticular)) {
            line = line.replace(oldJsSrc, newJsSrc)
        } else if (line.contains(oldCssSrc)) {
            line = line.replace(oldCssSrc, newCssSrc)
        }

        lines.append(line + "\n")
    }

    htmlFile.writeText(lines.toString())
}

```

![image.png](http://upload-images.jianshu.io/upload_images/1233356-906664e2c22dc448.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


![image.png](http://upload-images.jianshu.io/upload_images/1233356-f09edb2bd05252a5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



logback-spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <springProperty scope="context"
                    name="logging.file"
                    source="logging.file"/>

    <springProperty scope="context"
                    name="logging.path"
                    source="logging.path"/>

    <springProperty scope="context"
                    name="logging.level.root"
                    source="logging.level.root"/>

    <springProperty scope="context"
                    name="spring.application.name"
                    source="spring.application.name"/>

    <springProperty scope="context"
                    name="logging.file.max-size"
                    source="logging.file.max-size"/>

    <springProperty scope="context"
                    name="logging.file.max-history"
                    source="logging.file.max-history"/>

    <property name="LOG_FILE"
              value="${logging.path:-.}/${logging.file:-${spring.application.name:-spring}.log}"/>


    <property name="MAX_SIZE"
              value="${logging.file.max-size:-10MB}"/>


    <property name="MAX_HISTORY"
              value="${logging.file.max-history:-0}"/>


    <conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter"/>
    <conversionRule conversionWord="wex"
                    converterClass="org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter"/>
    <conversionRule conversionWord="wEx"
                    converterClass="org.springframework.boot.logging.logback.ExtendedWhitespaceThrowableProxyConverter"/>

    <property name="CONSOLE_LOG_PATTERN"
              value="${CONSOLE_LOG_PATTERN:-%clr(%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}}){faint} %clr(${LOG_LEVEL_PATTERN:-%5p}) %clr(${PID:- }){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>
    <property name="FILE_LOG_PATTERN"
              value="${FILE_LOG_PATTERN:-%d{${LOG_DATEFORMAT_PATTERN:-yyyy-MM-dd HH:mm:ss.SSS}} ${LOG_LEVEL_PATTERN:-%5p} ${PID:- } --- [%t] %-40.40logger{39} : %m%n${LOG_EXCEPTION_CONVERSION_WORD:-%wEx}}"/>

    <logger name="org.apache.catalina.startup.DigesterFactory" level="ERROR"/>
    <logger name="org.apache.catalina.util.LifecycleBase" level="ERROR"/>
    <logger name="org.apache.coyote.http11.Http11NioProtocol" level="WARN"/>
    <logger name="org.apache.sshd.common.util.SecurityUtils" level="WARN"/>
    <logger name="org.apache.tomcat.util.net.NioSelectorPool" level="WARN"/>
    <logger name="org.eclipse.jetty.util.component.AbstractLifeCycle" level="ERROR"/>
    <logger name="org.hibernate.validator.internal.util.Version" level="WARN"/>

    <!-- show parameters for hibernate sql 专为 Hibernate 定制 -->
    <logger name="org.hibernate.type.descriptor.sql.BasicBinder" level="TRACE"/>
    <logger name="org.hibernate.type.descriptor.sql.BasicExtractor" level="DEBUG"/>
    <logger name="org.hibernate.SQL" level="DEBUG"/>
    <logger name="org.hibernate.engine.QueryParameters" level="DEBUG"/>
    <logger name="org.hibernate.engine.query.HQLQueryPlan" level="DEBUG"/>

    <!--myibatis log configure-->
    <logger name="com.apache.ibatis" level="TRACE"/>
    <logger name="java.sql.Connection" level="DEBUG"/>
    <logger name="java.sql.Statement" level="DEBUG"/>
    <logger name="java.sql.PreparedStatement" level="DEBUG"/>

    <!--<include resource="org/springframework/boot/logging/logback/base.xml"/>-->

    <appender name="FILE"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>${FILE_LOG_PATTERN}</pattern>
        </encoder>
        <file>${LOG_FILE}</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy">
            <fileNamePattern>${LOG_FILE}.%d{yyyy-MM-dd}.%i.gz</fileNamePattern>
            <maxFileSize>${MAX_SIZE}</maxFileSize>
            <maxHistory>${MAX_HISTORY}</maxHistory>
        </rollingPolicy>
    </appender>

    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>${CONSOLE_LOG_PATTERN}</pattern>
            <charset>utf8</charset>
        </encoder>
    </appender>

    <root level="${logging.level.root}">
        <appender-ref ref="CONSOLE"/>
        <appender-ref ref="FILE"/>
    </root>
</configuration>

```

application-dev.properties

```
spring.application.name=reakt
server.port=8004
#mysql
spring.datasource.url=jdbc:mysql://localhost:3306/reakt?useUnicode=true&characterEncoding=UTF8&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driverClassName=com.mysql.jdbc.Driver
# Specify the DBMS
spring.jpa.database=MYSQL
# Show or not log for each sql query
spring.jpa.show-sql=true
# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto=create-drop
#spring.jpa.hibernate.ddl-auto=update
# stripped before adding them to the entity manager)
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
#logging
logging.level.root=info
logging.level.org.springframework.web=info
logging.path=${user.home}/logs
#logging.file=${spring.application.name}.log
#logging.exception-conversion-word=
#logging.pattern.console=
#logging.pattern.file=
logging.file.max-history=30
logging.file.max-size=2MB
#logging.pattern.level=
#logging.pattern.dateformat=
#Freemarker
# template-loader-path, comma-separated list
#spring.freemarker.template-loader-path=classpath:/reakt/dist/
spring.freemarker.template-loader-path=classpath:/templates/
# suffix
spring.freemarker.suffix=.html
# static resources path pattern, default is root path: /** , 浏览器请求路径,会映射到spring.resources.static-locations
#spring.mvc.static-path-pattern=/reakt/dist/**
# if config this key, will overwrite the default Spring Boot Config
#spring.resources.static-locations=classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/,classpath:/reakt/dist/
#management
management.endpoints.web.enabled=true
management.endpoints.enabled-by-default=true
management.endpoints.web.base-path=/actuator
management.health.db.enabled=true
management.endpoint.health.enabled=true
management.endpoint.metrics.enabled=true
management.endpoint.mappings.enabled=true
management.endpoint.info.enabled=true
management.endpoint.beans.enabled=true
management.endpoint.env.enabled=true
management.endpoint.health.show-details=true
management.endpoint.logfile.enabled=true
management.endpoint.scheduledtasks.enabled=true
management.endpoint.sessions.enabled=true
management.health.diskspace.enabled=true
management.info.git.enabled=true

```


# 工程源代码

完整的工程源代码(感觉有所帮助的, 顺手点个 Star 哦 !):

https://github.com/EasyKotlin/reakt



# 参考文章

React.js and Spring Data REST: 

https://spring.io/guides/tutorials/react-and-spring-data-rest/

Kotlin 使用命令行执行 kts 脚本: http://www.jianshu.com/p/5848fbb73227

http://start.spring.io/




