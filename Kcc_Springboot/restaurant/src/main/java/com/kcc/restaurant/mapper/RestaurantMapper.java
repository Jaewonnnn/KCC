package com.kcc.restaurant.mapper;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.domain.RestaurantMenu;
import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    public List<Restaurant> findAllRestaurant();
    public RestaurantInformationDto findOneRestaurantInformation(int id);
    public int createRestaurant(RestaurantInformationDto restaurant);
    public int createRestaurantMenu(RestaurantMenu restaurantMenu);
    public void updateRestaurantInformation(RestaurantInformationDto restaurant);
    public int deleteRestaurantAllMenu(int restaurantId);
    public int deleteRestaurant(int restaurantId);

    public float getReviewAverageScore(int restaurantId);
    public List<Review> getReviews(int restaurantId);

}
