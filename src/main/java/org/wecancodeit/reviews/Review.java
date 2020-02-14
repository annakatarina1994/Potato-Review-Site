package org.wecancodeit.reviews;

import java.util.Date;

public class Review {
    private String reviewAuthor;
    private int reviewRating;
    private Date reviewDate;
    private String reviewText;
    private String reviewHashTags;

    public Review(String reviewAuthor, int reviewRating, Date reviewDate, String reviewText, String reviewHashTags) {
        this.reviewAuthor = reviewAuthor;
        this.reviewRating = reviewRating;
        this.reviewDate = reviewDate;
        this.reviewText = reviewText;
        this.reviewHashTags = reviewHashTags;
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

    public String getReviewHashTags() {
        return reviewHashTags;
    }
}
