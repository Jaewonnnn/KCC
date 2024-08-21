package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.domain.RestaurantMenu;
import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import com.kcc.restaurant.dto.RestaurantReviewDto;
import com.kcc.restaurant.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantMapper mapper;

    @Override
    public List<Restaurant> findAllRestaurant() {

        return mapper.findAllRestaurant();
    }

    @Override
    public RestaurantInformationDto findOneRestaurantInformation(int id) {

        return mapper.findOneRestaurantInformation(id);
    }

    @Override
    public void createRestaurant(RestaurantInformationDto restaurant) {
        int restaurantResult = mapper.createRestaurant(restaurant);
        for (RestaurantMenu menu : restaurant.getMenus()) {
            menu.setRestaurantId(restaurant.getId());
            int menuResult = mapper.createRestaurantMenu(menu);
        }
    }

    @Override
    public void updateRestaurant(int restaurantId, RestaurantInformationDto restaurant) {
        restaurant.setId(restaurantId);
        mapper.deleteRestaurantAllMenu(restaurantId);
        mapper.updateRestaurantInformation(restaurant);
        for (RestaurantMenu menu : restaurant.getMenus()) {
            menu.setRestaurantId(restaurantId);
            mapper.createRestaurantMenu(menu);
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        mapper.deleteRestaurantAllMenu(restaurantId);
        mapper.deleteRestaurant(restaurantId);
    }

    @Override
    public RestaurantReviewDto getReviewAverageScore(int restaurantId) {
        RestaurantReviewDto dto = new RestaurantReviewDto();
        float avgScore = mapper.getReviewAverageScore(restaurantId);
        dto.setAvgScore(avgScore);
        List<Review> reviews = mapper.getReviews(restaurantId);
        dto.setReviews(reviews);

        return dto;

    }
}
