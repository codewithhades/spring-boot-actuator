# Spring Boot :mag_right: Actuators

## About Spring Boot and this example

[Spring Boot](https://spring.io/projects/spring-boot) allows you to create stand-alone Spring applications by embedding an application server.

It provides production-ready features like metrics or health-checks and simplifies the build configuration overall.

In this example you can check how to configure Spring Boot actuators that will provide us out of the box metrics and health-checks.

## Technical requirements

The only requirement is that you have a running Spring Boot application. If you need some help at setting it up you can check how  [in this example](https://github.com/codewithhades/spring-boot-basic-setup).

## How to configure actuators

To deploy the Spring Boot actuators we just need to import the dependency

````xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
````

This will automatically deploy a REST API when you start your application under

- [localhost:8080/app/actuator](http://localhost:8080/app/actuator/health) - _The actuator base API_
- [localhost:8080/app/actuator/health](http://localhost:8080/app/actuator/health) - _The health API_

I hope you found this example useful!

:coffee: May Java be with you!