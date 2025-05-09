package com.rishi.jobProject.reviews;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private reviewService reviewservice;

    public ReviewController(reviewService reviewservice) {
        this.reviewservice = reviewservice;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReview(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewservice.getAllReview(companyId), HttpStatus.OK);

    }
    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable long companyId ,@RequestBody Review review){
       boolean issave =  reviewservice.addReview(companyId,review);
       if(issave) {
           return new ResponseEntity<>("Review added succesfully", HttpStatus.OK);
       }else{
           return new ResponseEntity<>("Review not saved", HttpStatus.NOT_FOUND);

       }
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId,@PathVariable Long reviewId){
    return new ResponseEntity<>(reviewservice.getReview(companyId,reviewId),HttpStatus.OK);
    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
        boolean isReviewUpdated = reviewservice.updateReview(companyId,reviewId,review);
        if(isReviewUpdated){
            return new ResponseEntity<>("Review Updated Succesfully",HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean isReviewDeleted = reviewservice.deleteReview(companyId,reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("Review Deleted Succesfully",HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Review not found",HttpStatus.NOT_FOUND);
        }
    }


}
