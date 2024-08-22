package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Review;

public interface ReviewService {
    public int createReview(Review review);
    public int deleteReview(int reviewId);
}
