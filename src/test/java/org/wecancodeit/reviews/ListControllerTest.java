package org.wecancodeit.reviews;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ListControllerTest {
    private MockMvc mockMvc;
    private ListController underTest;
    private ListStorage mockStorage;
    private Model mockModel;

    @BeforeEach
    public void setUp() {
        mockStorage = mock(ListStorage.class);
        underTest = new ListController(mockStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockModel = mock(Model.class);
    }

    @Test
    public void shouldReturnViewWithOneCampus() {
        Category testCategory = new Category("White");
        when(mockStorage.findCategoryByName("Brown")).thenReturn(testCategory);

        underTest.displaySingleCategory("Brown", mockModel);

        verify(mockStorage).findCategoryByName("Brown");
        verify(mockModel).addAttribute("category", testCategory);
    }

    @Test
    public void shouldReturnViewNamedCategoryViewWhenDisplaySingleCampus() {
        String viewName = underTest.displaySingleCategory("Brown", mockModel);
        assertThat(viewName).isEqualTo("categories");
    }

    @Test
    public void shouldGoToSpecificCategories() throws Exception {
        Category testCategory = new Category("White");
        when(mockStorage.findCategoryByName("Brown")).thenReturn(testCategory);

        mockMvc.perform(get("/categories/Brown"))
                .andExpect(status().isOk());
    }

    @Test
    public void listControllerShouldInstantiate() throws Exception {
        Category testCategory = new Category("Big");

        List<Category> categoryCollection = Collections.singletonList((testCategory));
        when(mockStorage.findAllCategories()).thenReturn(categoryCollection);
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoryView"))
                .andExpect(model().attributeExists("category"))
                .andExpect(model().attribute("category", testCategory));
    }
}
