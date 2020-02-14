package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapListStorageTest {

    @Test
    public void shouldStoreCategoryInMap() {
        Category testCategory = new Category("Big");
        ListStorage underTest = new MapListStorage();
        underTest.storeCategory(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }

    @Test
    public void shouldRetrieveSingleCategoryByName() {
        Category testCategory1 = new Category("Soft");
        Category testCategory2 = new Category("Yum");
        Category testCategory3 = new Category("Baked");
        ListStorage underTest = new MapListStorage();
        underTest.storeCategory(testCategory1);
        underTest.storeCategory(testCategory2);
        underTest.storeCategory(testCategory3);
        Category retrievedCategory = underTest.findCategoryByName("Yum");
        Category retrievedCategory2 = underTest.findCategoryByName("Soft");
        assertThat(retrievedCategory).isEqualTo(testCategory2);
        assertThat(retrievedCategory2).isEqualTo(testCategory1);
    }
}

