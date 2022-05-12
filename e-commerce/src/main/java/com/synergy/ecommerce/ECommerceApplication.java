package com.synergy.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.synergy.ecommerce.entities.Customer;
import com.synergy.ecommerce.repositories.CustomerRepository;

@SpringBootApplication
//@EnableConfigurationProperties
//@EntityScan(basePackages = {"entities"})
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository)
	{
		return args -> { Customer customer = new Customer(
				"Rustem","Aisariyev","scorus0808@gmail.com","Logan square 123",7471609097L,"pass","RustemA");
			customerRepository.save(customer);
			};
		};*/
}
