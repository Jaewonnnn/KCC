package com.kcc.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Integer id;
    private Integer restaurantId;
    private String content;
    private Integer score;
    private Date createdAt;
}
