package org.wecancodeit.reviews;

import java.util.Collection;

public interface ReviewStorage {
    Collection<Review> findAllReviews();

    void storeReview(Review review);

    Review findReviewById(Long reviewToFind);

}
