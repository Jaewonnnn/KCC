package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Users;
import org.zerock.mapper.HomeMapper;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper mapper;

    @Override
    public Users getUser(Users user) {
        return mapper.getUser(user);
    }

    @Override
    public int signUp(Users user) {
        return mapper.signUp(user);
    }
}
