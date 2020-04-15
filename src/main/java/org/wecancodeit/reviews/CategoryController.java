package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/submissions")
    public String displaySubmissions(Model model) {
        model.addAttribute("categories", categoryStorage.findAllCategories());
        return "Submissions";
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
