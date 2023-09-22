package com.api.config;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.cors.CorsConfiguration;
	import org.springframework.web.cors.CorsConfigurationSource;
	import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

	@Configuration
	public class Config {

	    @Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.addAllowedOrigin("*"); // Replace with the allowed origin(s) you want to permit

	        // Add more CORS settings as needed, e.g., allowed methods, headers, etc.
	        configuration.addAllowedMethod("GET");
	        configuration.addAllowedMethod("POST");
	        configuration.addAllowedHeader("Authorization");
	        configuration.addAllowedHeader("Content-Type");

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);

	        return source;
	    }
	}
	

