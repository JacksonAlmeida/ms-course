package com.sunflower.hrapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableEurekaClient
@SpringBootApplication
public class HrApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrApiGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator myRoute( RouteLocatorBuilder builder) {
		return builder.routes().route(
				"hr-worker", x -> x.host("*.sunflower.com")
				.and()
				.path("/workers/**")
				.uri("lb://hr-worker")
				)
				.route(
				x -> x.path("/payments/**")
				.uri("lb://hr-payroll"))
				.route(
				x -> x.host("*.circuitbreack.com")
				.filters( f -> f.circuitBreaker(config -> config
						.setName("mycmd")
						.setFallbackUri("forward:fallback")))
				.uri("lb://hr-payroll"))
				.build();
	}

	
	@RequestMapping(value = "/fallback")
	public ResponseEntity<String> fallback(){
		String msg = "Serviço fora do Ar";
		return ResponseEntity.status(200).body(msg);
	}
	
}
