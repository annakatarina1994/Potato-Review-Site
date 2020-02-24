package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Review;

import java.util.Collection;

@Repository
public interface ReviewStorage {
    Collection<Review> findAllReviews();

    void storeReview(Review review);

    Review findReviewById(Long reviewToFind);

}
