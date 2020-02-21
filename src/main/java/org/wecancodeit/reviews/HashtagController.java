package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;

    private ReviewStorage reviewStorage;

    public HashtagController(HashtagStorage hashtagStorage, ReviewStorage reviewStorage) {
        this.hashtagStorage = hashtagStorage;
        this.reviewStorage= reviewStorage;
    }

    @RequestMapping("/hashtags")
    public String displayHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.findAllHashtags());
        return "ListOfHashtags";
    }

    @RequestMapping("/hashtags/{hashtagId}")
    public String displaySingleHashtag(@PathVariable Long hashtagId, Model model) {
        Hashtag retrievedHashtag = hashtagStorage.findHashtagById(hashtagId);
        Collection<Review> reviewList = reviewStorage.findAllReviews();
        model.addAttribute("hashtag", retrievedHashtag);
        model.addAttribute("reviews", reviewList);
        return "hashtag";
    }
}
