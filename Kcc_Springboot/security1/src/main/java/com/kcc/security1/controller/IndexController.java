package com.kcc.security1.controller;

import com.kcc.security1.model.User;
import com.kcc.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"", "/"})
    public String index(){
        return "index";
    }
    @GetMapping("/common")
    public @ResponseBody String common(){
        return "common";
    }

    @GetMapping("/user")
    public @ResponseBody String user(){
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
        return "manager";
    }

    @GetMapping("/loginForm")
    public String login(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public @ResponseBody String join(User user){
        System.out.println(user);
        user.setRole("ROLE_USER");

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        repository.save(user);
        return "join";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}

