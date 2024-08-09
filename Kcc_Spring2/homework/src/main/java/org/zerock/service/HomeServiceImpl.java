package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.User;
import org.zerock.mapper.Mapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HomeServiceImpl implements HomeService {
	
	private Mapper mapper;
	
	@Override
	public User getUser(User user) {
		
		return mapper.getUser(user);
	}

	@Override
	public int signUp(User user) {
		if(mapper.signUp(user) == 1) {
			return 1;
		}else {
			return 0;
		}	
	}
}
