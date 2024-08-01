package kosa.mapper;

import kosa.model.User;

public interface UserMapper {
	int signUp(User user);
	User login(User user);
}
