package com.rishi.jobProject.reviews;

import com.rishi.jobProject.company.Company;
import com.rishi.jobProject.company.CompanySerivce;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements reviewService{
    private final ReviewRepository reviewRepository;
    private final CompanySerivce companySerivce;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanySerivce companySerivce) {
        this.reviewRepository = reviewRepository;
        this.companySerivce = companySerivce;
    }

    @Override
    public List<Review> getAllReview(Long comapnyId) {
        List<Review> reviews =  reviewRepository.findByCompanyId(comapnyId);
        return reviews;


    }

    @Override
    public boolean addReview(long companyId, Review review) {
        Company company = companySerivce.findComapnybyID(companyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }else {

            return false;
        }
    }

    @Override
    public Review getReview(long companyId, Long reviewId) {
       List<Review> reviews =  reviewRepository.findByCompanyId(companyId);
       return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(long companyId, Long reviewId, Review review) {
        if(companySerivce.findComapnybyID(companyId)!=null){
            review.setCompany(companySerivce.findComapnybyID(companyId));
            review.setId(reviewId);
            reviewRepository.save(review);
            return true;
        }else return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companySerivce.findComapnybyID(companyId)!=null&& reviewRepository.existsById(reviewId)){

            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companySerivce.updateCompany(company,companyId);
            reviewRepository.deleteById(reviewId);

            return true;
        }else return false;

    }
}
