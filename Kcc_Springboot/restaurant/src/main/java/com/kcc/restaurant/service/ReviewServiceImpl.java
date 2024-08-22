package com.kcc.restaurant.service;

import com.kcc.restaurant.domain.Review;
import com.kcc.restaurant.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private static final Logger log = LoggerFactory.getLogger(ReviewServiceImpl.class);
    private final ReviewMapper mapper;

    @Override
    public int createReview(Review review) {
        int result = mapper.createReview(review);
        log.info("result = {}", Integer.toString(result));
        return result;
    }

    @Override
    public int deleteReview(int reviewId) {
        return mapper.deleteReview(reviewId);
    }
}
