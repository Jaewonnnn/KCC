package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import com.kcc.restaurant.dto.RestaurantReviewDto;

import java.util.List;

public interface RestaurantService {
    public List<Restaurant> findAllRestaurant();
    public RestaurantInformationDto findOneRestaurantInformation(int id);
    public void createRestaurant(RestaurantInformationDto restaurant);
    public void updateRestaurant(int restaurantId, RestaurantInformationDto restaurant);
    public void deleteRestaurant(int restaurantId);
    public RestaurantReviewDto getReviewAverageScore(int restaurantId);
}
