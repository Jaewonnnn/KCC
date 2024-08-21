package com.kcc.restaurant.dto;

import com.kcc.restaurant.domain.Page;
import com.kcc.restaurant.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReviewDto {
    private float avgScore;
    private List<Review> reviews;
    private Page page;
}
