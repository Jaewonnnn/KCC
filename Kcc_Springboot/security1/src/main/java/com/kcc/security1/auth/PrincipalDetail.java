package com.kcc.security1.auth;

import com.kcc.security1.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
public class PrincipalDetail implements UserDetails, OAuth2User {
    // 즉 UserDetails을 user에 넣는 과정이다.

    private User user;
    private Map<String, Object> attributes;

    //일반 로그인
    public PrincipalDetail(User user) {
        this.user = user; //user객체 추가

    }

    //OAuth 로그인(구글)
    public PrincipalDetail(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { //권한을 담기때문에 가장 중요
        //리턴 요구하는 타입대로 리턴해야함 -> 그래야만 security가 동작(그냥외워)
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override //필요없음
    public String getName() {
        return "";
    }
}
