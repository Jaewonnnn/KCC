package org.zerock.mapper;

import org.zerock.domain.Users;

public interface HomeMapper {
    Users getUser(Users user);
    int signUp(Users user);
}
