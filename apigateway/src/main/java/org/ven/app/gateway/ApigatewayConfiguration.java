package org.ven.app.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApigatewayConfiguration {
	
	@Bean
	public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("employeemicroservice",r->r.path("/api/employee/**").uri("http://localhost:8081"))
				.route("departmentmicroservice",r->r.path("/api/depart/**").uri("http://localhost:8080"))
				.build();
	}

}
