package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ReviewController {

    private ReviewStorage reviewStorage;

    public ReviewController(ReviewStorage reviewStorage) {
        this.reviewStorage = reviewStorage;
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
    public String addReview(@RequestParam Category reviewCategory, String reviewName, String reviewAuthor, int reviewRating, String reviewText, Date reviewDate){
        reviewStorage.storeReview(new Review(reviewAuthor, reviewRating, reviewDate, reviewText, reviewCategory, reviewName));
        return "redirect:categories";
    }
}
