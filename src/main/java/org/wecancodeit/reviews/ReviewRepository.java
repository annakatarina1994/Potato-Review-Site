package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
Optional<Review> findByReviewName(String reviewToFind);

}
