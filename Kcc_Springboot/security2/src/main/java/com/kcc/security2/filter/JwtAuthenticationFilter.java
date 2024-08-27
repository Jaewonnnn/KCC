package com.kcc.security2.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcc.security2.config.PrincipalDetail;
import com.kcc.security2.model.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("attemptAuthentication 호출");

        //1. username, password 받기
        try {
            ObjectMapper om = new ObjectMapper(); //json데이터 파싱
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            //2. PrincipalDetailService loadUserByUsername() 호출
            Authentication authentication = authenticationManager.authenticate(authenticationToken); //인증 준비 작업

            //3. PrincipalDetail
            PrincipalDetail principalDetail= (PrincipalDetail) authentication.getPrincipal(); //캐스팅 해줄것
            // -> PrincipaDetail로 리턴
            System.out.println("principalDetail: " + principalDetail);

            return authentication; //??

        }catch (Exception e) {
            e.printStackTrace();
        }

//        return super.attemptAuthentication(request, response);
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        System.out.println("로그인 성공");

        //로그인 성공 -> JWT Token 생성, 전송
        PrincipalDetail principalDetail = (PrincipalDetail) authResult.getPrincipal(); //인증정보 얻어오기

        String jwtToken = JWT.create()
                .withSubject("kosaToken")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60000*10)))
                .withClaim("id", principalDetail.getUser().getId())
                .withClaim("username", principalDetail.getUser().getUsername()) //id보다 username이 중요
                .sign(Algorithm.HMAC512("kcc")); //가장 중요하다.

        response.addHeader("Authorization", "Bearer " + jwtToken); //Bearer 옆에는 반드시 한 칸을 띄울 것

    }
}
