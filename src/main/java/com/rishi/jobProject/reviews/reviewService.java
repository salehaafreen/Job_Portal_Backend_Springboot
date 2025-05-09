package com.rishi.jobProject.reviews;

import java.util.List;

public interface reviewService {

    List<Review> getAllReview(Long comapnyId);
    boolean addReview(long companyId, Review review);

    Review getReview(long companyId, Long reviewId);
    boolean updateReview(long companyId, Long reviewId,Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
