package com.amalitech.nosqlblog.controller;

import com.amalitech.nosqlblog.model.Review;
import com.amalitech.nosqlblog.service.ReviewService;
import com.amalitech.nosqlblog.service.impl.ReviewServiceImpl;

public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController() {
        this.reviewService = new ReviewServiceImpl();
    }

    public Review createReview(Review review) {
        return reviewService.create(review);
    }
}
