package org.zerock.mapper;

import org.zerock.domain.User;

public interface Mapper {
	public User getUser(User user);
	
	public int signUp(User user);

}
