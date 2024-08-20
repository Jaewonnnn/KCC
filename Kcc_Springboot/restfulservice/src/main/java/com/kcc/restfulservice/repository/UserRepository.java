package com.kcc.restfulservice.repository;

import com.kcc.restfulservice.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
