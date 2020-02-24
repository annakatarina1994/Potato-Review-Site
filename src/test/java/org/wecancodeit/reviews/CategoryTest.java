package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.Models.Category;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    public Category testCategory;

    @BeforeEach
    public void Setup(){
    testCategory = new Category("Soft", "Potatoes that are soft");
    }

    @Test
    public void getterShouldGetName(){
        assertEquals(testCategory.getCategoryName(), "Soft");
    }

    @Test
    public void getterShouldGetDescription(){
        assertEquals(testCategory.getCategoryDescription(), "Potatoes that are soft");
    }
}
