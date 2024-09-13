package com.kcc.spring_docker.controller;

import com.kcc.spring_docker.service.MemberService;
import com.kcc.spring_docker.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final MemberService memberService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Docker2!!!";
    }

    @GetMapping("/members")
    public List<MemberVO> selectAllMembers(){
        return memberService.selectAllMembers();
    }
}
