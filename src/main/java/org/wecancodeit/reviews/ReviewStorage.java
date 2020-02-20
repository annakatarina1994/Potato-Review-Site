package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ReviewStorage {
    Collection<Review> findAllReviews();

    void storeReview(Review review);

    Review findReviewById(String reviewToFind);

}
