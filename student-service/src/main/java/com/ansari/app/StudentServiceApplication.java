package com.ansari.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan({"com.ansari.controller", "com.ansari.service"})
@EntityScan("com.ansari.entity")
@EnableJpaRepositories("com.ansari.repository")
@EnableFeignClients("com.ansari.feignclients")
@EnableEurekaClient
public class StudentServiceApplication {
	
	@Value("${address.service.url}")
	private String addressServiceUrl;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
	/*
	@Bean
	public WebClient webClient () {
		WebClient webClient =WebClient.builder()
				.baseUrl(addressServiceUrl).build();
		
		return webClient;
	}
	*/

}
