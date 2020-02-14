package org.wecancodeit.reviews;

import java.util.Objects;


public class Hashtag {
    private String hashtagName;

    public Hashtag(String hashtagName) {
        this.hashtagName = hashtagName;
    }

    public String getHashtagName() {
        return hashtagName;
    }

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

