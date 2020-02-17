package org.wecancodeit.reviews;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private Long id;
    private String hashtagName;

    public Hashtag(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public String getHashtagName() {
        return hashtagName;
    }

    public Hashtag(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashtag hashtag = (Hashtag) o;
        return Objects.equals(hashtagName, hashtag.hashtagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashtagName);
    }
}

