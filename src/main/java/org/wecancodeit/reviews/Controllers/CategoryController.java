package org.wecancodeit.reviews.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Category;
import org.wecancodeit.reviews.CategoryStorage;
import org.wecancodeit.reviews.ReviewStorage;

import java.util.Collection;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;

    private ReviewStorage reviewStorage;

    public CategoryController(CategoryStorage categoryStorage,ReviewStorage reviewStorage) {
        this.categoryStorage = categoryStorage;
        this.reviewStorage= reviewStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "ListOfCategories";
    }

    @RequestMapping("/categories/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = categoryStorage.findCategoryByName(categoryName);
      //  Collection<Review> reviewList = reviewStorage.findAllReviews();
        model.addAttribute("category", retrievedCategory);
      //  model.addAttribute("reviews", reviewList);
        return "category";
    }
}
