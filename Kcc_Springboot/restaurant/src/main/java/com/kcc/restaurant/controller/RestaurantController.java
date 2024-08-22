package com.kcc.restaurant.controller;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import com.kcc.restaurant.dto.RestaurantReviewDto;
import com.kcc.restaurant.exception.RestaurantNotFoundException;
import com.kcc.restaurant.exception.ReviewNotFoundException;
import com.kcc.restaurant.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {
    private final RestaurantService service;

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> getRestaurant() {
        log.info("getRestaurant called");
        List<Restaurant> restaurants = service.findAllRestaurant();
        if(restaurants == null){
            throw new RestaurantNotFoundException("Restaurant not found");
        }
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<RestaurantInformationDto> getRestaurantById(@PathVariable int restaurantId) {
        RestaurantInformationDto info = service.findOneRestaurantInformation(restaurantId);
        if (info == null) {
            throw new RestaurantNotFoundException("Restaurant not found");
        }
        return new ResponseEntity<RestaurantInformationDto>(info, HttpStatus.OK);
    }

    @PostMapping("/restaurant")
    public ResponseEntity createRestaurant(@Valid @RequestBody RestaurantInformationDto restaurant) {
        RestaurantInformationDto newRestaurant = service.createRestaurant(restaurant);

        return ResponseEntity.ok(newRestaurant);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public ResponseEntity updateRestaurant(@PathVariable int restaurantId, @RequestBody RestaurantInformationDto restaurant) throws Exception {
        int updateResult = service.updateRestaurant(restaurantId, restaurant);
        if(service.findOneRestaurantInformation(restaurantId) == null){
            throw new RestaurantNotFoundException("Restaurant not found");
        }
        return ResponseEntity.ok(restaurant);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity deleteRestaurant(@PathVariable int restaurantId) throws Exception {
        int deleteResult = service.deleteRestaurant(restaurantId);
        if(service.findOneRestaurantInformation(restaurantId) == null || deleteResult == 0){
            throw new RestaurantNotFoundException("Restaurant not found");
        }
        return ResponseEntity.ok(restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ResponseEntity<RestaurantReviewDto> getRestaurantReviews(@PathVariable int restaurantId) {
        RestaurantReviewDto dto = service.getReviewAverageScore(restaurantId);
        if(service.findOneRestaurantInformation(restaurantId) == null){
            throw new RestaurantNotFoundException("Restaurant not found");
        }else if(dto == null){
            throw new ReviewNotFoundException("Review not found");
        }
        return new ResponseEntity<RestaurantReviewDto>(dto, HttpStatus.OK);
    }
}
