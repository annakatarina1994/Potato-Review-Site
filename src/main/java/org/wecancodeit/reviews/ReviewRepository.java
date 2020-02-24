package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.Models.Review;

import java.util.Optional;

public interface ReviewRepository extends CrudRepository<Review, Long> {
Optional<Review> findById(Long reviewToFind);

}
