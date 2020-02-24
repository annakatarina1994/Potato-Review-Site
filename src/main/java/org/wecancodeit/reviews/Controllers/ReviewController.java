package org.wecancodeit.reviews.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.Models.Review;
import org.wecancodeit.reviews.ReviewStorage;

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
}
