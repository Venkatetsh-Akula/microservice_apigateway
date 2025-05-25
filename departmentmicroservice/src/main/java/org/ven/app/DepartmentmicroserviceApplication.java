package org.ven.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DepartmentmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentmicroserviceApplication.class, args);
	}

}
