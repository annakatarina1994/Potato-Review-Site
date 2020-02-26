package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;
private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;

    public HashtagController(HashtagStorage hashtagStorage, ReviewStorage reviewStorage,CategoryStorage categoryStorage) {
        this.hashtagStorage = hashtagStorage;
        this.reviewStorage= reviewStorage;
        this.categoryStorage=categoryStorage;
    }

    @RequestMapping("/hashtags")
    public String displayHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "ListOfHashtags";
    }

    @RequestMapping("/hashtag/{hashtagName}")
    public String displaySingleHashtag(@PathVariable String hashtagName, Model model) {
        Hashtag retrievedHashtag = hashtagStorage.findHashtagByName(hashtagName);
//        Collection<Review> reviewList = reviewStorage.findAllReviews();
        model.addAttribute("hashtag", retrievedHashtag);
//        model.addAttribute("reviews", reviewList);
        return "hashtag";
    }
}
