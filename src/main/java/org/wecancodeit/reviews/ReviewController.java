package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {

    private ReviewStorage reviewStorage;
    private CategoryStorage categoryStorage;

    public ReviewController(ReviewStorage reviewStorage, CategoryStorage categoryStorage) {
        this.reviewStorage = reviewStorage;
        this.categoryStorage = categoryStorage;
    }

    @RequestMapping("/reviews")
    public String displayReviews(Model model) {
        model.addAttribute("reviews", reviewStorage.findAllReviews());
        return "ListOfReviews";
    }

    @RequestMapping("/review/{reviewId}")
    public String displaySingleReview(@PathVariable Long reviewId, Model model) {
        Review retrievedReview = reviewStorage.findReviewById(reviewId);
        model.addAttribute("review", retrievedReview);
        return "review";
    }

    @PostMapping("/add-review")
    public String addReview(@RequestParam String reviewAuthor, @RequestParam Integer reviewRating, @RequestParam String reviewText, @RequestParam String categoryName, @RequestParam String reviewName){
        Category reviewCategory = categoryStorage.findCategoryByName(categoryName);
        reviewStorage.storeReview(new Review(reviewAuthor, reviewRating, reviewText, reviewCategory, reviewName));
        return "redirect:categories";
    }
}
