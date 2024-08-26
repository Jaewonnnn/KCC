package com.kcc.security1.oauth;

import com.kcc.security1.auth.PrincipalDetail;
import com.kcc.security1.model.User;
import com.kcc.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    //구글 인증작업 -> UserDetails를 사용하지않음 -> OAuth2User이 객체를 사용 -> PrincipalDetail사용하지 않아서 security동작안됨 -> 이걸사용할수 있게 변경

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        System.out.println("userRequest: " + userRequest);
//        System.out.println("getClientRegistation: " + userRequest); //구글로부터 뽑아온 나의 정보
//        System.out.println("getAccessToken: " + userRequest.getAccessToken()); //토큰정보
        System.out.println("getAttributes: " + super.loadUser(userRequest).getAttributes()); //그사람의 고유한 정보

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println("getAttributes(): " + oAuth2User.getAttributes()); //이정보로 회원가입
        // 구글 로그인 버튼 클릭 -> 구글 로그인 창 -> 로그인 완료 -> Access Token 요청
        // userRequest 정보 -> loadUser 함수 호출 -> 구글로부터 넘어온 회원 프로필 추출(userRequest)

        String provider = userRequest.getClientRegistration().getRegistrationId(); //google
        String providerId = oAuth2User.getAttribute("sub"); //숫자
        String username = provider + "_" + providerId; //google_숫자(고유)
        //password는 필요X
        String email = oAuth2User.getAttribute("email"); //email (실제 email이 들어감)
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);

        if(userEntity == null) {
            //회원가입
            userEntity = User.builder()
                    .username(username)
                    .password("1234")
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();

            userRepository.save(userEntity);
        }

//        return super.loadUser(userRequest);
        return new PrincipalDetail(userEntity, oAuth2User.getAttributes()); //userEntity가 user 객체
    }
}
