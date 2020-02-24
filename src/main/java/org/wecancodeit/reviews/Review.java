package org.wecancodeit.reviews;

import javax.persistence.*;
import java.util.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String reviewName;
    private String reviewAuthor;
    private int reviewRating;
    private Date reviewDate;
    private String reviewText;
    @ManyToOne
    private Category reviewCategory;


    @ManyToMany
    private Collection<Hashtag> reviewHashTags = new ArrayList<>();


    public Review() {
    }

    public Review(String reviewAuthor, int reviewRating, Date reviewDate, String reviewText, Category reviewCategory, String reviewName) {
        this.reviewAuthor = reviewAuthor;
        this.reviewRating = reviewRating;
        this.reviewDate = new Date();
        this.reviewText = reviewText;
        this.reviewCategory = reviewCategory;
        this.reviewName = reviewName;
        this.reviewHashTags = getReviewHashTags();
    }

    public Collection<Hashtag> getReviewHashTags() {
        return reviewHashTags;
    }
    public String getReviewName() {
        return reviewName;
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

    public Long getId() {
        return id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewName, review.reviewName) &&
                Objects.equals(reviewCategory, review.reviewCategory) &&
                Objects.equals(reviewAuthor, review.reviewAuthor) &&
                Objects.equals(reviewDate, review.reviewDate) &&
                Objects.equals(reviewRating, review.reviewRating) &&
                Objects.equals(reviewText, review.reviewText) &&
                Objects.equals(id, review.id);


    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reviewName, reviewAuthor, reviewRating, reviewDate, reviewText, reviewCategory,reviewHashTags);
    }
}
