package org.wecancodeit.reviews;

import java.util.Collection;

public interface HashtagStorage {
    Collection<Hashtag> findAllHashtags();

    void storeHashtag(Hashtag hashtag);

    Hashtag findHashtagById(Long hashtagToFind);

    Hashtag findHashtagByName(String hashtagName);
}
