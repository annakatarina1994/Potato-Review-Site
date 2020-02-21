package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface HashtagRepository extends CrudRepository<Hashtag, Long> {

    Optional<Hashtag> findById(Long idToFind);
}
