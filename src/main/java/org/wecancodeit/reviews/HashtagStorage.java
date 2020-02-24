package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;

import java.util.Collection;

public interface HashtagStorage {
    Collection<Hashtag> findAllHashtags();

    void storeHashtag(Hashtag hashtag);

    Hashtag findHashtagById(Long hashtagToFind);
}
