package org.wecancodeit.reviews;

import java.util.Collection;

public interface ListStorage {
    Collection<Category> findAllCategories();

    void storeCategory(Category category);

    Category findCategoryByName(String categoryToFind);

    Collection<Hashtag> findAllHashtags();

    void storeHashtag(Hashtag hashtag);

    Hashtag findHashtagByTag(String hashtagToFind);
}
