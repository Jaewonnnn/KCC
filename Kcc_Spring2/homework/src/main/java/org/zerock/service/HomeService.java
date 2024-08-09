package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.User;


public interface HomeService {
	public User getUser(User user);
	public int signUp(User user);
}
