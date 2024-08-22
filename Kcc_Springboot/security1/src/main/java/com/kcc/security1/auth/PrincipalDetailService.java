package com.kcc.security1.auth;

import com.kcc.security1.model.User;
import com.kcc.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// authentication을 처리하기 위한 service
public class PrincipalDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    // 반드시 Overriding해줘야 함
    @Override
    // jsp의 name= "username"이 매개변수로(username) 넘어옴
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            return new PrincipalDetail(userEntity);
        }
        return null;
    }
}
