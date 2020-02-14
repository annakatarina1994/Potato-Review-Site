package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryStorageTest {

    @Test
    public void shouldStoreCategoryInMap() {
        Category testCategory = new Category("Big");
        CategoryStorage underTest = new MapCategoryStorage();
        underTest.store(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }
}

