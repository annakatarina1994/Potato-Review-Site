package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapListStorage implements ListStorage {
    private HashMap<String, Category> categories;
    private HashMap<String, Hashtag> hashtags;

    public MapListStorage() {
        categories = new HashMap<>();
        hashtags = new HashMap<>();
    }

    @Override
    public Collection<Category> findAllCategories() {
        return categories.values();
    }

    @Override
    public Collection<Hashtag> findAllHashtags() {
        return hashtags.values();
    }

    @Override
    public void storeHashtag(Hashtag hashtag) {
        hashtags.put(hashtag.getHashtagName(), hashtag);
    }

    @Override
    public Hashtag findHashtagByTag(String hashtagToFind) {
        return hashtags.get(hashtagToFind);
    }

    @Override
    public void storeCategory(Category category) {
        categories.put(category.getCategoryName(), category);
    }

    @Override
    public Category findCategoryByName(String categoryToFind) {
        return categories.get(categoryToFind);
    }
}
