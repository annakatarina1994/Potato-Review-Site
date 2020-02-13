package org.wecancodeit.reviews;

import java.util.Collection;
import java.util.HashMap;

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
}
