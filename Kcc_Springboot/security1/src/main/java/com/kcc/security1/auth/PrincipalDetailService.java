package com.kcc.security1.auth;

import com.kcc.security1.model.User;
import com.kcc.security1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //인증을 처리하기위한 서비스 객체
public class PrincipalDetailService implements UserDetailsService { //security는 이렇게 이루어짐

    @Autowired
    private UserRepository userRepository; //이거를 통해서 DB를 찾음

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //이 메소드가 인증을 해준다. (매우중요) -> 자동으로 username으로 넘어옴

        User user = userRepository.findByUsername(username);
        //여기서 인증완료 -> null이면 실패 -> 인증과 관련된 것은 무조건 UserDetails로 넘겨야한다.
        // 즉 username에 맞는 정보를 DB에서 가져와준다.
        //user 객체를 userDetail로 만들어줘야한다.
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new PrincipalDetail(userEntity);
        }


        return null;
    }
}
