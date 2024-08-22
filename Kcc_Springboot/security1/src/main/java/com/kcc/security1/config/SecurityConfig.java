package com.kcc.security1.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] WHITE_LIST = {
            "/",
            "/common/**",
            "/WEB-INF/views/**",
            "/joinForm",
            "/join",
            "/loginForm",
            "/h2-console/**",
    };

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeRequests(authorize ->
                authorize.requestMatchers(WHITE_LIST).permitAll()
                        .requestMatchers("/manager/**").hasAnyRole("ROLE_MANAGER", "ROLE_ADMIN")
                        .requestMatchers("/admin/**").hasAnyRole("ROLE_ADMIN")
                        .requestMatchers(PathRequest.toH2Console()).permitAll()
                        .anyRequest().authenticated()
        )
                .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin(form -> form.loginPage("/loginForm")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/main")); // loginForm 경로 설정
        return http.build();
    }
}
