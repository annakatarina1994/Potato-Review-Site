package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(){
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(categoryName, category.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }
}
