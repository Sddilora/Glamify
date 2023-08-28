package com.sd.ecommerce;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.sd.ecommerce.dto.ProductCategoryDTO;
import com.sd.ecommerce.dto.ProductDTO;
import com.sd.ecommerce.dto.Mapper.ProductCategoryMapper;
import com.sd.ecommerce.model.Discount;
import com.sd.ecommerce.model.ProductCategory;
import com.sd.ecommerce.model.ProductInventory;
import com.sd.ecommerce.service.ProductCategoryService;
import com.sd.ecommerce.service.ProductService;

@SpringBootApplication
public class EcommerceApplication {

	private final ProductCategoryMapper productCategoryMapper;

	public EcommerceApplication(ProductCategoryMapper productCategoryMapper) { // This is a constructor injection. We are injecting the ProductCategoryMapper bean into this class.
        this.productCategoryMapper = productCategoryMapper;
    }

	ProductCategoryDTO productCategory = new ProductCategoryDTO(null,null,null,false,"Category 1", "Description of Category 1");
	ProductCategoryDTO productCategory2 = new ProductCategoryDTO(null,null,null,false,"Category 2", "Description of Category 2");

	ProductInventory productInventory = new ProductInventory(10);
	ProductInventory productInventory2 = new ProductInventory(20);

	Discount discount = new Discount("Discount 1", "Description of Discount 1", 10, true);
	Discount discount2 = new Discount("Discount 2", "Description of Discount 2", 20, false);


	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner( ProductService productService , ProductCategoryService productCategoryService) { 
		return args -> {
			ProductCategory savedCategory1 = productCategoryMapper.convertToEntity(productCategoryService.save(productCategory));
			ProductCategory savedCategory2 = productCategoryMapper.convertToEntity(productCategoryService.save(productCategory2));
			productService.save(new ProductDTO("Product 1", 100.00, "https://via.placeholder.com/200x100", "Description of Product 1", "SKU-1", savedCategory1, null, null ));
			productService.save(new ProductDTO("Product 2",200.00, "https://via.placeholder.com/200x100", "Description of Product 2", "SKU-2" , savedCategory2, null , null));
		};
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
