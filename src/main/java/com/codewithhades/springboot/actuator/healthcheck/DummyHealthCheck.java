package com.codewithhades.springboot.actuator.healthcheck;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="dummyHealthCheck")
public class DummyHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("Message", "Code with Hades").build();
    }

}
