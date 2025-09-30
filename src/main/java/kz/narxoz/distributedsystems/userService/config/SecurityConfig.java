package kz.narxoz.distributedsystems.userService.config;

import kz.narxoz.distributedsystems.userService.converter.KeyCloakConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                                // Публичные endpoints
                                .requestMatchers("/api/public/**").permitAll()
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/user/create").permitAll()
                                .requestMatchers("/api/public/register").permitAll()
                                // Защищенные endpoints
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/user/**").authenticated()
                                .requestMatchers("/api/users/**").authenticated()
                                .anyRequest().authenticated()
                )
                .sessionManagement(
                        session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                ).oauth2ResourceServer(
                        o -> o
                                .jwt(jwtConfigurer ->
                                        jwtConfigurer.jwtAuthenticationConverter(keycloakConverter()))
                );
        return http.build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public KeyCloakConverter keycloakConverter() {
        return new KeyCloakConverter();
    }
}