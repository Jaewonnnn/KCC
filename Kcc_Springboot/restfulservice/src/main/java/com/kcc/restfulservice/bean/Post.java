package com.kcc.restfulservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // null로 하려고 Integer타입으로 함
    private String description;

    @ManyToOne(fetch = FetchType.LAZY) // user가 여러개의 post를 가질 수 있으므로 lazy로 설정
    @JsonIgnore
    private User user;
}
