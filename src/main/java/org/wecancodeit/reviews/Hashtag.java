package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hashtag{
    @Id
    @GeneratedValue
    private Long id;
    private String hashtagName;
    @ManyToMany(mappedBy = "hashtags")
    private Collection<Review> reviews;



    public Long getId() {
        return id;
    }


    public Hashtag(String hashtagName) {
        reviews = new ArrayList<>();
        this.hashtagName = hashtagName;
    }

    public String getHashtagName() {

        return hashtagName;
    }

    protected Hashtag(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(id, hashtag.id) &&
                Objects.equals(hashtagName, hashtag.hashtagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hashtagName);
    }
}

