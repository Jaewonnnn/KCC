package com.kcc.restfulservice.repository;

import com.kcc.restfulservice.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>{
}
