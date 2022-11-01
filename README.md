# Spring Boot :mag_right: Actuator

## About Spring Boot and this example

[Spring Boot](https://spring.io/projects/spring-boot) allows you to create stand-alone Spring applications by embedding an application server.

It provides production-ready features like metrics or health-checks and simplifies the build configuration overall.

In this example you can check how to configure the Spring Boot actuator which will provide us out of the box metrics and health-checks.

## Technical requirements

The only requirement is that you have a running Spring Boot application. If you need some help at setting it up you can check how  [in this example](https://github.com/codewithhades/spring-boot-basic-setup).

## How to configure the actuator

To deploy the Spring Boot actuator we just need to import the dependency

````xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
````

This will automatically deploy a REST API when you start your application under

- [localhost:8080/app/actuator](http://localhost:8080/app/actuator) - _The actuator base API with a list of exposed metrics_
- [localhost:8080/app/actuator/health](http://localhost:8080/app/actuator/health) - _The specific health metric API_

You can change the actuator base path by updating your [application.properties](src/main/resources/application.properties)

````properties
management.endpoints.web.base-path=/another-actuator-base-path
````

By default, all the actuator endpoints are included (except shutdown) but not exposed. You can expose specific endpoints by updating your [application.properties](src/main/resources/application.properties)

````properties
management.endpoints.web.exposure.include=health,beans
````
or expose them all
````properties
management.endpoints.web.exposure.include=*
````
And if you  need to include the shutdown endpoint you can do so by adding
````properties
management.endpoint.shutdown.enabled=true
````
which will allow you to shut down the application by calling
````bash
curl -X POST http://localhost:8080/app/actuator/shutdown
````
I hope you found this example useful!

:coffee: May Java be with you!