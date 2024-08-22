package com.kcc.restaurant.mapper;

import com.kcc.restaurant.domain.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
    public int createReview(Review review);
    public int deleteReview(int reviewId);
}
