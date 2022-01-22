package com.hassnain.wsapigateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){

        return builder.routes()
                .route(p -> p
                                .path("/users/**")
                                .filters(f-> f
                                        .addRequestHeader("Hello", "world")
                                        .removeRequestHeader("postman-token")
                                        )
                                .uri("http://localhost:8080")
                        )
                .build();

    }
}
