package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CategoryStorageJpaImplTest {

    @Test
    public void shouldFindAllCategories(){
        CategoryRepository mockCatRepo = mock(CategoryRepository.class);
        Category testCategory = new Category("brow","brow potatoes");
        CategoryStorage underTest = new CategoryStorageJpaImpl(mockCatRepo);
        when(mockCatRepo.findAll()).thenReturn(Collections.singletonList(testCategory));
        underTest.storeCategory(testCategory);
        verify(mockCatRepo).save(testCategory);
        assertThat(underTest.findAllCategories()).contains(testCategory);
    }
}
