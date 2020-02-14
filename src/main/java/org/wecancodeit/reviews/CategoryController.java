package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "categoriesView";
    }
    }
