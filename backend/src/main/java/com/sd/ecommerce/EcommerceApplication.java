package com.sd.ecommerce;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sd.ecommerce.model.Product;
import com.sd.ecommerce.service.ProductService;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner( ProductService productService ) {
		return args -> {
			productService.save(new Product(1L, "Product 1", 100.00, "https://via.placeholder.com/200x100", "Description of Product 1"));
			productService.save(new Product(2L,"Product 2", 200.00, "https://via.placeholder.com/200x100", "Description of Product 2"));
		};
	}

}
