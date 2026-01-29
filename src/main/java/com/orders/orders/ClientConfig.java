package com.orders.orders;

import com.orders.orders.Clients.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "user-service", types = UserClient.class)
public class ClientConfig {

    @Bean
    public RestClientHttpServiceGroupConfigurer userClientConfigurer() {
        return groups -> groups.filterByName("user-service")
                .forEachClient((group, builder) -> {
                    // Correct method for Spring Boot 4.0
                    builder.baseUrl("http://localhost:8081");
                    builder.defaultHeader("Content-Type", "application/json");
                    builder.defaultHeader("Accept", "application/json");
                });
    }
}
