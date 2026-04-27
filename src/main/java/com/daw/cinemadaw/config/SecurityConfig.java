package com.daw.cinemadaw.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

         http
        // CSRF only disabled for H2 console (dev tool)
        .csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/**")
        )

        // Only same-origin iframes allowed (prevents clickjacking)
        .headers(headers -> headers
            .frameOptions(frame -> frame.sameOrigin())
        )

        // Configuració d'autoritzacions
        .authorizeHttpRequests(auth -> auth

            .requestMatchers("/h2-console/**").hasRole("ADMIN")
            .requestMatchers("/login", "/logout", "/register").permitAll()
            .requestMatchers("/cookies/**").permitAll()
            .requestMatchers("/css/**", "/images/**", "/favicon.svg").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/client/**", "/session/**").hasAnyRole("CLIENT", "ADMIN")
        
            .anyRequest().authenticated()
        )

        // Configuració del formulari de login
        .formLogin(form -> form
            .loginPage("/login") // pàgina personalitzada de login
            .successHandler(new CustomLoginSuccessHandler()) // redirecció segons rol
            .permitAll()
        )

        // Configuració del logout
        .logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        );

        return http.build();
    }

    // Bean per encriptar contrasenyes amb BCrypt
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}