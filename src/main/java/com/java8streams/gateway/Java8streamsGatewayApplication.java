package com.java8streams.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class Java8streamsGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java8streamsGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder routeLocator) {
		return routeLocator.routes().route(r -> r.path("/coapi/**").uri("http://COAPI/"))
				.route(r -> r.path("/clientApi/**").uri("http://CLIENTCONSUMERAPI/")).build();

	}

}
