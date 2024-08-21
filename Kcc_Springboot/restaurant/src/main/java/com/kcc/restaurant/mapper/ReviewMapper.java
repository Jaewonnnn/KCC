package com.kcc.restaurant.mapper;

import com.kcc.restaurant.domain.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public void createReview(Review review);
    public void deleteReview(int reviewId);
}
