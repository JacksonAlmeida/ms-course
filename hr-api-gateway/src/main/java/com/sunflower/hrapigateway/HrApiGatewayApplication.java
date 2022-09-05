package com.sunflower.hrapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import io.netty.handler.codec.http.HttpMethod;

@EnableEurekaClient
@SpringBootApplication
public class HrApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoute( RouteLocatorBuilder builder) {
		return builder.routes().route(
				x -> x.host("*.sunflower.com")
				.and()
				.path("/workers/**")
				.uri("http://localhost:8001")
				)
				.route(
				x -> x.path("/payments/**")
				.uri("http://localhost:61932"))
				.route(
				x -> x.host("*.circuitbreack.com")
				.filters( f -> f.circuitBreaker(config -> config
						.setName("mycmd")
						.setFallbackUri("forward:fallback")))
				.uri("http://localhost:61932"))
				.build();
	}

	
	@RequestMapping(value = "/fallback")
	public ResponseEntity<String> fallback(){
		String msg = "Serviço fora do Ar";
		return ResponseEntity.status(200).body(msg);
	}
	
}
