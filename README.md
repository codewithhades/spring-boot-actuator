# Spring Boot :mag_right: Actuator

## About Spring Boot and this example

[Spring Boot](https://spring.io/projects/spring-boot) allows you to create stand-alone Spring applications by embedding an application server.

It provides production-ready features like metrics or health-checks and simplifies the build configuration overall.

In this example you can check how to configure the Spring Boot actuator which will provide us out of the box metrics and health-checks.

## Technical requirements

The only requirement is that you have a running Spring Boot application. If you need some help at setting it up you can check how  [in this example](https://github.com/codewithhades/spring-boot-basic-setup).

## How to deploy the actuator

To deploy the Spring Boot actuator we just need to import the dependency

````xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
````

This will automatically deploy a REST API when you start your application under

- [localhost:8080/app/actuator](http://localhost:8080/app/actuator) - _The actuator base path API with a list of exposed endpoints_
- [localhost:8080/app/actuator/health](http://localhost:8080/app/actuator/health) - _The health check endpoint_

## How to configure the actuator

We can adapt our actuator by updating our [application.properties](src/main/resources/application.properties) and override the properties in order to

- Change the actuator base path
    ````properties
    management.endpoints.web.base-path=/another-actuator-base-path
    ````
- Expose specific endpoint. By default, all the actuator endpoints are included (except shutdown) but not exposed
    ````properties
    management.endpoints.web.exposure.include=beans,metrics
    ````
  which you can check by browsing
  - [localhost:8080/app/actuator/beans](http://localhost:8080/app/actuator/beans)
  - [localhost:8080/app/actuator/metrics](http://localhost:8080/app/actuator/metrics)

- Expose all endpoints
    ````properties
    management.endpoints.web.exposure.include=*
    ````

- Include the shutdown endpoint by overriding
    ````properties
    management.endpoint.shutdown.enabled=true
    ````
  which will allow you to shut down the application by calling
    ````bash
    curl -X POST http://localhost:8080/app/actuator/shutdown
    ````

- Extend the health check endpoint by logging more details or adding more components into it such as the [DummyHealthCheck.java](src/main/java/com/codewithhades/springboot/actuator/healthcheck/DummyHealthCheck.java). These will be exposed under [localhost:8080/app/actuator/health/custom](http://localhost:8080/app/actuator/health/custom) if we also override
    ````properties
    management.endpoint.health.group.custom.show-components=always
    management.endpoint.health.group.custom.show-details=always
    ````

## And before you go...

:pray: I hope you find this example useful and if you want to support me in my mission to help our fellow Java developers please consider starring and sponsoring this space!

:coffee: May Java be with you!