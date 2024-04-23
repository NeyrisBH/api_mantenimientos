package com.cccmant.api_mantenimientos;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
public class ApiMantenimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMantenimientosApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig {

		@SuppressWarnings("deprecation")
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests(authorizeRequests -> authorizeRequests
						.requestMatchers(HttpMethod.POST, "/api/token").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/v1/tecnicos").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/v1/usuarios").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/v1/ubicaciones").hasAuthority("Admin")
						.anyRequest().authenticated())
				.csrf(csrf -> csrf.disable())
				.cors(Customizer.withDefaults());
		}

		@Bean
		public CorsConfigurationSource configurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
			configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "PUT", "DELETE", "HEAD"));
			configuration.setExposedHeaders(Arrays.asList("Authorization"));
			configuration.setAllowedOrigins(Arrays.asList("*"));

			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
	}
}
