package org.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"org.springboard"})
public class ServiceProviderSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderSvcApplication.class, args);
	}

}
