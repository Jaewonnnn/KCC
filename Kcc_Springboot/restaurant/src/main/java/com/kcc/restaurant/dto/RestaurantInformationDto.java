package com.kcc.restaurant.dto;

import com.kcc.restaurant.domain.RestaurantMenu;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantInformationDto {
    private Integer id;
    private String name;
    private String address;
    private Date createdAt;
    private Date updateAt;
    private List<RestaurantMenu> menus;
}
