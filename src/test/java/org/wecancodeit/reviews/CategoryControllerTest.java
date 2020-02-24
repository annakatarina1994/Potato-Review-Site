package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.Controllers.CategoryController;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class CategoryControllerTest {
    private MockMvc mockMvc;
    private CategoryController underTest;
    private CategoryStorage mockStorage;
    private Model mockModel;
    private ReviewStorage mockRevStorage;

    @BeforeEach
    public void setUp() {
        mockStorage = mock(CategoryStorage.class);
        mockRevStorage = mock(ReviewStorage.class);
        underTest = new CategoryController(mockStorage, mockRevStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockModel = mock(Model.class);
    }

    @Test
    public void shouldReturnViewWithOneCampus() {
        Category testCategory = new Category("White", "Light colored");
        when(mockStorage.findCategoryByName("Brown")).thenReturn(testCategory);

        underTest.displaySingleCategory("Brown", mockModel);

        verify(mockStorage).findCategoryByName("Brown");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoryViewWhenDisplaySingleCategory() {
        String viewName = underTest.displaySingleCategory("Brown", mockModel);
        assertThat(viewName).isEqualTo("category");
    }

    @Test
    public void shouldGoToSpecificCategories() throws Exception {
        Category testCategory = new Category("White", "No color");
        when(mockStorage.findCategoryByName("Brown")).thenReturn(testCategory);

        mockMvc.perform(get("/categories/Brown"))
                .andExpect(status().isOk());
    }

    @Test
    public void listControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("Big", "Larger than usual");

        List<Category> categoryCollection = Collections.singletonList((testCategory));
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("ListOfCategories"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attribute("categories", categoryCollection));
    }
}
