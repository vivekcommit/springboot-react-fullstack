package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class BackendApplication {
	private static final Logger logger = LogManager.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		logger.debug("[WORKFLOW] Entered main() in BackendApplication");
		logger.info("Starting BackendApplication...");
		SpringApplication.run(BackendApplication.class, args);
		logger.info("BackendApplication started.");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@SuppressWarnings("null")
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				logger.debug("[WORKFLOW] Entered addCorsMappings() in BackendApplication");
				logger.info("Configuring CORS for /api/**");
				registry.addMapping("/api/**").allowedOrigins("http://localhost:3000");
			}
		};
	}
}
