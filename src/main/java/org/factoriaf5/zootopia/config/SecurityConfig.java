package org.factoriaf5.zootopia.config;

import java.util.Arrays;

import org.factoriaf5.zootopia.facades.encryptations.Base64Encoder;
import org.factoriaf5.zootopia.services.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api-endpoint}")
    String endpoint;

    JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .cors(cors -> cors.configurationSource(corsConfiguration()))
        .csrf(csrf -> csrf.disable())
        .formLogin(form -> form
            .loginProcessingUrl("/api/v1/login")
            .successHandler((req, res, auth) -> res.setStatus(HttpServletResponse.SC_OK))
            .failureHandler((req, res, ex) -> res.setStatus(HttpServletResponse.SC_UNAUTHORIZED)))
        .logout(out -> out
            .logoutUrl(endpoint + "/logout")
            .deleteCookies("JSESSIONID"))
            .authorizeHttpRequests(auth -> auth
            .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
            .requestMatchers("/api/v1/login").permitAll()
            .requestMatchers(endpoint + "/species/**").hasRole("ADMIN")
            .anyRequest().authenticated())
        
        .userDetailsService(jpaUserDetailsService)
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED));

    http.headers(header -> header.frameOptions(frame -> frame.sameOrigin()));

    return http.build();
}


    @Bean
    public CorsConfigurationSource corsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Ajusta si es necesario
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Incluye OPTIONS
        configuration.setAllowedHeaders(Arrays.asList("*")); // Permitir todos los encabezados
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    Base64Encoder base64Encoder() {
        return new Base64Encoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails admin = User.builder()
                .username("Admin")
                .password("{bcrypt}$2a$12$BJ3/svgLxyn7cLcsPXYSteK4wSVYRncL9V7dYLpKSAIE40A6rs1a6") // passsword
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
}
