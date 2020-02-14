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

    @Test
    public void shouldRetrieveSingleCategoryByName() {
        Category testCategory1 = new Category("Soft");
        Category testCategory2 = new Category("Yum");
        Category testCategory3 = new Category("Baked");
        CategoryStorage underTest = new MapCategoryStorage();
        underTest.store(testCategory1);
        underTest.store(testCategory2);
        underTest.store(testCategory3);
        Category retrievedCategory = underTest.findCategoryByName("Yum");
        Category retrievedCategory2 = underTest.findCategoryByName("Soft");
        assertThat(retrievedCategory).isEqualTo(testCategory2);
        assertThat(retrievedCategory2).isEqualTo(testCategory1);
    }
}

