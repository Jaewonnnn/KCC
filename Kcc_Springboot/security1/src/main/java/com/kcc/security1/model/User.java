package com.kcc.security1.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Table(name="user2")
@NoArgsConstructor //넣을것
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String role; //ROLE_USER, ROLE_ADMIN

    private String provider; //구글
    private String providerId; //구글

    @CreationTimestamp
    //INSERT 쿼리가 발생할 때, 현재 시간을 값으로 채워서 쿼리를 생성
    //UpdateTimestamp도 존재
    private Timestamp created;

    @Builder //반드시 넣을것
    public User(String username, String password, String email, String role, String provider, String providerId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}
