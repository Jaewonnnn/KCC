package com.kcc.spring_docker.service;

import com.kcc.spring_docker.mapper.MemberMapper;
import com.kcc.spring_docker.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<MemberVO> selectAllMembers(){
        return memberMapper.selectAllMembers();
    }
}
