package com.kcc.restaurant.controller;

import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping("/review")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        int createResult = service.createReview(review);
        if(createResult == 1) {

        }
        return new ResponseEntity<String>("created", HttpStatus.OK);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId) throws Exception {
        int deleteResult = service.deleteReview(reviewId);
        if(deleteResult == 0){
            throw new Exception("Review remove faild");
        }else {
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }
    }


}
