package org.RestWithJWT.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(antMatcher("/h2-console/**")).permitAll() // 🛠 Use antMatcher explicitly
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // 🛠 Needed for H2 Console
                .formLogin(withDefaults());

        return http.build();
    }
}
