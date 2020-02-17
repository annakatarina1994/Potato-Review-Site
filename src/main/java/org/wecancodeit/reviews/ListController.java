package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ListController {

    private ListStorage listStorage;

    public ListController(ListStorage listStorage) {
        this.listStorage = listStorage;
    }

    @RequestMapping("/categories")
    public String displayCategories(Model model) {
        model.addAttribute("categories", listStorage.findAllCategories());
        return "categoriesView";
    }

    @RequestMapping("/categories/{categoryName}")
    public String displaySingleCategory(@PathVariable String categoryName, Model model) {
        Category retrievedCategory = listStorage.findCategoryByName(categoryName);
        model.addAttribute("category", retrievedCategory);
        return "categoryView";
    }
}
