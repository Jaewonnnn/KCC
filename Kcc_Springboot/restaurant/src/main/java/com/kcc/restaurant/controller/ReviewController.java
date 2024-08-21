package com.kcc.restaurant.controller;

import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping("/review")
    public ResponseEntity createReview(@RequestBody Review review) {
        service.createReview(review);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity deleteReview(@PathVariable int reviewId) {
        service.deleteReview(reviewId);

        return ResponseEntity.ok().build();
    }


}
