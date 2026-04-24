package com.eventify.eventify_service.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;


@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // 1️ Disable CSRF (because we use JWT, not session cookies)
            .csrf(csrf -> csrf.disable())

            // 2️ Make app stateless (no sessions)
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // 3️ Authorization rules
            .authorizeHttpRequests(auth -> auth
            		 .requestMatchers("/auth/**").permitAll()
            	    // Public resources
            	    .requestMatchers(
            	            "/", 
            	            "/index.html", 
            	            "/css/**", 
            	            "/js/**", 
            	            "/login.html",
            	            "/register.html",
            	            "/images/**"
            	    ).permitAll()
            	    .requestMatchers("/users/**").hasRole("ADMIN")
            	    .requestMatchers("/events/create").hasRole("ORGANIZER")
            	    .requestMatchers("/events/**")
            	        .hasAnyRole("ADMIN", "ORGANIZER", "PARTICIPANT")

            	    .anyRequest().authenticated()
            	
            )

            // 4️⃣ Disable default login forms
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // 5️⃣ Add JWT filter before default auth filter
            .addFilterBefore(jwtAuthenticationFilter,
                    UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
