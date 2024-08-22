package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import com.kcc.restaurant.dto.RestaurantReviewDto;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> findAllRestaurant();
    public RestaurantInformationDto findOneRestaurantInformation(int id);
    public RestaurantInformationDto createRestaurant(RestaurantInformationDto restaurant);
    public int updateRestaurant(int restaurantId, RestaurantInformationDto restaurant) throws Exception;
    public int deleteRestaurant(int restaurantId) throws Exception;
    public RestaurantReviewDto getReviewAverageScore(int restaurantId);
}
