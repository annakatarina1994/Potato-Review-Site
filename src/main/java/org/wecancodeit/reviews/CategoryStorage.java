package org.wecancodeit.reviews;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.Models.Category;

import java.util.Collection;

@Repository
public interface CategoryStorage {
    Collection<Category> findAllCategories();

    void storeCategory(Category category);

    Category findCategoryByName(String categoryToFind);

}
