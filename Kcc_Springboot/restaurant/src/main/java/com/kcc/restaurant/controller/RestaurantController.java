package com.kcc.restaurant.controller;

import com.kcc.restaurant.domain.Restaurant;
import com.kcc.restaurant.dto.RestaurantInformationDto;
import com.kcc.restaurant.dto.RestaurantReviewDto;
import com.kcc.restaurant.service.RestaurantService;
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
        return new ResponseEntity<List<Restaurant>>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<RestaurantInformationDto> getRestaurantById(@PathVariable int restaurantId) {
        RestaurantInformationDto info = service.findOneRestaurantInformation(restaurantId);
        return new ResponseEntity<RestaurantInformationDto>(info, HttpStatus.OK);
    }

    @PostMapping("/restaurant")
    public ResponseEntity createRestaurant(@RequestBody RestaurantInformationDto restaurant) {
        service.createRestaurant(restaurant);
        return ResponseEntity.ok(restaurant);
    }

    @PutMapping("/restaurant/{restaurantId}")
    public ResponseEntity updateRestaurant(@PathVariable int restaurantId, @RequestBody RestaurantInformationDto restaurant) {
        service.updateRestaurant(restaurantId, restaurant);
        return ResponseEntity.ok(restaurant);
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public ResponseEntity deleteRestaurant(@PathVariable int restaurantId) {
        service.deleteRestaurant(restaurantId);
        return ResponseEntity.ok(restaurantId);
    }

    @GetMapping("/restaurant/{restaurantId}/reviews")
    public ResponseEntity<RestaurantReviewDto> getRestaurantReviews(@PathVariable int restaurantId) {
        RestaurantReviewDto dto = service.getReviewAverageScore(restaurantId);

        return new ResponseEntity<RestaurantReviewDto>(dto, HttpStatus.OK);
    }
}
