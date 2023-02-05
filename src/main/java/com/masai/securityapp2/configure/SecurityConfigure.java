package com.masai.securityapp2.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigure {

	@Bean
	protected SecurityFilterChain mySecurityConfig(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/api/admin/").authenticated()
				.requestMatchers("/api/user").permitAll()).httpBasic();
		return http.build();
	}

}
