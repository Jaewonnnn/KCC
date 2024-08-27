package com.kcc.security2.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.kcc.security2.config.PrincipalDetail;
import com.kcc.security2.model.User;
import com.kcc.security2.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authManager, UserRepository userRepository) {
        super(authManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {


        //        super.doFilterInternal(request, response, chain);
        System.out.println("jwt 필터 호출");

        String jwtHeader = request.getHeader("Authorization");
        System.out.println("jwtToken: " + jwtHeader);

        //JWT 토큰을 검증을 해서 정상적인 사용자인지 확인
        if (jwtHeader == null || !jwtHeader.startsWith("Bearer ")) {
            chain.doFilter(request, response);
        }

        String jwtToken = request.getHeader("Authorization").replace("Bearer ", ""); //Bearer을 없애기
        String username = JWT.require(Algorithm.HMAC512("kcc"))
                .build().verify(jwtToken).getClaim("username").asString(); //문자열로
        System.out.println("username: " + username);

        if (username != null){
            User userEntity = userRepository.findByUsername(username);
            PrincipalDetail principalDetail = new PrincipalDetail(userEntity); // PrincipalDetail 객체 만들기
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetail, null, principalDetail.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

            chain.doFilter(request, response); //반대로
        }
    }
}
