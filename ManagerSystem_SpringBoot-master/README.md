# 基于SpringBoot框架的管理系统


### 介绍
基于**SpringBoot框架**的管理系统 _简洁版_ ；

实现 **登录** 、 **注册** 、 **增** 、 **删** 、 **改** 、 **查** ；

可继续完善增加前端、校验、其他功能等；

可作为 **SpringBoot框架** 开发练习基础模型；

 **课程设计** 、 **毕业设计** 开发基础；

任何复杂的框架都是简单的知识组合并延伸的，学好基础知识才是最重要的；

此项目简单，便于理解基本原理，为复杂的**SpringBoot框架**复杂项目的开发打下基础。




### 环境准备
开发平台：Idea 2019

数据库：MySQL 5.0.22

服务器：~~Tomcat 9.0.37~~   SpringBoot自动配置Tomcat服务器

注意：需要安装IDEA开发平台、MySQL数据库，版本不一定完全一致，做好版本适应性配置即可。



### 技术架构：

后端：SpringBoot

数据库管理：Mybatis

前端：Thymeleaf



### 项目结构

1.数据库及Java代码文件
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202251_69588e56_9956838.png "project.png")



2.前端代码及配置文件
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202304_965d86e2_9956838.png "project2.png")



3.项目启动

![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202316_49740962_9956838.png "start.png")



4.MySQL数据库
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202327_07940d13_9956838.png "mysql.png")



### 基本原理

####  **1. 相关概念** 

SpringBoot 是伴随着 Spring4.0 共同诞生的，目的是简化 spring 的配置及开发，并协助开发人员可以整体管理应用程序的配置，提供了众多开发组件，且内嵌了 web 应用容器，如 Tomcat 和 Jetty 等。目的是使开发得到简化，且能大幅提高开发人员的开发效率，为了简化Spring功能的配置我们可以引入或启动需要的Spring功能。避免开发人员过多的对框架的关注，把更多的精力与时间放在系统的业务逻辑代码中。



#### **2. SpringBoot的作用** 

SpringBoot框架，功能非常简单，便是帮助实现自动配置。SpringBoot框架的核心是自动配置。只要有相应的jar包，Spring则会帮助开发者实现自动配置，而无需像使用spring框架一样做很多配置。当默认配置不能满足要求的时候，能够用自己的配置来替换这些自动的配置类。此外，SpringBoot内嵌了web应用容器，除此之外还集成了系统监控等功能，都可以帮助快速搭建企业级的应用程序并使用。



#### **3. SpringBoot的核心功能** 

1.可以不依赖Tomcat等外部容器独立运行web项目，springboot的优点是能够以jar包的形式运行；

2.嵌入式的Servlet容器：不需要再打war包后再运行，在springboot中可以选择内嵌的tomcat、Jetty或者Undertow等容器来直接运行；

3.使pom文件配置更简化：只需要在 pom 文件中添加starter-web 依赖即可，无需引入很多依赖；

4.能够在生产环境中直接使用性能指标、健康检查和应用信息等；

5.springboot不需要任何xml文件配置而能实现所有的spring配置。



#### **4. SpringBoot的原理** 

1、使用IDEA开发工具创建一个springboot项目，主要依赖

```java
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

spring-boot-starter-web会自动引入开发过程中所需要的web模块jar包，如包含了spring-web和spring-webmvc的依赖，不需要再逐个的去导入，只需要导入一个就可以，避免遗漏或者版本问题。



2、SpringBootApplication类

```java
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@MapperScan(value = "com.mapper")  
public class ManagerSystem_SpringBoot_Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagerSystem_SpringBoot_Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ManagerSystem_SpringBoot_Application.class, args);
    }
```

面试会经常被问到Springboot的核心注解是什么？

@SpringBootApplication包含了很多注解，

其中

**@SpringBootConfiguration，**

**@EnableAutoConfiguration，**

**@ComponentScan**

三个注解尤为重要



**@SpringBootConfiguration**

源码如下：

```java
package org.springframework.boot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Configuration;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface SpringBootConfiguration {
}
```

其中@Configuration注解就是用来读取spring.factories文件

**@EnableAutoConfiguration**

而@EnableAutoConfiguration注解和@Configuration注解都具有配置的功能，那么又有什么区别？

@EnableAutoConfiguration注解使用的是自动配置机制，是自动导入，通俗的说就是在代码中自动import操作。例如，如果pom文件中配置了spring-boot-starter-web，那么他的jar包会放到类路径classpath里面，spring会自动配置tomcat和springmvc。如果不是自动配置的话，那么就需要手动配置。如果使用了自动配置以后，这些配置代码就不需要再额外的去配置了。

@Configuration的作用是如果有自动导入的话那么肯定就会有自动导出，注意，这需要该类方法中的@bean注解，可以理解为xml中的bean配置。

**@ComponentScan**

作用是告诉Spring哪个包下面的类用了这个注解，那么就会被spring自动扫描并且放入bean容器。



#### 5.SpringBoot的启动原理

SpringBoot整个启动流程分为两个步骤：

- 初始化一个SpringApplication对象

- 执行该对象的run方法。

```
package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootConfiguration
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@MapperScan(value = "com.mapper") 
public class ManagerSystem_SpringBoot_Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ManagerSystem_SpringBoot_Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ManagerSystem_SpringBoot_Application.class, args);
    }

}
```



##### 5.1SpringApplication初始化

```kotlin
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
        this.resourceLoader = resourceLoader;
        Assert.notNull(primarySources, "PrimarySources must not be null");
        this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
        this.webApplicationType = deduceWebApplicationType();
        setInitializers((Collection) getSpringFactoriesInstances(
                ApplicationContextInitializer.class));
        setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
        this.mainApplicationClass = deduceMainApplicationClass();
    }
```

可以知道初始化流程中最重要的就是通过SpringFactoriesLoader找到spring.factories文件中配置的ApplicationContextInitializer和ApplicationListener两个接口的实现类名称，以便后期构造相应的实例

- ApplicationContextInitializer的主要目的是在ConfigurableApplicationContext做refresh之前，对ConfigurableApplicationContext实例做进一步的设置或处理。

- ApplicationListener的目的是Spring框架对Java事件监听机制的一种框架实现。

  Spring Boot提供两种方式来添加自定义监听器通过

  SpringApplication.addListeners(ApplicationListener<?>... listeners)

  或者

  SpringApplication.setListeners(Collection<? extends ApplicationListener<?>> listeners)

  两个方法来添加一个或者多个自定义监听器。然后还需要开发者直接在自己的jar包的META-INF/spring.factories文件中新增配置即可：

```java
org.springframework.context.ApplicationListener = cn.moondev.listeners.xxxxListener\（自定义监听器）
```



##### 5.2SpringBoot启动流程

Spring Boot应用的整个启动流程都封装在SpringApplication.run方法中，本质上其实就是在spring的基础之上做了封装，做了大量的扩张。

```kotlin
public ConfigurableApplicationContext run(String... args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ConfigurableApplicationContext context = null;
        Collection<SpringBootExceptionReporter> exceptionReporters = new ArrayList<>();
        configureHeadlessProperty();
//1.通过SpringFactoriesLoader查找并加载所有的SpringApplicationRunListeners，通过调用
//starting()方法通知所有的SpringApplicationRunListeners：应用开始启动了
        SpringApplicationRunListeners listeners = getRunListeners(args);
        listeners.starting();
        try {
//2.创建并配置当前应用将要使用的Environment
            ApplicationArguments applicationArguments = new DefaultApplicationArguments(
                    args);
            ConfigurableEnvironment environment = prepareEnvironment(listeners,
                    applicationArguments);
            configureIgnoreBeanInfo(environment);
//3.打印banner
            Banner printedBanner = printBanner(environment);
//4.根据是否是web项目，来创建不同的ApplicationContext容器
            context = createApplicationContext();
//5.创建一系列FailureAnalyzer
            exceptionReporters = getSpringFactoriesInstances(
                    SpringBootExceptionReporter.class,
                    new Class[] { ConfigurableApplicationContext.class }, context);
//6.初始化ApplicationContext
            prepareContext(context, environment, listeners, applicationArguments,
                    printedBanner);
//7.调用ApplicationContext的refresh()方法,刷新容器
            refreshContext(context);
//8.查找当前context中是否注册有CommandLineRunner和ApplicationRunner，如果有则遍历执行它们。
            afterRefresh(context, applicationArguments);
            stopWatch.stop();
            if (this.logStartupInfo) {
                new StartupInfoLogger(this.mainApplicationClass)
                        .logStarted(getApplicationLog(), stopWatch);
            }
            listeners.started(context);
            callRunners(context, applicationArguments);
        }
        catch (Throwable ex) {
            handleRunFailure(context, listeners, exceptionReporters, ex);
            throw new IllegalStateException(ex);
        }
        listeners.running(context);
        return context;
    }
```

1.通过SpringFactoriesLoader查找并加载所有的SpringApplicationRunListeners，通过调用starting()方法通知所有的SpringApplicationRunListeners：应用开始启动。（SpringApplicationRunListeners其本质上就是一个事件发布者，在SpringBoot应用启动的不同时间点发布不同应用事件类型(ApplicationEvent)，如果有哪些事件监听者(ApplicationListener)对这些事件感兴趣，则可以接收并且处理）

 SpringApplicationRunListeners源码：

```csharp
public interface SpringApplicationRunListener {
    // 运行run方法时立即调用此方法，可以用户非常早期的初始化工作
    void starting();
    // Environment准备好后，并且ApplicationContext创建之前调用
    void environmentPrepared(ConfigurableEnvironment environment);
    // ApplicationContext创建好后立即调用
    void contextPrepared(ConfigurableApplicationContext context);
    // ApplicationContext加载完成，在refresh之前调用
    void contextLoaded(ConfigurableApplicationContext context);
    // 当run方法结束之前调用
    void finished(ConfigurableApplicationContext context, Throwable exception);
}
```

SpringApplicationRunListener只有一个实现类：EventPublishingRunListener。只会获取到一个EventPublishingRunListener的实例

starting()方法的内容：

```cpp
public void starting() {
    // 发布一个ApplicationStartedEvent
    this.initialMulticaster.multicastEvent(new ApplicationStartedEvent(this.application, this.args));
}
```



2.创建并配置当前应用将要使用的Environment，Environment用于描述应用程序当前的运行环境，其抽象了两个方面的内容：配置文件(profile)和属性(properties)，不同的环境(eg：生产环境、预发布环境)可以使用不同的配置文件，而属性则可以从配置文件、环境变量、命令行参数等来源获取。因此，当Environment准备好后，在整个应用的任何时候，都可以从Environment中获取资源。

> - 判断Environment是否存在，不存在就创建（如果是web项目就创建StandardServletEnvironment，否则创建StandardEnvironment）
> - 配置Environment：配置profile以及properties
> - 调用SpringApplicationRunListener的environmentPrepared()方法，通知事件监听者：应用的Environment已经准备好



3.打印banner（可以自定义）

4.根据是否是web项目，来创建不同的ApplicationContext容器

5.创建一系列FailureAnalyzer，创建流程依然是通过SpringFactoriesLoader获取到所有实现FailureAnalyzer接口的class，然后在创建对应的实例。FailureAnalyzer用于分析故障并提供相关诊断信息。

6.初始化ApplicationContext

- 将准备好的Environment设置给ApplicationContext
- 遍历调用所有的ApplicationContextInitializer的initialize()方法来对已经创建好的ApplicationContext进行进一步的处理
- 调用SpringApplicationRunListener的contextPrepared()方法，通知所有的监听者：ApplicationContext已经准备完毕
- 将所有的bean加载到容器中
- 调用SpringApplicationRunListener的contextLoaded()方法，通知所有的监听者：ApplicationContext已经装载完毕

7.调用ApplicationContext的refresh()方法,刷新容器

- 这里的刷新和spring中刷新原理类似，这里重点关注invokeBeanFactoryPostProcessors(beanFactory);方法，主要完成获取到所有的BeanFactoryPostProcessor来对容器做一些额外的操作，通过源可以进入到PostProcessorRegistrationDelegate类的invokeBeanFactoryPostProcessors()方法，会获取类型为BeanDefinitionRegistryPostProcessor的beanorg.springframework.context.annotation.internalConfigurationAnnotationProcessor，对应的Class为ConfigurationClassPostProcessor。ConfigurationClassPostProcessor用于解析处理各种注解，包括：@Configuration、@ComponentScan、@Import、@PropertySource、@ImportResource、@Bean。当处理@import注解的时候，就会调用EnableAutoConfigurationImportSelector.selectImports()来完成自动配置功能

8.查找当前context中是否注册有CommandLineRunner和ApplicationRunner，如果有则遍历执行它们。





### 页面展示

1.登录页面

![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202354_91a49284_9956838.png "login.png")



2.登录失败

![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202406_f3f3e491_9956838.png "loginerror.png")



3.注册页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202418_2d582a05_9956838.png "register.png")



4.注册成功

![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202429_548ff68d_9956838.png "registersuccess.png")


5.主页
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202442_416975c2_9956838.png "index.png")



6.新增页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202457_e3a03929_9956838.png "add.png")


7.删除页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202506_0a234864_9956838.png "delete.png")


8.修改页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1111/202526_4b972481_9956838.png "update.png")




### 注意

1.MySQL 版本5.0以上与8.0以上配置有些许差异，需要调整pom文件中数据库连接器版本

2.运行项目前提前配置好MySQL数据库、IDEA maven依赖库

3.本系统仅实现简单功能，仅为更好理解SpringBoot原理，需进一步完善更多功能及健壮性



### LICENSE

zjzhou



### About me

    一个爱学习、爱分享、爱交流的程序员；
    
    欢迎关注个人微信公众号【Java烂笔头】，一起交流、共同进步；


