package com.example.monsters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class MonstersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonstersApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(
				Arrays.asList(
						"http://localhost:4200",
						"http://monsters-env.eba-d73ppi3s.eu-west-1.elasticbeanstalk.com"
				)
		);
		corsConfiguration.setAllowedHeaders(
				Arrays.asList(
						"Origin",
						"Access-Control-Allow-Origin",
						"Content-Type",
						"Accept",
						"Authorization",
						"Origin, Accept",
						"X-Requested-With",
						"Access-Control-Request-Method",
						"Access-Control-Request-Headers"
				)
		);
		corsConfiguration.setExposedHeaders(
				Arrays.asList(
						"Origin",
						"Content-Type",
						"Accept",
						"Authorisation",
						"Access-Control-Allow-Origin",
						"Access-Control-Allow-Credentials"
				)
		);
		corsConfiguration.setExposedHeaders(
				Arrays.asList(
						"GET",
						"POST",
						"PUT",
						"DELETE",
						"OPTIONS"
				)
		);

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
