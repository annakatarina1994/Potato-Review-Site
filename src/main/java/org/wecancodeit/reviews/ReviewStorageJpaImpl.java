package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.Models.Review;

import java.util.Collection;

@Service
public class ReviewStorageJpaImpl implements ReviewStorage {

   private ReviewRepository reviewRepository;


    public ReviewStorageJpaImpl(ReviewRepository reviewRepository) {
        this.reviewRepository=reviewRepository;
    }

    @Override
    public Collection<Review> findAllReviews(){
        return (Collection<Review>) reviewRepository.findAll();
    }

    @Override
    public void storeReview(Review review){
        reviewRepository.save(review);
    }

    @Override
    public Review findReviewById(Long reviewToFind){
        return reviewRepository.findById(reviewToFind).get();
    }
}
