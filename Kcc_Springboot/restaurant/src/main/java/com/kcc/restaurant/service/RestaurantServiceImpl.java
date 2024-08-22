package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.domain.RestaurantMenu;
import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import com.kcc.restaurant.dto.RestaurantReviewDto;
import com.kcc.restaurant.exception.PostFailException;
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
    public RestaurantInformationDto createRestaurant(RestaurantInformationDto restaurant) {
        int createResult = mapper.createRestaurant(restaurant);
        if(createResult == 0){
            throw new PostFailException("Restaurant create failed");
        }
        for (RestaurantMenu menu : restaurant.getMenus()) {
            menu.setRestaurantId(restaurant.getId());
            int menuResult = mapper.createRestaurantMenu(menu);
             if (menuResult == 0) {
                throw new PostFailException("Menu create failed");
            }
        }
        RestaurantInformationDto newRestaurant = mapper.findOneRestaurantInformation(restaurant.getId());
        return newRestaurant;
    }

    @Override
    public int updateRestaurant(int restaurantId, RestaurantInformationDto restaurant) throws Exception {
        restaurant.setId(restaurantId);
        int deleteResult = mapper.deleteRestaurantAllMenu(restaurantId);
        if(deleteResult == 0){
            throw new Exception("Menu delete failed");
        }
        mapper.updateRestaurantInformation(restaurant);
        for (RestaurantMenu menu : restaurant.getMenus()) {
            menu.setRestaurantId(restaurantId);
            int createResult = mapper.createRestaurantMenu(menu);
            if(createResult == 0){
                throw new Exception("Menu create failed");
            }
        }
        return deleteResult;
    }

    @Override
    public int deleteRestaurant(int restaurantId) throws Exception {
        int deleteResult = mapper.deleteRestaurantAllMenu(restaurantId);

        return mapper.deleteRestaurant(restaurantId);
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
