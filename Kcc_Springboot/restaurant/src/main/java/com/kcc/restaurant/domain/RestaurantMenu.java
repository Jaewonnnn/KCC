package com.kcc.restaurant.domain;

import com.kcc.restaurant.dto.RestaurantInformationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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
