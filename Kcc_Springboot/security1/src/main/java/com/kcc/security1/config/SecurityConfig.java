package com.kcc.security1.config;

import com.kcc.security1.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
@EnableWebSecurity // security 활성화
//@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true) //메서드 단위일때만 사용
public class SecurityConfig {

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    private static final String[] WHITE_LIST = {
            "/",
            "/common/**",
            "/WEB-INF/views/**",
            "/joinForm",
            "/join",
            "/loginForm",
            "/h2-console/**"
    };

    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder(); //password 암호화 -> 데이터 저장할때
    }


    @Bean

//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                        .requestMatchers("/common/**").permitAll()
//                        .requestMatchers("/user/**").authenticated()
//                        .requestMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
//                        .requestMatchers("/admin").access("hasRole('ROLE_ADMIN')")
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }

    //메소드단위
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable);
//        http.authorizeRequests(authorize ->
//                authorize.requestMatchers(WHITE_LIST).permitAll() //위쪽에 지정한 부분은 이동가능
//                        .requestMatchers(PathRequest.toH2Console()).permitAll() //추가
//                        .anyRequest().authenticated() //인증요구
//        )
//                .csrf(csrf -> csrf.ignoringRequestMatchers(PathRequest.toH2Console()))
//                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)) //이 두줄은 인식못하는 것을 보이게끔 해주는 역할(신경쓰지말것) -> h2 DB를 사용할때 생기는 문제로 h2 DB를 인식 못하는 것이다.
//                .formLogin(form -> form.loginPage("/loginForm") //기본 login페이지 경로를 /loginForm으로 변경
//                        .loginProcessingUrl("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/main"));
//        return http.build();
//    }

    //url단위
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
                        .defaultSuccessUrl("/main")// loginForm 경로 설정
                ).oauth2Login(oath2Login ->
                        oath2Login.loginPage("/loginForm")
                                .userInfoEndpoint(userInfoEndPoint ->
                                        userInfoEndPoint.userService(principalOauth2UserService))
                );
        return http.build();
    }


}
