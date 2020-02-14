package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class MapCategoryStorage implements CategoryStorage {
    private HashMap<String, Category> categories;

    public MapCategoryStorage() {
        categories = new HashMap<>();
    }

    @Override
    public Collection<Category> findAllCategories() {
        return categories.values();
    }

    @Override
    public void store(Category category) {
        categories.put(category.getCategoryName(), category);
    }

    @Override
    public Category findCategoryByName(String categoryToFind) {
        return categories.get(categoryToFind);
    }
}
