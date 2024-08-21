package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewMapper mapper;

    @Override
    public void createReview(Review review) {
        mapper.createReview(review);
    }

    @Override
    public void deleteReview(int reviewId) {
        mapper.deleteReview(reviewId);
    }
}
