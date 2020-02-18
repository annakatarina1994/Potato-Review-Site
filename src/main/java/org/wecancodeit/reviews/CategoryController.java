package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage) {
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "ListOfCategories";
    }

    @RequestMapping("/categories/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = categoryStorage.findCategoryByName(categoryName);
        model.addAttribute("category", retrievedCategory);
        return "category";
    }
}
