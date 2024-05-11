package com.uber.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class CustomsecurityConfiguration {

	// For multiple users we can go with UserDetails Service
	// Static credentials InMemoryUserDetailsManager

	
/*	@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails userDetails = User.withUsername("Imran").password(passwordEncoder().encode("immu@123")).build();
		UserDetails userDetails2 = User.withUsername("Rasheed").password(passwordEncoder().encode("rashee@123")).build();
		UserDetails userDetails3 = User.withUsername("Rasool").password(passwordEncoder().encode("rasool@123")).build();

		return new InMemoryUserDetailsManager(userDetails, userDetails2, userDetails3);

	} */
	
	
	// By WithDefaultPasswordEncoder can be deprecated so spring introduced BCryptPasswordEncoder 
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain FilterChain(HttpSecurity httpSecurity) throws Exception {

		// For only one user static credentials

		/*
		 * httpSecurity.authorizeHttpRequests().requestMatchers("/testAPIOne",
		 * "testAPITwo").authenticated();
		 * httpSecurity.authorizeHttpRequests().requestMatchers("/testAPIThree",
		 * "testAPIFour").permitAll();
		 * 
		 * 
		 * httpSecurity.authorizeHttpRequests().requestMatchers("/saveUber").denyAll();
		 * 
		 * httpSecurity.formLogin(); return httpSecurity.build();
		 */

	/*	return httpSecurity
				
				//By default csrf token can be enabled
				//By disable the csrf token
				//.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						authorize -> authorize.requestMatchers("/**").authenticated()
								.requestMatchers("/testAPIThree").permitAll().requestMatchers("/restAPIFour").denyAll())
				.formLogin(Customizer.withDefaults()).build();

	} */
		
		//These are for Custom Credentials
		
		return httpSecurity
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/home").authenticated()
						.anyRequest().permitAll()
						)
				//.formLogin(Customizer.withDefaults())
				.formLogin(login -> login.loginPage("/login")
						.defaultSuccessUrl("/home")
						.failureUrl("/login?loginFailed=true")
						)
				// Logout functinality
				.logout(logout -> 
				logout.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
						
						)
				.build();
		

	}
}
