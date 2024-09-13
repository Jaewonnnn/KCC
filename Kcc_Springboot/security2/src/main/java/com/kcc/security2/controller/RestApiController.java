package com.kcc.security2.controller;

import com.kcc.security2.model.User;
import com.kcc.security2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //view가 없기 때문에 RestController 이거 사용
@RequiredArgsConstructor
public class RestApiController {

    public final BCryptPasswordEncoder bCryptPasswordEncoder;
    public final UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "<h1>HOME</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("USER");
        userRepository.save(user);

        return "회원가입완료";
    }

    @GetMapping("/manager/mm")
    public String manager() {
        return "manager";
    }

    @GetMapping("/admin/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
}