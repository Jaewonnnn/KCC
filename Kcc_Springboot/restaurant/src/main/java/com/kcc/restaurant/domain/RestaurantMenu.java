package com.kcc.restaurant.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantMenu {
    private Integer id;
    private Integer restaurantId;
    private String name;
    private Integer price;
    private Date createdAt;
    private Date updateAt;
}
