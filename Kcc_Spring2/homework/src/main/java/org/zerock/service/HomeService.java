package org.zerock.service;

import org.zerock.domain.Users;

public interface HomeService {
    Users getUser(Users user);
    int signUp(Users user);
}
