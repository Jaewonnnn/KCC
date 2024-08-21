package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Review;

public interface ReviewService {
    public void createReview(Review review);
    public void deleteReview(int reviewId);
}
