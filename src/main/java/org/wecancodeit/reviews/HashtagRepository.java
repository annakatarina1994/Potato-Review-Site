package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface HashtagRepository extends CrudRepository<Hashtag, Long> {

    Optional<Hashtag> findById(Long idToFind);
}
