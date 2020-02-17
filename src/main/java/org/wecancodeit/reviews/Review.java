package org.wecancodeit.reviews;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String reviewAuthor;
    private int reviewRating;
    private Date reviewDate;
    private String reviewText;
    @ManyToOne
    private Category reviewCategory;


//    @ManyToMany
//    private Hashtag reviewHashTags;

    public Review(){}

    public Review(String reviewAuthor, int reviewRating, Date reviewDate, String reviewText, Category reviewCategory) {
        this.reviewAuthor = reviewAuthor;
        this.reviewRating = reviewRating;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.reviewCategory = reviewCategory;
//        this.reviewHashTags = reviewHashTags;
    }


    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public int getReviewRating() {
        return reviewRating;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public String getReviewText() {
        return reviewText;
    }

    public Category getReviewCategory() {
        return reviewCategory;
    }

//    public String getReviewHashTags() {
//        return reviewHashTags;
//    }
}
