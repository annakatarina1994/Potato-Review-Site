package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReviewController {

    private ReviewStorage reviewStorage;
    private CategoryStorage categoryStorage;
    private HashtagRepository hashtagRepository;

    public ReviewController(ReviewStorage reviewStorage, CategoryStorage categoryStorage, HashtagRepository hashtagRepository) {
        this.reviewStorage = reviewStorage;
        this.categoryStorage = categoryStorage;
        this.hashtagRepository= hashtagRepository;
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

    @PostMapping("/review/{id}/add-hashtag")

    public String addHashtagtoReview(@RequestParam String hashTagName, @PathVariable Long id){

       Hashtag hashtagToAddToReview;
       Optional<Hashtag> hashtagOptional = hashtagRepository.findByName(hashTagName);

       if(hashtagOptional.isEmpty()){
           hashtagToAddToReview = new Hashtag(hashTagName);
           hashtagRepository.save(hashtagToAddToReview);
       }else{
           hashtagToAddToReview = hashtagOptional.get();
       }

       Review reviewToAddHashtagTo = reviewStorage.findReviewById(id);
       reviewToAddHashtagTo.addHashtag(hashtagToAddToReview);
       reviewStorage.storeReview(reviewToAddHashtagTo);
       return "redirect:/review/"+ id;

    }
}
