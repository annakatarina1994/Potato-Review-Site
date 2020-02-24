package org.wecancodeit.reviews;

import org.wecancodeit.reviews.Models.Category;

import java.util.Collection;

public interface CategoryStorage {
    Collection<Category> findAllCategories();

    void storeCategory(Category category);

    Category findCategoryByName(String categoryToFind);

}
